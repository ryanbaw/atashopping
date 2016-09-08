package ata.wx.shopping.dbc ;
import java.sql.* ;

// 主要功能就是连接数据库、关闭数据库
public class DataBaseConnection
{
	private final String DBDRIVER = "com.mysql.jdbc.Driver" ;         
	private final String DBURL = "jdbc:mysql://127.0.0.1:3306/atashopping?useUnicode=true&characterEncoding=utf-8" ;
	private final String DBUSER = "root" ;
	private final String DBPASSWORD = "justdoit" ;
	private Connection conn = null ;

	public DataBaseConnection()
	{
		try
		{
			Class.forName(DBDRIVER) ;
			this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// 取得数据库连接
	public Connection getConnection()
	{
//		try {
//			this.conn.setAutoCommit(false);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return this.conn;
	}

	// 关闭数据库连接
	public void close()
	{
		try
		{
			this.conn.close() ;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}
};