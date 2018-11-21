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
    <script type="text/javascript">
    	function adaptValue () {
    	
    		if(document.getElementById("account").value == "") {
			alert("请输入家长姓名");
			document.getElementById("account").focus();
			return false;
		}
    		
    		if(document.getElementById("time").value == "") {
			alert("请输入年龄");
			document.getElementById("time").focus();
			return false;
		}
    		
    		if(document.getElementById("iphone").value == "") {
			alert("请输入联系方式");
			document.getElementById("iphone").focus();
			return false;
		}
		else{
		     var num = document.getElementById("iphone").value;
             var phone1 = /^1[3,5]\d{9}$/;
             var phone2= /^1[0-9]{10}$/;
             //var phone3=/(^(\d{3,4}-)?\d{7,8})$|(13[0-9]{9}$/
                        
               if(phone1.test(num)||phone2.test(num)){
             }
              else{alert("联系方式输入不正确");
                 return false;}
		}
		
			if(document.getElementById("name").value == "") {
				alert("请输入家长姓名");
				document.getElementById("name").focus();
				return false;
			}
			
    		if(document.getElementById("address").value == "") {
			alert("请输入地址");
			document.getElementById("address").focus();
			return false;
		}
		
		if(document.getElementById("qqhao").value == "") {
			alert("请输入QQ号");
			document.getElementById("qqhao").focus();
			return false;
		}
		
		if(document.getElementById("weixinhao").value == "") {
			alert("请输入微信号");
			document.getElementById("weixinhao").focus();
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
		
			<h1 class="mui-title">信息录入</h1>
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
		<div class="mui-content-padded">
		<form class="mui-input-group" method="post" action="SavePatientXinxiServlet" onSubmit="return adaptValue();">
			<div class="mui-input-row">
				<label>家长姓名</label>
				<input type="text" name="ppname" id="name"  placeholder="输入家长姓名">
			</div>
			<div class="mui-input-row">
				<label>联系电话</label>
				<input type="text" name="pphone" id="iphone" placeholder="输入联系电话">
			</div>
			<div class="mui-input-row">
				<label>宝宝姓名</label>
				<input type="text" name="pname" id="account" placeholder="输入宝宝姓名">
			</div>
			<div class="mui-input-row">
				<label>宝宝性别</label>
				<div class="mui-radio my-radio">男 <input name="pxb" type="radio" value="男" checked="checked"></div> 
				<div class="mui-radio my-radio">女 <input name="pxb" type="radio" value="女"></div>
			</div>
			<div class="mui-input-row">
				<label>宝宝年龄</label>
				<input type="text" name="page" id="time" placeholder="输入宝宝年龄">
			</div>
			<div class="mui-input-row">
				<label>家长微信</label>
				<input type="text" name="weixin" id="weixinhao"  placeholder="输入家长微信">
			</div>
			<div class="mui-input-row">
				<label>地址</label>
				<input type="text" name="paddress" id="address" placeholder="输入地址">
			</div>
			 <button type="submit" class="mui-btn my-btn mui-btn-block">提交</button>
		</form>
	    </div>
	</div>
	<script src="js-changsha/mui.min.js"></script>
	<script src="js-changsha/mui.picker.js"></script>
	<script src="js-changsha/mui.poppicker.js"></script>
	<script src="js-changsha/city.data.js" type="text/javascript" charset="utf-8"></script>
	<script src="js-changsha/city.data-3.js" type="text/javascript" charset="utf-8"></script>
	
</body>
</html>