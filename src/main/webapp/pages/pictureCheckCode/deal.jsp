<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>deal.jsp</title>

  </head>
  <body>
  	<%
  		String checkCode=request.getParameter("checkCode");
  		if("".equals(checkCode)||checkCode==null){
  			out.println("<script>alert('请输入验证码！');window.location.href='checkCode.jsp';</script>");
  		}else{
  			if(!checkCode.equals(session.getAttribute("randCheckCode"))){
  				out.println("<script>alert('您输入的验证码不正确！');history.back(-1);</script>");
  			}
  		}
  	 %>
  </body>
</html>
