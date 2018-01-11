<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
</head>
<body>
	<ul>
		<li><a href="${pageContext.request.contextPath }/menu/getAllMenu" target="right">菜单管理</a></li>
		<li><a href="${pageContext.request.contextPath }/role/getAllRole" target="right">角色管理</a></li>
		<li><a href="${pageContext.request.contextPath }/user/getAllUser" target="right">用户管理</a></li>
	</ul>
</body>
</html>