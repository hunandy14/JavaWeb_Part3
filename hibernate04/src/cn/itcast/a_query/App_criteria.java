package cn.itcast.a_query;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.itcast.utils.QueryList;

public class App_criteria {
	
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
		dept.setDeptName("财务部");
		Employee emp = new Employee();
		emp.setEmpName("itcast");
		emp.setSalary(9999);
		emp.setDept(dept);
		
		// 聯集保存要加 休眠表要加 cascade="save-update,delete"
		session.save(emp);
		
		session.getTransaction().commit();
		session.close();
	}

	/*
	 *  1)	Get/load主键查询
		2)	对象导航查询
		3)	HQL查询，  Hibernate Query language  hibernate 提供的面向对象的查询语言。
		4)	Criteria 查询，   完全面向对象的查询（Query By Criteria  ,QBC）
		5)	SQLQuery， 本地SQL查询
	 */
	
	//4)	Criteria 查询，
	@SuppressWarnings("unchecked")
	@Test
	public void criteria() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Employee.class);
		// 构建条件
		criteria.add(Restrictions.eq("empId", 1));
//		criteria.add(Restrictions.idEq(12));  // 主键查询
		
		QueryList.out(criteria.list());
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	// 5)	SQLQuery， 本地SQL查询
	// 不能跨数据库平台： 如果该了数据库，sql语句有肯能要改。
	@SuppressWarnings("unchecked")
	@Test
	public void sql() {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		SQLQuery q = session.createSQLQuery("SELECT * FROM t_Dept limit 5;")
			.addEntity(Dept.class);  // 也可以自动封装
		
		QueryList.out(q.list());
		
		session.getTransaction().commit();
		session.close();
	}
}











