<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
	    <link rel="stylesheet" href="dep-td/css/ydui.css" />
        <script src="dep-td/js/ydui.flexible.js"></script>
        <link rel="stylesheet" type="text/css" href="css-td/health.css" />
	    <style type="text/css">
        .btn-list{
             display: flex;
    		width: 80%;
    		margin-left: 10%;
            
        }
        
        .btn-list .login-btn{
			width:2rem
			}
    </style>
	    
</head>

<body>
<form action="LoginServlet" id="login_form" method="post" target="_parent" class="loading">
	<div class="g-flexview">
            <div class="g-scrollview bgc-img">
                <div class="log">
                    <img class="logo" src="img/logotd.png" />
                    <img class="name" src="img/title.png" />
                </div>

                <div class="m-cell login-input">
                    <div class="cell-item bgc-input">
                        <div class="cell-left "><img src="img/user.png" /></div>
                        <div class="cell-right"><input name="loginName" id="loginName" type="text" class="cell-input" placeholder="请输入您的账号" autocomplete="off" /></div>
                    </div>
                    <div class="cell-item bgc-input">
                        <div class="cell-left"><img src="img/pass.png" /></div>
                        <div class="cell-right"><input name="userPassword" id="userPassword" type="password" class="cell-input" placeholder="请输入您的密码" autocomplete="off" /></div>
                    </div>
                </div>
				<div class="btn-list">
				    <input name="pId" id="pId" type="hidden" value="${param.pid}" />
	                <button id="submit" type="submit" class="btn-block btn-primary login-btn">登录</button>
	                <a href="addzhuce.jsp?pid=${param.pid}" class="btn-block btn-primary login-btn">注册</a> 
	            </div>
                 <div class="btm-text">
                    <p>本系统由六经扶阳派小儿推拿</p>
                    <p>创始人吉亚宁老师发明并提供技术支持</p>
                    <p>Copyright 2018 玖壹康宁健康咨询管理</p>
                </div>
            </div>
            
        </div>
	<input type="hidden" id="txtMac" name="mac"/> 
	   </form>
	 <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="dep-td/js/ydui.js"></script>
        <script type="text/javascript">
            $('#submit').click(function() {
                var acc = $('#account').val(),
                    pass = $('#password').val();
                if(acc == '') {
                    YDUI.dialog.toast('请填写您的账号', 'none', 1000);
                    return false;
                }
                if(pass == '') {
                    YDUI.dialog.toast('请填写您的密码', 'none', 1000);
                    return false;
                }
            })
             $(document).ready(function() {
                $('body').height($('body')[0].clientHeight);
            });
        </script>
		
	 <script language="javascript" type="text/javascript" src="http://js.users.51.la/19060340.js"></script>
<noscript><a href="http://www.51.la/?19060340" target="_blank"><img alt="&#x6211;&#x8981;&#x5566;&#x514D;&#x8D39;&#x7EDF;&#x8BA1;" src="http://img.users.51.la/19060340.asp" style="border:none" /></a></noscript>
</body>
</html>