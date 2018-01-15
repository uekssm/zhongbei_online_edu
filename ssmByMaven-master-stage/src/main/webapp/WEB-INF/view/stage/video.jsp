<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<title>视频内容</title>
	<link rel="stylesheet" href="../../stageRescourse/css/base.css">
	<link rel="stylesheet" href="../../stageRescourse/css/header.css">
	<link rel="stylesheet" href="../../stageRescourse/css/content.css">
	<link rel="stylesheet" href="../../stageRescourse/css/footer.css">
</head>
<body>
<header id="header">
      <div class="logo">
          <img src="../../stageRescourse/image/home/logo.png" alt="">
          <div class="name">
              <h3>在线视屏交流平台</h3>
              <h6>ENDUCATION.COM</h6>
          </div>
      </div>
      <!--logo -->

      <div class="search">
          <img src="../../stageRescourse/image/home/sseachleft.png" alt='' class="sleft">
          <input type="text" placeholder="请输入您想要搜索的课程" class="sinput">
          <img src="../../stageRescourse/image/home/ssearchright.png" alt='' class="sright">
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
				 <img src="../../stageRescourse/image/more/more01.png" alt="">
				 <a href="index.html">首页</a>
				 <img src="../../stageRescourse/image/more/more02.png" alt="">
				 <img src="../../stageRescourse/image/more/more03.png" alt="">
				 <a href="">视频</a>
			</div>
			<div class="more_xinxi">
				<h2>学院:</h2>
				<h3>软件工程学院</h3>
			</div>
	    </div>
		
	</section>
	<!-- 详细信息结束 -->
	<!-- 主体视频开始 -->
	<section id="content">
		<div class="content_left">
		    <!-- 播放视频部分 -->
			<div class="content_vdisplay">
		     <%-- <video src="${pageContext.request.contextPath }${videoinfo.get(0).video }" controls></video> --%>
		     <video src="http://localhost:8080/ssm/${videoinfo.get(0).video }" controls></video>
				<div class="more_title">
					<h2>${videoinfo.get(0).name }</h2>
				    <h3>摄影艺术 高级突破 摄影艺术</h3>
				    <h4>主讲人：闻新</h4>
				    <h5>已有5265人观看</h5>
				</div>
			</div>
			<!-- 播放视频部分结束 -->
			<!-- 猜你喜欢开始 -->
			<div class="content_like">
				<div class="content_lT">
					<h1>猜你喜欢</h1>
					<a href="">换一批</a>
				</div>
				<!-- 猜你喜欢列表 -->
				<ul class="more_courseBox">
					<li>
						<a href="" class="more_imgBox">
						   <img src="../../stageRescourse/image/more/more04.png" alt="">
						   <div class="shadow">
                                <div class="more_switch"></div>
						   </div>
						   
						</a>
						<div class="more_title">
							<h2>C语言程序设计初级</h2>
							<h3>C语言程序设计初级</h3>
						</div>
					</li>
					<li>
						<a href="" class="more_imgBox">
						   <img src="../../stageRescourse/image/more/more04.png" alt="">
						    <div class="shadow">
                                <div class="more_switch"></div>
						   </div>
						</a>
						<div class="more_title">
							<h2>C语言程序设计初级</h2>
							<h3>C语言程序设计初级</h3>
						</div>
					</li>
					<li>
						<a href="" class="more_imgBox">
						   <img src="../../stageRescourse/image/more/more04.png" alt="">
						    <div class="shadow">
                                <div class="more_switch"></div>
						   </div>
						</a>
						<div class="more_title">
							<h2>C语言程序设计初级</h2>
							<h3>C语言程序设计初级</h3>
						</div>
					</li>
					<li>
						<a href="" class="more_imgBox">
						   <img src="../../stageRescourse/image/more/more04.png" alt="">
						    <div class="shadow">
                                <div class="more_switch"></div>
						   </div>
						</a>
						<div class="more_title">
							<h2>C语言程序设计初级</h2>
							<h3>C语言程序设计初级</h3>
						</div>
					</li>
					<li>
						<a href="" class="more_imgBox">
						   <img src="../../stageRescourse/image/more/more04.png" alt="">
						    <div class="shadow">
                                <div class="more_switch"></div>
						   </div>
						</a>
						<div class="more_title">
							<h2>C语言程序设计初级</h2>
							<h3>C语言程序设计初级</h3>
						</div>
					</li>
					<li>
						<a href="" class="more_imgBox">
						   <img src="../../stageRescourse/image/more/more04.png" alt="">
						    <div class="shadow">
                                <div class="more_switch"></div>
						   </div>
						</a>
						<div class="more_title">
							<h2>C语言程序设计初级</h2>
							<h3>C语言程序设计初级</h3>
						</div>
					</li>
				</ul>
			</div>
			<!-- 猜你喜欢结束 -->
			<!-- 我要评论开始 -->
			<div class="content_Comment">
				<div class="content_lT">
					<h1>我要评论</h1>
				</div>
				<textarea name="" id="" cols="30" rows="10" placeholder="我来说两句..."></textarea>
				<button>发布</button>
			</div>
			<!-- 我要评论结束 -->
			<!-- 热门评论开始 -->
			<div class="content_hot">
				<div class="content_lT">
					<h1>热门评论(<span>20</span>)</h1>
				</div>
				<ul class="content_pinglun">
					<li>
						<img src="../../stageRescourse/image/cotent/head_p.png" alt="">
						<div class="content_plR">
							<div class="content_plRt">
								<h1>不浪漫的罪名</h1>
                                <div>
                                	<img src="../../stageRescourse/image/cotent/like.png" alt="">
                                	<span>7792</span>
                                	<img src="../../stageRescourse/image/cotent/look.png" alt="">
                                	<span>45774</span>
                                </div>
							</div>
							<p>相传曾有一道集山珍海味之大全的荤菜，奇香四溢，惹得邻院寺庙里念经的和尚垂涎欲滴，失去定力，而寻香番强故名“佛跳墙”.
							</p>
						</div>
					</li>
					<li>
						<img src="../../stageRescourse/image/cotent/head_p.png" alt="">
						<div class="content_plR">
							<div class="content_plRt">
								<h1>不浪漫的罪名</h1>
                                <div>
                                	<img src="../../stageRescourse/image/cotent/like.png" alt="">
                                	<span>7792</span>
                                	<img src="../../stageRescourse/image/cotent/look.png" alt="">
                                	<span>45774</span>
                                </div>
							</div>
							<p>相传曾有一道集山珍海味之大全的荤菜，奇香四溢，惹得邻院寺庙里念经的和尚垂涎欲滴，失去定力，而寻香番强故名“佛跳墙”.</p>
						</div>
					</li>
					<li>
						<img src="../../stageRescourse/image/cotent/head_p.png" alt="">
						<div class="content_plR">
							<div class="content_plRt">
								<h1>不浪漫的罪名</h1>
                                <div>
                                	<img src="../../stageRescourse/image/cotent/like.png" alt="">
                                	<span>7792</span>
                                	<img src="../../stageRescourse/image/cotent/look.png" alt="">
                                	<span>45774</span>
                                </div>
							</div>
							<p>相传曾有一道集山珍海味之大全的荤菜，奇香四溢，惹得邻院寺庙里念经的和尚垂涎欲滴，失去定力，而寻香番强故名“佛跳墙”.</p>
						</div>
					</li>
					<li>
						<img src="../../stageRescourse/image/cotent/head_p.png" alt="">
						<div class="content_plR">
							<div class="content_plRt">
								<h1>不浪漫的罪名</h1>
                                <div>
                                	<img src="../../stageRescourse/image/cotent/like.png" alt="">
                                	<span>7792</span>
                                	<img src="../../stageRescourse/image/cotent/look.png" alt="">
                                	<span>45774</span>
                                </div>
							</div>
							<p>相传曾有一道集山珍海味之大全的荤菜，奇香四溢，惹得邻院寺庙里念经的和尚垂涎欲滴，失去定力，而寻香番强故名“佛跳墙”.</p>
						</div>
					</li>
				</ul>
				<!-- 分页 -->
				<div class="more_fenye">
					<h2>首页</h2>
					<h2>上一页</h2>
					<span class="hot">1</span>
					<h2>下一页</h2>
					<h2>尾页</h2>
				</div>
			</div>
			<!-- 热门评论结束 -->
		</div>
		<!-- 右边 -->
		<div class="content_right">
			<!-- 正在播放开始 -->
			<h1>正在播放</h1>
			<div class="content_list current_video">
				<a href="" class="more_imgBox">
				   <img src="../../stageRescourse/image/more/more04.png" alt="">
				</a>
				<div class="more_title">
					<h2>${videoinfo.get(0).name }</h2>
					<h3>摄影艺术 高级突破 摄影艺术</h3>
					<h4>免费视频</h4>
				</div>
				<div class="more_watch">
					<a href="">免费观看</a>
					<h4>已有5265人观看</h4>
				</div>
			</div>
			<!-- 正在播放结束 -->
			<h1 class="next">接下来播放</h1>
			<c:forEach items="${requestScope.videoinfo }" var="videoval">
				<%-- <div class="content_list" knowledge="${videoval.name }" videourl="${pageContext.request.contextPath }${videoval.video }"> --%>
				<div class="content_list" knowledge="${videoval.name }" videourl="http://localhost:8080/ssm/${videoval.video }">
					<a href="javascript:void(0)" class="more_imgBox changevideo">
					   <img src="../../stageRescourse/image/more/more04.png" alt="">
					</a>
					<div class="more_title">
						<h2> ${videoval.name }</h2>
						<h3>摄影艺术 高级突破 摄影艺术</h3>
						<h4>免费视频</h4>
					</div>
					<div class="more_watch">
						<a href="javascript:void(0)" class="changevideo">免费观看</a>
						<h4>已有5265人观看</h4>
					</div>
				</div>
					
			</c:forEach>
			
			
			
		</div>
	</section>
	<!-- 主体视频结束 -->
	
 <!-- 底部开始 -->
<footer>
  <div class="contain">
    <img src="../../stageRescourse/image/footer/footer_06.png" alt="">
  </div>
</footer>
<!-- 底部结束 -->

<!-- 点击免费观看切换视频 -->
<script src="../../stageRescourse/js/jquery-3.2.1.js"></script>
<script>
	$('body').on('click','.changevideo',function(){
		//更改当前播放的视频及详情
		$('.content_vdisplay video').attr('src',$(this).parents('.content_list').attr('videourl'));
		$('.content_vdisplay h2').html($(this).parents('.content_list').attr('knowledge'));
		
		//更改正在播放的视频信息（侧边）
		$('.current_video h2').html($(this).parents('.content_list').attr('knowledge'));
		//在接下来播放列表移除刚点击播放的视频	
		$(this).parents('.content_list').remove();
	})
</script>
</body>
</html>
