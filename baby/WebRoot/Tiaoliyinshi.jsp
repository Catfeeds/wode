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
    <title>饮食调理</title>
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
                    <div class="navigation-title">饮食调理</div>
                </div>

                <div class="m-cell">
                    <a href="jkyh_text/Yinshipage1.jsp" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/hl-1.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                            	<p class="title">【家庭护理】孩子常见疾病的饮食与护理（上）</p>
                            	<p class="con">看到宝宝生病，看着他难受的模样，妈妈们是不是心都碎了却又手足无措。</p>
                            	<div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                    <a href="jkyh_text/Yinshipage2.jsp" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/hl-6.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                                <p class="title">【家庭护理】孩子常见疾病的饮食与护理（下）</p>
                                <p class="con">看到宝宝生病，看着他难受的模样，妈妈们是不是心都碎了却又手足无措。</p>
                                <div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                    <a href="jkyh_text/Yinshipage3.jsp" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/pic_1.jpg"/></div>
                        <div class="cell-right">
                            <div class="text">
                                <p class="title">【超全辅食技能get】（一）</p>
                                <p class="con">妈妈再也不用担心宝宝吃不对啦！</p>
                                <div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                 	<a href="jkyh_text/Yinshipage5.jsp" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/ys-1.jpg"/></div>
                        <div class="cell-right">
                            <div class="text">
                                <p class="title">为何要断夜奶？</p>
                                <p class="con">宝宝又积食了，晚上睡眠质量不好，特别容易生病，你知不知道，这些不良的现象都有可能会由夜奶导致哦！</p>
                                <div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a> 
                    
                    <a href="jkyh_text/Yinshipage6.jsp" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/ys-2.jpg"/></div>
                        <div class="cell-right">
                            <div class="text">
                                <p class="title">孩子不爱吃饭？是你还不知道这几种解决方法！</p>
                                <p class="con">大家都知道吃饭是孩子成长的首要原因之一，但是有的家长一到饭点就发愁，孩子不爱吃饭，吃了没几口就不吃了，强行喂又怕损伤他的脾胃。</p>
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
