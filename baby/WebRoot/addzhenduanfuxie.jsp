<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.dao.*"%>
<%@ page import="com.bean.*"%>

<%
    User myUser =(User)request.getSession().getAttribute("user");
    //未登录状态
    if (myUser == null) { 
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
<head>
    <meta charset="utf-8">
    <title>症状选择</title>
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
     <form id="form3" action="InputFuxie" method="post">
        <div class="g-flexview bgc-f">
            <div class="g-scrollview bgc-flower">
                <div class="navigation">
                    <a class="back" href="javascript:;" onclick="javascript:history.back(-1);"><img src="img/back.png" /></a>
                    <div class="navigation-title">推拿取穴-腹泻</div>
                </div>

                <div class="sym bgc-f">
                    <div class="m-cell symptom">
                    	<!-- <div class="cell-item">
	                        <div class="cell-left">度数</div>
	                        <div class="cell-right"><input id="limit" type="number" class="cell-input" placeholder="单击输入" autocomplete="off" step="0.1"/>℃</div>
                  		 </div> -->
                        <div class="cell-item">
                            <div class="cell-left">腹泻性状</div>
                            <label class="cell-right">
                                <select class="cell-select" name="xingzhuang">

                                    <option value="01_不消化物">不消化物</option>
                                    <option value="02_糊状">糊状</option>
                                    <option value="03_蛋花状">蛋花状</option>
                                    <option value="04_水样">水样</option>
                                    <option value="05_脓状物">脓状物</option>
                                </select>
                                <img src="img/enter.png"/>
                            </label>
                         </div>

                        <div class="cell-item">
                            <div class="cell-left">气味</div>
                            <label class="cell-right">
                                <select class="cell-select" name="qiwei">
                                    <option value="01_正常">正常</option>
                                    <option value="02_大便臭">大便臭</option>
                                    <option value="03_大便酸臭">大便酸臭</option>
                                    <option value="04_大便腥味">大便腥味</option>
                                </select>
                                <img src="img/enter.png"/>
                            </label>
                        </div>

                        <a  class="cell-item" id="color" href="from-selectdabianyanse.jsp?xuanze=3">
                            <div class="cell-left">大便颜色</div>
                            <label class="cell-right">
                                <input id="color1" class="cell-input" type="text"  name="dabianyanse" value="黄色" readonly/>
                                <!-- <input class="cell-input" type="hidden"  name="dabianyanse" value="黄色" readonly/> -->
                                <img src="img/enter.png"/>
                            </label>
                        </a>
                    </div>

                    <!--颜色-->

                </div>
            </div>
        </div>
       </form>
        
        <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="dep-td/js/ydui.js"></script>
        <script type="text/javascript">
             var data = sessionStorage.getItem('shitfuxie');
             $('#color1').val(data)
        </script>

       <button form="form3" type="submit" class="btn-block  present">提交</button>

</body>
</html>