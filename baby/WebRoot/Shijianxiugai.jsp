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
	String starttime=request.getParameter("starttime");
	String ystime=request.getParameter("ystime");
	String zhucetime=request.getParameter("zhucetime");
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
    <script type="text/javascript" src="js/date.js"></script>
    <script type="text/javascript">
    	
   		document.addEventListener('plusready', function(){
   			//console.log("所有plus api都应该在此事件发生后调用，否则会出现plus is undefined。"
   			
   		});
   		
    </script>
    <script type="text/javascript">
    	function adaptValue () {
    	
    	if(document.getElementById("starttime").value == "") {
			alert("请选择注册时间");
			document.getElementById("starttime").focus();
			return false;
		}
    	
    		if(document.getElementById("jieshutime").value == "") {
			alert("请选择到期时间");
			document.getElementById("jieshutime").focus();
			return false;
		}
    			//校验数据
    			//数据合法返回true，否则返回false，并提示用户
    			return true;
    		}
    		
    
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
		<form class="mui-input-group" method="post" action="ShiJianXiuGaiServlet" onSubmit="return adaptValue();">
			<div class="mui-input-row">
				<label>姓名</label>
				<input type="hidden" name="uid" value="<%=uid %>">
				<input type="text" name="ppname" id="name" readonly="true" value="<%=name %>" >
			</div>
			<div class="mui-input-row">
				<label>选择权限</label>
				<select name="upower">
	               <option value="1" >VIP会员</option>
	               <option value="2" >七天会员</option>
	               <option value="3" >游客</option>
             </select>	
			</div>
			<div class="mui-input-row">
				<label>注册时间</label>
				<input type="text" name="zhucetime" id="zhucetime" readonly="true" value="<%=zhucetime %>"/>
			</div>
			<div class="mui-input-row">
				<label>开始时间</label>
				<input type="text" name="zhucetime" id="zhucetime" readonly="true" value="<%=starttime %>"/>
			</div>
			<div class="mui-input-row">
				<label>修改开始时间</label>
				<input type="text" name="starttime" id="starttime" value="<%=starttime %>" onclick="fPopCalendar(event,this,this);"/>
			</div>
			<div class="mui-input-row">
				<label>选择到期时间</label>
				<input type="text" name="jieshutime" id="jieshutime" value="<%=ystime %>" onclick="fPopCalendar(event,this,this);"/>
			</div>
			 <button type="submit" class="mui-btn my-btn mui-btn-block" onclick="adaptValue()">提交</button>
		</form>
		
	</div>
	<script src="js-changsha/mui.min.js"></script>
	<script src="js-changsha/mui.picker.js"></script>
	<script src="js-changsha/mui.poppicker.js"></script>
	<script src="js-changsha/city.data.js" type="text/javascript" charset="utf-8"></script>
	<script src="js-changsha/city.data-3.js" type="text/javascript" charset="utf-8"></script>
	
</body>
</html>