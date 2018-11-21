<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="css-changsha/mui.css">
    <link rel="stylesheet" href="css-changsha/main.css">
     <style>
    	html,body{height: 100%;background:#f9f7ef url(img/index2.jpg) center no-repeat; background-size: contain;}
    	.mui-content{background-color: transparent;}
    	.mui-input-row label~input{width: 75%;}
    	
    </style>
    <script type="text/javascript">
    	
   		document.addEventListener('plusready', function(){
   			//console.log("所有plus api都应该在此事件发生后调用，否则会出现plus is undefined。"
   			
   		});
   		
    </script>
</head>
<body>
	<header id="header" class="mui-bar mui-bar-nav">
<!--图标显示
	<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
-->			
			<h1 class="mui-title">健康宝管理系统</h1>
	</header>
	<nav class="mui-bar mui-bar-tab">
	    <a class="mui-tab-item-link mui-active" href="xuanzejiemian.jsp">
	      <span class="mui-icon my-nav-icon-1"></span>
	      <span class="mui-tab-label">推拿取穴</span>
	    </a>
	    <a class="mui-tab-item-link" href="jiankangyanghu.jsp">
	      <span class="mui-icon my-nav-icon-2"></span>
	      <span class="mui-tab-label">学育儿</span>
	    </a>
	    <a class="mui-tab-item-link" href="yuerketang.jsp">
	      <span class="mui-icon my-nav-icon-3"></span>
	      <span class="mui-tab-label">学推拿</span>
	    </a>
	    <a class="mui-tab-item-link" href="personal-center.jsp">
	      <span class="mui-icon my-nav-icon-4"></span>
	      <span class="mui-tab-label">我的</span>
	    </a>
 	 </nav>

	<div class="mui-content">
		<div class="my-txt-box">
			<p><b class="my-txt-bt">温馨提示</b>${user.name}您好！欢迎登陆健康宝管理系统，很高兴为您提供在线专业儿童健康监测与管理服务，您是第${user.userid}位使用者，<strong>本系统只用于保健</strong>
			<%
				 if(user.getUpower()==0||user.getUpower()==1||user.getUpower()==2){
				    %>
			，您还剩余${numbers }次可以使用。
			<%
			       }
			       %>
			</p>
		</div>
		<ul class="my-grid-9">
			<li class="my-col-sm-3 my-view-cell">
				<a href="XuanzeServlet?xz=01">
                    <span class="my-grid-icon">感冒</span>
				</a>
			</li>
			<li class="my-col-sm-3 my-view-cell">
				<a href="XuanzeServlet?xz=01">
                    <span class="my-grid-icon my-grid-text-2">感冒发烧</span>
				</a>
			</li>
			<li class="my-col-sm-3 my-view-cell">
				<a href="XuanzeServlet?xz=02">
                    <span class="my-grid-icon my-grid-text-2">感冒咳嗽</span>
				</a>
			</li>
			<li class="my-col-sm-3 my-view-cell">
				<a href="XuanzeServlet?xz=03">
                    <span class="my-grid-icon">腹泻</span>
				</a>
			</li>
			<li class="my-col-sm-3 my-view-cell">
				<a href="XuanzeServlet?xz=04">
                    <span class="my-grid-icon">便秘</span>
				</a>
			</li>
			<li class="my-col-sm-3 my-view-cell">
				<a href="XuanzeServlet?xz=05">
                    <span class="my-grid-icon">积食</span>
				</a>
			</li>
			<li class="my-col-sm-3 my-view-cell">
				<a href="XuanzeServlet?xz=06">
                    <span class="my-grid-icon">保健</span>
				</a>
			</li>
			<!-- <li class="">
				<a href="XuanzeServlet?xz=07">
                    <span class=""></span>
				</a>
			</li> -->
			<li class="my-col-sm-3 my-view-cell">
				<a href="XuanzeServlet?xz=07">
                    <span class="my-grid-icon my-grid-text-3">增强<br />免疫力</span>
				</a>
			</li>
			<li class="my-col-sm-3 my-view-cell">
				<a href="XuanzeServlet?xz=08">
                    <span class="my-grid-icon my-grid-text-2">益智助长</span>
				</a>
			</li>
		</ul>
        
	</div>
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>