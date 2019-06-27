<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<title>Login画面</title>
</head>
<body>
	<jsp:include page="header.jsp" />
		<h1>Login画面</h1>
		<s:form action="LoginAction">
			<table>
				<tr>
				<td><label>ログインID</label></td>
					<td><s:textfield name="loginId" placeholder="ログインID"/></td>
				</tr>
				<tr>
					<td><label>パスワード</label></td>
					<td><s:password name="password" placeholder="パスワード"/></td>
				</tr>
				<tr>
					<td><s:submit value="ログイン"/></td>
				</tr>
			</table>
		</s:form>
</body>
</html>