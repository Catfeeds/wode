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
    <title>食疗小方</title>
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
                    <div class="navigation-title">食疗小方</div>
                </div>

                <div class="m-cell">
                	<!-- <a href="jkyh_text/Shiliaojiaomizhou.jsp" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/jiaomizhou.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                            	<p class="title">食疗小方之焦米粥</p>
                            	<p class="con"></p>
                            	<div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a> -->
                    
                    <a href="https://mp.weixin.qq.com/s/28nv5XJpFernM4tSKIQbIQ" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/slxf1.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                            	<p class="title">食疗小方—应对咳嗽一</p>
                            	<p class="con"></p>
                            	<div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                    <a href="https://mp.weixin.qq.com/s/6KagHuUcCdxBwZhQpBhc4Q" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/slxf2.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                            	<p class="title">食疗小方—应对咳嗽二</p>
                            	<p class="con"></p>
                            	<div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                    <a href="https://mp.weixin.qq.com/s/8M1Q-KvQ5ZotBG7zsrXl1g" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/slxf3.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                            	<p class="title">食疗小方—应对咳嗽三</p>
                            	<p class="con"></p>
                            	<div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                    <a href="https://mp.weixin.qq.com/s/rt13Q2JSyTck79RIxjOuAw" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/slxf4.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                            	<p class="title">腹泻小妙招—大米油</p>
                            	<p class="con"></p>
                            	<div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                    <a href="https://mp.weixin.qq.com/s/5KsvqQKGqJNNP0MpsrCbng" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/slxf5.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                            	<p class="title">腹泻小妙招—姜糖饮</p>
                            	<p class="con"></p>
                            	<div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                    <a href="https://mp.weixin.qq.com/s/Sde_WVe2N7EC5Fa_HVVLlA" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/slxf6.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                            	<p class="title">腹泻小妙招—胡萝卜水</p>
                            	<p class="con"></p>
                            	<div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                    <a href="https://mp.weixin.qq.com/s/tfoTR2zqkLS05QnXBdzCBg" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/slxf7.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                            	<p class="title">一碗粥，将食疗养生做到简单极致</p>
                            	<p class="con"></p>
                            	<div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                    <a href="https://mp.weixin.qq.com/s/nhJtElOjPAHBbwQf0XywXw" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/slxf8.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                            	<p class="title">便秘小妙招—蜂蜜条</p>
                            	<p class="con"></p>
                            	<div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                    <a href="https://mp.weixin.qq.com/s/I7h_2dQc_VJiLRafg3qftw" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/slxf9.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                            	<p class="title">呕吐小妙招—萝卜酸梅汤</p>
                            	<p class="con"></p>
                            	<div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                    <a href="https://mp.weixin.qq.com/s/ZKLO5ykbCIAwszpVBpfocA" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/slxf10.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                            	<p class="title">乌梅三豆汤，补脾补肾身体棒......</p>
                            	<p class="con"></p>
                            	<div class="time"><img src="img/time.png"/>2018/07/07</div>
                            </div>
                        </div>
                    </a>
                    
                    <a href="https://mp.weixin.qq.com/s/TiX8MC1Ogh8J54v7awngLg" class="cell-item article bgc-f">
                        <div class="cell-left"><img src="img/jkyh/slxf11.png"/></div>
                        <div class="cell-right">
                            <div class="text">
                            	<p class="title">补益肝肾、滋养五脏之黑芝麻粳米粥</p>
                            	<p class="con"></p>
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
