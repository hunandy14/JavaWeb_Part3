<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
	
	 
	<!-- 修改struts标签默认的样式的方法1 
	<style type="text/css">
	ul{
		display: inline;
	}
	ul li{
		display: inline;
		color: red;
	}
	</style>
	--> 
	
	
  </head>
  
  <body>
  	<%@taglib uri="/struts-tags" prefix="s" %>
  	
  	
  	<br/>
  	
  	 <form method="post" action="${pageContext.request.contextPath }/user_register.action">
  	 	用戶名：<input type="text" name="user.userName">
  	 	 		<s:fielderror fieldName="user.userName"></s:fielderror>
  	 	<br/>
  	 	密碼　：<input type="text" name="user.pwd">
  	 			<s:fielderror fieldName="user.pwd"></s:fielderror>
  	 	<br/>
  	 	郵箱　：<input type="text" name="user.email"><br/>
  	 	生日　：<input type="text" name="user.birth"><br/>
  	 	<input type="submit" value="注册"><br/>
  	 </form>
  </body>
</html>
