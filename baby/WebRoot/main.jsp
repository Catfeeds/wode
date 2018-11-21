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
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>main</title>
<base target="_self">
<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="skin/css/main.css" />
</head>
<body leftmargin="8" topmargin='8'>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><div style='float:left'> <img height="14" src="skin/images/frame/book1.gif" width="20" />&nbsp;欢迎使用扶阳小儿推拿技术家庭实用系统，健康是您给孩子最好的礼物！ </div>
      <div style='float:right;padding-right:8px;'>
        <!--  //保留接口  -->
      </div></td>
  </tr>
  <tr>
    <td height="1" background="skin/images/frame/sp_bg.gif" style='padding:0px'></td>
  </tr>
</table>
<table width="100%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;">
  <tr>
    <td background="skin/images/frame/wbg.gi" bgcolor="#7AC452" class='title' colspan="2"><span>春夏秋冬</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>
		    <!-- <span style="text-align:left;"><h2>通知：</h2></span>
		    <span style="text-align:left;font-size:16px">与家长交流的话术已经添加到自主学习里面，开店成败的关键在于与家长沟通的技巧，希望大家能仔细看看。</span> -->
		    <span style="text-align:left;color:;"><h2>春天：</h2></span>
	  	    <span style="text-align:left;font-size:20px">春天要多给宝宝吃蔬菜水果，因为春节聚餐多厚味肥甘，
	  	    吃得多，厚味内积易助火生痰，多吃蔬菜水果，可以内清其积以“解腻”。有研究表明维生素A可保护呼吸道上皮组织的健康，
	  	    增强对呼吸道疾病的抵抗能力，富含维生素A的食物有动物肝脏、蛋黄、奶油和鱼肝油。春天是长身体的季节，
	  	    也是长智力的季节，DHA是脑组织和视网膜的重要原料，因此要注意补充，深海鱼中富含DHA我们可适当增加摄入量，
	  	    烹调时要避免采用煎炸等方式，以免破坏鱼油。</span><br/>
	          <!-- <span style="color:red;">由于系统维护，系统将于八点关闭，请谅解！</span>
	          <center>
	            <img src="skin/images/yaogao.jp" alt=""/>
	           </center>-->
    </td>
    		
    <td>
		    <span style="text-align:left;color:;"><h2>夏季</h2></span>
	  	    <span style="text-align:left;font-size:20px">白开水：纯净的白开水最容易解渴，它进入体内后可以立即进行新陈代谢、
	  	    调节体温、输送养分及清洁身体内部的功能，尤其是夏天，宝贝多喝白开水不仅可以解暑降温，
	  	    还能补充丢失的水分，是最安全的补水选择。
	  	    绿豆汤：绿豆汤有清热解毒、止渴消暑的功效，是非常适合夏季的饮品。值得注意的是，宝贝要适量饮用绿豆汤，过量饮用容易导致腹泻或消化系统免疫力降低。</span><br/>
	          <!-- <span style="color:red;">由于系统维护，系统将于八点关闭，请谅解！</span>
	          <center>
	            <img src="skin/images/tuiretie.jp" alt=""/>
	           </center>-->
    </td>
  </tr>
  
   <tr bgcolor="#FFFFFF">
    <td>
		    <!-- <span style="text-align:left;"><h2>通知：</h2></span>
		    <span style="text-align:left;font-size:16px">与家长交流的话术已经添加到自主学习里面，开店成败的关键在于与家长沟通的技巧，希望大家能仔细看看。</span> -->
		    <span style="text-align:left;color:;"><h2>秋季：</h2></span>
	  	    <span style="text-align:left;font-size:20px">别以为秋季，就只是对付宝宝的腹泻就足够了，其他问题大可忽略。
	  	    秋季如果饮食不当，也会遭遇便秘的问题，与腹泻是相反方向的调理。
	  	    到了秋天，各种美味能让宝宝的胃口大开，但是富含 营养 的高蛋白食物多吃会让宝宝的胃肠负担明显加重
	  	    ，容易出现口臭、便秘等现象。</span><br/>
	          <!-- <span style="color:red;">由于系统维护，系统将于八点关闭，请谅解！</span>
	          <center>
	            <img src="skin/images/yaogao.jp" alt=""/>
	           </center>-->
    </td>
    		
    <td>
		    <span style="text-align:left;color:;"><h2>冬季:</h2></span>
	  	    <span style="text-align:left;font-size:20px">无论是在什么季节，宝宝的一日三餐都要讲究食物的多样化，
	  	    粮食、蔬菜、水果、动物性食品、乳类制品和豆制品，这五类食品一样都不能少。在冬季，尤其要让宝宝多吃蔬菜。
　　<br>相比于其他季节，冬天的水果的蔬菜的种类相对比较少，而且宝宝对蔬菜和水果的兴趣也不如夏天秋天时大，
为此更容易导致宝宝缺少维生素。此外，妈妈们需注意，针对不爱吃蔬菜的宝宝，妈妈不要强行逼迫宝宝吃，
而应该从扩大蔬菜种类，更换蔬菜种类及改变烹调方式等去吸引宝宝去吃自己爱吃的蔬菜。针对比较挑食的宝宝，
妈妈们一定要足够耐心，让宝宝自己去接纳蔬菜食物。</span><br/>
	          <!-- <span style="color:red;">由于系统维护，系统将于八点关闭，请谅解！</span>
	          <center>
	            <img src="skin/images/tuiretie.jp" alt=""/>
	           </center>-->
    </td>
  </tr>
</table>

<table width="100%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr bgcolor="#7AC452">
    <td colspan="2" background="skin/images/frame/wbg.gi" class='title'><span>基本信息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="25%" bgcolor="#FFFFFF">您的姓名：</td>
    <td width="75%" bgcolor="#FFFFFF">${user.name}</td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>软件版本信息：</td>
    <td>青岛玖壹康宁健康管理咨询有限公司</td>
  </tr>
</table>

<table width="100%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC">
  <tr bgcolor="#7AC452">
    <td colspan="2" background="skin/images/frame/wbg.gi" class='title'><span>信息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="32">推拿：</td>
    <td><u>六经扶阳小儿推拿</u></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="25%" height="32">微信：</td>
    <td width="75%"><u>tuina686</u></td>
  </tr>
</table>
</body>
</html>
