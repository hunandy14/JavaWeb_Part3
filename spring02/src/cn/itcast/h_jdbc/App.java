package cn.itcast.h_jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	// 容器对象 把xml裡漫寫的東東都按造規則給建造出來
	ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/h_jdbc/bean.xml");
	
	@Test
	public void testApp() throws Exception {
		// 從xml把剛剛已經創建好的的類給拿出來用
		UserDao ud = (UserDao) ac.getBean("userDao");
//		ud.save();
		System.out.println(ud.findById(1));
		System.out.println(ud.getAll());
	}
}
