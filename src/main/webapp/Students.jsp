<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <label>Welcome Students...</label> -->
	
	<!-- Header  -->
	<%@ include file="Header.html" %>

	<%=
	"Student: "+session.getAttribute("std")
//		out.println("Student: "+request.getAttribute("student"));
	%>
	 </br>
	 
	<!-- Footer -->
	<%@ include file="Footer.html" %>
	 
</body>
</html>