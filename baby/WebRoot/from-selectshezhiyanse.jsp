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
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>舌质颜色</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="css-changsha/mui.css">
    <link rel="stylesheet" type="text/css" href="css-changsha/icons-extra.css" />
    <link rel="stylesheet" href="css-changsha/main.css">
    <style>
		.mui-input-group .mui-input-row {
			height: auto;
		}
	</style>
    <script type="text/javascript">
    	
   		document.addEventListener('plusready', function(){
   			//console.log("所有plus api都应该在此事件发生后调用，否则会出现plus is undefined。"
   			
   		});
   		
    </script>
</head>
<body>
	<form name="form2" action="SheZhiYanSeXuanze" method="post">
	<header id="header" class="mui-bar mui-bar-nav">

	<a class="mui-action-back mui-icon mui-icon-extra mui-icon-extra-arrowleftcricle mui-pull-left"></a>
	<!--  <a class="mui-icon mui-pull-left" href="xuanzejiemian.jsp" style="margin-left:20px ">首页</a>-->
		
			<h1 class="mui-title">舌质颜色</h1>
	<button class="mui-btn mui-btn-blue mui-btn-link mui-pull-right" type="submit">确定</button>
	</header>
	<div class="mui-content">
		<ul class="mui-input-group">
			<li class="mui-input-row mui-radio">
				<label>舌质淡红</label>
				<input name="shezhiyanse" type="radio" checked="checked" value="01_淡红">
				<input type="hidden" name="xuanze" value="<%=request.getParameter("xuanze")%>"/>
				<div class="mui-slider" style="margin-bottom: 1px;">
		        <div class="mui-slider-group mui-slider-loop">
		        	<!-- 额外增加的一个节点(循环轮播：第一个节点是最后一个图文表格) -->
		            <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-dan3.jpg">
		                            </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-dan4.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-dan1.jpg">
		                            </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-dan2.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-dan3.jpg">
		                            </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-dan4.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-dan1.jpg">
		                            </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-dan2.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <!-- 额外增加的一个节点(循环轮播：最后一个节点是第一个图文表格) -->
		        </div>
		    </div>
			</li>
			<li class="mui-input-row mui-radio">
				<label>舌质红</label>
				<input name="shezhiyanse" type="radio" value="02_红">
				<div class="mui-slider" style="margin-bottom: 1px;">
		        <div class="mui-slider-group mui-slider-loop">
		        	<!-- 额外增加的一个节点(循环轮播：第一个节点是最后一个图文表格) -->
		            <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-hong3.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-hong4.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-hong1.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-hong2.jpg">
		                          </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-hong3.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-hong4.jpg">
		                          </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-hong1.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-hong2.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <!-- 额外增加的一个节点(循环轮播：最后一个节点是第一个图文表格) -->
		        </div>
		    </div>
			</li>
			<li class="mui-input-row mui-radio">
				<label>舌质暗红</label>
				<input name="shezhiyanse" type="radio" value="02_暗红">
				<div class="mui-slider" style="margin-bottom: 1px;">
		        <div class="mui-slider-group mui-slider-loop">
		        	<!-- 额外增加的一个节点(循环轮播：第一个节点是最后一个图文表格) -->
		            <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-an5.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-an6.jpg">
		                           </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-an1.jpg">
		                            </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-an2.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-an3.jpg">
		                            </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-an4.jpg">
		                            </a></li>
		                </ul>
		            </div>
		             <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-an5.jpg">
		                            </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-an6.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-an1.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/szys-an2.jpg">
		                           </a></li>
		                </ul>
		            </div>
		            <!-- 额外增加的一个节点(循环轮播：最后一个节点是第一个图文表格) -->
		        </div>
		    </div>
			</li>
		</ul>
	</div>
	</form>
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>
