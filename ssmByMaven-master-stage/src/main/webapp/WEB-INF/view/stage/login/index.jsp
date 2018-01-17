<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>中北大学软件学院在线教育平台-首页</title>
    <link rel="stylesheet" href="../stageRescourse/css/base.css">
    <link rel="stylesheet" href="../stageRescourse/css/index.css">
    <link rel="stylesheet" href="../stageRescourse/css/header.css">
    <link rel="stylesheet" href="../stageRescourse/css/footer.css">
    <link rel="stylesheet" href="../stageRescourse/css/swiper.css">
    <link rel="stylesheet" href="../stageRescourse/css/spider.css">
    <script src="../stageRescourse/js/jquery-3.2.1.js"></script>
    <script src="../stageRescourse/js/swiper.min.js"></script>
    <script src="../stageRescourse/js/index.js"></script>
    <script src="../stageRescourse/js/spider.js"></script>
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
    <!-- banner开始 -->
    <div id="index_banner">
        <div class="index_banner_img">
            <a href="">
                <img src="../stageRescourse/image/home/banner.png" alt="">
            </a>
        </div>
        <!-- 个人信息开始 -->
        <div class="index_banner_personal">
            <div class="index_banner_box">
                <a href="" class="index_personal_img">
                    <img src="../stageRescourse/image/home/personal.png" alt="">
                </a>
            </div>
            <h1 class="index_personal_name">JAMES</h1>
            <h2 class="index_personal_account">27382900289</h2>
            <ul class="index_personal_skill">
                <li>
                    <div class="index_banner_skills">
                        <canvas id='canvas' width="67" height="67">
                            <p>You browser not support canvas</p>
                        </canvas>
                    </div>
                    <span>JAVA</span>
                </li>
                <li>
                    <div class="index_banner_skills">
                        <canvas id='canvas1' width="67" height="67">
                            <p>You browser not support canvas</p>
                        </canvas>
                    </div>
                    <span>JAVA</span>
                </li>
                <li>
                    <div class="index_banner_skills">
                        <canvas id='canvas2' width="67" height="67">
                            <p>You browser not support canvas</p>
                        </canvas>
                    </div>
                    <span>JAVA</span>
                </li>
            </ul>
        </div>
        <!-- 个人信息结束 -->
    </div>  
    <!-- banner结束 -->

    <!-- 推荐课程开始 -->
    <div id="index_recommend">
        <div class="index_module_logo">
            <img src="../stageRescourse/image/home/m1.png" alt="">
        </div>
        <div class="index_module_more">
            <a href="${pageContext.request.contextPath }/course/index">
                <span>更多</span>
                <i>&#xe6f5;</i>
            </a>
        </div>
        
        <!-- 课程介绍开始 -->
        <ul class="index_module_course">
            <li>
                <div class="index_module_img">
                    <img src="../stageRescourse/image/home/c1.png" alt="">
                </div>
                <h1 class="index_module_title">前端与移动开发</h1>
                <p class="index_module_content">本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏</p>
                <div class="index_module_fenge"></div>
                <p class="index_module_time">学习时间：<span>7个月</span></p><div class="index_module_btn">
                    <button class="index_module_details">课程详情</button>
                    <button class="index_module_salary">就业薪资</button>
                </div>   
            </li>
            <li>
                <div class="index_module_img">
                    <img src="../stageRescourse/image/home/c2.png" alt="">
                </div>
                <h1 class="index_module_title">前端与移动开发</h1>
                <p class="index_module_content">本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏</p>
                <div class="index_module_fenge"></div>
                <p class="index_module_time">学习时间：<span>7个月</span></p><div class="index_module_btn">
                    <button class="index_module_details">课程详情</button>
                    <button class="index_module_salary">就业薪资</button>
                </div>   
            </li>
            <li>
                <div class="index_module_img">
                    <img src="../stageRescourse/image/home/c3.png" alt="">
                </div>
                <h1 class="index_module_title">前端与移动开发</h1>
                <p class="index_module_content">本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏</p>
                <div class="index_module_fenge"></div>
                <p class="index_module_time">学习时间：<span>7个月</span></p><div class="index_module_btn">
                    <button class="index_module_details">课程详情</button>
                    <button class="index_module_salary">就业薪资</button>
                </div>   
            </li>
            <li>
                <div class="index_module_img">
                    <img src="../stageRescourse/image/home/c4.png" alt="">
                </div>
                <h1 class="index_module_title">前端与移动开发</h1>
                <p class="index_module_content">本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏</p>
                <div class="index_module_fenge"></div>
                <p class="index_module_time">学习时间：<span>7个月</span></p><div class="index_module_btn">
                    <button class="index_module_details">课程详情</button>
                    <button class="index_module_salary">就业薪资</button>
                </div>   
            </li>
        </ul>
        <!-- 课程介绍结束 -->
    </div> 
    <!-- 推荐课程结束 -->

    <!-- 课程详情开始 -->
    <div class="spider">

        <div class="close">

        </div>
        <div class="spiderContent hot">
            <div class="spiderBoxP">


            <ul class="spiderBox">
                <h3>
                    <img src="../stageRescourse/image/home/sJavsCourse.png" alt="">
                </h3>
                <img src="../stageRescourse/image/home/spider.png" alt="" class="spiderImg">
                <li>
                    <div class="title">
                        <h3>前端</h3>
                        <img src="../stageRescourse/image/home/s01.png" alt="">
                    </div>
                    <div class="description">
                        需要具备Java基本及常用设计模式，有良好的面向对象设计思想，OOP/OOD以及UML的技术。
                    </div>
                </li>
                <li>
                    <div class="title">
                        <h3>JavaSE开发</h3>
                        <img src="../stageRescourse/image/home/s02.png" alt="">
                    </div>
                    <div class="description">
                        不仅具备数据库开发能力，能操作Oracle、MySQL等大型关系型数据库，而且还能进行NoSQL非关系型数据库，比如MongoDB数据库的开发。
                    </div>
                </li>
                <li>
                    <div class="title">
                        <h3>Java框架开发</h3>
                        <img src="../stageRescourse/image/home/s03.png" alt="">
                    </div>
                    <div class="description">
                        具有良好的开发架构经验，深入理解Hadoop/MapReduce/Storm/Spark等大数据框架应用开发等。
                    </div>
                </li>
                <li>
                    <div class="title">
                        <h3>Java架构开发</h3>
                        <img src="../stageRescourse/image/home/s04.png" alt="">
                    </div>
                    <div class="description">
                        熟悉常用的 BI工具，数据的清洗、转换、存储等工作，进行数据处理和可视化。
                    </div>
                </li>
                <li>
                    <div class="title">
                        <h3>Java项目开发</h3>
                        <img src="../stageRescourse/image/home/s05.png" alt="">
                    </div>
                    <div class="description">
                        具备熟练的Linux技术，Shell编程，能够利用常用的工具程序进行跟踪诊断。
                    </div>
                </li>
                <li>
                    <div class="title">
                        <h3>较强的编程能力及良好的编程习惯</h3>
                        <img src="../stageRescourse/image/home/s06.png" alt="">
                    </div>
                    <div class="description">
                        能够完成较复杂的交互流程设计和实现，具备良好的编程习惯，能够编写高质量技术文档；需要较强的逻辑分析、数据分析能力、问题排查能力，工作主动，学习能力强，具备丰富想象力和创造力。
                    </div>
                </li>
            </ul>
            </div>

            <section class="spiderLun">
                <!-- start -->
                <h3 class="scourseTitle">
                    <img src="../stageRescourse/image/home/scourseTitle.png" alt="">
                </h3>
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>



                    </div>
                    <div class="swiper-scrollbar"></div>
                    <!-- Add Pagination -->
                </div>
                <!-- end -->
               
                 <!-- start -->
                <h3 class="scourseTitle">
                    <img src="../stageRescourse/image/home/scourseTitle.png" alt="">
                </h3>
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>



                    </div>
                    <div class="swiper-scrollbar"></div>
                    <!-- Add Pagination -->
                </div>
                <!-- end -->

                 <!-- start -->
                <h3 class="scourseTitle">
                    <img src="../stageRescourse/image/home/scourseTitle.png" alt="">
                </h3>
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>



                    </div>
                    <div class="swiper-scrollbar"></div>
                    <!-- Add Pagination -->
                </div>
                <!-- end -->

                 <!-- start -->
                <h3 class="scourseTitle">
                    <img src="../stageRescourse/image/home/scourseTitle.png" alt="">
                </h3>
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>



                    </div>
                    <div class="swiper-scrollbar"></div>
                    <!-- Add Pagination -->
                </div>
                <!-- end -->

                 <!-- start -->
                <h3 class="scourseTitle">
                    <img src="../stageRescourse/image/home/scourseTitle.png" alt="">
                </h3>
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>
                        <div class="swiper-slide citem">
                            <div class="sIcon"></div>
                            <h3 class="sTitle">
                                前端移动开发
                            </h3>
                            <p class="sDescription">
                                本课程是基于websocket的火拼俄罗斯的升级版本，课程中在前两个课的基础上实现了用两个浏览器对战模式，完整的实现了游戏
                            </p>
                            <div class="sTime">
                                学习时间: <span>7个月</span>
                            </div>
                            <div class="sButton">
                                <a href="${pageContext.request.contextPath }/course/coursePath/34">课程详情</a>
                                <button>就业薪资</button>
                            </div>
                        </div>



                    </div>
                    <div class="swiper-scrollbar"></div>
                    <!-- Add Pagination -->
                </div>
                <!-- end -->


            </section>
        </div>
    </div>
    <!-- 课程详情结束 -->

    <!-- 在线测评开始 -->
    <div id="index_test">
        <div class="index_module_logo">
            <img src="../stageRescourse/image/home/m2.png" alt="">
        </div>
        <ul class="index_test_btn">
            <li class="index_test_btnActive">测评</li>
            <li>排名</li>
        </ul>
        <div class="index_test_list">
            <ul class="index_ceping">
                <li>
                    <h1 class="index_test_title">在线测试</h1>
                    <p class="index_test_description">在线考评 成绩可靠并且立即可见</p>
                    <a href="" class="index_test_more">
                        <span class="index_test_moreActive"></span>
                        <span></span>
                        <span></span>
                    </a>
                </li>
                <li>
                    <h1 class="index_test_title">在线测试</h1>
                    <p class="index_test_description">在线考评 成绩可靠并且立即可见</p>
                    <a href="" class="index_test_more">
                        <span class="index_test_moreActive"></span>
                        <span></span>
                        <span></span>
                    </a>
                </li>
                <li>
                    <h1 class="index_test_title">随堂测试</h1>
                    <p class="index_test_description">在线考评 成绩可靠并且立即可见</p>
                    <a href="" class="index_test_more">
                        <span class="index_test_moreActive"></span>
                        <span></span>
                        <span></span>
                    </a>
                </li>
                <li>
                    <h1 class="index_test_title">随机测试</h1>
                    <p class="index_test_description">在线考评 成绩可靠并且立即可见</p>
                    <a href="" class="index_test_more">
                        <span class="index_test_moreActive"></span>
                        <span></span>
                        <span></span>
                    </a>
                </li>
            </ul>
            <ul class="index_rank">
                <li>
                    <div class="index_rank_num"><img src="../stageRescourse/image/home/n1.png" alt=""></div>
                    <div class="index_rank_content">
                        <div class="index_rank_img">
                            <img src="../stageRescourse/image/home/h2.png" alt="">
                        </div>
                        <div class="index_rank_contents">
                            <a href=""><h1 class="index_interaction_rankListT">建设事业部精益项目终审会&nbsp;</h1></a>
                            <p class="index_interaction_rankListD">委书记孙永强同志带领全体党员在上海中共一大会址足使每一位党员接受了一次深刻。</p>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="index_rank_num"><img src="../stageRescourse/image/home/n2.png" alt=""></div>
                    <div class="index_rank_content">
                        <div class="index_rank_img">
                            <img src="../stageRescourse/image/home/h2.png" alt="">
                        </div>
                        <div class="index_rank_contents">
                            <a href=""><h1 class="index_interaction_rankListT">建设事业部精益项目终审会&nbsp;</h1></a>
                            <p class="index_interaction_rankListD">委书记孙永强同志带领全体党员在上海中共一大会址足使每一位党员接受了一次深刻。</p>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="index_rank_num"><img src="../stageRescourse/image/home/n3.png" alt=""></div>
                    <div class="index_rank_content">
                        <div class="index_rank_img">
                            <img src="../stageRescourse/image/home/h2.png" alt="">
                        </div>
                        <div class="index_rank_contents">
                            <a href=""><h1 class="index_interaction_rankListT">建设事业部精益项目终审会&nbsp;</h1></a>
                            <p class="index_interaction_rankListD">委书记孙永强同志带领全体党员在上海中共一大会址足使每一位党员接受了一次深刻。</p>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="index_rank_num"><img src="../stageRescourse/image/home/n4.png" alt=""></div>
                    <div class="index_rank_content">
                        <div class="index_rank_img">
                            <img src="../stageRescourse/image/home/h2.png" alt="">
                        </div>
                        <div class="index_rank_contents">
                            <a href=""><h1 class="index_interaction_rankListT">建设事业部精益项目终审会&nbsp;</h1></a>
                            <p class="index_interaction_rankListD">委书记孙永强同志带领全体党员在上海中共一大会址足使每一位党员接受了一次深刻。</p>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <div class="index_test_fenge">
            <div class="index_test_fengeA"></div>
        </div>
    </div>
    <!-- 在线测评结束 -->

    <!-- 在线互动开始 -->
    <div id="index_interaction">
        <div class="index_module_logo">
            <img src="../stageRescourse/image/home/m3.png" alt="">
        </div>
        <div class="index_interaction_list">
            <div class="index_interaction_rank">
                <div class="index_interaction_top">
                    <div class="index_interaction_logo">
                        <img src="../stageRescourse/image/home/h1.png" alt="">
                    </div>
                    <h1 class="index_interaction_title">互动排行</h1>
                </div>
                <div class="index_interaction_rankList">
                    <a href="" class="index_interaction_img">
                        <img src="../stageRescourse/image/home/h2.png" alt="">
                    </a>
                    <div class="index_interaction_content">
                        <a href=""><h1 class="index_interaction_rankListT">建设事业部精益项目终审会 </h1></a>
                        <p class="index_interaction_rankListD">委书记孙永强同志带领全体党员在上海中共一大会址足使每一位党员接受了一次深刻。</p>
                    </div>
                </div>
                <div class="index_interaction_rankList">
                    <a href="" class="index_interaction_img">
                        <img src="../stageRescourse/image/home/h2.png" alt="">
                    </a>
                    <div class="index_interaction_content">
                        <a href=""><h1 class="index_interaction_rankListT">建设事业部精益项目终审会 </h1></a>
                        <p class="index_interaction_rankListD">委书记孙永强同志带领全体党员在上海中共一大会址足使每一位党员接受了一次深刻。</p>
                    </div>
                </div>
            </div>
            <ul class="index_interaction_personal">
                <li>
                    <a href="" class="index_interaction_personalT">在校学生</a>
                    <p class="index_interaction_personalD">火拼俄罗斯的升级版课程中 在前两个课的基础上实现了用两个浏览器  </p>
                </li>
                <li>
                    <a href="" class="index_interaction_personalT">师资团队</a>
                    <p class="index_interaction_personalD">火拼俄罗斯的升级版课程中 在前两个课的基础上实现了用两个浏览器  </p>
                </li>
                <li>
                    <a href="" class="index_interaction_personalT">毕业学生</a>
                    <p class="index_interaction_personalD">火拼俄罗斯的升级版课程中 在前两个课的基础上实现了用两个浏览器  </p>
                </li>
                <li>
                    <a href="" class="index_interaction_more">
                        <div>
                            <span class="index_test_moreActive"></span>
                            <span></span>
                            <span></span>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <!-- 在线互动结束 -->

    <!-- 师资团队开始 -->
    <div id="index_techer">
        <div class="index_module_logo">
            <img src="../stageRescourse/image/home/m4.png" alt="">
        </div>
        <ul class="index_techer_list">
            <li>
                <div class="index_techer_img">
                    <img src="../stageRescourse/image/home/t1.png" alt="">
                </div>
                <h1 class="index_techer_title">全栈开发团队</h1>
                <p class="index_techer_description">委书记孙永强同志带领全体党员在上海中共一大会址足使每一位党员接受了一次深刻。</p>
            </li>
            <li>
                <div class="index_techer_img">
                    <img src="../stageRescourse/image/home/t2.png" alt="">
                </div>
                <h1 class="index_techer_title">全栈开发团队</h1>
                <p class="index_techer_description">委书记孙永强同志带领全体党员在上海中共一大会址足使每一位党员接受了一次深刻。</p>
            </li>
            <li>
                <div class="index_techer_img">
                    <img src="../stageRescourse/image/home/t3.png" alt="">
                </div>
                <h1 class="index_techer_title">全栈开发团队</h1>
                <p class="index_techer_description">委书记孙永强同志带领全体党员在上海中共一大会址足使每一位党员接受了一次深刻。</p>
            </li>
        </ul>
        <a href="" class="index_techer_more">更多</a>
    </div>
    <!-- 师资团队结束 -->
    <!-- 底部开始 -->
    <footer>
      <div class="contain">
        <img src="../stageRescourse/image/footer/footer_06.png" alt="">
      </div>
    </footer>
    <!-- 底部结束 -->
</body>
</html>