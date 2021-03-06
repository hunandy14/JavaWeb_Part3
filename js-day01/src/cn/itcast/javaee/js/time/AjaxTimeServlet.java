package cn.itcast.javaee.js.time;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 无需刷新整个Web页面显示服务器响应的当前时间
 * @author AdminTC
 */
public class AjaxTimeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		get_getVar(request);
		
		System.err.println("07的get 收到的命令===>");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowStr = sdf.format(new Date());
		
		//以流的方式将结果响应到AJAX异步对象中
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(nowStr);
		pw.flush();
		pw.close();
	}

	private Enumeration<String> get_getVar(HttpServletRequest request) {
		Enumeration<String> enums =  request.getParameterNames();
		while( enums.hasMoreElements() ){
			String paramName = enums.nextElement();
			String paramValue = request.getParameter(paramName);
			System.out.println(paramName + "=" + paramValue);
		}
		return enums;
	}
}





