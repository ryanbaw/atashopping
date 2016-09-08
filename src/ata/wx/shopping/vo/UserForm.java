package ata.wx.shopping.vo;

public class UserForm {

	private String fid;
	private String username;
	private String pname;
	private double proprice;
	private int count;
	private String time;
	private double summoney;
	
	
	public UserForm() {
		super();
	}
	
	public UserForm(String fid, String username, String pname, int count,
			String time) {
		super();
		this.fid = fid;
		this.username = username;
		this.pname = pname;
		this.count = count;
		this.time = time;
	}
	
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	public double getSummoney() {
		return summoney;
	}

	public void setSummoney(double summoney) {
		this.summoney = summoney;
	}

	public double getProprice() {
		return proprice;
	}

	public void setProprice(double proprice) {
		this.proprice = proprice;
	}
	
}
