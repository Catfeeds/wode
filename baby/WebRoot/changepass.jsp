<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
    
    <%@ page import="com.dao.*"%>
	<%@ page import="com.bean.*"%>
    <%
	User user =(User)request.getSession().getAttribute("user");
	//未登录状态
	if (user!=null) { 
		
	} else {
		response.sendRedirect("login.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <title>修改密码</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="css-changsha/mui.css">
    <link href="css-changsha/mui.picker.css" rel="stylesheet" />
	<link href="css-changsha/mui.poppicker.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="css-changsha/icons-extra.css" />
    <link rel="stylesheet" href="css-changsha/main.css">
    <script type="text/javascript">
    	
   		document.addEventListener('plusready', function(){
   			//console.log("所有plus api都应该在此事件发生后调用，否则会出现plus is undefined。"
   			
   		});
   		
    </script>
</head>
<body>
	<header id="header" class="mui-bar mui-bar-nav">

	<a class="mui-action-back mui-icon-extra mui-icon-extra-arrowleftcricle mui-icon  mui-pull-left"></a>
		
			<h1 class="mui-title">修改密码</h1>
	</header>
	<nav class="mui-bar mui-bar-tab">
	    <a class="mui-tab-item-link mui-active" href="xuanzejiemian.jsp">
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
	    <a class="mui-tab-item-link" href="personal-center.jsp">
	      <span class="mui-icon my-nav-icon-4"></span>
	      <span class="mui-tab-label">我的</span>
	    </a>
 	 </nav>
	<div class="mui-content">
		<form class="mui-input-group" name="form2" action="ChangePassServlet" method="post">
			<div class="mui-input-row">
				<label>原密码：</label>
				<input type="text" name="password">
			</div>
			<div class="mui-input-row">
				<label>新密码：</label>
				<input type="text" name="newpassword">
			</div>
		
		<div class="mui-content-padded">
	        <button type="submit" class="mui-btn my-btn mui-btn-block">提交</button>
	    </div>
	    </form>
	</div>
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>