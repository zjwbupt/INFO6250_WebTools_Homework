<%-- 
    Document   : part4
    Created on : 2019-2-12, 15:13:27
    Author     : zhangjianwei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assignment3: Part4_Using JSTL Functions</title>
    </head>
    
    <body>
        <h2>1. Core Tags</h2>
            <h3>a. &lt;c:out&gt; Example</h3>
                <c:out value="&lt Use no escapeXml &gt" escapeXml="true" default="默认值"></c:out><br/>
                <c:out value="&lt Use of escapeXml &gt" escapeXml="false" default="默认值"></c:out><br/>
                <c:out value="${null}" escapeXml="false">使用的表达式结果为null，则输出该默认值</c:out><br/>
            
            <h3>b. &lt;c:set&gt; Example</h3>    
                <c:set var="salary" scope="session" value="${2000*2}"/><br/>
                Salary is : <c:out value="${salary}"/><br/>
            
            <h3>c. &lt;c:if&gt; Example</h3> 
                <c:if test="${salary > 2000}">
                <p>My Salary is: <c:out value="${salary}"/><p>
                </c:if><br/>
                    
        <h2>2. Format Tags</h2>
            <h3>a. Format Number:</h3>
            <c:set var="balance" value="120000.2309" />
            <p>Format Number (1): <fmt:formatNumber value="${balance}" type="currency"/></p>
            <p>Format Number (2): <fmt:formatNumber type="number" maxIntegerDigits="3" value="${balance}" /></p>
            <p>Format Number (3): <fmt:formatNumber type="number" maxFractionDigits="3" value="${balance}" /></p>
            <p>Format Number (4): <fmt:formatNumber type="number" groupingUsed="false" value="${balance}" /></p>
            <p>Format Number (5): <fmt:formatNumber type="percent" maxIntegerDigits="3" value="${balance}" /></p>
            <p>Format Number (6): <fmt:formatNumber type="percent" minFractionDigits="10" value="${balance}" /></p>
            <p>Format Number (7): <fmt:formatNumber type="percent" maxIntegerDigits="3" value="${balance}" /></p>
            <p>Format Number (8): <fmt:formatNumber type="number" pattern="###.###E0" value="${balance}" /></p>
            <p>Dollar :
            <fmt:setLocale value="en_US"/>
            <fmt:formatNumber value="${balance}" type="currency"/></p>
            
                
            <h3>b. Format Data:</h3>
            <c:set var="now" value="20-10-2019" />
            <fmt:parseDate value="${now}" var="parsedEmpDate" pattern="dd-MM-yyyy" />
            <p>Date after parse: <c:out value="${parsedEmpDate}" /></p>
            
            <h3>c. Time Zone: </h3>
            <c:set var="now" value="<%=new java.util.Date()%>" />
            
            <table border="1" width="100%">
            <tr>
                <td width="100%" colspan="2" bgcolor="#0000FF">
                <p align="center">
                <b> <font color="#FFFFFF" size="4">Formatting: <fmt:formatDate value="${now}" type="both" timeStyle="long" dateStyle="long" /> </font> </b>
                </p>
                </td>
            </tr>

            <c:forEach var="zone"  begin="1" end="5" items="<%=java.util.TimeZone.getAvailableIDs()%>">
            <tr>
                <td width="51%"> <c:out value="${zone}" /> </td>
                <td width="49%"> <fmt:timeZone value="${zone}"> <fmt:formatDate value="${now}" timeZone="${zn}" type="both" /> </fmt:timeZone> </td>
            </tr>
            </c:forEach>
            </table>
                
        <h2>3. XML Tag & Function </h2>
        <h3>a. x:out</h3>
        <c:set var="xmltext">
        <books>
    <book>
      <name>Padam History</name>
      <author>ZARA</author>
      <price>100</price>
    </book>
    <book>
      <name>Great Mistry</name>
      <author>NUHA</author>
      <price>2000</price>
    </book>
  </books>
</c:set>

<x:parse xml="${xmltext}" var="output"/>
<b>The title of the first book is</b>: 
<x:out select="$output/books/book[1]/name" />
<br>
<b>The price of the second book</b>: 
<x:out select="$output/books/book[2]/price" />

        <h3>b. fn: indexOf</h3>
        <c:set var="string1" value="This is first String."/>
        <c:set var="string2" value="This <abc>is second String.</abc>"/>

        <p>Index (1) : ${fn:indexOf(string1, "first")}</p>
<p>Index (2) : ${fn:indexOf(string2, "second")}</p>

        <h3>c. fn:substring() </h3>
        <c:set var="string1" value="This is first String."/>
<c:set var="string2" value="${fn:substring(string1, 5, 15)}" />

<p>Generated substring is : ${string2}</p>

<h3>d. fn:length() </h3>

<c:set var="string1" value="This is first String."/>
<c:set var="string2" value="This is second String." />

<p>Length (1) : ${fn:length(string1)}</p>
<p>Length (2) : ${fn:length(string2)}</p>



    </body>
    
</html>
