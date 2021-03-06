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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<!-- 页面： 必须要拿到ValueStack -->
  	
  	-------------------------------------------<br/>
     <br/><br/>1. 取根元素的值 那個class本身的成員變數<br/>
     <s:property value="user.id"/> <br/>
     <s:property value="user.name"/> <br/>
     <s:property value="user.address"/> <br/>
     <s:property value="user.address.city"/> <br/>
     <s:property value="user.address.province"/>  <br/>
     
     -------------------------------------------<br/>
      <br/><br/>2. 手動取非根元素的值<br/>
      #request.request_data::         <s:property value="#request.request_data"/> <br/>
      #request.map_request_data::     <s:property value="#request.map_request_data"/> <br/>
      #request.map_cn::               <s:property value="#request.map_cn"/> <br/>
      #session.Session_data::         <s:property value="#session.Session_data"/> <br/>
      #application.Application_data:: <s:property value="#application.Application_data"/>    <br/><br/>
     
     -------------------------------------------<br/>
      <!-- 自动找request/session/application,找到后立刻返回 -->
      <br/><br/>2. 自动找request/session/application,找到后立刻返回 <br/>
      #request_data::          <s:property value="#request_data"/> <br/>
      #attr.map_request_data:: <s:property value="#attr.map_request_data"/> <br/>
      #attr.map_cn::           <s:property value="#attr.map_cn"/> <br/>
      
      #attr.Session_data::     <s:property value="#attr.Session_data"/> <br/>
      #attr.Application_data:: <s:property value="#attr.Application_data"/>  <br/><br/>
      
      -------------------------------------------<br/>
      <!-- 获取请求的参数数据 get 參數上的東西-->
      <br/><br/>3. 获取请求的参数数据 get 參數上的東西 <br/>
      get_xml_userName:: <s:property value="#parameters.xml_userName"/> <br/>
      get_userName::     <s:property value="#parameters.userName"/> <br/>
     
     <!-- struts的调试标签：可以观测值栈数据 -->
     <s:debug></s:debug>
  </body>
</html>







