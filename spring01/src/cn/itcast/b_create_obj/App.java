package cn.itcast.b_create_obj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private static ApplicationContext ac;
	static {
		// 创建IOC容器对象
		System.err.println("####################################################");
		ac = new ClassPathXmlApplicationContext("cn/itcast/b_create_obj/bean.xml");		
		System.err.println("####################################################");
	}

	
	@Test
	public void user1() throws Exception {
		System.err.println("無默認參數建構子::");
		User user = (User) ac.getBean("user1");
		System.out.println("  "+user);
	}
	// 测试：对象创建
	@Test
	public void user2() throws Exception {
		System.err.println("有建構參數建構子由xml設置初值::");
		User user = (User) ac.getBean("user2");
		System.out.println("  "+user);
	}
	// 测试：对象创建
	@Test
	public void user3() throws Exception {
		System.err.println("由xml定義字串，並把字串賦值到user::");
		User user = (User) ac.getBean("user3");
		System.out.println("  "+user);
	}
	// 测试：对象创建
	@Test
	public void user4() throws Exception {
		System.err.println("呼叫工廠非靜待函數構造::");
		User user = (User) ac.getBean("user4");
		System.out.println("  "+user);
	}
	
	
	// 测试: 容器中对象的写法
	@Test
	public void testObj() throws Exception {
		System.err.println("呼叫工廠靜態函數構造::");
		User user = (User) ac.getBean("user5");
		System.out.println("  "+user);
	}
}









