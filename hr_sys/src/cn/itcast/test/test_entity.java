package cn.itcast.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.entity.Employee;
import cn.itcast.entity.Dept;
import cn.itcast.entity.Admin;
import cn.itcast.service.IAdminService;
import cn.itcast.service.impl.AdminService;

@SuppressWarnings("unused")
public class test_entity {
	private static ApplicationContext ac = 
	    new ClassPathXmlApplicationContext
	           (
	               "bean.xml"
	           );
	
	@Test
	public void Service(){
		Admin admin = new Admin("chg", "123");
		
		IAdminService adminService;
		Object obj = ac.getBean("adminService");
		adminService = (IAdminService) obj;
		adminService.login(admin);
	}
//	@Test
	public void Dao(){
		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		Admin admin = new Admin("chg", "123");
		
		
		sessionFactory.getCurrentSession()//
		.createQuery("from Admin where adminName=? and pwd=?")//
		.setString(0, admin.getAdminName())//
		.setString(1, admin.getPwd())//
		.uniqueResult();
	}

//	@Test
	public void entity(){
		getDatabaseObject(Admin.class);
		getDatabaseObject(Dept.class);
		getDatabaseObject(Employee.class);
	}
	
	// 獲取特定物件
	private Object getDatabaseObject(Class<?> clazz, int idx) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		SessionFactory dataSource = (SessionFactory)  ac.getBean("sessionFactory");
		
		Session s = dataSource.openSession();
		s.beginTransaction();
		
		Object obj = s.get(clazz, idx);
		System.err.println(obj);
		
		s.getTransaction().commit();
		s.close();
		return obj;
	}
	private Object getDatabaseObject(Class<?> clazz) {
		return getDatabaseObject(clazz, 1);
	}
}
