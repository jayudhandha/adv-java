<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %> 
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
  
    String num1 = request.getParameter("num1");
	String num2 = request.getParameter("num2");
	  
	// extracting numbers from request
	int x = Integer.parseInt(num1);
	int y = Integer.parseInt(num2);
	int z = x / y; // dividing the numbers
	out.print("division of numbers is: " + z); // result
  
%>
</body>
</html>