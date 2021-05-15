package cn.itcast.b_anno;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service
 * @author Jie.Yuan
 *
 */
@Service
public class DeptService {
	
	// 部门dao
	@Resource
	private DeptDao deptDao;
	
	// 日志dao
	@Resource
	private LogDao logDao;

	/*
	 * 事务控制？
	 */
	@Transactional(
			readOnly = false,  // 读写事务
			timeout = -1,       // 事务的超时时间不限制
			//noRollbackFor = ArithmeticException.class,  // 遇到数学异常不回滚
			isolation = Isolation.DEFAULT,              // 事务的隔离级别，数据库的默认
			propagation = Propagation.REQUIRED			// 事务的传播行为
	)
	public void save(Dept dept){
		// 保存日志  【自己开启一个事务】 才不會被事務一起回滾了
		// 因為標籤事務只能整塊函式都事務，不能選擇從哪一行開始，就自己再開一個事務就可以脫離控制了
		logDao.insertLog();
		int i = 1;
		i = i/0;
		deptDao.save(dept);  // 保存部门
	}
}





