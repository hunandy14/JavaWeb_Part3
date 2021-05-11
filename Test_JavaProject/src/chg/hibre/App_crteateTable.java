package chg.hibre;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import chg.entity.Dept;
import chg.entity.Employee;

public class App_crteateTable {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)   
			.addClass(Employee.class)   // 测试时候使用
			.buildSessionFactory();
	}
	@Test
	public void add() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 新增項目
		Dept dept = new Dept();
		dept.setDeptName("測試部");
		Employee emp = new Employee();
		emp.setEmpName("itcast");
		emp.setSalary(9999);
		emp.setDept(dept);
		
		// 聯集保存要加 休眠表要加 cascade="save-update,delete"
		session.save(emp);
		
		session.getTransaction().commit();
		session.close();
	}
}













