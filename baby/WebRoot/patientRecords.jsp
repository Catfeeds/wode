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
	if (user.getUpower()==0||user.getUpower()==1||user.getUpower()==2||user.getUpower()==3) { 
		
	} else {
		response.sendRedirect("noPower.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加诊断</title>
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
	
	
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #95B8E7;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	
	padding: 8px;
	border-style: solid;
	border-color: #95B8E7;
	background-color: #ffffff;
}
</style> 

  <script type="text/javascript">
			function doShow(k,i) {
				if(k==2) i--;
				if(k==3) i++;
				if(i==0) {alert("已经到第一页")} 
				else if (i-1=="${totalcount}") {alert("已经到最后一页")}
				else  {
					window.location.href="SearchRecordPageServlet?i="+i;
				}
			}
 </script>
		
  
</head>

<body leftmargin="8" topmargin="8">


<form name='form3' action='SearchRecordServlet' method='post'>
<input type='hidden' name='dopost' value='' />
<table width='100%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#7ac452' height=80px>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          	<td align='center'><span style="font-size:40px">姓名：</span></td>
          	<td width='160'>
          	<input type='text' id="name"  name="pname" value=''  style='width:150px;height:60px;font-size:28px'/>
          	</td>
        	<td><span style="font-size:40px">电话：</span></td>
        	<td>
          	<input type='text' id="phone"  name="phone" value=''  style='width:150px;height:60px;font-size:28px' />
        	</td>
        	<td>
    		&nbsp;&nbsp;<input type="radio" name="sex" value="女" style='width:30px;height:30px'/><span style="font-size:40px">女</span>&nbsp;&nbsp;&nbsp;
        	<input type="radio" name="sex" value="男" style='width:30px;height:30px'/><span style="font-size:40px">男</span>
        	</td>
        	<td>
          	&nbsp;&nbsp;<input name="imageField" type="image" src="skin/images/new/chaxun.png" style="width:160px;height:60px" border="0" class="np" />
        	</td>
       	 </tr>
       	</table>
       </td>
      </tr>
</table> 
</form>
  
<!--  内容列表   -->
<form name="form2">

<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#ffffff">
	<td height="24" colspan="10" background="skin/images/tbg.gif">&nbsp;<span style="font-size:60px">记录查询&nbsp;</span></td>
</tr>
<tr align="center" bgcolor="#7ac452" height="22">
	<td width="6%"><span style="font-size:35px">ID</span></td>
	<td width="13%"><span style="font-size:35px">姓名</span></td>
	<td width="30%"><span style="font-size:35px">症状</span></td>
	<td width="8%"><span style="font-size:35px">诊断</span></td>
	<td width="12%"><span style="font-size:35px">手法</span></td>
	<td width="15%"><span style="font-size:35px">时间</span></td>
	<td width="30%"><span style="font-size:35px">操作</span></td>
</tr>
<c:forEach items="${recordList }" var="record">
<tr align='center' bgcolor="#ffffff" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><span style="font-size:15px">${record.userid }</span></td>
	<td><u><span style="font-size:30px">${record.pname }</span></u></td>
	<td align="left"><span style="font-size:23px">${record.dyzz }</span></td>
	<td><span style="font-size:20px">${record.dycf }</span></td>
	<td><span style="font-size:30px">${record.dysf }</span></td>
	<td><span style="font-size:30px">${record.ctime }</span></td>
	<td><a href="ForwardToAddSymptom?pid=${record.pid}"><span style="font-size:40px;color:red">添加记录</span></a> </td>
	 <!--<td>
		<c:if test="${record.isdo==0 }"><a href="IsdoServlet?id='${record.cid }'&flag=0">未完成</a></c:if>
		<c:if test="${record.isdo==1 }"><a href="IsdoServlet?id='${record.cid }'&flag=1">已完成</a></c:if>
	</td> -->
</tr>
</c:forEach>

<tr align="right" bgcolor="#7ac452">
	<td align="center" colspan="3"><a href="javascript:void(0);" onClick="doShow(2,<%=i%>);"><img src="skin/images/new/back_btn.png"/></a></td>
	 <td align="left" colspan="2"><a href="javascript:void(0);" onClick="doShow(3,<%=i%>);"><img src="skin/images/new/next_btn.png"/></a></td>
	 <td align="left" colspan="3"><span style="font-size:35px">第${i}页/共${totalcount }页</span></td>
</tr>
</table>

</form>

</body>
</html>

