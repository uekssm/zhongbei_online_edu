<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<title>课程安排更多</title>
	<meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../stageRescourse/css/base.css">
    <link rel="stylesheet" href="../stageRescourse/css/header.css">
	<link rel="stylesheet" href="../stageRescourse/css/more.css">
	<link rel="stylesheet" href="../stageRescourse/css/footer.css">
	<script src="../stageRescourse/js/jquery-3.2.1.js"></script>
	<script src="../stageRescourse/js/more.js"></script>
</head>
<body>
<header id="header">
      <div class="logo">
          <img src="../stageRescourse/image/home/logo.png" alt="">
          <div class="name">
              <h3>在线视屏交流平台</h3>
              <h6>ENDUCATION.COM</h6>
          </div>
      </div>
      <!--logo -->

      <div class="search">
          <img src="../stageRescourse/image/home/sseachleft.png" alt='' class="sleft">
          <input type="text" placeholder="请输入您想要搜索的课程" class="sinput">
          <img src="../stageRescourse/image/home/ssearchright.png" alt='' class="sright">
      </div>
      <!--search-->

      <div class="notice">
          <div class="nicon">
          </div>
          <div class="ncontent">
              通知
              <p>
                   到教学楼查询您的课程
              </p>
          </div>
      </div>
      <!--notice -->

      <ul class="nav">
          <!-- 需要选中状态  加hot-->
          <li class="list hot">
              <ul class="point">
                  <li></li>
                  <li></li>
              </ul>
              <a href="index.html">网站首页</a>
          </li>
          <li class="list">
              <ul class="point">
                  <li></li>
                  <li></li>
              </ul>
              <a href="">用户中心</a>
          </li>
          <li class="list">
              <ul class="point">
                  <li></li>
                  <li></li>
              </ul>
              <a href="">提供帮助</a>
          </li>
          <li class="list">
              <ul class="point">
                  <li></li>
                  <li></li>
              </ul>
              <a href="">后台管理</a>
          </li>
      </ul>
      <!--nav-->
  </header>

<!-- 详细信息开始 -->
	<section id="more_detail">
		<div class="more_main">
		    <!-- 面包屑 -->
			<div class="more_bread">
				 <img src="../stageRescourse/image/more/more01.png" alt="">
				 <a href="index.html">首页</a>
				 <img src="../stageRescourse/image/more/more02.png" alt="">
				 <img src="../stageRescourse/image/more/more03.png" alt="">
				 <a href="">课程安排</a>
			</div>
			<!-- 学院信息 -->
			<ul class="more_xinxi">
				<li>
					<h2>学院:</h2>
					<h3>软件工程学院</h3>
				</li>
				<li>
					<h2>专业:</h2>
					<h3>软件工程</h3>
				</li>
				<li>
					<h2>方向:</h2>
					<h3>大数据</h3>
				</li>
				<li class="ml">
					<h2>年级:</h2>
					<h4>大一</h4>
					<h4>大二</h4>
					<h4 class="hot">大三</h4>
					<h4>大四</h4>
				</li>
				<li class="ml1">
					<h2>类型:</h2>
					<h4>全部</h4>
					<h4 class="hot">基础</h4>
					<h4>案例</h4>
					<h4>框架</h4>
					<h4>工具</h4>
					<h4>设计模式</h4>
				</li>
			</ul>
		</div>
	</section>
<!-- 详细信息结束 -->

<!-- 课程开始 -->
<section id="more_course">
	<div class="more_courseTop">
		<div class="more_courseLeft">
			<h1 class="hot">最新</h1>
			<h1>最热</h1>
		</div>
		<div class="more_courseRight">
			<h1>难度:</h1>
			<h1>全部</h1>
			<h1 class="hot">初级</h1>
			<h1>中级</h1>
			<h1>高级</h1>
			<h1>1/24</h1>
			<a href="">&lt;</a>
			<a href="">&gt;</a>
		</div>
	</div>
	<!-- 视频课程列表 -->
	<ul class="more_courseBox">
		<li>
			<a href="${pageContext.request.contextPath }/course/video/134" class="more_imgBox">
			   <img src="../stageRescourse/image/more/more04.png" alt="">
			   <div class="more_switch"></div>
			</a>
			<div class="more_title">
				<h2>黑白数字影像·大师研修班</h2>
				<h3>摄影艺术 高级突破 摄影艺术</h3>
				<h4>免费视频</h4>
			</div>
			<div class="more_watch">
				<a href="${pageContext.request.contextPath }/course/video/134">免费观看</a>
				<h4>已有5265人观看</h4>
			</div>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/course/video/134" class="more_imgBox">
			   <img src="../stageRescourse/image/more/more04.png" alt="">
			   <div class="more_switch"></div>
			</a>
			<div class="more_title">
				<h2>黑白数字影像·大师研修班</h2>
				<h3>摄影艺术 高级突破 摄影艺术</h3>
				<h4>免费视频</h4>
			</div>
			<div class="more_watch">
				<a href="${pageContext.request.contextPath }/course/video/134">免费观看</a>
				<h4>已有5265人观看</h4>
			</div>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/course/video/134" class="more_imgBox">
			   <img src="../stageRescourse/image/more/more04.png" alt="">
			   <div class="more_switch"></div>
			</a>
			<div class="more_title">
				<h2>黑白数字影像·大师研修班</h2>
				<h3>摄影艺术 高级突破 摄影艺术</h3>
				<h4>免费视频</h4>
			</div>
			<div class="more_watch">
				<a href="${pageContext.request.contextPath }/course/video/134">免费观看</a>
				<h4>已有5265人观看</h4>
			</div>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/course/video/134" class="more_imgBox">
			   <img src="../stageRescourse/image/more/more04.png" alt="">
			   <div class="more_switch"></div>
			</a>
			<div class="more_title">
				<h2>黑白数字影像·大师研修班</h2>
				<h3>摄影艺术 高级突破 摄影艺术</h3>
				<h4>免费视频</h4>
			</div>
			<div class="more_watch">
				<a href="${pageContext.request.contextPath }/course/video/134">免费观看</a>
				<h4>已有5265人观看</h4>
			</div>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/course/video/134" class="more_imgBox">
			   <img src="../stageRescourse/image/more/more04.png" alt="">
			   <div class="more_switch"></div>
			</a>
			<div class="more_title">
				<h2>黑白数字影像·大师研修班</h2>
				<h3>摄影艺术 高级突破 摄影艺术</h3>
				<h4>免费视频</h4>
			</div>
			<div class="more_watch">
				<a href="${pageContext.request.contextPath }/course/video/134">免费观看</a>
				<h4>已有5265人观看</h4>
			</div>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/course/video/134" class="more_imgBox">
			   <img src="../stageRescourse/image/more/more04.png" alt="">
			   <div class="more_switch"></div>
			</a>
			<div class="more_title">
				<h2>黑白数字影像·大师研修班</h2>
				<h3>摄影艺术 高级突破 摄影艺术</h3>
				<h4>免费视频</h4>
			</div>
			<div class="more_watch">
				<a href="${pageContext.request.contextPath }/course/video/134">免费观看</a>
				<h4>已有5265人观看</h4>
			</div>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/course/video/134" class="more_imgBox">
			   <img src="../stageRescourse/image/more/more04.png" alt="">
			   <div class="more_switch"></div>
			</a>
			<div class="more_title">
				<h2>黑白数字影像·大师研修班</h2>
				<h3>摄影艺术 高级突破 摄影艺术</h3>
				<h4>免费视频</h4>
			</div>
			<div class="more_watch">
				<a href="${pageContext.request.contextPath }/course/video/134">免费观看</a>
				<h4>已有5265人观看</h4>
			</div>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/course/video/134" class="more_imgBox">
			   <img src="../stageRescourse/image/more/more04.png" alt="">
			   <div class="more_switch"></div>
			</a>
			<div class="more_title">
				<h2>黑白数字影像·大师研修班</h2>
				<h3>摄影艺术 高级突破 摄影艺术</h3>
				<h4>免费视频</h4>
			</div>
			<div class="more_watch">
				<a href="${pageContext.request.contextPath }/course/video/134">免费观看</a>
				<h4>已有5265人观看</h4>
			</div>
		</li>
		<li>
			<a href="${pageContext.request.contextPath }/course/video/134" class="more_imgBox">
			   <img src="../stageRescourse/image/more/more04.png" alt="">
			   <div class="more_switch"></div>
			</a>
			<div class="more_title">
				<h2>黑白数字影像·大师研修班</h2>
				<h3>摄影艺术 高级突破 摄影艺术</h3>
				<h4>免费视频</h4>
			</div>
			<div class="more_watch">
				<a href="${pageContext.request.contextPath }/course/video/134">免费观看</a>
				<h4>已有5265人观看</h4>
			</div>
		</li>
	</ul>
	<!-- 分页导航 -->
	<div class="more_fenye">
		<h2>首页</h2>
		<h2>上一页</h2>
		<span class="hot">1</span>
		<span>2</span>
		<span>3</span>
		<span>4</span>
		<span>5</span>
		<h2>下一页</h2>
		<h2>尾页</h2>
	</div>
</section>
<!-- 课程结束 -->

 <!-- 底部开始 -->
<footer>
  <div class="contain">
    <img src="../stageRescourse/image/footer/footer_06.png" alt="">
  </div>
</footer>
<!-- 底部结束 -->
</body>
</html>
