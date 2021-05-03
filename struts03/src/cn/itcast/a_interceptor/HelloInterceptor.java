package cn.itcast.a_interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 自定义拦截器
 * @author Jie.Yuan
 *
 */
public class HelloInterceptor implements Interceptor{
	
	// 启动时候执行
	public HelloInterceptor(){
		System.out.println("創建了攔截器對象");
	}

	// 启动时候执行
	@Override
	public void init() {
		System.out.println("執行了攔截器的初始化方法");
	}

	// 拦截器业务处理方法 （在访问action时候执行？ 在execute之前执行？）
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("2. 執行Action之前");
		
		// 调用下一个拦截器或执行Action  (相当于chain.doFilter(..)
		// 获取的是： execute方法的返回值
		String resultFlag = invocation.invoke();
		
		System.out.println("4. 攔截器，業務處理-結束 " + resultFlag);
		
		return resultFlag;
	}
	

	@Override
	public void destroy() {
		System.out.println("销毁....");
	}


}
