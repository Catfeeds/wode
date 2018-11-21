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

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>选择颜色</title>
    <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" name="viewport" />
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <meta content="telephone=no" name="format-detection" />
    <link rel="stylesheet" href="dep-td/css/ydui.css" />
    <script src="dep-td/js/ydui.flexible.js"></script>
    <link rel="stylesheet" type="text/css" href="css-td/health.css" />
    <link rel="stylesheet" type="text/css" href="css-td/swiper.min.css" />
	 <style type="text/css">
        .swiper-wrapper {
            margin-left: .4rem;
            padding-bottom: .3rem;
        }
    </style>
    <script type="text/javascript">
    	
   		document.addEventListener('plusready', function(){
   			//console.log("所有plus api都应该在此事件发生后调用，否则会出现plus is undefined。"
   			
   		});
   		
    </script>

  </head>
  
  <body>
     <div class="g-flexview">
            <div class="g-scrollview">
                <div class="navigation">
                    <a class="back" href="javascript:;" onclick="javascript:history.back(-1);"><img src="img/back.png" /></a>
                    <div class="navigation-title">大便颜色</div>
                </div>

                <div class="color-block">

                    <div class="color-list">
                        <div class="m-cell">
                            <label class="cell-item">
                                    <span class="cell-left">黄色</span>
                                    <label class="cell-right">
                                    	<input type="hidden" name="xuanze" value="<%=request.getParameter("xuanze")%>"/>
                                        <input type="radio" name="dabianyanse"  value="黄色" checked/>
                                        <i class="cell-radio-icon"></i>
                                    </label>
                            </label>
                            <div class="swiper-container color-img bgc-f">
                                <div class="swiper-wrapper">
                                    <div class="swiper-slide"><img src="img/db-huang1.jpg" /></div>
                                    <div class="swiper-slide"><img src="img/db-huang2.jpg" /></div>
                                </div>
                            </div>
                            <label class="cell-item">
                                    <span class="cell-left">黄褐色</span>
                                    <label class="cell-right">
                                        <input type="radio" name="dabianyanse" value="黄褐色"/>
                                        <i class="cell-radio-icon"></i>
                                    </label>
                            </label>
                            <div class="swiper-container color-img bgc-f">
                                <div class="swiper-wrapper">
                                    <div class="swiper-slide"><img src="img/db-huanghe1.jpg" /></div>
                                    <div class="swiper-slide"><img src="img/db-huanghe2.jpg" /></div>
                                </div>
                            </div>

                            <label class="cell-item">
                                    <span class="cell-left">绿色</span>
                                    <label class="cell-right">
                                        <input type="radio" name="dabianyanse" value="绿色"/>
                                        <i class="cell-radio-icon"></i>
                                    </label>
                            </label>
                            <div class="swiper-container color-img bgc-f">
                                <div class="swiper-wrapper">
                                    <div class="swiper-slide"><img src="img/db-lv1.jpg" /></div>
                                    <div class="swiper-slide"><img src="img/db-lv2.jpg" /></div>
                                    <div class="swiper-slide"><img src="img/db-lv3.jpg" /></div>
                                    <div class="swiper-slide"><img src="img/db-lv4.jpg" /></div>
                                </div>
                            </div>

                        </div>
                        <button id="submit" type="submit" class="btn-block btn-primary login-btn">确定</button>
                    </div>

                </div>
            </div>
        </div>
        <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="dep-td/js/ydui.js"></script>
        <script src="js-td/swiper.min.js" type="text/javascript" charset="utf-8"></script>
        <script>
        $('#submit').click(function(){
                var val = $("input[type='radio']:checked").val();
                sessionStorage.setItem('shitbianmi', val);
                window.history.back();
            })
            var swiper = new Swiper('.swiper-container', {
                slidesPerView: 2,
                spaceBetween: 0,
                pagination: {
                    el: '.swiper-pagination',
                    clickable: true,
                },
            });
        </script>
  </body>
</html>
