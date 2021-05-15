package cn.itcast.b_anno;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	@Test
	public void testApp() throws Exception {
		//容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/b_anno/bean.xml");
		
		// 模拟数据
		Dept dept = new Dept();
		dept.setDeptName("测试： 开发部");
		
		DeptService deptService = (DeptService) ac.getBean("deptService");
		deptService.save(dept);
	}
	
	// 了解容器的相关方法
	@Test
	public void testApp2() throws Exception {
		ApplicationContext ac;
		DeptDao deptDao;
		//1. 根据bean.xml配置路径，创建容器对象
//		ac = new ClassPathXmlApplicationContext("cn/itcast/b_anno/bean.xml");

		
		//2. 根据多个配置文件的路径，创建容器对象
		String[] xmls = new String[]{
				"cn/itcast/b_anno/bean.xml", "cn/itcast/a_tx/bean.xml"};
//		ac = new ClassPathXmlApplicationContext(xmls);
		
		
		
		//3.  容器对象相关方法
		ac = new ClassPathXmlApplicationContext("cn/itcast/b_anno/bean.xml");
		//3.1 从容器中获取指定名称的bean对象
//		deptDao = (DeptDao) ac.getBean("deptDao");
		//3.2 根据类型从容器获取实例 【改类型只能在IOC中有唯一的对象，否则报错】
//		deptDao = ac.getBean(DeptDao.class);
		//3.3 泛型，不需要强转
//		deptDao = ac.getBean("deptDao", DeptDao.class);
		//3.4 获取容器中bean对象的数量
		int count = ac.getBeanDefinitionCount();
		System.out.println(count);
		
		String[] names = ac.getBeanDefinitionNames();
		System.out.println(Arrays.toString(names));
	}
}











