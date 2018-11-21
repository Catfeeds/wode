<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.dao.*"%>
<%@ page import="com.bean.*"%>

<%
	User myUser =(User)request.getSession().getAttribute("user");
	//未登录状态
	if (myUser == null) { 
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
    <meta charset="utf-8">
    <title>表单提交</title>
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
	<header id="header" class="mui-bar mui-bar-nav">

	<a class="mui-action-back mui-icon-extra mui-icon-extra-arrowleftcricle mui-icon  mui-pull-left"></a>
		
			<h1 class="mui-title">辩证取穴 - 积食</h1>
	</header>
	
	<div class="mui-content">
	 <form id="form5" action="InputJishi" method="post">
		<ul class="mui-table-view">
		
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectshiyucha.jsp?xuanze=5">
					<span class="mui-badge my-list-wz">${str2shiyucha}</span>
					食欲差<input type="hidden" name="shiyucha" value="${shiyucha}"/>
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selecttiaoshi.jsp?xuanze=5">
					<span class="mui-badge my-list-wz">${str2tiaoshi}</span>
					挑食<input type="hidden" name="tiaoshi" value="${tiaoshi}"/>
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectyanshi.jsp?xuanze=5">
					<span class="mui-badge my-list-wz">${str2yanshi}</span>
					厌食<input type="hidden" name="yanshi" value="${yanshi}"/>
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectyoukouqi.jsp?xuanze=5">
					<span class="mui-badge my-list-wz">${str2youkouqi}</span>
					有口气<input type="hidden" name="youkouqi" value="${youkouqi}"/>
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectshetaihou.jsp?xuanze=5">
					<span class="mui-badge my-list-wz">${str2shetaihou}</span>
					舌苔厚<input type="hidden" name="shetaihou" value="${shetaihou}"/>
				</a>
			</li>
		</ul>
	    </form>
	    <div class="mui-content-padded">
	        <button form="form5" type="submit" class="mui-btn my-btn mui-btn-block">提交</button>
	    </div>
	</div>
	
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>