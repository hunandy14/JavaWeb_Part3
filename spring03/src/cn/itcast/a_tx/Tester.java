package cn.itcast.a_tx;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Tester {
	DeptDao deptDao;
	
	@Test
	public void save(){
		deptDao();
		Dept dept = new Dept("Tester輸入的部門");
		deptDao.save(dept);
	}
		
	@Test
	// 還原 spring 建造的物件
	public void deptDao() {
		// 建立  dataSource
		DataSource dataSource = new_ComboPooledDataSource();
		// 建立 jdbcTemplate
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//建立 Dao
		deptDao = new DeptDao(jdbcTemplate);
	}
	private ComboPooledDataSource new_ComboPooledDataSource(){
		// 伺服器設定值
		String driverClass="com.mysql.jdbc.Driver";
		String jdbcUrl="jdbc:mysql:///hib_demo";
		String user="root";
		String password="root";
		int initialPoolSize=3;
		int maxPoolSize=10;
		int maxStatements=100;
		int acquireIncrement=2;
		// 設置ds
		ComboPooledDataSource ds = new ComboPooledDataSource();
		try {
			ds.setDriverClass(driverClass);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		ds.setJdbcUrl(jdbcUrl);
		ds.setUser(user);
		ds.setPassword(password);
		ds.setInitialPoolSize(initialPoolSize);
		ds.setMaxPoolSize(maxPoolSize);
		ds.setMaxStatements(maxStatements);
		ds.setAcquireIncrement(acquireIncrement);
		return ds;
	}
	

	@Test
	// 範例給的測試拿出來用一下
	public void springJDBC() throws ClassNotFoundException, SQLException{
		Connection con = null;
		Statement stmt = null;
		String sql = "insert into t_dept(deptName) values('test');";
		
		// 連接對象方法1
//	    Class.forName("com.mysql.jdbc.Driver");
//		con = DriverManager.getConnection("jdbc:mysql:///hib_demo", "root", "root");
		// 連接對象方法2
		con = new_DataSource_Spring().getConnection();
		
		// 执行命令对象
		stmt =  con.createStatement();
		// 执行
		stmt.execute(sql);
		
		// 关闭
		stmt.close();
		con.close();
	}
	private DriverManagerDataSource new_DataSource_Spring() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
	    ds.setUrl("jdbc:mysql:///hib_demo");
	    ds.setDriverClassName("com.mysql.jdbc.Driver");
	    ds.setUsername("root");
	    ds.setPassword("root");
		return ds;
	}

	
	@Test
	// 原本的方法 spring 沒包到這些這些
	public void JDBC() throws Exception {
		// 获取连接
		Connection con = new_DataSource().getConnection();
		
		// 查資料庫內容
		String sql = "select * from t_dept";
        QueryRunner qr = new QueryRunner(); //创建核心工具类
        BeanListHandler<Dept> handle = new BeanListHandler<Dept>(Dept.class);
        
        List<Dept> list = qr.query(con, sql, handle); //查询
        for (Dept v : list) { System.out.println(v); }
        
		// 关闭
		con.close();
	}
	private DataSource new_DataSource() {
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
