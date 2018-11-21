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
			<h1 class="mui-title ">养生调理</h1>
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
					<a href="jkyh_text/Yangshengpage9.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-25.png">
						<div class="mui-media-body">
							【火速围观】你的宝宝是阴虚内热的体质吗？
							<p class='mui-ellipsis'>孩子为纯阳之体，但并不是有阳无阴的！</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Yangshengpage1.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-9.png">
						<div class="mui-media-body">
							【宝宝养护】饮食起居，顺季而为（上）
							<p class='mui-ellipsis'>以四时养生为据，合理安排幼儿四季饮食和日常起居。</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Yangshengpage2.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-9.png">
						<div class="mui-media-body">
							【宝宝养护】饮食起居，顺季而为（下）
							<p class='mui-ellipsis'>以四时养生为据，合理安排幼儿四季饮食和日常起居。</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Yangshengpage3.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-11.png">
						<div class="mui-media-body">
							【体征监测】如何通过体征变化看病情走向（上）
							<p class='mui-ellipsis'>学会随时观察孩子的细微变化，给孩子一个健康的身体，你值得学习。</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Yangshengpage4.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-11.png">
						<div class="mui-media-body">
							【体征监测】如何通过体征变化看病情走向（中）
							<p class='mui-ellipsis'>学会随时观察孩子的细微变化，给孩子一个健康的身体，你值得学习。</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Yangshengpage5.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-11.png">
						<div class="mui-media-body">
							【体征监测】如何通过体征变化看病情走向（下）
							<p class='mui-ellipsis'>学会随时观察孩子的细微变化，给孩子一个健康的身体，你值得学习。</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Yangshengpage6.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-13.png">
						<div class="mui-media-body">
							【营养百科】常见维生素和矿物质的来源及作用  一
							<p class='mui-ellipsis'>最全的维生素和矿物质百科来啦！</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Yangshengpage7.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-13.png">
						<div class="mui-media-body">
							【营养百科】常见维生素和矿物质的来源及作用  二
							<p class='mui-ellipsis'>最全的维生素和矿物质百科来啦！</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Yangshengpage8.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-13.png">
						<div class="mui-media-body">
							【营养百科】常见维生素和矿物质的来源及作用  三
							<p class='mui-ellipsis'>最全的维生素和矿物质百科来啦！</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>

			</ul>
	</div>
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>
