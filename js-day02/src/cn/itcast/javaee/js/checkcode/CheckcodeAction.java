package cn.itcast.javaee.js.checkcode;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 验证码检查
 * @author AdminTC
 */
public class CheckcodeAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	//客户端验证码
	private String checkcode;//2525
	//注入客户端验证码
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}


	/**
	 * 验证
	 */	
	public String check() throws Exception {
		//从imgage.jsp获取session中的验证码
		String checkcodeServer = (String) ActionContext.getContext().getSession().get("CHECKNUM");
		
		
		System.err.println("#### CheckcodeAction.check()");
		System.err.println("  圖片答案：" + checkcodeServer);
		System.err.println("  輸入字串：" + checkcode);

		//将客户端的验证码与服务端的验证码进行比较
		String tip;
		if(checkcode.equals(checkcodeServer)){
			tip = "images/MsgSent.gif";
		} else {
			tip = "images/MsgError.gif";
		}
		//以IO流的方式将tip变量的值输出到AJAX异步对象中
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(tip);
		pw.flush();
		pw.close();
		//以下方式不是最好的，但可以完成AJAX异步交互
		return null;
	}
}









