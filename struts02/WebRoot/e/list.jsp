<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>下载列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
  	<table border="1" align="center">
  		<tr>
  			<td>编号</td>
  			<td>文件名</td>
  			<td>操作</td>
  		</tr>
  		<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  		<c:forEach var="fileName" items="${fileNames}" varStatus="vs">
  			<tr>
  				<td>${vs.count }</td>
  				<td>${fileName }</td>
  				<td>
  					<!-- 构建一个 url 自動產生Get語法的網址
  					down_down 第二個down是呼叫down()方法-->
  					<c:url var="url" value="down_down">
  						<c:param name="fileName" value="${fileName}"></c:param>
  					</c:url>
  					${url }
  					<a href="${url }">下载</a>
  				</td>
  			</tr>
  		</c:forEach>
  	</table>
  </body>
</html>







