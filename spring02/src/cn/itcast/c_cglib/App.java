package cn.itcast.c_cglib;

import org.junit.Test;

public class App {
	@Test
	public void main() {
		// 目标对象
		UserDao target = new UserDao();
		// class cn.itcast.c_cglib.UserDao
		System.out.println(target.getClass());
		
		// 代理对象
		UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
		// UserDao子类：class cn.itcast.c_cglib.UserDao$$EnhancerByCGLIB$$25d4aeab
		System.out.println(proxy.getClass());
		
		// 执行代理对象的方法
		proxy.save();
	}
}
