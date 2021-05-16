package cn.itcast.action;

import java.util.Map;

import cn.itcast.entity.Employee;
import cn.itcast.service.EmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

// ########## 沒帶.action不能啟動 ############
// http://127.0.0.1:8081/ssh/show.action
// ######################################
public class EmployeeAction extends ActionSupport{
	
	// IOC容器注入
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	@Override
	public String execute(){
		int empid = 2;
		// 调用Service
		Employee emp = new Employee("Test123321");
		emp = employeeService.findById(empid);
		// 保存到request
		Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("emp", emp);
System.err.println("#######################" + emp);
		return SUCCESS;
	}
}
