<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>session购物车应用案例</title>
</head>
<body>
<h3>请选择购买商品</h3>
<form action="<%=request.getContextPath()%>/product" method="post">
  <table border="1" cellpadding="10" cellspacing="0">
    <tr>
      <td>书名</td>
      <td>加入购物车</td>
    </tr>
    <tr>
      <td>Mysql</td>
      <td><input type="checkbox" name="book" value="Mysql" /></td>
    </tr>
    <tr>
      <td>sqlServer</td>
      <td><input type="checkbox" name="book" value="sqlServer" /></td>
    </tr>
    <tr>
      <td>mongodb</td>
      <td><input type="checkbox" name="book" value="mongodb" /></td>
    </tr>
    <tr>
      <td>java</td>
      <td><input type="checkbox" name="book" value="java" /></td>
    </tr>
    <tr>
      <td>c</td>
      <td><input type="checkbox" name="book" value="c" /></td>
    </tr>
    <tr>
      <td>jquery</td>
      <td><input type="checkbox" name="book" value="jquery" /></td>
    </tr>
    <tr>
      <td>html</td>
      <td><input type="checkbox" name="book" value="html" /></td>
    </tr>
    <tr>
      <td><input type="submit" value="加入购物车" /></td>
    </tr>
  </table>
</form>
</body>
</html>
