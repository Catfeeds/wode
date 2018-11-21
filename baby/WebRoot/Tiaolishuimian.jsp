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
			<h1 class="mui-title ">睡眠调理</h1>
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
					<a href="TiaoLiServlet?tiaolibh=13">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							小儿正常睡眠需求
							<p class='mui-ellipsis'>儿童身高除了与遗传、营养、体育锻炼等因素有关外</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="TiaoLiServlet?tiaolibh=14">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							婴儿睡眠不好的原因一
							<p class='mui-ellipsis'>当宝宝在晚上有大小便时，排泄物会让宝宝感觉屁屁不舒服</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="TiaoLiServlet?tiaolibh=15">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							婴儿睡眠不好的原因二
							<p class='mui-ellipsis'>宝宝在出生3个月之前一直都是在睡觉，这时爸妈绝对不能可以改变睡眠时间</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="TiaoLiServlet?tiaolibh=16">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							婴儿睡眠不好的原因三
							<p class='mui-ellipsis'>出生4个月的宝宝会有分离不安的情绪，所以在晚上经常会要妈妈陪伴在旁</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="TiaoLiServlet?tiaolibh=17">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							婴儿睡眠不好的原因四
							<p class='mui-ellipsis'>爸妈不可以因为宝宝哭闹或者正在游戏玩耍，而随便延迟睡眠时间</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>

			</ul>
	</div>
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>
