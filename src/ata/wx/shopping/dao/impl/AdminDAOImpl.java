package ata.wx.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ata.wx.shopping.dao.AdminDAO;
import ata.wx.shopping.dbc.DataBaseConnection;
import ata.wx.shopping.vo.Admin;



public class AdminDAOImpl implements AdminDAO {

	public void delete(Admin admin) throws Exception {
		String sql = "DELETE FROM admin WHERE username=?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;

		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			Connection dbcon = dbc.getConnection();
			pstmt = dbcon.prepareStatement(sql);
			pstmt.setString(1, admin.getUsername());
			// 进行数据库更新操作
			dbcon.setAutoCommit(false);
			try{
				pstmt.executeUpdate();		
				dbc.getConnection().commit();
			}catch(Exception e){
				dbcon.rollback();
				dbcon.setAutoCommit(true);
			}
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}

	}

	public void delete(String username) throws Exception {
		String sql = "DELETE FROM admin WHERE username=?";
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

	public void insert(Admin admin) throws Exception {

		String sql="INSERT INTO admin (username,password) VALUES (?,?) ";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, admin.getUsername());
			pstmt.setString(2, admin.getPassword());
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

	public Admin selectByName(String username) throws Exception {
		
		Admin admin = null;
		String sql = "SELECT * FROM user WHERE username=?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			// 进行数据库查询操作
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// 查询出内容，之后将查询出的内容赋值给user对象
				admin=new Admin();
				admin.setUsername(rs.getString(1));
				admin.setPassword(rs.getString(2));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		return admin;
	}

	public List<Admin> selectByLike(String cond) throws Exception{
		List<Admin> adminlist = new ArrayList<Admin>();
		String sql = "SELECT * FROM admin WHERE username LIKE ? ";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		ResultSet rs=null;

		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			// 设置模糊查询条件
			pstmt.setString(1, "%" + cond + "%");
			// 进行数据库查询操作
		
			 rs= pstmt.executeQuery();			
				while(rs.next()) {
					// 查询出内容，之后将查询出的内容赋值给user对象
					Admin admin=new Admin();
					admin.setUsername(rs.getString(1));
					admin.setPassword(rs.getString(2));
					// 将查询出来的数据加入到List对象之中
					adminlist.add(admin);
				}			
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			rs.close();
			pstmt.close();
			dbc.close();
		}
		return adminlist;
		
	}

	public void updatePassword(String username, String password)
			throws Exception {
		String sql = "UPDATE admin SET password=? WHERE username=?";
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



	public boolean selectByNamePassword(String username, String password)
			throws Exception {
		String sql = "SELECT * FROM admin WHERE username=? and password=?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		boolean ret = false;
		ResultSet rs=null;
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			// 设置模糊查询条件
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

	public void insert(String username, String password) throws Exception {
		String sql="INSERT INTO admin (username,password) VALUES (?,?) ";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
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
