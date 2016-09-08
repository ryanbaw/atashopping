package ata.wx.shopping.dao;

import java.util.List;

import ata.wx.shopping.vo.UserAccount;

public interface UserAccountDAO {
//	private String username;
//	private double money;

	public void newUserAccount(String username) throws Exception;
	
	public void deleteUserAccount(String username) throws Exception;
	
	public void updateUserAccount(String username,double money) throws Exception;
	
	public UserAccount selectUserAccount(String username) throws Exception;
	
	public List<UserAccount> selectAllUserAccount() throws Exception;
}
