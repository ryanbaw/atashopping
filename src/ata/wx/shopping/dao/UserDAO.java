package ata.wx.shopping.dao;

import java.util.List;

import ata.wx.shopping.vo.User;

public interface UserDAO {

//	private String username;
//	private String password;
//	private String email;
//	private String tel;
//	private String address;
//	private String sex;
//	private int age;
//	private String regtime;
	//新增加用户
	public void insert(User user) throws Exception;
		
	public void insert(String username,String password,String email,String regtime) throws Exception;
	
	public void insert(String username,String password,String email,String tel,String address,String sex,int age,String regtime) throws Exception;
	
	public void update(User user) throws Exception;
	
	public void updatePassword(String username,String password) throws Exception;
	
	public void updateEmail(String username,String email) throws Exception;
	
	public void updateAddress(String username,String address) throws Exception;
	
	public void updtae(String username,String password,String email,String tel,String address,String sex,int age,String regtime) throws Exception;
	
	public void delete(User user) throws Exception;
	
	public void delete(String username) throws Exception;
	
	public User selectByName(String username) throws Exception;
	
	public boolean selectByNamePassword(String username ,String password )throws Exception;
	
	public List<User> selectAll() throws Exception;
	
	public List<User> selectByLike(String cond) throws Exception;
	
	
	
	
}
