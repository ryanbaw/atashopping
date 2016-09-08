package ata.wx.shopping.test;

import ata.wx.shopping.factory.DAOFactory;


public class BankDAOImplTest {
	
	public static void main(String[] args) {

		try {

			System.out.println((Boolean)DAOFactory.getBankDAOInstance().select("aliqi", "766"));
			DAOFactory.getBankDAOInstance().update("aliqi", "766",789);
			System.out.println(String.valueOf(DAOFactory.getBankDAOInstance().select("aliqi")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
