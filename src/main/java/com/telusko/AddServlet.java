package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class AddServlet  extends HttpServlet{
	
public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {	
	int i = Integer.parseInt(req.getParameter("num1"));
	int j = Integer.parseInt(req.getParameter("num2"));
	
	int k = i+j;
	
	// to call another servlet from one servlet you can either use SERVLET DISPACTER OR REDIRECT
	
	// to preserve  data from one servlet to another we can SESSION MANAGEMENT  or cookies too
	
	
	 //req.setAttribute("k", k );              	  1.Sending data to another servlet using Request Dispatcher	
	 //RequestDispatcher rd = req.getRequestDispatcher("sq");
	 //rd.forward(req, res);
	
	
	 //res.sendRedirect("sq?k="+k);  		 	 //2. Sending data or request to another servlet using SendRedirect URL Redirecting	
	 
	 //HttpSession session = req.getSession();     3. Sending Data through HttpSession. Session is preserved throughout multiple servlets
	 //session.setAttribute("k", k);
	 //res.sendRedirect("sq");
	
	
	 //Cookie cookie = new Cookie("k",k+"");		 //4. Sending Data through Cookies 
	 //res.addCookie(cookie);
	 //res.sendRedirect("sq");
	
	 student s1 = new student(23,"kalicharan"); 
	 student s2 = new student(16,"gustavo"); 
	 student s3 = new student(11,"loccopilot"); 
    
	 List<student> stud = new ArrayList<student>();
	 stud.add(s1);
	 stud.add(s2);
	 stud.add(s3);
	 
	 req.setAttribute("students", stud);
	 
	 RequestDispatcher rd = req.getRequestDispatcher("add.jsp");
	 rd.forward(req, res);
} 
}