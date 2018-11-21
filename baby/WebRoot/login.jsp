<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>健康宝管理系统</title>
<script event="OnObjectReady(objObject,objAsyncContext)" for="foo">  
if(objObject.IPEnabled!=null&&objObject.IPEnabled!="undefined"&&objObject.IPEnabled == true){  
   if(objObject.MACAddress!=null&&objObject.MACAddress!="undefined"&&objObject.DNSServerSearchOrder!=null)  
       MACAddr=objObject.MACAddress;  
   if(objObject.IPEnabled&&objObject.IPAddress(0)!=null&&objObject.IPAddress(0)!="undefined"&&objObject.DNSServerSearchOrder!=null)  
       IPAddr=objObject.IPAddress(0);  
   if(objObject.DNSHostName!=null&&objObject.DNSHostName!="undefined")  
       sDNSName=objObject.DNSHostName;  
}  
</script> 

<script type="text/javascript"> 
var MACAddr; 
var IPAddr; 
var DomainAddr;  
var sDNSName;  
function init(){ 
   var service=locator.ConnectServer(); 
   service.Security_.ImpersonationLevel=3; 
   service.InstancesOfAsync(foo,'Win32_NetworkAdapterConfiguration'); 
} 
function getMac(){ 
   document.getElementById('txtMac').value=unescape(MACAddr); 
} 
</script>
	    <title>登录页</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
	    <link rel="stylesheet" href="css-changsha/mui.css">
	    <link rel="stylesheet" href="css-changsha/app.css">
	    <link rel="stylesheet" href="css-changsha/main.css">
	    <style>
	    	
			html{height: 100%;background: url(img/login_bg1.jpg);background-size:contain ;position: relative;}
	    	body{background: transparent;}
	    	.mui-content{background-color: transparent;}
	    	.mui-input-row label~input{width: 75%;}
	    	
	    	p.my-copyright{text-align: center; color: #fff; margin-top: 120px;}
	    	
	    </style>
</head>

<body>
<form action="LoginServlet" id="login_form" method="post" target="_parent" class="loading">
<div class="mui-content">
		<div class="my-login">
			<div class="my-login-bt"><img src="img/login_bt1.png" width="100%" /></div>
					<div class="mui-input-row my-login-input">
						<label class="my-login-name"><img src="img/icon_name.png" width="100%"/></label>
						<input type="text" class="mui-input-clear" name="loginName" id="loginName" placeholder="请输入账号">
					</div>
					<div class="mui-input-row my-login-input">
						<label class="my-login-name"><img src="img/icon_passwd1.png" width="100%"/></label>
						<input type="text" type="password" name="userPassword" id="userPassword" class="mui-input-password" placeholder="请输入密码">
					</div>
					<div class="mui-button-row my-login-btn">
						<button type="submit" class="mui-btn mui-btn-primary">登录</button>
						<!-- <br><br><a href="addzhucefram.jsp" class="mui-btn mui-btn-primary">注册</a> -->
					</div>
		</div>
	</div>
	<input type="hidden" id="txtMac" name="mac"/> 
	   </form>
	<script src="js-changsha/mui.min.js"></script>
		<p class="my-copyright" style="font-size:12px;margin-top:30px;color:white;">
		<!-- <p class="my-copyright"> -->
			本系统由六经扶阳派<br/>小儿推拿创始人吉亚宁老师发明<br/>并提供技术支持<br/>
			Copyright © 2015 玖壹康宁健康管理咨询<br/>
		     </p>
		     <script language="javascript" type="text/javascript" src="http://js.users.51.la/19060340.js"></script>
<noscript><a href="http://www.51.la/?19060340" target="_blank"><img alt="&#x6211;&#x8981;&#x5566;&#x514D;&#x8D39;&#x7EDF;&#x8BA1;" src="http://img.users.51.la/19060340.asp" style="border:none" /></a></noscript>
</body>

<script type="text/javascript">
$(function(){
    $('.rem').click(function(){
        $(this).toggleClass('selected');
    })
    $('#signup_select').click(function(){
        $('.form_row ul').show();
        event.cancelBubble = true;
    })
    $('#d').click(function(){
        $('.form_row ul').toggle();
        event.cancelBubble = true;
    })
    $('body').click(function(){
        $('.form_row ul').hide();
    })
    $('.form_row li').click(function(){
        var v  = $(this).text();
        $('#signup_select').val(v);
        $('.form_row ul').hide();
    })
})
</script>
</html>