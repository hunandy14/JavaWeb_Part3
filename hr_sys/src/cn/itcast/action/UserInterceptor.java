package cn.itcast.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 效验用户是否登陆，只有登陆后才可以进行操作。
 * 没有登陆，只能查看列表，不能操作！
 * @author Jie.Yuan
 *
 */
public class UserInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 得到当前执行的方法ㄏ
		String methodName = invocation.getProxy().getMethod();
		// 得到ActionContext对象
		ActionContext ac = invocation.getInvocationContext();
		// 获取session, 从session中获取登陆的管理员账号
		Object obj = ac.getSession().get("adminInfo");
		
		// 判断：(白名單那些能進來)
		if ("login".equals(methodName) || "list".equals(methodName) || "register".equals(methodName)){
			// 允许访问登陆、列表展示
			return invocation.invoke();
		} else { // 被阻擋的時候的特殊條件 
			// 验证 
			if (obj != null){ // (登入成功 session有東西給進)
				// 执行Action
				return invocation.invoke();
			} else {
				// 没有登陆
				return "login";
			}
		}
		
	}

}
