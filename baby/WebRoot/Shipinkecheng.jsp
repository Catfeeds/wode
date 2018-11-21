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
					<a href="ShiPinServlet?shipinbh=64">
						<img class="mui-media-object mui-pull-left" src="img/kecheng/sltd.jpg">
						<div class="mui-media-body">
							必备基础知识之小儿生理特点
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinServlet?shipinbh=65">
						<img class="mui-media-object mui-pull-left" src="img/kecheng/bltd.jpg">
						<div class="mui-media-body">
							必备基础知识之小儿病理特点
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinServlet?shipinbh=66">
						<img class="mui-media-object mui-pull-left" src="img/kecheng/wwwc.jpg">
						<div class="mui-media-body">
							体征观察：望、闻、问、触、八纲辨证
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinServlet?shipinbh=67">
						<img class="mui-media-object mui-pull-left" src="img/kecheng/tnyl.jpg">
						<div class="mui-media-body">
							快速掌握推拿原理及注意事项
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinServlet?shipinbh=68">
						<img class="mui-media-object mui-pull-left" src="img/kecheng/xwsf.jpg">
						<div class="mui-media-body">
							快速找到推拿穴位及推拿作用
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinServlet?shipinbh=69">
						<img class="mui-media-object mui-pull-left" src="img/kecheng/xwsf.jpg">
						<div class="mui-media-body">
							快速学习推拿手法及操作要领
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				
			</ul>
	</div>
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>
