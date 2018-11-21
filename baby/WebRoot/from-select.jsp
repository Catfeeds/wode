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
  <head>
    <base href="<%=basePath%>">
    
    <title>表单提交</title>
     <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css-changsha/mui.css">
    <link rel="stylesheet" type="text/css" href="css-changsha/icons-extra.css" />
    <link rel="stylesheet" href="css-changsha/main.css">
    <script type="text/javascript">
    	
   		document.addEventListener('plusready', function(){
   			//console.log("所有plus api都应该在此事件发生后调用，否则会出现plus is undefined。"
   			
   		});
   		
    </script>

  </head>
  
  <body>
  <form name="form2" action="addzhenduanshanghuxidao.jsp" method="post">
	   <header id="header" class="mui-bar mui-bar-nav">
	<button class="mui-btn mui-btn-blue mui-btn-link mui-pull-right" >确定</button>
		<a class="mui-action-back mui-icon mui-icon-extra mui-icon-extra-arrowleftcricle mui-pull-left"></a>
				<h1 class="mui-title">辩证取穴 - 感冒</h1>
		</header>
		<div class="mui-content">
			<ul class="mui-table-view">
				<li class="mui-table-view-cell">
					<a class="mui-navigate-right" href="from-list.html">
						<input name="bisai" type="radio" value="02_是_鼻塞">是
					</a>
				</li>
				<li class="mui-table-view-cell">
					<a class="mui-navigate-right" href="from-list.html">
						<input name="bisai" type="radio" value="01_否_-">否
					</a>
				</li>
			</ul>
		</div>
	</form>
	<script src="js-changsha/mui.min.js"></script>
  </body>
</html>
