package cn.itcast.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	@Test
	public void Emp(){
		ApplicationContext ac;
		ac = new ClassPathXmlApplicationContext("bean-base.xml");
//		ac = new ClassPathXmlApplicationContext("bean-dao.xml");
		
	}

}
