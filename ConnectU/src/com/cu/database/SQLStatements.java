package com.cu.database;

public class SQLStatements {	public static String GET_STUDENT_INFO = "SELECT * FROM student WHERE student_id = ? ;";
public static String GET_COURSE_INFO = "SELECT * FROM course where course_id = ? ;";
public static String GET_DEGREE_INFO = "SELECT * FROM degree where degree_id = ? ;";
public static String GET_COURSEDEGREE_INFO = "SELECT * FROM coursedegree where degree_id = ? ;";
public static String GET_COURSESTUDENT_INFO = "SELECT * FROM coursestudent where student_id = ? ;";
}
