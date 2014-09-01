<%@page import="come.myEbay.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="control"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Auction Search Results</title>
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
					<th>Starting Price</th>
					<th>Current Price</th>
				</tr>
			</thead>
			<tbody>
				<control:forEach var="auctionItem"
					items="${requestScope.auctionItem}">
					<tr>
						<td>${auctionItem.id}</td>
						<td>${auctionItem.item.title}</td>
						<td>${auctionItem.sellerId}</td>
						<td>${auctionItem.startingBid}</td>
						<td>${auctionItem.currentPrice}</td>
						<form action="ShowAuction" method="get">
							<input type="hidden" name="itemId" value="${auctionItem.item.id}">
							<td><input type="submit" value="View Auction"></td>
						</form>
						
						<form action="watchAuctionController" method="get">
							<input type="hidden" name="auctionId" value="${auctionItem.id}">
							<input type="hidden" name="itemId" value="${auctionItem.item.id}">
							<td><input type="submit" value="Watch"></td>
						</form>
					</tr>
				</control:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>