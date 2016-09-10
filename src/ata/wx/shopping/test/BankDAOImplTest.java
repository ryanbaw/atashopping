package ata.wx.shopping.test;

import ata.wx.shopping.factory.DAOFactory;
import ata.wx.shopping.vo.Bank;

public class BankDAOImplTest {
	
	public static void main(String[] args) {

		try {
			Bank mybank = new Bank("aliqi", "766", 9999999);
			DAOFactory.getBankDAOInstance().insert(mybank);
			System.out.println((Boolean)DAOFactory.getBankDAOInstance().select("aliqi", "766"));
			DAOFactory.getBankDAOInstance().update("aliqi", "766",789);
			System.out.println(String.valueOf(DAOFactory.getBankDAOInstance().select("aliqi")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
