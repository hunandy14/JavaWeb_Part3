package cn.itcast.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.entity.Employee;
import cn.itcast.service.EmployeeService;

public class test {
	private static ApplicationContext ac;
	SessionFactory dataSource = (SessionFactory) ac.getBean("sessionFactory");
	
	
	static {
//		ac = new ClassPathXmlApplicationContext("bean-base.xml");
//		ac = new ClassPathXmlApplicationContext("bean-dao.xml");
//		ac = new ClassPathXmlApplicationContext("bean-service.xml");
		ac = new ClassPathXmlApplicationContext("bean-action.xml");
	}
	
//	@Test
	public void empDao(){
		//開啟事務  (線程版當作全圖攻擊來看)(要開 thread)
		dataSource.getCurrentSession().beginTransaction();
		// 查詢 (因為沒有AOP只好自己開事務)
		EmployeeDao empDao = (EmployeeDao) ac.getBean("employeeDao");
		Employee emp = empDao.findById(1);
		System.err.println(emp);
	}
	
	@Test
	public void employeeService(){
		EmployeeService empSrv = (EmployeeService) ac.getBean("employeeService");
		EmployeeDao empDao = empSrv.getEmployeeDao();

		dataSource.getCurrentSession().beginTransaction();
		Employee emp = empDao.findById(1);
		
		empSrv.findById(1);
		dataSource.getCurrentSession().close();
	}
	
//	@Test
	public void session(){
		Session s = dataSource.openSession();
		s.beginTransaction();
		
		s.getTransaction().commit();
		s.close();
	}
//	@Test
	public void sessionThread(){
		dataSource.getCurrentSession().beginTransaction();

		dataSource.getCurrentSession().close();
	}
}
