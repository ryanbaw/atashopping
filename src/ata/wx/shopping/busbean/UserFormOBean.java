package ata.wx.shopping.busbean;

import java.util.List;
import ata.wx.shopping.util.*;

import ata.wx.shopping.factory.DAOFactory;
import ata.wx.shopping.vo.Product;
import ata.wx.shopping.vo.UserAccount;

public class UserFormOBean {
	
	public static void buyProcess(String username,List<Product> prolist){
	    String formid=GetIdTime.getFormid();
		String time=GetIdTime.getTime();
		
		for(int i=0; i<prolist.size();i++){
			Product product=prolist.get(i);
			String pid=product.getPid();
			String pname=product.getPname();
			double proprice=product.getPrice();
			//得到买了该样商品的数量
			int count=1;//product.getPcount();
			double summoney =count*proprice;
			
            try {
            	//得到用户现有多少钱
				UserAccount useraccount=DAOFactory.getUserAccountDAOInstance().selectUserAccount(username);
				double usermoney1=useraccount.getMoney();
				//在用户账户中减去一样商品的消费额
				double usermoney2=usermoney1-summoney;
				//更新用户账户金额
				DAOFactory.getUserAccountDAOInstance().updateUserAccount(username, usermoney2);
            	//原先该样商品的总数量
    			int pcount1=DAOFactory.getProductDAOInstance().selectById(pid).getPcount();
    			//更新该样商品数据库
    			DAOFactory.getProductDAOInstance().updateByPname(pid, pcount1-count);
    			//在用户账单数据库中加入一条信息
				DAOFactory.getUserFormDAOInstance().insert(formid, username, pname, proprice, count, time, summoney);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
