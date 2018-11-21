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
		
			<h1 class="mui-title">辩证取穴 - 感冒发烧</h1>
	</header>
	
	<div class="mui-content">
	<form id="form1" action="InputSymptom" method="post">
		<ul class="mui-table-view">
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectdushu.jsp?xuanze=2"> 
					<span class="mui-badge my-list-wz">${str2dushu}</span>
					度数<input type="hidden" name="dushu" value="${dushu}"/> 
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectbisai.jsp?xuanze=1"> 
					<span class="mui-badge my-list-wz">${str2bisai}</span>
					鼻塞<input type="hidden" name="bisai" value="${bisai}"/> 
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectliuti.jsp?xuanze=1"> 
					<span class="mui-badge my-list-wz">${str2liuti}</span>
					流涕<input type="hidden" name="liuti" value="${liuti}"/> 
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectdapenti.jsp?xuanze=1"> 
					<span class="mui-badge my-list-wz">${str2dapenti}</span>
					打喷嚏<input type="hidden" name="dapenti" value="${dapenti}"/> 
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectyantong.jsp?xuanze=1"> 
					<span class="mui-badge my-list-wz">${str2yantong}</span>
					咽痛<input type="hidden" name="yantong" value="${yantong}"/> 
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectyanshi.jsp?xuanze=1"> 
					<span class="mui-badge my-list-wz">${str2yanshi}</span>
					厌食<input type="hidden" name="yanshi" value="${yanshi}"/> 
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectoutu.jsp?xuanze=1"> 
					<span class="mui-badge my-list-wz">${str2outu}</span>
					呕吐<input type="hidden" name="outu" value="${outu}"/> 
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectganmaofuxie.jsp?xuanze=1"> 
					<span class="mui-badge my-list-wz">${str2ganmaofuxie}</span>
					腹泻<input type="hidden" name="ganmaofuxie" value="${ganmaofuxie}"/> 
				</a>
			</li>
			 <li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectfutong.jsp?xuanze=1"> 
					<span class="mui-badge my-list-wz">${str2futong}</span>
					腹痛<input type="hidden" name="futong" value="${futong}"/> 
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selecttoutong.jsp?xuanze=1"> 
					<span class="mui-badge my-list-wz">${str2toutong}</span>
					头痛<input type="hidden" name="toutong" value="${toutong}"/> 
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selecttouyun.jsp?xuanze=1"> 
					<span class="mui-badge my-list-wz">${str2touyun}</span>
					头晕<input type="hidden" name="touyun" value="${touyun}"/> 
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectbttzd.jsp?xuanze=1"> 
					<span class="mui-badge my-list-wz">${str2bttzd}</span>
					扁桃体肿大<input type="hidden" name="bttzd" value="${bttzd}"/> 
				</a>
			</li>
		</ul>
	    </form>
	    <div class="mui-content-padded">
	        <button form="form1" type="submit" class="mui-btn my-btn mui-btn-block">提交</button>
	    </div>
	</div>
	
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>