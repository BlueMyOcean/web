<%@ page language="java" import="java.util.*"  pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>δ��¼</title>
    <script language='javascript' type='text/javascript'>
        var secs = 3; //����ʱ������
        var URL;
        function Load(url) {
            URL = url;
            for ( var i = secs; i >= 0; i--) {
                window.setTimeout('doUpdate(' + i + ')', (secs - i) * 1000);
            }
        }
        function doUpdate(num) {
            document.getElementById('ShowDiv').innerHTML = '����' + num + '����Զ���ת����¼ҳ��';
            if (num == 0) {
                window.location = URL;
            }
        }
    </script>
</head>

<body>
<center>
    <h1>
        <font color="red" align="center">����δ��¼��</font>
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
                �ֶ���¼��
            </h5> </font>
    /s:a -->

</center>
</body>
</html>