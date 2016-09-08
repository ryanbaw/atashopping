package ata.wx.shopping.vo;

public class MoneyLog {

//	CREATE TABLE `moneylog` (
//			  `logid` varchar(20) NOT NULL,
//			  `username` varchar(20) default NULL,
//			  `money` double(15,3) default NULL,
//			  `time` varchar(20) default NULL,
//			  PRIMARY KEY  (`logid`)
//			) ENGINE=InnoDB DEFAULT CHARSET=gbk;
	
	private String logid;
	private String username;
	private double money;
	private String time;
	
	
	public MoneyLog() {
		super();
	}
	
	public MoneyLog(String logid, String username, double money, String time) {
		super();
		this.logid = logid;
		this.username = username;
		this.money = money;
		this.time = time;
	}
	public String getLogid() {
		return logid;
	}
	public void setLogid(String logid) {
		this.logid = logid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
