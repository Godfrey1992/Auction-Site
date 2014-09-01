<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert Item</title>
</head>
<body>
	<center>
		<jsp:include page="Header.jsp" />
		<br />
		<h4>Note: please insert item name in UPPER CASE</h4>
		<form name="input" action="InsertItem" method="get">
			<input type="text" name="title" placeholder="Title"><br>
			<input type="text" name="desc" placeholder="Description"><br>
			<input type="submit" value="Insert Item">
		</form>
	</center>
</body>
</html>