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
		response.sendRedirect("login.jsp");
		return;
	}

%>
<!DOCTYPE html>

<html >   
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会员管理</title>
 <link type="text/css" href="css/menu.css" rel="stylesheet" />
 <link type="text/css" href="css/zhuce.css" rel="stylesheet" /> 
 <link rel="stylesheet" type="text/css" href="skin/css/base.css"> 
  <link rel="stylesheet" href="css-changsha/mui.css">
    <link rel="stylesheet" type="text/css" href="css-changsha/icons-extra.css" />
    <link rel="stylesheet" type="text/css" href="css-changsha/iconfont.css" />
    <link rel="stylesheet" href="css-changsha/main.css">
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
			function doShow(k,i) {
				if(k==2) i--;
				if(k==3) i++;
				if(i==0) {alert("已经到第一页")} 
				else if (i-1=="${totalcount}") {alert("已经到最后一页")}
				else  {
					window.location.href="SearchAgentPageServlet?i="+i;
				}
			}
			/*-------------翻页结束---------------*/
			
			/* 是否全选标记 */   
			var checkedAll = false;  
			/* 全选/取消全选   
			* formName 所在form的name值   
			* checkboxName checkbox的name值   
			* 注意：所有checkbox的name值都必须一样，这样才能达到全选的效果   
			*/   
			function selectAll(form4,checkboxid){   
			var form = document.all.item(form4);   
			var elements = form.elements[checkboxid];   
			for (var i=0;i<elements.length;i++){    
			var e = elements[i];   
			if(checkedAll){   
			e.checked = false;   
			form.alls.checked = false;   
			} else {   
			e.checked = true;   
			form.alls.checked = true;   
			}   
			}   
			if(checkedAll){   
			checkedAll = false;   
			} else {   
			checkedAll = true;   
			}   
			}    
			/* 检查是否有checkbox被选中   
			* formName 所在form的name值   
			* checkboxName checkbox的name值   
			* 注意：所有checkbox的name值都必须一样，这样才能达到全选的效果   
			*/   
			function checkAll(form4,checkboxid){   
			var hasCheck = false;   
			var form = document.all.item(form4);   
			var elements = form.elements[checkboxid];   
			for (var i=0;i<elements.length;i++){   
			var e = elements[i];   
			if(e.checked){   
			hasCheck = true;   
			}   
			}   
			return hasCheck;   
			}  
			/* 执行操作 */   
			function do_action(){   
			if (!checkAll("form4","checkboxid")){   
			alert("没有用户被选中，请选择！"); 
			window.location.href="SearchAgentServlet?w=1";  
			} else {   
			}   
			}   
		</script>

</head>

<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>
	<header id="header" class="mui-bar mui-bar-nav">
		<a class="mui-action-back mui-icon mui-icon-extra mui-icon-extra-arrowleftcricle mui-pull-left"></a>
			<h1 class="mui-title ">信息列表</h1>
	</header>

	<nav class="mui-bar mui-bar-tab">
	    <a class="mui-tab-item-link" href="xuanzejiemian.jsp">
	      <span class="mui-icon my-nav-icon-1"></span>
	      <span class="mui-tab-label">辩证取穴</span>
	    </a>
	    <a class="mui-tab-item-link" href="jiankangyanghu.jsp">
	      <span class="mui-icon my-nav-icon-2"></span>
	      <span class="mui-tab-label">健康养护</span>
	    </a>
	    <a class="mui-tab-item-link" href="yuerketang.jsp">
	      <span class="mui-icon my-nav-icon-3"></span>
	      <span class="mui-tab-label">育儿课堂</span>
	    </a>
	    <a class="mui-tab-item-link mui-active" href="personal-center.jsp">
	      <span class="mui-icon my-nav-icon-4"></span>
	      <span class="mui-tab-label">我的</span>
	    </a>
 	 </nav>
<!--  搜索表单  -->
<form name='form3' action="SearchAgentServlet" method="post">
<input type='hidden' name='dopost' value='' />
<table  style="margin-top:49px;border:1px;width:100%; cellpadding:1px; cellspacing:1px; bgcolor:'#FFF5EE';align:center;">
  <tr bgcolor='#ff7084' height='80px'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr >
          <td style="background:url();" align='center'><span style="font-size:40px">姓名：</span></td>
          <td>
          	<input type='text' id="name"  name="name" value='' style='width:150px;height:60px;font-size:28px' />
        </td>
        <td style="background:url();"><span style="font-size:40px">&nbsp;电话：</span></td>
        <td>
          	<input type='text' id="phone"  name="phone" value='' style='width:150px;height:60px;font-size:28px' />
        </td>
         <td style="background:url();" align='center'><span style="font-size:40px">&nbsp;权限：</span></td>
         <a href="addzhuce.jsp" class="btn-block btn-primary login-btn">注册</a>
          <td>
          	<select name="upower" style='width:150px;height:60px;font-size:20px'>
          			<option value="" >全部</option>
	               <option value="1" >VIP会员</option>
	               <option value="2" >七天会员</option>
	               <option value="3" >游客</option>
	            </select>
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
<form name='form4' action="UpdateAgentServlet" method="post">
<table width="100%" height="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px;margin-bottom:38px;">

<tr bgcolor="#ff7084">
<c:if test="${user.upower==0}">
<td height="28" colspan="10">
	<a href="/AddAgentChaxunID" class="coolbg">&nbsp;添加人员&nbsp;</a>
	<!-- <a href="/UpdateAgentServlet" class="coolbg" onClick="do_action()">&nbsp;修改代理</span>&nbsp;</a>-->
	<a href="/Export" class="coolbg">&nbsp;导出人员&nbsp;</a>
	
</td>
</c:if>
</tr>

<tr bgcolor="#ffffff">
	<td><input type="checkbox" name="alls" onClick="selectAll('form4','checkboxid')" title="全选/取消全选"/></td>
	<td height="24" colspan="9" background="skin/images/tbg.gif">&nbsp;<spanstyle="font-size:30px">信息查询列表</span>&nbsp;</td>
</tr>
<tr align="center" bgcolor="#ff7084" height="22">
	<!--<td width="6%"><span style="font-size:35px">ID</span></td> -->
	
	<!-- <td width="5%" style="border:2px solid #EE6A50;text-align:center;"><span style="font-size:35px;">选择</span></td> -->
	<td width="10%" style="border:2px solid #EE6A50;text-align:center;"><span style="font-size:35px">姓名</span></td>
	<td width="15%" style="border:2px solid #EE6A50;text-align:center;"><span style="font-size:35px">电话</span></td>
	<!--<td width="3%" style="border:2px solid #EE6A50;text-align:center;"><span style="font-size:3px">助教老师</span></td>
	 <td width="15%" style="border:2px solid #EE6A50;text-align:center;"><span style="font-size:35px">登录次数</span></td> -->
	<td width="20%" style="border:2px solid #EE6A50;text-align:center;"><span style="font-size:35px">开始时间</span></td>
	<td width="15%" style="border:2px solid #EE6A50;text-align:center;"><span style="font-size:35px">结束时间</span></td>
	<td width="20%" style="border:2px solid #EE6A50;text-align:center;"><span style="font-size:35px">剩余取穴次数</span></td>
	 <!--<td width="5%"><span style="font-size:35px">上级id</span></td> -->
	<c:if test="${user.upower==0}">
	   <td width="30%"><span style="font-size:35px">操作</span></td>
	</c:if>
</tr>
<c:forEach items="${xiajiList }" var="x">
<tr align='center' bgcolor="#FFFfff" onMouseMove="javascript:this.bgColor='#ffffff';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<!-- <td><span style="font-size:13px">${p.crid }</span></td> -->
	<!-- <td style="border:1px solid #EE6A50;text-align:center;"><input name="checkboxid" type="checkbox" id="id" value="${x.userid }" class="np"/></td> -->
	<td  style="border:1px solid #EE6A50;text-align:center;"><span style="font-size:30px">${x.uname }</span><br/>
		<c:if test="${x.upower==1}">
			<span style="font-size:30px;color:red">vip会员</span>
		</c:if>
		<c:if test="${x.upower==2}">
			<span style="font-size:30px;color:red">7天会员</span>
		</c:if>
		<c:if test="${x.upower==3}">
			<span style="font-size:30px;color:red">游客</span>
		</c:if>
	</td>
	<td style="border:1px solid #EE6A50;text-align:center;"><span style="font-size:30px">${x.loginName }</span></td>
	<!--<td style="border:1px solid #EE6A50;text-align:center;"><span style="font-size:30px">${x.zhujiao }</span></td>
	 <td style="border:1px solid #EE6A50;text-align:center;"><span style="font-size:30px">${x.uclick }</span></td> -->
	<td style="border:1px solid #EE6A50;text-align:center;"><span style="font-size:30px">${x.starttime }</span></td>
	<td style="border:1px solid #EE6A50;text-align:center;"><span style="font-size:30px">${x.ystime }</span></td>
	<td style="border:1px solid #EE6A50;text-align:center;"><span style="font-size:30px">${x.numbers }</span></td>
	<!-- <td><span style="font-size:30px">${x.sjid }</span></td> -->
	<c:if test="${user.upower==0}">
	<td  style="border:1px solid #EE6A50;text-align:center;">
		<!-- <a href="JieSuan?uid=${x.userid}&name=${x.uname}"><span style="font-size:30px">结算</span></a><br/> -->
		<a href="Chongzhi.jsp?name=${x.uname}&uid=${x.userid}&numbers=${x.numbers }"><span style="font-size:30px">充值|</span></a>
		<a href="Janzhi.jsp?name=${x.uname}&uid=${x.userid}&numbers=${x.numbers }"><span style="font-size:30px">减值</span></a><br/>
		<a href="SearchPatientXinxiServlet?w=1&uid=${x.userid}"><span style="font-size:30px">健康档案</span></a><br/>
		<!-- <a href="Xiugaizhujiao.jsp?uid=${x.userid}&name=${x.uname}&xzhujiao=${x.zhujiao }"><span style="font-size:30px">修改助教</span></a><br/>-->
		<a href="Shijianxiugai.jsp?uid=${x.userid}&name=${x.uname}&starttime=${x.starttime}&ystime=${x.ystime}&zhucetime=${x.zhucetime}"><span style="font-size:30px">时间和权限修改</span></a><br/>
		<a href="ChongZhiPsswordServlet?uid=${x.userid}"><span style="font-size:30px">重置密码</span></a>
	</td>
	</c:if>
</tr>
</c:forEach>

<tr align="right" bgcolor="#ff7084">
	<td align="center" colspan="2"><a href="javascript:void(0);" onClick="doShow(2,<%=i%>);"><img src="skin/images/new/back_btn.png"/></a></td>
	<td align="center"><a href="javascript:void(0);" onClick="doShow(3,<%=i%>);"><img src="skin/images/new/next_btn.png"/></a></td>
	<td colspan="5" align="left"><span style="font-size:40px">第${i}页/共${totalcount }页</span></td>
</tr>
</table>

</form>
</body>
</html>
