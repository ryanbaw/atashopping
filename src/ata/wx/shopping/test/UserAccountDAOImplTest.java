package ata.wx.shopping.test;

import ata.wx.shopping.factory.DAOFactory;
import ata.wx.shopping.vo.UserAccount;

public  class UserAccountDAOImplTest {
	public static void newUserAccountTest(String name) {
		try {
			DAOFactory.getUserAccountDAOInstance().newUserAccount(name);
			System.out.println("创建成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteUserAccountTest(String name) {
		try {
			DAOFactory.getUserAccountDAOInstance().deleteUserAccount(name);
			System.out.println("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateUserAccountTest(String name, double money) {
		try {
			DAOFactory.getUserAccountDAOInstance().updateUserAccount(name,
					money);
			System.out.println("更新成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 public static UserAccount selectUserAccountTest(String username) {
	 try {
	 UserAccount
	 userAccount=(UserAccount)DAOFactory.getUserAccountDAOInstance().selectUserAccount(username);
	 System.out.println("选择成功！");
	 return userAccount;
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
	return null;
	 }
	public static void main(String[] args) {
		//newUserAccountTest("家家");
       // deleteUserAccountTest("家家");
		System.out.println(selectUserAccountTest("王宏秀1").getUsername()+selectUserAccountTest("王宏秀1").getMoney());
//        updateUserAccountTest("丹丹", 0.01);
	}
}