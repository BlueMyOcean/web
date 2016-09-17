<%--
  Created by IntelliJ IDEA.
  User: W
  Date: 2016/8/30
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创新Lab</title>
</head>
<body>
欢迎来到创新实验室首页！
<form method="post" action="/user/login">
    用户名:<input type="text" name="username"/>
    密 码：<input type="password" name="password"/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
