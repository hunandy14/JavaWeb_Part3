package cn.itcast.a_config;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction {
	
	private String userName;
	public void setUserName(String userName) {
		System.err.println("自動注入get數據 userName="+userName);
		this.userName = userName;
	}
	

	// Action中业务处理方法
	public String login() {
		System.out.println("UserAction.login()" + userName);
		return "login";
	}
	
	public String register() {
		System.out.println("register()" + userName);
		return "register";
	}
}
