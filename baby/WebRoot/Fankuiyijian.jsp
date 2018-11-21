<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ page import="com.dao.*"%>
<%@ page import="com.bean.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%
	User user =(User)request.getSession().getAttribute("user");
	//未登录状态
	if (user == null) { 
		response.sendRedirect("login.jsp");
		return;
	} else {
	
	}
%>
<!DOCTYPE HTML>
<html lang="en" class="feedback">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>反馈意见</title>
        <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" name="viewport" />
        <meta content="yes" name="apple-mobile-web-app-capable" />
        <meta content="black" name="apple-mobile-web-app-status-bar-style" />
        <meta content="telephone=no" name="format-detection" />
        <link rel="stylesheet" href="dep-td/css/ydui.css" />
        <script src="dep-td/js/ydui.flexible.js"></script>
        <link rel="stylesheet" type="text/css" href="css-td/health.css" />
    	
    	
	</head>

	<body>
		<form action="FanKuiYiJianServlet" method="post">
		<div class="g-flexview bgc-f">
            <div class="g-scrollview bgc-flower">
                <div class="navigation">
                    <a class="back" href="javascript:;" onclick="javascript:history.back(-1);"><img src="img/back.png" /></a>
                    <div class="navigation-title">反馈意见</div>
                </div>
                <div class="bgc-f opinion">
                    <div class="m-celltitle">问题和意见</div>
                    <div class="m-cell">
                        <div class="cell-item">
                            <div class="cell-right">
                            	<input type="hidden" name="userid" value="${user.userid }">
								<input type="hidden" name="uname" value="${user.uname }">
                                <textarea class="cell-textarea" name="fankuiyijian"  placeholder="请详细描述您的问题和意见...">${fankuiyijian}</textarea>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="bgc-f opinion">
                    <div class="m-celltitle">QQ/邮箱</div>
                    <div class="m-cell">
                        <div class="cell-item">
                            <div class="cell-right">
                                <textarea class="cell-textarea" name="email" placeholder="方便我们联系你..."></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                 <button id="submit" type="submit" class="btn-block btn-primary login-btn">发送</button>
                 <br>
                <div class="bgc-f opinion">
                    
                    	<div class="m-celltitle" style>
                    	<center>也可关注公众号"吉言吉语"给我们留言。</center>
                   	</div>
                   	 <center><img src="img/gzh.jpg">
                   	</center>
                </div>
                
               
                
            </div>
        </div>
        </form>
         <footer class="m-tabbar">
                    <a href="xuanzejiemian.jsp" class="tabbar-item" id="tuina">
                        <span class="tabbar-icon">
                            <img src="img/bar1.png"/>
                        </span>
                        <span class="tabbar-txt">推拿取穴</span>
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
                        <span class="tabbar-txt c-e9">我的</span>
                    </a>
                </footer>
        <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="dep-td/js/ydui.js"></script>
         <script src="js-td/health.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>