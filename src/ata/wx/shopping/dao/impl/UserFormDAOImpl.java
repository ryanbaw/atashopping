package ata.wx.shopping.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ata.wx.shopping.dao.UserFormDAO;
import ata.wx.shopping.dbc.DataBaseConnection;
import ata.wx.shopping.vo.Product;
import ata.wx.shopping.vo.UserForm;

public class UserFormDAOImpl implements UserFormDAO {

	public void insert(String fid, String username, String pname, double proprice,int count,
			String time,double summoney) throws Exception {
		String sql="INSERT INTO userform (fid,username,pname,proprice,count,time,summoney) VALUES (?,?,?,?,?,?,?) ";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, fid);
			pstmt.setString(2, username);
			pstmt.setString(3, pname);
			pstmt.setDouble(4, proprice);
			pstmt.setInt(5, count);
			pstmt.setString(6, time);
			pstmt.setDouble(7, summoney);
			// 进行数据库更新操作
System.out.println(pstmt);			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			pstmt.close();
			dbc.close();
		}

	}

	public UserForm selectByFid(String fid) throws Exception {
		
		UserForm userForm = null;
		String sql = "SELECT * FROM userform WHERE fid=?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, fid);
			// 进行数据库查询操作
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// 查询出内容，之后将查询出的内容赋值给user对象
				userForm=new UserForm();
				userForm.setFid(rs.getString(2));
				userForm.setUsername(rs.getString(3));
				userForm.setPname(rs.getString(4));
				userForm.setProprice(rs.getDouble(5));
				userForm.setCount(rs.getInt(6));
				userForm.setTime(rs.getString(7));
				userForm.setSummoney(rs.getDouble(8));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		return userForm;
	}

	public List<UserForm> selectByName(String username) throws Exception {
		
		
		List<UserForm> formList=new ArrayList<UserForm>();
		String sql = "SELECT * FROM userform WHERE username=?";
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
			while(rs.next()) {
				// 查询出内容，之后将查询出的内容赋值给user对象
				UserForm userForm = null;
				userForm=new UserForm();
				userForm.setFid(rs.getString(2));
				userForm.setUsername(rs.getString(3));
				userForm.setPname(rs.getString(4));
				userForm.setProprice(rs.getDouble(5));
				userForm.setCount(rs.getInt(6));
				userForm.setTime(rs.getString(7));
				userForm.setSummoney(rs.getDouble(8));
				formList.add(userForm);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		return formList;
	}
	
public List<UserForm> selectAllForm() throws Exception {

	List<UserForm> formList=new ArrayList<UserForm>();
		String sql = "SELECT * FROM userform ";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			// 进行数据库查询操作
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				// 查询出内容，之后将查询出的内容赋值给user对象
				UserForm userForm=new UserForm();
				userForm.setFid(rs.getString(2));
				userForm.setUsername(rs.getString(3));
				userForm.setPname(rs.getString(4));
				userForm.setProprice(rs.getDouble(5));
				userForm.setCount(rs.getInt(6));
				userForm.setTime(rs.getString(7));
				userForm.setSummoney(rs.getDouble(8));
				formList.add(userForm);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		return formList;
	}

	public void insert(Product product) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
