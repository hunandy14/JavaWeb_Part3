package cn.itcast.a_hello;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App2 {
	
	private static SessionFactory sf;
	static  {
		/*
		//1. 创建配置管理类对象
		Configuration config = new Configuration();
		// 加载配置文件  (默认加载src/hibernate.cfg.xml)
		config.configure();
		//2. 根据加载的配置管理类对象，创建SessionFactory对象
		sf = config.buildSessionFactory();
		*/
		
		// 创建sf对象
		sf = new Configuration().configure().buildSessionFactory();
	}

	//1. 保存对象
	@Test
	public void testSave() throws Exception {
		// 对象
		Employee emp = new Employee();
		emp.setEmpName("张三123");
		emp.setWorkDate(new Date());
		
		//根据session的工厂，创建session对象
		Session session = sf.openSession();
		// 开启事务
		Transaction tx = session.beginTransaction();
		//-----执行操作-----
		session.save(emp);
		
		// 提交事务/ 关闭
		tx.commit();
		session.close();
	}
	
	
	//更新
	@Test
	public void testUpdate() throws Exception {
		// 对象
		Employee emp = new Employee();
		emp.setEmpId(1);
		emp.setEmpName("chg");
		
		// 创建session
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		//-------执行操作-------
		// 没有设置主键? 执行保存:执行更新操作; 如果设置主键但主键不存在不存在則报错！
		session.saveOrUpdate(emp);
		
		tx.commit();
		session.close();
	}
}












