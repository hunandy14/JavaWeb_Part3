package cn.itcast.b_form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

	private String userName;
	private String pwd;
	private String email;
	private Date birth;
	
	
	public User() {
		super();
	}
	public User(String userName, String pwd, String email, Date birth) {
		super();
		this.userName = userName;
		this.pwd = pwd;
		this.email = email;
		this.birth = birth;
	}
	public User(String userName, String pwd, String email, String birth) {
		super();
		this.userName = userName;
		this.pwd = pwd;
		this.email = email;
		
		Date date = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		try {
			date = df.parse(birth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.birth = date;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		String date_str=null;
		if(birth!=null){			
			date_str = new SimpleDateFormat("yyyy-MM-dd").format(birth);
		}
		return "User [birth=" + date_str + ", email=" + email + ", pwd=" + pwd
				+ ", userName=" + userName + "]";
	}
}
