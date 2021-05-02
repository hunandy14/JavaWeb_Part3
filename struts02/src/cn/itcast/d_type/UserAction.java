package cn.itcast.d_type;

import java.util.Date;

/**
 * Struts核心业务： 请求数据自动封装以及类型转换
 * @author Jie.Yuan
 *
 */
public class UserAction {
	
	 // 对象类型，一定给get方法
	private User user222; 
	public void setUser(User user) {
		this.user222 = user;
	}
	public User getUser() {
		return user222;
	}

	// 处理注册请求
	public String register() {
		System.err.println(user222);
		return "success";
	}
}
