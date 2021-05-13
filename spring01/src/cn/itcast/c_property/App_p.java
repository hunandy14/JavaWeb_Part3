package cn.itcast.c_property;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.c_property.MVC.User;
import cn.itcast.c_property.MVC.UserAction;

public class App_p {

	// 创建容器对象
	private ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/c_property/bean_p.xml");

	
	@Test
	public void testExecuteAction() {
		// 从容器中获取Action
		UserAction userAction = (UserAction) ac.getBean("userAction");
		userAction.execute();
		// 從容器中取User
		User user = (User) ac.getBean("user");
		System.out.println(user);
	}
}





