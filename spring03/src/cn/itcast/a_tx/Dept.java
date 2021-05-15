package cn.itcast.a_tx;

public class Dept {

	private int deptId;
	private String deptName;
	
	
	public Dept() {
		super();
	}
	public Dept(String deptName) {
		super();
		this.deptName = deptName;
	}


	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
}
