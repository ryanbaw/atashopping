<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'administrator.jsp' starting page</title>
    
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
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
.STYLE1 {font-size: 12px}
-->
</style>
  </head>
  
  <body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="100%" height="519" border="0" cellpadding="1" cellspacing="0">
  <tr>
    <td width="28%">&nbsp;</td>
    <td width="43%">&nbsp;</td>
    <td width="29%">&nbsp;</td>
  </tr>
  <tr>
    <td height="277">&nbsp;</td>
    <td><table width="413" height="266" border="0" cellpadding="1">
      <tr>
        <td background="images/login.jpg"><form action="servlet/AdminServlet?actionType=0" method="post">
          <table width="400" height="243" border="0" cellpadding="1">
            <tr>
              <td width="20%">&nbsp;</td>
              <td width="19%">&nbsp;</td>
              <td width="32%">&nbsp;</td>
              <td width="29%">&nbsp;</td>
            </tr>
            <tr>
              <td height="55">&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td><div align="right" class="STYLE1">管理员：</div></td>
              <td><div align="center">
                  <input name="username" type="text" class="STYLE1" id="username" size="15">
              </div></td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td><div align="right"><span class="STYLE1">密码</span>：</div></td>
              <td><div align="center">
                  <input name="password" type="password" class="STYLE1" id="password" size="15">
              </div></td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td height="49">&nbsp;</td>
              <td></td>
              <td colspan="2">　
                <input name="login" type="submit" class="STYLE1" value="登录">
                  <input name="reset" type="reset" class="STYLE1" value="取消"></td>
            </tr>
          </table>
                  </form>
          </td>
      </tr>
    </table></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
</body>
</html>
