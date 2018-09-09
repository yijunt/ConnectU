package com.cu.model;

public class CourseStudent {
	public CourseStudent() {};
	
	public CourseStudent(String courseId, String studentId) {
		super();
		this.courseId = courseId;
		this.studentId = studentId;
	}
	private String courseId;
	private String studentId;
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
}
