package com.cu.sampels;

public class CourseSample {
	String courseName = "Project Two";
	String courseId = "INFS3605";
	int courseUOC = 6;
	boolean prerequisite = true;
	boolean semesterOne = false;
	boolean semesterTwo = true;
	boolean semesterThree = false;
	String link = null;
	Course projectTwo = new Course(courseName, courseId, courseUOC, prerequisite, semesterOne, semesterTwo, semesterThree, link);
	Course projectOne = new Course("Project One", "INFS3611", 6, true, true, false, false, link);

}
