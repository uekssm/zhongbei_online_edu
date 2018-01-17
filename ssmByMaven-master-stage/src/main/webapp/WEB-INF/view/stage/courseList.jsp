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
              <a href="http://localhost:8080/ssmStage/login/main">网站首页</a>
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
              <a href="http://localhost:8080/ssm/login/login">后台管理</a>
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
				 <a href="http://localhost:8080/ssmStage/login/main">首页</a>
				 <img src="../stageRescourse/image/more/more02.png" alt="">
				 <img src="../stageRescourse/image/more/more03.png" alt="">
				 <a href="">课程安排</a>
			</div>
			<!-- 学院信息 -->
			<ul class="more_xinxi">
				<li class="ml">
					<h2>学院:</h2>
					<h4 class="hot" identy="0">全部</h4>
					<c:forEach items="${requestScope.collegenames }" var="collegeval" begin="10" end="14">
						<h4 identy="${collegeval.id }"> ${collegeval.name }</h4>
					</c:forEach>
					
					
				</li>
				<li class="ml1">
					<h2>专业:</h2>
					<h4 id="majorall" class="hot" identy="0">全部</h4>
					
				</li>
				<li class="ml2">
					<h2>方向:</h2>
					<h4 class="hot">全部</h4>
					<h4>大数据</h4>
					<h4>大数据</h4>
				</li>
				<li class="ml3">
					<h2>年级:</h2>
					<h4 class="hot" identy="0">全部</h4>
					<h4 identy="1">大一</h4>
					<h4 identy="2">大二</h4>
					<h4 identy="3">大三</h4>
					<h4 identy="4">大四</h4>
				</li>
				<li class="ml4">
					<h2>类型:</h2>
					<h4 class="hot">全部</h4>
					<h4>基础</h4>
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
	<ul style="display:none">
		<li style="display:none" id="hiddenmodel">
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
	<ul class="more_courseBox">
		
		
	</ul>
	<!-- 分页导航 -->
	<div class="more_fenye">
		<h2 class="pageoption">首页</h2>
		<h2 class="pageoption prevpage">上一页</h2>
		
		
		<h2 class="pageoption nextpage">下一页</h2>
		<h2 class="pageoption">尾页</h2>
		
		<input type="hidden" class="pagetotal">
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
<script>
	$(function(){
		//点击分页时切换内容
		$('.more_fenye').on('click','.pageoption',function(){
			var pageindex;
			switch($(this).text()){
				case '首页':
					pageindex=0;
					$('span.pageoption').removeClass('hot').filter(':eq(0)').addClass('hot');
					break;
				case '尾页':
					pageindex=$('.pagetotal').val()-1;
					$('span.pageoption').removeClass('hot').filter(':last').addClass('hot');
					break;
				case '上一页':
					if($('span.pageoption.hot').prev().text()!='上一页'){
						pageindex=$('span.pageoption.hot').text()-2;
						$('span.pageoption.hot').removeClass('hot').prev().addClass('hot');
					}
					break;
				case '下一页':
					if($('span.pageoption.hot').next().text()!='下一页'){
						pageindex=$('span.pageoption.hot').text();
						$('span.pageoption.hot').removeClass('hot').next().addClass('hot');
					}
					break;
				default:
					pageindex=$(this).text()-1;
					$('span.pageoption').removeClass('hot').filter(this).addClass('hot');
					break;
			}
			getCourse(pageindex,2);
			
		});
	
	
		getCourse(0,1);
		//文档加载完成异步获取专业信息
		getmajor(0);
		function getmajor(collegeId){
			$.ajax({
				url:"${pageContext.request.contextPath }/course/getSubject",
				type:"get",
				data:{"collegeId":collegeId},
				scriptCharset:"utf-8",
				success:function(majorinfo){
					majorobj=jQuery.parseJSON(majorinfo);
					if(majorobj.length<5){
						len=majorobj.length;
					}else{
						len=5;
					}
					$('.ml1 h4').not('#majorall').remove();
					for(var i=0;i<len;i++){
						//每次从全部开始追加
						$('.ml1').append("<h4  identy='"+majorobj[i].id+"'>"+majorobj[i].name+"</h4>");
					}
				}
			});
		}
		$('body').on('click','.ml1 h4',function(){
			$('.ml1 h4').attr("class","").filter(this).attr("class","hot");
			getCourse(0,1);
		});
		$('body').on('click','.ml2 h4',function(){
			$('.ml2 h4').attr("class","").filter(this).attr("class","hot");
			getCourse(0,1);
		});
		$('body').on('click','.ml3 h4',function(){
			$('.ml3 h4').attr("class","").filter(this).attr("class","hot");
			getCourse(0,1);
		});
		$('body').on('click','.ml4 h4',function(){
			$('.ml4 h4').attr("class","").filter(this).attr("class","hot");
			getCourse(0,1);
		});
		//不同的学院获取不同的专业
		$('body').on('click','.ml h4',function(){
			$('.ml h4').attr("class","").filter(this).attr("class","hot");
			$('.ml1 h4').attr("class","").filter('#majorall').attr("class","hot");
			if(!$(this).attr('identy')){
				collegeId=0;
			}else{
				collegeId=$(this).attr('identy');
			}
			getmajor(collegeId);
			getCourse(0,1);
		});
		
		//点击条件获得课程
		/* 
			pageindex----当前页
			type---------1条件切换，2分页获取
		 */
		function getCourse(pageindex,type){
		
			college_id=$('.ml .hot').attr('identy');
			subject_id=$('.ml1 .hot').attr('identy');
			//direction_id=$('.ml2 .hot').attr('identy');
			grade=$('.ml3 .hot').attr('identy');
			//type=$('.ml4 .hot').attr('identy');
			/* alert(college_id);
			alert(subject_id);
			alert(grade);  */
			$.ajax({
				url:"${pageContext.request.contextPath }/course/getAllCourse",
				type:'post',
				data:{'limit':9,'pageindex':pageindex,'college_id':college_id,'subject_id':subject_id,'grade':grade},
				dataType:'json',
				success:function(result){
					coursedata=result.rows;
					totalcourse=result.results;
					$('.more_courseBox').empty();
					if(totalcourse>0){
						
						for(var i=0;i<coursedata.length;i++){
							var newli=$('#hiddenmodel').clone();
							newli.find('.more_imgBox').attr("href","${pageContext.request.contextPath }/course/video/"+coursedata[i].id);
							newli.find('.more_title h2').html(coursedata[i].name);
							newli.find('.more_watch a').attr("href","${pageContext.request.contextPath }/course/video/"+coursedata[i].id);
							$('.more_courseBox').append("<li>"+newli.html()+"</li>");
						}
						if(type==1){
							if(totalcourse>9){
							
								pagenum=Math.ceil(totalcourse/9);
								$('.pagetotal').val(pagenum);//隐藏域记录总页数
								$('span.pageoption').remove();
								for(var j=1;j<=pagenum;j++){
									if(j==6){
										break;
									}
									$('.nextpage').before("<span class='pageoption' pageindex='"+(j-1)+"'>"+j+"</span>")
								}
								$('span.pageoption:first').addClass('hot');
								$('.more_fenye').show();
							}else{
								$('.more_fenye').hide();
							}
						}
					} 
				}
			}); 
		}
	});
</script>
</body>
</html>
