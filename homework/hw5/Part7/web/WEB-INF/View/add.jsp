<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/18
  Time: 6:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add Movie to Database</title>
</head>
<body>
<h1>Please enter the details below:</h1>
<div>
    <form:form commandName="movie" method="post">
        <label>Movie Title: </label>
        <form:input path="title"/><br/>
        <label>Lead Actor: </label>
        <form:input path="actor"/><br/>
        <label>Lead Actress: </label>
        <form:input path="actress"/><br/>
        <label>Genre: </label>
        <form:input path="genre"/><br/>
        <label>Year: </label>
        <form:input path="year"/><br/>
        <input type="submit" name="submit" value="Add Movie"/>
    </form:form>
</div>
</body>
</html>
