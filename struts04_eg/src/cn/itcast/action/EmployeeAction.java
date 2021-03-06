package cn.itcast.action;

import java.util.List;

import cn.itcast.entity.Employee;
import cn.itcast.service.IEmployeeService;
import cn.itcast.service.impl.EmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 员工管理Action
 * @author Jie.Yuan
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	private static final long serialVersionUID = 1L;
	
	/****封装数据****/
	private Employee employee = new Employee();
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	// 重写模型驱动方法
	@Override
	public Employee getModel() {
		return employee;
	}
	
	/****调用的Service****/
	private IEmployeeService employeeService = new EmployeeService();
	
	/**
	 * 1. 添加员工
	 */
	public String save() {
		try {
			// 调用service保存
			employeeService.save(employee);
			// 添加成功，去到列表页面
			return list();
			//return "addsuccess";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 2. 列表显示
	 */
	public String list() {
		try {
			// 查询全部
			List<Employee> listEmp = employeeService.getAll();
			// 保存到request域
			ActionContext.getContext().getContextMap().put("listEmp", listEmp);
			return "list";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 3. 进入修改页面
	 */
	public String viewUpdate() {
		// 按下修改後會由get傳id並進入這個函式
		// get上的id會被struts自動封裝進成員變數employee
		try {
			// 3.1 获取当前修改的记录的主键值
			int id = employee.getId();
			// 3.2 service查询
			Employee emp = employeeService.findById(id);
			// 3.3 数据回显
			// a. 先得到值栈
			ValueStack vs = ActionContext.getContext().getValueStack();
			vs.pop();	//移除栈顶元素
			vs.push(emp);	// emp对象放入栈顶
			
System.err.println("#### 結束 viewUpdate() 下一步進入 update.jsp");
			return "update";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 4. 修改员工
	 */
	public String update() {
		// update.jsp 按下修改員工後才執行這個函式
		// 按下同時會提交表格數據到struts2，並由struts寫入到成員函式employee
		try {
			// 调用service修改
			employeeService.update(employee);
			return list();
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
