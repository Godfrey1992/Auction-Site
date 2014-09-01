<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Item/Auction</title>
</head>
<body>
	<center>
		<jsp:include page="Header.jsp" />
		</br>
		<h4>Note: only select auction or item NOT both</h4>
		<form name="input" action="SearchItems" method="get">
			<input type="text" name="s" placeholder="Search..."> <input
				type="checkbox" name="option1" value="live">Auctions <input
				type="checkbox" name="option2" value="live" checked="checked">Items
		</form>
	</center>
</body>
</html>