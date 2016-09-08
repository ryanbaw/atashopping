package ata.wx.shopping.busbean;

import ata.wx.shopping.factory.*;

public class UserOBean {
	public static void newUserBean(String username, String password, String email, String tel, String address, String sex,int  age,String  regtime){
		try {
			DAOFactory.getUserDAOInstance().insert(username, password, email, tel, address, sex, age, regtime);
			DAOFactory.getUserAccountDAOInstance().newUserAccount(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteUserBean(String username){
		try {
			DAOFactory.getUserDAOInstance().delete(username);
			DAOFactory.getUserAccountDAOInstance().deleteUserAccount(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
