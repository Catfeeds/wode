<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

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
<html >   
<head>
<meta charset="utf-8">
    <title>信息录入</title>
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
	<div class="g-flexview me-bgc">
              <div class="navigation">
                  <a class="back" href="javascript:;" onclick="javascript:history.back(-1);"><img src="img/back.png" /></a>
               <div class="navigation-title">信息录入</div>
           </div>
	<form method="post" action="SavePatientXinxiServlet" onSubmit="return adaptValue();">
           <div class="m-cell infor">
               <div class="cell-item">
                   <div class="cell-left">家长姓名</div>
                   <div class="cell-right">
                       <input type="text" class="cell-input" name="ppname" id="patriarch"  placeholder="请输入家长姓名" autocomplete="off" />
                       <img src="img/enter.png" />
                   </div>
               </div>
               <div class="cell-item">
                   <div class="cell-left">联系电话</div>
                   <div class="cell-right">
                       <input type="number" class="cell-input" name="pphone" id="phone"  placeholder="请输入 联系电话" autocomplete="off" />
                       <img src="img/enter.png" />
                   </div>
               </div>
               <div class="cell-item">
                   <div class="cell-left">宝宝姓名</div>
                   <div class="cell-right">
                       <input type="text" class="cell-input" name="pname" id="baby" placeholder="请输入宝宝姓名" autocomplete="off" />
                       <img src="img/enter.png" />
                   </div>
               </div>

               <div class="cell-item">
                   <div class="cell-left">宝宝性别</div>
                   <div class="cell-right" id="sex">
                       <label class="cell-item">
                           <label class="cell-right">
                               <input type="radio" name="pxb" value="男" checked/>
                               <i class="cell-radio-icon"></i>
                           </label>
                       <span class="cell-left"><img src="img/boy.png"/></span>

                       </label>
                       <label class="cell-item">

                           <label class="cell-right">
                               <input type="radio" name="pxb" value="女"/>
                               <i class="cell-radio-icon"></i>
                           </label>
                       <span class="cell-left"><img src="img/girl.png"/></span>
                       </label>
                   </div>
               </div>

               <div class="cell-item">
                   <div class="cell-left">宝宝年龄</div>
                   <div class="cell-right">
                       <input type="text" class="cell-input" name="page" id="age" placeholder="请输入宝宝年龄" autocomplete="off" />
                       <img src="img/enter.png" />
                   </div>
               </div>

               <div class="cell-item">
                   <div class="cell-left">家长微信</div>
                   <div class="cell-right">
                       <input type="text" class="cell-input" name="weixin" id="wx" placeholder="请输入家长微信" autocomplete="off" />
                       <img src="img/enter.png" />
                   </div>
               </div>
               <div class="cell-item">
                   <div class="cell-left">地址</div>
                   <div class="cell-right">
                       <input type="text" class="cell-input" readonly="" name="paddress" id="J_Address"  placeholder="请选择地址">
                       <img src="img/enter.png" />
                   </div>
               </div>
           </div>

           <button id="submit" type="submit" class="btn-block  present">提交</button>
        </form>
       </div>
       
       <footer class="m-tabbar">
                    <a href="xuanzejiemian.jsp" class="tabbar-item" id="tuina">
                        <span class="tabbar-icon">
                            <img src="img/bar1.png"/>
                        </span>
                        <span class="tabbar-txt">推拿取穴</span>
                    </a>
                    <div class="tabbar-item" id="silk">
                        <span class="bgc-jn" id="bgc-jn"></span>
                        <span class="tabbar-txt">育儿锦囊</span>
                        <img class="bts-img" src="img/bts.png"/>
                        <ul class="silk">
                        	<li><a href="Tiaolifayu.jsp">宝宝成长</a></li>
                        	<li><a href="Tiaoliyinshi.jsp">饮食调理</a></li>
                        	<li><a href="Tiaolishuimian.jsp">睡眠调理</a></li>
                        	<li><a href="Tiaolichuandai.jsp">穿戴养护</a></li>
                        </ul>
                    </div>
                    <div class="tabbar-item" id="classroom">
                        <span class="bgc-cr" id="bgc-cr"></span>
                        <span class="tabbar-txt">育儿课堂</span>
                        <img class="bts-img" src="img/bts.png"/>
                        <ul class="silk">
                            <li><a href="Shipintuina.jsp">穴位查找</a></li>
                            <li><a href="Jilaoshiwenda.jsp">吉老师问答</a></li>
                            <li><a href="Tuinaxuzhi.jsp">推拿须知</a></li>
                        </ul>
                    </div>
                    <a href="personal-center.jsp" class="tabbar-item" id="me">
                        <span class="tabbar-icon">
                            <img src="img/bar4.png"/>
                        </span>
                        <span class="tabbar-txt c-e9">我的</span>
                    </a>
                </footer>
   <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
   <script src="dep-td/js/ydui.js"></script>
   <script src="js-td/health.js" type="text/javascript" charset="utf-8"></script>
   <script src="http://static.ydcss.com/uploads/ydui/ydui.citys.js"></script>
   <script type="text/javascript">
       $('#submit').click(function() {
           var reg = /^(13[0-9]|14[5-9]|15[012356789]|166|17[0-8]|18[0-9]|19[8-9])[0-9]{8}$/,
               patriarch = $('#patriarch').val(),
               phone = $('#phone').val(),
               baby = $('#baby').val(),
               age = $('#age').val(),
               wx = $('#wx').val(),
               site = $('#J_Address').val(),
               sex = $("input[name='pxb']:checked").val();
           if(patriarch == '') {
               YDUI.dialog.toast('请输入家长姓名', 'none', 1000);
               return false;
           }
           if(!reg.test(phone)) {
               YDUI.dialog.toast('请输入十一位正确格式的手机号', 'none', 1000);
               return false;
           }

           if(baby == '') {
               YDUI.dialog.toast('请输入宝宝姓名', 'none', 1000);
               return false;
           }

           if(age == '') {
               YDUI.dialog.toast('请输入宝宝年龄', 'none', 1000);
               return false;
           }

           if(wx == '') {
               YDUI.dialog.toast('请输入您的微信号', 'none', 1000);
               return false;
           }
           if(site == '') {
               YDUI.dialog.toast('请选择您的地址', 'none', 1000);
               return false;
           }
       })
   </script>
   <!--地址-->
   <script type="text/javascript">
       var $address = $('#J_Address');
       $address.citySelect();
       $address.on('click', function() {
           $address.citySelect('open');
       });
       $address.on('done.ydui.cityselect', function(ret) {
           $(this).val(ret.provance + ' ' + ret.city + ' ' + ret.area);
       });
   </script>
</body>
</html>