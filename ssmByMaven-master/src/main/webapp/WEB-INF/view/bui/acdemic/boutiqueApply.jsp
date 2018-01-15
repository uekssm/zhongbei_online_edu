<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.min.css">
	<link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/dpl.css" rel="stylesheet">
  <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/bui.css" rel="stylesheet">
	<style type="text/css">
		table{
			margin-top: 40px;
		}

		.modal-table{
			margin-top:0;
		}

		.modal-table td{
			text-align: center;
		}
	</style>

	<script type="text/javascript" src="../scripts/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="../scripts/bootstrap/bootstrap.min.js"></script>
	 <!-- <script src="http://g.tbcdn.cn/fi/bui/jquery-1.8.1.min.js"></script> -->
  <script src="http://g.alicdn.com/bui/seajs/2.3.0/sea.js"></script>
  <script src="http://g.alicdn.com/bui/bui/1.1.21/config.js"></script>
</head>
<body>

	
	<div class="container">
		<div class="col-xs-2"></div>
		<div class="col-xs-8">
			<form id="J_Form" action="${pageContext.request.contextPath }/boutique/addBoutique" method="post" enctype="multipart/form-data">
				<table class="table">
					
					<tr>
						<td>请输入课程编号</td>
						<td>
							<input name="num" data-rules="{required:true}">
								
						</td>
					</tr>
					
					
					<tr>
						<td colspan="2">
							<button class="btn btn-primary" type="submit">确认录入</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div class="col-xs-2"></div>
	</div>

	<script type="text/javascript">
		$(function(){
			$('.selcollege').change(function(){
				var collegeid=this.value;
				$.ajax({
					url:"${pageContext.request.contextPath }/subject/getSubjectByCollegeId?collegeid="+collegeid,
					success:function(res){
						console.log(res);
					}
				});
			});
		});
	</script>
	<script type="text/javascript">
        BUI.use('bui/calendar',function(Calendar){
            var datepicker = new Calendar.DatePicker({
              trigger:'.calendar-time',
              showTime:true,
              autoRender : true
            });
        });
      </script>

      <script type="text/javascript">
      BUI.use('bui/form',function(Form){
      
      new Form.Form({
        srcNode : '#J_Form'
      }).render();
      
  });  
      
</script>
</body>
</html>