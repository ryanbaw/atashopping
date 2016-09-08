package ata.wx.shopping.busbean;

import ata.wx.shopping.factory.DAOFactory;
import ata.wx.shopping.vo.UserAccount;
import ata.wx.shopping.util.*;
public class UserBankOBean {
	//充值
	//更新bank的时候自动在useraccount上加上数量

	//username是用户在网站的用户名     //这个money是用户要充的钱的数量
	public static void addMoney(String cardname,String password,String username,double addmoney){
		try {
			String moneyLogId=GetIdTime.getLogid();
			String time=GetIdTime.getTime();
			//这个钱是充值前银行账户有多少钱
			double money1=DAOFactory.getBankDAOInstance().select(cardname).getMoney();
			double money2=money1-addmoney;
			DAOFactory.getBankDAOInstance().update(cardname, password, money2);
			//得到用户账户充值钱所拥有的钱
			UserAccount useraccount=DAOFactory.getUserAccountDAOInstance().selectUserAccount(username);
			double usermoney1=useraccount.getMoney();
			//充值后用户的总钱数
			double usermoney2=usermoney1+addmoney;
			DAOFactory.getUserAccountDAOInstance().updateUserAccount(username, usermoney2);
			//增加充值记录
			DAOFactory.getMoneyLogDAOInstance().insert(moneyLogId, username, addmoney, time);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
