package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import cn.itcast.dao.IEmployeeDao;
import cn.itcast.entity.Employee;

public class EmployeeDao extends BaseDao<Employee> implements IEmployeeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll() {
		String sql = "from Employee";
		Query q = getSessionFactory().getCurrentSession().createQuery(sql);
		List<Employee> list = q.list();
		// 急加載
		for (Employee object : list)
			Hibernate.initialize(object.getDept());
		return list;
	}
	@Override
	public List<Employee> getAll(String employeeName) {
		String sql = "from Employee where empName like ?";
		Query q = getSessionFactory().getCurrentSession().createQuery(sql)
					.setParameter(0, "%" +employeeName + "%");
		List<Employee> list = q.list();
		for (Employee object : list)
			Hibernate.initialize(object.getDept());
		return list;
	}
	
	@Override
	public Employee findById(int id) {
		String hql = "from Employee e left join fetch e.dept where e.id=?";			
		return (Employee) getSessionFactory()
			.getCurrentSession()
			.createQuery(hql)
			.setParameter(0, id)
			.uniqueResult();
	}

}
