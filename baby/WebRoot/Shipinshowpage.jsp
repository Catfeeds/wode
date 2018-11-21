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
   <title>视频详情</title>
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
                    <div class="navigation-title">${spname}推拿视频</div>
                </div>

                <div class="videopar-list bgc-f">
                    <div class="video-title"><img src="img/video.png" /> <span>推拿视频</span></div>
                    <div class="video-wrap">
                   		 <video class="flv" id="source" controls poster='${tplujing}' src="${splujing }" type="video/mp4"></video>
                   	<div>
                </div>

                <!--图解-->
                <div class="chart bgc-f">
                    <div class="chart-list">
                        <div class="title">图解</div>
                        <div class="img">
                            <img src="${xwweizhi }" />
                        </div>
                    </div>

                    <div class="chart-list">
                        <div class="title">位置</div>
                        <p class="text">${spneirong}</p>
                    </div>

                    <div class="chart-list">
                        <div class="title">作用</div>
                        <p class="text">${xwzuoyong }</p>
                    </div>
                </div>

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
                        <span class="tabbar-tx c-e9">育儿课堂</span>
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
        <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="dep-td/js/ydui.js"></script>
         <script src="js-td/health.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
            //          视频切换
            $('.overflow .item').click(function() {
                var src = $(this).attr('data-src'),
                    img = $(this).attr('data-img');
                console.log(src, img)
                $('#source').attr({
                    src: src,
                    poster: img
                })
            })
        </script>
</body>
</html>
