package cn.itcast.entity;

public class Admin {

	private int id;
	private String adminName;
	private String pwd;
	
	public Admin() {
		super();
	}
	public Admin(String adminName, String pwd) {
		super();
		this.adminName = adminName;
		this.pwd = pwd;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + ", pwd=" + pwd
				+ "]";
	}
}
