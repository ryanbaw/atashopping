<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<style type="text/css">
@import "../css/default1.css";
</style>
		<script>
function yulan()
{
var fileext=document.form1.UpFile.value.substring(document.form1.UpFile.value.lastIndexOf("."),document.form1.UpFile.value.length)
         fileext=fileext.toLowerCase()
    
         if ((fileext!='.jpg')&&(fileext!='.gif')&&(fileext!='.jpeg')&&(fileext!='.png')&&(fileext!='.bmp'))
         {
             alert("对不起，系统仅支持标准格式的照片，请您调整格式后重新上传，谢谢 !");
              document.form1.UpFile.focus();
         }
         else
         {
         //alert(''+document.form1.UpFile.value)//把这里改成预览图片的语句
   document.getElementById("preview").innerHTML="<img src='"+document.form1.UpFile.value+"' width=120 style='border:6px double #ccc'>"
         }


}


</script>


	</head>

	<body>
		<form name="form1" action="/atashopping1.2/servlet/AdminServlet?actionType=311" method="post">
			<br />
			<br />

			<table width="351" height="190" border="1" align="center"
				cellpadding="1" cellspacing="0">
				<tr>
					<td height="31" colspan="2" background="../imag/header-bg1.png">
						<div align="center">
							增加商品
						</div>
					</td>
				</tr>
				<tr>
					<td>
						商品名称：
					</td>
					<td>
						<input type="text" name="pname" />
					</td>
				</tr>
				<tr>
					<td>
						商品单价：
					</td>
					<td>
						<input type="text" name="price" />
					</td>
				</tr>
				<tr>
					<td>
						商品数量：
					</td>
					<td>
						<input type="text" name="pcount" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div id="preview" ></div>
					</td>
				</tr>
				<tr>
					<td>
						商品图片：
					</td>
					<td>
						<input type="file" name="UpFile" onchange="yulan()" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<center>
							<input type="submit" name="Submit" value="增加" />
							<input type="reset" name="reset" value="重置" />
						</center>

					</td>
				</tr>
			</table>

			<br />
		</form>
	</body>
</html>
