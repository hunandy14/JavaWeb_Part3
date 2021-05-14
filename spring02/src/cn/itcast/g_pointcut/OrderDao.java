package cn.itcast.g_pointcut;


/**
 * 目标对象
 * @author Jie.Yuan
 *
 */
public class OrderDao{

	public void save() {
		System.out.println("-----核心业务：保存！！！------");
	}

}
