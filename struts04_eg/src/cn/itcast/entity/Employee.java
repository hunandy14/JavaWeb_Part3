package cn.itcast.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

	private int id;// INT PRIMARY KEY AUTO_INCREMENT,
	private String empName;// VARCHAR(20),
	private Date workDate;// DATE -- 入职时间
	
	
	public Employee() {
		super();
	}
	public Employee(int id, String empName, String workDate) {
		this.id = id;
		this.empName = empName;
		this.workDate = coverToDate(workDate);
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		String date_str=null;
		if(workDate!=null){			
			date_str = new SimpleDateFormat("yyyy-MM-dd").format(workDate);
		}
		return "Employee [id=" + id + ", empName=" + empName + ", workDate="
				+ workDate + "]";
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
}
