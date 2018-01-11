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
<frameset rows="20%,*,10%">
	<frame src="${pageContext.request.contextPath }/index/top">
	<frameset cols="20%,*">
		<frame src="${pageContext.request.contextPath }/index/left">
		<frame src="${pageContext.request.contextPath }/index/right" name="right">
	</frameset>
	<frame src="${pageContext.request.contextPath }/index/bottom">
</frameset>
</html>