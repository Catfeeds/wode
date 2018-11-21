<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>玖壹健康管理系统</title>
<link type="text/css" href="css/menu.css" rel="stylesheet" />
<link type="text/css" href="css/zhuce.css" rel="stylesheet" />

<script type="text/javascript">

</script>
</head>


<body>

<div class="form-bak1">
<center>
<div style="width: 400;" align="left">
<form action="AddPhoServlet" method="post" enctype="multipart/form-data">

</br>
  </br>
   上传文件：<input type="file" name="upload" siez="16">
</br></br> 
所属分类：
<select name="ppower" style="width: 180px;  background-color: #98FB98">
<option value="1_舌部">舌部</option>
<option value="2_唇色">唇色</option>
<option value="3_面色">面色</option>
<option value="4_咽喉">咽喉</option>
<option value="5_各种疹">各种疹</option>
<option value="6_化验单">化验单</option>
</select>
</br>
</br>
图片名称：
<input type="text" name="pname"  style="width: 180; ">
  </br>
  </br>
   
  <input type="submit" value="提交" style="width: 60; height:40; ">    
  </form>       

</div>
</center>
</div>
</body>
</html>