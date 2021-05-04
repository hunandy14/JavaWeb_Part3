package cn.itcast.a_validation;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 注意：如果要想用struts的数据效验功能，必须继承ActionSupport或实现相关接口
 * @author Jie.Yuan
 *
 */
public class UserAction extends ActionSupport {
	
	// 封装请求数据
	private User user;
	
	public UserAction() {
		this.user = new User();
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}

	
	// 重写数据验证的方法(只會驗證  validate 後的方法方法名)
	// 	這裡是手動寫驗證，下一個方法可以用xml寫驗證
	public void validateRegister() {
System.err.println("##########User="+user);
		// 用户名非空
		if (user.getUserName() == null || "".equals(user.getUserName())) {
			// 保存错误信息
			super.addFieldError("userName", "用户名必须填写！");
		}
		// 密码
		if (user.getPwd() == null || "".equals(user.getPwd())) {
			super.addFieldError("pwd", "密码必填");
		}
	}
	
	
	// 业务方法
	public String register() {
System.out.println("##user"+user);
		return SUCCESS;
	}
	
	
	// 列表展示(不用数据效验)
	public String list() {
System.out.println("##list");
		return SUCCESS;
	}
}








