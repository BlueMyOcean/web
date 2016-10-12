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
    <link rel="stylesheet" href="/css/header.css" />
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
    <img class="outlook_img" src="/images/outlook1.jpg" />
    <img class="touxiang" src="/images/touxiang.jpg" />
    <div class="weather">
        <iframe width="300" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&color=%23C6C6C6&icon=1&py=pengshan&num=1"></iframe>

    </div>
    <p class="good_say">把你的脸迎向阳光，那就不会有阴影</p>
</div>

<form id="information">
    <h2 class="head">您的个人信息</h2>
    <p style="display: inline-block">姓 名：<input name="name" value="<c:out value="${user.name}"/>" type="text"></p>
    <p style="display: inline-block">性 别：<select class="sex">
        <option> 男 </option>
        <option> 女 </option>
    </select></p>
    <p style="display: inline-block">学 号：<input name="num" value="<c:out value="${user.sno}"/>" type="text"></p>
    <p style="display: inline-block">专 业：<input name="zy" value=" <c:out value="${user.major}"/>" type="text"></p>
    <p style="display: inline-block">年 级：<input name="grade" value=" <c:out value="${user.grade}"/>" type="text"></p>
    <p style="display: inline-block">班 级：<input name="class" value=" <c:out value="${user.name}"/>" type="text"></p>
    <p>用户名：<label class="username"><c:out value="${user.username}"/></label></p>
    <p>Q   Q：<input class="qq" type="text"></p>
    <p>邮 箱：<input class="email" type="text"></p>
    <input class="submit" type="button" value="保存修改">
</form>

<div id="news">
    <h2>瞄一眼TA的收藏</h2>
    <div class="part">
        <img src="/images/news1.jpg" />
        <h3>范冰冰入围金马影后 回应：入围已是最好的礼物</h3>
        <p>第53届金马奖入围名单昨日公布，范冰冰凭借其《我不是潘金莲》中的李雪莲一角，入围最佳女主角。此前不久，范冰冰已经凭借李雪莲一角获得西班牙圣塞巴斯蒂安电影节影后银贝壳大奖。</p>
        <span class="hot">热 点</span>
    </div>
    <div class="part">
        <img src="/images/news2.jpg" />
        <h3>移动VR王者之争：新GearVR对比Daydream两项占优</h3>
        <p>三星上月和Note 7一起发布了2016版新款Gear VR设备，新款设备向下兼容，支持的三星手机包括Note 7、Galaxy S7、Galaxy S7 Edge、Galaxy S6、Galaxy S6 Edge、S6 Edge+和Note 5。</p>
        <span class="early">更 早</span>
    </div>
    <div class="part">
        <img src="/images/news1.jpg" />
        <h3>让男人垂涎的星座女</h3>
        <p>男人看到某些女人眼睛就会贼溜溜的转，心也会随之躁动不安来，什么样的女人会让男人有这种感觉呢？</p>
        <span class="early">更 早</span>
    </div>
</div>
</body>
</html>

