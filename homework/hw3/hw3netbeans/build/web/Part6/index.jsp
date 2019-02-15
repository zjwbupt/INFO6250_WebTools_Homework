<%-- 
    Document   : index.jsp
    Created on : 2019-2-14, 18:50:32
    Author     : zhangjianwei
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action = "csvReader" method="post">
            <label>Input the csv you wanna read</label>
            <input type = "text" name = "Name"><br/>
            <input type = "submit" value= "submit"><br/>
        </form>
    </body>
</html>

