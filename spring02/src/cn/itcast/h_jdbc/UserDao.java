package cn.itcast.h_jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDao {
	
	// IOC容器注入  [這個可以整合到jdbcTemplate裡面
	//           而這個初始化後就用不到了，乾脆給spring xml內管理就不用取出來鬧事] 
//	private DataSource dataSource;
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	
	/*
	1. 由xml創建DataSource (因為這個只會用一次就不寫到類裡了直接丟給xml託管)
	2. 由xml創建jdbcTemplate並把剛剛的DataSource經由set丟進jdbcTemplate裡
	3. 由xml創建UserDao並經由底下的set把jdbcTemplate都進來
	4. app.java要用的時候從xml取出來，直接用
	*/
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	public void save() {
		String sql = "insert into t_dept(deptName) values('test');";
		jdbcTemplate.update(sql);
	}
	
	public Dept findById(int id) {
		String sql = "select * from t_dept where deptId=?";

		// 雖然只有拿到一個紀錄，但是通用的關係所以適用List返回，只好再自己取出來
		List<Dept> list = jdbcTemplate.query(sql,new MyResult(), id);
		Dept dept1 = (list!=null && list.size()>0) ? list.get(0) : null;
		
		return dept1;
	}
	
	public List<Dept> getAll() {
		String sql = "select * from t_dept";
		List<Dept> list = jdbcTemplate.query(sql, new MyResult());
		return list;
	}
	
	
	
	/* 
	因為沒有hibernate才會搞到只好自己封裝，手動造Dao
	這是再類內的一個類，實現了RowMapper<Dept>類別
	要建造List的時候把這個方法直接往函式裡面丟，函式就可以丟List出來了
	*/
	class MyResult implements RowMapper<Dept>{

		// 如何封装一行记录
		@Override
		public Dept mapRow(ResultSet rs, int index) throws SQLException {
			Dept dept = new Dept();
			dept.setDeptId(rs.getInt("deptId"));
			dept.setDeptName(rs.getString("deptName"));
			return dept;
		}
		
	}
}







