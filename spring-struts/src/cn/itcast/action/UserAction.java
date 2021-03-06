package cn.itcast.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.dao.UserDao;
import cn.itcast.service.UserService;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// springIOC容器注入
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String execute() throws Exception {
		System.err.println("spring創建的Dao");
		userService.save();
		return SUCCESS;
	}
	
	public String execute2() throws Exception {
		UserDao userDao = new UserDao();
		userService = new UserService();
		userService.setUserDao(userDao);
		
		System.err.println("手動創建的Dao");
		userService.save();
		return SUCCESS;
	}
}








