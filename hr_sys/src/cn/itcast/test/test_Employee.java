package cn.itcast.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.entity.Employee;
import cn.itcast.service.IEmployeeService;

public class test_Employee {
	// 加載spring物件
	ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
	// 員工
	IEmployeeService empSrv = (IEmployeeService) ac.getBean("employeeService");
	
//	############################## Employee ##############################
	@Test
	public void ServiceEmployee_getall2(){
		String name="chg";
		List<Employee> list = empSrv.getAll(name);
		// 獲取所有員工
		for (int i = 0; i < list.size(); i++) {
			Employee emp = list.get(i);
			System.out.println("list["+i+"]::");
			System.out.println("  "+emp);
		}
	}
	@Test
	public void ServiceEmployee_getall(){
		List<Employee> list = empSrv.getAll();
		// 獲取所有員工
		for (int i = 0; i < list.size(); i++) {
			Employee emp = list.get(i);
			System.out.println("list["+i+"]::");
			System.out.println("  "+emp);
		}
	}
	@Test
	public void ServiceEmployee_findById(){
		// 根據ID查找
		Object obj = empSrv.findById(1);
		System.err.println(obj);
	}
}
