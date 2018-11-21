<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.dao.*"%>
<%@ page import="com.bean.*"%>
    <%
	User user =(User)request.getSession().getAttribute("user");
	//未登录状态
	if (user == null) { 
		response.sendRedirect("xuanzejiemian.jsp");
		return;
	} else {
	
	}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>个人中心</title>
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
	<nav class="mui-bar mui-bar-tab">
	    <a class="mui-tab-item-link" href="xuanzejiemian.jsp">
	      <span class="mui-icon my-nav-icon-1"></span>
	      <span class="mui-tab-label">辩证取穴</span>
	    </a>
	    <a class="mui-tab-item-link" href="jiankangyanghu.jsp">
	      <span class="mui-icon my-nav-icon-2"></span>
	      <span class="mui-tab-label">健康养护</span>
	    </a>
	    <a class="mui-tab-item-link" href="yuerketang.jsp">
	      <span class="mui-icon my-nav-icon-3"></span>
	      <span class="mui-tab-label">育儿课堂</span>
	    </a>
	    <a class="mui-tab-item-link mui-active" href="personal-center.jsp">
	      <span class="mui-icon my-nav-icon-4"></span>
	      <span class="mui-tab-label">我的</span>
	    </a>
 	 </nav>
	<div class="mui-content">
		<div class="my-user-top">
			<div class="my-user-img"><img src="img/user-img.png" width="100%" /></div>
			<div class="my-user-info">
				<p class="my-user-name">${user.uname}</p>
				<p class="my-user-text">欢迎来到健康宝管理系统！</p>
			</div>
		</div>
		<ul class="mui-table-view">
			<%
				 if(user.getUpower()==0||user.getUpower()==1||user.getUpower()==2){
				    %>
				<li class="mui-table-view-cell">
					<a class="mui-navigate-right" href="inputxinxi.jsp">
						<span class="my-iconfont my-user-icon"><em class="my-iconfont "></em></span>信息录入
					</a>
				</li>
				<%
			       }
			       %>
				<li class="mui-table-view-cell">
					<a class="mui-navigate-right" href="SearchPatientXinxiServlet?w=1">
						<span class="my-iconfont my-user-icon"><em class="my-iconfont "></em></span>健康档案
					</a>
				</li>
				<li class="mui-table-view-cell">
					<a class="mui-navigate-right" href="Fankuiyijian.jsp">
						<span class="my-iconfont my-user-icon"><em class="my-iconfont "></em></span>反馈意见
					</a>
				</li>
				<li class="mui-table-view-cell">
					<a class="mui-navigate-right" href="changepass.jsp">
						<span class="my-iconfont my-user-icon"><em class="my-iconfont "></em></span>修改密码
					</a>
				</li>
				<li class="mui-table-view-cell">
					<a class="mui-navigate-right" href="ExitServlet">
						<span class="my-iconfont my-user-icon"><em class="my-iconfont "></em></span>退出
					</a>
				</li>
				<%
				 if(user.getUpower()==0){
				    %>
			    <li class="mui-table-view-cell">
					<a class="mui-navigate-right" href="SearchAgentServlet?w=1">
						<span class="my-iconfont my-user-icon"><em class="my-iconfont my-icon-shujuluru"></em></span>会员查看和添加
					</a>
				</li>
			       <%
			       }
			       %>
			       <%
				 if(user.getUserid()==2){
				    %>
			    <li class="mui-table-view-cell">
					<a class="mui-navigate-right" href="addzhucefram.jsp">
						<span class="my-iconfont my-user-icon"><em class="my-iconfont my-icon-shujuluru"></em></span>用户注册
					</a>
				</li>
			       <%
			       }
			       %>
			      
			</ul>
	</div>
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>