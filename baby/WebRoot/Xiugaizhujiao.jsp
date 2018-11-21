<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ page import="com.dao.*"%>
<%@ page import="com.bean.*"%>
<%
	User myUser =(User)request.getSession().getAttribute("user");
	//未登录状态
	if (myUser == null) { 
		response.sendRedirect("xuanzejiemian.jsp");
		return;
	} else {
	
	}
	String uid=request.getParameter("uid");
	String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
	String xzhujiao=new String(request.getParameter("xzhujiao").getBytes("ISO-8859-1"),"UTF-8");
%>
<!DOCTYPE html>
<html >   
<head>
<meta charset="utf-8">
    <title>信息录入</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="css-changsha/mui.css">
    <link href="css-changsha/mui.picker.css" rel="stylesheet" />
	<link href="css-changsha/mui.poppicker.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="css-changsha/icons-extra.css" />
    <link rel="stylesheet" href="css-changsha/main.css">
    <script type="text/javascript">
    	
   		document.addEventListener('plusready', function(){
   			//console.log("所有plus api都应该在此事件发生后调用，否则会出现plus is undefined。"
   			
   		});
   		
    </script>
</head>
<body>
	<header id="header" class="mui-bar mui-bar-nav">

	<a class="mui-action-back mui-icon-extra mui-icon-extra-arrowleftcricle mui-icon  mui-pull-left"></a>
		
			<h1 class="mui-title">时间修改</h1>
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
		<form class="mui-input-group" method="post" action="XiuGaiZhujiaoServlet">
			<div class="mui-input-row">
				<label>姓名</label>
				<input type="hidden" name="uid" value="<%=uid %>">
				<input type="text" name="ppname" id="name" readonly="true" value="<%=name %>" >
			</div>
			<div class="mui-input-row">
				<label>现任助教</label>
				<input type="text" name="xzhujiao" id="xzhujiao" readonly="true" value="<%=xzhujiao %>" >
			</div>
			<div class="mui-input-row">
				<label>选择助教</label>
				<select name="zhujiao">
	               <option value="26_文霞" >文霞</option>
	               <option value="31_孙基建" >孙基建</option>
	               <option value="25_方清清" >方清清</option>
	               <option value="15_张小三" >张小三</option>
	               <option value="16_张凯" >张凯</option>
	               <option value="11_李兵林" >李兵林</option>
	               <option value="20_吴佳丰" >吴佳丰</option>
	               <option value="18_杨柳" >杨柳</option>
	               <option value="13_童洋" >童洋</option>
	               <option value="1_江爱蓉" >江爱蓉</option>
             </select>	
			</div>
			 <button type="submit" class="mui-btn my-btn mui-btn-block">提交</button>
		</form>
		
	</div>
	<script src="js-changsha/mui.min.js"></script>
	<script src="js-changsha/mui.picker.js"></script>
	<script src="js-changsha/mui.poppicker.js"></script>
	<script src="js-changsha/city.data.js" type="text/javascript" charset="utf-8"></script>
	<script src="js-changsha/city.data-3.js" type="text/javascript" charset="utf-8"></script>
	
</body>
</html>