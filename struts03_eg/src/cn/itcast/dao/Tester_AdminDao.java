package cn.itcast.dao;

import java.util.List;

import org.junit.Test;

import cn.itcast.entity.Admin;

public class Tester_AdminDao {
	@Test
	public void AdminDao(){
		AdminDao dao = new AdminDao();
		
		List<Admin> list = null; 
		list = dao.getAll();
		System.err.println(list);
	}
}
