package cn.itcast.dao;

import java.util.List;

import org.junit.Test;

import cn.itcast.dao.impl.EmployeeDao;
import cn.itcast.entity.Employee;

public class Tester_Dao {
	private IEmployeeDao employeeDao = new EmployeeDao();
	@Test
	public void EmployeeDao(){
		// 獲取全部
		List<Employee> list = employeeDao.getAll();
		System.err.println(list);
		
		// ID查找
		Employee emp = employeeDao.findById(1);
		System.err.println(emp);
	}
	@Test
	public void EmployeeDao_add(){
		// 新增員工
		Employee emp = new Employee(2, "yuyu", "1999-01-01");
		
		// 新增
//		employeeDao.save(emp);
	}
	@Test
	public void EmployeeDao_update(){
		// 以編號為主去查詢
		int idx = 2;
		// 員工資料
		Employee emp = new Employee(idx, "yuyu2", "1999-02-02");
		
		// 新增員工
//		employeeDao.update(emp);
	}
}
