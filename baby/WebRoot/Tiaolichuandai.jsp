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
			<h1 class="mui-title ">穿戴养护</h1>
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
					<a href="jkyh_text/Chuandaipage1.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-19.png">
						<div class="mui-media-body">
							你知道吗？——小儿穿衣服不宜过多！ 
							<p class='mui-ellipsis'>小儿穿多少衣服，应根据季节和个体差异而定。</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Chuandaipage2.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-16.png">
						<div class="mui-media-body">
							怎样正确给孩子“春捂”和“秋冻”（上） 
							<p class='mui-ellipsis'>春捂要把握时机。</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Chuandaipage3.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-17.png">
						<div class="mui-media-body">
							怎样正确给孩子“春捂”和“秋冻”（下）
							<p class='mui-ellipsis'>因时而异，看“天”行事</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Chuandaipage4.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-18.png">
						<div class="mui-media-body">
							“三暖二凉”穿衣法
							<p class='mui-ellipsis'>你还在为宝宝穿衣发愁吗？赶快来学习“三暖二凉”穿衣法吧！</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<!-- 
				<li class="mui-table-view-cell mui-media">
					<a href="TiaoLiServlet?tiaolibh=36">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							在家在外不同“捂”
							<p class='mui-ellipsis'>在太阳出来后或中午气温有所回升时开窗。 且不要急着给宝宝换上单鞋</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="TiaoLiServlet?tiaolibh=37">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							秋冻”勿盲目
							<p class='mui-ellipsis'>儿童为稚阴稚阳之体，正处在生长发育阶段，自身调节能力较差，遇到寒冷刺激</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				 -->

			</ul>
	</div>
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>
