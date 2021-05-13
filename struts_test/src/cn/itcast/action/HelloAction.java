package cn.itcast.action;

import com.opensymphony.xwork2.ActionSupport;

// 开发action： 处理请求
public class HelloAction extends ActionSupport {
	
	// 处理请求
	public String execute() throws Exception {
		System.out.println("訪問到了action，正在處理請求");
		System.out.println("調用service");
		return "success";
	}
}
