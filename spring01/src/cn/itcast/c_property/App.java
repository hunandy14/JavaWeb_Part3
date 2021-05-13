package cn.itcast.c_property;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.c_property.MVC.User;
import cn.itcast.c_property.MVC.UserAction;

public class App {

	// 创建容器对象
	private ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/c_property/bean.xml");

	@Test
	public void user1() {
		// 从容器中获取
		User user = (User) ac.getBean("user1");
		System.out.println(user);
	}
	@Test
	public void user2() {
		// 从容器中获取
		User user = (User) ac.getBean("user2");
		System.out.println(user);
	}
	
	@Test
	public void testExecuteAction1() {
		// 从容器中获取Action
		UserAction userAction = (UserAction) ac.getBean("userAction1");
		userAction.execute();
	}
	@Test
	public void testExecuteAction2() {
		// 从容器中获取Action
		UserAction userAction = (UserAction) ac.getBean("userAction2");
		userAction.execute();
	}
}





