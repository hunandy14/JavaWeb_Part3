package cn.itcast.d_myaop1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	ApplicationContext ac = 
		new ClassPathXmlApplicationContext("cn/itcast/d_myaop1/bean.xml");

	@Test
	public void testApp1() {
		System.err.println("沒有代理只有核心代碼");
		IUserDao userDao1 = (IUserDao) ac.getBean("userDao");
		userDao1.save();
	}
	
	@Test
	public void testApp2() {
		IUserDao userDao = (IUserDao) ac.getBean("userDao_proxy");
		System.out.println(userDao.getClass());
		userDao.save();
	}
}
