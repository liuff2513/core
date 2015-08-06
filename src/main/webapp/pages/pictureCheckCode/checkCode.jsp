<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>checkCode.jsp</title>
  </head>
  <body>
  	<input name="checkCode" type="text" id="checkCode" title="验证码区分大小写" size="8" maxlength="4"/>
  	<img src="<%=basePath%>test/pictureCheckCode.action" id="createCheckCode"> 
  	<a href="#" onclick="myReload();">&nbsp;看不清？换一个</a>
  	<input type="button" value="确认" onclick="">
  	<script type="text/javascript">
  	function myReload(){
  		document.getElementById("createCheckCode").src=
  		document.getElementById("createCheckCode").src+"?+nocache="+new Date().getTime();
  	}
  	</script>
  </body>
</html>
