package com.cu.sampels;

public class Degree {

	private String degree_id;
	private String degree_name;
	private int total_uoc;
	private int faculty;
	private boolean free_elective;
	private boolean gened_course;
	
	public Degree(String degree_id, String degree_name, int total_uoc, int faculty, boolean free_elective,
			boolean gened_course) {
		super();
		this.degree_id = degree_id;
		this.degree_name = degree_name;
		this.total_uoc = total_uoc;
		this.faculty = faculty;
		this.free_elective = free_elective;
		this.gened_course = gened_course;
	}

	public String getDegree_id() {
		return degree_id;
	}

	public void setDegree_id(String degree_id) {
		this.degree_id = degree_id;
	}

	public String getDegree_name() {
		return degree_name;
	}

	public void setDegree_name(String degree_name) {
		this.degree_name = degree_name;
	}

	public int getTotal_uoc() {
		return total_uoc;
	}

	public void setTotal_uoc(int total_uoc) {
		this.total_uoc = total_uoc;
	}

	public int getFaculty() {
		return faculty;
	}

	public void setFaculty(int faculty) {
		this.faculty = faculty;
	}

	public boolean isFree_elective() {
		return free_elective;
	}

	public void setFree_elective(boolean free_elective) {
		this.free_elective = free_elective;
	}

	public boolean isGened_course() {
		return gened_course;
	}

	public void setGened_course(boolean gened_course) {
		this.gened_course = gened_course;
	}
	
	
}
