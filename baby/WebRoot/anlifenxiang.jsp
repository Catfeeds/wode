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

<html>
  <meta charset="utf-8">
    <title>育儿课堂</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="../css-changsha/mui.css">
    <link rel="stylesheet" type="text/css" href="css-changsha/icons-extra.css" />
    <link rel="stylesheet" type="text/css" href="css-changsha/iconfont.css" />
    <link rel="stylesheet" href="css-changsha/main.css">
    <script type="text/javascript">
    	
   		document.addEventListener('plusready', function(){
   			//console.log("所有plus api都应该在此事件发生后调用，否则会出现plus is undefined。"
   			
   		});
   		
    </script>
</head>
<body>
	<header id="header" class="mui-bar mui-bar-nav">
	<a class="mui-action-back mui-icon mui-icon-extra mui-icon-extra-arrowleftcricle mui-pull-left"></a>
			<h1 class="mui-title ">育儿课堂</h1>
	</header>
	<nav class="mui-bar mui-bar-tab">
	    <a class="mui-tab-item-link" href="xuanzejiemian.jsp">
	      <span class="mui-icon my-nav-icon-1"></span>
	      <span class="mui-tab-label">辩证取穴</span>
	    </a>
	    <a class="mui-tab-item-link mui-active" href="jiankangyanghu.jsp">
	      <span class="mui-icon my-nav-icon-2"></span>
	      <span class="mui-tab-label">健康养护</span>
	    </a>
	    <a class="mui-tab-item-link" href="yuerketang.jsp">
	      <span class="mui-icon my-nav-icon-3"></span>
	      <span class="mui-tab-label">育儿课堂</span>
	    </a>
	    <a class="mui-tab-item-link" href="personal-center.jsp">
	      <span class="mui-icon my-nav-icon-4"></span>
	      <span class="mui-tab-label">我的</span>
	    </a>
 	 </nav>
	<div class="mui-content">
		<div class="my-txt-box">
			<h3 style="text-align: center; padding-top: 20px;">小儿胃肠型感冒典型医案分享</h3>
			<p style="text-align: center;"><span class="my-date-icon"><em class="my-iconfont my-icon-shijian"></em>2016/11/07</span></p>
			<div><img src="img/anli.png" width="100%"></div>
			<p style="text-indent: 30px;">“这是10-11月发生的比较具有代表性的医案，由于天气的原因以及目前家长的普遍养育方式，小儿胃肠型感冒是近期比较多见的症状，我把这个医案写下来，给更多家长借鉴。”吉老师说。</p>
			<h3 style="font-size: 16px; margin-top:20px;">一、发热、头痛、呕吐--小儿胃肠型感冒症状</h3>
			<p style="text-indent: 30px;">患儿小月，未满6岁，上幼儿园，10月25号咳嗽，起初干咳。一天咳嗽十几声，但并不影响吃饭，稍微一活动就会出汗，出汗比平时多一点。</p>
			<p style="text-indent: 30px;">妈妈是大学老师，当天工作忙，早上给孩子煮了葱姜水。奶奶看孩子咳嗽不放心，就带孩子上青医附院拍了胸片，医生诊断是细菌性支气管炎，开了消炎药和止咳药，吃了5天，咳嗽有所减轻，但没有好利索。</p>
			<p style="text-indent: 30px;">10月31号下午上了舞蹈课，晚上和全家一起吃了自助餐，回家后就吐了。吐出的除了晚上吃的食物，还有早上吃的西红柿鸡蛋。吐完后就开始发热，头痛，还有点恶心，体温38.1度。</p>
			<p style="text-indent: 30px;">奶奶提议带孩子上医院，但妈妈不愿让孩子吃药打抗生素，听说我们诊所擅长各种儿科疾病调养，而且不打针不吃药，没有副作用， 11月1号早上就请假带孩子来调理。</p>
			<h3 style="font-size: 16px; margin-top:20px;">二、辩证取穴--望闻问触</h3>
			<p style="text-indent: 30px;">孩子来时精神不振，上眼皮沉重，面色暗黄，无光泽，色晦暗。全身皮肤干热，后背的温度最热，口腔有酸臭味，下眼袋色青，鼻翼两侧发青，唇色红，舌质红粗糙，舌苔白厚，咽喉红，咳嗽声沉重，无痰，咳嗽时张口抬肩用力，鼻塞，大便一天一次，前干后软，小便黄。</p>
			<p style="text-indent: 30px;">据吉亚宁老师诊断是由于感冒没恢复，学跳舞，吃自助餐导致食复和劳复，感冒症状加重，由表症到了半表半里症，表现为胃肠道症状和感冒症状。治疗法则以辛凉解表，健脾化湿，化痰止咳，清补板门300 ，清补肺经300。（六经扶阳穴位选取根据节气变化而变化，家长不能盲目取穴）</p>
			<p style="text-indent: 30px;">嘱咐了家长让孩子多喝水，不能让孩子吃喝奶制品、水果、肉类和海鲜类，尽量吃清淡易消化的食物，每次吃饭吃五分饱。</p>
			<h3 style="font-size: 16px; margin-top:20px;">三、小儿胃肠型感冒病情发展--推拿配合饮食调理3天痊</h3>
			<p style="text-indent: 30px;">2号早上复诊，孩子精神好些了，头不痛了，也没有再吐，但是咳嗽还是很厉害，咳起来表情很痛苦，体温38.2。这天是奶奶带过来调理的，原来奶奶起初并不相信小儿推拿，虽然也听说过我们诊所，但还是认为不打针不吃药不太靠谱。直到前一天孩子做了推拿后，身体有所好转，奶奶这才相信，才肯带孩子过来。治疗法则还是照之前的方法：清补板门300 ，清补肺经300。（六经扶阳穴位选取根据节气变化而变化，现在节气已变！家长不能盲目取穴）</p>
			<p style="text-indent: 30px;">3号还是奶奶带过来调理，孩子体温降了下来，精神好了很多，还是有些咳嗽，不过不那么严重了，咳嗽时不费力就能咳出黄白相间的黏痰，并且随着流白粘鼻涕。看到孩子把痰咳了出来吉老师就能肯定，孩子这是要好了。因为咳嗽实质上就是在排痰，只要痰排出了体外，孩子就不会咳嗽了。在看孩子面色和舌苔，脸色由黄变白，舌质由粗糙变细柔，舌面芒刺变小，舌苔也变薄了，取穴还是照旧不变。</p>
			<p style="text-indent: 30px;">第四天，孩子来复诊，体征上已经没有什么异常了。奶奶说孩子看上去和没生病的孩子差不多了。以平衡脾肺阴阳，止咳排痰；调理肝胆阴阳，镇惊安神；清补板门300， 清补肝胆300。（六经扶阳穴位选取根据节气变化而变化，现在节气已变！家长不能盲目取穴）奶奶特别高兴，一直说谢谢吉老师，说以前孩子感冒上医院，一进医院就做检查、开药，有时候还要打针输液，花上几百上千不说，孩子治疗一个星期也不见好。做小儿推拿推了两天，孩子明显好转，推三天孩子基本上就没什么问题了。</p>
			<h3 style="font-size: 16px; margin-top:20px;">四、小儿胃肠型感冒的护理建议</h3>
			<p style="text-indent: 30px;">其实，孩子感冒并不可怕。可怕的是有些家长一看到孩子感冒就乱了阵脚，轻微感冒就让孩子打针吃药，导致孩子免疫力受损。另外，有些家长看孩子生病，面容憔悴，就觉得是因为孩子营养不够，给孩子吃大鱼大肉、水果牛奶，这样反而容易引起孩子积食。</p>
			<h3 style="font-size: 16px; margin-top:20px; text-indent: 30px;">吉亚宁老师在这里给广大家长们一些孩子感冒的护理建议：</h3>
			<p style="text-indent: 30px;">多喝水，特别是发热的孩子，出汗后更要及时补充水分，防止缺水引起惊厥；</p>
			<p style="text-indent: 30px;">每隔半小时测一下体温，体温38.5℃以上就要采取降温措施；</p>
			<p style="text-indent: 30px;">做完推拿后出汗的宝宝不要立即出门，以免受风导致复感，要多喝温水；</p>
			<p style="text-indent: 30px;">发热的宝宝手脚冰凉时，是因为风寒入里，体温会很快升高，当宝宝的手脚发热时，体温已经升到了最高峰，热度就会慢慢下降；</p>
			<p style="text-indent: 30px;">宝宝出汗后要及时更换衣服，注意保暖，特别是前胸后背；</p>
			<p style="text-indent: 30px;">宝宝剧烈咳嗽时不要喂东西或喝水，以免吸入气管；</p>
			<p style="text-indent: 30px;">饮食要清淡，忌食油腻、太甜、太咸或是刺激的食物，忌食海鲜、肉类和凉性水果，多喝开水，每顿吃6~7分饱，如果患儿剧烈咳嗽后呕吐的，吐完不要接着吃东西或喝水。胃肠性感冒加呕吐和腹泻的宝宝要禁食，多喝水，不要喝奶制品，不要吃水果和肉类、海鲜类，宜吃清淡易消化饮食，每次喂五分饱。</p>
		</div>
	</div>
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>
