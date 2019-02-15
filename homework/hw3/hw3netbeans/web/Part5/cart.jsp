<%-- 
    Document   : cart
    Created on : Feb 11, 2019, 3:25:31 PM
    Author     : lx
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Shopping Cart</title>
    </head>
    <body>
        <div>
            <a href="book.jsp">Books</a>
            <a href="music.jsp">Music</a>
            <a href="computer.jsp">Computer</a>
        </div>
        <h1>View Shopping Cart!</h1><br/>
        <form action="ShoppingController" method="post">
            <c:forEach items="${myCart.getCart()}" var="prod">
                <input type="checkbox" name="product" value="${prod.name}">${prod.name} [$${prod.price}]<br/><br/>
            </c:forEach> 
            
            <br/>
            <input type = "submit" value="delete"/>
            <input type = "hidden" name="action" value="delete"/><br/><br/>
	</form>
    </body>
</html>
