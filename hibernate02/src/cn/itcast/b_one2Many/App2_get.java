package cn.itcast.b_one2Many;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App2_get {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)   
			.addClass(Employee.class)   // 测试时候使用
			.buildSessionFactory();
	}

	@Test
	public void get() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
//		 通过部门方，获取另外一方
//		Dept dept = (Dept) session.get(Dept.class, 1);
//		System.out.println(dept.getDeptName());
//		System.err.println(dept.getEmps());// 懒加载
		
		
		// 通过员工房，获取另外一方
		Employee emp = (Employee) session.get(Employee.class, 1);
//		System.out.println(emp.getEmpName());
//		System.out.println(emp.getDept().getDeptName());
		System.err.println(emp);
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void print(){
//		Dept dept = new Dept();
//		System.err.println(dept);
//		
//		Employee emp = new Employee();
//		System.err.println(emp);
	}
}
