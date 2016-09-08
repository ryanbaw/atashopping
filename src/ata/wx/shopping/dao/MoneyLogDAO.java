package ata.wx.shopping.dao;

import java.util.List;

import ata.wx.shopping.vo.MoneyLog;

public interface MoneyLogDAO {
//	private String logid;
//	private String username;
//	private double money;
//	private String time;

	public List<MoneyLog> selectByName(String username) throws Exception;
	
	public List<MoneyLog> selectAllLog() throws Exception;
	
	public void insert(String logid,String username,double money,String time) throws Exception;
}
