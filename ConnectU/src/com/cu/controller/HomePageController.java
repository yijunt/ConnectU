package com.cu.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class homePageServlet
 */
//@WebServlet("/homePageServlet")
public class HomePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected String studentId = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		studentId = request.getSession().getAttribute("userName").toString();
		ConnectUController cu = new ConnectUController();
//		System.out.println(cu.getExtraCoursesObject(studentId));
//		System.out.println(cu.getCoursesObject(studentId));
		HashMap<String, ArrayList<String>> majorMap = new HashMap<>();
		majorMap =  cu.majorMap(studentId);

		request.getSession().setAttribute("flowchartObject", cu.getCoursesObject(studentId));

		request.getSession().setAttribute("userName", studentId);
		if(majorMap.isEmpty()) {
			request.getSession().setAttribute("majorBool", null);
		} 
		if(studentId.equals("1234"))
			response.sendRedirect("html/homepage.jsp");
		else 
			response.sendRedirect("html/homepage2.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
