package com.cu.controller;
import java.util.ArrayList;
import java.util.Arrays;

import com.cu.sampels.CourseSample;

public class ProgressionPlanController {
    //https://www.javagists.com/java-tree-data-structure
    public static boolean addedNodeFlag = false;
    public static void main(String[] args) {
//        Node<String> root = createCourseTree();
//        System.out.print("print root");
//        printTree(root, " ");
    	System.out.println(getRemainingCourseList());
    }
    private static CourseSample courseSample = new CourseSample();

    private static Node<String> createCourseTree(){
        ArrayList<String[]> courseList = courseSample.getCourseList();
        ArrayList<String> addedNode = new ArrayList<>();

        Node<String> root = new Node<>("INFS");
        addedNode.add(root.getData());

        do {
            int j = 0;
            while(courseList.size() > j) {
                String[] course = courseList.get(j);
                System.out.println(Arrays.toString(courseList.get(j)));
                if(course[1] == null) {
                    //no prerequisite
                    createChildNote(course[0], root);
                    addedNode.add(course[0]);
                    courseList.remove(j);
                    j--; //deduct index if remove
                } else {
                    if(addedNode.contains(course[1])) {
                        System.out.println("hereee");
                        System.out.println(course[1]);
                        //prerequisite course is already added in the node
                        searchNode(course[0], course[1], root);
                        if(addedNodeFlag) {
                            addedNode.add(course[0]);
                            courseList.remove(j);
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
                j++;
            }

        } while(!courseList.isEmpty());

        return root;
    }

    private static <T> void printTree(Node<T> node, String appender) {
        System.out.println(appender + node.getData());
        node.getChildren().forEach(each ->  printTree(each, appender + appender));
    }
    private static <T> void searchNode(String course, String prerequisiteCourse, Node<String> node) {
        System.out.println("Course needed is = " + prerequisiteCourse);
        if(node.getData() == prerequisiteCourse) {
            System.out.println("the course exists!");
            System.out.println(node.getData());
            createChildNote(course, node);
            
            addedNodeFlag = true;
            return;
        } else {
            node.getChildren().forEach(each -> searchNode(course, prerequisiteCourse, each));
        }
    }

    private static Node<String> createChildNote(String child, Node<String> parentNode){
        return parentNode.addChild(new Node<>(child));
    }
    
    private static int getRemainingCourseList() {
    	int count = 0;
        ArrayList<String[]> totalCourseList = courseSample.getCourseList();
        ArrayList<String> completedCourseList = courseSample.getCourseCompleted();
        
        for (String[] totalCourse: totalCourseList) {
        	for(String completedCourse: completedCourseList) {
        		if(totalCourse[1].equals(completedCourse)) {
        			count++;
        		}
        	}
        }
    	
    	return count;
    }
}
