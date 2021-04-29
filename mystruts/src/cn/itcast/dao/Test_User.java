package cn.itcast.dao;

import org.junit.Test;

import cn.itcast.entity.User;

public class Test_User {
	@Test
	public void Test_user(){
		User u = new User("tom", "888");
		UserDao ud = new UserDao();
		
		User u2 = ud.login(u);
		System.err.println("u2=" + u2);
	}
}
