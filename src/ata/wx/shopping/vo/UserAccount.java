package ata.wx.shopping.vo;

public class UserAccount {
	
	private String username;
	private double money;
	
	public UserAccount() {
		super();
	}
	
	public UserAccount(String username) {
		super();
		this.username = username;
	}
	
	public UserAccount(String username, double money) {
		super();
		this.username = username;
		this.money = money;
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

}
