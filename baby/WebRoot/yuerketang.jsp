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
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <title>育儿课堂</title>
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
			<h1 class="mui-title ">育儿课堂</h1>
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
		<!-- <div>
				<div id="segmentedControl" class="mui-segmented-control mui-segmented-control-inverted mui-segmented-control-primary">
					<a class="mui-control-item my-tab-item mui-active" href="#item1">
						操作指南
					</a>
						<a class="mui-control-item my-tab-item" href="#item2">
						育儿课堂
					</a>
				</div>
		</div>
		<div>
			<div id="item1" class="mui-control-content mui-active">
				<div id="scroll">
					<div class="mui-scroll">
						<ul class="mui-table-view">
							<li class="mui-table-view-cell mui-media">
								<a href="TiaoLiServlet?tiaolibh=38">
									<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
									<div class="mui-media-body">
										六经扶阳小儿推拿操作规范
										<p class='mui-ellipsis'>左手固定住孩子手部，使推拿穴位充分暴露</p>
										<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
									</div>
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div> -->
			<div class="mui-content">
					<ul class="mui-table-view">
						<!-- <li class="mui-table-view-cell">
							<a href="anlifenxiang.jsp">
								<div class="mui-media-body">
									个案分析
								</div>
							</a>
						</li>
						 -->
						<li class="mui-table-view-cell" onclick="javascript:window.location.href='Shipintuina.jsp'">
							推拿视频
						</li>
						<!-- <li class="mui-table-view-cell" onclick="javascript:window.location.href='Shipinkecheng.jsp'">
							课程视频
						</li>
						<li class="mui-table-view-cell" onclick="javascript:window.location.href='ShipinGKK.jsp'">
							往期公开课精彩回顾
						</li> -->
						<li class="mui-table-view-cell" onclick="javascript:window.location.href='Jilaoshiwenda.jsp'">
							吉老师问答
						</li>
						<li class="mui-table-view-cell" onclick="javascript:window.location.href='jkyh_text/Caozuoguifan.jsp'">
							六经扶阳小儿推拿操作规范
						</li>
						<!-- <li class="mui-table-view-cell mui-media">
							<a href="ShiPinServlet?shipinbh=70">
								<div class="mui-media-body">
									系统操作示范
								</div>
							</a>
						</li> -->
					</ul>
			</div>
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>

