package chg.hibre;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import chg.entity.Dept;
import chg.entity.Employee;
import chg.utils.QueryList;

public class App_hql {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure("hibernate_basic.cfg.xml")
			.addClass(Dept.class)   
			.addClass(Employee.class)   // 测试时候使用
			.buildSessionFactory();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void hql() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// f. 分组查询
		//-- 统计t_employee表中，每个部门的人数
		//数据库写法：SELECT dept_id, COUNT(*) FROM t_employee GROUP BY dept_id HAVING COUNT(*)>0;
		// HQL写法
		
		String s1="select e.dept, count(*) from Employee e group by e.dept HAVING COUNT(*)>0";
		String s2="select count(*) from Employee e group by e.dept HAVING COUNT(*)>0";
		String s3="select d from Dept d";
		
		Query q = session.createQuery(s3);
		
		// 取出數據1
		List<Object> queryList = q.list();
		QueryList.out(queryList);
		
		session.getTransaction().commit();
		session.close();
	}
	

	@Test
	public void hql2() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, 1);
		System.err.println(dept);
	}

}













