package cn.itcast.b_second_cache;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import cn.itcast.utils.QueryList;

public class App {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)   
			.addClass(Employee.class)   // 测试时候使用
			.buildSessionFactory();
	}
	// 1. 测试二级缓存的使用
	// 没有/有用 二级缓存
	@Test
	public void testCache() {
		Session session1 = sf.openSession();
		session1.beginTransaction();
		// a. 查询一次
		Dept dept = (Dept) session1.get(Dept.class, 1);
		dept.getEmps().size();// 集合
		session1.getTransaction().commit();
		session1.close();
		
		System.out.println("------");
		
		// 第二个session
		Session session2 = sf.openSession();
		session2.beginTransaction();
		// b. 查询第二次(二级缓存配置好； 这里還沒出去就茶道緩存有，直接取不查詢數據庫)
		dept = (Dept) session2.get(Dept.class, 1);
		dept.getEmps().size();
		
		session2.getTransaction().commit();
		session2.close();
	}
	
	
	@Test
	public void listCache() {
		Query q = null;
		// HQL查询 
		Session session1 = sf.openSession();
		session1.beginTransaction();
		q = session1.createQuery("from Dept where deptId=1");
		q.setCacheable(true); 			// 【setCacheable  指定从二级缓存找，或者是放入二级缓存】
		QueryList.out(q.list());
		session1.getTransaction().commit();
		session1.close();
		
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		q = session2.createQuery("from Dept where deptId=1");
		q.setCacheable(true);			// 【setCacheable  指定从二级缓存找，或者是放入二级缓存】
		QueryList.out(q.list());	// 不查询数据库： 需要开启查询缓存
		session2.getTransaction().commit();
		session2.close();
	}
}











