<%-- 
    Document   : formPart7add
    Created on : 2019-2-14, 19:37:39
    Author     : zhangjianwei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action = "addMovie" method="post">
            <label>Input the Movie you wanna add</label><br/>
            <label>title</label><input type = "text" name = "title"><br/>
            <label>actor</label><input type = "text" name = "actor"><br/>
            <label>actress</label><input type = "text" name = "actress"><br/>
            <label>genre</label><input type = "text" name = "genre"><br/>
            <label>year</label><input type = "text" name = "year"><br/>
            <input type ="submit" value= "add"><br/>
        </form>
    </body>
</html>

