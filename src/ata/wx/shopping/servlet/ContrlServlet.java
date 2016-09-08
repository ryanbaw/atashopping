package ata.wx.shopping.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ata.wx.shopping.busbean.*;
import ata.wx.shopping.dao.AdminDAO;
import ata.wx.shopping.dao.BankDAO;
import ata.wx.shopping.dao.UserAccountDAO;
import ata.wx.shopping.dao.UserDAO;
import ata.wx.shopping.factory.DAOFactory;
import ata.wx.shopping.util.GetIdTime;
import ata.wx.shopping.vo.*;

public class ContrlServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ContrlServlet() {
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

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//getParameter
		int changei = Integer.parseInt(request.getParameter("valuetype"));
		switch(changei){
			//用户登录 done;
			case 1:
				String loginusername = request.getParameter("loginusername");
				String loginpassword = request.getParameter("loginpassword");
				try {
					if(DAOFactory.getUserDAOInstance().selectByNamePassword(loginusername, loginpassword)){
						User user = DAOFactory.getUserDAOInstance().selectByName(loginusername);
						request.getSession().setAttribute("loginusername", user);
						response.sendRedirect(request.getContextPath()+"/logok.jsp");
					}else{
						response.sendRedirect(request.getContextPath()+"/logfail.jsp");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			//用户注册 
			case 2:
				UserDAO userdao = DAOFactory.getUserDAOInstance();
				String regusername = request.getParameter("regusername");
				if("".equals(regusername)){
					response.sendRedirect(request.getContextPath()+"/regfail.jsp");
					return;
				}
				try {
					if(userdao.selectByName(regusername)!=null){
						request.getSession().setAttribute("hasuser", "has");
						response.sendRedirect(request.getContextPath()+"/regfail.jsp");
					}else{
						String regpassword = request.getParameter("regpassword");
//String regname = request.getParameter("regname");
						String regemail = request.getParameter("regemail");
						String regtel = request.getParameter("regtel");
						String regaddr = request.getParameter("regaddr");
						String regsex = request.getParameter("regsex");
						String regborntime = request.getParameter("regage");
						int regage=0;
						if("".equals(regborntime)){
							response.sendRedirect(request.getContextPath()+"/regfail.jsp");
							return;
						}else{
							String nowyear = GetIdTime.getTime().substring(0, 4);
							String regyear = regborntime.substring(0,4);
							System.out.println("reg year is:"+regyear);
							System.out.println("This year is:"+nowyear);
							regage = Integer.valueOf(nowyear) - Integer.valueOf(regyear);
						}
						String regtime = GetIdTime.getTime();
						UserOBean.newUserBean(regusername, regpassword, regemail, regtel, regaddr, regsex, regage, regtime);
						User user = userdao.selectByName(regusername);
						request.getSession().setAttribute("loginusername",user);
						response.sendRedirect(request.getContextPath()+"/regok.jsp");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			//管理员登陆	done
			case 3:
				String adminname = request.getParameter("adminname");
				String adminpassword = request.getParameter("adminpassword");
				AdminDAO admindao = DAOFactory.getAdminDAOInstance();
				try {
					if(admindao.selectByNamePassword(adminname, adminpassword)){
						Admin admin = admindao.selectByName(adminname);
						request.getSession().setAttribute("adminname", admin);
						this.getServletContext().getRequestDispatcher("admin.jsp").forward(request, response);
					}else{
						response.sendRedirect("alogfail.jsp");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			//Bank用户登录 
			case 4:
				String useraccount = request.getParameter("useraccount");
//System.out.println(useraccount);
				String accountpwd = request.getParameter("accountpwd");
//System.out.println(accountpwd);
				BankDAO userbankdao = DAOFactory.getBankDAOInstance();
System.out.println(userbankdao);
				try {
System.out.println(userbankdao.select(useraccount, accountpwd));
					if(userbankdao.select(useraccount, accountpwd)){
						Bank bankuser = userbankdao.select(useraccount);
System.out.println(bankuser);
						request.getSession().setAttribute("bankuser", bankuser);
						response.sendRedirect(request.getContextPath()+"/addmoney.jsp");
					}else{
						response.sendRedirect(request.getContextPath()+"/addmoney.jsp");
					}
					
				} catch (Exception e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}

				break;
			//购物 
			case 5:
				User buyuser =(User)request.getSession().getAttribute("loginusername");
				List<Product> listproduct = (List<Product>) request.getSession().getAttribute("listproduct");
				UserDAO userdaobuy = DAOFactory.getUserDAOInstance();
				try {
					if(userdaobuy.selectByNamePassword(buyuser.getUsername(), buyuser.getPassword())){
						UserFormOBean.buyProcess(buyuser.getUsername(), listproduct);
						request.getSession().setAttribute("buyuser", buyuser);
						this.getServletContext().getRequestDispatcher("payok.jsp").forward(request, response);
					}else{
						response.sendRedirect("buyfalse.jsp");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				break;
			//删除用户 
			case 6:
				String wantdeletestr = request.getParameter("wantdeletestr");
				try {
						UserOBean.deleteUserBean(wantdeletestr);
						response.sendRedirect("admin.jsp");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			//用户注销 done;
			case 7:
				request.getSession().removeAttribute("loginusername");
				request.getSession().removeAttribute("bankuser");
				response.sendRedirect(request.getContextPath()+"/index.jsp");
				break;
			//用户信息修改
			case 8:
				String pastpassword = request.getParameter("password");
				String editpassword = request.getParameter("newpassword");
				String edittel = request.getParameter("telphone");
				String editaddr = request.getParameter("address");
				int editage = 0;
				try{
					editage = Integer.valueOf(request.getParameter("year"));
				}catch(Exception e){
					response.sendRedirect(request.getContextPath()+"/infupdate.jsp");
					e.printStackTrace();
				}
				User edituser = (User)request.getSession().getAttribute("loginusername");
				String usepassword = null;
				if(edituser==null){
					response.sendRedirect(request.getContextPath()+"/index.jsp");
					return;
				}
				usepassword = edituser.getPassword();
				if("".equals(usepassword)&&"".equals(pastpassword)){
					response.sendRedirect(request.getContextPath()+"/editfail.jsp");
				}else{
					if(usepassword.equals(pastpassword)){
						try {
							UserDAO edituserdao = DAOFactory.getUserDAOInstance();
							String editusername = edituser.getUsername();
							String edituseremail = edituser.getEmail();
							String editusersex = edituser.getSex();
							String eidtuserregtime = edituser.getRegtime();
							
							edituserdao.updtae(editusername, editpassword, edituseremail, edittel, editaddr, editusersex, editage, eidtuserregtime);
							response.sendRedirect(request.getContextPath()+"/editok.jsp");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else{
						response.sendRedirect(request.getContextPath()+"/editfail.jsp");
					}
				}
				break;
			//Bank注销
			case 9:
				request.getSession().removeAttribute("bankuser");
				response.sendRedirect(request.getContextPath()+"/addmoney.jsp");
				break;
			//Bank充值
			case 10:
				double addmoney = 0;
				try{
					User userob =(User)request.getSession().getAttribute("loginusername");
					Bank bankob = (Bank)request.getSession().getAttribute("bankuser");
//System.out.println(userob);
//System.out.println(bankob);
					String addmoneystr = request.getParameter("addmoney");
//System.out.println("\n欲充值金额："+addmoneystr+"\n");
					if("".equals(addmoneystr)){
						request.getSession().setAttribute("zeromoney", "zero");
						response.sendRedirect(request.getContextPath()+"/addfalse.jsp");
						return;
					}else{
						addmoney = Double.valueOf(addmoneystr);
//System.out.println(addmoney);
					}
					if(bankob!=null&&userob!=null){
						String userobname = userob.getUsername();
						UserBankOBean.addMoney(bankob.getUsername(), bankob.getPassword(), userobname, addmoney);
						response.sendRedirect(request.getContextPath()+"/addok.jsp");
					}else{
						response.sendRedirect(request.getContextPath()+"/addfalse.jsp");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			//BankUser注册
			case 11:
				String regbankusername = request.getParameter("regbankusername");
				String regbankpassword = request.getParameter("regbankpassword");
				String regeRMB = request.getParameter("regeRMB");
				BankDAO bankd = DAOFactory.getBankDAOInstance();
				Bank bankreg;
				try {
					bankreg = bankd.select(regbankusername);
					if(bankreg==null){
						bankreg = new Bank();
						if(!"".equals(regeRMB)){
							bankreg.setUsername(regbankusername);
							bankreg.setPassword(regbankpassword);
							bankreg.setMoney(Double.valueOf(regeRMB));
							bankd.insert(bankreg);
							response.sendRedirect(request.getContextPath()+"/bankregok.jsp");
						}else{
							response.sendRedirect(request.getContextPath()+"/bankregfail.jsp");
						}
					}else{
						request.getSession().setAttribute("hasbankuser", "hasbank");
						response.sendRedirect(request.getContextPath()+"/bankregfail.jsp");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
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
