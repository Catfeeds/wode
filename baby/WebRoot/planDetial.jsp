<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.dao.*"%>
<%@ page import="com.bean.*"%>
    <%
	User user =(User)request.getSession().getAttribute("user");
	//未登录状态  未登录状态 
	if (user!=null) { 
		
	} else {
		response.sendRedirect("login.jsp");
		return;
	}
	%>
<!DOCTYPE html>
<html>
<head>
<%
	java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	java.util.Date currentTime = new java.util.Date();
	String time = simpleDateFormat.format(currentTime).toString(); //放到页面的head中}
%>
	<meta charset="utf-8">
    <title>健康档案</title>
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
            <div class="g-scrollview health">
                <div class="navigation">
                    <a class="back" href="javascript:;" onclick="javascript:history.back(-1);"><img src="img/back.png" /></a>
                    <div class="navigation-title">健康档案</div>
                </div>

                <div class="introduce bgc-f">
                    <p><b>宝宝姓名：${pname }</b></p>
                    <p><b>宝宝年龄：${age}</b></p>
                    <p><b>创建时间：${nowTime }</b></p>
                   <!--  <div class="number">${pid }</div> -->
                </div>

                <div class="videopar-list bgc-f">
                	 
                     <div class="suggest">
                        <div class="title"><img src="img/idera1.png" /> <span>推拿建议</span></div>
                        <div class="subtitle">
		                 	<%	if(request.getSession().getAttribute("sumitem1") == null||request.getSession().getAttribute("sumitem1").equals(null)||request.getSession().getAttribute("sumitem1").equals("")||request.getSession().getAttribute("sumitem1") == ""){
						 %>
						<%}else{ %>
                        
                        		${xwqingbu1 }${xwmingcheng1 }${cishu1 }次<br/>
                        		
                        	<%} %>	
                        	<%
					if(request.getSession().getAttribute("sumitem2") == null||request.getSession().getAttribute("sumitem2").equals(null)||request.getSession().getAttribute("sumitem2").equals("")||request.getSession().getAttribute("sumitem2") == ""){
				 %>
				<%}else{ %> 
                        ${xwqingbu2 }${xwmingcheng2 }${cishu2 }次<br/>
                        
                       <%} %>
                       
                       <%
					if(request.getSession().getAttribute("sumitem3") == null||request.getSession().getAttribute("sumitem3").equals(null)||request.getSession().getAttribute("sumitem3").equals("")||request.getSession().getAttribute("sumitem3") == ""){
				 %>
				<%}else{ %>
					${xwqingbu3 }${xwmingcheng3 }${cishu3 }次
					
					<%} %>
                        </div>
                        <!-- <p class="con">注：+为补，-为清，+为清补，五加减号为揉法，前二位为穴位代码，后三位数为推拿次数。</p> -->
                    </div>
                    
                    
                    
                	<div class="video-title"><img src="img/video.png" /> <span>推拿视频</span></div>
                    <div class="video-wrap">
                    	<video class="flv" id="source" controls poster='${img1}' src="${shipin1 }" type="video/mp4"></video>
                    </div>
                    <div class="flv-list">
                        <div class="overflow">
                        	 <%
					if(request.getSession().getAttribute("sumitem1") == null||request.getSession().getAttribute("sumitem1").equals(null)||request.getSession().getAttribute("sumitem1").equals("")||request.getSession().getAttribute("sumitem1") == ""){
				 %>
				<%}else{ %>
                            <div class="item" data-src="${shipin1 }" data-img='${img1}'  data-pic='${xuewei1}'>
                                <img src="img/786772964607229047.png" />
                                <div class="star"><img src="img/player.png" /></div>
                                <span class="number">${sumitem1}</span>
                            </div>
                    <%} %>	
				
				<%
					if(request.getSession().getAttribute("sumitem2") == null||request.getSession().getAttribute("sumitem2").equals(null)||request.getSession().getAttribute("sumitem2").equals("")||request.getSession().getAttribute("sumitem2") == ""){
				 %>
				<%}else{ %>       
                            <div class="item" data-src="${shipin2 }" data-img='${img2}'  data-pic='${xuewei2}'>
                                <img src="img/786772964607229047.png" />
                                <div class="star"><img src="img/player.png" /></div>
                                <span class="number">${sumitem2}</span>
                            </div>
                           <%} %>	
				
				<%
					if(request.getSession().getAttribute("sumitem3") == null||request.getSession().getAttribute("sumitem3").equals(null)||request.getSession().getAttribute("sumitem3").equals("")||request.getSession().getAttribute("sumitem3") == ""){
				 %>
				<%}else{ %>
                            <div class="item" data-src="${shipin3 }" data-img='${img3}'  data-pic='${xuewei3}'>
                                <img src="img/786772964607229047.png" />
                                <div class="star"><img src="img/player.png" /></div>
                                <span class="number">${sumitem3}</span>
                            </div>
                            <%} %>	
				
				<%
					if(request.getSession().getAttribute("sumitem4") == null||request.getSession().getAttribute("sumitem4").equals(null)||request.getSession().getAttribute("sumitem4").equals("")||request.getSession().getAttribute("sumitem4") == ""){
				 %>
				<%}else{ %>
                            <div class="item" data-src="${shipin4 }" data-img='${img4}'  data-pic='${xuewei4}'>
                                <img src="img/786772964607229047.png" />
                                <div class="star"><img src="img/player.png" /></div>
                                <span class="number">${sumitem4}</span>
                            </div>
                            <%} %>	
				
				<%
					if(request.getSession().getAttribute("sumitem5") == null||request.getSession().getAttribute("sumitem5").equals(null)||request.getSession().getAttribute("sumitem5").equals("")||request.getSession().getAttribute("sumitem5") == ""){
				 %>
				<%}else{ %>
                            <div class="item" data-src="${shipin5 }" data-img='${img5}'  data-pic='${xuewei5}'>
                                <img src="img/786772964607229047.png" />
                                <div class="star"><img src="img/player.png" /></div>
                                <span class="number">${sumitem5}</span>
                            </div>
                            <%} %>	
				
				<%
					if(request.getSession().getAttribute("sumitem6") == null||request.getSession().getAttribute("sumitem6").equals(null)||request.getSession().getAttribute("sumitem6").equals("")||request.getSession().getAttribute("sumitem6") == ""){
				 %>
				<%}else{ %>
                            <div class="item" data-src="${shipin6 }" data-img='${img6}'  data-pic='${xuewei6}'>
                                <img src="img/786772964607229047.png" />
                                <div class="star"><img src="img/player.png" /></div>
                                <span class="number">${sumitem6}</span>
                            </div>
                            <%} %>	
				
				<%
					if(request.getSession().getAttribute("sumitem7") == null||request.getSession().getAttribute("sumitem7").equals(null)||request.getSession().getAttribute("sumitem7").equals("")||request.getSession().getAttribute("sumitem7") == ""){
				 %>
				<%}else{ %>
                            <div class="item" data-src="${shipin7 }" data-img='${img7}'  data-pic='${xuewei7}'>
                                <img src="img/786772964607229047.png" />
                                <div class="star"><img src="img/player.png" /></div>
                                <span class="number">${sumitem7}</span>
                            </div>
                     	<%} %>
                        </div>
                    </div>
                   
                </div>
                
                <!--图解-->
                <div class="chart bgc-f">
                	<div class="chart-list">
                        <div class="title">图解</div>
                        <div class="img">
                            <img src='${xuewei1}' />
                        </div>
                    </div>
                </div>
                
                <div class="h-list bgc-f">
                    <div class="title"><img src="img/idera2.png" /> <span>操作注意事项：</span></div>
                    <p>1、本次推拿时间3-5分钟</p>
                    <p>2、积食、便秘、保健、每日推拿1次；感冒、发烧、剧烈咳嗽，每日可推拿1~2次，建议高烧及剧烈咳嗽症状及时到医院检查。</p>
                    <p>3、每分钟推拿100次左右</p>
                    <p>4、按所处穴位顺序依次推拿，两次推拿间隔不得低于4小时。</p>
                </div>

                <div class="h-list bgc-f">
                    <div class="title"><img src="img/idera3.png" /> <span>护理建议：</span></div>
                    <p>${hulizhuyi }</p>
                </div>

                <div class="h-list bgc-f">
                    <div class="title"><img src="img/idera4.png" /> <span>提示：</span></div>
                    <p>1、发烧38.5度以上，要及时去医院就诊。</p>
                    <p>2、手脚冰凉的孩子必然会高热，要及时去医院就诊。</p>
                    <p>3、孩子腹痛时间超过10分钟，要及时去医院就诊。</p>
                    <p>4、发现孩子鼻梁暗滞时，孩子可能是鼻炎。</p>
                    <p>5、此系统只作为保健使用。</p>
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
        <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="dep-td/js/ydui.js"></script>
        <script src="js-td/health.js" type="text/javascript" charset="utf-8"></script>
       <script type="text/javascript">
            //          视频切换
              $(function() {
                var videoWrap = $('.video-wrap');  
                var pics = $('.chart-list>.img>img');
                $('.overflow .item').click(function() {
                    var src = $(this).attr('data-src'),
                        img = $(this).attr('data-img'),
                        pic = $(this).attr('data-pic');
                    $('#source').remove();
                    var video = '<video class="flv" id="source" controls poster="'+ img +'" src="'+ src +'" type="video/mp4"></video>';
                    videoWrap.append(video);  
                        
                    pics.attr('src',pic);
                })
            })

                
        </script>
</body>
</html>
