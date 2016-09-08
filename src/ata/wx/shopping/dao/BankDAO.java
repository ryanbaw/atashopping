package ata.wx.shopping.dao;

import ata.wx.shopping.vo.Bank;

public interface BankDAO {
	
	public boolean update(String cardname,String password,double money) throws Exception;
	
	public boolean select(String cardname,String password) throws Exception;

	public Bank select(String cardname) throws Exception;
	
//	public Bank select(String cardname,String password,double money) throws Exception;
	
	public void insert(Bank bank) throws Exception;
}
