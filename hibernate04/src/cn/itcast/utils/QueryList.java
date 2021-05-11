package cn.itcast.utils;

import java.util.List;

public class QueryList {
	// 打印由Query查詢所得到的數組的內容
	static public void out(List<Object> queryList) {
	    // 邏輯判斷
	    if (queryList == null) {return;}
	    if (queryList.size() < 1) {return;}

	    // 第二層為陣列
	    if(queryList.get(0) instanceof Object[]){
	        for (int j = 0; j < queryList.size(); j++) {
	            System.err.println("List["+j+"]::");
	            for (Object object : (Object[])queryList.get(j)) {
	                System.err.println("  "+object);
	            }
	        }

	    // 第二層為物件
	    } else if(queryList.get(0) instanceof Object){
	        if (queryList.get(0).toString().length() > 16){
	            for (int j = 0; j < queryList.size(); j++) {
	                System.err.println("List["+j+"]::");
	                System.err.println("  "+queryList.get(j));
	            }
	        } else {
	            System.err.println(queryList);
	        }
	    }
	}
	
	// 判斷queryList第二層是否為陣列
	static public void isArray(Object queryObject) {
		// 判斷第二層是陣列還是物件
		if(queryObject instanceof Object[]){
			System.err.println("Object[]");
		} else if(queryObject instanceof Object){
			System.err.println("Object");
		}
	}
}
