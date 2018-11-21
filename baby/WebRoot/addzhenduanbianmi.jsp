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
    <title>表单提交</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
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
	<header id="header" class="mui-bar mui-bar-nav">

	<a class="mui-action-back mui-icon-extra mui-icon-extra-arrowleftcricle mui-icon  mui-pull-left"></a>
		
			<h1 class="mui-title">辩证取穴 - 便秘</h1>
	</header>
	
	<div class="mui-content">
	 <form id="form4" action="InputBianmi" method="post">
		<ul class="mui-table-view">
			<!-- <li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectliuhan.jsp?xuanze=6"> 
					<span class="mui-badge my-list-wz">${str2liuhan}</span>
					流汗<input type="hidden" name="liuhan" value="${liuhan}"/> 
				</a>
			</li> -->
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectxingzhuang.jsp?xuanze=4"> 
					<span class="mui-badge my-list-wz">${str2xingzhuang}</span>
					性状<input type="hidden" name="xingzhuang" value="${xingzhuang}"/> 
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectqiwei.jsp?xuanze=4"> 
					<span class="mui-badge my-list-wz">${str2qiwei}</span>
					气味<input type="hidden" name="qiwei" value="${qiwei}"/> 
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectdabianyanse.jsp?xuanze=4"> 
					<span class="mui-badge my-list-wz">${str2dabianyanse}</span>
					大便颜色<input type="hidden" name="dabianyanse" value="${dabianyanse}"/> 
				</a>
			</li>
			<!-- <li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectchuzhen.jsp?xuanze=6"> 
					<span class="mui-badge my-list-wz">${str2chuzhen}</span>
					触诊<input type="hidden" name="chuzhen" value="${chuzhen}"/> 
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectwenzhen.jsp?xuanze=6"> 
					<span class="mui-badge my-list-wz">${str2wenzhen}</span>
					闻诊<input type="hidden" name="wenzhen" value="${wenzhen}"/> 
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectyanshen-img.jsp?xuanze=6">
					
					<span class="mui-badge my-list-wz">${str2yanshen}</span>
					眼神<input type="hidden" name="yanshen" value="${yanshen}"/> 
				</a>
			</li> 
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectmianse.jsp?xuanze=6">
					<span class="mui-badge my-list-wz">${str2mianse}</span>
					面色<input type="hidden" name="mianse" value="${mianse}"/>
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectxiayandai.jsp?xuanze=6">
					<span class="mui-badge my-list-wz">${str2xiayandai}</span>
					下眼袋<input type="hidden" name="xiayandai" value="${xiayandai}"/>
				</a>
			</li>
			<!-- <li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectbiliang.jsp?xuanze=6">
					<span class="mui-badge my-list-wz">${str2biliang}</span>
					鼻梁<input type="hidden" name="biliang" value="${biliang}"/>
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectbiyiliangce.jsp?xuanze=6">
					<span class="mui-badge my-list-wz">${str2biyiliangce}</span>
					鼻翼两侧<input type="hidden" name="biyiliangce" value="${biyiliangce}"/>
				</a>
			</li> 
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectchunse.jsp?xuanze=6">
					<span class="mui-badge my-list-wz">${str2chunse}</span>
					唇色<input type="hidden" name="chunse" value="${chunse}"/>
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectsheti.jsp?xuanze=6">
					<span class="mui-badge my-list-wz">${str2sheti}</span>
					舌体<input type="hidden" name="sheti" value="${sheti}"/>
				</a>
			</li>
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectshezhi.jsp?xuanze=6">
					<span class="mui-badge my-list-wz">${str2shezhi}</span>
					舌质<input type="hidden" name="shezhi" value="${shezhi}"/>
				</a>
			</li>
			<!-- <li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectshezhiyanse.jsp?xuanze=6">
					<span class="mui-badge my-list-wz">${str2shezhiyanse}</span>
					舌质颜色<input type="hidden" name="shezhiyanse" value="${shezhiyanse}"/>
				</a>
			</li> 
			<li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectshetai.jsp?xuanze=6">
					<span class="mui-badge my-list-wz">${str2shetai}</span>
					舌苔<input type="hidden" name="shetai" value="${shetai}"/>
				</a>
			</li>
			<!-- <li class="mui-table-view-cell">
				<a class="mui-navigate-right" href="from-selectyanhou.jsp?xuanze=6">
					<span class="mui-badge my-list-wz">${str2yanhou}</span>
					咽喉<input type="hidden" name="yanhou" value="${yanhou}"/>
				</a>
			</li> -->
		</ul>
	    </form>
	    <div class="mui-content-padded">
	        <button form="form4" type="submit" class="mui-btn my-btn mui-btn-block">提交</button>
	    </div>
	</div>
	
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>