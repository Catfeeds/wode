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
    <title>健康养护</title>
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
			<h1 class="mui-title ">饮食调理</h1>
	</header>
	<nav class="mui-bar mui-bar-tab">
	    <a class="mui-tab-item-link" href="xuanzejiemian.jsp">
	      <span class="mui-icon my-nav-icon-1"></span>
	      <span class="mui-tab-label">辩证取穴</span>
	    </a>
	    <a class="mui-tab-item-link mui-active" href="jiankangyanghu.jsp">
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
		<ul class="mui-table-view">
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Yinshipage1.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-1.png">
						<div class="mui-media-body">
							【家庭护理】孩子常见疾病的饮食与护理（上）
							<p class='mui-ellipsis'>看到宝宝生病，看着他难受的模样，妈妈们是不是心都碎了却又手足无措。</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Yinshipage2.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-6.png">
						<div class="mui-media-body">
							【家庭护理】孩子常见疾病的饮食与护理（下）
							<p class='mui-ellipsis'>看到宝宝生病，看着他难受的模样，妈妈们是不是心都碎了却又手足无措。</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<!--
				<li class="mui-table-view-cell mui-media">
					<a href="TiaoLiServlet?tiaolibh=3">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-1.png">
						<div class="mui-media-body">
							【家庭护理】孩子常见疾病的饮食与护理（三）
							<p class='mui-ellipsis'>看到宝宝生病，看着他难受的模样，妈妈们是不是心都碎了却又手足无措。</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				 
				<li class="mui-table-view-cell mui-media">
					<a href="TiaoLiServlet?tiaolibh=4">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-6.png">
						<div class="mui-media-body">
							【家庭护理】孩子常见疾病的饮食与护理（四）
							<p class='mui-ellipsis'>看到宝宝生病，看着他难受的模样，妈妈们是不是心都碎了却又手足无措。</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				 -->
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Yinshipage3.jsp">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							【超全辅食技能get】（一）
							<p class='mui-ellipsis'>妈妈再也不用担心宝宝吃不对啦！</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Yinshipage4.jsp">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							【超全辅食技能get】（二）
							<p class='mui-ellipsis'>辅食引入也是尤为重要，宝妈们要多加注意哦！</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Yinshipage5.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-8.png">
						<div class="mui-media-body">
							为何要断夜奶？
							<p class='mui-ellipsis'>宝宝又积食了，晚上睡眠质量不好，特别容易生病，你知不知道，这些不良的现象都有可能会由夜奶导致哦！</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="jkyh_text/Yinshipage6.jsp">
						<img class="mui-media-object mui-pull-left" src="img/jkyh/hl-28.png">
						<div class="mui-media-body">
							母乳喂养也会积食吗？
							<p class='mui-ellipsis'>宝宝的健康掌握在各位家长手里，你们的正当养护才是防止宝宝生病最好的良方！</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<!--
				<li class="mui-table-view-cell mui-media">
					<a href="TiaoLiServlet?tiaolibh=8">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							嘴角有白茬
							<p class='mui-ellipsis'>有些孩子经常口角有“白茬儿”，是口干引起的</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="TiaoLiServlet?tiaolibh=9">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							秋后咳嗽妙方
							<p class='mui-ellipsis'>入秋后咳嗽的孩子越来越多，大多数的孩子咳声重浊、痰液黏稠不易咳出</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="TiaoLiServlet?tiaolibh=10">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							健脾和胃
							<p class='mui-ellipsis'>大米性平味甘归脾、胃经，有健脾养胃、肥五脏百窍、滋阴长力之功效</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="TiaoLiServlet?tiaolibh=11">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							大便溏软
							<p class='mui-ellipsis'>孩子入厕后，可以观察一下大便，如果颜色发青，溏软不成形，粘在马桶上了</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li>
				<li class="mui-table-view-cell mui-media">
					<a href="TiaoLiServlet?tiaolibh=12">
						<img class="mui-media-object mui-pull-left" src="img/pic_1.jpg">
						<div class="mui-media-body">
							积食
							<p class='mui-ellipsis'>发现孩子积食后，首先应迅速减少孩子的饮食量，比如平时每顿饭吃一个馒头</p>
							<p><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
						</div>
					</a>
				</li> -->

			</ul>
	</div>
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>
