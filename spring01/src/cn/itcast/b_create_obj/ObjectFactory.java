package cn.itcast.b_create_obj;

// 工厂，创建对象
public class ObjectFactory {

	// 实例方法创建对象
	public User getInstance() {
		return new User(100,"工厂：调用实例方法0");
	}
	
	// 静态方法创建对象(帶static的函式)
	public static User getStaticInstance() {
		return new User(101,"工厂：调用静态方法1");
	}
}
