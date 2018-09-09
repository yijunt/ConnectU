package com.cu.model;

public class Degree {
	public Degree() {};
	
	public Degree(String degreeId, String degreeName, String totalUOC, String faculty, boolean freeElective,
			boolean genedCourse) {
		super();
		this.degreeId = degreeId;
		this.degreeName = degreeName;
		this.totalUOC = totalUOC;
		this.faculty = faculty;
		this.freeElective = freeElective;
		this.genedCourse = genedCourse;
	}

	private String degreeId;
	private String degreeName;
	private String totalUOC;
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
	public String getTotalUOC() {
		return totalUOC;
	}
	public void setTotalUOC(String totalUOC) {
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
