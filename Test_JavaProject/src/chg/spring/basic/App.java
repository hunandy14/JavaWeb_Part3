package chg.spring.basic;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chg.spring.basic.entity.Dept;
import chg.spring.basic.service.DeptService;

public class App {

	@Test
	public void testApp() throws Exception {
		//容器对象
		ApplicationContext ac;
		ac = new ClassPathXmlApplicationContext("chg/spring/basic/bean.xml");
		
		DeptService deptService = (DeptService) ac.getBean("deptService");
		
		deptService.save(new Dept("事務回滾測試"));
	}
}
