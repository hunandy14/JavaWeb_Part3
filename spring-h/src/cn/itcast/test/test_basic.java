package cn.itcast.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import chg.utils.QueryList;

public class test_basic {
	private static SessionFactory sf;
	@Test
	public void Dept(){
		Session session = sf.openSession();
//		session.beginTransaction();
		
		// f. 分组查询
		//-- 统计t_employee表中，每个部门的人数
		//数据库写法：SELECT dept_id, COUNT(*) FROM t_employee GROUP BY dept_id HAVING COUNT(*)>0;
		// HQL写法
		
//		Query q1 = session.createQuery("select d from t_dept d");
		
		// 取出數據1
//		List<Object> queryList1 = q1.list();
//		QueryList.out(queryList1);
		
//		session.getTransaction().commit();
//		session.close();
	}
	
	@Test
	public void fun2(){
		
	}
}
