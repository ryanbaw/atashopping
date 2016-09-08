<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="ata.wx.shopping.vo.*" %>
<%@page import="ata.wx.shopping.factory.DAOFactory"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <style type="text/css">@import "../css/default.css";</style>
	<style type="text/css">@import "../css/jquery.tablesorter.pager.css";</style>
	<script type="text/javascript" src="../js/jquery-latest.js"></script>
	
	
	<script type="text/javascript" src="../js/jquery.tablesorter.js"></script>
	<script type="text/javascript" src="../js/jquery.tablesorter.pager.js"></script>
	<script type="text/javascript">
	$(function() {
		$("table")
			.tablesorter({widthFixed: true})
			.tablesorterPager({container: $("#pager")});
	});
	</script>

  </head>
  
  <body>
   <table cellspacing="0" id="large">
   <thead>
					<tr>
						<th>用户名</th>
						<th>Email</th>
						<th>电话</th>
						<th>地址</th>
						<th>性别</th>
						<th>年龄</th>
						<th>注册时间</th>
						
					</tr>
	</thead>
	<tfoot>
	<tr>
						<th>用户名</th>
						<th>Email</th>
						<th>电话</th>
						<th>地址</th>
						<th>性别</th>
						<th>年龄</th>
						<th>注册时间</th>
						
					</tr>
	</tfoot>
	<tbody>
	<%
	 List<User>userList=DAOFactory.getUserDAOInstance().selectAll();
	 for(int i=0;i<userList.size();i++){
	     User user=userList.get(i);
	 %>				
					
					<tr>
				<td><%=user.getUsername() %></td>
				<td><%=user.getEmail() %></td>
				<td><%=user.getTel() %></td>
				<td><%=user.getAddress() %></td>
				<td><%=user.getSex() %></td>
				<td><%=user.getAge() %></td>
				<td><%=user.getRegtime() %></td>
				

			</tr>
			<% }%>
				
				</tbody>
			</table>
			

<br/>
<div id="pager" class="pager">
	<form>
		<img src="../img/first.png" class="first"/>
		<img src="../img/prev.png" class="prev"/>
		<input type="text" class="pagedisplay"/>
		<img src="../img/next.png" class="next"/>
		<img src="../img/last.png" class="last"/>
		<select class="pagesize">
			<option selected="selected"  value="5">5</option>
			<option value="10">10</option>
			<option value="15">15</option>
			<option value="20">20</option>
			<option value="30">30</option>
			<option  value="40">40</option>
		</select>
	</form>
</div>
   
  </body>
</html>
