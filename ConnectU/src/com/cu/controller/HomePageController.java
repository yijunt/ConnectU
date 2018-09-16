package com.cu.controller;


import java.io.IOException;

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
		System.out.println(cu.getExtraCoursesObject(studentId));
		System.out.println(cu.getCoursesObject(studentId));

		request.getSession().setAttribute("name", cu.getExtraCoursesObject(studentId));

		request.getSession().setAttribute("userName", studentId);
		response.sendRedirect("html/homepage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
