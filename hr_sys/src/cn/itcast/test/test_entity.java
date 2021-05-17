package cn.itcast.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.entity.Employee;
import cn.itcast.entity.Dept;
import cn.itcast.entity.Admin;
import cn.itcast.service.IAdminService;
import cn.itcast.service.IDeptService;
import cn.itcast.service.IEmployeeService;
import cn.itcast.service.impl.AdminService;

@SuppressWarnings("unused")
public class test_entity {
	private static ApplicationContext ac = 
	    new ClassPathXmlApplicationContext
	           (
	               "bean.xml"
	           );
	// 管理員
	IAdminService admSrv = (IAdminService) ac.getBean("adminService");
	// 員工
	IEmployeeService empSrv = (IEmployeeService) ac.getBean("employeeService");
	// 部門
	IDeptService deptSrv = (IDeptService) ac.getBean("deptService");
	
	

	
//	############################## Employee ##############################	
	@Test
	public void ServiceEmployee_(){
		
	}
//	@Test
	public void ServiceEmployee_getall2(){
		String name="chg";
		List<Employee> list = empSrv.getAll(name);
		// 獲取所有員工
		for (int i = 0; i < list.size(); i++) {
			Employee emp = list.get(i);
			System.err.println("list["+i+"]::");
			System.err.println("  "+emp.toSimpleString());
		}
	}
	
	@Test
	public void ServiceEmployee_getall(){
		List<Employee> list = empSrv.getAll();
		
		// 獲取所有員工
		for (int i = 0; i < list.size(); i++) {
			Employee emp = list.get(i);
			System.err.println("list["+i+"]::");
			System.err.println("  "+emp.toSimpleString());
		}
	}
//	@Test
	public void ServiceEmployee_findById(){
		// 根據ID查找
		Object obj = empSrv.findById(1);
		System.err.println(obj);
	}
//	############################## Dept ##############################	
//	@Test
	public void ServiceDept(){
		List<?> list = deptSrv.getAll();
		// 獲取全部
		for (int i = 0; i < list.size(); i++) {
			Object emp = list.get(i);
			System.err.println("list["+i+"]:: \n" + emp);
		}
		
		// 獲取特定ID
		Object obj = deptSrv.findById(1);
		System.err.println(obj);
	}
//	############################## Admin ##############################	
//	@Test
	public void ServiceAdmin(){
		Object obj = admSrv.login(new Admin("chg", "123"));
		System.err.println(obj);
	}
//  ############################## 物件測試  ##############################
	@Test
	public void entity(){
		getDatabaseObject(Admin.class);
//		getDatabaseObject(Dept.class);
//		getDatabaseObject(Employee.class);
	}
	// 獲取特定物件
	private Object getDatabaseObject(Class<?> clazz) {
		int idx = 1;
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		SessionFactory dataSource = (SessionFactory)  ac.getBean("sessionFactory");
		String sql = "select e from Employee e";
		
		Session s = dataSource.openSession();
		s.beginTransaction();
		
		// 急加載
		Query q =  s.createQuery(sql);
		for (Object object : q.list())
			Hibernate.initialize(((Employee)object).getDept());
		
		Object obj = s.get(clazz, idx);
		System.err.println(obj);
		
		s.getTransaction().commit();
		s.close();
		
		// 急加載的測試
//		queryList_out( list );
		
		return obj;
	}
	// 打印由Query查詢所得到的數組的內容
	private <T> void queryList_out(List<T> queryList) {
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
	        if (queryList.get(0).toString().length() > 16){
	            for (int j = 0; j < queryList.size(); j++) {
	                System.err.println("List["+j+"]::");
	                System.err.println("  "+queryList.get(j));
	            }
	        } else {
	            System.err.println(queryList);
	        }
	    }
	}
}
