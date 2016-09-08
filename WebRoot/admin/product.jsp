<%@ page language="java"  pageEncoding="gbk"%>
<%@page import="ata.wx.shopping.factory.DAOFactory"%>
<%@page import="ata.wx.shopping.vo.Product"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style type="text/css">
  table {
	font-size: 12px;
	background-color: #4D4D4D;
	
	border: 1px solid #000;
}
</style>
  </head>
  
  <body>
  <%
   String pid=(String)request.getSession().getAttribute("pid");
    Product product=DAOFactory.getProductDAOInstance().selectById(pid);
   %>
    <form  action="/atashopping1.2/servlet/AdminServlet?actionType=3411" method="post" >
  <table width="469" height="287" border="1" align="center" cellpadding="1" cellspacing="0">
  <tr ><td colspan="2"><center><font color="#ffffff" size="4">修改商品信息</font></center></td></tr>
    <tr>
      <td width="227" height="204"><table width="200" height="200" border="0" cellpadding="1" cellspacing="0">
        <tr>
          <td><img src="<%=product.getImgpath() %>"></td>
        </tr>
      </table></td>
      <td width="498"><p><font color="#ffffff"> 
        产品名称：</font> 
            <input type="text" name="pname"  value="<%=product.getPname() %>" />
      </p>
      <p><font color="#ffffff"> 
        产品数量：</font> 
          <input type="text" name="pcount" value="<%=product.getPcount() %>"/>
</p>
      <p><font color="#ffffff"> 
        产品价格： 
          </font><input type="text" name="price" value="<%=product.getPrice() %>"/>
      </p></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2"><div align="center">
        <input type="submit" name="update" value="修改" />
        　　　　　　　　
        <input type="reset" name="reset" value="重置" />
      </div></td>
    </tr>
    
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
</form>
  </body>
</html>
