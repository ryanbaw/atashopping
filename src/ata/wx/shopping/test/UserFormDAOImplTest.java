package ata.wx.shopping.test;

import java.util.List;

import ata.wx.shopping.dao.impl.UserFormDAOImpl;
import ata.wx.shopping.vo.UserForm;


public class UserFormDAOImplTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserFormDAOImpl userform = new	UserFormDAOImpl();
		// TODO Auto-generated method stub
	  
		try {
			userform.insert("1223","王宏秀","杯子",12.12,121,"2008年1月27日",123.23);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	try {
//		UserForm user=userform.selectByFid("121");
//		System.out.print(user.getUsername());
//		System.out.print(user.getTime());
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	try {
//		List<UserForm> userform1=userform.selectByName("郭丹丹");
//		System.out.println(userform1.get(0).getUsername()+"\t"+userform1.get(0).getTime());
//		System.out.println(userform1.size());
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	}
}
