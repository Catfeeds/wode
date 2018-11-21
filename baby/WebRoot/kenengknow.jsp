<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<!DOCTYPE html>
<html>

<head>
<title>注意事项</title>
<meta name="viewport" content="width=1120,user-scalable=no" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link type="text/css" href="css/menu.css" rel="stylesheet" />
<link type="text/css" href="css/zhuce.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
<script src="js/jquery.min.js"></script>
<script src="js/jquery-1.8.0.min.js"></script>
<script src="js/this.js?/main.html"></script>
<script type="text/javascript">
	$(function() {
		function adaptValue() {
			//校验数据
			//数据合法返回true，否则返回false，并提示用户
			return true;
		}
	});
</script>
<style type="text/css">
table.gridtable {
	width: 100%;
	font-family: verdana, arial, sans-serif;
	font-size: 13px;
	color: #333333;
	border-width: 1px;
	border-color: #95B8E7;
	border-collapse: collapse;
}

table.gridtable th {
	width: 15%;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #95B8E7;
	background-color: #dedede;
}

table.gridtable td {
	width: 15%;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #95B8E7;
	background-color: #ffffff;
}

option{
	font-size:18px;
}
</style>
<script type="text/javascript">
	$(function(){
		$("option").each(function() {
			if($(this).val()=="${bh}") {
				$(this).attr('selected',true);
			}
		})
		
	});
</script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮 
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#CD6079" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
	  <td>
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
</table> -->
  
<!--  内容列表   -->
<form name="form2" action="SearchKenengServlet" method="post">

<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
	<tr bgcolor="#ffffff">
		<td height="24" colspan="10" background="skin/images/tbg.gif">&nbsp; <span style="font-size:60px;">注意事项</span>&nbsp;</td>
	</tr>

	<tr align="center" bgcolor="#7AC452" height="22">
		<td  colspan="10">
		<span style="font-size:40px;"></br>选择症状：</span>
			<select name="keneng" id=select style="font-size:30px;height:60px;width:300px">
				
				<option value="qingxuanze">请选择</option>
				<option value="05">腹痛</option>
				<option value="06">呕吐</option>
				<option value="011">发热</option>
				<option value="08">积食</option>
				<!--  <option value="012">咳嗽</option>
				<option value="013">鼻炎</option>-->
				<option value="07">宝宝的日常注意</option>
				<option value="021">消化道</option>
				<!-- <option value="031">疹子</option>
				<option value="041">其他</option>
				<option value="042">幼儿急疹</option> -->
					
				</select> <br/><br/>
				<center>
				<input name="imageField" type="image" src="images/search03.png"  style="width:260px; height:80px; border:0" class="np" />
			  	</center>
				</td>
			</tr>
				<tr bgcolor="#7AC452" align="left"  >
					<td style="font-size:40px;height:40px;width:300px; font-color:red;" colspan="9">${kn.bingzheng }</td>
		   			<td style="font-size:40px;height:40px; width:1300px;">${kn.qingkuang }</td>
					
				</tr>
</table>
</form>
<table>
<tr align="left" bgcolor="#7AC452">
	<td height="50px" colspan="10" align="center">
	    <span style="text-align:center;font-size:40px"><h2>${richang.rcmc}</h2></span>
	</td>
</tr>

<tr align="left" bgcolor="#7AC452">
	<td height="50px" colspan="10" align="left">
	    <span style="text-align:left;font-size:30px"><h2>${richang.neirong}</h2></span>
	</td>
</tr>
</table>

</body>
</html>