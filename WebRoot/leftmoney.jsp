<%@ page language="java" import="ata.wx.shopping.vo.*" pageEncoding="utf-8"%>
<%@page import="ata.wx.shopping.factory.DAOFactory"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商城帐户剩余金额</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#FF9966">
	<%
		UserAccount useraccount = null;
		User user = (User)request.getSession().getAttribute("loginusername");
		if(user!=null){
			useraccount = DAOFactory.getUserAccountDAOInstance().selectUserAccount(user.getUsername()); 
			out.print("<font size='2' color='#0000ff'>商城帐户剩余金额:</font>"+String.valueOf(useraccount.getMoney()));
		}else{
			response.sendRedirect(request.getContextPath()+"/viewmfail.jsp");
		}
	%>
	<font size="2" color="#0000ff">
		<a href="index.jsp">返回首页</a>
		<a href="userconsle.jsp">返回用户控制面板</a>
	</font>
  </body>
</html>
