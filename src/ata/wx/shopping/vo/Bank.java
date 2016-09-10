package ata.wx.shopping.vo;

public class Bank {
	
//	CREATE TABLE `bank` (
//			  `username` varchar(20) NOT NULL,
//			  `password` varchar(20) default NULL,
//			  `money` double(15,3) default NULL,
//			  PRIMARY KEY  (`username`)
//			) ENGINE=InnoDB DEFAULT CHARSET=gbk;
	
	private String cardname;
	private String password;
	private double money;

	public Bank() {
		super();
	}
	
	public Bank(String username, String password, double money) {
		super();
		this.cardname = username;
		this.password = password;
		this.money = money;
	}
	public String getUsername() {
		return cardname;
	}
	public void setUsername(String username) {
		this.cardname = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
}
