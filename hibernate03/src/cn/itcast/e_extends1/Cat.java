package cn.itcast.e_extends1;

public class Cat extends Animal{
	// 抓老鼠
	private String catchMouse;

	public String getCatchMouse() {
		return catchMouse;
	}
	public void setCatchMouse(String catchMouse) {
		this.catchMouse = catchMouse;
	}
	@Override
	public String toString() {
		return "Cat [catchMouse=" + catchMouse + "]";
	}
}
