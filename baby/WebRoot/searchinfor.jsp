<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.dao.*"%>
<%@ page import="com.bean.*"%>
<%
	User myUser =(User)request.getSession().getAttribute("user");
	//未登录状态
	if (myUser == null) { 
		response.sendRedirect("login.jsp");
		return;
	} else {
	
	}
%>
<% 
	int i=Integer.parseInt((request.getSession().getAttribute("i")).toString());
%>
<%
	User user =(User)request.getSession().getAttribute("user");
	//未登录状态
	if (user.getUpower()==0||user.getUpower()==1||user.getUpower()==2) { 
		
	} else {
		response.sendRedirect("login.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html >   
<head>
	<meta charset="utf-8">
    <title>选择宝宝</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="css-changsha/mui.css">
    <link rel="stylesheet" type="text/css" href="css-changsha/icons-extra.css" />
    <link rel="stylesheet" href="css-changsha/main.css">
	<script src="js-changsha/mui.min.js"></script>
    <script type="text/javascript">
    	
   		document.addEventListener('plusready', function(){
   			//console.log("所有plus api都应该在此事件发生后调用，否则会出现plus is undefined。"
   			
   		});
   		
    </script>
</head>
<body>
	
	<header id="header" class="mui-bar mui-bar-nav">
		
			<h1 class="mui-title">选择宝宝</h1>
		<a class="mui-action-back mui-icon mui-icon-extra mui-icon-extra-arrowleftcricle mui-pull-left"></a>
	
	<button class="mui-btn mui-btn-blue mui-btn-link mui-pull-right" onclick="javascript:window.location.href='inputinfor.jsp'">添加</button>
	</header>
	<div class="mui-content">
		<ul class="mui-table-view">
			<c:forEach items="${patientList }" var="p">
				<li onclick="javascript:window.location.href='ForwardToAddSymptom?pid=${p.pid}&pname=${p.pname }&userid=${user.userid}&fid=${user.fid}&zhuyibh=${zhuyibh}&selplan=${selplan}&age=${p.page }'" data-value="AKSJ" data-tags="AKeSiJin" class="mui-table-view-cell mui-indexed-list-item">${p.pname }</li>
			</c:forEach>
		</ul>
	</div>
	</body>
</html>
