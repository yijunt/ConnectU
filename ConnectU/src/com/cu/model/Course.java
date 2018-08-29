package com.cu.model;

public class Course {
	private String courseName;
	private String courseId;
	private int courseUOC;
	private boolean prerequisite;
	private boolean semesterOne;
	private boolean semesterTwo;
	private boolean semesterThree;
	private String link;
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
}
