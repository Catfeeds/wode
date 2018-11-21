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
  <meta charset="utf-8">
    <title>课程视频</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="css-changsha/mui.css">
    <link rel="stylesheet" type="text/css" href="css-changsha/icons-extra.css" />
    <link rel="stylesheet" type="text/css" href="css-changsha/iconfont.css" />
    <link rel="stylesheet" href="css-changsha/main.css">
    <script type="text/javascript">
    	
   		document.addEventListener('plusready', function(){
   			//console.log("所有plus api都应该在此事件发生后调用，否则会出现plus is undefined。"
   			
   		});
   		
    </script>
</head>
<body>
	<header id="header" class="mui-bar mui-bar-nav">
	<a class="mui-action-back mui-icon mui-icon-extra mui-icon-extra-arrowleftcricle mui-pull-left"></a>
			<h1 class="mui-title ">课程视频</h1>
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
	    <a class="mui-tab-item-link mui-active" href="yuerketang.jsp">
	      <span class="mui-icon my-nav-icon-3"></span>
	      <span class="mui-tab-label">育儿课堂</span>
	    </a>
	    <a class="mui-tab-item-link" href="personal-center.jsp">
	      <span class="mui-icon my-nav-icon-4"></span>
	      <span class="mui-tab-label">我的</span>
	    </a>
 	 </nav>
	<div class="mui-content">
		<ul class="mui-table-view">
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinServlet?shipinbh=71">
						<img class="mui-media-object mui-pull-left" src="img/banner-4.jpg">
						<div class="mui-media-body">
							小孩反复咳嗽怎么办！辣妈儿推有绝招
							<p class='mui-ellipsis'>往期公开课精彩回顾</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/12/29</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinServlet?shipinbh=72">
						<img class="mui-media-object mui-pull-left" src="img/banner-4.jpg">
						<div class="mui-media-body">
							小孩突发高烧，辣妈儿推给你支三招
							<p class='mui-ellipsis'>往期公开课精彩回顾</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/12/29</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinServlet?shipinbh=73">
						<img class="mui-media-object mui-pull-left" src="img/banner-4.jpg">
						<div class="mui-media-body">
							警惕！这些表现都是生病的征兆
							<p class='mui-ellipsis'>往期公开课精彩回顾</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/12/29</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinServlet?shipinbh=74">
						<img class="mui-media-object mui-pull-left" src="img/banner-4.jpg">
						<div class="mui-media-body">
							从体征变化看病程走向
							<p class='mui-ellipsis'>往期公开课精彩回顾</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/12/29</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinServlet?shipinbh=75">
						<img class="mui-media-object mui-pull-left" src="img/banner-4.jpg">
						<div class="mui-media-body">
							推拿后孩子的常见变化
							<p class='mui-ellipsis'>往期公开课精彩回顾</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/12/29</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinServlet?shipinbh=76">
						<img class="mui-media-object mui-pull-left" src="img/banner-4.jpg">
						<div class="mui-media-body">
							教您轻松看懂化验单！
							<p class='mui-ellipsis'>往期公开课精彩回顾</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/12/29</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinServlet?shipinbh=77">
						<img class="mui-media-object mui-pull-left" src="img/banner-4.jpg">
						<div class="mui-media-body">
							贫血、缺乏维生素、微量元素等相关护理
							<p class='mui-ellipsis'>往期公开课精彩回顾</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/12/29</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinServlet?shipinbh=78">
						<img class="mui-media-object mui-pull-left" src="img/banner-4.jpg">
						<div class="mui-media-body">
							常见类型的过敏护理方案
							<p class='mui-ellipsis'>往期公开课精彩回顾</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/12/29</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinServlet?shipinbh=79">
						<img class="mui-media-object mui-pull-left" src="img/banner-4.jpg">
						<div class="mui-media-body">
							【虚不受补】为什么你家小孩越吃越瘦？
							<p class='mui-ellipsis'>往期公开课精彩回顾</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/12/29</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinServlet?shipinbh=80">
						<img class="mui-media-object mui-pull-left" src="img/banner-4.jpg">
						<div class="mui-media-body">
							【阴虚内热】踢被？脾气暴躁？根源在这里！
							<p class='mui-ellipsis'>往期公开课精彩回顾</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/12/29</span></p>
						</div>
					</a>
				</li>

			</ul>
	</div>
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>
