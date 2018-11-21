<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="utf-8">
    <title>吉老师问答</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="css-changsha/mui.css">
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
		
			<h1 class="mui-title">吉老师问答</h1>
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
	    <a class="mui-tab-item-link mui-active" href="yuerketang.jsp">
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
			<div style="margin-top:10px; margin-bottom: 10px;"><img src="img/pic_faq.jpg" width="100%"></div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>1.宝妈：孩子便秘怎么办？</p>
				<p class="my-answer" >吉老师：孩子便秘要先从饮食上调理，家长要做到每顿饭不要给孩子吃得过饱，不要吃一些比较不容易消化的东西，不要吃一些生冷水果。带孩子做适量的运动，同时可以配合推拿调理。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>2.宝妈：孩子又流鼻涕，又咳嗽，只能推一种症状，另一种症状怎么办？</p>
				<p class="my-answer" >吉老师：这种情况首先要根据孩子的病情以及症状来选择最重的症状来帮助孩子快速恢复。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>3.宝妈：孩子半夜睡觉哭醒，嘴角还生水泡，应该怎么调理？</p>
				<p class="my-answer" >吉老师：孩子半夜睡觉哭醒，有可能是给孩子吃的太多了，脾胃不舒服导致的，或是晚上太冷，或受惊吓导致的。
孩子嘴上有泡泡这应该是上火了，一是要给孩子少吃饭，适当的饿一下，要清淡饮食，不要吃辛辣油腻的食物，二是睡觉时不要给孩子盖的太多或太少，要适中，三是要保持室内空气流通，安静。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>4.宝妈：孩子反复咳嗽两个月，咳嗽的时候胸部有啰音，不咳的时候正常，应该如何推拿？</p>
				<p class="my-answer" >吉老师：这个是要根据孩子的体质来决定的，每个孩子的体质不同，取得穴位也不同，调理的快慢也不同。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>5.宝妈：孩子流鼻涕、鼻塞一个月了。用通调方没用，应该怎么办？</p>
				<p class="my-answer" >吉老师：这样要考虑孩子是不是有鼻炎，要给孩子控制好饮食，少吃饭多喝点热水，或是把熬熟的香油给孩子在鼻孔处抹一下。建议去医院给孩子检查一下。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>6.宝妈：宝宝流鼻涕，声音沙哑，怎么办？</p>
				<p class="my-answer" >吉老师：宝宝出现流鼻涕、声音嘶哑这种情况说明宝宝已经感冒了，那么家长在家里要做好护理，在饮食上少吃多餐，不要给宝宝吃一些辛辣刺激的食物，包括海鲜鱼肉，生冷以及水果。如果不能判断的话可以去医院里诊断。
				</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>7.宝妈：感冒推拿是不是不分细菌引起的还是病毒引起的？</p>
				<p class="my-answer" >吉老师：中医上是不分病毒和细菌的。推拿是调理孩子的体质。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>8.宝妈：怎么提高免疫力？如何推拿和养护？</p>
				<p class="my-answer" >吉老师：这种情况，首先要从调理孩子脾胃开始，只有孩子的脾胃好了身体抵抗力才能自然的上升。只有吃的好宝宝体质才会好，那么在家里家长就要做到不要给宝宝吃一些不容易消化的东西，多吃一些比较清淡、比较容易消化的食物，而且要忌食生冷寒凉的东西。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>9.宝妈：孩子鼻子不通气，睡觉时鼻子应该有痰，呼噜呼噜的，怎么办？</p>
				<p class="my-answer" >吉老师：首先是要看宝宝是感冒了引起的还是孩子平常有鼻炎引起的。
如果是感冒引起的，那么就要及时的给孩子把感冒治疗好。在家里妈妈要做到每顿饭给孩子吃的七八分饱，清淡饮食不吃鱼肉，海鲜生冷以及水果。如果是鼻炎，那就要把鼻炎给它治疗好。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>10.宝妈：孩子拉肚子好几天了，拉绿色泡沫，吃药都不见好，还干咳，怎么办？</p>
				<p class="my-answer" >吉老师：这种情况应该是孩子有点胃肠型感冒。
孩子拉绿色的大便，是因为给孩子吃的多、积食导致的。孩子吃多积食后，会需要分泌大量的胆汁来消化食物，胆汁是绿色的，所以说孩子大便一直是绿色的，大便带有泡沫，是因为孩子长时间的积食产热形成的。咳嗽是因为孩子长时间的腹泻，抵抗力下降外受风寒所导致的。
</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>11.宝妈：孩子有时说话喉咙像有痰，咳嗽的时候是干咳，这是什么原因？</p>
				<p class="my-answer" >吉老师：像这种情况，说话的时候有痰，咳嗽的时候又是清嗓子的干咳，这只能是说明平时孩子吃的是比较多，积食导致脾为生痰。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>12.宝妈：宝宝四天没有拉粑粑了，想知道怎么回事？</p>
				<p class="my-answer" >吉老师：这种情况考虑宝宝平时吃的过多造成脾胃运化无力导致的便秘。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>13.宝妈：孩子之前断断续续拉了一个星期了，有时候拉黄色的有泡沫，有时候拉绿色的有泡沫，有时拉的稀的里面有没消化的食物残渣，最近几天孩子早晨醒来会咳嗽一阵，起来后就一整天都不咳嗽，是怎么回事？
</p>
				<p class="my-answer" >吉老师：这种情况要看宝宝多大，如果说单纯就是早上起来咳嗽几声的话，应该没有什么太大的问题。
但是这个大便是不正常的，可能就是吃多了积食导致的。这种情况呢，给宝宝一定要少吃，每顿饭吃到七八分饱，不要吃海鲜鱼肉，包括生冷的食物以及水果，如果是哺乳期，妈妈也要忌食。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>14.宝妈：孩子鼻窦炎在家怎么养护？</p>
				<p class="my-answer" >吉老师：在家里一定要给孩子注意不要吃一些寒凉生冷、容易过敏的食物，再就是做好护理，不要让他感冒引起鼻炎加重。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>15.宝妈：宝宝什么时候可以断夜奶，具体怎么做？</p>
				<p class="my-answer" >吉老师：如果说现在还是给宝宝吃夜奶，可以逐步的减少，从以前正常的一天晚上吃两顿可以慢慢的改成一顿，再慢慢的给它戒了。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>16.宝妈：孩子流鼻涕怎么办？</p>
				<p class="my-answer" >吉老师：孩子流鼻涕了首先要看流鼻涕的原因是风寒感冒还是鼻炎导致的，知道了病因才好对症治疗。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>17.宝妈：孩子积食怎么推拿、怎么护理？</p>
				<p class="my-answer" >吉老师：积食时的护理，首先要给孩子饿一下，少食多餐。只要孩子积食，每顿都给孩子吃三分到五分饱，并且不吃水果，不吃鸡鸭鱼肉海鲜等。
孩子可以通过推拿治疗，但是一定要有孩子具体的体征。单凭一个积食怎么推拿没法回答。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>18.宝妈：小孩子肠胃消化不良，推哪些穴位有利呢？</p>
				<p class="my-answer" >吉老师：孩子因消化不良需要一个推拿方，因为没有具体的体征，所以只能给一个通调方法：清补大肠 300 。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>19.宝妈：过敏性咳嗽可以推拿吗？</p>
				<p class="my-answer" >吉老师：过敏性咳嗽是可以通过推拿调理的，但是过敏性咳嗽是比较复杂的，所以就需要专业推拿师的调理。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>20.宝妈：咳嗽怎么推拿？要注意什么？</p>
				<p class="my-answer" >吉老师：咳嗽分了好多种情况，要根据具体情况引起的咳嗽，干咳或有痰的咳嗽，才能给出推拿方法。
但家长一定要给咳嗽的孩子做好护理，不要给孩子吃水果、鸡鸭鱼肉等一些生痰的食物，给孩子少食多餐。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>21.宝妈：宝宝脾虚怎么办？</p>
				<p class="my-answer" >吉老师：让宝宝少食多餐，吃温热的食物，不要吃寒凉性的食物。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>22.宝妈：什么时候可以补钙？</p>
				<p class="my-answer" >吉老师：孩子出生后一个月以后就可以补钙。每年的最佳补钙时间是三月到五月， 2 个月的时间。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>23.宝妈：宝宝的睡眠时间？</p>
				<p class="my-answer" >吉老师：宝宝月子里正常睡 21-22 个小时， 2-3 个月睡 20 个小时左右， 3 个月以后睡 15-18 个小时， 6 个月以后睡 13-15 个小时。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>24.宝妈：宝宝脸部为什么出现红血丝？</p>
				<p class="my-answer" >吉老师：阳气虚会导致红血丝。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>25.宝妈：宝宝多大加辅食？一般加多少?</p>
				<p class="my-answer" >吉老师：孩子四个月到七个月为过渡期辅食的引入时间，每天只能添一次，一次的辅食量为一小勺的二分之一。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>26.宝妈：宝宝肚脐什么时候能掉？</p>
				<p class="my-answer" >吉老师：一般十天左右就能掉。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>27.宝妈：宝宝鼻塞怎么办？</p>
				<p class="my-answer" >吉老师：先检查一下有没有鼻屎堵塞鼻孔，再检查宝宝有没有感冒，大点的宝宝还要检查鼻腔内有没有异物。
有鼻屎的情况，可以把香油熬开，放凉给宝宝抹鼻孔，鼻屎就可以自己喷出来。
感冒鼻塞的情况下家长可以把双手搓热给宝宝捂捂囟门和前额，每次20分钟左右，平时要注意戴帽子。如果没有缓解就要及时去医院检查或是进行推拿。
</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>28.宝妈：宝宝便秘怎么办？</p>
				<p class="my-answer" >吉老师：宝宝便秘了，先要找出便秘的原因，宝宝便秘大多是由于积食或是吃生冷寒凉的食物、水果太多引起的。
找出原因就先要从护理上给宝宝少吃饭，不要吃生冷寒凉的食物以及海鲜和太油腻的食物，要吃温热食品。运用推拿治疗便秘是最安全、最有效并且没有副作用的方法。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>29.宝妈：宝宝夜啼的原因？</p>
				<p class="my-answer" >吉老师：非疾病性的有：第一，积食；第二，温度太高；第三，气温太低寒冷；第四，没有及时更换尿布；第五，蚊虫叮咬；第六，缺钙；第七，包被太紧。
疾病性的有：第一，感冒发热；第二，腹痛；第三，耳朵痛；第四，呕吐；第五，腹泻。</p>
			</div>
			<div class="my-faq-box">
				<p class="my-question"><em>问</em>30.宝妈：怎么给宝宝拍嗝？</p>
				<p class="my-answer" >吉老师：斜抱起宝宝，家长手半曲，用手掌由上往下轻拍。</p>
			</div>
		</div>
	</div>
	<script src="js-changsha/mui.min.js"></script>
</body>
</html>
