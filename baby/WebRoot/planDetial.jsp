<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.dao.*"%>
<%@ page import="com.bean.*"%>
    <%
	User user =(User)request.getSession().getAttribute("user");
	//未登录状态  未登录状态 
	if (user!=null) { 
		
	} else {
		response.sendRedirect("login.jsp");
		return;
	}
	%>
<!DOCTYPE html>
<html>
<head>
<%
	java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	java.util.Date currentTime = new java.util.Date();
	String time = simpleDateFormat.format(currentTime).toString(); //放到页面的head中}
%>
	<meta charset="utf-8">
    <title>健康档案</title>
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
	<a class="mui-icon mui-icon-extra mui-pull-left"></a>
		
			<h1 class="mui-title">健康档案</h1>
	</header>
	<nav class="mui-bar mui-bar-tab">
	    <a class="mui-tab-item-link mui-active" href="xuanzejiemian.jsp">
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
	    <a class="mui-tab-item-link" href="personal-center.jsp">
	      <span class="mui-icon my-nav-icon-4"></span>
	      <span class="mui-tab-label">我的</span>
	    </a>
 	 </nav>

	<div class="mui-content">
		<div class="my-txt-bg">
			<div class="mui-pull-left"><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em></span>${nowTime }</div> 
			<div class="mui-pull-right">编号：${pid }</div>                           
		</div>
		<div class="my-txt-box">
			<div class="my-ts-content">
				<p style="padding: 0;">宝宝姓名：${pname } &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;宝贝年龄：${age}</p>
			</div>
			<!--<div class="my-ts-content">
				<p class="my-low-bt"><b>判断结果:</b></p>
				<p>${chufang }</p>
			</div>
			 <div class="my-ts-content">
				<p class="my-low-bt"><b>判断依据:</b></p>
				<p> ${str2 }
				</p>
			</div> -->
			<div class="my-ts-content">
				<p class="my-low-bt"><b>推拿建议：</b></p>
				<p class="mui-tab-label"> ${shoufa }<br/>
					注：+为补，-为清，+-为清补，无加减号为揉法，前二位为穴位代码，后三位数为推拿次数。
					</p>
				<p>推拿视频：</p>
				<div class="my-video-box mui-segmented-control">
				<%
					if(request.getSession().getAttribute("sumitem1") == null||request.getSession().getAttribute("sumitem1").equals(null)||request.getSession().getAttribute("sumitem1").equals("")||request.getSession().getAttribute("sumitem1") == ""){
				 %>
				<%}else{ %>
						<a class="mui-control-item my-date-icon mui-active" href="#sp1"><em class="my-iconfont my-icon-font43"></em>${sumitem1}</a>
				<%} %>	
				
				<%
					if(request.getSession().getAttribute("sumitem2") == null||request.getSession().getAttribute("sumitem2").equals(null)||request.getSession().getAttribute("sumitem2").equals("")||request.getSession().getAttribute("sumitem2") == ""){
				 %>
				<%}else{ %>
						<a class="mui-control-item my-date-icon" href="#sp2"><em class="my-iconfont my-icon-font43"></em>${sumitem2}</a>
				<%} %>	
				
				<%
					if(request.getSession().getAttribute("sumitem3") == null||request.getSession().getAttribute("sumitem3").equals(null)||request.getSession().getAttribute("sumitem3").equals("")||request.getSession().getAttribute("sumitem3") == ""){
				 %>
				<%}else{ %>
						<a class="mui-control-item my-date-icon" href="#sp3"><em class="my-iconfont my-icon-font43"></em>${sumitem3}</a>
				<%} %>	
					
				<%
					if(request.getSession().getAttribute("sumitem4") == null||request.getSession().getAttribute("sumitem4").equals(null)||request.getSession().getAttribute("sumitem4").equals("")||request.getSession().getAttribute("sumitem4") == ""){
				 %>
				<%}else{ %>
						<a class="mui-control-item my-date-icon" href="#sp4"><em class="my-iconfont my-icon-font43"></em>${sumitem4}</a>
				<%} %>	
				
				<%
					if(request.getSession().getAttribute("sumitem5") == null||request.getSession().getAttribute("sumitem5").equals(null)||request.getSession().getAttribute("sumitem5").equals("")||request.getSession().getAttribute("sumitem5") == ""){
				 %>
				<%}else{ %>
						<a class="mui-control-item my-date-icon" href="#sp5"><em class="my-iconfont my-icon-font43"></em>${sumitem5}</a>
				<%} %>	
				
				<%
					if(request.getSession().getAttribute("sumitem6") == null||request.getSession().getAttribute("sumitem6").equals(null)||request.getSession().getAttribute("sumitem6").equals("")||request.getSession().getAttribute("sumitem6") == ""){
				 %>
				<%}else{ %>
						<a class="mui-control-item my-date-icon" href="#sp6"><em class="my-iconfont my-icon-font43"></em>${sumitem6}</a>
				<%} %>	
				
				<%
					if(request.getSession().getAttribute("sumitem7") == null||request.getSession().getAttribute("sumitem7").equals(null)||request.getSession().getAttribute("sumitem7").equals("")||request.getSession().getAttribute("sumitem7") == ""){
				 %>
				<%}else{ %>
						<a class="mui-control-item my-date-icon" href="#sp7"><em class="my-iconfont my-icon-font43"></em>${sumitem7}</a>
				<%} %>	
					
				</div>
				 <div class="mui-control-content mui-active" id="sp1">
					<video controls="controls" width="100%" height="300px" preload="metadata" poster="${img1}">
			            <source src="${shipin1 }" type="video/mp4"></source>
			        </video>
				</div>
				<div class="mui-control-content" id="sp2">
					<video controls="controls" width="100%" height="300px" preload="metadata" poster="${img2}">
			            <source src="${shipin2 }" type="video/mp4"></source>
			        </video>
				</div>
				<div class="mui-control-content" id="sp3">
					<video controls="controls" width="100%" height="300px" preload="metadata" poster="${img3}">
			            <source src="${shipin3 }" type="video/mp4"></source>
			        </video>
				</div>
				<div class="mui-control-content" id="sp4">
					<video controls="controls" width="100%" height="300px" preload="metadata" poster="${img4}">
			            <source src="${shipin4 }" type="video/mp4"></source>
			        </video>
				</div>
				<div class="mui-control-content" id="sp5">
					<video controls="controls" width="100%" height="300px" preload="metadata" poster="${img5}">
			            <source src="${shipin5 }" type="video/mp4"></source>
			        </video>
				</div>
				<div class="mui-control-content" id="sp6">
					<video controls="controls" width="100%" height="300px" preload="metadata" poster="${img6}">
			            <source src="${shipin6 }" type="video/mp4"></source>
			        </video>
				</div>
				<div class="mui-control-content" id="sp7">
					<video controls="controls" width="100%" height="300px" preload="metadata" poster="${img7}">
			            <source src="${shipin7 }" type="video/mp4"></source>
			        </video>
				</div>
				
			</div>
			<div class="my-ts-content">
				<p class="my-low-bt"><b>操作注意事项：  </b></p>
				<p> 1、本次推拿时间为3-5分钟 <br/>
					2、积食、便秘、保健、每日推拿1次；感冒、发烧、剧烈咳嗽，每日可推拿1~2次，建议高烧及剧烈咳嗽症状及时到医院检查。  <br/>
					3、每分钟推拿100次左右  <br/>
					4、按所出穴位顺序依次推拿，两次推拿间隔不得低于4小时。
				</p>
			</div>
			<div class="my-ts-content">
				<p class="my-low-bt"><b>护理建议：  </b></p>
				<p>${hulizhuyi } </p>
			</div>
			<div class="my-ts-content">
				<p class="my-low-bt"><b>提示：  </b></p>
				<p> 1、发烧38.5度以上，要及时去医院就诊 。<br/>
					2、手脚冰凉的孩子必然会高热，要及时去医院就诊。  <br/>
					3、孩子腹痛时间超过10分钟,要及时去医院就诊。<br/>
					4、发现孩子鼻梁暗滞时，孩子可能是鼻炎。<br/>
					5、此系统只作为保健使用。
				</p>
			</div>
		</div>
	</div>
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>
