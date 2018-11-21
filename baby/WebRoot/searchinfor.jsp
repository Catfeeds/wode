<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.dao.*"%>
<%@ page import="com.bean.*"%>
<%
	User myUser =(User)request.getSession().getAttribute("user");
	//未登录状态
	if (myUser == null) { 
		response.sendRedirect("login.jsp");
		return;
	} else {
	
	}
%>
<% 
	int i=Integer.parseInt((request.getSession().getAttribute("i")).toString());
%>
<%
	User user =(User)request.getSession().getAttribute("user");
	//未登录状态
	if (user.getUpower()==0||user.getUpower()==1||user.getUpower()==2) { 
		
	} else {
		response.sendRedirect("login.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html >   
<head>
	<meta charset="utf-8">
    <title>选择宝宝</title>
    <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" name="viewport" />
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <meta content="telephone=no" name="format-detection" />
    <script src="dep-td/js/ydui.flexible.js"></script>
    <link rel="stylesheet" type="text/css" href="css-td/health.css" />
    <link rel="stylesheet" href="dep-td/css/ydui.css" />
    <script type="text/javascript">
    	
   		document.addEventListener('plusready', function(){
   			//console.log("所有plus api都应该在此事件发生后调用，否则会出现plus is undefined。"
   			
   		});
   		
    </script>
</head>
<body>
	<div class="g-flexview bgc-f">
            <div class="g-scrollview bgc-flower">
            	<div class="navigation">
                    <a class="back" href="javascript:;" onclick="javascript:history.back(-1);"><img src="img/back.png" /></a>
                    <div class="navigation-title">选择宝宝</div>
                    <a class="search" href="inputinfor.jsp"><img src="img/add.png" /></a>
                </div>
                
                <div class="line"></div>
                <div class="choose-list">
                    <c:forEach items="${patientList }" var="p">
                    	
	                    <a href="ForwardToAddSymptom?pid=${p.pid}&pname=${p.pname }&userid=${user.userid}&fid=${user.fid}&zhuyibh=${zhuyibh}&selplan=${selplan}&age=${p.page }'" class="choose-item">
	                        <c:if test="${p.pxb == '男'}">
	                        <img src="img/boy.png" />
	                        </c:if>
	                        
	                         <c:if test="${p.pxb == '女'}">
	                        <img src="img/girl.png" />
	                        </c:if>
	                        <p> ${p.pname }</p>
	                    </a>
	                 </c:forEach>
                </div>

            </div>
        </div>
        <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="dep-td/js/ydui.js"></script>
	
	</body>
</html>
