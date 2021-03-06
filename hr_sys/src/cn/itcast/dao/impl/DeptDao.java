package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import cn.itcast.dao.IDeptDao;
import cn.itcast.entity.Dept;

public class DeptDao implements IDeptDao {
	
	// 容器注入
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Dept findById(int id) {
//		return this.findById(id);
		return (Dept) sessionFactory.getCurrentSession().get(Dept.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> getAll() {
//		return this.getAll();
		return sessionFactory.getCurrentSession().createQuery("from Dept").list();
	}

}
