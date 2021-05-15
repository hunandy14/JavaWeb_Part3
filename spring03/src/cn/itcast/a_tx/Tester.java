package cn.itcast.a_tx;

import java.sql.Connection;
import java.util.List;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

public class Tester {
	private DataSource dataSource;

	
	@Test
	public void testDbcp() throws Exception {
		// 設置dataSource - 連接到資料庫
		dataSource = newDataSource();
		
		// 获取连接
		Connection con = dataSource.getConnection();
		
		// 查資料庫內容
		String sql = "select * from t_dept";
        QueryRunner qr = new QueryRunner(); //创建核心工具类
        BeanListHandler<Dept> handle = new BeanListHandler<Dept>(Dept.class);
        
        List<Dept> list = qr.query(con, sql, handle); //查询
        for (Dept v : list) { System.out.println(v); }
        
		// 关闭
		con.close();
	}





	@Test
	public void JDBC(){
//		String sql = "insert into t_dept(deptName) values('test');";
//		Connection con = null;
//		Statement stmt = null;
//		Class.forName("com.mysql.jdbc.Driver");
//		// 连接对象
//		con = DriverManager.getConnection("jdbc:mysql:///hib_demo", "root", "root");
//		// 执行命令对象
//		stmt =  con.createStatement();
//		// 执行
//		stmt.execute(sql);
//		
//		// 关闭
//		stmt.close();
//		con.close();
	}
	@Test
	public void DeptDao(){
		
	}
	
	
	private DataSource newDataSource() {
		// DBCP连接池核心类
		BasicDataSource ds = new BasicDataSource();		
		// 连接池参数配置：初始化连接数、最大连接数 / 连接字符串、驱动、用户、密码
		ds.setUrl("jdbc:mysql:///hib_demo");			//数据库连接字符串
		ds.setDriverClassName("com.mysql.jdbc.Driver");  //数据库驱动
		ds.setUsername("root");							//数据库连接用户
		ds.setPassword("root"); 							//数据库连接密码
		ds.setInitialSize(3);  // 初始化连接
		ds.setMaxActive(6);	  // 最大连接
		ds.setMaxIdle(3000);   // 最大空闲时间
		return ds;
	}
}
