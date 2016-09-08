<%@ page language="java" import="ata.wx.shopping.vo.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>注册新用户</title>
		<style type="text/css">
<!--
.STYLE2 {
	color: #F18650;
	font-size: 16px;
	font-weight: bold;
}

.STYLE3 {
	font-size: 12px
}

.STYLE8 {
	color: #FF0000
}

.STYLE5 {
	font-family: "宋体";
	font-size: 12px;
}
-->
</style>

		<script src="setday.js"></script>

		<script language="javascript">
var points = Array("0","0","0","0","0","0","0","0");
//检查所有;
function checkall(){
	checkemail();
	checkBox();
	if(checkyear()){
		var i=0;
		while (i<=7){
		if(points[i]=="0"){
			alert("你的用户信息不正确,请检查1!");
//			alert(points);
			i=10;
			return false;
		}else{i++;}
		};
	}else{
		return false;
	}
}
//检查用户名;
function checkusername(){
	var msg=new Array(
	"<font color=\"red\" class=\"STYLE1\" >用户名不能为空</font>",
	"<font color=\"red\" class=\"STYLE1\" >用户名长度不正确</font>",
	"" );
	var username = 	document.getElementById("regbankusername").value;
	if (username == "") {
	    usermessage(0);
		points[0]="0";
		return false;
	}
	if(username.length<4||username.length>18){
	    usermessage(1);
		points[0]="0";
	    return false;
	}else{
	usermessage(2);
	points[0]="1";
	return true;
	}
	function usermessage(id){
		check_info.innerHTML = msg[id];	
	}
}
//检查登入密码;
function checkpassword(){
	var pwd = document.getElementById("regbankpassword").value;

	if (pwd.length<6||pwd.length>16){
		pwd_info.innerHTML = "<font color=\"red\">密码格式不正确</font>";
		points[1]="0";
		return false;
    }
	else{
	    document.getElementById("pwd_info").innerHTML = "";
		points[1]="1";
		return true;
	}
}
//检查密码是否一致;
function checkcpassword(){
	var pwd2 = document.getElementById("cpassword").value;
	if (pwd2==document.getElementById("regbankpassword").value){
		document.getElementById("pwdrepeat_info").innerHTML = "";
		points[2]="1";
		return true;
	} else{
		document.getElementById("pwdrepeat_info").innerHTML = "<font color=\"red\">两次输入的密码不一致，请检查后重试。</font>";
		points[2]="0";
		return false;
	}
}


</script>
	</head>

	<body bgcolor="#FF9966">
	<%
		User user=new User();
		user=(User)request.getSession().getAttribute("loginusername");
		if(user==null){
			response.sendRedirect("index.jsp");
		}
  	%>
		<table width="71%" height="295" border="0" align="center"
			cellpadding="1" cellspacing="0">
			<tr>
				<td></td>
			</tr>
			<tr>
				<td align="center" bgcolor="#ffce99">
					<div id="content">
						<div id="container">
							<div class="topArc">
								<span class="left"><span class="right"></span>
								</span>
							</div>
							<p class="declare">
								请注意：带有
								<span class="STYLE3"><span class="STYLE8">*</span>
								</span>的项目必须填写。
							</p>
							<form action="servlet/ContrlServlet?valuetype=11" method="post" onSubmit="return checkall(this);" name="form" id="form"
								autocomplete="off">
								<fieldset>
									<div align="left">
										<legend>
											<span class="STYLE2"> 请选择您的用户名</span>
										</legend>
									</div>
									<table width="663" class="blur">
										<tbody>
											<tr>
												<th width="144" valign="top">
													<label for="username">
														<div align="right">
															<i><br />
															</i><span class="STYLE3"><span class="STYLE8">*</span>虚拟银行帐户：</span>
														</div>
													</label>
												</th>
												<td width="233" class="input">
													<input class="text" type="text" id="regbankusername"
														name="regbankusername" onblur="checkusername()" />
													<div id="check_info">
													</div>
													<br />
												</td>
												<td width="270" bgcolor="#ffce99" class="desc "
													chgmodeblur="chgModeBlur" borderColor="#FFFFFF">
													<font size="2">&middot;由字母a～z(不区分大小写)、数字0～9、点、减号或下划线组成<br />
														&middot;只能以数字或字母开头和结尾<br /> &middot;用户名长度为4～18个字符</font>
												</td>
											</tr>
										</tbody>
									</table>
								</fieldset>
								<fieldset>
									<div align="left"></div>
									<div align="left">
										<legend>
											<span class="STYLE2"> 请填写安全设置</span><span>(&nbsp;以下信息对保护您的帐号安全极为重要，请您慎重填写并牢记&nbsp;)</span>
										</legend>
									</div>
									<table width="666" class="blur">
										<tbody>
											<tr>
												<th width="146" class="STYLE3">
													<label for="password">
														<div align="right">
															<span class="STYLE8">*</span><span class="STYLE5">
																登录密码：</span>
														</div>
													</label>
												</th>
												<td width="235" class="input">
													<input class="text" type="password" name="regbankpassword"
														onblur="checkpassword()" />
													<div id="pwd_info"></div>
													<span></span>
												</td>
												<td width="269" rowspan="2" bgcolor="#FFCC99" class="desc">
													<font size="2">密码长度6～16位，字母区分大小写</font>
												</td>
											</tr>
											<tr>
												<th class="STYLE3">
													<label for="cpassword">
														<div align="right">
															<span class="STYLE8">*</span>再次确认密码：
														</div>
													</label>
												</th>
												<td class="input">
													<input class="text" id="cpassword" type="password"
														name="cpassword" onblur="checkcpassword()"/>
													<div id="pwdrepeat_info"></div>
													<span></span>
												</td>
											</tr>
										</tbody>
									</table>
									
									
									<div class="hr"></div>
									<table width="666" class="blur">
										<tbody>
											<tr>
												<th width="148" valign="top">
													<label for="mail">
														<div align="right">
															<span class="STYLE3"><span class="STYLE8">*</span>账户初始金额</span>：
														</div>
													</label>
												</th>
												<td width="238" valign="top" class="input">
													<input class="text" id="regeRMB" name="regeRMB"
														 />
													<div id="RMB_info"></div>
													<span></span>
												</td>
												<td width="264" bgcolor="#FFCC99" class="desc">
													<font size="2">&middot;初始账户余额（单位：RMB）</font>
												</td>
											</tr>
										</tbody>
									</table>
									<div class="hr"></div>
									<table class="blur">
										<tbody>
											<tr>
												<th>
													<label for="usercheckcode"></label>
												</th>
												<td class="input">
													&nbsp;
												</td>
												<td></td>
											</tr>
											<tr>
												<th>
													<span class="STYLE8">*</span>
												</th>
												<td bgcolor="#FFCE99">
													<input id="agree" title="是否同意服务条款" type="checkbox"
														checked="checked" name="agree" onclick="checkBox()" />
													我已看过并同意《
													<a href="#">ATA服务条款</a>》
													<br />
													<font size="2"><span></span>
													</font>
												</td>
											</tr>
											<tr></tr>
										</tbody>
									</table>
								</fieldset>
								<div id="btn">
									<div align="center">
										<input name="submit" type="submit" id="confirm"
											 value="注册帐号" />
										<span></span>
									</div>
								</div>
							</form>
							<div class="bottomArc">
								<span class="left"><span class="right"></span>
								</span>
							</div>
						</div>
						<div id="footer">
							<br />
							&nbsp;1997-2008&nbsp;ATA培训基地
						</div>
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>
