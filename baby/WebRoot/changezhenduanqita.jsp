<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加诊断</title>
 <link type="text/css" href="css/menu.css" rel="stylesheet" />
  <link type="text/css" href="css/zhuce.css" rel="stylesheet" />
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
</head>

<body>
<div class="form-bak1">
<form id="myForm" method="post" action="ChangeZdQita">
<input type="hidden" name="pid" value="${pid }"/>
<center>
<div style="width: 650;" margin:0 auto; align="left">
睡眠不宁：夜啼
<select name="yeti" style="width: 300;  background-color: #98FB98">
<option value="00_正常">正常</option>
<option value="01_脾胃虚寒">脾胃虚寒</option>
<option value="02_心惊炽热">心惊炽热</option>
<option value="03_积食">积食</option>
<option value="04_惊吓">惊吓</option>
<option value="05_缺钙">缺钙</option>
</select>
</br>
</br>
遗尿：
<select name="yiniao" style="width: 300;  background-color: #98FB98">
<option value="00_正常">正常</option>
<option value="01_脾肾虚寒">脾肾虚寒</option>
<option value="02_脾肺虚损">脾肺虚损</option>
<option value="03_肝经湿热">肝经湿热</option>
<option value="04_痰湿内蕴">痰湿内蕴</option>
<option value="05_疲劳生热">疲劳生热</option>
</select>
</br>
</br>
尿频：
<select name="niaopin" style="width: 300;  background-color: #98FB98">
<option value="00_正常">正常</option>
<option value="01_精神紧张">精神紧张</option>
<option value="02_脾肾虚寒">脾肾虚寒</option>
</select>
</br>
</br>
多汗：
<select name="duohan" style="width: 300;  background-color: #98FB98">
<option value="00_正常">正常</option>
<option value="01_阳虚自汗">阳虚自汗</option>
<option value="02_阴虚盗汗">阴虚盗汗</option>
</select>
</br>
</br>
肠系膜淋巴结肿大：
<select name="linbajie" style="width: 300;  background-color: #98FB98">
<option value="00_正常">正常</option>
<option value="01_虚寒腹痛">虚寒腹痛</option>
<option value="02_湿热腹痛">湿热腹痛</option>
</select>
</br>
</br>
腹痛：
<select name="futong" style="width: 300;  background-color: #98FB98">
<option value="00_正常">正常</option>
<option value="01_寒性腹痛">寒性腹痛</option>
<option value="02_热性腹痛">热性腹痛</option>
<option value="03_食积腹痛">食积腹痛</option>
<option value="04_气郁腹痛">气郁腹痛</option>
<option value="05_虚寒腹痛">虚寒腹痛</option>
</select>
</br>
</br>
肠套叠：
<select name="changtaodie" style="width: 300;  background-color: #98FB98">
<option value="00_正常">正常</option>
<option value="01_剧烈腹痛">剧烈腹痛</option>
</select>
</br>
</br>

流涎：
<select name="liudan" style="width: 300;  background-color: #98FB98">
<option value="00_正常">正常</option>
<option value="01_脾胃积热">脾胃积热</option>
<option value="02_脾胃虚寒">脾胃虚寒</option>
</select>
</br>
</br>
湿疹：
<select name="shizhen" style="width: 300;  background-color: #98FB98">
<option value="00_正常">正常</option>
<option value="01_脾胃积热">脾胃积热</option>
<option value="02_脾胃虚寒">脾胃虚寒</option>
</select>
</br>
</br>
口疮：
<select name="kouchuang" style="width: 300;  background-color: #98FB98">
<option value="00_正常">正常</option>
<option value="01_虚火口疮">虚火口疮</option>
<option value="02_实火口疮">实火口疮</option>
<option value="03_鹅口疮">鹅口疮</option>
</select>
</br>
</br>


精神：
<select name="jingshen" style="width: 300;  background-color: #98FB98">
<option value="01_精神好">精神好</option>
<option value="02_精神可">精神可</option>
<option value="03_精神欠佳">精神欠佳</option>
<option value="04_精神不振">精神不振</option>
<option value="05_精神烦躁">精神烦躁</option>
<option value="06_精神萎靡">精神萎靡</option>
<option value="07_精神嗜睡">精神嗜睡</option>
<option value="08_精神昏迷">精神昏迷</option>
</select>
</br>
</br>
面色：

面色：
<select name="mianse" style="width: 300;  background-color: #98FB98">
<option value="01_面色正常，有光泽">面色正常，有光泽</option>
<option value="02_面色正常，无光泽">面色正常，无光泽</option>
<option value="03_面色淡白，无光泽伴脾虚斑">面色淡白，无光泽伴脾虚斑</option>
<option value="04_面色淡黄，无光泽伴脾虚斑">面色淡黄，无光泽伴脾虚斑</option>
<option value="05_面色暗黄，无光泽伴脾虚斑">面色暗黄，无光泽伴脾虚斑</option>
<option value="06_面色晦暗，无光泽伴脾虚斑">面色晦暗，无光泽伴脾虚斑</option>
<option value="07_面色红，无光泽">面色红，无光泽</option>
</select>
</br>
</br>

眼神：
<select name="yanshen" style="width: 300;  background-color: #98FB98">
<option value="01_目光有神">目光有神</option>
<option value="02_目光无神">目光无神</option>
</select>
</br>
</br>
眼睛：
<select name="yanjing" style="width: 300;  background-color: #98FB98">
<option value="01_正常">正常</option>
<option value="02_眼泪汪汪">眼泪汪汪</option>
<option value="03_两目红赤">两目红赤</option>
<option value="04_白睛发黄">白睛发黄</option>
<option value="05_白睛发红">白睛发红</option>
<option value="06_白睛发青">白睛发青</option>
<option value="07_眼结膜红赤">眼结膜红赤</option>
<option value="08_上下眼睑麦粒肿">上下眼睑麦粒肿</option>
<option value="09_眼睛分泌物增多">眼睛分泌物增多</option>
</select>
</br>
</br>
眼袋：
<select name="yandai" style="width: 300;  background-color: #98FB98">
<option value="01_下眼袋颜色正常">下眼袋颜色正常</option>
<option value="02_下眼袋青">下眼袋青</option>
<option value="03_下眼袋红">下眼袋红</option>
<option value="04_下眼袋黑">下眼袋黑</option>
<option value="05_下眼袋无肿大">下眼袋无肿大</option>
<option value="06_下眼袋肿大">下眼袋肿大</option>
</select>
</br>
</br>
鼻梁：
<select name="biliang" style="width: 300;  background-color: #98FB98">
<option value="01_鼻梁部光亮">鼻梁部光亮</option>
<option value="02_鼻梁部暗黄">鼻梁部暗黄</option>
<option value="03_鼻梁部色暗黄伴皮肤粗糙小竖纹">鼻梁部色暗黄伴皮肤粗糙小竖纹</option>
</select>
</br>
</br>
鼻准：
<select name="bizhun" style="width: 300;  background-color: #98FB98">
<option value="01_鼻准部微黄光亮">鼻准部微黄光亮</option>
<option value="02_鼻准部色黄无光泽">鼻准部色黄无光泽</option>
<option value="03_鼻准部暗黄无光泽">鼻准部暗黄无光泽</option>
<option value="04_鼻准部暗黑无光泽">鼻准部暗黑无光泽</option>
<option value="05_鼻准部暗黄伴白色小颗粒">鼻准部暗黄伴白色小颗粒</option>
</select>
</br>
</br>
鼻翼两侧：
<select name="biyi" style="width: 300;  background-color: #98FB98">
<option value="01_鼻翼两侧色泽正常">鼻翼两侧色泽正常</option>
<option value="02_鼻翼两侧发白">鼻翼两侧发白</option>
<option value="03_鼻翼两侧发青">鼻翼两侧发青</option>
<option value="04_鼻翼两侧发黄">鼻翼两侧发黄</option>
<option value="05_鼻翼两侧起皮">鼻翼两侧起皮</option>
</select>
</br>
</br>
鼻粘膜：
<select name="binianmo" style="width: 300;  background-color: #98FB98">
<option value="01_鼻黏膜正常">鼻黏膜正常</option>
<option value="02_鼻黏膜微红湿润">鼻黏膜微红湿润</option>
<option value="03_鼻黏膜微红干燥">鼻黏膜微红干燥</option>
<option value="04_鼻黏膜微红，干燥伴结节肿大">鼻黏膜微红，干燥伴结节肿大</option>
<option value="05_鼻黏膜微红，湿润伴结节肿大">鼻黏膜微红，湿润伴结节肿大</option>
<option value="06_鼻黏膜鲜红，湿润伴结节肿大">鼻黏膜鲜红，湿润伴结节肿大</option>
<option value="07_鼻黏膜鲜红，干燥伴结节肿大">鼻黏膜鲜红，干燥伴结节肿大</option>
<option value="08_鼻黏膜暗红，湿润伴结节肿大">鼻黏膜暗红，湿润伴结节肿大</option>
<option value="09_鼻黏膜暗红，干燥伴结节肿大">鼻黏膜暗红，干燥伴结节肿大</option>
<option value="10_鼻黏膜灰白，湿润">鼻黏膜灰白，湿润</option>
<option value="11_鼻黏膜灰白，干燥伴结节肿大">鼻黏膜灰白，干燥伴结节肿大</option>
<option value="12_流鼻黏膜干燥，出血">鼻黏膜干燥，出血</option>
<option value="13_鼻黏膜干燥，出血量少">鼻黏膜干燥，出血量少</option>
<option value="14_鼻黏膜干燥，出血量多">鼻黏膜干燥，出血量多</option>
</select>
</br>
</br>
唇：
<select name="chun" style="width: 300;  background-color: #98FB98">
<option value="01_唇色淡红，湿润">唇色淡红，湿润</option>
<option value="02_唇色淡红，干燥有竖纹">唇色淡红，干燥有竖纹</option>
<option value="03_唇色淡白，湿润有竖纹">唇色淡白，湿润有竖纹</option>
<option value="04_唇色淡白，干燥无竖纹">唇色淡白，干燥无竖纹</option>
<option value="05_唇色淡红，干燥起皮">唇色淡红，干燥起皮</option>
<option value="06_唇色淡红，干燥，黄水疮">唇色淡红，干燥，黄水疮</option>
<option value="07_唇色红，湿润有竖纹">唇色红，湿润有竖纹</option>
<option value="08_唇色红，干燥无竖纹">唇色红，干燥无竖纹</option>
<option value="09_唇色红，干燥起皮">唇色红，干燥起皮</option>
<option value="10_唇色红，干燥，唇疮">唇色红，干燥，唇疮</option>
<option value="11_唇色深红，湿润，有竖纹">唇色深红，湿润，有竖纹</option>
<option value="12_唇色深红，干燥，无竖纹">唇色深红，干燥，无竖纹</option>
<option value="13_唇色深红，干燥，起皮，干裂">唇色深红，干燥，起皮，干裂</option>
<option value="14_唇色深红，干燥，唇疮">唇色深红，干燥，唇疮</option>
<option value="15_唇色鲜红，湿润">唇色鲜红，湿润</option>
<option value="16_唇色鲜红，干燥，无竖纹">唇色鲜红，干燥，无竖纹</option>
<option value="17_唇色鲜红，肿胀，无竖纹">唇色鲜红，肿胀，无竖纹</option>
<option value="18_唇色鲜红，干燥，起皮，干裂">唇色鲜红，干燥，起皮，干裂</option>
<option value="19_唇色暗红，湿润，有竖纹">唇色暗红，湿润，有竖纹</option>
<option value="20_唇色暗红，干燥，无竖纹">唇色暗红，干燥，无竖纹</option>
<option value="21_唇色暗红，干燥，无竖纹，起皮，干裂">唇色暗红，干燥，无竖纹，起皮，干裂</option>
<option value="22_唇色暗红，干燥，唇疮">唇色暗红，干燥，唇疮</option>
<option value="23_下唇中间鲜红光亮，无竖纹">下唇中间鲜红光亮，无竖纹</option>
<option value="24_下唇中间暗红，无竖纹">下唇中间暗红，无竖纹</option>
<option value="25_下唇线暗红，口唇干燥">下唇线暗红，口唇干燥</option>
<option value="26_上唇线暗红，口唇干燥">上唇线暗红，口唇干燥</option>
</select>
</br>
</br>
舌体：
<select name="sheti" style="width: 300;  background-color: #98FB98">
<option value="01_舌体正常">舌体正常</option>
<option value="02_舌体胖大，娇嫩">舌体胖大，娇嫩</option>
<option value="03_舌体胖大，齿痕">舌体胖大，齿痕</option>
<option value="04_舌体瘦长">舌体瘦长</option>
<option value="05_舌体薄瘦长">舌体薄瘦长</option>
<option value="06_舌体正常裂纹">舌体正常裂纹</option>
</select>
</br>
</br>
舌质：
<select name="shezhi" style="width: 300;  background-color: #98FB98">
<option value="01_舌质细柔淡红">舌质细柔淡红</option>
<option value="02_舌质粗糙淡白">舌质粗糙淡白</option>
<option value="03_舌质细柔淡白">舌质细柔淡白</option>
<option value="04_舌质粗糙淡红">舌质粗糙淡红</option>
<option value="05_舌质粗糙，红">舌质粗糙，红</option>
<option value="06_舌质粗糙，深红">舌质粗糙，深红</option>
<option value="07_舌质粗糙，暗红">舌质粗糙，暗红</option>
<option value="08_舌质粗糙伴圆形大芒刺">舌质粗糙伴圆形大芒刺</option>
<option value="09_舌质细柔伴圆形大芒刺">舌质细柔伴圆形大芒刺</option>
<option value="10_舌质细柔长形芒刺">舌质细柔长形芒刺</option>
<option value="11_舌质粗糙长形芒刺">舌质粗糙长形芒刺</option>
<option value="12_舌尖有细小芒刺，色红">舌尖有细小芒刺，色红</option>
<option value="13_地图舌，舌质粗糙">地图舌，舌质粗糙</option>
<option value="14_地图舌，舌质细柔">地图舌，舌质细柔</option>

</select>
</br>
</br>
舌苔：
<select name="shetai" style="width: 300;  background-color: #98FB98">
<option value="01_舌苔白润">舌苔白润</option>
<option value="02_舌苔白腻">舌苔白腻</option>
<option value="03_舌苔白厚">舌苔白厚</option>
<option value="04_舌苔白中带黄润">舌苔白中带黄润</option>
<option value="05_舌苔白中带黄腻">舌苔白中带黄腻</option>
<option value="06_舌苔白中带灰润">舌苔白中带灰润</option>
<option value="07_舌苔白中带灰腻">舌苔白中带灰腻</option>
<option value="08_舌苔黄腻">舌苔黄腻</option>
<option value="09_舌苔黄厚">舌苔黄厚</option>
<option value="10_舌苔黄滑">舌苔黄滑</option>
<option value="11_舌苔白滑">舌苔白滑</option>
<option value="12_舌苔花剥苔">舌苔花剥苔</option>
</select>
</br>
</br>
咽喉：
<select name="yanhou" style="width: 300;  background-color: #98FB98">
<option value="01_咽部微红">咽部微红</option>
<option value="02_咽部红">咽部红</option>
<option value="03_咽部鲜红">咽部鲜红</option>
<option value="04_咽部暗红">咽部暗红</option>
<option value="05_咽部红色丘疹">咽部红色丘疹</option>
<option value="06_咽部暗红色出血点">咽部暗红色出血点</option>
<option value="07_咽部红色片状出血点">咽部红色片状出血点</option>
<option value="08_咽部悬雍垂肿大，色红">咽部悬雍垂肿大，色红</option>
<option value="09_咽部鲜红，状似出血">咽部鲜红，状似出血</option>
<option value="10_咽部咽后壁滤泡">咽部咽后壁滤泡</option>
<option value="11_咽部咽后壁挂有鼻涕">咽部咽后壁挂有鼻涕</option>
<option value="12_扁桃体一度">扁桃体一度</option>
<option value="13_扁桃体二度">扁桃体二度</option>
<option value="14_扁桃体三度">扁桃体三度</option>
<option value="15_扁桃体化脓">扁桃体化脓</option>
<option value="16_咽部鲜红，充血">咽部鲜红，充血</option>
<option value="17_咽部鲜红色疹子">咽部鲜红色疹子</option>
<option value="18_咽部鲜红，伴溃疹">咽部鲜红，伴溃疹</option>
</select>
</br>
</br>
</div>
</center>

<input id="addRecord" type="button" name="提交"  value="提交"/>
</form>
</div>
</body>
</html>

