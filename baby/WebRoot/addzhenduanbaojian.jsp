<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <meta charset="utf-8">
    <title>症状选择</title>
    <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" name="viewport" />
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <meta content="telephone=no" name="format-detection" />
    <link rel="stylesheet" href="dep-td/css/ydui.css" />
    <script src="dep-td/js/ydui.flexible.js"></script>
    <link rel="stylesheet" type="text/css" href="css-td/health.css" />
    <script type="text/javascript">
    	
   		document.addEventListener('plusready', function(){
   			//console.log("所有plus api都应该在此事件发生后调用，否则会出现plus is undefined。"
   			
   		});
   		
    </script>
</head>
<body>
	
	 <form id="form7" action="InputBaojian" method="post">
	 <div class="g-flexview bgc-imgt">
            <div class="g-scrollview">
				<div class="m-cell symptom">
					<div class="navigation">
                    <a class="back" href="javascript:;" onclick="javascript:history.back(-1);"><img src="img/back.png" /></a>
                    <div class="navigation-title">保健</div>
                </div>
					
					
                    <label class="cell-item">
                        <label class="cell-left">日常保健</label>
                    <label class="cell-right">
                            <input type="radio" name="baojian" checked="checked" value="01_日常保健"/>
                            <i class="cell-checkbox-icon"></i>
                    </label>
                    </label>
                    <label class="cell-item">
                        <label class="cell-left">易感儿</label>
                    <label class="cell-right">
                            <input type="radio" name="baojian" value="02_易感儿"/>
                            <i class="cell-checkbox-icon"></i>
                    </label>
                    </label>

                </div>
                
                <div class="standard-list">
                       <div class="title"></div>
					<p><b>日常保健：</b>根据节气不同变换，一年四季根据八节二十四气七十二候取穴组方；
日常保健穴位是平时在家给孩子取穴推拿保健，来激发经络之气,以起到通经活络、调节人体脏腑气血功能的作用,达到预防保健改善机体免疫功能，起到扶正培元，强身健体的作用。另外，保健穴位有较好的健运脾胃的功能，补中益气，有效调理胃肠功能。</p>
					<p><b>易感儿：</b>易感儿，多见于6个月至6岁的宝宝，其中以1-3岁的宝宝更为多见。尤其是在季节交替的时候，气候一发生变化，他们体质较差，便反复地并发呼吸道感染。由于处理不当，很容易引发哮喘等疾病，严重影响生长发育速度和身心健康。
易感儿体征：
面色淡黄/暗黄，无光泽（面色晦暗），舌苔白厚，唇色淡红（唇色发白血色度不足）
触摸孩子手脚常表现为发凉，触摸孩子后脖颈表现为发凉</p>

                </div>

                <button id="submit" type="submit" class="btn-block  present">提交</button>
            </div>
        </div>
       </form>
        <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="dep-td/js/ydui.js"></script>
</body>
</html>