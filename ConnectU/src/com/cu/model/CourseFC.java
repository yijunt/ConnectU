package com.cu.model;


public class CourseFC {
	
	public CourseFC(String courseId, String courseName, String mainPrerequisiteCourse, String secPrerequisiteCourse,
			String link, boolean courseTaken, boolean twoPrerequisite, boolean[] semester) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.mainPrerequisiteCourse = mainPrerequisiteCourse;
		this.secPrerequisiteCourse = secPrerequisiteCourse;
		this.link = link;
		this.courseTaken = courseTaken;
		this.twoPrerequisite = twoPrerequisite;
		this.semester = semester;
	}
	
	private String courseId, courseName, mainPrerequisiteCourse, secPrerequisiteCourse, link;
	private boolean courseTaken, twoPrerequisite;
	private boolean[] semester;
}
