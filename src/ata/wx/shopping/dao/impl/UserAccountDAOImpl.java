package ata.wx.shopping.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ata.wx.shopping.dao.UserAccountDAO;
import ata.wx.shopping.dbc.DataBaseConnection;
import ata.wx.shopping.vo.UserAccount;


public class UserAccountDAOImpl implements UserAccountDAO {

	public void deleteUserAccount(String username) throws Exception {

		String sql = "DELETE FROM useraccount WHERE username=?";
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

	public void newUserAccount(String username) throws Exception {
		String sql="INSERT INTO useraccount (username,money) VALUES (?,?) ";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			
			pstmt.setDouble(2, 0.000);
			
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

	public UserAccount selectUserAccount(String username) throws Exception {
		UserAccount userAccount=null;
		String sql="SELECT * FROM useraccount WHERE username=?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);
			
			// 进行数据库更新操作
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				userAccount=new UserAccount();
				userAccount.setUsername(rs.getString(1));				
				userAccount.setMoney(rs.getDouble(2));
			}
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		
		return userAccount;
	}
	
	public List<UserAccount> selectAllUserAccount() throws Exception{
		List<UserAccount> userAccountList=new ArrayList<UserAccount> ();
		String sql="SELECT * FROM useraccount ";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			
			// 进行数据库更新操作
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				UserAccount userAccount=new UserAccount();
				userAccount=new UserAccount();
				userAccount.setUsername(rs.getString(1));				
				userAccount.setMoney(rs.getDouble(2));
				userAccountList.add(userAccount);
			}
			pstmt.close();
		} catch (Exception e) {
			throw new Exception("操作出现异常");
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		
		return userAccountList;
		
	}

	public void updateUserAccount(String username, double money)
			throws Exception {
		String sql = "UPDATE useraccount SET money=? WHERE username=?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setDouble(1, money);
			pstmt.setString(2,username);			
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
