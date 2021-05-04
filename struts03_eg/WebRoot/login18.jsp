<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><s:text name="title"></s:text></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
  這一頁是 login18.jsp
  	 <form method="post" action="${pageContext.request.contextPath }/user_login.action">
  	 	<s:text name="title"></s:text>：<input type="text" name="admin.userName"><br/>
  	 	<s:text name="pwd"></s:text>：<input type="text" name="admin.pwd"><br/>
  	 	<input type="submit" value=<s:text name="submit"></s:text>><br/>
  	 </form>
  </body>
</html>
