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
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <meta charset="utf-8">
    <title>推拿视频</title>
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
			<h1 class="mui-title ">推拿视频</h1>
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
	<div class="mui-content">
		<ul class="mui-table-view">
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=1">
						<img class="mui-media-object mui-pull-left" src="img/tn/1.png">
						<div class="mui-media-body">
							01吉祥穴
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=2">
						<img class="mui-media-object mui-pull-left" src="img/tn/2.png">
						<div class="mui-media-body">
							02如意穴
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=3">
						<img class="mui-media-object mui-pull-left" src="img/tn/3.png">
						<div class="mui-media-body">
							03一窝蜂穴
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=4">
						<img class="mui-media-object mui-pull-left" src="img/tn/4.png">
						<div class="mui-media-body">
							04新一扇门穴
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=5">
						<img class="mui-media-object mui-pull-left" src="img/tn/5.png">
						<div class="mui-media-body">
							05感冒点
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=6">
						<img class="mui-media-object mui-pull-left" src="img/tn/6.png">
						<div class="mui-media-body">
							06清热点
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=7">
						<img class="mui-media-object mui-pull-left" src="img/tn/7.png">
						<div class="mui-media-body">
							07外关穴
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=8">
						<img class="mui-media-object mui-pull-left" src="img/tn/8.png">
						<div class="mui-media-body">
							08阳明穴
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=9">
						<img class="mui-media-object mui-pull-left" src="img/tn/9.png">
						<div class="mui-media-body">
							09大肠点
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=10">
						<img class="mui-media-object mui-pull-left" src="img/tn/10.png">
						<div class="mui-media-body">
							10阳池穴
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=11">
						<img class="mui-media-object mui-pull-left" src="img/tn/11.png">
						<div class="mui-media-body">
							11泰山点
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=12">
						<img class="mui-media-object mui-pull-left" src="img/tn/12.png">
						<div class="mui-media-body">
							12板门
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=13">
						<img class="mui-media-object mui-pull-left" src="img/tn/13.png">
						<div class="mui-media-body">
							13咽喉点
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=14">
						<img class="mui-media-object mui-pull-left" src="img/tn/14.png">
						<div class="mui-media-body">
							14灵泉穴
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=15">
						<img class="mui-media-object mui-pull-left" src="img/tn/15.png">
						<div class="mui-media-body">
							15大肠穴
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=16">
						<img class="mui-media-object mui-pull-left" src="img/tn/16.png">
						<div class="mui-media-body">
							16鼻出血点
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=17">
						<img class="mui-media-object mui-pull-left" src="img/tn/17.png">
						<div class="mui-media-body">
							17合谷
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=18">
						<img class="mui-media-object mui-pull-left" src="img/tn/18.png">
						<div class="mui-media-body">
							18脾经
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=19">
						<img class="mui-media-object mui-pull-left" src="img/tn/19.png">
						<div class="mui-media-body">
							19二马穴
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=20">
						<img class="mui-media-object mui-pull-left" src="img/tn/20.png">
						<div class="mui-media-body">
							20头痛点
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=21">
						<img class="mui-media-object mui-pull-left" src="img/tn/21.png">
						<div class="mui-media-body">
							21脾点
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=22">
						<img class="mui-media-object mui-pull-left" src="img/tn/22.png">
						<div class="mui-media-body">
							22液门
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=23">
						<img class="mui-media-object mui-pull-left" src="img/tn/23.png">
						<div class="mui-media-body">
							23肝点
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=24">
						<img class="mui-media-object mui-pull-left" src="img/tn/24.png">
						<div class="mui-media-body">
							24外劳宫
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=25">
						<img class="mui-media-object mui-pull-left" src="img/tn/25.png">
						<div class="mui-media-body">
							25胃经
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=26">
						<img class="mui-media-object mui-pull-left" src="img/tn/26.png">
						<div class="mui-media-body">
							26扁桃体点
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=27">
						<img class="mui-media-object mui-pull-left" src="img/tn/27.png">
						<div class="mui-media-body">
							27膈点
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=28">
						<img class="mui-media-object mui-pull-left" src="img/tn/28.png">
						<div class="mui-media-body">
							28总筋
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=29">
						<img class="mui-media-object mui-pull-left" src="img/tn/29.png">
						<div class="mui-media-body">
							29内劳宫
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=30">
						<img class="mui-media-object mui-pull-left" src="img/tn/30.png">
						<div class="mui-media-body">
							30掌小横纹
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=31">
						<img class="mui-media-object mui-pull-left" src="img/tn/31.png">
						<div class="mui-media-body">
							31小肠
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=32">
						<img class="mui-media-object mui-pull-left" src="img/tn/32.png">
						<div class="mui-media-body">
							32小天心
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=33">
						<img class="mui-media-object mui-pull-left" src="img/tn/33.png">
						<div class="mui-media-body">
							33夜尿穴
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=34">
						<img class="mui-media-object mui-pull-left" src="img/tn/34.png">
						<div class="mui-media-body">
							34上焦
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=35">
						<img class="mui-media-object mui-pull-left" src="img/tn/35.png">
						<div class="mui-media-body">
							35肾顶
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=36">
						<img class="mui-media-object mui-pull-left" src="img/tn/36.png">
						<div class="mui-media-body">
							36内关
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=37">
						<img class="mui-media-object mui-pull-left" src="img/tn/37.png">
						<div class="mui-media-body">
							37三焦
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=38">
						<img class="mui-media-object mui-pull-left" src="img/tn/38.png">
						<div class="mui-media-body">
							38小肠点
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=39">
						<img class="mui-media-object mui-pull-left" src="img/tn/39.png">
						<div class="mui-media-body">
							39肝经
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=40">
						<img class="mui-media-object mui-pull-left" src="img/tn/40.png">
						<div class="mui-media-body">
							40心经
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=41">
						<img class="mui-media-object mui-pull-left" src="img/tn/41.png">
						<div class="mui-media-body">
							41肺经
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=42">
						<img class="mui-media-object mui-pull-left" src="img/tn/42.png">
						<div class="mui-media-body">
							42肾经
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=43">
						<img class="mui-media-object mui-pull-left" src="img/tn/43.png">
						<div class="mui-media-body">
							43肾纹
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=44">
						<img class="mui-media-object mui-pull-left" src="img/tn/44.png">
						<div class="mui-media-body">
							44四横纹
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=45">
						<img class="mui-media-object mui-pull-left" src="img/tn/45.png">
						<div class="mui-media-body">
							45内八卦
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=46">
						<img class="mui-media-object mui-pull-left" src="img/tn/46.png">
						<div class="mui-media-body">
							46运水入土
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=47">
						<img class="mui-media-object mui-pull-left" src="img/tn/47.png">
						<div class="mui-media-body">
							47阴池穴
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=48">
						<img class="mui-media-object mui-pull-left" src="img/tn/48.png">
						<div class="mui-media-body">
							48咳喘
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=49">
						<img class="mui-media-object mui-pull-left" src="img/tn/49.png">
						<div class="mui-media-body">
							49胃肠痛点
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=50">
						<img class="mui-media-object mui-pull-left" src="img/tn/50.png">
						<div class="mui-media-body">
							50命门
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=51">
						<img class="mui-media-object mui-pull-left" src="img/tn/51.png">
						<div class="mui-media-body">
							51一扇门
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=52">
						<img class="mui-media-object mui-pull-left" src="img/tn/52.png">
						<div class="mui-media-body">
							52两扇门
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=53">
						<img class="mui-media-object mui-pull-left" src="img/tn/53.png">
						<div class="mui-media-body">
							53十宣
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=54">
						<img class="mui-media-object mui-pull-left" src="img/tn/54.png">
						<div class="mui-media-body">
							54五指节
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=55">
						<img class="mui-media-object mui-pull-left" src="img/tn/55.png">
						<div class="mui-media-body">
							55外八卦
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=56">
						<img class="mui-media-object mui-pull-left" src="img/tn/56.png">
						<div class="mui-media-body">
							56列缺
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=57">
						<img class="mui-media-object mui-pull-left" src="img/tn/57.png">
						<div class="mui-media-body">
							57三关
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=58">
						<img class="mui-media-object mui-pull-left" src="img/tn/58.png">
						<div class="mui-media-body">
							58六腑
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=59">
						<img class="mui-media-object mui-pull-left" src="img/tn/59.png">
						<div class="mui-media-body">
							59天河水
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=60">
						<img class="mui-media-object mui-pull-left" src="img/tn/60.png">
						<div class="mui-media-body">
							60威灵穴
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=61">
						<img class="mui-media-object mui-pull-left" src="img/tn/61.png">
						<div class="mui-media-body">
							61精宁
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=62">
						<img class="mui-media-object mui-pull-left" src="img/tn/62.png">
						<div class="mui-media-body">
							62运土入水
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="ShiPinChuFangServlet?shipinbh=63">
						<img class="mui-media-object mui-pull-left" src="img/tn/63.png">
						<div class="mui-media-body">
							63胆经
							<p class='mui-ellipsis'>请观看视频</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2018/06/17</span></p>
						</div>
					</a>
				</li>

			</ul>
	</div>
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>
