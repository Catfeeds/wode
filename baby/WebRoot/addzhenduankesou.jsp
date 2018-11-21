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
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加诊断</title>
 <link type="text/css" href="css/menu.css" rel="stylesheet" />
  <link type="text/css" href="css/zhuce.css" rel="stylesheet" />
  <link rel="stylesheet" type="text/css" href="skin/css/base.css"/>
  <script type="text/javascript">
  		$(function() {
  			$("#addRecord").unbind("click");
  			$("#addRecord").click(function() {
  				//1 、判断选项是否全选了 ，没全选提示
  				//2、若全选择提交表单
  				$("#myForm").submit();
  			});
  		});
  		
  		function del(){
  	 	 var dom=document.getElementById("fs");
  	 	 var dushu=document.getElementById("ds");
  	 	  for(i=0;i<dom.length;i++) {//下拉框的长度就是他的选项数
           if(dom[i].selected==true) {
            var text=dom[i].text;//获取文本
            if(text=="否"){	
  	 	 		dushu.style.display="none";
  	 	 	}else{
  	 	 		dushu.style.display="block";
  	 	 			}
          		 }
  	 	 
  			}
  	 	 }
 
  </script>

<style>
	select option{
	font-size:21px;
	}
	select{
	font-size:21px;
	}
</style>
</head>

<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif' onload="del()">

<form name="form2" action="InputKesou" method="post">
<table width="100%" height="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
	<tr bgcolor="#FFffff" align="center">
		<td height="24" colspan="3" background="skin/images/tbg.gif"><span style="font-size:39px;">&nbsp;咳嗽&nbsp;</span></td>
	</tr>

	<tr bgcolor="#FFffff" align="center">
		<td height="24" colspan="3"><span style="font-size:18px;color:red;">&nbsp;(提示:宝宝伸舌头时,只需要让宝宝自然伸舌头就可以)&nbsp;</span></td>
	</tr>

	<tr align="center" bgcolor="#7AC452" height="30" >
		
		<td colspan="3" align="center">
		 <input type="hidden" name="pid" value="${pid }"/><br />
			<span style="font-size:35px;">干&nbsp;咳：</span>
			<select name="ganke" style="width:75px;height:60px;">
				<option value="01_否_-">否</option>
			    <option value="02_是_干咳、">是</option>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span style="font-size:35px;">咳嗽有痰：</span>
			<select name="kesouyoutan" style="width:75px;height:60px;">
				<option value="01_否_-">否</option>
			    <option value="02_是_咳嗽有痰、">是</option>
			</select></br></br>
		</td>
	
	</tr>
	
	<tr align="center" bgcolor="#7AC452" height="30" >
	
		<td>
			<input type="hidden" name="pid" value="${pid }"/>
			<span style="font-size:30px;">触诊</span>
		</td>
	
		<td>
			<span style="font-size:30px;">下眼袋</span>
		</td>
		
		<td>
			<span style="font-size:30px;">舌苔</span>
		</td>
	</tr>
	
	<tr align="center" bgcolor="#F0FFFF" height="60" >
	
		<td>
			<select name="chuzhen" style="width:300px;height:45px;">
			<option value="01_正常">正常</option>
			<option value="02_额头热">额头热</option>
			<!--<option value="03_额头凉">额头凉</option> -->
			<option value="03_后背热">后背热</option>
			<!--<option value="05_后背凉">后背凉</option>-->
			<option value="04_前胸热">前胸热</option>
			<!--<option value="07_前胸凉">前胸凉</option>-->
			<option value="05_小腹热">小腹热</option>
			<!--<option value="09_小腹凉">小腹凉</option>-->
			</select>
		</td>
	
		<td>
			<select name="xiayandai" style="width:300px;height:45px;">
			<option value="01_无">无</option>
			<option value="02_下眼袋红">下眼袋红</option>
			<option value="03_下眼袋青">下眼袋青</option>
			<option value="04_下眼袋红肿大">下眼袋红肿大</option>
			<option value="05_下眼袋青肿大">下眼袋青肿大</option>
			</select>
		</td>
	
		<td>
			<select name="shetai" style="width:300px;height:45px;">
			<option value="01_正常">正常</option>
			<option value="01_舌苔薄白">舌苔薄白</option>
			<option value="02_舌苔薄黄">舌苔薄黄</option>
			<option value="03_舌苔白厚">舌苔白厚</option>
			<option value="04_舌苔黄厚">舌苔黄厚</option>
			<option value="05_无苔">无苔</option>
			</select>
		</td>
		
	</tr>

	<tr align="center" bgcolor="#7AC452" height="30" >
	
		<td>
			<span style="font-size:30px;">闻诊</span>
		</td>
	
		<td>
			<span style="font-size:30px;">唇色</span>
		</td>
		
		<td>
			<span style="font-size:30px;">舌体</span>
		</td>
	</tr>
	
	<tr align="center" bgcolor="#F0FFFF" height="60" >
	
		<td>
			<select name="wenzhen" style="width:300px;height:45px;">
			<option value="01_正常">正常</option>
			<option value="01_大便臭">大便臭</option>
			<option value="02_大便酸臭">大便酸臭</option>
			<option value="03_大便腥味">大便腥味</option>
			<option value="01_口腔味臭">口腔味臭</option>
			<option value="02_口腔味酸">口腔味酸</option>
			</select>
		</td>
	
		<td>
			<select name="chunse" style="width:300px;height:45px;">
			<option value="01_正常">正常</option>
			<option value="01_唇色淡红">唇色淡红</option>
			<option value="02_唇色红">唇色红</option>
			<option value="03_唇色暗红">唇色暗红</option>
			</select>
		</td>
		
		<td>
			<select name="yanhou" style="width:300px;height:45px;">
			<option value="01_正常">正常</option>
			<option value="01_舌体胖大">舌体胖大</option>
			<option value="02_舌体瘦长">舌体瘦长</option>
			<!--  <option value="03_舌质瘦小细柔">舌质瘦小</option>
			<option value="04_舌质瘦小细柔">舌质瘦小</option>-->
			</select>
		</td>
	</tr>
	
	<tr align="center" bgcolor="#7AC452" height="22">
		<td>
			<span style="font-size:30px;">面色</span>
		</td>
		
		<td>
			</span><span style="font-size:30px;">舌质</span>
		</td>
		
		<td>
			<span style="font-size:30px;">咽喉</span>
		</td>
	</tr>
	
	<tr align="center" bgcolor="#F0FFFF" height="60">
		<td>
			<select name="mianse" style="width:300px;height:45px;">
			<option value="01_正常">正常</option>
			<option value="01_面色淡白">面色淡白</option>
			<option value="02_面色淡黄">面色淡黄</option>
			<option value="03_面色暗黄">面色暗黄</option>
			<option value="04_面色红">面色红</option>
			</select>
		</td>
		
		<td>
			<select name="shezhi" style="width:300px;height:45px;">
			<option value="01_正常">正常</option>
			<option value="01_舌质粗糙">舌质粗糙</option>
			<option value="02_舌质细柔">舌质细柔</option>
			</select>
		</td>
		
		<td>
			<select name="yanhouyanhou" style="width:300px;height:45px;">
			<option value="01_正常">正常</option>
			<option value="01_咽喉红">咽喉红</option>
			<option value="02_扁桃体肿大">扁桃体肿大</option>
			</select>
		</td>
	</tr>
	
	<tr align="center" bgcolor="#FFffff" height="18px">
		<td colspan="3">
			<input id="addRecord" type="submit"  class="submit-shxdtijiao"  value=""/>
		</td>
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