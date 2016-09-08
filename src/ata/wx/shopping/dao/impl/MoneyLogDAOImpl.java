package ata.wx.shopping.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import ata.wx.shopping.dao.MoneyLogDAO;
import ata.wx.shopping.dbc.DataBaseConnection;
import ata.wx.shopping.vo.MoneyLog;

public class MoneyLogDAOImpl implements MoneyLogDAO {

	public void insert(String logid, String username, double money,
			String time) throws Exception {
		String sql="INSERT INTO moneylog (logid,username,money,time) VALUES (?,?,?,?) ";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;
		
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, logid);
			pstmt.setString(2, username);
			pstmt.setDouble(3, money);
			pstmt.setString(4, time);
			// 进行数据库更新操作
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
	
	}

	public List<MoneyLog> selectByName(String username) throws Exception {
		List<MoneyLog> logList=new ArrayList<MoneyLog>();
		String sql = "SELECT * FROM moneylog WHERE username=?";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;

		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			// 设置模糊查询条件
			pstmt.setString(1, username);
			
			// 进行数据库查询操作
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// 查询出内容，之后将查询出的内容赋值给person对象
				MoneyLog moneyLog=new MoneyLog();
				moneyLog.setLogid(rs.getString(1));
				moneyLog.setUsername(rs.getString(2));
				moneyLog.setMoney(rs.getDouble(3));
				moneyLog.setTime(rs.getString(4));

				// 将查询出来的数据加入到List对象之中
				logList.add(moneyLog);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		return logList;
	}
	
	public List<MoneyLog> selectAllLog() throws Exception {
		List<MoneyLog> logList=new ArrayList<MoneyLog>();
		String sql = "SELECT * FROM moneylog ";
		PreparedStatement pstmt = null;
		DataBaseConnection dbc = null;

		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DataBaseConnection();
			pstmt = dbc.getConnection().prepareStatement(sql);
			
			
			
			// 进行数据库查询操作
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// 查询出内容，之后将查询出的内容赋值给person对象
				MoneyLog moneyLog=new MoneyLog();
				moneyLog.setLogid(rs.getString(1));
				moneyLog.setUsername(rs.getString(2));
				moneyLog.setMoney(rs.getDouble(3));
				moneyLog.setTime(rs.getString(4));

				// 将查询出来的数据加入到List对象之中
				logList.add(moneyLog);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		return logList;
	}

}
