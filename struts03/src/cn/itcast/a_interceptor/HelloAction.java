package cn.itcast.a_interceptor;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action开发测试
 * @author Jie.Yuan
 *
 */
public class HelloAction extends ActionSupport{

	public HelloAction() {
		System.out.println("1. Action實力創建了");
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("3. 執行了請求處理的方法: execute");
		return super.execute();
	}
}
