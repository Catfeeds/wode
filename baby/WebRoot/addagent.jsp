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
     <script type="text/javascript" src="js/date.js"></script>
    <script type="text/javascript">
    	
   		document.addEventListener('plusready', function(){
   			//console.log("所有plus api都应该在此事件发生后调用，否则会出现plus is undefined。"
   			
   		});
   		
    </script>
    <script type="text/javascript">
    	function adaptValue () {
    	
    		if(document.getElementById("uname").value == "") {
			alert("请输入家长姓名");
			document.getElementById("uname").focus();
			return false;
		}
    		
    		if(document.getElementById("phone").value == "") {
			alert("请输入联系方式");
			document.getElementById("phone").focus();
			return false;
		}
		else{
		     var num = document.getElementById("phone").value;
             var phone1 = /^1[3,5]\d{9}$/;
             var phone2= /^1[0-9]{10}$/;
             //var phone3=/(^(\d{3,4}-)?\d{7,8})$|(13[0-9]{9}$/
                        
               if(phone1.test(num)||phone2.test(num)){
             }
              else{alert("联系方式输入不正确");
                 return false;}
		}
		if(document.getElementById("qqweixin").value == "") {
			alert("请输入微信号");
			document.getElementById("qqweixin").focus();
			return false;
		}
			
    		/* if(document.getElementById("address").value == "") {
			alert("请输入地址");
			document.getElementById("address").focus();
			return false;
		} */
		if(document.getElementById("moneys").value == "") {
			alert("请输入系统使用次数");
			document.getElementById("moneys").focus();
			return false;
		}else{
		     var num = document.getElementById("moneys").value;
             var phone1 = /^\d+$/;
             //var phone3=/(^(\d{3,4}-)?\d{7,8})$|(13[0-9]{9}$/
                        
               if(phone1.test(num)){
             }
              else{alert("次数请输入数字");
                 return false;}
		}
		/* if(document.getElementById("course").value == "") {
			alert("请输入购买疗程数");
			document.getElementById("course").focus();
			return false;
		}else{
		     var num = document.getElementById("course").value;
             var phone1 = /^\d+$/;
             //var phone3=/(^(\d{3,4}-)?\d{7,8})$|(13[0-9]{9}$/
                        
               if(phone1.test(num)){
             }
              else{alert("次数请输入数字");
                 return false;}
		} */
		
		if(document.getElementById("jieshutime").value == "") {
			alert("请选择系统到期时间");
			document.getElementById("jieshutime").focus();
			return false;
		}
		/* if(document.getElementById("coursestart").value == "") {
			alert("请选择疗程开始时间");
			document.getElementById("coursestart").focus();
			return false;
		}
		if(document.getElementById("courseend").value == "") {
			alert("请选择疗程结束时间");
			document.getElementById("courseend").focus();
			return false;
		} */
		
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
	    <a class="mui-tab-item-link" href="chanpinjieshao.jsp">
	      <span class="mui-icon my-nav-icon-6"></span>
	      <span class="mui-tab-label">足贴科普</span>
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
		<form class="mui-input-group" method="post" action="AddAgentServlet" onSubmit="return adaptValue();">
			<div class="mui-input-row">
				<label>输入姓名</label>
				<input type="text"  name="uname" id="uname"   placeholder="输入家长姓名">
			</div>
			<div class="mui-input-row">
				<label>联系电话</label>
				<input type="text" name="phone" id="phone" placeholder="输入联系电话">
			</div>
			<div class="mui-input-row">
				<label>输入QQ/微信</label>
				<input type="text" name="qqweixin" id="qqweixin" placeholder="输入QQ/微信">
			</div>
			<!-- <div class="mui-input-row">
				<label>输入地址</label>
				<input type="text" name="address" id="address" placeholder="输入地址">
			</div> -->
			<div class="mui-input-row">
				<label>选择权限</label>
				<select name="upower">
	               <option value="1" >VIP会员</option>
	               <option value="2" >七天会员</option>
	               <option value="3" >游客</option>
             </select>	
			</div>
			<div class="mui-input-row">
				<label>选择助教老师</label>
				<select name="zhujiao">
					<option value="01_总部" >总部</option>
	                <option value="02_孙婉" >孙婉</option>
	                <option value="03_韩笛" >韩笛</option>
	               
             	</select>	
			</div>
			<div class="mui-input-row">
				<label>输入系统使用次数</label>
				<input type="text" name="moneys" id="moneys"  placeholder="输入系统使用次数">
			</div>
			<div class="mui-input-row">
				<label>选择系统到期时间</label>
				<input type="text" name="jieshutime" id="jieshutime" onclick="fPopCalendar(event,this,this);"/>
			</div>
			<!-- <div class="mui-input-row">
				<label>购买疗程数</label>
				<input type="text" name="course" id="course"  placeholder="输入购买疗程数">
			</div>
			<div class="mui-input-row">
				<label>疗程开始时间</label>
				<input type="text" name="coursestart" id="coursestart"  onclick="fPopCalendar(event,this,this);">
			</div>
			<div class="mui-input-row">
				<label>疗程结束时间</label>
				<input type="text" name="courseend" id="courseend"  onclick="fPopCalendar(event,this,this);">
			</div> -->
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