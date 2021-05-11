package chg.test.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App_hql {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)   
			.addClass(Employee.class)   // 测试时候使用
			.buildSessionFactory();
	}
//	@Test
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
	
	@Test
	public void all() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// f. 分组查询
		//-- 统计t_employee表中，每个部门的人数
		//数据库写法：SELECT dept_id, COUNT(*) FROM t_employee GROUP BY dept_id HAVING COUNT(*)>0;
		// HQL写法
		
		Query q = session.createQuery("select e.dept, count(*) from Employee e group by e.dept HAVING COUNT(*)>0");
		
		// 取出數據
		List<Object[]> queryList = q.list();
		printQueryList(queryList);
		
		session.getTransaction().commit();
		session.close();
	}
	// 打印由Query查詢所得到的數組的內容
	private void printQueryList(List<Object[]> obj_list) {
		for (int j = 0; j < obj_list.size(); j++) {
			System.err.println("List["+j+"]::");
			Object[] obj_item = obj_list.get(j);
			for (int i = 0; i < obj_item.length; i++) {
				Object obj = obj_item[i];
				System.err.println("  "+obj);
			}
		}
	}
}













