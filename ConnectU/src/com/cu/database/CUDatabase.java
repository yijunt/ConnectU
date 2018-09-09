package com.cu.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import com.cu.model.Course;
import com.cu.model.CourseDegree;
import com.cu.model.CourseStudent;
import com.cu.model.Degree;
import com.cu.model.Student;


public class CUDatabase {
	SQLStatements sqlstatements = new SQLStatements();
	PreparedStatement stmt;
	ResultSet rs;
	DBConnection db = new DBConnection();
	Connection conn;

	public boolean verifyLogin(String userName, String password) {
		boolean verification = false;
		String pwd = null;

		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement(SQLStatements.GET_STUDENT_INFO);
			stmt.setString(1, userName);
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				pwd = rs.getString(5);
			}
			if (password.equals(pwd)) {
				verification = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verification;
	}

	public Student getStudentInfo(String userName) {
		Student student = new Student();
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement(SQLStatements.GET_STUDENT_INFO);
			stmt.setString(1, userName);
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				student.setDegreeId(rs.getString(4));
				student.setFirstname(rs.getString(2));
				student.setLastName(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close(stmt, conn);
		}

		return student;
	}

	public Degree getDegreeInfo(String degreeId) {
		Degree degree = new Degree();
		System.out.println(degreeId);
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement(SQLStatements.GET_DEGREE_INFO);
			stmt.setString(1, degreeId);
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				degree.setDegreeId(rs.getString(1));
				degree.setDegreeName(rs.getString(2));
				degree.setTotalUOC(rs.getString(3));
				degree.setFaculty(rs.getString(4));
				degree.setFreeElective(rs.getBoolean(5));
				degree.setGenedCourse(rs.getBoolean(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close(stmt, conn);
		}
		return degree;
	}

	public Hashtable<CourseDegree, Course> getCourseDegreeList(String degreeId) {
		ArrayList<CourseDegree> courseDegreeList = new ArrayList<>();
		Hashtable<CourseDegree, Course> courseDegreeDetailsMap = new Hashtable<>();

		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement(SQLStatements.GET_COURSEDEGREE_INFO);
			stmt.setString(1, degreeId);
			rs = stmt.executeQuery();
			while(rs != null && rs.next()) {
				CourseDegree courseDegree = new CourseDegree();
				courseDegree.setCourseDegreeId(rs.getInt(1));
				courseDegree.setCourseId(rs.getString(2));
				courseDegree.setDegreeId(rs.getString(3));
				courseDegree.setCoreCourseFlag(rs.getBoolean(4));
				courseDegree.setMajor(rs.getString(5));
				
				courseDegreeList.add(courseDegree);
				
				Course course = getCourseInfo(rs.getString(2));
//				Course course = new Course();
				courseDegreeDetailsMap.put(courseDegree, course);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close(stmt, conn);
		}
		return courseDegreeDetailsMap;
	}
	
	public Course getCourseInfo (String courseId) {
		Course course = new Course();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQLStatements.GET_COURSE_INFO);
			pstmt.setString(1, courseId);
			ResultSet res = pstmt.executeQuery();
			if(res != null && res.next()) {
				course.setCourseId(res.getString(1));
				course.setPrerequisiteCourseId(res.getString(2));
				course.setCourseName(res.getString(3));
				course.setSemesterOne(res.getBoolean(4));
				course.setSemesterTwo(res.getBoolean(5));
				course.setSemesterThree(res.getBoolean(6));
				course.setCourseUOC(res.getInt(7));
				course.setLink(res.getString(8));
				String prerequisiteCourses = res.getString(9);
				if (prerequisiteCourses != null) {
					course.setPrerequisiteCourses(prerequisiteCourses.split(","));
				} else {
					course.setPrerequisiteCourses(null);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close(pstmt, con);
		}
		
		return course;
	}
	
	public ArrayList<CourseStudent> getCourseStudentList (String studentId) {
		ArrayList<CourseStudent> courseStudentList = new ArrayList<>();
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement(SQLStatements.GET_COURSESTUDENT_INFO);
			stmt.setString(1, studentId);
			rs = stmt.executeQuery();
			while(rs!= null && rs.next()) {
				CourseStudent courseStudent = new CourseStudent();
				courseStudent.setCourseId(rs.getString(2));
				courseStudent.setStudentId(rs.getString(3));
				
				courseStudentList.add(courseStudent);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close(stmt, conn);
		}
		
		return courseStudentList;
		
	}

}
