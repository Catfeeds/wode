<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ page import="com.dao.*"%>
<%@ page import="com.bean.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%
	User user =(User)request.getSession().getAttribute("user");
	//未登录状态
	if (user == null) { 
		response.sendRedirect("login.jsp");
		return;
	} else {
	
	}
%>
<!DOCTYPE HTML>
<html lang="en" class="feedback">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>反馈意见</title>
		<link rel="stylesheet" href="css-changsha/mui.css">
    	<link rel="stylesheet" type="text/css" href="css-changsha/icons-extra.css" />
    	<link rel="stylesheet" type="text/css" href="css-changsha/feedback.css" />
    	<link rel="stylesheet" href="css-changsha/main.css">	
    	
    	
	</head>

	<body>
		<form action="FanKuiYiJianServlet" method="post">
		<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon-extra mui-icon-extra-arrowleftcricle mui-icon  mui-pull-left"></a>
			<button type="submit" class="mui-btn mui-btn-blue mui-btn-link mui-pull-right">发送</button>
			<h1 class="mui-title">反馈意见</h1>
		</header>
		<nav class="mui-bar mui-bar-tab">
		    <a class="mui-tab-item-link" href="xuanzejiemian.jsp">
		      <span class="mui-icon my-nav-icon-1"></span>
		      <span class="mui-tab-label">辩证取穴</span>
		    </a>
		    <a class="mui-tab-item-link" href="jiankangyanghu.jsp">
		      <span class="mui-icon my-nav-icon-2"></span>
		      <span class="mui-tab-label">健康养护</span>
		    </a>
		    <a class="mui-tab-item-link" href="yuerketang.jsp">
		      <span class="mui-icon my-nav-icon-3"></span>
		      <span class="mui-tab-label">育儿课堂</span>
		    </a>
		    <a class="mui-tab-item-link mui-active" href="personal-center.jsp">
		      <span class="mui-icon my-nav-icon-4"></span>
		      <span class="mui-tab-label">我的</span>
		    </a>
 		 </nav>
		<div class="mui-content">
			<div class="mui-content-padded">
				<div class="mui-inline">问题和意见</div>
			</div>
			<div class="row mui-input-row">
				<input type="hidden" name="userid" value="${user.userid }">
				<input type="hidden" name="uname" value="${user.uname }">
				<textarea id='question' id="fankuiyijian" name="fankuiyijian" class="mui-input-clear question" placeholder="请详细描述你的问题和意见...">${fankuiyijian}</textarea>
			</div>
			<p>QQ/邮箱</p>
			<div class="mui-input-row">
				<input id='contact' type="text" id="email" name="email" class="mui-input-clear contact" placeholder="(选填,方便我们联系你 )" />
			</div>
		</div>
		</form>
		<script src="js-changsha/mui.min.js"></script>
		<script src=" js-changsha/feedback.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			mui.init();
			mui('.mui-scroll-wrapper').scroll();
		</script>
	</body>

</html>