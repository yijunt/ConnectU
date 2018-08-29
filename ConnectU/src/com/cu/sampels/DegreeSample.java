package com.cu.sampels;

public class DegreeSample {

	private String degree_id = "INFS12341";
	private String degree_name = "Bachelor of Information System";
	private int total_uoc = 104;
	private int faculty = 1; //1 being degree
	private boolean free_elective = true;
	private boolean gened_course = true;
	
	Degree degree = new Degree(degree_id, degree_name, total_uoc, faculty, free_elective, gened_course);
	
	
}
