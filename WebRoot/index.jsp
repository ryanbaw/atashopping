<%@ page language="java" import="ata.wx.shopping.vo.*,java.util.*" pageEncoding="utf-8"%>

<%@page import="ata.wx.shopping.factory.DAOFactory"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<base href="<%=basePath%>"/>
	
	<title>ATA网上购物商城 欢迎您的光临！</title>
	
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body bgcolor="#FF9966">
  
<table width="926" height="341" border="0" align="center" cellpadding="0" cellspacing="0" id="__01">
	<tr>
		<td rowspan="14"> 
			<img src="images/login_01.jpg" width="189" height="292" alt=""></td>
		<td rowspan="7">
			<img src="images/login_02.jpg" width="62" height="84" alt=""></td>
		<td rowspan="7">
			<img src="images/login_03.jpg" width="86" height="84" alt=""></td>
		<td rowspan="7">
			<img src="images/login_04.jpg" width="84" height="84" alt=""></td>
		<td rowspan="8">
			<img src="images/login_05.jpg" width="69" height="85" alt=""></td>
		<td rowspan="7">
			<img src="images/login_06.jpg" width="63" height="84" alt=""></td>
		<td colspan="13">
			<img src="images/login_07.jpg" width="372" height="26" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="1" height="26" alt=""></td>
	</tr>
	<tr>
		<td colspan="7" rowspan="2">
			<img src="images/login_08.jpg" width="211" height="19" alt=""></td>
		<td colspan="3">
			<img src="images/login_09.jpg" width="109" height="14" alt=""></td>
		<td colspan="3" rowspan="8">
			<img src="images/login_10.jpg" width="52" height="79" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="1" height="14" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="images/login_11.jpg" width="109" height="5" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="1" height="5" alt=""></td>
	</tr>
	<tr>
		<td colspan="6" rowspan="2">
			<img src="images/login_12.jpg" width="185" height="19" alt=""></td>
		<td colspan="3">
			<img src="images/login_13.jpg" width="107" height="13" alt=""></td>
		<td rowspan="6">
			<img src="images/login_14.jpg" width="28" height="60" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="1" height="13" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="images/login_15.jpg" width="107" height="6" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="1" height="6" alt=""></td>
	</tr>
	<tr>
		<td colspan="5" rowspan="4">
			<img src="images/login_16.jpg" width="155" height="41" alt=""></td>
		<td colspan="3">
			<img src="images/login_17.jpg" width="104" height="15" alt=""></td>
		<td rowspan="4">
			<img src="images/login_18.jpg" width="33" height="41" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="1" height="15" alt=""></td>
	</tr>
	<tr>
		<td colspan="3" rowspan="3">
			<img src="images/login_19.jpg" width="104" height="26" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="1" height="5" alt=""></td>
	</tr>
	<tr>
		<td colspan="3" rowspan="7">
			<img src="images/login_20.jpg" width="232" height="208" alt=""></td>
		<td rowspan="7">
			<img src="images/login_21.jpg" width="63" height="208" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="1" height="1" alt=""></td>
	</tr>
	<tr>
		<td rowspan="6">
			<img src="images/login_22.jpg" width="69" height="207" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="1" height="20" alt=""></td>
	</tr>
	<tr>
		<td colspan="4" rowspan="2">
			<img src="images/login_23.jpg" width="154" height="50" alt=""></td>
		<td colspan="8">
			<img src="images/login_24.jpg" width="193" height="27" alt=""></td>
		<td rowspan="5">
			<img src="images/login_25.jpg" width="25" height="187" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="1" height="27" alt=""></td>
	</tr>
	<tr>
		<td colspan="8">
			<img src="images/login_26.jpg" width="193" height="23" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="1" height="23" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="images/login_27.jpg" width="65" height="122" alt=""></td>
		<td colspan="8" rowspan="2">
			<img src="images/login_28.jpg" width="267" height="128" alt=""></td>
		<td rowspan="3">
			<img src="images/login_29.jpg" width="15" height="137" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="1" height="122" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="images/login_30.jpg" width="5" height="15" alt=""></td>
		<td rowspan="2">
			<img src="images/login_31.jpg" width="39" height="15" alt=""></td>
		<td rowspan="2">
			<img src="images/login_32.jpg" width="21" height="15" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="1" height="6" alt=""></td>
	</tr>
	<tr>
		<td colspan="8">
			<img src="images/login_33.jpg" width="267" height="9" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="1" height="9" alt=""></td>
	</tr>
	<tr>
		<td colspan="19" valign="bottom" background="images/login_34.jpg">
		<table width="923" height="35" border="0" cellspacing="0">
			<tr>
				<td width="255">&nbsp;</td>
				<td valign="bottom">
					<form action="servlet/ContrlServlet?valuetype=1" method="post">
					<%
						User user=new User();
						user=(User)request.getSession().getAttribute("loginusername");
						if(user==null){
							out.println("<font size='3'>用户：<input  size='20' height='15' type='text' name='loginusername'></font>");
							out.println("<font size='3'>密码：<input  size='20' height='15' type='password' name='loginpassword'></font>");
							out.print("<input type='submit' value='登录'>");
							out.print("<a href='register.jsp'>注册新用户</a>");
						}else{
							out.print("<font size='3'>欢迎您  :"+user.getUsername()+"</font>");
							out.print("&nbsp;&nbsp;");
							out.print("<font size='3'><a href='servlet/ContrlServlet?valuetype=7'>注销</a></font>");
							out.print("&nbsp;&nbsp;");
							out.print("<a href='userconsle.jsp'>个人控制面板</a>");
						}
					%>
					</form>
				</td>
			</tr>
		</table>
		</td>
		<td><img src="images/分隔符.gif" width="1" height="48" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="images/分隔符.gif" width="189" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="62" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="86" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="84" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="69" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="63" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="5" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="39" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="21" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="89" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="1" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="30" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="26" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="48" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="33" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="28" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="12" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="15" height="1" alt=""></td>
		<td>
			<img src="images/分隔符.gif" width="25" height="1" alt=""></td>
		<td></td>
	</tr>
</table>
<table width="925" height="1060" border="0" align="center" cellpadding="1" cellspacing="0">
  <tr>
	<td valign="top" background="images/b1.JPG"><table width="905" height="749" border="0" cellpadding="1" cellspacing="0">
	  <tr>
		<td width="589" height="309" align="right" valign="bottom"><table width="545" height="221" border="0" cellpadding="1" cellspacing="0">
			<tr>
			<%
				List<Product> pList=  DAOFactory.getProductDAOInstance().selectAll();
				List pList1 = (List)request.getSession().getAttribute("pList");
				request.getSession().setAttribute("pList",pList1);
			%>
			<td width="169" align="left" valign="top"><img src="<%=pList.get(0).getImgpath() %>" width="162" height="128">
			<center><%=pList.get(0).getPname() %></center>
			</br>
			<center><%=pList.get(0).getPrice() %>元
			<a href="servlet/BuyServlet?pid=<%=pList.get(0).getPid() %>"><font color="red" size="2" >加入购物车</font></a>
			</center>
			
			</td>
			<td width="169" align="left" valign="top"><img src="<%=pList.get(1).getImgpath() %>" width="162" height="128">
			<center><%=pList.get(1).getPname() %></center>
			</br>
			<center><%=pList.get(1).getPrice() %>元
			<a href="servlet/BuyServlet?pid=<%=pList.get(1).getPid() %>"><font color="red" size="2">加入购物车</font></a>
			</center>
			</td>
			
			<td width="172" align="left" valign="top"><img src="<%=pList.get(2).getImgpath() %>" width="162" height="128">
			<center><%=pList.get(2).getPname() %></center>
			</br>
			<center><%=pList.get(2).getPrice() %>元
			<a href="servlet/BuyServlet?pid=<%=pList.get(2).getPid() %>"><font color="red" size="2">加入购物车</font></a>
			</center>
			</td>
			<td width="27">&nbsp;</td>
		  </tr>
		</table></td>
		<td width="312" rowspan="2"><table width="312" height="698" border="0" cellpadding="1" cellspacing="0">
		  <tr>
			<td width="13" height="103">&nbsp;</td>
			<td width="283">&nbsp;</td>
			<td width="10">&nbsp;</td>
		  </tr>
		  <tr>
			<td height="577">&nbsp;</td>
			<td><table width="100%" height="590" border="0" cellpadding="1" cellspacing="0">
			  <tr>
				<td>&nbsp;</td>
				</tr>
			  <tr>
				<td>&nbsp;</td>
				</tr>
			  <tr>
				<td>&nbsp;</td>
				</tr>
			  <tr>
				<td>&nbsp;</td>
				</tr>
			  <tr>
				<td>&nbsp;</td>
				</tr>
			  <tr>
				<td>&nbsp;</td>
				</tr>
			</table></td>
			<td>&nbsp;</td>
		  </tr>
		  <tr>
			<td height="18">&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		  </tr>
		</table></td>
	  </tr>
	  <tr>
		<td height="390"><table width="579" height="353" border="0" cellpadding="1" cellspacing="0">
		  <tr>
			<td width="22" height="26">&nbsp;</td>
			<td colspan="3">&nbsp;</td>
			</tr>
		  <tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		  </tr>
		  <tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		  </tr>
		</table></td>
		</tr>
	  <tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	  </tr>
	</table></td>
  </tr>
</table>
<!-- End ImageReady Slices -->
	</body>
</html>
