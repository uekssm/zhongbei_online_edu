<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加新菜单</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath }/menu/addMenu" method="post" modelAttribute="command">
		<c:if test="${command.id != null }">
			<form:hidden path="id"/>
			<input type="hidden" name="_method" value="PUT"/>
			<%-- 对于 _method 不能使用 form:hidden 标签, 因为 modelAttribute 对应的 bean 中没有 _method 这个属性 --%>
			<%-- 
			<form:hidden path="_method" value="PUT"/>
			--%>
		</c:if>
		name : <form:input path="name"/><br><br>
		target_href　: <form:input path="target_href"/><br><br>
		parent_id :　<form:input path="parent_id"/><br><br>
		<input type="submit" value="提交"/>
	</form:form>
</body>
</html>