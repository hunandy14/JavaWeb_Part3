package cn.itcast.b_form;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 1. 数据回显
 * 2. 模型驱动
 * @author Jie.Yuan
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	// 封装请求数据
	private User user = new User();
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	
	// 实现模型驱动接口方法
	@Override
	public User getModel() {
		return user;
	}
	
	
	public String add() {
		// 测试： 使用了模型驱动，是否数据正常？ Ok
System.out.println("## 進入add()方法" + user);
		return "success";
	}
	
	
	// 进入修改页面
	public String viewUpdate() {
		// 模拟一个对象(先获取一个id，再根据id调用service查询，把查到的结果保存到域)
		User userInfo = new User("Jack", "123456", "yuanjie@itcast.cn", "1990-01-01");
System.out.println("####################### 進入viewUpdate()方法" + userInfo);
		
		ActionContext ac = ActionContext.getContext();
		/*************数据回显非成員變數***************/
//		Map<String,Object> request = (Map<String, Object>) ac.get("request");
//		request.put("userInfo", userInfo);
		
		/************* 数据回显成員變數***************/
		// 获取值栈(把userInfo推進成員變數裡面)
		ValueStack vs = ac.getValueStack();
		vs.pop();// 移除栈顶元素
		vs.push(userInfo);  // 入栈
		
		// 进入修改页面
		return "viewUpdate";
	}
	
	// 业务方法
    //	http://localhost:8081/struts04/user2_index
	public String index() {
		// 保存数据到request域
		ActionContext ac = ActionContext.getContext();
		@SuppressWarnings("unchecked")
		Map<String,Object> request = (Map<String, Object>) ac.get("request");
		request.put("cn", "China");
		
		return SUCCESS;
	}
}








