<%-- 
    Document   : formPart7browse
    Created on : 2019-2-14, 19:22:39
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
        <form action = "manageMovie" method="post">
            <label>Keyword</label>
            <input type = "text" name = "keywords"><br/>
            <input type="radio" name="kind" value="title">search by Title<br/>
            <input type="radio" name="kind" value="actor">search by Actor<br/>
            <input type="radio" name="kind" value="actress">search by Actress<br/>
            <input type ="submit" value= "Search Movies"><br/>
        </form>        
    </body>
</html>
