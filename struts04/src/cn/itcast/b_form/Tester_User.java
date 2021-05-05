package cn.itcast.b_form;

import org.junit.Test;

public class Tester_User {
	@Test
	public void user(){
		User user = new User("Jack", "123456", "yuanjie@itcast.cn", "1990-01-01");		
		System.out.println(user);
	}
}
