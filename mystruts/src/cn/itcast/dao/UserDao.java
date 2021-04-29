package cn.itcast.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.entity.Id;
import cn.itcast.entity.User;
import cn.itcast.utils.JdbcUtils;


public class UserDao {

	// 模拟登陆
	public User login(User user){
		if ("tom".equals(user.getName()) && "888".equals(user.getPwd()) ){
			// 登陆成功
			return user;
		}
		// 登陆失败
		return null;
	}
	public User login_database(User user){
		Id id = null;
		String name = user.getName();
		String pwd  = user.getPwd();
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
		
		if (id!=null ){
			// 登陆成功
			return user;
		}
		// 登陆失败
		return null;
	}
	
	// 模拟注册
	public void register(User user) {
		System.out.println("注册成功：用户，" + user.getName());
	}
}
