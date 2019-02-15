<%-- 
    Document   : browseOutput
    Created on : 2019-2-14, 19:22:39
    Author     : zhangjianwei
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@page import="import entity.Movie;"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>You searched for "${requestScope.keyword}"</p>
        <u>Here are the search results</u><br/>
        <table border=1>
            <tr/><th/>Movie Title<th/>Actor<th/>Actress<th/>Genre<th/>Year
            <c:forEach var="movie" items="${requestScope.result}">
                <tr/><td/>${movie.title}<td/>${movie.actor}<td/>${movie.actress}<td/>${movie.genre}<td/>${movie.year}
            </c:forEach>
        </table>
        <a href="index.jsp">Click here to go back to the main page</a>
    </body>
</html>
