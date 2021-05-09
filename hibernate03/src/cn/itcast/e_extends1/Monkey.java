package cn.itcast.e_extends1;

public class Monkey extends Animal {
	// 吃香蕉
	private String eatBanana;

	public String getEatBanana() {
		return eatBanana;
	}
	public void setEatBanana(String eatBanana) {
		this.eatBanana = eatBanana;
	}
	@Override
	public String toString() {
		return "Monkey [eatBanana=" + eatBanana + "]";
	}
}
