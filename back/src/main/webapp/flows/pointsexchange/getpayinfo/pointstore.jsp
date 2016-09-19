<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/18 0018
  Time: 上午 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>积分商城</title>
</head>
<body>
<form method="get">
    <input type="hidden" name="_flowExecutionKey" value="${flowExcutionKey}">
    <label>
        <input type="text" value="goodnum"/>
    </label>
    <br/>
    <input type="submit" name="_eventId_payinfo_submit" value="get payinfo">
</form>
</body>
</html>
