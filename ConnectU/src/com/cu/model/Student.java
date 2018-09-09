package com.cu.model;

public class Student {
	public Student() {};
	
	public Student(String studentId, String firstname, String lastName, String degreeId) {
		super();
		this.studentId = studentId;
		this.firstname = firstname;
		this.lastName = lastName;
		this.degreeId = degreeId;
	}

	private String studentId;
	private String firstname;
	private String lastName;
	private String degreeId;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDegreeId() {
		return degreeId;
	}
	public void setDegreeId(String degreeId) {
		this.degreeId = degreeId;
	}
	
	
}
