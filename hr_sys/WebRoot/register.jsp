<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<title>註冊帳號</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body>
		<p align="center" >
			註冊結果： <s:property value="#request.admin.name" /> &nbsp;
		</p>
		
	<s:if test="#session.regInfo != null">
		<p align="center" >
			註冊結果： <s:property value="#session.regInfo" /> &nbsp;
		</p>
		<s:a href="#">退出</s:a>
		<s:a href="emp_viewAdd">添加员工</s:a>
	</s:if>

	<s:form action="/admin_register" method="post" theme="simple">
		<table border="1" align="center" cellpadding="5" cellspacing="0">
			<tr>
				<td colspan="2">註冊帳號</td>
			</tr>
			<tr>
				<td>账号</td>
				<td><s:textfield name="adminName" id="adminName" value=""></s:textfield>
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><s:textfield name="pwd" id="pwd" value=""></s:textfield>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><s:submit value="登陆"></s:submit>
				</td>
			</tr>

		</table>
	</s:form>
</body>
</html>
