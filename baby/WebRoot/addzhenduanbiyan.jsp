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
	<div class="g-flexview bgc-imgt">
		<form id="form1" action="InputBiyan" method="post">
            <div class="g-scrollview">
                <div class="navigation">
                    <a class="back" href="javascript:;" onclick="javascript:history.back(-1);"><img src="img/back.png" /></a>
                    <div class="navigation-title">鼻炎</div>
                </div>

                <!--症状-->
                <div class="m-cell symptom">
                    <label class="cell-item">
                        <label class="cell-left">鼻塞</label>
                    <label class="cell-right">
                            <input type="checkbox" name="biyan" value="鼻塞"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>
                    <label class="cell-item">
                        <label class="cell-left">流清水鼻涕</label>
                    <label class="cell-right">
                            <input type="checkbox" name="biyan" value="流清水鼻涕"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>
                    <label class="cell-item">
                        <label class="cell-left">黄鼻涕</label>
                    <label class="cell-right">
                            <input type="checkbox" name="biyan" value="黄鼻涕"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>

                    <label class="cell-item">
                        <label class="cell-left">白黏鼻涕</label>
                    <label class="cell-right">
                            <input type="checkbox" name="biyan" value="白黏鼻涕"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>

                    <label class="cell-item">
                        <label class="cell-left">向后吸鼻子</label>
                    <label class="cell-right">
                            <input type="checkbox" name="biyan" value="向后吸鼻子"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>

                    <label class="cell-item">
                        <label class="cell-left">清嗓子</label>
                    <label class="cell-right">
                            <input type="checkbox" name="biyan" value="清嗓子"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>

                    <label class="cell-item">
                        <label class="cell-left">耸鼻子</label>
                    <label class="cell-right">
                            <input type="checkbox" name="biyan" value="耸鼻子"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>
                    
                     <label class="cell-item">
                        <label class="cell-left">鼻出血</label>
                    <label class="cell-right">
                            <input type="checkbox" name="biyan" value="鼻出血"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>
                    
                     <label class="cell-item">
                        <label class="cell-left">鼻干燥</label>
                    <label class="cell-right">
                            <input type="checkbox" name="biyan" value="鼻干燥"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>
                    
                    <label class="cell-item">
                        <label class="cell-left">抠鼻子</label>
                    <label class="cell-right">
                            <input type="checkbox" name="biyan" value="抠鼻子"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>


					<label class="cell-item">
                        <label class="cell-left">打呼噜</label>
                    <label class="cell-right">
                            <input type="checkbox" name="biyan" value="打呼噜"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>
                    
                </div>

                <button form="form1" id="submit" type="submit" class="btn-block  present">提交</button>
            </div>
        </div>
        <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="dep-td/js/ydui.js"></script>
        <script type="text/javascript">
            $('#submit').click(function() {
                var limit = $('#limit').val(),
                    arr = [];//选中的症状
                $.each($('input:checkbox:checked'), function() {
                    console.log($(this).val())
                    arr.push($(this).val())
                });
                if(limit == '') {
                    YDUI.dialog.toast('请输入度数', 'none', 1000);
                    return false;
                }
                
            })
        </script>
</body>
</html>