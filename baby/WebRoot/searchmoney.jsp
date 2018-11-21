<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	int i=Integer.parseInt((request.getSession().getAttribute("i")).toString());
%>
<%
	User user =(User)request.getSession().getAttribute("user");
	//未登录状态
	if (user.getUpower()==0||user.getUpower()==1||user.getUpower()==2) { 
		
	} else {
		response.sendRedirect("noPower.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>   
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>健康管理系统</title>
 <link type="text/css" href="css/menu.css" rel="stylesheet" />
 <link type="text/css" href="css/zhuce.css" rel="stylesheet" /> 
 <link rel="stylesheet" type="text/css" href="skin/css/base.css"> 
  <style type="text/css">
table.gridtable {
	width:100%;
	font-family: verdana,arial,sans-serif;
	font-size:13px;
	color:#333333;
	border-width: 1px;
	border-color: #95B8E7;
	border-collapse: collapse;
}
table.gridtable th {
	width:15%;
	
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #95B8E7;
	background-color: #dedede;
}
table.gridtable td {
	width:15%;
	border-width: 1px;
	
	padding: 8px;
	border-style: solid;
	border-color: #95B8E7;
	background-color: #ffffff;
}
</style>  

</head>

<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<form name='form4' action="UpdateAgentServlet" method="post">
<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">

<tr bgcolor="#ffffff">
	<td height="24" colspan="9" background="skin/images/tbg.gif">&nbsp;<spanstyle="font-size:30px">金额信息</span>&nbsp;</td>
</tr>
<tr align="center" bgcolor="#ff7084" height="22">
	<td width="15%"><span style="font-size:35px">姓名</span></td>
	<td width="25%"><span style="font-size:35px">下级人数</span></td>
	<td width="15%"><span style="font-size:35px">下级共点击数</span></td>
	<td width="20%"><span style="font-size:35px">所得金额</span></td>
	<c:if test="${user.upower==0}">
		<td width="25%"><span style="font-size:35px">操作</span></td>
	</c:if>
</tr>
<tr align='center' bgcolor="#FFFfff" onMouseMove="javascript:this.bgColor='#ffffff';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><span style="font-size:30px">${name}</span></td>
	<td align="center"><span style="font-size:30px">${xjsize}</span></td>
	<td><span style="font-size:30px">${sumclick }</span></td>
	<td><span style="font-size:30px">${summoney }元</span></td>
	<c:if test="${user.upower==0}">
		<td>
			<a href="JieSuanQingLing?uid=${intuid}&?name=${name}"><span style="font-size:30px">结算</span></a><br/>
		</td>
	</c:if>
</tr>

</table>

</form>

</body>
</html>
