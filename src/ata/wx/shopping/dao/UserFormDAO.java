package ata.wx.shopping.dao;

import java.util.List;

import ata.wx.shopping.vo.Product;
import ata.wx.shopping.vo.UserForm;

public interface UserFormDAO {
	
//	private String fid;
//	private String username;
//	private String pname;
//	private int count;
//	private String time;
	
	public UserForm selectByFid(String fid) throws Exception;
	
	public List<UserForm> selectByName(String username) throws Exception;
	
	public void insert(String fid,String username,String pname,double proprice,int count,String time,double summoney)throws Exception;

	public void insert(Product product) throws Exception;
	
	public List<UserForm> selectAllForm() throws Exception ;
}
