package cn.itcast.action;

import java.util.Map;

import cn.itcast.entity.Admin;
import cn.itcast.service.IAdminService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 管理员登陆注册模块
 * 1. 登陆
 * @author Jie.Yuan
 *
 */
// http://127.0.0.1:8081/hr_sys/admin_login
public class AdminAction extends ActionSupport implements ModelDriven<Admin> {

	private static final long serialVersionUID = 1L;
	
	// 封装请求数据
	private Admin admin = new Admin();
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Admin getAdmin() {
		return admin;
	}
	
	@Override
	public Admin getModel() {
		return admin;
	}
	
	// 调用Service
	private IAdminService adminService;
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	
	/**
	 * 註冊
	 */
	
	public String register2(){
		System.err.println("#######進入register()");
		// 登陆验证
		Admin adminInfo = adminService.login(admin);
		// 验证有無重複帳號
		if (adminInfo == null){
			// 登陆失败
			return "regNewUser";
		} else {
			// 有重複帳號
			ActionContext.getContext().getSession().put("adminInfo", adminInfo);
			return "regFaild";
		}
	}
	/**
	 * 註冊帳號
	 */
	public String register(){
System.out.println("#######進入register()");
		// 登陆验证是否存在
		Admin adminInfo = adminService.login(admin);
		
		// 验证
		if (adminInfo == null){
			System.err.println("###註冊成功");
			adminService.register(admin);
			ActionContext.getContext().getSession().put("regInfo", "註冊成功");
			return "regNewUser";
		} else {
			System.err.println("###註冊失敗(帳號已經存在)");
			ActionContext.getContext().getSession().put("regInfo", "帳號已經存在");
			
			// 数据回显
			ActionContext.getContext().getContextMap().put("regInfoReqset", "帳號已經存在");
			
			ActionContext.getContext();
			System.err.println("註冊失敗");
			return "regFaild";
		}
	}
	
	/**
	 * 登陆
	 */
	public String login(){
		System.err.println("#######進入 login()");
		// 登陆验证
		Admin adminInfo = adminService.login(admin);
		// 验证
		if (adminInfo == null){
			System.err.println("################# 登陸失敗");
			// 登陆失败
			return "loginFaild";
		} else {
			// 登陆成功, 保存数据到session
			ActionContext.getContext().getSession().put("adminInfo", adminInfo);
			return "index";
		}
	}

}
