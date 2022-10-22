package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Idfilter
 */
@WebFilter("/add")
public class Idfilter extends HttpFilter implements Filter {
   
	 /* @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("Idfilter called");
		
		PrintWriter out  = response.getWriter();
		
		HttpServletRequest req = (HttpServletRequest)request;
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		if(num1>=0 && num2>=0)
			// pass the request along the filter chain
			chain.doFilter(request, response);
		
		else
			 out.println("Invalid Input, Only positive valus allowed in this realm");
			
	 }		
	

	
}
