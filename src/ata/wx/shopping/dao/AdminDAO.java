package ata.wx.shopping.dao;

import java.util.List;

import ata.wx.shopping.vo.Admin;

public interface AdminDAO {
	
	public void insert(Admin admin)throws Exception ;
	
	public void insert(String username,String password)throws Exception;
	
	
	public void updatePassword(String username,String password)throws Exception ;
	
	public List<Admin> selectByLike(String cond) throws Exception;
	
	public void delete(String username) throws Exception ;
	
	public Admin selectByName(String username)throws Exception ;
	
	public boolean selectByNamePassword(String username,String password)throws Exception;

}
