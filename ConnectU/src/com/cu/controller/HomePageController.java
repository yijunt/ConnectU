package com.cu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cu.database.CUDatabase;
import com.cu.model.Course;
import com.cu.model.CourseDegree;
import com.cu.model.CourseStudent;
import com.cu.model.Degree;
import com.cu.model.Student;

/**
 * Servlet implementation class homePageServlet
 */
//@WebServlet("/homePageServlet")
public class HomePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected String studentId = null;
	CUDatabase cudb = new CUDatabase();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		studentId = request.getSession().getAttribute("userName").toString();

		for (Map.Entry<CourseDegree, Course> value : courseInfo().entrySet()) {
			CourseDegree courseDegree = value.getKey();
			Course course = value.getValue();
			
			System.out.println("Key: " + courseDegree.getCourseDegreeId() + " Value: " + course.getCourseName());
		}
		
	}
	//get studentInfo
	public Student studentInfo() {
		Student student = cudb.getStudentInfo(studentId);
		return student;
	}

	//get degreeInfo
	public Degree degreeInfo() {
		String degreeId = studentInfo().getDegreeId();
		Degree degree = cudb.getDegreeInfo(degreeId);
		return degree;
	}
	
	//return a hashtable of courses need to complete
	public  Hashtable<CourseDegree, Course> courseInfo() {
		String degreeId = studentInfo().getDegreeId();
		Hashtable<CourseDegree, Course> courseDegreeMap = cudb.getCourseDegreeList(degreeId);
		
		return courseDegreeMap;
	}
	
	//return a list of all courses need to take (including major)
	public ArrayList<Course> courseList() {
		ArrayList<Course> courseList = new ArrayList<>();

		for (Map.Entry<CourseDegree, Course> value : courseInfo().entrySet()) {
			Course course = value.getValue();
			courseList.add(course);
		}
		
		return courseList;
	}
	
	//return courseDegreeArrayList for the flowchart (not include major)
	public ArrayList<Course> courseFlowChartList() {
		ArrayList<Course> courseList = new ArrayList<>();
		
		//if its not under major category, then has to display in flowchart
		for (Map.Entry<CourseDegree, Course> value : courseInfo().entrySet()) {
			if(value.getKey().getMajor() == null) {
				Course course = value.getValue();
				courseList.add(course);
			}
		}
		
		return courseList;
	}
	
	//return a hashmap of major courses if available
	public HashMap<String, ArrayList<String>> majorMap() {
		HashMap<String, ArrayList<String>> majorMap = new HashMap<>();

		for (Map.Entry<CourseDegree, Course> value : courseInfo().entrySet()) {
			CourseDegree courseDegree = value.getKey();
			if(courseDegree.getMajor() != null) {
				ArrayList<String> majorCourse;
				if(majorMap.containsKey(courseDegree.getMajor())) {
					majorCourse = majorMap.get(courseDegree.getMajor());
				} else {
					majorCourse = new ArrayList<>();
				}
				majorCourse.add(courseDegree.getCourseId());
				majorMap.put(courseDegree.getMajor(), majorCourse);
			}
		}
		return majorMap;
	}
	
	//return courseTakenArrayList from courseStudent (include free elec, gened and major)
	public ArrayList<Course> courseTakenList() {
		ArrayList<Course> courseTakenList = new ArrayList<>();
		ArrayList<CourseStudent> courseStudentList = cudb.getCourseStudentList(studentId);
		
		for(CourseStudent courseStudent: courseStudentList) {
			Course course = cudb.getCourseInfo(courseStudent.getCourseId());
			courseTakenList.add(course);
		}
		return courseTakenList;
	}

	//return a list of free elec and gened course if available (differentiate using courseStudent and courseDegree)
	public ArrayList<Course> extraCourseList() {
		ArrayList<Course> extraCourseList = new ArrayList<>();
		ArrayList<Course> courseDegreeList = courseList();
		ArrayList<Course> courseStudentList = courseTakenList();
		
		for(Course courseStudent: courseStudentList) {
			if (!courseDegreeList.contains(courseStudent)) {
				extraCourseList.add(courseStudent);
			}
		}
		if(extraCourseList.isEmpty()) {
			return null;
		} 
		return extraCourseList;
	}

	//return a total uoc of the degree
	public int totalUOC() {
		Degree degree = degreeInfo();
		return Integer.parseInt(degree.getTotalUOC());
	}
	
	//return course term (dont think we need this)	
}
