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
			.configure()
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
		
		Query q1 = session.createQuery("select e.dept, count(*) from Employee e group by e.dept HAVING COUNT(*)>0");
		Query q2 = session.createQuery("select count(*) from Employee e group by e.dept HAVING COUNT(*)>0");
		
		// 取出數據1
		List<Object> queryList1 = q1.list();
		QueryList.out(queryList1);
		
		// 取出數據2
		List<Object> queryList2 = q2.list();
		QueryList.out(queryList2);
		
		session.getTransaction().commit();
		session.close();
	}


}













