package cn.itcast.b_ognl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * struts的数据流转
 * @author Jie.Yuan
 *
 */
public class OgnlDemo2 extends ActionSupport{
	
	// 根元素值
    private User user = new User(100,"Jacks");
    
    public User getUser() {
		return user;
	}
    public void setUser(User user) {
		this.user = user;
	}
	
	
	public String execute2() throws Exception {
System.err.println("## 進入 od2 execute2() 方法");

		ActionContext ac = ActionContext.getContext();
		// 映射数据 (這個可以不用 attr可以直接叫到)
		ac.getContextMap().put("request_data", "[request_data]");
		// 数据存储request
		Map<String,Object> map = (Map<String, Object>) ac.get("request");
		map.put("map_request_data", "[request_data2]");
		map.put("map_cn", "[China]");
		
		ac.getSession().put("Session_data", "[Session_data]");
		ac.getApplication().put("Application_data", "[Application_data]");
		
		
		// 二、值栈对象的存储数据的原理
		ValueStack vs = ac.getValueStack();
		/***************操作根元素的几种方法*****************/
		// 设置数据: 入栈
//		vs.push(new User(1002,"Tom"));	// 栈顶
//		vs.pop();						// 移除栈顶元素
		
		// 如何存储？  map结构存储  
//		vs.set("user1", new User(1,"Jacky1"));
//		vs.set("user2", new User(2,"Jacky2"));
		
		return super.execute();
	}
	
	public String execute3() throws Exception {
System.err.println("## 進入 od2 execute3() 方法");

		// 获取值栈对象，方式1：
		HttpServletRequest request = ServletActionContext.getRequest();
		ValueStack vs1 = (ValueStack) request.getAttribute("struts.valueStack");
		
		// 获取值栈对象，方式2： 
		ActionContext ac = ActionContext.getContext();
		ValueStack vs2 = ac.getValueStack();
		
		System.out.println("ServletActionContext.getRequest() " +
				"是否等於  ActionContext.getContext() ---" + (vs1 == vs2));//true
		
		return super.execute();
	}
}














