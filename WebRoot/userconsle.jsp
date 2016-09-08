<%@ page language="java" import="java.util.*,ata.wx.shopping.vo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户控制面板</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    <style type="text/css">
<!--
.STYLE1 {
	font-family: "宋体";
	font-size: 12px;
}
-->
    </style>
</head>
  
  <body>
  	<%
		User user=new User();
		
		user=(User)request.getSession().getAttribute("loginusername");
		if(user==null){
			response.sendRedirect("index.jsp");
		}
	%>
    <table width="700" border="0" align="center">
      <tr align="left" valign="top">
        <td><div><span class="STYLE1">
          <jsp:include page="ui.html"></jsp:include>
        </span></td>
      </tr>
  </table>
    <br>
  </body>
</html>
