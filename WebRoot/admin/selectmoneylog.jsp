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
						<th>充值单号</th>
						<th>用户名</th>
						<th>充值金额</th>
						<th>充值时间</th>
						
					</tr>
	</thead>
	<tfoot>
	<tr>
						<th>充值单号</th>
						<th>用户名</th>
						<th>充值金额</th>
						<th>充值时间</th>
						
					</tr>
	</tfoot>
	<tbody>
	<%
	 List<MoneyLog> logList=DAOFactory.getMoneyLogDAOInstance().selectAllLog();
	 for(int i=0;i<logList.size();i++){
	     MoneyLog moneyLog=logList.get(i);
	 %>				
					
					<tr>
				<td><%=moneyLog.getLogid() %></td>
				<td><%=moneyLog.getUsername() %></td>
				<td><%=moneyLog.getMoney() %></td>
				<td><%=moneyLog.getTime() %></td>
				
				

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
