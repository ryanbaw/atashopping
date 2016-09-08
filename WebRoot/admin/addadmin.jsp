<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <style type="text/css">
  table {
	font-size: 12px;
	background-color: #4D4D4D;
	
	border: 1px solid #000;
}
</style>

  </head>
  
  <body><form action="/atashopping1.2/servlet/AdminServlet?actionType=211" method="post">
  <table width="300" border="1">
<tbody><tr>
<td colspan="2"><center><font color="#ffffff" size="4">增加管理员</font></center></td>
</tr>
<tr>
<td align="right"><font color="#ffffff">用户名：</font></td>
<td>&nbsp;<input type="text" name="usernam"></td></tr>
<tr>
<td align="right">&nbsp;<font color="#ffffff">密码：</font></td>
<td>&nbsp;<input type="password" name="password"></td></tr>
<tr>
<td align="right">&nbsp;<font color="#ffffff">确认密码：</font></td>
<td>&nbsp;<input type="password" name="repassword"></td></tr>

<tr>
      <td colspan="2"><div align="center">
        <input type="submit" name="update" value="确定" />
        　　　　　　　　
        <input type="reset" name="reset" value="重置" />
      </div></td>
    </tr>

</tbody></table></form>
    
  </body>
</html>
