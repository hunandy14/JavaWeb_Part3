package cn.itcast.c_many2many;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App1_save {
	
	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Project.class)   
			.addClass(Developer.class)   // 测试时候使用
			.buildSessionFactory();
	}

	// 1. 多对多，保存  【只能通过一方维护另外一方，不能重复维护！】
	@Test
	public void save() {
		Session session = sf.openSession();
		
		
		/*
		 * 模拟数据： 
			电商系统（曹吉，王春）
			OA系统（王春，老张）
		 */
		// 创建项目对象
		Project prj_ds = new Project();
		prj_ds.setPrj_name("电商系统");
		Project prj_oa = new Project();
		prj_oa.setPrj_name("OA系统");
		
		// 创建员工对象
		Developer dev_cj = new Developer();
		dev_cj.setD_name("曹吉");
		Developer dev_wc = new Developer();
		dev_wc.setD_name("王春");
		Developer dev_lz = new Developer();
		dev_lz.setD_name("老张");
		// 关系 【项目方】
		prj_ds.getDevelopers().add(dev_cj);
		prj_ds.getDevelopers().add(dev_wc); // 电商系统（曹吉，王春）
		prj_oa.getDevelopers().add(dev_wc);
		prj_oa.getDevelopers().add(dev_lz); // OA系统（王春，老张）
		
		
		// 保存
		session.beginTransaction();
//		session.save(dev_cj);
//		session.save(dev_wc);
//		session.save(dev_lz);
		session.save(prj_ds);
		session.save(prj_oa);   // project的休眠文件中的dev標籤
								// 要設置聯集保存前面三行就可以省掉了
		session.getTransaction().commit();
		session.close();
		
		//	測試數據能不從員工方查到所在部門的信息
		queryDeveloper(2);
	}
	
	private Developer queryDeveloper(int idx){
		Developer dev = null;
		Session session = sf.openSession();
		session.beginTransaction();
		
		//	測試數據能不從員工方查到所在部門的信息
		dev = (Developer) session.get(Developer.class, idx);
		session.getTransaction().commit();
		
		// 不知道為什麼在關閉前沒先打印就會報錯，報錯是因為會話被關閉了
		// 反過來為什麼打印可以搞定這件事情，讓dev被有效的傳出去
		System.err.println(dev);
		session.close();
		return dev;
	}
	
	
//	@Test
//	public void bak() {
//		Session session = sf.openSession();
//		session.beginTransaction();
//		
//		session.getTransaction().commit();
//		session.close();
//	}
	
}
