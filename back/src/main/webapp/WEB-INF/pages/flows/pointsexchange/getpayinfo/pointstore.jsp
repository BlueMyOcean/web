<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head><title>积分商城</title></head>

<body>
<h2>欢迎来到积分商城</h2>

<form:form>
    <input type="hidden" name="_flowExecutionKey"
           value="${flowExecutionKey}"/>
    <input type="text" value="1" name="goodnum"/><br/>
    <input type="submit" name="_eventId_payinfo_submit" value="payinfo_submit" />
</form:form>
</body>
</html>
