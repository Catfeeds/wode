<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.dao.*"%>
<%@ page import="com.bean.*"%>
<%
	User user =(User)request.getSession().getAttribute("user");
	//未登录状态
	if (user == null) { 
		response.sendRedirect("login.jsp");
		return;
	} else {
	
	}
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
   <meta charset="utf-8">
    <title>咽喉</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="css-changsha/mui.css">
    <link rel="stylesheet" type="text/css" href="css-changsha/icons-extra.css" />
    <link rel="stylesheet" href="css-changsha/main.css">
    <script type="text/javascript">
    	
   		document.addEventListener('plusready', function(){
   			//console.log("所有plus api都应该在此事件发生后调用，否则会出现plus is undefined。"
   			
   		});
   		
    </script>
</head>
<body>
	<form name="form2" action="KouQiangXuanze" method="post">
	<header id="header" class="mui-bar mui-bar-nav">

	<a class="mui-action-back mui-icon mui-icon-extra mui-icon-extra-arrowleftcricle mui-pull-left"></a>
		
			<h1 class="mui-title">口腔</h1>
	<button class="mui-btn mui-btn-blue mui-btn-link mui-pull-right" type="submit">确定</button>
	</header>
	<div class="mui-content">
		<div class="mui-input-group">
			<div class="mui-input-row mui-radio">
				<label>无味</label>
				<input name="kouqiang" type="radio" checked="checked" value="01_无味_24">
				<input type="hidden" name="xuanze" value="<%=request.getParameter("xuanze")%>"/>
			</div>
			<div class="mui-input-row mui-radio">
				<label>酸味</label>
				<input name="kouqiang" type="radio" value="01_酸味_25">
			</div>
			<div class="mui-input-row mui-radio">
				<label>臭味</label>
				<input name="kouqiang"  type="radio" value="02_臭味_26" >
			</div>
		</div>
	</div>
	</form>
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>
