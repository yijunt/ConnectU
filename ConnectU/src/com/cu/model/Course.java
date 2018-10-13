package com.cu.model;

import java.util.Arrays;

public class Course {
	public Course() {};
	
	public Course(String courseName, String courseId, int courseUOC, String prerequisiteCourseId, boolean semesterOne,
			boolean semesterTwo, boolean semesterThree, String link, String[] prerequisiteCourses) {
		super();
		this.courseName = courseName;
		this.courseId = courseId;
		this.courseUOC = courseUOC;
		this.prerequisiteCourseId = prerequisiteCourseId;
		this.semesterOne = semesterOne;
		this.semesterTwo = semesterTwo;
		this.semesterThree = semesterThree;
		this.link = link;
		this.prerequisiteCourses = prerequisiteCourses;
	}


	private String courseName;
	private String courseId;
	private int courseUOC;
	private String prerequisiteCourseId;
	private boolean semesterOne;
	private boolean semesterTwo;
	private boolean semesterThree;
	private String link;
	private String[] prerequisiteCourses;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public int getCourseUOC() {
		return courseUOC;
	}
	public void setCourseUOC(int courseUOC) {
		this.courseUOC = courseUOC;
	}
	public String getPrerequisiteCourseId() {
		return prerequisiteCourseId;
	}
	public void setPrerequisiteCourseId(String prerequisiteCourseId) {
		this.prerequisiteCourseId = prerequisiteCourseId;
	}
	public boolean isSemesterOne() {
		return semesterOne;
	}
	public void setSemesterOne(boolean semesterOne) {
		this.semesterOne = semesterOne;
	}
	public boolean isSemesterTwo() {
		return semesterTwo;
	}
	public void setSemesterTwo(boolean semesterTwo) {
		this.semesterTwo = semesterTwo;
	}
	public boolean isSemesterThree() {
		return semesterThree;
	}
	public void setSemesterThree(boolean semesterThree) {
		this.semesterThree = semesterThree;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String[] getPrerequisiteCourses() {
		return prerequisiteCourses;
	}
	public void setPrerequisiteCourses(String[] prerequisiteCourses) {
		this.prerequisiteCourses = prerequisiteCourses;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseId=" + courseId + ", courseUOC=" + courseUOC
				+ ", prerequisiteCourseId=" + prerequisiteCourseId + ", semesterOne=" + semesterOne + ", semesterTwo="
				+ semesterTwo + ", semesterThree=" + semesterThree + ", link=" + link + ", prerequisiteCourses="
				+ Arrays.toString(prerequisiteCourses) + "]";
	}
	
	
	
	
}
