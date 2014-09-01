<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="control"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Watch List</title>
</head>
<body>
	<center>
		<jsp:include page="Header.jsp" />
		<br />
		<table border="1" cellpadding="4">
			<thead>
				<tr>
					<th>Auction ID</th>
					<th>Item Name</th>
				</tr>
			</thead>
			<tbody>
				<control:forEach var="itemWatch" items="${requestScope.itemWatch}">
					<tr>
						<td><a href="ShowAuction?itemId=${itemWatch.item.id}">${itemWatch.auctionId}</a></td>
						<td>${itemWatch.item.title}</td>
					</tr>
				</control:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>