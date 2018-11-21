<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.dao.*"%>
<%@ page import="com.bean.*"%>
<%
	User myUser =(User)request.getSession().getAttribute("user");
	//未登录状态
	if (myUser == null) { 
		response.sendRedirect("xuanzejiemian.jsp");
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
    
    <title>玖壹康宁小儿健康管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="skin/css/base.css" type="text/css"/>
<link rel="stylesheet" href="skin/css/menu.css" type="text/css" />

<script language='javascript'>var curopenItem = '1';</script>
<script language="javascript" type="text/javascript" src="skin/js/frame/menu.js"></script>
<base target="main" />
</head>
  
  <body target="main">
<table width='98%' height="100%" border='0' cellspacing='0' cellpadding='0'>
  <tr>
    <!-- Item 1 Strat -->
    <td style='padding-left:20px;border:5px;' align="center">
	     
    	<a href='InfInputServlet' target='main'><img src="../images/input.png"></a>
    </td>
    <!-- Item 1 End -->
      
      
     <!-- Item 2 Strat -->
       <td style='padding-left:3px;'align="center" >
            <a href='SearchPatientXinxiServlet?w=1' target='main'><img src="../images/caidan2.png"></a> 
       </td>
      <!-- Item 2 End -->
      
      <!-- Item 3 Strat -->
      <td align="center">
      	<a href='SearchRecordServlet' target='main'><img src="../images/caidan3.png"></a>
       </td>
      <!-- Item 3 End -->

    <!-- Item 4 Strat -->
      <td align="center">
	  	<a href='Photoknow' target='main'><img src="../images/caidan4.png"></a>
      </td>
     <!-- Item 4 End -->
     
     <!-- Item 4 Strat -->
      <td align="center">
		    <a href='Kenengknow' target='main'><img src="../images/caidan5.png"></a>
       </td>
     <!-- Item 4 End -->

	 <!-- Item 5 Strat -->
	  <td align="center">
      <a href='ForwardToEditPassServlet' target='main'><img src="../images/caidan6.png"></a>
       </td>
      <!-- Item 5 End -->
      
	 <!-- Item 6 Strat -->
	 <%
	 if(user.getUpower()==0){
	    %>
	  <td align="center">
      <a href='SearchAgentServlet?w=1' target='main'><img src="../images/caidan8.png"></a>
       </td>
       <%
       }
       %>
      <!-- Item 6 End -->
  </tr>
</table>
  </body>
</html>
