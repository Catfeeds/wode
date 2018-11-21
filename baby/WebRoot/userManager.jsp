<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	int i=Integer.parseInt((request.getSession().getAttribute("i")).toString());
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title>
 <link type="text/css" href="css/menu.css" rel="stylesheet" />
  <link type="text/css" href="css/zhuce.css" rel="stylesheet" />
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
  <script type="text/javascript">
  		$(function() {
	  		$("#add").click(function() {
	  			window.location.href="ForwardToAddUserServlet";
	  		});
  		});
  </script>
  <script type="text/javascript">
			function doShow(k,i) {
				if(k==2) i--;
				if(k==3) i++;
				if(i==0) {alert("已经到第一页")} 
				else if (i-1=="${totalcount}") {alert("已经到最后一页")}
				else  {
					window.location.href="UserManagerPageServlet?i="+i;
				}
			}
		</script>
  
</head>

<body>

<div class="form-bak-search">
<form action="UserManagerServlet" method="post">姓名：
<input type="text" id="name"  name="name"  value="">
职位：
<select name="post">
	<option value="">全部</option>
	<option value="0">超级管理员</option>
	<option value="1">分部管理员</option>
	<option value="2">医生</option>
	<option value="3">按摩师</option>
	<option value="4">医生&按摩师</option>
</select>
分部：
<select name="fid">
	<option value="">全部</option>
	<c:forEach items="${fenbuList }" var="fenbu">
		<option value="${fenbu.fid }">${fenbu.fname }</option>
	</c:forEach>
	
</select>
<input type="submit"  name="submit" value="搜索">
</form>
</div>
<input type="button" id="add" name="addUser" value="添加用户">
<div class="form-bak1">


<table class="gridtable">
<tr>
    <th >账号</th>
    <th >姓名</th>
    <th >岗位</th>
    <th >所在地区</th>
    <th >创建者</th>
    <th >密码重置</th>
    <th >操作</th>
  </tr>
	<c:forEach items="${userList }" var="user">
	<tr>
		<td>
			${user.loginName }
		</td>
		<td>
			${user.uname }
		</td>
		<td>
			${user.postName }
		</td>
		<td>
			${user.fenbuName }
		</td>
		<td>
			${user.createName }
		</td>
		<td>
		<a href="RestPasswordServlet?userid=${user.userid }">重置</a>
		</td>
		<td>
		<a href="ForwardToEditUserServlet?userid=${user.userid }">编辑</a>
		<!--  
		-->
		</td>
		</tr>
	</c:forEach>
	<tr>
	 <td><a href="javascript:void(0);" onClick="doShow(2,<%=i%>);">上一页</a></td>
	 <td><a href="javascript:void(0);" onClick="doShow(3,<%=i%>);">下一页</a></td>
	 <td>第${i}页/共${totalcount }页</td>
 </tr>
</table>
</div>
</body>
</html>

