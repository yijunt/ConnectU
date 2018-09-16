package com.cu.model;


public class CourseFC {
	
	public CourseFC(String key, String courseName, String parent, String secPrerequisiteCourse,
			String link, boolean completed, boolean twoPrerequisite, boolean[] semester) {
		super();
		this.key = key;
		this.courseName = courseName;
		this.parent = parent;
		this.secPrerequisiteCourse = secPrerequisiteCourse;
		this.link = link;
		this.completed = completed;
		this.twoPrerequisite = twoPrerequisite;
		this.semester = semester;
	}
	
	private String key, courseName, parent, secPrerequisiteCourse, link;
	private boolean completed, twoPrerequisite;
	private boolean[] semester;
}
