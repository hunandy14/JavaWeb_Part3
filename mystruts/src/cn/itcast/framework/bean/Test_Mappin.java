package cn.itcast.framework.bean;

import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Test_Mappin {
	
//	測試讀取是否正常
	@Test
	public void test_ManagerInit(){
		ActionMapping am = new ActionMapping();
		
		// 讀取全部信息到 ActionMapping與
		ActionMappingManager amm = new ActionMappingManager();
		
		am = amm.getActionMapping("login2");
		System.err.println(amm);
	}
}
