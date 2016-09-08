<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="ata.wx.shopping.factory.DAOFactory"%>
<%@page import="ata.wx.shopping.vo.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<script src="js/jquery-1[1].2.2.js" type="text/javascript"></script>

		<script>
  $(document).ready(function(){
    $("#example").tablesorter({sortList:[[0,0],[2,1]], widgets: ['zebra']});
  });
  </script>

	</head>
  
  <body>
    <link rel="stylesheet" href="http://dev.jquery.com/view/trunk/themes/flora/flora.all.css" type="text/css" media="screen" title="Flora (Default)">
<script  src="http://dev.jquery.com/view/trunk/plugins/tablesorter/2.0/jquery.tablesorter.js"></script>

	<table id="example" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
		<thead>
			<tr>
				<th>用户名</th>
				<th>密码</th>

				<th>Email</th>
				<th>电话</th>
				<th>地址</th>
				<th>性别</th>
				<th>年龄</th>
				<th>注册时间</th>
			</tr>
		</thead>
		<tbody>
		<%
		List<User> userList =DAOFactory.getUserDAOInstance().selectAll();
		for(int i=0;i<userList.size();i++){
		
		 %>

			<tr>
				<td><%=userList.get(i).getUsername() %></td>
				<td><%=userList.get(i).getPassword() %></td>
				<td><%=userList.get(i).getEmail() %></td>
				<td><%=userList.get(i).getTel() %></td>
				<td><%=userList.get(i).getSex() %></td>
				<td><%=userList.get(i).getAge() %></td>
				<td><%=userList.get(i).getRegtime() %></td>
				<td><%=userList.get(i).getAddress() %></td>

			</tr>
			<% }%>
			
		</tbody>
	</table>
</body>
 
</html>
