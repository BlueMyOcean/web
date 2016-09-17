<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>	ComLab</title>
		<meta charset="UTF-8">
		<link href="${pageContext.request.contextPath}/css/error.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
   <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
   <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
   <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />
  <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" type="text/javascript">
        function baidu(){
            var search=document.getElementById("input");
            window.location.href="https://www.baidu.com/s?wd="+search.value;
        }
    </script>

    </head>
	<body>
		<img src="${pageContext.request.contextPath}/images/intro-bg1.jpg">
	<div id="header">
	<img src="${pageContext.request.contextPath}/images/logo2.png" />
	<div>
	<ul>
	<li><a href="${pageContext.request.contextPath}/WEB-INF/pages/index2.html">更多</a></li>
        <%! String name;String username;%>
        <%= name= (String) session.getAttribute("nickname")%>
        <%=username = (String)session.getAttribute("username")%>
        <% if (name==null){ %>
	<li><a  id="register"  data-toggle="modal" data-backdrop="static" data-target="#registerModal"><span class="glyphicon glyphicon-user"></span>注册</a></li>
	<li><a id="logon" data-toggle="modal" data-backdrop="static" data-target="#logonModal"><span class="glyphicon glyphicon-log-in"></span> 登陆</a></li>
        <% } else{%>
        <li><a  id="logout"  data-toggle="modal" data-backdrop="static" href="<s:url value="/user/logout"/>"><span class="glyphicon glyphicon-log-out"></span>退出</a></li>
        <li><a  id="nickname"  data-toggle="modal" data-backdrop="static" href=" <s:url value="/user/{username}"><s:param name="username" value="<%=username%>"/> </s:url> "><span class="glyphicon glyphicon-user"></span><%= name%></a></li>
        <%}%>
	<li><a href="/" class="active">首页</a></li>
	</ul>
	</div>
	</div>


		<div id="search">
			<input type="text" id="input" />
			<button type="button" onclick=baidu()>搜索一下</button>
		</div>

<div id="registerModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
				欢迎注册实验室签到账号
				</h4>
			</div>

			<!--注册-->
			<div class="modal-body">
			<sf:form method="post" action="${pageContext.request.contextPath}/user/register" cssClass="form-horizontal" commandName="user">
			<div class="form-group">
			<label class="control-label col-md-3 col-sm-2">用户名：</label>
			<div class="col-md-8 col-sm-10">
				<sf:input path="username" cssClass="form-control" />
				<sf:errors path="username"  cssClass="error"/><br/>
			</div>
			</div>
			
			<div class="form-group">
			<label class="control-label col-md-3 col-sm-2">密　码：</label>
			<div class="col-md-8 col-sm-10">
				<sf:input path="password" type="password" cssClass="form-control" />
				<sf:errors path="password" cssClass="error"  /><br/>
			</div>
			</div>

				<div class="form-group">
					<label class="control-label col-md-3 col-sm-2">姓  名：</label>
					<div class="col-md-8 col-sm-10">
						<sf:input path="name" cssClass="form-control" />
						<sf:errors path="name" cssClass="error" /><br/>
					</div>
				</div>
			
			<div class="form-group">
			<label class="control-label col-md-3 col-sm-2">学  号：</label>
			<div class="col-md-8 col-sm-10">
				<sf:input path="sno" cssClass="form-control" />
				<sf:errors path="sno" cssClass="error" /><br/>
			</div>
			</div>

				<div class="form-group">
					<label class="control-label col-md-3 col-sm-2">专  业：</label>
					<div class="col-md-8 col-sm-10">
						<sf:input path="major" cssClass="form-control" />
						<sf:errors path="major" cssClass="error" /><br/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-md-3 col-sm-2">班  级：</label>
					<div class="col-md-8 col-sm-10">
						<sf:input path="clas" cssClass="form-control" />
						<sf:errors path="clas" cssClass="error" /><br/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-md-3 col-sm-2">年  级：</label>
					<div class="col-md-8 col-sm-10">
						<sf:input path="grade" cssClass="form-control" />
						<sf:errors path="grade" cssClass="error" /><br/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-md-3 col-sm-2">性  别：</label>
					<div class="col-md-8 col-sm-10">
						<sf:input path="sex" cssClass="form-control" />
						<sf:errors path="sex" cssClass="error" /><br/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-md-3 col-sm-2">昵  称：</label>
					<div class="col-md-8 col-sm-10">
						<sf:input path="nickname" cssClass="form-control" />
						<sf:errors path="nickname" cssClass="error" /><br/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-md-3 col-sm-2">邮  箱：</label>
					<div class="col-md-8 col-sm-10">
						<sf:input path="email" cssClass="form-control" />
						<sf:errors path="email" type="email" cssClass="error" /><br/>
					</div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<input type="submit" class="btn btn-primary" value="注册"/>
				</div>



			</sf:form>
			</div>


		</div>
	</div>
</div>

<div id="logonModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
				欢迎登陆实验室签到系统
				</h4>
			</div>
			<div class="modal-body">
			<div class="row">
			<div class="col-md-4">
			</div>
			<div class="col-md-8">
				<form class="form-horizontal" action="${pageContext.request.contextPath}/user/login" method="post">
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3" >用户名：</label>
						<div class="col-md-8 col-sm-8">
							<div class="input-group">
								<span class="input-group-btn">
									<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-user"></span>  </button>
								</span>
								<input type="text" class="form-control" name="username"/>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3">密　码：</label>
						<div class="col-md-8 col-sm-8">
							<div class="input-group">
								<span class="input-group-btn">
									<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-lock"></span>  </button>
								</span>
								<input type="password" class="form-control" name="password"/>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<input type="submit" class="btn btn-primary" value="登录"/>
					</div>

				</form>

			</div>
			</div>
			</div>

		</div>
	</div>
</div>

</body>
</html>
