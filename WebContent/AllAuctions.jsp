<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="control"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>All Auction's</title>
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
					<th>Seller ID</th>
					<th>Starting Bid</th>
					<th>currentPrice</th>
				</tr>
			</thead>
			<tbody>
				<control:forEach var="auction" items="${requestScope.auction}">
					<tr>
						<td>${auction.id}</td>
						<td>${auction.item.title}</td>
						<td>${auction.sellerId}</td>
						<td>${auction.startingBid}</td>
						<td>${auction.currentPrice}</td>
					</tr>
				</control:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>