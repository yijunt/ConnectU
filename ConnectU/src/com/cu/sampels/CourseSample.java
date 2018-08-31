package com.cu.sampels;import java.util.ArrayList;

public class CourseSample {
    public CourseSample(){}
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
    Course INFS1602 = new Course("INFS1602", null);
    Course INFS1603 = new Course("INFS1603", null);
    Course INFS2631 = new Course("INFS2631", "INFS1603");
    Course INFS3873 = new Course("INFS3873", "INFS2631");
    Course INFS2621 = new Course("INFS2621", "INFS1602");
    Course INFS3607 = new Course("INFS3607", "INFS2621");

    public ArrayList<String[]> getCourseList () {
        ArrayList<String[]> courseList = new ArrayList<>();
        String[] INFS1602 = {"INFS1602",null};
        String[] INFS1603 = {"INFS1603", null};
        String[] INFS2631 = {"INFS2631", "INFS1602"};
        String[] INFS3873 = {"INFS3873", "INFS2631"};
        String[] INFS2621 = {"INFS2621", "INFS1602"};
        String[] INFS3607 = {"INFS3607", "INFS2631"};

        courseList.add(INFS1602);
        courseList.add(INFS1603);
        courseList.add(INFS2631);
        courseList.add(INFS3873);
        courseList.add(INFS2621);
        courseList.add(INFS3607);
        return courseList;

    }
}
