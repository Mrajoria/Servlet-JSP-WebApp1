<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add JSP Page</title>
</head>
<body bgcolor="green">


	<!--  Directive tag we can use it for importing package-->
	<%@ page import="java.util.Date,java.text.DateFormat,java.text.SimpleDateFormat,java.util.Date,java.util.Calendar,java.sql. *"%>              
	<%@ taglib  uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
	<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	
		
							
	<!--..Declaration tag we can for declaring instance variables and method for servlet class-->
	<%!														  
	 int coef =3;
	 String strDate;
	 String endswith = "Trainer";		
	%>																	
								
				
	<%															//Sciptlet tag; Code inside this goes to the service() method of servlet class

	
	  Date date = Calendar.getInstance().getTime();  
      DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
      strDate = dateFormat.format(date);  
      
      //out.println("Attempting to divide by zero...");
      //int l = 5/0;
      
      //String url = "jdbc:mysql://localhost:3306/studentDB";          USING SQL without jstl sql tag; We use percent tag 
      //String username ="root";
      
      //String password = "admin";
      //String sql = "select * from student where rollno=23";
      //Class.forName("com.mysql.jdbc.Driver");
      //Connection con = DriverManager.getConnection(url,username,password);
      
      //Statement st = con.createStatement();
      //ResultSet rs = st.executeQuery(sql);
      //rs.next();
      
     
	%> 
	<br>
	
	 <br>
	 My Fav Number is: <%= coef %>			 <!--..Expression tag; Anything after = goes to html page [its equivalent to out.println() of servlet-->
	 <br>
	 
	 Current date is  <%= strDate %>
	 <br>
	  
	  <br>
	  <h4>Showing list of all students from student ArrayList</h4>
	  <c:forEach items="${students}" var="s" >
	   
	   ${s.name} <br>
	  
	  </c:forEach>
	  
	  <br>
	  
	  <h2> 1. Fetching Data using JSTL SQL tags [we need @taglib to use this]</h3>            
	  
	  <sql:setDataSource var="db"  driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/studentDB" user="root" password="admin" /> 
	  <sql:query var="rs" dataSource="${db}" >select * from student </sql:query>
	  
	   <c:forEach items="${rs.rows}" var="student" >
	   
	   <br> <c:out value="${student.rollno}"></c:out> : <c:out value="${student.marks}"></c:out> :<c:out value="${student.name}"></c:out>
	  
	  </c:forEach>
	  
	  <h2>2. Using Functions tag in JSTl using prefix fn</h3>
	  
	  <c:set var="str" value="Naveen reddy is a java trainer" />
	  
	  Length = ${fn:length(str)}
	  
	  <h3> 2.1 Spliting string with space as delimiter </h2>
	  
	  <c:forEach items="${fn:split(str, ' ')}"  var="s">
	   ${s}
	   <br>
	  </c:forEach>
	  
	  
	   <h3> 2.2 function to check index of a substring [using fn tag] </h2>
	   
	   Index position : ${fn:indexOf(str,"trainer")}
	  
	   <h3> 2.3 Using fn:contains() and c:if tag to test whether string contains a substring or not </h3>
	    <c:if test="${fn:contains(str, 'java')}">
	    	Java is there
	    </c:if>
	  
	   <h3> 2.3 Using fn:endswith() to test whether string: <c:out value="${str}"></c:out>  with a given string</h3>
	   <c:if test="${fn:endsWith(str,'trainer')}">
	   ${endswith} string exists
	   </c:if>
	   
	   
	  

</body>
</html>