package cn.itcast.Tester;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(User.class)   // 测试时候使用
			.buildSessionFactory();
	}

	//1. 对象状态的转换
	@Test
	public void testSaveSet() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setUserName("Jack22222");
		session.save(user);		
		
		session.getTransaction().commit();
		session.close();
		
		System.err.println(user);
	}
	
	
	@Test
	public void bak() throws Exception {
		Session session = sf.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
	}
}










