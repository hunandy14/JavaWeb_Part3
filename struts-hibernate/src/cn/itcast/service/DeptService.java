package cn.itcast.service;

import cn.itcast.dao.DeptDao;
import cn.itcast.entity.Dept;

public class DeptService {

	// 调用的dao
	private DeptDao deptDao  = new DeptDao();
	
	public Dept findById(int id){
		return deptDao.findById(id);
	}
}
