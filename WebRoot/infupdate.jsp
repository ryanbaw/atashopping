<%@ page language="java" import="java.util.*,ata.wx.shopping.vo.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户信息修改</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
<!--
.STYLE1 {
	font-size: 12px
}

.STYLE5 {
	font-family: "宋体";
	font-size: 12px;
}

.STYLE8 {
	color: #FF0000
}

.STYLE9 {
	font-size: 16px
}

.STYLE10 {
	font-size: 16px;
	color: #333333;
}

#Layer1 {
	position: absolute;
	left: 305px;
	top: 5px;
	width: 59px;
	height: 39px;
	z-index: 1;
}
-->
</style>

<script language="javascript">
var points = Array("0","0","0","0","0" );
//检查所有;
function checkall(){
	checkadd();
	var i=0;
	while (i<=5){
	if(points[i]=="0"){
	alert("你的用户信息不正确,请检查!");
//	alert(points);
	i=10;
	return false;
	}else{
	i++; }
	}
}

//检查登入密码;
function checkpassword(){
	var pwd = document.getElementById("password").value;

	if (pwd.length<6||pwd.length>16){
		pwd_info.innerHTML = "<font color=\"red\">密码格式不正确</font>";
		points[0]="0";
		return false;
    }
	else{
	    document.getElementById("pwd_info").innerHTML = "";
		points[0]="1";
		return true;
	}
}
//检查新密码;
function checknewpassword(){
	var pwd = document.getElementById("newpassword").value;

	if (pwd.length<6||pwd.length>16){
		newpwd_info.innerHTML = "<font color=\"red\">密码格式不正确</font>";
		points[1]="0";
		return false;
    }
	else{
	    document.getElementById("newpwd_info").innerHTML = "";
		points[1]="1";
		return true;
	}
}
//检查密码是否一致;
function checkcpassword(){
	var pwd2 = document.getElementById("cqpassword").value;
	if (pwd2==document.getElementById("newpassword").value){
		document.getElementById("pwdrepeat_info").innerHTML = "";
		points[2]="1";
		return true;
	} else{
		document.getElementById("pwdrepeat_info").innerHTML = "<font color=\"red\">两次输入的密码不一致，请检查后重试。</font>";
		points[2]="0";
		return false;
	}
}

//检查电话;
function checktelphone(){
	var tel=document.form1.telphone.value;
	var num1=/(^13[013456789]\d{8}$)/;
	if(num1.test(tel)){
		if(tel.length!=11){
			alert("您输入的手机号码有误!!");
			document.getElementById("tel_info").innerHTML = "<font color=\"red\">您输入的手机号码有误,请重输</font>"
			points[3]="0";
			return false;
		}else{
		document.getElementById("tel_info").innerHTML = "";
		points[3]="1";
		return true;
		}
	}else{
		document.getElementById("tel_info").innerHTML = "<font color=\"red\">您输入的手机号码有误,请重输</font>"
		points[3]="0";
		return false;
	}
}

//检查年龄;
function checkyear(){
	var year=/^\d{2}/
	var yeara=document.getElementById("year").value;
	if(year.test(yeara)){
		points[3]="1";
		year_info.innerHTML=""
		return true;
	}else{
	year_info.innerHTML="<font color=\"red\">年龄为2位数</font>"
	points[3]="0";
	return false;
	}
}



//检查地址;
function checkadd(){
	if(document.form1.address.value==""){
		address_info.innerHTML="<font color=\"red\">地址为能为空,请确认</font>";
		points[4]="0";
		return false;
	}else{
	address_info.innerHTML="";
	points[4]="1";
	return true;
	}
}

</script>

</head>

<body bgcolor="#FF9966" leftmargin="0" topmargin="0" marginwidth="0"
		marginheight="0">
	<%
		User user=new User();
		user=(User)request.getSession().getAttribute("loginusername");
		if(user==null){
			response.sendRedirect("index.jsp");
		}
	%>
<table width="637" height="647" border="0" align="center"
			cellpadding="1" cellspacing="0">
			<tr>
				<td align="center" valign="top">
<table width="634" height="46" border="0" align="center" cellpadding="1">
						<tr>
							<td width="542" class="STYLE5">
								<jsp:include page="ui.html"></jsp:include>
						  </td>
					  </tr>
				  </table>
					<form id="form1" name="form1" method="post" onSubmit="return checkall();"
						action="servlet/ContrlServlet?valuetype=8">
						<table width="95%" height="144" border="1" cellpadding="1"
							cellspacing="0" bordercolor="#CCCCCC">
							<tr>
								<td width="28%" height="27" class="STYLE1">
									<div align="right">
										<span class="STYLE8">*</span>旧密码：									</div>								</td>
								<td width="33%">
									<div align="center">
										<input type="password" name="password"
											onBlur="checkpassword()" />
										<div id="pwd_info"></div>
									</div>								</td>
								<td width="39%" bgcolor="#FABB90" class="STYLE1">
									<span class="desc STYLE5"><span class="desc STYLE6">·</span>密码长度6～16位，字母区分大小写</span>								</td>
							</tr>
							<tr>
								<td height="20" class="STYLE1">
									<div align="right">
										<span class="STYLE8">*</span>新密码：									</div>								</td>
								<td>
									<div align="center">
										<input type="password" name="newpassword"
											onBlur="checknewpassword()" />
										<div id="newpwd_info"></div>
									</div>								</td>
								<td bgcolor="#FABB90" class="STYLE1">
									<span class="desc STYLE5"><span class="desc STYLE6">·</span>密码长度6～16位，字母区分大小写</span>								</td>
							</tr>
							<tr>
								<td height="35" class="STYLE1">
									<div align="right">
										<span class="STYLE8">*</span>再输入一遍新密码：									</div>								</td>
								<td>
									<div align="center">
										<input type="password" name="cqpassword"
											onBlur="checkcpassword()" />
										<div id="pwdrepeat_info"></div>
									</div>								</td>
								<td bgcolor="#FABB90" class="STYLE1">
									<span class="desc STYLE6 STYLE7"><span
										class="desc STYLE6">·</span>答案长度6～30位，字母区分大小写，一个汉字占两位。用于修复帐号密码</span>								</td>
							</tr>
							<tr>
								<td height="20" class="STYLE1">
									<div align="right">
										<span class="STYLE8">*</span>年龄：									</div>								</td>
								<td>
									<div align="center">
										<input type="text" name="year"
											onBlur="checkyear()"  />
										<div id="year_info"></div>
									</div>								</td>
								<td class="STYLE1">&nbsp;							  </td>
							</tr>
							<tr>
								<td height="20" class="STYLE1">
									<div align="right">
										<span class="STYLE8">*</span>电话：									</div>								</td>
								<td>
									<div align="center">
										<input type="text" name="telphone" onBlur="checktelphone()" />
										<div id="tel_info"></div>
									</div>								</td>
								<td bgcolor="#FABB90" class="STYLE1">
									<span class="desc STYLE6">·</span><span class="STYLE5">联系电话可以是移动手机注册或者小灵通</span>								</td>
							</tr>
							<tr>
								<td height="20" class="STYLE1">
									<div align="right">
										<span class="STYLE8">*</span>地址：									</div>								</td>
								<td>
									<div align="center">
										<input type="text" name="address"  />
										<div id="address_info"></div>
									</div>								</td>
								<td bgcolor="#FABB90" class="STYLE1">
									<span class="desc STYLE6">·</span><span class="STYLE5">填写详细的家庭住址</span>								</td>
							</tr>
						</table>
						<p>
							<input type="submit" name="Submit" value="修  改">

							<input type="reset" name="Submit2" value="重 置">
						</p>
					</form>
				</td>
			</tr>
</table>
		<!-- End ImageReady Slices -->
</body>
</html>
