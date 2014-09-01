<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="control"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Search Item Results</title>
</head>
<body>
	<center>
		<jsp:include page="Header.jsp" />
		<br />
		<table border="1" cellpadding="4">
			<thead>
				<tr>
					<th>Item ID</th>
					<th>Item Name</th>
					<th>Item Description</th>
					<th>Price</th>
					<th>Make Auction</th>
				</tr>
			</thead>
			<tbody>
				<control:forEach var="item" items="${requestScope.items}">
					<tr>
						<td>${item.id}</td>
						<td>${item.title}</td>
						<td>${item.description}</td>
						<form action="CreateAuction" method="get">
							<input type="hidden" name="itemID" value="${item.id}"> 
							<input type="hidden" name="sellerID" value="1">
							<td><input type="text" name="startingBID">
							<td><input type="submit" value="AUCTION IT!"></td>
						</form>
					</tr>
				</control:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>