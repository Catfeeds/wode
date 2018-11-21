<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

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

<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
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
</table>
  
<!--  内容列表   -->
<form name="form2" method="post" action="ZenziSelect">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
	<tr bgcolor="#E7E7E7" align="center">
		<td height="24" colspan="10" background="skin/images/tbg.gif"><span style="font-size:39px;">&nbsp;疹子&nbsp;</span></td>
	</tr>


	<tr align="center" bgcolor="#CD6079" height="30" >
	
		<td>
			<input type="hidden" name="pid" value="${pid }"/>
			<a href="#xz001"><input style="width:20px;height:20px;" type="radio"  name="zenzi" checked="checked" value="01_幼儿急疹_031"/></a>
			<span style="font-size:25px;">幼儿急疹</span>
		</td>
	
		<td>
			<a href="#xz001"><input style="width:20px;height:20px;" type="radio"  name="zenzi" value="02_病毒疹_032"/></a>
			<span style="font-size:25px;">病毒疹</span>
		</td>
		
		<td>
			<a href="#xz001"><input style="width:20px;height:20px;" type="radio"  name="zenzi" value="03_水痘_033"/></a>
			<span style="font-size:25px;">水痘</span>
		</td>
	</tr>
	
	<tr align="center" bgcolor="#FFF5EE" height="22" >
	
		<td>
			幼儿急疹:
			1、发病年龄：4个月~2岁
			2、体温38℃以上
			3、体温3小时一升一降，发热2~3天
			4、精神好目光有神
			5、伴厌食、恶心、呕吐、腹泻、腹痛
			6、偶有感冒症状
			7、疹色玫红，细小、密集
			8、疹出热退
		</td>
	
		<td>
			病毒疹：
			1、发病年龄：学龄及学龄前儿童
			2、体温38℃以上
			3、精神欠佳
			4、伴厌食、恶心、呕吐、腹泻、腹痛
			5、疹色玫红，个大、独立
			6、疹子出齐后热退
			7、疹子消退较慢，不脱屑、不留斑
		</td>
		
		<td>
			水痘：
			1、发病年龄：学龄及学龄前儿童
			2、四季都可发生
			3、体温38℃以上
			4、前期红色小丘疹，继之水疱后脓疮继之中央先行凹陷、结痂、脱落，伴剧烈瘙痒
			5、水痘出齐热退
		</td>
	</tr>
	
	<tr align="center" bgcolor="#CD6079" height="22">
		<td>
			<a href="#xz001"><input style="width:20px;height:20px;" type="radio"  name="zenzi" value="04_猩红热_034"/></a>
			<span style="font-size:25px;">猩红热</span>
		</td>
		
		<td>
			<a href="#xz001"><input style="width:20px;height:20px;" type="radio"  name="zenzi" value="05_麻疹_035"/></a>
			<span style="font-size:25px;">麻疹</span>
		</td>
		
		<td>
			<a href="#xz001"><input style="width:20px;height:20px;" type="radio"  name="zenzi" value="06_口腔疱疹_036"/></a>
			<span style="font-size:25px;">口腔疱疹</span>
		</td>
	</tr>
	
	<tr align="center" bgcolor="#FFF5EE" height="22">
		<td>
			猩红热：
			1、发病年龄：学龄及学龄前儿童
			2、四季都可发生
			3、体温38℃以上
			4、持续高热
			5、咽部鲜红，伴咽痛，舌质鲜红，芒刺突起
			6、自头面部会出现鲜红色密集疹子，连成一片
		</td>
		
		<td>
			麻疹：
			1、发病年龄：学龄及学龄前儿童
			2、冬春季多发
			3、体温38℃以上
			4、目赤畏光，眼泪汪汪
			5、口腔粘膜斑
			6、发热持续至疹子出透
			7、疹色暗红，先稀后密，先头胸部后四肢
			8、疹子高出皮肤，触之碍手
			9、先自头面部消退，退疹时脱屑
		</td>
		
		<td>
			口腔疱疹：
			1、发病年龄：学龄及学龄前儿童
			2、四季都可发生
			3、体温38℃以上
			4、持续高热
			5、咽部出现红色小疹子，细小、密集、迅速破溃为小溃疹，疼痛重
		</td>
	</tr>	
	
	<tr align="center" bgcolor="#CD6079" height="22">
		<td>
			<a href="#xz001"><input style="width:20px;height:20px;" type="radio"  name="zenzi" value="07_手足口_037"/></a>
			<span style="font-size:25px;">手足口</span>
		</td>
		
		<td>
			<a href="#xz001"><input style="width:20px;height:20px;" type="radio"  name="zenzi" value="08_惊厥_038"/></a>
			<span style="font-size:25px;">惊厥</span>
		</td>
		
		<td>
			<a href="#xz001"><input style="width:20px;height:20px;" type="radio"  name="zenzi" value="09_慢惊风_039"/></a>
			<span style="font-size:25px;">慢惊风</span>
		</td>
	</tr>
	
	<tr align="center" bgcolor="#FFF5EE" height="22">
		<td>
			手足口：
			1、发病年龄：学龄及学龄前儿童
			2、四季都可发生
			3、体温38℃以上
			4、持续高热2天左右咽部出现红色小疹子，细小、密集
			5、手心、脚心、屁股等处也会出现暗红色疹子
		</td>
		
		<td>
			惊厥：
			1、高热不退，面赤唇红，烦躁不安，气急臂煽
			2、突然爆发，意识丧失，继而两眼球上翻，牙关紧闭，颈项强直，手足抽搐，腹胀，喉中痰声辘辘，咳吐不利
			3、发作时间可几秒钟活数分钟，较长者可10-30分钟以上，有时反复发作，针织呈持续状态。
		</td>
		
		<td>
			慢惊风：
			面色淡黄或青白，疲惫无神，语声轻浅，有时在沉睡中突发痉挛，时作时止，手脚发凉或手足心热
		</td>
	</tr>
	
	<tr align="center" bgcolor="#CD6079" height="22">
		<td>
			<a href="#xz001"><input style="width:20px;height:20px;" type="radio"  name="zenzi" value="10_斜颈_0310"/></a>
			<span style="font-size:25px;">斜颈</span>
		</td>
		
		<td>
			<a href="#xz001"><input style="width:20px;height:20px;" type="radio"  name="zenzi" value="11_急性眼结合膜炎_0311"/></a>
			<span style="font-size:25px;">急性眼结核膜炎</span>
		</td>
		
		<td>
			<a href="#xz001"><input style="width:20px;height:20px;" type="radio" name="zenzi" value="12_腮腺炎_0312"/></a>
			<span style="font-size:25px;">腮腺炎</span>
		</td>
	</tr>
	
	<tr align="center" bgcolor="#FFF5EE" height="22">
		<td>
			斜颈：
			1、出生数日后发现宝宝头向一侧倾斜
			2、触诊胸锁乳突肌部有梭形肿物，患处皮肤正常，无水肿。
		</td>
		
		<td>
			急性眼结合膜炎：
			1、急性眼结合膜炎俗称红眼病
			2、主要表现为眼结合膜充血、水肿、疼痛、多粘液脓性分泌物
			3、球结合膜充血、水肿，在穹窿部最显著，愈近角膜愈轻
			4、疼痛畏光，重则流泪、头痛、大便干、小便赤
		</td>
		
		<td>
			腮腺炎：
			1、发病年龄：学龄及学龄前儿童；
			2、发病季节：冬季；
			3、特征：腮腺肿胀带有痛感，以耳垂为中心向下，向前，向后肿大为特点；
			4、愈后：终生免疫。
		</td>
	</tr>
	
	<tr align="center"  height="22">
		<td bgcolor="#CD6079">
			<a href="#xz001"><input style="width:20px;height:20px;" type="radio" name="zenzi" value="13_腮腺发炎_0313"/></a>
			<span style="font-size:25px;">腮腺发炎</span>
		</td>
		
		<td colspan="2" bgcolor="#FFF5EE">
			腮腺发炎：
			1、发病年龄：任何年龄都可发病；
			2、发病季节：一年四季；
			3、特征：腮腺肿胀疼痛，耳前肿大为明显特征；
			4、愈后：可反复发作。
		</td>
	</tr>
	
	<tr align="center" bgcolor="#FFF5EE" height="30" >
	
		<td>
			<span style="font-size:20px;">度数：</span><br />
			<input type="text" name="dushu" style="width:200px;height:26px; background-color: #CD6079"/>℃
		</td>
	
		<td>
			<a name="xz001" id="xz001" ><span style="font-size:20px;">眼神：</span></a><br />
			<select name="yanshen" style="width:200px;height:26px; background-color: #CD6079">
			<option value="01_目光有神">目光有神</option>
			<option value="02_目光无神">目光无神</option>
			</select>
		</td>
	
		<td>
			<span style="font-size:20px;">舌苔：</span><br />
			<select name="shetai" style="width:200px;height:26px; background-color: #CD6079">
			<option value="01_薄白苔">薄白苔</option>
			<option value="02_舌苔白润">舌苔白润</option>
			<option value="02_舌苔白厚腻">舌苔白厚腻</option>
			<!-- <option value="03_舌苔白腻">舌苔白腻</option>
			<option value="04_舌苔白厚">舌苔白厚</option> -->
			<option value="05_舌苔白中带黄腻">舌苔白中带黄腻</option>
			<option value="06_舌苔白中带灰腻">舌苔白中带灰腻</option>
			<option value="07_舌苔黄厚腻">舌苔黄厚腻</option>
			<!-- <option value="07_舌苔黄腻">舌苔黄腻</option>
			<option value="08_舌苔黄厚">舌苔黄厚</option> -->
			<option value="09_舌苔黄滑">舌苔黄滑</option>
			<option value="010_舌苔白滑">舌苔白滑</option>
			<option value="11_镜面舌">镜面舌</option>
			<option value="12_舌红无苔">舌红无苔</option>
			</select>
		</td>
	</tr>
	
	<tr align="center" bgcolor="#FFF5EE" height="30" >
	
		<td>
			<span style="font-size:20px;">精神：</span><br />
			<select name="jingshen" style="width:200px;height:26px; background-color: #CD6079">
			<option value="01_精神好">精神好</option>
			<option value="02_精神欠佳">精神欠佳</option>
			<option value="03_精神烦躁">精神烦躁</option>
			</select>
		</td>
	
		<td>
			<span style="font-size:20px;">唇色：</span><br />
			<select name="chunse" style="width:200px;height:26px; background-color: #CD6079">
			<option value="01_唇色淡红，湿润">唇色淡红，湿润</option>
			<option value="02_唇色淡红，干燥">唇色淡红，干燥</option>
			<option value="03_唇色红，湿润">唇色红，湿润</option>
			<option value="04_唇色红，干燥">唇色红，干燥</option>
			<option value="05_唇色鲜红，湿润">唇色鲜红，湿润</option>
			<option value="06_唇色鲜红，干燥">唇色鲜红，干燥</option>
			<option value="07_唇色暗红，湿润">唇色暗红，湿润</option>
			<option value="08_唇色暗红，干燥">唇色暗红，干燥</option>
			</select>
		</td>
	
		<td>
			<span style="font-size:20px;">咽喉：</span><br />
			<select name="yanhou" style="width:200px;height:26px; background-color: #CD6079">
			<option value="01_咽部微红">咽部微红</option>
			<option value="02_咽部红">咽部红</option>
			<option value="03_咽部鲜红">咽部鲜红</option>
			<option value="04_咽部红色丘疹">咽部红色丘疹</option>
			<option value="05_咽部暗红色出血点">咽部暗红色出血点</option>
			<option value="06_咽部鲜红，充血">咽部鲜红，充血</option>
			<option value="07_咽部鲜红色疹子">咽部鲜红色疹子</option>
			<option value="08_咽部鲜红，伴溃疹">咽部鲜红，伴溃疹</option>
			</select>
		</td>
	</tr>
	
	<tr align="center" bgcolor="#FFF5EE" height="30" >
	
		<td>
			<span style="font-size:20px;">面色：</span><br />
			<select name="mianse" style="width:200px;height:26px; background-color: #CD6079">
			<option value="01_面色正常，有光泽">面色正常，有光泽</option>
			<option value="02_面色正常，无光泽">面色正常，无光泽</option>
			<option value="03_面色红，无光泽">面色红，无光泽</option>
			<option value="04_面色淡黄">面色淡黄</option>
			<option value="05_面色暗黄">面色暗黄</option>
			</select>
		</td>
	
		<td>
			<span style="font-size:20px;">舌质：</span><br />
			<select name="shezhi" style="width:200px;height:26px; background-color: #CD6079">
			<option value="01_舌质粗糙淡白">舌质粗糙淡白</option>
			<option value="02_舌质细柔淡白">舌质细柔淡白</option>
			<option value="03_舌质细柔，红">舌质细柔，红</option>
			<option value="04_舌质粗糙，红">舌质粗糙，红</option>
			<option value="05_舌质细柔，深红">舌质细柔，深红</option>
			<option value="06_舌质粗糙，深红">舌质粗糙，深红</option>
			<option value="07_舌质细柔，淡红">舌质细柔，淡红</option>
			<option value="08_舌质粗糙，淡红">舌质粗糙，淡红</option>
			<option value="09_舌质鲜红，草莓舌">舌质鲜红，草莓舌</option>
			</select>
		</td>
		
		<td></td>
	</tr>
	
	<tr bgcolor="#FFF5EE">
		<td colspan="3">
			<input id="addRecord" type="submit"  class="submit-shxdtijiao"  value=""/>
		</td>
	</tr>

</table>
</form>

<!--  搜索表单  -->
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#FFF5EE'>
    <td height="50px" colspan="10" align="center">
	    <span style="text-align:left;color:#225a1f;"><h2>通知：</h2></span>
  	    <span style="text-align:left;color:#225a1f;">药水泉丹砂泥膏已经问世了！</span><br/>
  	    <span style="text-align:left;color:#225a1f;">作用原理：温补肾阳、温补脾阳、调中行气、宣肺理气</span><br/>
  	    <span style="text-align:left;color:#225a1f;">
  	使用人群：失眠多梦、面黄无光泽、口气重、肝火旺、阴虚燥热、气血虚热、 神疲乏力、宫寒肢冷、行经腹痛、手脚发凉、鼻塞、流涕、夜间打鼾、张口呼吸、慢性咳嗽、鼻后滴漏综合症等。
  	    </span><br/>
          <!-- <span style="color:red;">由于系统维护，系统将于八点关闭，请谅解！</span>-->
            <img src="skin/images/yaogao.jpg" alt="" />
	</td>
  </tr>
</table>
</body>
</html>

