<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="ata.wx.shopping.vo.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title>ATA商城后台管理</title>
<head>
	


</head>
  
  <body>
  <center>
  <jsp:include page="ui.html"></jsp:include>
  </center>
  <hr/>
  <%
  //System.out.print(request.getSession().getAttribute("chooseType")); 
    if(request.getSession().getAttribute("chooseType")==null){}
    else{
    int chooseType=(Integer)request.getSession().getAttribute("chooseType");
    switch(chooseType){
     case 21:
       %>
       <center>
     
           <jsp:include page="addadmin.jsp"></jsp:include>
     </center>
    <% 
     break;
    
    case 22:
       %>
       <center>
     
           <jsp:include page="deleteuser.jsp"></jsp:include>
     </center>
    <% 
     break;
     
    case 23:
    %> 
       <center>
     
           <jsp:include page="selectalluser.jsp"></jsp:include>
     </center>
    <% 
    break;
    
    case 31:
    %> 
       <center>
     
           <jsp:include page="addproduct.jsp"></jsp:include>
     </center>
    <% 
    break;
    
    case 32:
    %> 
       <center>
     
           <jsp:include page="deleteproduct.jsp"></jsp:include>
     </center>
    <% 
    break;
    
     case 33:
    %> 
       <center>
     
           <jsp:include page="selectproduct.jsp"></jsp:include>
     </center>
    <% 
    break;
    
      case 34:
Admin admin=(Admin)request.getSession().getAttribute("admin");
if(admin==null){
 System.out.print("kong");
}

    %> 
       <center>
     
           <jsp:include page="updateproduct.jsp"></jsp:include>
     </center>
    <% 
    break;
    
     case 341:
    %> 
       <center>
     
           <jsp:include page="product.jsp"></jsp:include>
     </center>
    <% 
    break;
    
      case 41:
    %> 
       <center>
     
           <jsp:include page="selectallaccout.jsp"></jsp:include>
     </center>
    <% 
    break;
    
      case 42:
    %> 
       <center>
     
           <jsp:include page="selectmoneylog.jsp"></jsp:include>
     </center>
    <% 
    break;
    
       case 51:
    %> 
       <center>
     
           <jsp:include page="selectuserform.jsp"></jsp:include>
     </center>
    <% 
    break;
    
        default:
    %> 
       
     
           <jsp:include page="bgc.html"></jsp:include>
     
    <% 
    break;
    
    }
    
    
    
    
    }
    
    
     %>
     
   
  
  
  

</body>