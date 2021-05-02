package cn.itcast.d_type;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class Tester_String2Data {
	@Test
	public void String2Data() throws ParseException {
		String value = null;
		value = "2020-06-20";
		// 字串轉日期
		Date date = coverFromString(value);
		System.out.println(date);
		// 日期轉字串
		String dataStr = coverFromDate(date);
		System.err.println(dataStr);
	}
	// 字串轉日期
	private String coverFromDate(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dataStr = df.format(date);
		return dataStr;
	}
	// 日期轉字串
	private Date coverFromString(String value) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = df.parse(value);
		} catch (ParseException e) {
			System.err.println("日期的文字格式化錯誤");
			//e.printStackTrace();
		}
		return date;
	}
}
