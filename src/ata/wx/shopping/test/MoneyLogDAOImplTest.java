package ata.wx.shopping.test;

import ata.wx.shopping.dao.MoneyLogDAO;
import ata.wx.shopping.factory.DAOFactory;

public class MoneyLogDAOImplTest {


	public static void main(String[] args) {

//		try {
//			DAOFactory.getMoneyLogDAOInstance().insert("Y08054", "余玉兰", 63325.6663, "9：53");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			System.out.println(DAOFactory.getMoneyLogDAOInstance().selectByName("余玉兰"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
