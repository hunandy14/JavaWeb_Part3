package cn.itcast.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import cn.itcast.entity.Id;
import cn.itcast.entity.User;
import cn.itcast.utils.JdbcUtils;

public class Test_User {
	@Test
	public void Test_user(){
		User u = new User("tom", "888");
		UserDao ud = new UserDao();
		
		User u2 = ud.login(u);
		System.err.println("u2=" + u2);
	}
	@Test
	public void Tester_quser(){
		Id id = null;
		String name="chg";
		String pwd="123";
		try {
			String sql = "SELECT admin.id FROM admin WHERE userName=? AND pwd=?";
			id = JdbcUtils.getQueryRuner()//
					.query(sql, 
							new BeanHandler<Id>(Id.class),
							name, //第一個問號
							pwd); //第二個問號
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		if(id!=null){
			System.err.println("登入成功有這個帳號"+id);
		}
	}
}
