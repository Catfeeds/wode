<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.dao.*"%>
<%@ page import="com.bean.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>用户注册</title>
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
    <script type="text/javascript">
			function doShow() {
				if(document.getElementById("phone").value == "") {
					alert("请输入手机号");
					document.getElementById("phone").focus();
					return false;
				}
				else{
				     var num = document.getElementById("phone").value;
		             var phone1 = /^1[3,5]\d{9}$/;
		             var phone2= /^1[0-9]{10}$/;
		             //var phone3=/(^(\d{3,4}-)?\d{7,8})$|(13[0-9]{9}$/
		                        
		               if(phone1.test(num)||phone2.test(num)){
		             }
		              else{alert("手机号输入ddd不正确");
		                 return false;}
				}
				var myphone= document.getElementById("phone").value;
				var uname= document.getElementById("uname").value;
				var qqweixin= document.getElementById("phone").value;
				var address= document.getElementById("J_Address").value;
				var password= document.getElementById("password").value;
				var qrpassword= document.getElementById("qrpassword").value;
				var time= document.getElementById("time").value;
				var pId= document.getElementById("pId").value;
				window.location.href="MagServlet?myphone="+myphone+"&uname="+uname+"&qqweixin="+qqweixin+"&address="+address+"&password="+password+"&qrpassword="+qrpassword+"&time="+time+"&pId="+pId;
			}
	</script>
    
    <script type="text/javascript">
    	function changeShow(){
    		document.getElementById("duxinyz1").style.display="block";
    		document.getElementById("duxinyz2").style.display="block";
    		document.getElementById("duxinyz3").style.display="block";
    	}
    
    </script>
    <script type="text/javascript">
    	function adaptValue() {
    	
    		if(document.getElementById("uname").value == "") {
			alert("请输入姓名");
			document.getElementById("uname").focus();
			return false;
		}
    	if(document.getElementById("password").value == "") {
			alert("请输入密码");
			document.getElementById("password").focus();
			return false;
		}else{
		     var num = document.getElementById("password").value;
             var pass1 = /^[0-9]*$/;
             //var phone2= /^1[0-9]{10}$/;
             //var phone3=/(^(\d{3,4}-)?\d{7,8})$|(13[0-9]{9}$/
                        
               if(pass1.test(num)){
               if(document.getElementById("qrpassword").value == document.getElementById("password").value){
               		
               }else{alert("密码不一致！");
                 	return false;}
             }else{alert("密码不正确！");
                 return false;}
		}
    		
		/*if(document.getElementById("qqweixin").value == "") {
			alert("请输入微信号");
			document.getElementById("qqweixin").focus();
			return false;
		}*/
			
    	 	if(document.getElementById("J_Address").value == "") {
			alert("请输入地址");
			document.getElementById("J_Address").focus();
			return false;
		} 
		if(document.getElementById("phone").value == "") {
			alert("请输入手机号");
			document.getElementById("phone").focus();
			return false;
		}
		else{
		     var num = document.getElementById("phone").value;
             var phone1 = /^1[3,5]\d{9}$/;
             var phone2= /^1[0-9]{10}$/;
             //var phone3=/(^(\d{3,4}-)?\d{7,8})$|(13[0-9]{9}$/
                        
               if(phone1.test(num)||phone2.test(num)){
             }
              else{alert("手机号输入不正确");
                 return false;}
		}
		
		if(document.getElementById("yanzm").value == "" || document.getElementById("yanzm").value == null) {
			alert("请输入验证码");
			document.getElementById("yanzm").focus();
			return false;
		}else if(document.getElementById("charValue").value == document.getElementById("yanzm").value){
			return true; 
		}else{
			alert("验证码不正确，请输入正确验证码!");
			return false;
		}
    			//校验数据
    			//数据合法返回true，否则返回false，并提示用户
    			return true;
   }
    		
    
    </script>
  </head>
  
  <body>
    <div class="g-flexview me-bgc">
              <div class="navigation">
                  <a class="back" href="javascript:;" onclick="javascript:history.back(-1);"><img src="img/back.png" /></a>
               <div class="navigation-title">用户注册</div>
           </div>
	<form method="post" action="AddZhuceServlet">
           <div class="m-cell infor">
           	    
               <div class="cell-item">
                   <div class="cell-left">输入姓名</div>
                   <div class="cell-right">
                       <input type="text" class="cell-input" name="uname" id="uname"  value="${uname}" id="patriarch"  placeholder="请输入姓名" autocomplete="off" />
						<input type="hidden" name="time" id="time" value="${time}">
                       <img src="img/enter.png" />
                   </div>
               </div>
               
               <div class="cell-item">
                   <div class="cell-left">输入密码</div>
                   <div class="cell-right">
                       <input type="text" class="cell-input" name="password" id="password" value="${password}" placeholder="请输入密码" autocomplete="off" />
                       <img src="img/enter.png" />
                   </div>
               </div>
               
               <div class="cell-item">
                   <div class="cell-left">确认密码</div>
                   <div class="cell-right">
                       <input type="text" class="cell-input" name="qrpassword" id="qrpassword" value="${qrpassword}" placeholder="请确认输入密码" autocomplete="off" />
                       <img src="img/enter.png" />
                   </div>
               </div>

               <div class="cell-item">
                   <div class="cell-left">地址</div>
                   <div class="cell-right">
                  	   <input type="hidden" name="charValue" id="charValue" value="${charValue}">
					   <input type="hidden" name="time" id="time" value="${time}">
                       <input type="text" class="cell-input" readonly="" name="paddress" id="J_Address" value="${address}" placeholder="请选择地址">
                       <img src="img/enter.png" />
                   </div>
               </div>
               <div class="cell-item">
                   <div class="cell-left">手机号码</div>
                   <div class="cell-right">
                       <input type="number" class="cell-input" name="phone" id="phone" value="${myphone}"  placeholder="手机号码为登录账号" autocomplete="off" />
                       <img src="img/enter.png" />
                   </div>
               </div>
               <div class="cell-item">
                   <div class="cell-right">
						<div onClick="doShow();" style="color:red;" id="duxinyz3">获取验证码</div>
                   </div>
               </div>
               
               <div class="cell-item">
                   <div class="cell-left">输入验证码</div>
                   <div class="cell-right">
						<input type="text" class="cell-input" name="yanzm" id="yanzm"  placeholder="输入验证码">
                       <img src="img/enter.png" />
                   </div>
               </div>
           </div>
           <input name="pId" id="pId" type="hidden" value="${param.pid}" />
           <button id="submit" type="submit" class="btn-block  present"  onClick="return adaptValue();">注册</button>
           </br></br>
           <p style="text-align:center;font-size: 20px;">
				注册成功即赠送<span
					style="font-size: 26px;color: #ff0000;font-weight:bold;font-style: italic;">3天vip取穴功能！</span>
			</p>
        </form>
       </div>
       
   <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
   <script src="dep-td/js/ydui.js"></script>
   <script src="js-td/health.js" type="text/javascript" charset="utf-8"></script>
   <script src="http://static.ydcss.com/uploads/ydui/ydui.citys.js"></script>
   <!-- <script type="text/javascript">
       $('#submit').click(function() {
           var reg = /^1[34578]\d{9}$/,
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
               YDUI.dialog.toast('请选择您的地址', 'none', 1000)
               return false;
           }
       })
   </script> -->
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