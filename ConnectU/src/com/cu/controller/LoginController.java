package com.cu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cu.database.CUDatabase;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CUDatabase cudb = new CUDatabase();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		System.out.println("the name is " + userName);
		
		boolean result = verifyLogin(userName, password);

		if(result) {
			request.getSession().setAttribute("userName", userName);
//			response.sendRedirect("html/homepage.html");
			response.sendRedirect("HomePageController");
		} else {
			PrintWriter out = response.getWriter();
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('User or password incorrect');");
			   out.println("location='index.html';");
			   out.println("</script>");
			
		}
		
		
	}
	

	public boolean verifyLogin(String userName, String pwd) {
		boolean verify;
		verify = cudb.verifyLogin(userName, pwd);
		if(verify) {
			System.out.println("Login success");
			return true;
		} else {
			System.out.println("Wrong credentials");
			return false;
		}
	}

}
