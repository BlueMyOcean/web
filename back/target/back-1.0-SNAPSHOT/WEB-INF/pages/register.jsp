<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/1 0001
  Time: 下午 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session = "false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <!--  <style type="text/css">
        span.error{
            color:red;
        }
    </style>
    -->
    <link href= "${pageContext.request.contextPath}/css/error.css" type="text/css" rel="stylesheet"/>
    <title>注册</title>
</head>
<body>
<h1>注册</h1>
<!--<form method="post">
    姓名:<input type="text" name ="name" /><br/>
    学号:<input type="text" name ="sno" /><br/>
    专业:<input type="text" name ="major" /><br/>
    年级:<input type="text" name ="grade" /><br/>
    班级:<input type="text" name ="clas" /><br/>
    性别<input type="text" name ="sex" /><br/>
    昵称<input type="text" name ="nickname" /><br/>
    用户名:<input type="text" name ="username" /><br/>
    密码:<input type="text" name ="password" /><br/>
    邮箱:<input type="text" name ="email" /><br/>
    qq:<input type="text" name ="qq" /><br/>
    <input type="submit" value="注册" />
</form>-->
<sf:form method="post" action="/user/register" commandName="user">
    姓名:<sf:input path ="name" /><sf:errors path="name"  cssClass="error"/><br/>
    学号:<sf:input path="sno" /><sf:errors path="sno" cssClass="error" /><br/>
    专业:<sf:input path="major" /><sf:errors path="major"  cssClass="error"/><br/>
    年级:<sf:input path ="grade" /><sf:errors path="grade"  cssClass="error"/><br/>
    班级:<sf:input path ="clas" /><sf:errors path="clas" cssClass="error" /><br/>
    性别:<sf:input path ="sex" /><sf:errors path="sex"  cssClass="error"/><br/>
    昵称:<sf:input path ="nickname" /><sf:errors path="nickname"  cssClass="error"/><br/>
    用户名:<sf:input path ="username" /><sf:errors path="username"  cssClass="error"/><br/>
    密码:<sf:password path ="password" /><sf:errors path="password" cssClass="error"  /><br/>
    邮箱:<sf:input path ="email" type="email" /><sf:errors path="email"  cssClass="error"/><br/>
    qq:<sf:input path ="qq" /><sf:errors path="qq"  cssClass="error"/><br/>
    <input type="submit" value="注册" />
</sf:form>
</body>
</html>
