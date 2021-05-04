package cn.itcast.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.IEmployeeDao;
import cn.itcast.dao.impl.EmployeeDao;
import cn.itcast.entity.Employee;
import cn.itcast.service.IEmployeeService;
import cn.itcast.utils.JdbcUtils;

public class EmployeeService implements IEmployeeService{
	
	private IEmployeeDao employeeDao = new EmployeeDao();

	@Override
	public Employee findById(int id) {
		try {
			return employeeDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Employee> getAll() {
		try {
			return employeeDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(Employee emp) {
		try {
			employeeDao.save(emp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void update(Employee emp) {
		try {
			employeeDao.update(emp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}

}
