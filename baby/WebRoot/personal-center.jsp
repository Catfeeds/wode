<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="com.dao.*"%>
<%@ page import="com.bean.*"%>
    <%
	User user =(User)request.getSession().getAttribute("user");
	//未登录状态
	if (user == null) { 
		response.sendRedirect("xuanzejiemian.jsp");
		return;
	} else {
	
	}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>我的</title>
    <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" name="viewport" />
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <meta content="telephone=no" name="format-detection" />
    <link rel="stylesheet" href="dep-td/css/ydui.css" />
    <script src="dep-td/js/ydui.flexible.js"></script>
    <link rel="stylesheet" type="text/css" href="css-td/health.css" />
    
    <style>
        .m-confirm {
            width: 5.4rem;
            height: 2.2rem;
            background-color: #ffffff;
            border-radius: 0.24rem;
        }
        .confirm-bd{
            padding: .25rem .35rem;
            color: #373737;
            font-size: 0.34rem;
        }
        .confirm-ft>a.confirm-btn.primary{
            color: #3c2323;
        }
    </style>
</head>
<body>
     <div class="g-flexview me-bgc">
         <div class="g-scrollview">
             <div class="me-t">
                 <img class="header" src="img/image2.png" />
                 <div class="text">
                     <p class="name">吉氏扶阳小儿推拿</p>
                     <p class="welcome">欢迎来到健康宝管理系统！</p>
                 </div>
             </div>
             <div class="m-cell me-list">
				<%
				 if(user.getUpower()==0||user.getUpower()==1||user.getUpower()==2){
				    %>
                 <a class="cell-item" href="inputxinxi.jsp">
                     <div class="cell-left"><img src="img/write.png" />信息录入</div>
                     <div class="cell-right"><img src="img/enter.png" /></div>
                 </a>
                 <%
			       }
			       %>
                 <a class="cell-item" href="SearchPatientXinxiServlet?w=1">
                     <div class="cell-left"><img src="img/file.png" />健康档案</div>
                     <div class="cell-right"><img src="img/enter.png" /></div>
                 </a>

                 <a class="cell-item" href="Fankuiyijian.jsp">
                     <div class="cell-left"><img src="img/Feedback.png" />反馈意见</div>
                     <div class="cell-right"><img src="img/enter.png" /></div>
                 </a>
                 <a class="cell-item" href="changepass.jsp">
                     <div class="cell-left"><img src="img/modify.png" />修改密码</div>
                     <div class="cell-right"><img src="img/enter.png" /></div>
                 </a>
                 <a class="cell-item" href="ExitServlet" id="quit">
                     <div class="cell-left"><img src="img/out.png" />退出</div>
                     <div class="cell-right"><img src="img/enter.png" /></div>
                 </a>
                 <%
				 if(user.getUpower()==0){
				    %>
                 <a class="cell-item" href="SearchAgentServlet?w=1" id="quit">
                     <div class="cell-left"><img src="img/out.png" />会员查看和添加</div>
                     <div class="cell-right"><img src="img/enter.png" /></div>
                 </a>
                  <%
			       }
			       %>
			       <%
				 if(user.getUserid()==2){
				    %>
                 <a class="cell-item" href="addzhucefram.jsp" id="quit">
                     <div class="cell-left"><img src="img/out.png" />用户注册</div>
                     <div class="cell-right"><img src="img/enter.png" /></div>
                 </a>
                  <%
			       }
			       %>
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
                        	<li><a href="Shiliaoxiaofang.jsp">食疗小方</a></li>
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
         </div>
     </div>
     <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
     <script src="dep-td/js/ydui.js"></script>
     <script src="js-td/health.js" type="text/javascript" charset="utf-8"></script>
     <script type="text/javascript">
         $("#quit").click(function() {
             YDUI.dialog.confirm('', '确定要退出吗？', function() {
                 //退出
             });
         })
     </script>
 </body>
</html>