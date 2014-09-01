
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login</title>
</head>
<body>
	<center>
		<table border='1' cellpadding='4'>
			<tbody>
				<tr>
					<td><a href='Login.jsp'>Login</a></td>
					<td><a href='RegisterUser.jsp'>Register</a></td>
				</tr>
			</tbody>
		</table>
		<br />
		<form name="input" action="Login" method="post">
			<input type="text" name="username" placeholder="user name"><br>
			<input type="text" name="password" placeholder="password"><br>
			<input type="submit" value="login">
		</form>
	</center>
</body>
</html>