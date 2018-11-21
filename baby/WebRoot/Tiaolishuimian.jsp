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
    <title>睡眠调理</title>
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
                    <div class="navigation-title">睡眠调理</div>
                </div>

                <div class="m-cell">
                    <a href="TiaoLiServlet?tiaolibh=13" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/sm-1.jpg"/></div>
                        <div class="cell-right">
                            <div class="text">
                            	<p class="title">小儿正常睡眠需求</p>
                            	<p class="con">儿童身高除了与遗传、营养、体育锻炼等因素有关外</p>
                            	<div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                    <a href="jkyh_text/Shuimianpage1.jsp" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/sm-4.jpg"/></div>
                        <div class="cell-right">
                            <div class="text">
                                <p class="title">宝宝打呼噜，说明睡得香？情况可能比你想的严重……</p>
                                <p class="con">无论是深夜入眠还是午间小憩，看着孩子沉睡在梦乡里总是一件幸福的事。</p>
                                <div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                    <a href="TiaoLiServlet?tiaolibh=14" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/sm-2.jpg"/></div>
                        <div class="cell-right">
                            <div class="text">
                                <p class="title">婴儿睡眠不好的原因一</p>
                                <p class="con">当宝宝在晚上有大小便时，排泄物会让宝宝感觉屁屁不舒服</p>
                                <div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                    <a href="TiaoLiServlet?tiaolibh=15" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/sm-3.jpg"/></div>
                        <div class="cell-right">
                            <div class="text">
                                <p class="title">婴儿睡眠不好的原因二</p>
                                <p class="con">宝宝在出生3个月之前一直都是在睡觉，这时爸妈绝对不能可以改变睡眠时间</p>
                                <div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
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
