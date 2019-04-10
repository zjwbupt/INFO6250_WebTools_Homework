<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<title> List Customers</title>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2> CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
<!-- 			add out html table-->
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
			</tr>
			
			<c:forEach var = "tempCustomer" items ="${customers}">
				<tr>
					<td>${tempCustomer.firstname}</td>
					<td>${tempCustomer.lastname}</td>
					<td>${tempCustomer.email}</td>
				</tr>
			</c:forEach>
		</table>

		</div>
	</div>
</body>

</html>