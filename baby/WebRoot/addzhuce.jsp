<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ page import="com.dao.*"%>
<%@ page import="com.bean.*"%>
<!DOCTYPE html>
<html >   
<head>
<meta charset="utf-8">
    <title>用户注册</title>
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
			function doShow() {
				if(document.getElementById("phone").value == "") {
					alert("请输入手机号");
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
		              else{alert("手机号输入不正确");
		                 return false;}
				}
				var myphone= document.getElementById("phone").value;
				var uname= document.getElementById("uname").value;
				var qqweixin= document.getElementById("qqweixin").value;
				var address= document.getElementById("address").value;
				var upassword= document.getElementById("upassword").value;
				var qrpassword= document.getElementById("qrpassword").value;
				var time= document.getElementById("time").value;
				window.location.href="MagServlet?myphone="+myphone+"&uname="+uname+"&qqweixin="+qqweixin+"&address="+address+"&upassword="+upassword+"&qrpassword="+qrpassword+"&time="+time;
			}
	</script>
    
    <script type="text/javascript">
    	function changeShow(){
    		document.getElementById("duxinyz1").style.display="block";
    		document.getElementById("duxinyz2").style.display="block";
    		document.getElementById("duxinyz3").style.display="block";
    	}
    
    </script>
    <script type="text/javascript">
    	function adaptValue () {
    	
    		if(document.getElementById("uname").value == "") {
			alert("请输入姓名");
			document.getElementById("uname").focus();
			return false;
		}
    	if(document.getElementById("upassword").value == "") {
			alert("请输入密码");
			document.getElementById("upassword").focus();
			return false;
		}else{
		     var num = document.getElementById("upassword").value;
             var pass1 = /^[0-9]*$/;
             //var phone2= /^1[0-9]{10}$/;
             //var phone3=/(^(\d{3,4}-)?\d{7,8})$|(13[0-9]{9}$/
                        
               if(pass1.test(num)){
               if(document.getElementById("qrpassword").value == document.getElementById("upassword").value){
               		
               }else{alert("密码不一致！");
                 	return false;}
             }else{alert("密码不正确！");
                 return false;}
		}
    		
		if(document.getElementById("qqweixin").value == "") {
			alert("请输入微信号");
			document.getElementById("qqweixin").focus();
			return false;
		}
			
    		if(document.getElementById("address").value == "") {
			alert("请输入地址");
			document.getElementById("address").focus();
			return false;
		}
		if(document.getElementById("phone").value == "") {
			alert("请输入手机号");
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
              else{alert("手机号输入不正确");
                 return false;}
		}
		
		if(document.getElementById("yanzm").value == "") {
			alert("请输入验证码");
			document.getElementById("yanzm").focus();
			return false;
		}else if(document.getElementById("charValue").value == document.getElementById("yanzm").value){
			return true; 
		}else{
			alert("验证码不正确，请输入正确验证码!");
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

	<a class="mui-action-back mui-icon-extra mui-icon  mui-pull-left" href="login.jsp">登录页</a>
		
			<h1 class="mui-title">注册用户</h1>
	</header>
	<div class="mui-content">
		<div class="mui-content-padded">
		<form class="mui-input-group" method="post" action="AddZhuceServlet" onSubmit="return adaptValue();">
			<div class="mui-input-row">
				<label>输入姓名</label>
				<input type="text"  name="uname" id="uname"  value="${uname}" placeholder="输入姓名">
			</div>
			<div class="mui-input-row">
				<label>输入密码</label>
				<input type="text" name="upassword" id="upassword" value="${upassword}"  placeholder="密码为数字">
			</div>
			<div class="mui-input-row">
				<label>确认密码</label>
				<input type="text" name="qrpassword" id="qrpassword" value="${qrpassword}" placeholder="密码为数字">
			</div>
			<div class="mui-input-row">
				<label>QQ/微信</label>
				<input type="text" name="qqweixin" id="qqweixin" value="${qqweixin}" placeholder="输入QQ/微信">
			</div>
			<div class="mui-input-row">
				<label>输入地址</label>
				<input type="text" name="address" id="address" value="${address}" placeholder="输入地址">
			</div>
			<div class="mui-input-row">
				<label>手机号码</label>
				<input type="hidden" name="charValue" id="charValue" value="${charValue}">
				<input type="hidden" name="time" id="time" value="${time}">
				<input type="text" name="phone" id="phone" onclick="changeShow();" value="${myphone}" placeholder="手机号为登录账号">
			</div>
			
			<div class="mui-input-row" id="duxinyz2">
				<label>输入验证码</label>
				<input type="text" name="yanzm" id="yanzm"  placeholder="输入验证码">
			</div>
			<div class="mui-input-row">
				<label></label>
				<div onClick="doShow();" style="color:red;" id="duxinyz3">获取验证码</div>
			</div>
			<!-- <div class="mui-input-row">
				<label>选择权限</label>
				<select name="upower">
	               <option value="1" >普通用户</option>
	               <option value="3" >游客</option>
             </select>	
			</div>
			<div class="mui-input-row">
				<label>输入次数</label>
				<input type="text" name="moneys" id="moneys"  placeholder="输入次数">
			</div>
			<div class="mui-input-row">
				<label>选择到期时间</label>
				<input type="text" name="jieshutime" id="jieshutime" onclick="fPopCalendar(event,this,this);"/>
			</div> -->
			 <button type="submit" class="mui-btn my-btn mui-btn-block">注册</button>
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