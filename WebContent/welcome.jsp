<%@page import="com.xiudun.domain.User"%>
<%@page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
	</head>
	<% User user = (User)request.getSession().getAttribute("user"); %>
	<body>
		<h1 align="center">欢迎【<%=user.getTruename() %>】登录</h1>
	</body>
</html>