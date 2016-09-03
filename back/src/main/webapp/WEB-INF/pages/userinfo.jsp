<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/1 0001
  Time: 下午 3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>

</head>
<body>
<h1>你的信息：</h1>
姓名：<c:out value ="${user.name}"/><br/>
性别:<c:out value="${user.sex}"/><br/>
学号:<c:out value="${user.sno}"/><br/>
专业:<c:out value="${user.major}"/><br/>
年级:<c:out value="${user.grade}"/><br/>
班级:<c:out value="${user.clas}"/><br/>
qq:<c:out value="${user.qq}"/><br/>
邮箱:<c:out value="${user.email}"/><br/>
个性签名:<c:out value="${user.pernature}"/><br/>
注册日期:<c:out value="${user.registerdate}"/><br/>
</body>
</html>
