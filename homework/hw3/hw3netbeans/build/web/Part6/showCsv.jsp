<%-- 
    Document   : showCsv
    Created on : 2019-2-12, 14:56:00
    Author     : prospace
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>csv show</title>
    </head>
    <body>
        <p>This is the csv you select</p>
        <%@ page import="java.util.*"%>
        <c:if test= "${sessionScope.title!=null}">
            <c:set var="cart" value = "${sessionScope.title}"/>
            <table border = "1">
                <tr>
                <c:forEach items="${sessionScope.title}" var="Str">
                    <th><c:out value = "${Str}"/></td>
                </c:forEach>               
                </tr> 
                <c:forEach items="${sessionScope.content}" var = "element">
                    <tr>
                        <c:forEach items = "${element.value}" var = "conts">
                            <td><c:out value="${conts}"/></td>
                        </c:forEach>
                    </tr> 
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
