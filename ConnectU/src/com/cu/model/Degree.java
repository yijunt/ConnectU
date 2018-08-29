package com.cu.model;

public class Degree {
	private String degreeId;
	private String degreeName;
	private int totalUOC;
	private String faculty;
	private boolean freeElective;
	private boolean genedCourse;
	public String getDegreeId() {
		return degreeId;
	}
	public void setDegreeId(String degreeId) {
		this.degreeId = degreeId;
	}
	public String getDegreeName() {
		return degreeName;
	}
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}
	public int getTotalUOC() {
		return totalUOC;
	}
	public void setTotalUOC(int totalUOC) {
		this.totalUOC = totalUOC;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public boolean isFreeElective() {
		return freeElective;
	}
	public void setFreeElective(boolean freeElective) {
		this.freeElective = freeElective;
	}
	public boolean isGenedCourse() {
		return genedCourse;
	}
	public void setGenedCourse(boolean genedCourse) {
		this.genedCourse = genedCourse;
	}
}
