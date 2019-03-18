<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/3
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quiz</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js">
    </script>
</head>
<body>
<c:choose>
    <c:when test="${page.equals('question')}">
        <h1>Question ${questionIndex}: ${question.question}</h1>
        <c:choose>
            <c:when test="${questionIndex < 10}">
                <c:set var="redirectValue" value="${questionIndex+1}"/>
            </c:when>
            <c:otherwise>
                <c:set var="redirectValue" value="result"/>
            </c:otherwise>
        </c:choose>

        <script>
            $(document).ready(function () {

                $('form').on('submit', function (e) {
                    if( $('input[name=option]:checked').val()!= "A" && $('input[name=option]:checked').val()!= "B" && $('input[name=option]:checked').val()!= "C" && $('input[name=option]:checked').val()!= "D")
                    {
                        e.preventDefault();
                    }
                });

            });
        </script>

        <form action="${redirectValue}.htm" method="post">
            A. <input type="radio" name="option" value="A"/>${question.optionA}<br/>
            B. <input type="radio" name="option" value="B"/>${question.optionB}<br/>
            C. <input type="radio" name="option" value="C"/>${question.optionC}<br/>
            D. <input type="radio" name="option" value="D"/>${question.optionD}<br/>
            <input type="submit"  name="Submit" value="Next" />

            <%--<script type="text/javascript">--%>
                <%--function checkValid() {--%>
                    <%--var option_obj = document.getElementsByName('option');--%>
                    <%--var temp_option = false;--%>
                    <%--for(var i = 0; i < option_obj.length; i ++){--%>
                        <%--if(option_obj[i].checked){--%>
                            <%--var option = option_obj[i].value;--%>
                            <%--temp_option = true;--%>
                            <%--break;--%>
                        <%--}--%>
                    <%--}--%>
                    <%--if(temp_option == false){--%>
                        <%--alert('Please select your answer');--%>
                        <%--return false;--%>
                    <%--}--%>
                <%--}--%>
            <%--</script>--%>

        </form>
    </c:when>
    <c:otherwise>
        <h1>Result</h1>
        <c:forEach var="question" items="${questionList}">
            <p>Question ${questionList.indexOf(question)+1}: ${question.question}</p>
            <p>Your Answer: ${userAnswer.get(question)}</p>
            <p>Correct Answer: ${question.correctOption}</p>
            <br/>
        </c:forEach>
    </c:otherwise>
</c:choose>
</body>
</html>
