package cn.itcast.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.action.UserAction;
import cn.itcast.dao.UserDao;
import cn.itcast.service.UserService;

public class Teser {
	private static ApplicationContext ac_dao;
	private static ApplicationContext ac_srv;
	private static ApplicationContext ac_act;
	
	private static UserDao ud = new UserDao();
	private static UserService us = new UserService();
	
	@Test
	public void service(){
		us.setUserDao(ud);
		us.save();
	}

	@Test
	public void spring_dao(){
		ac_dao = new ClassPathXmlApplicationContext("bean-action.xml");
		ud = (UserDao) ac_dao.getBean("userDao");
		ud.save();
	}
	@Test
	public void spring_service(){
		ac_srv = new ClassPathXmlApplicationContext("bean-action.xml");
		us = (UserService) ac_srv.getBean("userService");
		us.save();
	}
	
	@Test
	public void spring_action(){
		ac_act = new ClassPathXmlApplicationContext("bean-action.xml");
		UserAction ua = (UserAction) ac_act.getBean("userAction");
		try {
			ua.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
