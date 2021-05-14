package cn.itcast.a_static;

import org.junit.Test;

public class App {
	@Test
	public void main() {
		// 目标对象
		IUserDao target = new UserDao();
		
		// 代理
		IUserDao proxy = new UserDaoProxy(target);
		proxy.save();  // 执行的是，代理的方法
	}
}
