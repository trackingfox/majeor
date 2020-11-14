<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%

	request.getSession(false);
	if(session==null){%>
		<a href="http://localhost:8080/LOGIN_PAGE/home.jsp">Home</a>
		<a href="http://localhost:8080/LOGIN_PAGE/login.jsp">Login</a>
	<%
	}else{
		//already created
		%>
		<a href="http://localhost:8080/LOGIN_PAGE/logout.jsp">Logout</a><%
	}
	String name = request.getParameter("name");
	%>
	<br><br>
	<% 
	out.println("Welcome : "+name);
	
	%>

</body>
</html>