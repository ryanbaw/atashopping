package ata.wx.shopping.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import ata.wx.shopping.dao.UserDAO;
import ata.wx.shopping.dbc.DataBaseConnection;
import ata.wx.shopping.vo.User;

public class UserDAOImpl implements UserDAO {
//	private String username;
//	private String password;
//	private String email;
//	private String tel;
//	private String address;
//	private String sex;
//	private int age;
//	private String regtime;

	public void delete(User user) throws Exception {

		String sql = "DELETE FROM user WHERE username=?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;

		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			// 进行数据库更新操作
			
			pstmt.executeUpdate();			
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			pstmt.close();
			dbc.close();
		}
		
	}

	public void delete(String username) throws Exception {

		String sql = "DELETE FROM user WHERE username=?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;

		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		
	}

	public void insert(User user) throws Exception {

		String sql="INSERT INTO user (username,password,email,tel,address,sex,age,regtime) VALUES (?,?,?,?,?,?,?,?) ";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getTel());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getSex());
			pstmt.setInt(7, user.getAge());
			pstmt.setString(8, user.getRegtime());
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
	}

	public void insert(String username, String password, String email,
			String regtime) throws Exception {
		String sql="INSERT INTO user (username,password,email) VALUES (?,?,?) ";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}

	}

	public void insert(String username, String password, String email,
			String tel, String address, String sex, int age, String regtime)
			throws Exception {
		String sql="INSERT INTO user (username,password,email,tel,address,sex,age,regtime) VALUES (?,?,?,?,?,?,?,?) ";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setString(4, tel);
			pstmt.setString(5, address);
			pstmt.setString(6, sex);
			pstmt.setInt(7, age);
			pstmt.setString(8, regtime);
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}

	}

	public List<User> selectAll() throws Exception {
		List<User> userlist = new ArrayList<User>();
		String sql = "SELECT * FROM user ";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			dbc.getConnection().setAutoCommit(true);
			pstmt = dbc.getConnection().prepareStatement(sql);
			// 进行数据库查询操作
			ResultSet rs = pstmt.executeQuery();
						
            
			while(rs.next()) {
				// 查询出内容，之后将查询出的内容赋值给user对象
				User user=new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setTel(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setSex(rs.getString(6));
				user.setAge(rs.getInt(7));
				user.setRegtime(rs.getString(8));
				// 将查询出来的数据加入到List对象之中
				userlist.add(user);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		return userlist;
	}
	
	
	public User selectByName(String username) throws Exception {
		User user = null;
		String sql = "SELECT * FROM user WHERE username=?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		ResultSet rs=null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			// 进行数据库查询操作
			 rs= pstmt.executeQuery();
			if (rs.next()) {
				// 查询出内容，之后将查询出的内容赋值给user对象
				user=new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setTel(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setSex(rs.getString(6));
				user.setAge(rs.getInt(7));
				user.setRegtime(rs.getString(8));
			}
			
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			rs.close();
			pstmt.close();
			dbc.close();
		}
		return user;
	}
	
	public boolean selectByNamePassword(String username, String password)
	throws Exception {

		String sql = "SELECT * FROM user WHERE username=? and password=?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		boolean ret = false;
		ResultSet rs=null;
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			// 设置用户查询条件
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			// 进行数据库查询操作
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				ret = true;
			}
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			rs.close();
			pstmt.close();
			// 关闭数据库连接
			dbc.close();
		}
		System.out.println(ret);
		return ret;
	}
    
	
	public List<User> selectByLike(String cond) throws Exception{
		List<User> userlist = new ArrayList<User>();
		String sql = "SELECT * FROM user WHERE username LIKE ? or address LIKE ?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;

		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			// 设置模糊查询条件
			pstmt.setString(1, "%" + cond + "%");
			pstmt.setString(2, "%" + cond + "%");
			// 进行数据库查询操作
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				while(rs.next()) {
					// 查询出内容，之后将查询出的内容赋值给user对象
					User user=new User();
					user.setUsername(rs.getString(1));
					user.setPassword(rs.getString(2));
					user.setEmail(rs.getString(3));
					user.setTel(rs.getString(4));
					user.setAddress(rs.getString(5));
					user.setSex(rs.getString(6));
					user.setAge(rs.getInt(7));
					user.setRegtime(rs.getString(8));
					// 将查询出来的数据加入到List对象之中
					userlist.add(user);
				}
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		return userlist;
		
	}

	public void update(User user) throws Exception {
		String sql = "UPDATE user SET password=?,email=?,tel=?,address=?,sex=?,age=?,regtime=? WHERE username=?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getTel());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getSex());
			pstmt.setInt(6, user.getAge());
			pstmt.setString(7, user.getRegtime());
			pstmt.setString(8, user.getUsername());
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}

	}

	public void updatePassword(String username, String password) throws Exception {
		

		String sql = "UPDATE user SET password=? WHERE username=?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, username);
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
	}

	public void updateEmail(String username, String email)
			throws Exception {
		String sql = "UPDATE user SET email=? WHERE username=? ";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, username);
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}

	}
	
	public void updateAddress(String username, String address) throws Exception {

		String sql = "UPDATE user SET address=? WHERE username=? ";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			
			pstmt.setString(1, address);
			pstmt.setString(2, username);
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		
	}

	public void updtae(String username, String password, String email,
			String tel, String address, String sex, int age, String regtime)
			throws Exception {
		String sql = "UPDATE user SET password=?,email=?,tel=?,address=?,sex=?,age=?,regtime=? WHERE username=?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, email);
			pstmt.setString(3, tel);
			pstmt.setString(4, address);
			pstmt.setString(5, sex);
			pstmt.setInt(6, age);
			pstmt.setString(7, regtime);
			pstmt.setString(8, username);
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}

	}

	

	

}
