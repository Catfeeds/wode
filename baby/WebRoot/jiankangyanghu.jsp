<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
    
    <%@ page import="com.dao.*"%>
	<%@ page import="com.bean.*"%>
    <%
	User user =(User)request.getSession().getAttribute("user");
	//未登录状态
	if (user!=null) { 
		
	} else {
		response.sendRedirect("login.jsp");
		return;
	}
	String uid=request.getParameter("uid");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <title>健康养护</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="css-changsha/mui.css">
    <link rel="stylesheet" href="css-changsha/main.css">
     <style>
    	html,body{height: 100%;background: #f1f1f1; background-size: contain;}
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
			<h1 class="mui-title ">健康养护</h1>
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
		<div id="slider" class="mui-slider" >
			<div class="mui-slider-group mui-slider-loop">
				<!-- 额外增加的一个节点(循环轮播：第一个节点是最后一张轮播) -->
				<div class="mui-slider-item mui-slider-item-duplicate">
					<a href="#">
						<img src="img/banner-1.jpg">
					</a>
				</div>
				<!-- 第一张 -->
				<div class="mui-slider-item">
					<a href="#">
						<img src="img/banner-1.jpg">
					</a>
				</div>
				<!-- 第二张 -->
				<div class="mui-slider-item">
					<a href="#">
						<img src="img/banner-2.jpg">
					</a>
				</div>
				<!-- 第三张 -->
				<div class="mui-slider-item">
					<a href="#">
						<img src="img/banner-3.jpg">
					</a>
				</div>
				<!-- 第四张 -->
				<div class="mui-slider-item">
					<a href="#">
						<img src="img/banner-4.jpg">
					</a>
				</div>
				<!-- 额外增加的一个节点(循环轮播：最后一个节点是第一张轮播) -->
				<div class="mui-slider-item mui-slider-item-duplicate">
					<a href="#">
						<img src="img/banner-1.jpg">
					</a>
				</div>
			</div>
			<div class="mui-slider-indicator">
				<div class="mui-indicator mui-active"></div>
				<div class="mui-indicator"></div>
				<div class="mui-indicator"></div>
				<div class="mui-indicator"></div>
			</div>
		</div>
		<ul class="my-grid-9">
			<li class="my-col-sm-3 my-view-cell">
				<a href="Tiaoliyinshi.jsp">
                    <span class="my-grid-icon my-grid-text-2">饮食调理</span>
				</a>
			</li>
			<li class="my-col-sm-3 my-view-cell">
				<a href="Tiaolishuimian.jsp">
                    <span class="my-grid-icon my-grid-text-2">睡眠调理</span>
				</a>
			</li>
			<!-- <li class="my-col-sm-3 my-view-cell">
				<a href="Tiaolipaixie.jsp">
                    <span class="my-grid-icon my-grid-text-2">排泄调理</span>
				</a>
			</li>
			<li class="my-col-sm-3 my-view-cell">
				<a href="Tiaolifayu.jsp">
                    <span class="my-grid-icon my-grid-text-2">发育调理</span>
				</a>
			</li>
			<li class="my-col-sm-3 my-view-cell">
				<a href="Tiaoliyangsheng.jsp">
                    <span class="my-grid-icon my-grid-text-2">养生调理</span>
				</a>
			</li> -->
			<li class="my-col-sm-3 my-view-cell">
				<a href="Tiaolichuandai.jsp">
                    <span class="my-grid-icon my-grid-text-2">穿戴养护</span>
				</a>
			</li>
			
		</ul>
        
	</div>
	<script src="js-changsha/mui.min.js"></script>
	<script type="text/javascript" charset="utf-8">
			mui.init({
				swipeBack:true //启用右滑关闭功能
			});
			var slider = mui("#slider");
			slider.slider({
				interval: 5000
			});
				
		</script>
</body>
</html>