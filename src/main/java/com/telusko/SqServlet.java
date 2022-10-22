package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sq")
public class SqServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		 // int k = (int)req.getAttribute("k");                 //1.getting data from req using request dispatcher
		 // k = k*k;
	     //PrintWriter out = res.getWriter();
		 //out.println("result is : +"+k);
		
		//int k = Integer.parseInt(req.getParameter("k"));      //2.Getting data from another servlet [URL REDIRECTING]i.e from the req object [which other servlet sent]
		//k = k*k;
		//PrintWriter out = res.getWriter();
		//out.println("result is : +"+k);
		
		//HttpSession session = req.getSession();				 //3. Getting data from another servlet using HttpSession 
		//int k = (int)session.getAttribute("k");
		//k = k*k;
		//PrintWriter out = res.getWriter();
		//out.println("result is : +"+k);
		
		
		 int k=0;												 //4. Getting data from another servlet using Cookies
		 Cookie cookies[] = req.getCookies();
		 for(Cookie c : cookies) {
			 if(c.getName().equals("k"))
				 k = Integer.parseInt(c.getValue());
		 }
		 k = k*k;
		 PrintWriter out = res.getWriter();
		 out.println("result is : +"+k);
		 
		 
		System.out.println("sq servlet called");
	}

}
