package cn.itcast.a_hello;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//一、 对象
public class Employee {

	private int empId;
	private String empName;
	private Date workDate;
	
	
	public Employee() {
		super();
	}
	public Employee(int empId, String empName, Date workDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.workDate = workDate;
	}
	public Employee(int empId, String empName, String workDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.workDate = coverToDate(workDate);
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", workDate=" + coverToString(workDate) + "]";
	}

	
	// 字串轉換到日期
	private Date coverToDate(String Date) {
		Date date = null;
        SimpleDateFormat df = new  SimpleDateFormat("yyyy-MM-dd");
        try {
			date = df.parse(Date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	// 日期轉換到字串
	private String coverToString(Date date) {
		if(date!=null){			
			return new SimpleDateFormat("yyyy-MM-dd").format(date);
		} else {
			return null;
		}
		
	}
}
