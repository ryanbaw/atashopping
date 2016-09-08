package ata.wx.shopping.test;

import ata.wx.shopping.busbean.*;

/**
 * 
 * @author 陈志军测试
 *
 */
public class UserBankOBeanTest {
	
	public static void main(String[] args) {
		for(int i=1;i<50;i++){
			String username="用户"+i;
			
			UserBankOBean.addMoney("admin", "admin", username, 10000);
		}
		
	}

}
