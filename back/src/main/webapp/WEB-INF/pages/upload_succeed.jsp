<%@ page language="java" import="java.util.*"  pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>上传成功！</title>
    <script language='javascript' type='text/javascript'>
        var secs = 2; //倒计时的秒数
        var URL;
        function Load(url) {
            URL = url;
            for ( var i = secs; i >= 0; i--) {
                window.setTimeout('doUpdate(' + i + ')', (secs - i) * 1000);
            }
        }
        function doUpdate(num) {
            document.getElementById('ShowDiv').innerHTML = '将在' + num + '秒后自动跳转到登录页面';
            if (num == 0) {
                window.location = URL;
            }
        }
    </script>
</head>

<body>
<center>
    <h1>
        <font color="blue" align="center">上传头像成功！</font>
    </h1>
    <br />
    <div id="ShowDiv"></div>
    <script language="javascript">
        Load("/");
    </script>
    <!--
    s:a href="/ourRepository/user_login.jsp">
        <font color="blue">
            <h5>
                手动登录？
            </h5> </font>
    /s:a -->

</center>
</body>
</html>