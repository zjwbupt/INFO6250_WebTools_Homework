<%-- 
    Document   : viewMovie
    Created on : 2019-2-14, 19:22:39
    Author     : zhangjianwei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    
    <script language = "javascript" type="text/javascript">
        function choosework(){
            var selection = document.getElementById("operator");
            if (selection.value === "browse")
                window.location.href = "formPart7browse.jsp";
            else
                window.location.href = "formPart7add.jsp";
        }
    </script>
    
    <body>
        <label>Welcome to our Movie Store</label><br/>
        <label>Please make your selection below</label><br/>
        <select id = "operator">
            <option value = "add"> Add new movie to database </option>
            <option value = "browse"> Browse movies</option>>
        </select>
        <button type = "button"  onclick = "choosework()">Send</button>
    </body>
</html>
