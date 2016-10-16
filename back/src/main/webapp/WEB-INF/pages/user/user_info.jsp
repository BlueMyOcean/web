<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/12 0012
  Time: 下午 7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css" />
    <script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        function update()
        {
            var id,name,sex,sno,major,grade,clas,qq,email;
            name = document.getElementById("name");
            var name_s=name.value.trim();
            sex = document.getElementById("sex");
            var sex_s=sex.value.trim();
            sno = document.getElementById("sno");
            var sno_s=sno.value.trim();
            major = document.getElementById("major");
            var major_s=major.value.trim();
            grade = document.getElementById("grade");
            var grade_s=grade.value.trim();
            clas = document.getElementById("clas");
            var clas_s=clas.value.trim();
            qq = document.getElementById("qq");
            var qq_s=qq.value.trim();
            email = document.getElementById("email");
            var email_s=email.value.trim();

            var data={"id":id,"name":name_s,"sno":sno_s,"major":major_s,"grade":grade_s,"clas":clas_s,"sex":sex_s,"qq":qq_s,"email":email_s}

            $.ajax({
                type:"POST",
                url:"/user/update",
                dataType:"json",
                contentType:'application/json;charset=utf-8',
                data:JSON.stringify(data),
                success:function (data) {
                    name.value = data.name;
                    sex.value = data.sex;
                    sno.value = data.sno;
                    major.value = data.major;
                    grade.value = data.grade;
                    clas.value = data.clas;
                    qq.value = data.qq;
                    email.value = data.email;
                },
                error:function(e){
                    alert("修改失败！请检查长度属性！");
                }
            });

        }
    </script>
</head>
<body>
<div id="header">
    <ul class="list">
        <li>首页</li>
        <li>新闻</li>
        <li>财经</li>
        <li>体育</li>
        <li>更多</li>
    </ul>
    <p class="name"><c:out value="${user.name}"/>您好 <span style="cursor: pointer;">[退出]</span></p>
</div>
<div id="outlook">
    <h2 class="title">我的收藏</h2>
    <p class="shoucang">已收藏 <span>0</span> 篇文章 </p>
    <img class="outlook_img" src="${pageContext.request.contextPath}/images/outlook1.jpg" />
    <img class="touxiang" src="${pageContext.request.contextPath}/images/touxiang.jpg" />
    <div class="weather">
        <iframe width="300" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&color=%23C6C6C6&icon=1&py=pengshan&num=1"></iframe>

    </div>
    <p class="good_say">把你的脸迎向阳光，那就不会有阴影</p>
</div>

<form id="information">
    <h2 class="head">您的个人信息</h2>
    <p style="display: inline-block">姓 名：<input id="name" name="name" value="<c:out value="${user.name}"/>" type="text"></p>
    <p style="display: inline-block">性 别：<select id="sex" class="sex">
        <option> 男 </option>
        <option> 女 </option>
    </select></p>
    <p>id：<label class="id"><c:out value="${user.id}"/></label></p>
    <p style="display: inline-block">学 号：<input id="sno" name="num" value="<c:out value="${user.sno}"/>" type="text"></p>
    <p style="display: inline-block">专 业：<input id="major" name="major" value="<c:out value="${user.major}"/>" type="text"></p>
    <p style="display: inline-block">年 级：<input id="grade" name="grade" value="<c:out value="${user.grade}"/>" type="text"></p>
    <p style="display: inline-block">班 级：<input id="clas" name="clas" value="<c:out value="${user.clas}"/>" type="text"></p>
    <p>用户名：<label id="username" class="username"><c:out value="${user.username}"/></label></p>
    <p>Q   Q：<input id="qq" class="qq" type="text" value="<c:out value="${user.qq}"/>"></p>
    <p>邮 箱：<input id="email" class="email"  type="text" value="<c:out value="${user.email}"/>" ></p>
    <input onclick="update()" type="button" value="保存修改">
</form>

<div id="news">
    <h2>瞄一眼TA的收藏</h2>
    <div class="part">
        <img src="${pageContext.request.contextPath}/images/news1.jpg" />
        <h3>范冰冰入围金马影后 回应：入围已是最好的礼物</h3>
        <p>第53届金马奖入围名单昨日公布，范冰冰凭借其《我不是潘金莲》中的李雪莲一角，入围最佳女主角。此前不久，范冰冰已经凭借李雪莲一角获得西班牙圣塞巴斯蒂安电影节影后银贝壳大奖。</p>
        <span class="hot">热 点</span>
    </div>
    <div class="part">
        <img src="${pageContext.request.contextPath}/images/news2.jpg" />
        <h3>移动VR王者之争：新GearVR对比Daydream两项占优</h3>
        <p>三星上月和Note 7一起发布了2016版新款Gear VR设备，新款设备向下兼容，支持的三星手机包括Note 7、Galaxy S7、Galaxy S7 Edge、Galaxy S6、Galaxy S6 Edge、S6 Edge+和Note 5。</p>
        <span class="early">更 早</span>
    </div>
    <div class="part">
        <img src="${pageContext.request.contextPath}/images/news1.jpg" />
        <h3>让男人垂涎的星座女</h3>
        <p>男人看到某些女人眼睛就会贼溜溜的转，心也会随之躁动不安来，什么样的女人会让男人有这种感觉呢？</p>
        <span class="early">更 早</span>
    </div>
</div>
</body>
</html>

