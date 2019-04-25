<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>People Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">

		<h1>This is secured!</h1>
		<p>
			Hello <b><c:out value="${pageContext.request.remoteUser}"/></b> <br><br>
			Roles: <security:authentication property="principal.authorities"/>
		</p>

		<div id="content">

			<security:authorize access="hasAnyAuthority('TEACHER','ADMIN')">
			<!-- put new buttion: Add Customer -->
 			<input type="button" value = "Add Customer"
 			onclick="window.location.href='showFormForAdd';return false;"
 	 			class="add-button"
 	 		/>
			</security:authorize>



			<%-- add search function--%>
			<form:form action="search" method="get">
				Search Customer: <input type = "text" name = "theSearchName"/>
				<input type = "submit" value="Search" calss="add-button">
			</form:form>
		
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<security:authorize access="hasAuthority('ADMIN')">
					<th>Action</th>
					</security:authorize>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">


					<!-- Construct an "update link with customer id -->
					<c:url var = "updateLink" value = "/customer/showFormForUpdate">
						<c:param name = "customerId" value="${tempCustomer.id}"/>
					</c:url>

					<!-- Construct an "delete link with customer id -->
					<c:url var = "deleteLink" value = "/customer/delete">
						<c:param name = "customerId" value="${tempCustomer.id}"/>
					</c:url>

					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>

						<security:authorize access="hasAuthority('ADMIN')">
						<td>
							<!-- display the update link -->
							<a href = "${updateLink}">Update</a>
							|
							<a href = "${deleteLink}"
							onclick = "if(!(confirm('Are you sure you want to delete this'))) return false">Delete</a>
						</td>
						</security:authorize>


					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>

	<br>
	<c:url var="logoutUrl" value="/logout"/>
	<form class="form-inline" action="${logoutUrl}" method="post">
		<input type="submit" value="Log out" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>

</body>

</html>









