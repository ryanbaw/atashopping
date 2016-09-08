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
	
	<script type="text/javascript" src="../js/jquery-latest.js"></script>
	<script type="text/javascript" src="../js/jquery.tablesorter.js"></script>
	<script type="text/javascript">
	
	$(function() {
		
		// add ie checkbox widget
		$.tablesorter.addWidget({
			id: "iecheckboxes",
			format: function(table) {
				if($.browser.msie) {
					if(!this.init) {
						$(":checkbox",table).change(function() { this.checkedState = this.checked});				
						this.init = true;
					}
					$(":checkbox",table).each(function() {
						$(this).attr("checked",this.checkedState);
					});
				}
			}
		});
		
		$("table").tablesorter({widgets: ['iecheckboxes']})
		
		
		
		
		
	});
		
	</script>
	</head>
  
 <body>
		<form action="/atashopping1.2/servlet/AdminServlet?actionType=221" method="post">
			<table id="large" cellspacing="0">

				<thead>
					<tr>
						<th>
							用户名
						</th>

						<th>
							Email
						</th>
						<th>
							电话
						</th>
						<th>
							地址
						</th>
						<th>
							性别
						</th>
						<th>
							年龄
						</th>
						<th>
							注册时间
						</th>
										<th>选中删除</th>
						
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>
							用户名
						</th>

						<th>
							Email
						</th>
						<th>
							电话
						</th>
						<th>
							地址
						</th>
						<th>
							性别
						</th>
						<th>
							年龄
						</th>
						<th>
							注册时间
						</th>
										<th>选中删除</th>
						

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
				<td>
							
								<input type="checkbox" value=<%= user.getUsername()%> name="username" />
							
						</td>

			</tr>
			<% }%>
				
				</tbody>
			</table>
			
			
			<input type="submit" value="删除"/>
			
	</form>
	</body>
</html>
