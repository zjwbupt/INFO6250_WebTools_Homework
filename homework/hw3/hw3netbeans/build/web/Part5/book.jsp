<%-- 
    Document   : book
    Created on : Feb 11, 2019, 2:39:12 PM
    Author     : lx
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entity.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop for Books</title>
    </head>
    <body>   
        <div>
            <a href="book.jsp">Books</a>
            <a href="music.jsp">Music</a>
            <a href="computer.jsp">Computer</a>
        </div>
        <h1>Shop for Books!</h1><br/>
        <jsp:useBean id="products" class="DAO.ProductCatalog" scope="session" />
        <form action="ShoppingController" method="post">
                <c:forEach items="${sessionScope.products.getProductList()}" var="prod">
                    <c:if test="${prod.type == 'book'}">
                        <input type="checkbox" name="product" value="${prod.name}">${prod.name} [$${prod.price}]<br/><br/>
                    </c:if>
                </c:forEach>  

            <br/>
            <input type = "submit" value="Add to Cart"/>
            <input type = "hidden" name="action" value="add"/><br/><br/>
            <a href="cart.jsp">View Cart</a><br/><br/>
        </form>
    </body>
</html>
