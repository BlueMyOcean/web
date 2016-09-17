<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/12 0012
  Time: 下午 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传</title>
</head>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
<input type="file" name="picture" accept="*/*">
    <input type="submit"/>
</form>

</body>
</html>
