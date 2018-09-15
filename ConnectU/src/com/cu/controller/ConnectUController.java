package com.cu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import com.cu.database.CUDatabase;
import com.cu.model.Course;
import com.cu.model.CourseDegree;
import com.cu.model.CourseFC;
import com.cu.model.CourseStudent;
import com.cu.model.Degree;
import com.cu.model.Student;
import com.google.gson.Gson;

public class ConnectUController {
	CUDatabase cudb = new CUDatabase();
	
	//convert courses to json for flowchart
	public String getCoursesObject(String studentId) {
		ArrayList<Course> courseList = courseFlowChartList(studentId);
		ArrayList<Course> courseTakenList = courseTakenList(studentId);
		ArrayList<CourseFC> courseObject = new ArrayList<>();

		Gson courseGson = new Gson();
		for(Course course : courseList) {
			Gson gson = new Gson();
			String courseId = course.getCourseId();
			String courseName = course.getCourseName();
			boolean courseTaken = false;
			String mainPrerequisiteCourse = null;
			String secPrerequisiteCourse = null;
			boolean twoPrerequisite = false;
			boolean semester[] = {false, false, false};
			String link = course.getLink();
			if(courseTakenList.contains(course)) {
				courseTaken = true;
			}
			if(course.getPrerequisiteCourseId() != null) {
				mainPrerequisiteCourse = course.getPrerequisiteCourseId();
				if(course.getPrerequisiteCourses() != null) {
					String[] twoPrerequisites = course.getPrerequisiteCourses();
					secPrerequisiteCourse = twoPrerequisites[1]; //getSecondCourse
					twoPrerequisite = true;
				}
			}
			if(course.isSemesterOne()) {
				semester[0] = true; //sem 1
			}
			if(course.isSemesterTwo()) {
				semester[1] = true; //sem 2
			}
			if(course.isSemesterThree()) {
				semester[2] = true; //sem 3
			}
			
			CourseFC courseFC = new CourseFC
					(courseId, courseName, mainPrerequisiteCourse, 
					secPrerequisiteCourse, link, courseTaken, twoPrerequisite, semester);
			String json = gson.toJson(courseFC);
			courseObject.add(courseFC);
		}
		
		return courseGson.toJson(courseObject); //the symbol & will be replace into '/u0026', either replace string here or in mysql
		
	}

	public String getExtraCoursesObject (String studentId) {
		ArrayList<Course> courseList = extraCourseList(studentId);
		
		Gson gson = new Gson();
		return gson.toJson(courseList);
	}
	
	public String getMajorList (String studentId) {
	
		return null;
	}
	
	//get studentInfo
	public Student studentInfo(String studentId) {
		Student student = cudb.getStudentInfo(studentId);
		return student;
	}

	//get degreeInfo
	public Degree degreeInfo(String studentId) {
		String degreeId = studentInfo(studentId).getDegreeId();
		Degree degree = cudb.getDegreeInfo(degreeId);
		return degree;
	}
	
	//return a hashtable of courses need to complete
	public  Hashtable<CourseDegree, Course> courseInfo(String studentId) {
		String degreeId = studentInfo(studentId).getDegreeId();
		Hashtable<CourseDegree, Course> courseDegreeMap = cudb.getCourseDegreeList(degreeId);
		
		return courseDegreeMap;
	}
	
	//return a list of all courses need to take (including major)
	public ArrayList<Course> courseList(String studentId) {
		ArrayList<Course> courseList = new ArrayList<>();

		for (Map.Entry<CourseDegree, Course> value : courseInfo(studentId).entrySet()) {
			Course course = value.getValue();
			courseList.add(course);
		}
		
		return courseList;
	}
	
	//return courseDegreeArrayList for the flowchart (not include major)
	public ArrayList<Course> courseFlowChartList(String studentId) {
		ArrayList<Course> courseList = new ArrayList<>();
		
		//if its not under major category, then has to display in flowchart
		for (Map.Entry<CourseDegree, Course> value : courseInfo(studentId).entrySet()) {
			if(value.getKey().getMajor() == null) {
				Course course = value.getValue();
				courseList.add(course);
			}
		}
		
		return courseList;
	}
	
	//return a hashmap of major courses if available
	/*RETURN OBJECT MIGHT BE EMPTY!! MUST PERFORM CHECKING*/
	public HashMap<String, ArrayList<String>> majorMap(String studentId) {
		HashMap<String, ArrayList<String>> majorMap = new HashMap<>();
		try {
			
			for (Map.Entry<CourseDegree, Course> value : courseInfo(studentId).entrySet()) {
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
		} catch (NullPointerException e) {
			System.out.println("No major in this degree: " + e);
		}
		return majorMap;
	}
	
	//return courseTakenArrayList from courseStudent (include free elec, gened and major)
	public ArrayList<Course> courseTakenList(String studentId) {
		ArrayList<Course> courseTakenList = new ArrayList<>();
		ArrayList<CourseStudent> courseStudentList = cudb.getCourseStudentList(studentId);
		
		for(CourseStudent courseStudent: courseStudentList) {
			Course course = cudb.getCourseInfo(courseStudent.getCourseId());
			courseTakenList.add(course);
		}
		return courseTakenList;
	}

	//return a list of free elec and gened course if available (differentiate using courseStudent and courseDegree)
	public ArrayList<Course> extraCourseList(String studentId) {
		ArrayList<Course> extraCourseList = new ArrayList<>();
		ArrayList<Course> courseDegreeList = courseList(studentId);
		ArrayList<Course> courseStudentList = courseTakenList(studentId);
		
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
	public int totalUOC(String studentId) {
		Degree degree = degreeInfo(studentId);
		return Integer.parseInt(degree.getTotalUOC());
	}
	
	//return course term (dont think we need this)	
}
