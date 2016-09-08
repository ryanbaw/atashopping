package ata.wx.shopping.factory ;

import ata.wx.shopping.dao.AdminDAO;
import ata.wx.shopping.dao.BankDAO;
import ata.wx.shopping.dao.MoneyLogDAO;
import ata.wx.shopping.dao.ProductDAO;
import ata.wx.shopping.dao.UserAccountDAO;
import ata.wx.shopping.dao.UserDAO;
import ata.wx.shopping.dao.UserFormDAO;
import ata.wx.shopping.dao.impl.AdminDAOImpl;
import ata.wx.shopping.dao.impl.BankDAOImpl;
import ata.wx.shopping.dao.impl.MoneyLogDAOImpl;
import ata.wx.shopping.dao.impl.ProductDAOImpl;
import ata.wx.shopping.dao.impl.UserAccountDAOImpl;
import ata.wx.shopping.dao.impl.UserDAOImpl;
import ata.wx.shopping.dao.impl.UserFormDAOImpl;




public class DAOFactory
{	
	public static UserDAO getUserDAOInstance(){
		return new UserDAOImpl();
	}
	
	public static AdminDAO getAdminDAOInstance(){
		return new AdminDAOImpl();
	}
	
	public static ProductDAO getProductDAOInstance(){
		return new ProductDAOImpl();
	}
	
	public static BankDAO getBankDAOInstance(){
		return new BankDAOImpl();
	}
	
	public static UserAccountDAO getUserAccountDAOInstance(){
		return new UserAccountDAOImpl();
	}
	
	public static UserFormDAO getUserFormDAOInstance(){
		return new UserFormDAOImpl();
	}
	
	public static MoneyLogDAO getMoneyLogDAOInstance(){
		return new MoneyLogDAOImpl();
	}
		
}
