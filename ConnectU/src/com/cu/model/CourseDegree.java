package com.cu.model;

public class CourseDegree {
	public CourseDegree() {};
	
	public CourseDegree(int courseDegreeId, String courseId, String degreeId, boolean coreCourseFlag, String major) {
		super();
		this.courseDegreeId = courseDegreeId;
		this.courseId = courseId;
		this.degreeId = degreeId;
		this.coreCourseFlag = coreCourseFlag;
		this.major = major;
	}
	private int courseDegreeId;
	private String courseId;
	private String degreeId;
	private boolean coreCourseFlag;
	private String major;
	public int getCourseDegreeId() {
		return courseDegreeId;
	}
	public void setCourseDegreeId(int courseDegreeId) {
		this.courseDegreeId = courseDegreeId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getDegreeId() {
		return degreeId;
	}
	public void setDegreeId(String degreeId) {
		this.degreeId = degreeId;
	}
	public boolean isCoreCourseFlag() {
		return coreCourseFlag;
	}
	public void setCoreCourseFlag(boolean coreCourseFlag) {
		this.coreCourseFlag = coreCourseFlag;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	
}
