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
    <title>宝宝成长</title>
    <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" name="viewport" />
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <meta content="telephone=no" name="format-detection" />
    <link rel="stylesheet" href="dep-td/css/ydui.css" />
    <script src="dep-td/js/ydui.flexible.js"></script>
    <link rel="stylesheet" type="text/css" href="css-td/health.css" />
    <script type="text/javascript">
    	
   		document.addEventListener('plusready', function(){
   			//console.log("所有plus api都应该在此事件发生后调用，否则会出现plus is undefined。"
   			
   		});
   		
    </script>
</head>
<body>
	<div class="g-flexview bgc-f4">
            <div class="g-scrollview">
                <div class="navigation">
                    <a class="back" href="javascript:;" onclick="javascript:history.back(-1);"><img src="img/back.png" /></a>
                    <div class="navigation-title">宝宝成长</div>
                </div>

                <div class="m-cell">
                	<a href="jkyh_text/Fayupage4.jsp" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/fy-bz0.jpg"/></div>
                        <div class="cell-right">
                            <div class="text">
                            	<p class="title">辣妈的带娃经历之乐乐妈</p>
                            	<p class="con">我是一位宝妈，我的儿子乐乐已经七个月了。在这里我要诚挚的感谢吉亚宁老师。</p>
                            	<div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    <a href="jkyh_text/Fayupage1.jsp" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/fy-bz.jpg"/></div>
                        <div class="cell-right">
                            <div class="text">
                            	<p class="title">变蒸——在变化中蒸蒸日上</p>
                            	<p class="con">什么是小儿“变蒸”呢，小儿“变蒸”会出现哪些表现，怎么应对呢？</p>
                            	<div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                     <a href="jkyh_text/Fayupage2.jsp" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/hl-12.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                                <p class="title">0-6个月的宝宝成长</p>
                                <p class="con">这个时间段的宝宝容易出现腹泻、湿疹等问题</p>
                                <div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                   <a href="jkyh_text/Fayupage3.jsp" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/fy-2.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                                <p class="title">6-12个月的宝宝成长</p>
                                <p class="con">这个时间段的宝宝容易出现积食、幼儿急疹等问题</p>
                                <div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                    
                     <!--<a href="TiaoLiServlet?tiaolibh=26" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/fy-3.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                                <p class="title">1-3岁的宝宝成长</p>
                                <p class="con">这个时间段的宝宝：每天都问很多为什么，对很多东西都感到好奇。</p>
                                <div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                    <a href="TiaoLiServlet?tiaolibh=27" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/fy-4.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                                <p class="title">3-6岁的宝宝成长</p>
                                <p class="con">这个时间段的宝宝：开始有第一次的独立活动，离开妈妈身边</p>
                                <div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                     -->
                </div>
                
               <footer class="m-tabbar">
                    <a href="xuanzejiemian.jsp" class="tabbar-item" id="tuina">
                        <span class="tabbar-icon">
                            <img src="img/bar1.png"/>
                        </span>
                        <span class="tabbar-txt">推拿取穴</span>
                    </a>
                    <div class="tabbar-item" id="silk">
                        <span class="bgc-jn" id="bgc-jn"></span>
                        <span class="tabbar-txt c-e9">育儿锦囊</span>
                        <img class="bts-img" src="img/bts.png"/>
                        <ul class="silk">
                        	<li><a href="Tiaolifayu.jsp">宝宝成长</a></li>
                        	<li><a href="Shiliaoxiaofang.jsp">食疗小方</a></li>
                        	<li><a href="Tiaoliyinshi.jsp">饮食调理</a></li>
                        	<li><a href="Tiaolishuimian.jsp">睡眠调理</a></li>
                        	<li><a href="Tiaolichuandai.jsp">穿戴养护</a></li>
                        </ul>
                    </div>
                    <div class="tabbar-item" id="classroom">
                        <span class="bgc-cr" id="bgc-cr"></span>
                        <span class="tabbar-txt">育儿课堂</span>
                        <img class="bts-img" src="img/bts.png"/>
                        <ul class="silk">
                            <li><a href="Shipintuina.jsp">穴位查找</a></li>
                            <li><a href="Jilaoshiwenda.jsp">吉老师问答</a></li>
                            <li><a href="Tuinaxuzhi.jsp">推拿须知</a></li>
                        </ul>
                    </div>
                    <a href="personal-center.jsp" class="tabbar-item" id="me">
                        <span class="tabbar-icon">
                            <img src="img/bar4.png"/>
                        </span>
                        <span class="tabbar-txt">我的</span>
                    </a>
                </footer>
            </div>
        </div>
        <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="dep-td/js/ydui.js"></script>
        <script src="js-td/health.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
