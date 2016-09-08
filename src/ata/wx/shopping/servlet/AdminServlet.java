package ata.wx.shopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ata.wx.shopping.util.*;
import ata.wx.shopping.busbean.UserOBean;
import ata.wx.shopping.dao.AdminDAO;
import ata.wx.shopping.factory.DAOFactory;
import ata.wx.shopping.vo.Admin;

@SuppressWarnings("serial")
public class AdminServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdminServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int actionType = Integer.parseInt(request.getParameter("actionType"));
		
		switch(actionType){
		case 0:
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			AdminDAO admindao = DAOFactory.getAdminDAOInstance();
			try {
				if(admindao.selectByNamePassword(username, password)){
					Admin admin = admindao.selectByName(username);
					
					HttpServletRequest req = (HttpServletRequest)request ;
					HttpSession session = req.getSession() ;
					
					session.setAttribute("admin", admin);
					request.getSession().setAttribute("chooseType", actionType);
					this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);
				}else{
					response.sendRedirect("/admin/fail.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 1:
			//this.getServletContext().getRequestDispatcher("atashopping1.2/index.jsp").forward(request, response);

			break;
		case 2 :
			request.getSession().setAttribute("chooseType", actionType);
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);
			break;
		case 21:
			request.getSession().setAttribute("chooseType", actionType);
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);
			break;
		case 211:
			String username1=request.getParameter("username");
			String password1=request.getParameter("password");
			String repassword1=request.getParameter("repassword");
			if(password1!=null&&repassword1!=null){
				if(password1.endsWith(repassword1)){
					try {
						DAOFactory.getAdminDAOInstance().insert(username1, password1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			request.getSession().setAttribute("chooseType", 23);
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);

			break;
		//删除用户	
		case 22:
			request.getSession().setAttribute("chooseType", actionType);
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);
			break;
		case 221:
			String[] usernameList=request.getParameterValues("username");
			for(int i=0;i<usernameList.length;i++)
			try {
//					DAOFactory.getUserDAOInstance().delete(usernameList[i]);
					UserOBean.deleteUserBean(usernameList[i]);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);

		case 23:
			request.getSession().setAttribute("chooseType", actionType);
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);
			break;
				
		case 3:
			request.getSession().setAttribute("chooseType", actionType);
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);
			break;
		case 31:
			request.getSession().setAttribute("chooseType", actionType);
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);
			break;
		case 311:
			String pid=GetIdTime.getPid();
			String pname=request.getParameter("pname");

			double price=Double.parseDouble(request.getParameter("price").trim());
			
			int pcount=Integer.parseInt(request.getParameter("pcount").trim());
			
			
			String picname=request.getParameter("UpFile");
			if(picname!=null){
			int p=picname.indexOf(java.io.File.separator);
			while (p>0){
				picname = picname.substring(p+1);
				p =picname.indexOf(java.io.File.separator);
				}
			}

            String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			String imgpath=basePath+"images/"+picname;			
//System.out.println(imgpath);
//http://localhost:8080/atashopping1.2/images/pic30a.jpg
			try {
					DAOFactory.getProductDAOInstance().insert(pid, pname, price, pcount, imgpath);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);

			
			break;
		case 32:
			request.getSession().setAttribute("chooseType", actionType);
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);
			break;
		case 321:
			String[] pList=request.getParameterValues("pid");
			for(int i=0;i<pList.length;i++){
				try {
					DAOFactory.getProductDAOInstance().deleteById(pList[i]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);

			
			break;
		case 33:
			request.getSession().setAttribute("chooseType", actionType);
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);
			break;
		case 34:
//Admin admin=(Admin)request.getSession().getAttribute("admin");
//if(admin==null){
//System.out.print("kong");
//}
			request.getSession().setAttribute("chooseType", actionType);
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);
			break;	
		case 341:
			request.getSession().setAttribute("chooseType", actionType);
			String pid1=request.getParameter("pid");
			request.getSession().setAttribute("pid", pid1);
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);
			break;
		case 3411:
			String pid2=(String)request.getSession().getAttribute("pid");
			String pname2=request.getParameter("pname");
			int pcount2=Integer.parseInt(request.getParameter("pcount"));
			double price2=Double.parseDouble(request.getParameter("price"));
			try {
					DAOFactory.getProductDAOInstance().update(pid2, pname2, price2, pcount2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getSession().setAttribute("chooseType", 34);
				this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);
			break;
		case 4:
			request.getSession().setAttribute("chooseType", actionType);
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);
			break;
		case 41:
			request.getSession().setAttribute("chooseType", actionType);
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);
			break;
		case 42:
			request.getSession().setAttribute("chooseType", actionType);
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);
			break;
		case 43:
			break;
		case 5:
			request.getSession().setAttribute("chooseType", actionType);
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);
			break;
		case 51:
			request.getSession().setAttribute("chooseType", actionType);
			this.getServletContext().getRequestDispatcher("/admin/manager.jsp").forward(request, response);
			break;
		case 6:
			request.getSession().removeAttribute("admin");
			request.getSession().removeAttribute("chooseType");
			response.sendRedirect(request.getContextPath()+"/administrator.jsp");
			break;
		default:
			break;
		}
		
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
