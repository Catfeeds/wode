<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>推拿取穴</title>
    <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" name="viewport" />
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <meta content="telephone=no" name="format-detection" />
    <link rel="stylesheet" href="dep-td/css/ydui.css" />
    <script src="dep-td/js/ydui.flexible.js"></script>
    <link rel="stylesheet" type="text/css" href="css-td/health.css" />
    
</head>
<body>
	<div class="g-flexview bgc-imgt">
            <div class="g-scrollview index">
                <div class="title">健康宝管理系统</div>
                <div id="scrollobj">
                    <span>温馨提示：</span>
                    <span>健康宝系统已经上线，此系统为1.0版本，1.0版本针对于普通感冒、感冒发烧、感冒咳嗽、腹泻、便秘、呕吐、积食、保健的调理，其中还包括宝宝成长中需要的育儿知识、食疗小方、推拿视频等，教会您如何在家里给宝宝推拿，简单易学好操作，请开始您的健康旅行吧。</span>
                </div>
                <div class="index-text">
                    <span class="hint">温馨提示</span>${user.name}您好！欢迎登陆健康宝管理系统，很高兴为您提供在线专业儿童健康检测与管理服务，您是第${user.userid}位使用者。
                                          您的帐号到期时间为 ${user.ystime}。
                   <%-- 您的可用次数剩余：<span class="ff">${numbers }次</span> --%>
                </div>

                <div class="index-select">
               		<a class="item active" href="XuanzeServlet?xz=06"><span class="text">保健</span></a>
                    <a class="item" href="XuanzeServlet?xz=07"><span class="text">调理<br/>脾胃</span></a>
                    <a class="item" href="XuanzeServlet?xz=00"><span class="text">普通<br/>感冒</span></a>
                    <a class="item" href="XuanzeServlet?xz=01"><span class="text">感冒<br/>发烧</span></a>
                    <a class="item" href="XuanzeServlet?xz=02"><span class="text">感冒<br/>咳嗽</span></a>
                    <a class="item" href="XuanzeServlet?xz=03"><span class="text">腹泻</span></a>
                    <a class="item" href="XuanzeServlet?xz=04"><span class="text">便秘</span></a>
                    <a class="item" href="XuanzeServlet?xz=09"><span class="text">呕吐</span></a>
                    <a class="item" href="XuanzeServlet?xz=05"><span class="text">积食</span></a>
                    
                    <%
				 if(user.getUpower()==0){
				    %>
                   <a class="item" href="XuanzeServlet?xz=10"><span class="text">鼻炎</span></a>
                    <a class="item" href="XuanzeServlet?xz=11"><span class="text">慢性<br/>咳嗽</span></a>
                    <a class="item" href="XuanzeServlet?xz=12"><span class="text">咽炎</span></a> 
                    
                     <%
						}
				    %>
                    <!-- <a class="item" href="XuanzeServlet?xz=08"><span class="text">益智<br/>助长</span></a> -->
                </div>
 				<!--通知-->
                
                <footer class="m-tabbar">
                    <a href="xuanzejiemian.jsp" class="tabbar-item" id="tuina">
                        <span class="tabbar-icon">
                            <img src="img/bar1-click.png"/>
                        </span>
                        <span class="tabbar-txt c-e9">推拿取穴</span>
                    </a>
                    <div class="tabbar-item" id="silk">
                        <span class="bgc-jn" id="bgc-jn"></span>
                        <span class="tabbar-txt">育儿锦囊</span>
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
        <script language="javascript" type="text/javascript">
            function scroll(obj) {
                var tmp = (obj.scrollLeft) ++;
                //当滚动条到达右边顶端时
                if(obj.scrollLeft == tmp) obj.innerHTML += obj.innerHTML;
                //当滚动条滚动了初始内容的宽度时滚动条回到最左端
                if(obj.scrollLeft >= obj.firstChild.offsetWidth) obj.scrollLeft = 0;
            }
            setInterval("scroll(document.getElementById('scrollobj'))", 20);
        </script>
    </body>
</html>