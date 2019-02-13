### c:out tag

c:out tag is very like JSP script like <%= %> or ${...}

The c:out tag avoids all these prolems by providing escapeXML attribute that is set to true by default;

```html
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    
    <body>
        <c:out value = "<c:out> tag"/><br>
        Subscription ID: <c:out value = "${id}" default = "None"/> 
    </body>
</html>
```



### c:forEach and c:forTokens Tags

```html
<c:forEach var = "i" begin = "1" end = "10" step = "2">
	i = ${i}<br>
</c:forEach>

<c:forTokens var = "item" items = "<Once)unpn,A(Time%There...)" delims = "<).(%>">
	${item}<br>
</c:forTokens>
```

