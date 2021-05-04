package cn.itcast.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import cn.itcast.entity.Admin;
import cn.itcast.utils.JdbcUtils;

public class Tester_Dao {
	AdminDao dao = new AdminDao();
	Admin admin = new Admin();
	public Tester_Dao() {
		JdbcUtils.getQuerrRunner();
	}
	
	@Test
	public void AdminDao(){
		List<Admin> list = null; 
		list = dao.getAll();
		System.err.println(list);
	}
	@Test
	public void AdminDao2(){
		Admin ad = new Admin(1, "eric", "123456");
		System.err.println("### 輸入的使用者帳密" + ad);
		
		Admin ad2 = dao.login(ad);
		System.err.println("### 驗證後的使用者" + ad2);
	}
}
