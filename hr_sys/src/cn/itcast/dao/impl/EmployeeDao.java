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
		String sql = "from Employee e left join fetch e.dept";
		Query q = getSessionFactory().getCurrentSession().createQuery(sql);
		List<Employee> list = q.list();
		// 急加載 (原本以為無解結果加上 left join fetch e.dept 就會載進來了)
//		for (Employee object : list)
//			Hibernate.initialize(object.getDept());
		return list;
	}
	@Override
	public List<Employee> getAll(String employeeName) {
		String sql = "from Employee e left join fetch e.dept where empName like ?";
		Query q = getSessionFactory().getCurrentSession().createQuery(sql)
					.setParameter(0, "%" +employeeName + "%");
		List<Employee> list = q.list();
		// 急加載 (原本以為無解結果加上 left join fetch e.dept 就會載進來了)
//		for (Employee object : list)
//			Hibernate.initialize(object.getDept());
		return list;
	}
	@Override
	public Employee findById(int id) {
		String hql = "from Employee e left join fetch e.dept where e.id=?";
		Query q = getSessionFactory().getCurrentSession()
					.createQuery(hql).setParameter(0, id);
		return (Employee) q.uniqueResult();
	}

}
