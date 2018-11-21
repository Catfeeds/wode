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
    
    <title>玖壹康宁小儿健康管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="skin/css/base.css">
  </head>
  
  <body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#CD6079" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  	<td align="center">
  		<a href="Http://www.jynxetn.com"><input type='button' class="coolbg np" onClick="location='';" value='玖' /></a>
	    <a href="Http://www.jynxetn.com"><input type='button' class="coolbg np" onClick="location='';" value='壹' /></a>
	    <a href="Http://www.jynxetn.com"><input type='button' class='coolbg np' onClick="location='';" value='康' /></a>
	    <a href="Http://www.jynxetn.com"><input type='button' class="coolbg np" onClick="location='';" value='宁' /></a>
	    <a href="Http://www.jynxetn.com"><input type='button' class="coolbg np" onClick="location='';" value='欢' /></a>
	    <a href="Http://www.jynxetn.com"><input type='button' class="coolbg np" onClick="location='';" value='迎' /></a>
	    <a href="Http://www.jynxetn.com"><input type='button' class="coolbg np" onClick="location='';" value='您' /></a>
	    <a href="Http://www.jynxetn.com"><input type='button' class="coolbg np" onClick="location='';" value='！' /></a>
 	</td> 
 </tr>
</table>
</td>
</tr>
</table>
  
<!--  内容列表   -->
<form name="form2" action="" method="post">
<table id="dayin" width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
	<tr bgcolor="#E7E7E7" align="center" >
		<td height="24" colspan="10" background="skin/images/tbg.gif"><span style="font-size:30px;">&nbsp;欢迎光临&nbsp;</span></td>
	</tr>
	
	<tr bgcolor="#FFF5EE">
	  	<td align="left"  height="700px" valign="top">
	  		<h1 style="text-align:center;color:red; font-size:30px">系统使用方法</h1>
	  		<span style="align:left;color:#225a1f;font-size:20px">1、录入宝宝信息</span><br/>
	  		<span style="text-align:left;color:#225a1f;font-size:20px">2、(1)进入选择症状主页
	  				  </span><br/>
	  	    <span style="text-align:left;color:#225a1f; font-size: 20px;">
	  	                 (2)点选症状:因为是单选，点选时要以主要症状为主，也就是主诉。<br/>
	  	                                                       例1：咽痛，流涕，鼻塞要以咽痛为主症点选。<br/>
	  	    				  例2：咳嗽有痰，咽痛，流涕就以咳嗽有痰为主要症状。<br/>
	  	                	  例3：呕吐，腹泻，流涕也是选一个主要症状。</span><br/>
	  	    <span style="text-align:left;color:#225a1f; font-size: 20px;">(3)点选体征：按照实际观察到的体征输入</span><br/>
	  	    <span style="text-align:left;color:#225a1f; font-size: 20px;">(4)提交后获得穴位组合</span><br/>
	  	    <span style="text-align:left;color:#225a1f; font-size: 20px;">(5)打印穴位组合及护理</span>
	  	</td>
  </tr>
</table>

</form>

<!--  搜索表单  -->

</body>
</html>
