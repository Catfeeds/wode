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
	
	 <form id="form6" action="InputJishi" method="post">
		<div class="g-flexview bgc-imgt">
            <div class="g-scrollview">
                <div class="navigation">
                    <a class="back" href="javascript:;" onclick="javascript:history.back(-1);"><img src="img/back.png" /></a>
                    <div class="navigation-title">积食</div>
                </div>

                <!--症状-->
                <div class="m-cell symptom">
					<!-- <div class="cell-item">
	                        <div class="cell-left">度数</div>
	                        <div class="cell-right"><input id="limit" type="number" class="cell-input" placeholder="单击输入" autocomplete="off" step="0.1"/>℃</div>
                  	</div> -->
                    <label class="cell-item">
                        <label class="cell-left">食欲差</label>
                    <label class="cell-right">
                            <input type="checkbox" name="jishi" value="食欲差"/>
                            <i class="cell-checkbox-icon"></i>
                    </label>
                    </label>
                    <label class="cell-item">
                        <label class="cell-left">挑食</label>
                    <label class="cell-right">
                            <input type="checkbox" name="jishi" value="挑食"/>
                            <i class="cell-checkbox-icon"></i>
                    </label>
                    </label>
                    <label class="cell-item">
                        <label class="cell-left">厌食</label>
                    <label class="cell-right">
                            <input type="checkbox" name="jishi" value="厌食"/>
                            <i class="cell-checkbox-icon"></i>
                    </label>
                    </label>

                    <label class="cell-item">
                        <label class="cell-left">有口气</label>
                    <label class="cell-right">
                            <input type="checkbox" name="jishi" value="有口气"/>
                            <i class="cell-checkbox-icon"></i>
                    </label>
                    </label>
                    
                    <a  class="cell-item" id="color" href="from-selectshetaihou.jsp?xuanze=5">
	                           <div class="cell-left">舌苔厚</div>
	                           <label class="cell-right">
	                               <input id="color1" class="cell-input" type="text"  name="shetaihou" value="舌苔不厚" readonly/>
	                               <!-- <input class="cell-input" type="hidden"  name="shetaihou" value="${shetaihou}" readonly/> -->
	                               <img src="img/enter.png"/>
	                           </label>
	                  </a>

                </div>

            </div>
        </div>
       </form>
        <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="dep-td/js/ydui.js"></script>
        <script type="text/javascript">
             var data = sessionStorage.getItem('shitjishi');
             $('#color1').val(data)
        </script>
        <button form="form6" type="submit" class="btn-block  present">提交</button>
	   
</body>
</html>