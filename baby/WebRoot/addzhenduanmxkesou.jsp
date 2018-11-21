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
		<form id="form1" action="InputMxkesou" method="post">
            <div class="g-scrollview">
                <div class="navigation">
                    <a class="back" href="javascript:;" onclick="javascript:history.back(-1);"><img src="img/back.png" /></a>
                    <div class="navigation-title">慢性咳嗽</div>
                </div>

                <!--症状-->
                <div class="m-cell symptom">
                    <label class="cell-item">
                        <label class="cell-left">活动后咳嗽剧烈</label>
                    <label class="cell-right">
                            <input type="checkbox" name="mxkesou" value="活动后咳嗽剧烈"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>
                    <label class="cell-item">
                        <label class="cell-left">睡前咳，醒后咳</label>
                    <label class="cell-right">
                            <input type="checkbox" name="mxkesou" value="睡前咳，醒后咳"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>
                    <label class="cell-item">
                        <label class="cell-left">换季咳嗽频繁</label>
                    <label class="cell-right">
                            <input type="checkbox" name="mxkesou" value="换季咳嗽频繁"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>

                    <label class="cell-item">
                        <label class="cell-left">吭吭清嗓子</label>
                    <label class="cell-right">
                            <input type="checkbox" name="mxkesou" value="吭吭清嗓子"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>

                    <label class="cell-item">
                        <label class="cell-left">刺激性干咳</label>
                    <label class="cell-right">
                            <input type="checkbox" name="mxkesou" value="刺激性干咳"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>

                    <label class="cell-item">
                        <label class="cell-left">过敏性咳嗽</label>
                    <label class="cell-right">
                            <input type="checkbox" name="mxkesou" value="过敏性咳嗽"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>

                    <label class="cell-item">
                        <label class="cell-left">打呼噜</label>
                    <label class="cell-right">
                            <input type="checkbox" name="mxkesou" value="打呼噜"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>
                    
                     <label class="cell-item">
                        <label class="cell-left">干咳</label>
                    <label class="cell-right">
                            <input type="checkbox" name="mxkesou" value="干咳"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>
                    
                     <label class="cell-item">
                        <label class="cell-left">咳嗽有痰</label>
                    <label class="cell-right">
                            <input type="checkbox" name="mxkesou" value="咳嗽有痰"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>
                    
                    <label class="cell-item">
                        <label class="cell-left">早晨咳嗽频繁</label>
                    <label class="cell-right">
                            <input type="checkbox" name="mxkesou" value="早晨咳嗽频繁"/>
                            <label class="cell-checkbox-icon"></label>
                    </label>
                    </label>


					<label class="cell-item">
                        <label class="cell-left">夜间咳嗽频繁</label>
                    <label class="cell-right">
                            <input type="checkbox" name="mxkesou" value="夜间咳嗽频繁"/>
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