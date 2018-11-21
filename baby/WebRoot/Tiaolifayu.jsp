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
    <title>健康养护</title>
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
			<h1 class="mui-title ">发育调理</h1>
	</header>
	<nav class="mui-bar mui-bar-tab">
	    <a class="mui-tab-item-link" href="xuanzejiemian.jsp">
	      <span class="mui-icon my-nav-icon-1"></span>
	      <span class="mui-tab-label">辩证取穴</span>
	    </a>
	    <a class="mui-tab-item-link mui-active" href="jiankangyanghu.jsp">
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
		<ul class="mui-table-view">
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Fayupage1.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-26.png">
						<div class="mui-media-body">
							变蒸——在变化中蒸蒸日上
							<p class='mui-ellipsis'>什么是小儿“变蒸”呢，小儿“变蒸”会出现哪些表现，怎么应对呢？</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="TiaoLiServlet?tiaolibh=24">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							0-6个月
							<p class='mui-ellipsis'>这个时间段的宝宝：喝奶量急剧上升，容易出现腹泻、便秘等问题</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="TiaoLiServlet?tiaolibh=25">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							6-12个月
							<p class='mui-ellipsis'>这个时间段的宝宝：突然比之前容易感冒发烧，经常需要往医院跑</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="TiaoLiServlet?tiaolibh=26">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							1-3岁
							<p class='mui-ellipsis'>这个时间段的宝宝：每天都问很多为什么，对很多东西都感到好奇。</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="TiaoLiServlet?tiaolibh=27">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							3-6岁
							<p class='mui-ellipsis'>这个时间段的宝宝：开始有第一次的独立活动，离开妈妈身边</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
			</ul>
	</div>
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>
