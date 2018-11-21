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
    <title>表单提交</title>
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
	<form name="form2" action="SheZhiXuanze" method="post">
	<header id="header" class="mui-bar mui-bar-nav">

	<a class="mui-action-back mui-icon mui-icon-extra mui-icon-extra-arrowleftcricle mui-pull-left"></a>
		
			<h1 class="mui-title">舌质</h1>
	<button class="mui-btn mui-btn-blue mui-btn-link mui-pull-right" type="submit">确定</button>
	</header>
	<div class="mui-content">
		<ul class="mui-input-group">
			<li class="mui-input-row mui-radio">
				<label>舌质细柔淡红</label>
				<input name="shezhi" type="radio" checked="checked" value="01_细柔淡红_13">
				<input type="hidden" name="xuanze" value="<%=request.getParameter("xuanze")%>"/>
				<div class="mui-slider" style="margin-bottom: 1px;">
		        <div class="mui-slider-group mui-slider-loop">
		        	<!-- 额外增加的一个节点(循环轮播：第一个节点是最后一个图文表格) -->
		            <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xi7.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xi8.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrdh1.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrdh2.jpg">
		                          </a></li>
		                </ul>
		            </div>
		              <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrdh3.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrdh4.jpg">
		                          </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrdh5.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrdh6.jpg">
		                          </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrdh7.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrdh8.jpg">
		                          </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xi1.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xi2.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <!-- 额外增加的一个节点(循环轮播：最后一个节点是第一个图文表格) -->
		        </div>
		    </div>
			</li>
			<li class="mui-input-row mui-radio">
				<label>舌质细柔红</label>
				<input name="shezhi" type="radio" value="02_细柔红_14">
				<div class="mui-slider" style="margin-bottom: 1px;">
		        <div class="mui-slider-group mui-slider-loop">
		        	<!-- 额外增加的一个节点(循环轮播：第一个节点是最后一个图文表格) -->
		            <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrh3.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrh4.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrh1.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrh2.jpg">
		                          </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrh3.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrh4.jpg">
		                          </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrh1.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrh2.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <!-- 额外增加的一个节点(循环轮播：最后一个节点是第一个图文表格) -->
		        </div>
		    </div>
			</li>
			<li class="mui-input-row mui-radio">
				<label>舌质细柔暗红</label>
				<input name="shezhi" type="radio" value="03_细柔暗红_15">
				<div class="mui-slider" style="margin-bottom: 1px;">
		        <div class="mui-slider-group mui-slider-loop">
		        	<!-- 额外增加的一个节点(循环轮播：第一个节点是最后一个图文表格) -->
		            <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrah3.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrah4.jpg">
		                           </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrah1.jpg">
		                            </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrah2.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrah3.jpg">
		                            </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrah4.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrah1.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-xrah2.jpg">
		                           </a></li>
		                </ul>
		            </div>
		            <!-- 额外增加的一个节点(循环轮播：最后一个节点是第一个图文表格) -->
		        </div>
		    </div>
			</li>
			<li class="mui-input-row mui-radio">
				<label>舌质粗糙淡红</label>
				<input name="shezhi" type="radio" value="04_粗糙淡红_16">
				<div class="mui-slider" style="margin-bottom: 1px;">
		        <div class="mui-slider-group mui-slider-loop">
		        	<!-- 额外增加的一个节点(循环轮播：第一个节点是最后一个图文表格) -->
		            <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccdh3.jpg">
		                            </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccdh4.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccdh1.jpg">
		                            </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccdh2.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccdh3.jpg">
		                            </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccdh4.jpg">
		                            </a></li>
		                </ul>
		            </div>
		             <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccdh1.jpg">
		                            </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccdh2.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <!-- 额外增加的一个节点(循环轮播：最后一个节点是第一个图文表格) -->
		            
		        </div>
		    </div>
			</li>
			
			<li class="mui-input-row mui-radio">
				<label>舌质粗糙红</label>
				<input name="shezhi" type="radio" value="05_粗糙红_17">
				<div class="mui-slider" style="margin-bottom: 1px;">
		        <div class="mui-slider-group mui-slider-loop">
		        	<!-- 额外增加的一个节点(循环轮播：第一个节点是最后一个图文表格) -->
		            <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-cch7.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-cch8.jpg">
		                           </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-cch1.jpg">
		                            </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-cch2.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-cch3.jpg">
		                            </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-cch4.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-cch5.jpg">
		                            </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-cch6.jpg">
		                            </a></li>
		                </ul>
		            </div>
		             <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-cch7.jpg">
		                            </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-cch8.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-cch1.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-cch2.jpg">
		                           </a></li>
		                </ul>
		            </div>
		            <!-- 额外增加的一个节点(循环轮播：最后一个节点是第一个图文表格) -->
		        </div>
		    </div>
			</li>
			<li class="mui-input-row mui-radio">
				<label>舌质粗糙暗红</label>
				<input name="shezhi" type="radio" value="06_粗糙暗红_18">
				<div class="mui-slider" style="margin-bottom: 1px;">
		        <div class="mui-slider-group mui-slider-loop">
		        	<!-- 额外增加的一个节点(循环轮播：第一个节点是最后一个图文表格) -->
		            <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccah5.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccah6.jpg">
		                            </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccah1.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccah2.jpg">
		                          </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccah3.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccah4.jpg">
		                          </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccah5.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccah6.jpg">
		                          </a></li>
		                </ul>
		            </div>
		            <div class="mui-slider-item mui-slider-item-duplicate">
		                <ul class="mui-table-view mui-grid-view">
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccah1.jpg">
		                           </a></li>
		                    <li class="mui-table-view-cell mui-media mui-col-xs-6"><a href="javascript:void(0);"><img class="mui-media-object" src="img/sz-ccah2.jpg">
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
