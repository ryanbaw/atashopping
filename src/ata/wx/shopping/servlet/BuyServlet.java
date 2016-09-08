package ata.wx.shopping.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ata.wx.shopping.busbean.UserFormOBean;
import ata.wx.shopping.factory.DAOFactory;
import ata.wx.shopping.vo.Product;
import ata.wx.shopping.vo.User;

public class BuyServlet extends HttpServlet {

	List<String> pList=new ArrayList<String>();
	public BuyServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid=request.getParameter("pid");
		// String option=request.getParameter("option");
		if("buy".equals(request.getParameter("option"))){
			String[] pList2=request.getParameterValues("pids");
			if(pList2==null){
				response.sendRedirect(request.getContextPath()+"/buyfail.jsp");
				return;
			}
			List<Product> pList3=new ArrayList<Product>();
			for(int i=0;i<pList2.length;i++){
				try {
					Product product=DAOFactory.getProductDAOInstance().selectById(pList2[i]);
					pList3.add(product);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			User user=(User)request.getSession().getAttribute("loginusername");
			UserFormOBean.buyProcess(user.getUsername(), pList3);
			request.getSession().removeAttribute("pList");
			response.sendRedirect(request.getContextPath()+"/buyok.jsp");
		}else{
			if(pid!=null){
				pList.add(pid);
				request.getSession().setAttribute("pList", pList);
				response.sendRedirect(request.getContextPath()+"/shopcart.jsp");	 
				return;
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
