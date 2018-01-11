<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>中北大学软件学院在线教育平台</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/dpl.css" rel="stylesheet">
  <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/bui.css" rel="stylesheet">
<!-- <link href="../assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="../assets/css/bui-min.css" rel="stylesheet" type="text/css" /> -->
<link href="../assets/css/main-min.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="header">
		<div class="dl-title">
			<a href="<{:U('Index/index')}>" title="首页">
				<!-- 仅仅为了提供文档的快速入口，项目中请删除链接 --> <span class="lp-title-port">中北大学软件学院在线教育平台</span> </a>
		</div>

		<div class="dl-log">
			欢迎您:<span class="dl-log-user">教授:&nbsp;${userinfo.username}</span>
			<a href="loginout" title="退出系统" class="dl-log-quit">[退出]</a>
		</div>
		<!-- 如果学生日报有最新评论，登录提示 -->
		<!-- <empty name="res"> <else /> 
		<div class="dl-log note">
			<marquee scrollamount=3 onmouseover=this.stop()
				onmouseout=this.start()>
				您的日报有最新评论了！<a
					href="http://118.190.150.35/uek_oa/index.php/Admin/Login/index.html#45/278"
					target="_blank">前去查看</a>
			</marquee>
		</div>
		</empty> -->
	</div>
	<div class="content">
		<div class="dl-main-nav">
			<div class="dl-inform">
				<div class="dl-inform-title">
					贴心小秘书<s class="dl-inform-icon dl-up"></s>
				</div>
			</div>

			<ul id="J_Nav" class="nav-list ks-clear">
			
				<c:forEach items="${requestScope.ALLMENU }" var="MenuInfo">
					<li class="nav-item">
					<div class="nav-item-inner nav-order">${MenuInfo.name }</div></li>
					
				</c:forEach>
				
			</ul>
		</div>
		<ul id="J_NavContent" class="dl-tab-conten">

		</ul>
	</div>

	<script type="text/javascript" src="../assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="../assets/js/bui.js"></script>
	<script type="text/javascript" src="../assets/js/config.js"></script>

	<!-- main-min.js原来没有 导致的结果就是360等浏览器 登陆之后看不到左侧菜单 -->
	<script type="text/javascript" src="../assets/js/common/main-min.js"></script>

	<script>
		BUI.use('common/main', function() {
			//获取json
			$.getJSON('${pageContext.request.contextPath }/menu/getMenus', function(
					config) {
				new PageUtil.MainPage({
					modulesConfig : config
				});

			});
		});
	</script>
</body>
</html>