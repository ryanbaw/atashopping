<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
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

		<script src="js/setday.js"></script>

		<script language="javascript">
			var points = Array("0","0","0","0","0","0","0","0");
			//检查所有;
			function checkall() {
				checkemail();
				// checkBox();
				checkpassword();
				checkcpassword();
				if(checkyear()) {
					var i=0;
					while (i<8) {
						if (points[i]=="0") {
							alert("你的用户信息不正确,请检查1!");
							alert(points);
							i=10;
							return false;
						} else {
							i++;
							if (i==8) {
								return true;
							}
						}
					};
				} else {
					return false;
				}
			}
			//检查用户名;
			function checkusername() {
				var msg=new Array(
				"<font color=\"red\" class=\"STYLE1\" >用户名不能为空</font>",
				"<font color=\"red\" class=\"STYLE1\" >用户名长度不正确</font>",
				"" );
				var username = 	document.getElementById("regusername").value;
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
				var pwd = document.getElementById("regpassword").value;

				if (pwd.length<6||pwd.length>16){
					pwd_info.innerHTML = "<font color=\"red\">密码格式不正确</font>";
					points[1]="0";
					// alert(points[1]);
					return false;
				} else {
					document.getElementById("pwd_info").innerHTML = "";
					points[1]="1";
					return true;
				}
			}
			//检查密码是否一致;
			function checkcpassword(){
				var pwd2 = document.getElementById("cpassword").value;
				if (pwd2==document.getElementById("regpassword").value) {
					document.getElementById("pwdrepeat_info").innerHTML = "";
					points[2]="1";
					return true;
				} else {
					document.getElementById("pwdrepeat_info").innerHTML = "<font color=\"red\">两次输入的密码不一致，请检查后重试。</font>";
					points[2]="0";
					// alert(points[2]);
					return false;
				}
			}
			//检查年龄;
			function checkyear(){
				var year=/^\d{4}/
				var yeara=document.getElementById("regage").value;
				if(year.test(yeara)){
			//		if((parseFloat(yeara)>1910)&&(parseFloat(yeara)<2007)){
						points[3]="1";
						return true;
			//		}else{ 
			//		alert("你的用户信息不正确,请检查!");
			//		points[3]="0";
			//		return false;
			//		}
				}else{
				alert("你的用户信息不正确,请检查!");
				points[3]="0";
				return false;
				}
			}
			function clearyear(){
				document.form1.year.value="";
			}
			//检查电话;
			function checktelphone(){
				var tel=document.getElementById("regtel").value;
				var num1=/(^13[013456789]\d{8}$)/;
				if (num1.test(tel)) {
					if(tel.length!=11){
						alert("您输入的手机号码有误!!");
						document.getElementById("tel_info").innerHTML = "<font color=\"red\">您输入的手机号码有误,请重输</font>"
						points[4]="0";
						return false;
					}else{
					document.getElementById("tel_info").innerHTML = "";
					points[4]="1";
					return true;
					}
				} else {
					document.getElementById("tel_info").innerHTML = "<font color=\"red\">您输入的手机号码有误,请重输</font>"
					points[4]="0";
					return false;
				}
			}
			//检查Email
			function checkemail() {
				var email=document.getElementById("regemail").value;
				var reg=new RegExp("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$");
				if(reg.test(email)) {
					document.getElementById("email_info").innerHTML = "";
					points[5]="1";
				} else {
					document.getElementById("email_info").innerHTML = "E-mail地址无效";
					points[5]="0";
				}
			}
			//检查地址;
			function checkadd() {
				if (document.getElementById("regaddr").value=="") {
					address_info.innerHTML="地址为能为空";
					points[6]="0";
				} else {
					address_info.innerHTML="";
					points[6]="1";
				}
			}
			//检查协议;
			function checkBox(){
				if (document.getElementById("agree").checked){
					points[7]="1";
				} else {
					points[7]="0";
					return;
				}
			}
		</script>
	</head>

	<body bgcolor="#FF9966">
		<table width="71%" height="295" border="0" align="center" cellpadding="1" cellspacing="0">
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
							<form action="servlet/ContrlServlet?valuetype=2" method="post" onSubmit="return checkall(this);" name="form" id="form"
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
															</i><span class="STYLE3"><span class="STYLE8">*</span>通行证用户名：</span>
														</div>
													</label>
												</th>
												<td width="233" class="input">
													<input class="text" type="text" id="regusername"
														name="regusername" onblur="checkusername()" />
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
															<span class="STYLE8">*</span>
															<span class="STYLE5">登录密码：</span>
														</div>
													</label>
												</th>
												<td width="235" class="input">
													<input class="text" type="password" name="regpassword"
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
															<span class="STYLE8">*</span>重复登录密码：
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
									<table class="blur">
										<tbody>
											<tr>
												<th width="153" class="STYLE3">
													<label for="question">
														<div align="right">
															姓名：
														</div>
													</label>
												</th>
												<td width="232" class="input">
													<input name="regname" type="text" class="text" />
													<span></span>
												</td>
												<td width="269" rowspan="2" bgcolor="#FFCC99" class="desc">
													<font size="2">答案长度6～30位，字母区分大小写，一个汉字占两位。用于修复帐号密码</font>
												</td>
											</tr>
											<tr>
												<th class="STYLE3">
													<label for="answer">
														<div align="right">
															<span class="STYLE8">*</span>出生日期：
														</div>
													</label>
												</th>
												<td width="232" class="input">
													<INPUT id="regage" onclick="setday(this)" name="regage" runat="server" />
													<span></span>
												</td>
												<span></span>
												<td width="2"></td>
											</tr>
										</tbody>
									</table>
									<div class="hr"></div>
									<table width="670" bgcolor="#ffce99" class="blur">
										<tbody>
											<tr>
												<th width="150" class="STYLE3">
													<label>
														<div align="right">
															<span class="STYLE8">*</span>性别：
														</div>
													</label>
												</th>
												<td width="234" class="input">
													<label for="year"></label>
													<label for="month"></label>
													<label for="day">
														<input id="regsex" title="性别" type="radio"
															checked="checked" value="男" name="regsex" />
														男 &nbsp;&nbsp;&nbsp;&nbsp;
														<input id="regsex" type="radio" value="女" name="regsex" />
														女
													</label>
												</td>
												<td width="270" bgcolor="#FFCC99" class="desc"></td>
											</tr>
											<tr>
												<th class="STYLE3">
													<label>
														<div align="right">
															<span class="STYLE8">*</span>手机电话：
														</div>
													</label>
												</th>
												<td class="input" bgcolor="#ffce99">
													<LABEL id=female>
														<input name="regtel" id="regtel" type="text" class="text"
															onblur="checktelphone()" />
														<div id="tel_info"></div>
													</LABEL>
												</td>
											</tr>
											<tr>
												<th>
													<label for="firstname" class="STYLE3">
														<div align="right">
															<span class="STYLE8">*</span>地址：
														</div>
													</label>
												</th>
												<td class="input">
													<input class="text" id="regaddr" name="regaddr"
														onblur="checkadd()" />
													<div id="address_info"></div>
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
															<span class="STYLE3"><span class="STYLE8">*</span>电子邮箱</span>：
														</div>
													</label>
												</th>
												<td width="238" valign="top" class="input">
													<input class="text" id="regemail" name="regemail"
														 />
													<div id="email_info"></div>
													<span></span>
												</td>
												<td width="264" bgcolor="#FFCC99" class="desc">
													<font size="2">&middot;填写、验证保密邮箱，通行证安全有保障</font>
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
										<a href="index.jsp">登录</a><span></span>
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
