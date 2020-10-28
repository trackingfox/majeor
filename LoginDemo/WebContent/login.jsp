<%@ page import="java.util.*, login.Bean.*,login.Database.*,login.web.* " %>

<html>
<head>

<title>
</title>
</head>
<body>
	<div align ="center">
	<h1>User Login Form</h1>
	
	<form action="Login" method="post">
		<table>
			<tr>
				<td>User Name: </td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>
				
		</table>
	</form>
	</div>
</body>
</html>