<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.min.css">
<title>欢迎登陆优逸客综合服务平台</title>
</head>
<body>
	<div class="container">
		<div class="row">&nbsp;</div>
		<div class="row">&nbsp;</div>
		<div class="row">
			<div class="col-xs-6">
				<img src="../images/logo1-0.png" alt="">
			</div>
		</div>
		<hr><br><br><br>
		<div class="row">
			<div class="col-xs-3"></div>
			<form:form action="${pageContext.request.contextPath }/login/dologin" method="post"  name="myform" id="loginform">
			<div class="col-xs-12 col-sm-6">
				<div class="col-xs-12">
					<div class="col-xs-1"></div>
					<div class="col-xs-11">
						<p class="" style="font-size:22px;color:#777777">欢迎您，请先登录!</p>
					</div>
					
				</div>
				<div class="col-xs-12">&nbsp;</div>
				<div class="col-xs-12">
					<div class="col-xs-1"></div>
					<div class="col-xs-3 col-sm-3">
						<p class="" style="font-size:18px;color:#777777">用&nbsp;户&nbsp;名:</p>
					</div>
					<div class="col-xs-7 col-sm-7">
						<input type="text" class="form-control" name="username" size="30" placeholder="请输入姓名或手机号">
					</div>
				</div>
				<div class="col-xs-12">
					<div class="col-xs-4 col-sm-4"></div>
					<div class="col-xs-7 col-sm-7" id="usernameinfo" style="color:red">&nbsp;</div>
				</div>
				<div class="col-xs-12">
					<div class="col-xs-1"></div>
					<div class="col-xs-3 col-sm-3">
						<p class="" style="font-size:18px;color:#777777">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</p>
					</div>
					<div class="col-xs-7 col-sm-7">
						<input type="password" class="form-control" name="password" size="30" placeholder="请输入密码">
					</div>
				</div>
				<div class="col-xs-12">
					<div class="col-xs-4 col-sm-4"></div>
					<div class="col-xs-7 col-sm-7" id="passwordinfo" style="color:red">&nbsp;</div>
				</div>
				
				<div class="col-xs-12">&nbsp;</div>
				<div class="col-xs-12">
					<div class="col-sm-1"></div>
					<div class="col-xs-12 col-sm-9 text-center">
						<div class="col-xs-2"></div>
						<div class="col-xs-8">
							<input title="请输入用户名、密码" class="btn btn-primary btn-md" value="&nbsp;&nbsp;登&nbsp;&nbsp;录&nbsp;&nbsp;" type="submit" style="width:100%" >
						</div>
						
						<!-- <div class="col-xs-6">
							<input class="btn btn-md" value="&nbsp;&nbsp;注&nbsp;&nbsp;册&nbsp;&nbsp;" type="button" style="width:100%">
						</div> -->
						
						
					</div>
					
				</div>
			</div>
			</form:form>
			<div class="col-xs-3"></div>
		</div>
	</div>
	<script type="text/javascript" src="../scripts/jquery-1.11.2.js"></script>
	<!-- <script type="text/javascript">
		$(document).ready(function(){
			/*登录时对输入内容进行校验，如果为空不许提交，如果用户名和密码不对做出提示*/
			$('body').on('submit','#loginform',function(){
				var isname=ispwd=iscode=false;
				username=$('input[name$="username"]').val();
				if (username=='') {
					$('input[name$="username"]').css('border','1px solid red')
					$('#usernameinfo').text('用户名不允许为空');
				}else{
					//如果用户名输入框不为空则验证用户名
					$.ajax({
						async:false,
						url:'{:U("checkname")}',
						type:'post',
						data:{'username':username},
						success:function(msg){
							if (msg=='error') {
								$('input[name$="username"]').css('border','1px solid red')
								$('#usernameinfo').text('用户名不存在');
							}else if(msg=='more'){
								$('input[name$="username"]').css('border','1px solid red')
								$('#usernameinfo').text('姓名重复，请通过手机号登录');
							}else if(msg=='success'){
								$('input[name$="username"]').removeAttr('style');
								$('#usernameinfo').html('&nbsp;');
								isname=true;
							}
						}
					})
				}
				if ($('input[name$="password"]').val()=='') {
					$('input[name$="password"]').css('border','1px solid red')
					$('#passwordinfo').text('密码不允许为空');
				}else{
					//如果密码不为空则验证用户名和密码
					$.ajax({
						async:false,
						url:'{:U("checknamepwd")}',
						type:'post',
						data:$('#loginform').serialize(),
						success:function(msg){
							if (msg=='error') {
								$('input[name$="password"]').css('border','1px solid red');
								$('#passwordinfo').text('密码与用户名不匹配');
							}else{
								$('input[name$="password"]').removeAttr('style');
								$('#passwordinfo').html('&nbsp');
								ispwd=true;
							}
						}
					})
				}

				if ($('input[name$="captcha"]').val()=='') {
					$('input[name$="captcha"]').css('border','1px solid red')
					$('#codeinfo').text('验证码不允许为空');
				}else{
					code=$('input[name$="captcha"]').val();
					//如果验证码不为空则校验验证码
					$.ajax({
						async:false,
						url:'{:U("checkcode")}',
						type:'post',
						data:{'code':code},
						success:function(msg){
							if (msg=='error') {
								$('input[name$="captcha"]').css('border','1px solid red');
								$('#codeinfo').text('验证码不正确');
							}else{
								$('input[name$="captcha"]').removeAttr('style');
								$('#codeinfo').html('&nbsp');
								iscode=true;
							}
						}
					})
				}
				$('.codeimg').attr('src','__URL__/showcode/'+Math.random());
				if (isname&&ispwd&&iscode) {
					return true;
				}else{
					return false;
				}
				
			})
			/*当输入框值发生变化时取消警告红*/
			$('body').on('keyup','input[name$="username"]',function(){
				if ($(this).val()!='') {
					$('input[name$="username"]').removeAttr('style');
					$('#usernameinfo').html('&nbsp;');
				}else{
					$('input[name$="username"]').css('border','1px solid red')
					$('#usernameinfo').text('用户名不允许为空');
				}
			})
			$('body').on('keyup','input[name$="password"]',function(){
				if ($(this).val()!='') {
					$('input[name$="password"]').removeAttr('style');
					$('#passwordinfo').html('&nbsp;');
				}else{
					$('input[name$="password"]').css('border','1px solid red')
					$('#passwordinfo').text('密码不允许为空');
				}
			})
			$('body').on('keyup','input[name$="captcha"]',function(){
				if ($(this).val()!='') {
					$('input[name$="captcha"]').removeAttr('style');
					$('#codeinfo').html('&nbsp;');
				}else{
					$('input[name$="captcha"]').css('border','1px solid red')
					$('#codeinfo').text('验证码不允许为空');
				}
			})
		})
	</script> -->


	<%-- <form:form action="${pageContext.request.contextPath }/index/dologin" method="post" >
		
		userName : <input name="username"/><br><br>
		password :　<input name="password" type="password"/><br><br>
		<input type="submit" value="提交"/>
	</form:form> --%>
</body>
</html>