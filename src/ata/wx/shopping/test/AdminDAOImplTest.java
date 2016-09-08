package ata.wx.shopping.test;

import java.util.List;

import ata.wx.shopping.factory.DAOFactory;
import ata.wx.shopping.vo.Admin;

public class AdminDAOImplTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			
//			DAOFactory.getAdminDAOInstance().insert("家家", "123");
//			DAOFactory.getAdminDAOInstance().insert("玉兰", "E04");
//			DAOFactory.getAdminDAOInstance().updatePassword("家家", "E03");
//			DAOFactory.getAdminDAOInstance().selectByName("家家");
//			DAOFactory.getAdminDAOInstance().selectByNamePassword("玉兰", "E04");
//			DAOFactory.getAdminDAOInstance().insert("王宏秀","E03");
//			List<Admin> adminList=DAOFactory.getAdminDAOInstDAOFactory.getAdminDAOInstance()ance().selectByLike("li");
//			for(int i=0;i<adminList.size();i++){
//				System.out.println(adminList.get(i).getUsername());
//			}
			DAOFactory.getAdminDAOInstance().delete("王宏秀");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
