package cn.itcast.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import chg.utils.QueryList;
import cn.itcast.dao.DeptDao;
import cn.itcast.entity.Dept;

public class test_basic {
	private static SessionFactory sf;

	static {	// 開啟設定檔並載入物件
		sf = new Configuration()
				.configure("hibernate_test.cfg.xml")
				.addClass(Dept.class)   
				.buildSessionFactory();
	}
	
	
	@Test
	public void dao_modify(){

	}
	
//	@Test
	public void hibernate_modify(){
		// 開啟事務
		Session session = sf.openSession();
		session.beginTransaction();
		
		Dept dept = new Dept(44, "test3333 修改");
		session.update(dept);
				
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void Dept_getAll(){
		// 開啟事務
		Session session = sf.openSession();
		session.beginTransaction();
		
		
		// 查詢全部
		Query q1 = session.createQuery("select d from Dept d");
		
		// 取出數據1
		List<Object> queryList1 = q1.list();
		QueryList.out(queryList1);
		
		
		
		session.getTransaction().commit();
		session.close();
	}
	
//	@Test
	public void fun2(){
		
	}
}
