<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>list</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
  	<h1>欢迎你，${userInfo.userName }</h1>
  	
  	
  	<!-- 手动通过value设置显示的值 -->
  	<%@taglib uri="/struts-tags" prefix="s" %>
  	<s:form action="#">
  		用户名： <s:textfield name="#request.listAdmin[0].userName"></s:textfield>
  		<br/>
  		<s:submit value="修改"></s:submit>
  	</s:form>
  	
  	<table align="center" border="1">
  		<tr>
  			<td>序号</td>
  			<td>编号</td>
  			<td>用户名</td>
  			<td>密码</td>
  		</tr>
  		<%-- @taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" --%>
  		<!-- 用struts标签迭代数据 -->
  		<%@taglib uri="/struts-tags" prefix="s" %>
  		<s:iterator var="admin" value="#request.listAdmin" status="st">
  			<tr>
  				<td>
  					<s:property value="#st.count"/>
  				</td>
  				<td>
  					<s:property value="#admin.id"/>
  				</td>
  				<td>
  					<s:property value="#admin.userName"/>
  				</td>
  				<td>
  					<s:property value="#admin.pwd"/>
  				</td>
  			</tr>
  		</s:iterator>
  		
  	</table>
  </body>
</html>








