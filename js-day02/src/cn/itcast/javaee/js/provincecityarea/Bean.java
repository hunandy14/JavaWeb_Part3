package cn.itcast.javaee.js.provincecityarea;

/**
 * 封装省份和城市
 * @author AdminTC
 */
public class Bean {
	private String province;//省份
	private String city;//城市
	public Bean(){}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
