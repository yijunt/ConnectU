package com.cu.sampels;

public class Course {
	
	public Course(String courseName, String courseId, int courseUOC, boolean prerequisite, boolean semesterOne,
			boolean semesterTwo, boolean semesterThree, String link) {
		super();
		this.courseName = courseName;
		this.courseId = courseId;
		this.courseUOC = courseUOC;
		this.prerequisite = prerequisite;
		this.semesterOne = semesterOne;
		this.semesterTwo = semesterTwo;
		this.semesterThree = semesterThree;
		this.link = link;
	}
	
	public Course(String courseId, String prerequisiteCourse) {
		this.courseId = courseId;
		this.prerequisiteCourse = prerequisiteCourse;
	}
	private String courseName;
	private String courseId;
	private int courseUOC;
	private boolean prerequisite;
	private boolean semesterOne;
	private boolean semesterTwo;
	private boolean semesterThree;
	private String link;
	private String prerequisiteCourse;
	
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
	public boolean isPrerequisite() {
		return prerequisite;
	}
	public void setPrerequisite(boolean prerequisite) {
		this.prerequisite = prerequisite;
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

	public String getPrerequisiteCourse() {
		return prerequisiteCourse;
	}
	public void setPrerequisiteCourse(String prerequisiteCourse) {
		this.prerequisiteCourse = prerequisiteCourse;
	}
}
