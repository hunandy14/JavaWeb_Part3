package cn.itcast.c_property.MVC;

public class UserAction {
	// Service: 給set才能讓springIOC容器注入userService
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() {
		userService.save();
		return null;
	}
}








