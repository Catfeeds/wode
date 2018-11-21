<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
    <%@ page import="com.dao.*"%>
	<%@ page import="com.bean.*"%>
    <%
	User user =(User)request.getSession().getAttribute("user");
	//未登录状态
	if (user!=null) { 
		
	} else {
		response.sendRedirect("login.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>健康管理中心</title>
<link type="text/css" href="css/menu.css" rel="stylesheet" />
  <link type="text/css" href="css/zhuce.css" rel="stylesheet" />
  <link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>

<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

  <form name='form3' action="SearchPatientServlet" method="post">
<input type='hidden' name='dopost' value='' />
<table width='100%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#FFF5EE' align="center" style="margin-top:8px">
  <tr bgcolor='#FFB6C1' height='80px'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr >
          <td style="background:url();" align='center'><span style="font-size:40px">姓名：</span></td>
          <td>
          	<input type='text' id="name"  name="name" value='' style='width:150px;height:60px;font-size:28px' />
        </td>
        <td style="background:url();"><span style="font-size:40px">&nbsp;&nbsp;电话：</span></td>
        <td>
          	<input type='text' id="phone"  name="phone" value='' style='width:150px;height:60px;font-size:28px' />
        </td>
        <td style="background:url();"><span style="font-size:40px">&nbsp;&nbsp;地区：</span></td>
        <td>
          	<input type='text' id="phone"  name="phone" value='' style='width:150px;height:60px;font-size:28px' />
        </td>
        <td>
          &nbsp;&nbsp;<input name="imageField" type="image" src="skin/images/new/chaxun.png" style="width:160px; height:60px; border:0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
  
</table>
</form>
  
<!--  内容列表   -->
<form name="form2" action="AddAgentServlet" method="post">
<table id="dayin" width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA"  style="margin-top:8px,align:center">
	
	
	<tr bgcolor="#ffffff" align="center" >
		<td height="24" colspan="10" background="skin/images/tbg.gif"><span style="font-size:30px;">&nbsp;修改代理商&nbsp;</span></td>
	</tr>
	<c:forEach items="${updatelist }" var="u">
	<tr align="center" bgcolor="#FFB6C1" height="22">
		<td>
		<br><span style="font-size:35px;">输入姓名：</span>
			<input type="text" name="agname" value="${u.fname }" style="font-size:35px;width:300px;height:60px"/>
		</td>
	</tr>
	
	<tr align="center" bgcolor="#FFB6C1" height="22">
		<td>
		<br><span style="font-size:35px;">输入电话：</span>
		<input type="text" name="agaddress"  value="${u.phone}" style="font-size:35px;width:300px;height:60px"/>
		</td>
	</tr>
	</c:forEach>
	<tr align="center" bgcolor="#FFB6C1" height="18px">
		<td colspan="3">
			<br><input id="addRecord" type="submit"  class="submit-xgmima"  value=""/><br>
		</td>
	</tr>
</table>
</form>

</body>
</html>