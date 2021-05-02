package cn.itcast.c_data;

import java.util.Map;

import javax.servlet.ServletContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 数据处理
 * @author Jie.Yuan
 *
 */
public class DataAction_bak extends ActionSupport{
	


	@Override
	public String execute() throws Exception {
		
		// 1. 请求数据封装； 2. 调用Service处理业务逻辑，拿到结果数据
		
		// 3. 数据保存到域中
		
		
// 方式1
		// Struts中对数据操作，方式1： 直接拿到ServletApi, 执行操作
//		HttpServletRequest request = ServletActionContext.getRequest();
//		HttpSession session = request.getSession();
//		ServletContext application = ServletActionContext.getServletContext();
		// 操作
//		request.setAttribute("request_data", "request_data1");
//		session.setAttribute("session_data", "session_data1");
//		application.setAttribute("application_data", "application_data1");
		
		
		
// 方式2 (但是就拿不到基礎屬性了，webPath路徑之類的拿不到)
		// 【推荐：解耦的方式实现对数据的操作】
		// Struts中对数据操作，方式2： 通过ActionContext类 
		ActionContext ac = ActionContext.getContext();
		// 得到Struts对HttpServletRequest对象进行了封装，封装为一个map
		// 拿到表示request对象的map
	 	Map<String,Object> request =  ac.getContextMap(); 
	 	// 拿到表示session对象的map
	 	Map<String, Object> session = ac.getSession();
	 	// 拿到表示servletContext对象的map
	 	Map<String, Object> application = ac.getApplication();
	 	
	 	// 数据
	 	request.put("request_data", "request_data1_actionContext");
		session.put("session_data", "session_data1_actionContext");
		application.put("application_data", "application_data1_actionContext");
		
		return SUCCESS;
	}
}








