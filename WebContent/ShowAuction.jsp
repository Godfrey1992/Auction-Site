<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="control"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Show Auction</title>
</head>
<body>
	<center>
		<jsp:include page="Header.jsp" />
		<br />
		<table border="1" cellpadding="4">
			<thead>
				<tr>
					<th>Item ID</th>
					<th>Seller ID</th>
					<th>Item Name</th>
					<th>Item Description</th>
					<th>Current Bid</th>
					<th>Bid</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<control:forEach var="auctionItem"
					items="${requestScope.auctionItem}">
					<tr>
						<td>${auctionItem.item.id}</td>
						<td>${auctionItem.item.sellerId}</td>
						<td>${auctionItem.item.title}</td>
						<td>${auctionItem.item.description}</td>
						<td>${auctionItem.currentPrice}</td>
						<form name="input" action="updateController" method="get">
							<input type="hidden" name="itemId" value="${auctionItem.item.id}">
							<input type="hidden" name="auctionId" value="${auctionItem.id}">
							<td><input type="text" name="newPrice"
								placeholder="New Bid.."></td>
							<td><input type="submit" value="Place Bid"></td>
						</form>
					</tr>
				</control:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>