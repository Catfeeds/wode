<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<!DOCTYPE html>
<html>

<head>
<title>图片认知</title>
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
			if($(this).val()=="${ppower}") {
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
</table>-->
  
<!--  内容列表   -->
<form name="form2" action="SearchPhoServlet" method="post">

<table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
	<tr bgcolor="#ffffff">
		<td height="24" colspan="10" background="skin/images/tbg.gif">&nbsp; <span style="font-size:60px;">图片分享</span>&nbsp;</td>
	</tr>

	<tr  bgcolor="#7ac452" height="22">
		<td  colspan="8" align="center">
			<span style="font-size:40px;"><br>选择图片名称：</span>
			<select name="ppower" id=select style="font-size:30px;height:60px;weidth:300px;">
				
					<option value="0">请选择</option>
					<!-- 唇色 -->
					<option value="101">唇色-淡红</option>
					<option value="102">唇色-红</option>
					
					<!-- 舌头 -->
					<option value="207">舌质-细柔</option>
					<option value="208">舌质-粗糙</option>
					<option value="302">舌体-粗大</option>
					<option value="301">舌体-瘦长</option>
					<option value="404">舌苔-白厚</option>
					<option value="407">舌苔-白中带黄、厚</option>
					<option value="408">舌苔-白中带灰、厚</option>
					
					
					<!-- 下眼袋 -->
					<!-- <option value="601">下眼袋-青</option> -->
					<option value="602">下眼袋-红</option>
					<option value="603">下眼袋-黑</option>
					
				</select> <br/><br/>
				<center>
				<input name="imageField" type="image" src="images/search03.png"  style="width:260px; height:80px; border:0" class="np" />
			  	</center>
			  </td>
			</tr>
			
			<tr>
				<td></td>
			</tr>
			
			<c:forEach items="${photoList }" var="p">
			<tr align="center" bgcolor="#FFFFFF" height="22">
				<td ><span style="font-size:30px;">${p.pname }</span></td>
				<td colspan="8" align="left"><a href="${p.purl}"><img src="${p.purl }"
						width="400" height="300" />
				</a></td>
				
			</tr>
			</c:forEach>

</table>
</form>
<table>
	<tr align="left" bgcolor="#7ac452">
		<td height="50px" colspan="10" align="center">
		    <span style="text-align:center;font-size:40px"><h2>${richang.rcmc}</h2></span>
		</td>
	</tr>
	
	<tr align="left" bgcolor="#7ac452">
		<td height="50px" colspan="10" align="left">
		    <span style="text-align:left;font-size:30px"><h2>${richang.neirong}</h2></span>
		</td>
	</tr>
</table>
<!-- 
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#FFF5EE'>
    <td height="50px" colspan="10" align="center">
	    <span style="text-align:left;color:#225a1f;"><h2>通知：</h2></span>
  	    <span style="text-align:left;color:#225a1f;">药水泉丹砂泥膏已经问世了！</span><br/>
  	    <span style="text-align:left;color:#225a1f;">作用原理：温补肾阳、温补脾阳、调中行气、宣肺理气</span><br/>
  	    <span style="text-align:left;color:#225a1f;">
  	使用人群：失眠多梦、面黄无光泽、口气重、肝火旺、阴虚燥热、气血虚热、 神疲乏力、宫寒肢冷、行经腹痛、手脚发凉、鼻塞、流涕、夜间打鼾、张口呼吸、慢性咳嗽、鼻后滴漏综合症等。
  	    </span><br/>
          <!-- <span style="color:red;">由于系统维护，系统将于八点关闭，请谅解！</span>
            <img src="skin/images/yaogao.jpg" alt="" />
	</td>
  </tr>
</table> -->
</body>
</html>