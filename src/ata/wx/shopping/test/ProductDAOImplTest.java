package ata.wx.shopping.test;

import ata.wx.shopping.factory.DAOFactory;
import ata.wx.shopping.vo.Product;


public class ProductDAOImplTest {
	
	public static void main(String[] args) {

		try {
			//DAOFactory.getProductDAOInstance().insert("349", "陈志军2", 12.11, 23, "c:/");
			//DAOFactory.getProductDAOInstance().deleteByNmae("陈志军");
			//DAOFactory.getProductDAOInstance().deleteById("123");
			//DAOFactory.getProductDAOInstance().selectById("346");
//			System.out.println(((Product)DAOFactory.getProductDAOInstance().selectByLike("346").get(0)).getPname());
			System.out.println(DAOFactory.getProductDAOInstance().selectByLike("陈").size());
			//DAOFactory.getProductDAOInstance().selectByName("佳");
			//DAOFactory.getProductDAOInstance().update("346", "李佳", 19.51, 12,"c:/");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
