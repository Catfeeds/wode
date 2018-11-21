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
    <title>视频列表</title>
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
	<div class="g-flexview bgc-f">
            <div class="g-scrollview">
                <div class="navigation">
                    <a class="back" href="javascript:;" onclick="javascript:history.back(-1);"><img src="img/back.png" /></a>
                    <div class="navigation-title">学推拿</div>
                </div>
                <br/>
                <div class="index-text">
                    <span class="hint">温馨提示:</span><span class="ff"><b>点击图片即可观看相应视频。</b></span>
                </div>
                
                <div class="video-list">
                     <a href="ShiPinChuFangServlet?shipinbh=1" class="video-item">
                         <img class="img" src="img/tn/1.png"/>
                         <p class="title">01吉祥穴</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                         	<span>2018-07-08</span>
                         </div>
                     </a>
                     
                     <a href="ShiPinChuFangServlet?shipinbh=2" class="video-item">
                         <img class="img" src="img/tn/2.png"/>
                         <p class="title">02如意</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     
                     <a href="ShiPinChuFangServlet?shipinbh=3" class="video-item">
                         <img class="img" src="img/tn/3.png"/>
                         <p class="title">03一窝蜂穴</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=4" class="video-item">
                         <img class="img" src="img/tn/4.png"/>
                         <p class="title">04新一扇门穴</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=5" class="video-item">
                         <img class="img" src="img/tn/5.png"/>
                         <p class="title">05感冒点</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=6" class="video-item">
                         <img class="img" src="img/tn/6.png"/>
                         <p class="title">06清热点</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=7" class="video-item">
                         <img class="img" src="img/tn/7.png"/>
                         <p class="title">07外关穴</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=8" class="video-item">
                         <img class="img" src="img/tn/8.png"/>
                         <p class="title">08阳明穴</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=9" class="video-item">
                         <img class="img" src="img/tn/9.png"/>
                         <p class="title">09大肠点</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=10" class="video-item">
                         <img class="img" src="img/tn/10.png"/>
                         <p class="title">10阳池穴</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=11" class="video-item">
                         <img class="img" src="img/tn/11.png"/>
                         <p class="title">11泰山点</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=12" class="video-item">
                         <img class="img" src="img/tn/12.png"/>
                         <p class="title">12板门</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=13" class="video-item">
                         <img class="img" src="img/tn/13.png"/>
                         <p class="title">13咽喉点</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=14" class="video-item">
                         <img class="img" src="img/tn/14.png"/>
                         <p class="title">14灵泉穴</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=15" class="video-item">
                         <img class="img" src="img/tn/15.png"/>
                         <p class="title">15大肠穴</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=16" class="video-item">
                         <img class="img" src="img/tn/16.png"/>
                         <p class="title">16鼻出血点</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=17" class="video-item">
                         <img class="img" src="img/tn/17.png"/>
                         <p class="title">17合谷</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=18" class="video-item">
                         <img class="img" src="img/tn/18.png"/>
                         <p class="title">18脾经</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=19" class="video-item">
                         <img class="img" src="img/tn/19.png"/>
                         <p class="title">19二马穴</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=20" class="video-item">
                         <img class="img" src="img/tn/20.png"/>
                         <p class="title">20头痛点</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=21" class="video-item">
                         <img class="img" src="img/tn/21.png"/>
                         <p class="title">21脾点</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=22" class="video-item">
                         <img class="img" src="img/tn/22.png"/>
                         <p class="title">22液门</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=23" class="video-item">
                         <img class="img" src="img/tn/23.png"/>
                         <p class="title">23肝点</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=24" class="video-item">
                         <img class="img" src="img/tn/24.png"/>
                         <p class="title">24外劳宫</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=25" class="video-item">
                         <img class="img" src="img/tn/25.png"/>
                         <p class="title">25胃经</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=26" class="video-item">
                         <img class="img" src="img/tn/26.png"/>
                         <p class="title">26扁桃体点</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=27" class="video-item">
                         <img class="img" src="img/tn/27.png"/>
                         <p class="title">27膈点</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=28" class="video-item">
                         <img class="img" src="img/tn/28.png"/>
                         <p class="title">28总筋</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=29" class="video-item">
                         <img class="img" src="img/tn/29.png"/>
                         <p class="title">29内劳宫</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=30" class="video-item">
                         <img class="img" src="img/tn/30.png"/>
                         <p class="title">30掌小横纹</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=31" class="video-item">
                         <img class="img" src="img/tn/31.png"/>
                         <p class="title">31小肠</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=32" class="video-item">
                         <img class="img" src="img/tn/32.png"/>
                         <p class="title">32小天心</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=33" class="video-item">
                         <img class="img" src="img/tn/33.png"/>
                         <p class="title">33夜尿穴</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=34" class="video-item">
                         <img class="img" src="img/tn/34.png"/>
                         <p class="title">34上焦</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=35" class="video-item">
                         <img class="img" src="img/tn/35.png"/>
                         <p class="title">35肾顶</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=36" class="video-item">
                         <img class="img" src="img/tn/36.png"/>
                         <p class="title">36内关</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=37" class="video-item">
                         <img class="img" src="img/tn/37.png"/>
                         <p class="title">37三焦</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=38" class="video-item">
                         <img class="img" src="img/tn/38.png"/>
                         <p class="title">38小肠点</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=39" class="video-item">
                         <img class="img" src="img/tn/39.png"/>
                         <p class="title">39肝经</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=40" class="video-item">
                         <img class="img" src="img/tn/40.png"/>
                         <p class="title">40心经</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=41" class="video-item">
                         <img class="img" src="img/tn/41.png"/>
                         <p class="title">41肺经</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=42" class="video-item">
                         <img class="img" src="img/tn/42.png"/>
                         <p class="title">42肾经</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=43" class="video-item">
                         <img class="img" src="img/tn/43.png"/>
                         <p class="title">43肾纹</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=44" class="video-item">
                         <img class="img" src="img/tn/44.png"/>
                         <p class="title">44四横纹</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=45" class="video-item">
                         <img class="img" src="img/tn/45.png"/>
                         <p class="title">45内八卦</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=46" class="video-item">
                         <img class="img" src="img/tn/46.png"/>
                         <p class="title">46运水入土</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=47" class="video-item">
                         <img class="img" src="img/tn/47.png"/>
                         <p class="title">47阴池穴</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=48" class="video-item">
                         <img class="img" src="img/tn/48.png"/>
                         <p class="title">48咳喘</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=49" class="video-item">
                         <img class="img" src="img/tn/49.png"/>
                         <p class="title">49胃肠痛点</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=50" class="video-item">
                         <img class="img" src="img/tn/50.png"/>
                         <p class="title">50命门</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=51" class="video-item">
                         <img class="img" src="img/tn/51.png"/>
                         <p class="title">51一扇门</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=52" class="video-item">
                         <img class="img" src="img/tn/52.png"/>
                         <p class="title">52两扇门</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="" class="video-item">
                         <img class="img" src="img/tn/53.png"/>
                         <p class="title">53十宣</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=54" class="video-item">
                         <img class="img" src="img/tn/54.png"/>
                         <p class="title">54五指节</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=55" class="video-item">
                         <img class="img" src="img/tn/55.png"/>
                         <p class="title">55外八卦</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=56" class="video-item">
                         <img class="img" src="img/tn/56.png"/>
                         <p class="title">56列缺</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=57" class="video-item">
                         <img class="img" src="img/tn/57.png"/>
                         <p class="title">57三关</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=58" class="video-item">
                         <img class="img" src="img/tn/58.png"/>
                         <p class="title">58六腑</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=59" class="video-item">
                         <img class="img" src="img/tn/59.png"/>
                         <p class="title">59天河水</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=60" class="video-item">
                         <img class="img" src="img/tn/60.png"/>
                         <p class="title">60威灵穴</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=61" class="video-item">
                         <img class="img" src="img/tn/61.png"/>
                         <p class="title">61精宁</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=62" class="video-item">
                         <img class="img" src="img/tn/62.png"/>
                         <p class="title">62运土入水</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
                         </div>
                     </a>
                     <a href="ShiPinChuFangServlet?shipinbh=63" class="video-item">
                         <img class="img" src="img/tn/63.png"/>
                         <p class="title">63胆经</p>
                         <div class="time">
                            <img src="img/time.png"/> 
                            <span>2018-07-08</span>
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
                        <span class="tabbar-txt c-e9">育儿课堂</span>
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
