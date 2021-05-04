<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- 控制奇偶行變色 -->
	<style type="text/css" >
	   .odd{
	           background-color: #81C7D4; 
	          }
	   .even{
	           background-color: #9B90C2;}
	  </style>

  </head>
  
  
  
  
  <body>
    <br/>一、. list迭代<br/>
    <table border="1">
    	<tr>
    		<td>编号</td>
    		<td>名称</td>
    	</tr>
  		<s:iterator var="user" value="#request.list" status="st">
  			<tr class=<s:property value="#st.even?'even':'odd'"/> > <!-- 控制奇偶行變色 -->
  				<td><s:property value="#user.id"/></td>
  				<td><s:property value="#user.name"/></td>
  				<td><s:property value="#st"/></td>
  			</tr>
  		</s:iterator>
  	</table>
  	
  	 <br/>二、迭代map<br/>
    <table border="1">
    	<tr>
    		<td>编号</td>
    		<td>名称</td>
    	</tr>
  		<s:iterator var="en" value="#request.map" status="st">
  			<tr>
  				<td><s:property value="#en.key"/></td>
  				<td><s:property value="#en.value.name"/></td>
  			</tr>
  		</s:iterator>
  	</table>
  	
  	
  	<!-- Ognl表达式可以取值，也可以动态构建集合 -->
  </body>
</html>







