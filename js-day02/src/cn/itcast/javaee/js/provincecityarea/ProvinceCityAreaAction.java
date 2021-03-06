package cn.itcast.javaee.js.provincecityarea;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 省份-城市-区域三级联动【Struts2 + JSON版】
 * @author AdminTC
 */
public class ProvinceCityAreaAction extends ActionSupport{
	private Bean bean;
	public Bean getBean() {
		return bean;
	}
	public void setBean(Bean bean) {
		this.bean = bean;
	}
	/**
	 * 根据省份获取城市 
	 */
	public String findCityByProvince() throws Exception {
		cityList = new ArrayList<String>();
		if("湖北".equals(bean.getProvince())){
			cityList.add("武汉");
			cityList.add("赤壁");
		}else if("湖南".equals(bean.getProvince())){
			cityList.add("郴州");
			cityList.add("张家界");
			cityList.add("浏阳");
		}else if("广东".equals(bean.getProvince())){
			cityList.add("阳江");
			cityList.add("清远");
			cityList.add("佛山");
			cityList.add("湛江");
		}
		//让struts2框架帮你将List/Set/Map<String>转成JSON文本
		return SUCCESS;
	}
	
	
	/**
	 * 根据城市获取区域 
	 */
	public String findAreaByCity() throws Exception {
		areaList = new ArrayList<String>();
		if("阳江".equals(bean.getCity())){
			areaList.add("AA");
			areaList.add("BB");
		}else if("清远".equals(bean.getCity())){
			areaList.add("CC");
			areaList.add("DD");;
		}else if("佛山".equals(bean.getCity())){
			areaList.add("EE");
			areaList.add("FF");
		}else if("湛江".equals(bean.getCity())){
			areaList.add("GG");
			areaList.add("HH");
		}
		return SUCCESS;
	}
	private List<String> areaList;//区域的集合
	private List<String> cityList;//城市的集合
	public List<String> getCityList() {
		return cityList;
	}
	public List<String> getAreaList() {
		return areaList;
	}
	
	
	
}






