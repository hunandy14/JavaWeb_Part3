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
		
		Query q1 = session.createQuery("select e.dept, count(*) from Employee e group by e.dept HAVING COUNT(*)>0");
		Query q2 = session.createQuery("select count(*) from Employee e group by e.dept HAVING COUNT(*)>0");
		
		// 取出數據1
		List<Object> queryList1 = q1.list();
		queryList_out(queryList1);
		
		// 取出數據2
		List<Object> queryList2 = q2.list();
		queryList_out(queryList2);
		
		session.getTransaction().commit();
		session.close();
	}

	// 打印由Query查詢所得到的數組的內容
	private void queryList_out(List<Object> queryList) {
	    // 邏輯判斷
	    if (queryList == null) {return;}
	    if (queryList.size() < 1) {return;}
	    // 第二層為陣列
	    if(queryList.get(0) instanceof Object[]){
	        for (int j = 0; j < queryList.size(); j++) {
	            System.err.println("List["+j+"]::");
	            for (Object object : (Object[])queryList.get(j)) {
	                System.err.println("  "+object);
	            }
	        }
	    // 第二層為物件
	    } else if(queryList.get(0) instanceof Object){
	    	int len = queryList.get(0).toString().length();
	    	System.err.println("###Len="+len);
	        System.err.println(queryList);
	    }
	}
	
	// 判斷queryList第二層是否為陣列
	private void queryList_isArray(Object queryObject) {
		// 判斷第二層是陣列還是物件
		if(queryObject instanceof Object[]){
			System.err.println("Object[]");
		} else if(queryObject instanceof Object){
			System.err.println("Object");
		}
	}
}













