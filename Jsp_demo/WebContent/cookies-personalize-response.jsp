<html>
<head>

	<title> Configuration</title>

</head>

<body>
<%
// read the form data
	String favLang=request.getParameter("favoriteLanguage");

//create the cookie
Cookie theCookie= new Cookie("myApp.favoriteLanguage",favLang);
//set the life span...total no of seconds
theCookie.setMaxAge(60*60*24*365);

//send Cookie to browser
response.addCookie(theCookie);
%>

	
    Thanks !we set your favourite language to: ${param.favoriteLanguage}
	<br/><br/>
	<a href="cookies-homepage.jsp">Return to homepage</a>		
	
	</body>


</html>