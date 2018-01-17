<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>员工</title>
	 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
			 <!-- <link href="../assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
		<link href="../assets/css/bui-min.css" rel="stylesheet" type="text/css" /> -->
		<link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/dpl.css" rel="stylesheet">
  <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/bui.css" rel="stylesheet">
		<link href="../assets/css/page-min.css" rel="stylesheet" type="text/css" />   <!-- 下面的样式，仅是为了显示代码，而不应该在项目中使用-->
	 <link href="../assets/css/prettify.css" rel="stylesheet" type="text/css" />
	 <style type="text/css">
		code {
			padding: 0px 4px;
			color: #d14;
			background-color: #f7f7f9;
			border: 1px solid #e1e1e8;
		}
	 </style>
	 <script type="text/javascript" src="__PUBLIC__/js/jquery-1.11.2.js"></script>
	 
 </head>
 <body>
 
 <!-- 搜索 -->
 
	<div class="container">
		<form id="searchForm" class="form-horizontal">
			<div class="row">
				<div class="control-group span8">
					<label class="control-label">姓名：</label>
					<div class="controls">
						<input name="name" type="text" class="control-text">
					</div>
				</div>
				<div class="control-group span8">
					<label class="control-label"><s>*</s>职位：</label>
					<div class="controls" id="s1">
						<input type="text" id="show" name="position_id" class="input-normal control-text">
						<input type="hidden" id="hide"  name="hide">
					</div>
				</div>
					
				<div class="span3 offset2" >
					<button  type="button" id="btnSearch" class="button button-primary">搜索</button>
				</div>
			</div>
			
		</form>
		<div class="container">
			<a href="../../../Public/template/employee.xlsx">下载模板</a>
				<form action="{:U('HrEmployee/importFileEmployee')}" method="post" enctype="multipart/form-data">
					<input type="file" name='file'/>
					<input type="submit" value='导入'/>
				</form>
		</div>
		<div class="search-grid-container">
			<div id="grid"></div>
		</div>
	</div>
	
<!-- 新建 -->

	<div id="content" class="hide">
		 <form id ="J_Form" class="form-horizontal" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/employee/addemployee" >
		 <input type="hidden" id="user_id" name="user_id" value="0">
			<div class="row">
				<div class="control-group span8">
					<label class="control-label"><s>*</s>姓名：</label>
					<div class="controls">
						<input data-rules="{required:true}" name="name" type="text" class="control-text">
					</div>
				</div>
				<div class="control-group span8">
					<label class="control-label"><s>*</s>入职时间：</label>
					<div class="controls">
						<input data-rules="{required:true}" name="hiredate" type="text" class="calendar">
					</div>
				</div>
			</div>
			<div class="row">
			<div class="control-group span8">
				<label class="control-label"><s>*</s>部门：</label>
				<div class="controls" id="s1">
					<input type="text" id="show3" name="show" data-rules="{required:true}" class="input-normal control-text">
					<input type="hidden" id="hide3"  name="department_id">
				</div>
			</div>
				 <div class="control-group span8">
				<label class="control-label"><s>*</s>职位：</label>
				<div class="controls" id="s2">
					<input type="text" id="show2" name="hide" class="input-normal control-text" data-rules="{required:true}">
					<input type="hidden" id="hide2"  name="position_id">
				</div>
			</div>
			</div>
			<div class="row">
				<div class="control-group span8">
					<label class="control-label">性别：</label>
					<div class="controls">
						<select name="sex" id="">
							<option value="1">男</option>
							<option value="0">女</option>
						</select>
					</div>
				</div>
				<div class="control-group span8">
					<label class="control-label"><s>*</s>电话：</label>
					<div class="controls">
						<input name="tel" type="text" class="control-text" data-rules="{required:true}">
					</div>
				</div>
			 	
			</div>
			<div class="row">
				
				<div class="control-group span8">
					<label class="control-label">头像：</label>
					<div class="controls">
						<!-- <input name="photo" type="file" class="control-text" > -->
						<div id="J_Uploader1">
      					</div>
					</div>
				</div>
			 	
			 	<div class="control-group span8">
					<label class="control-label">在职/离职：</label>
					<div class="controls">
						<!-- <input name="photo" type="file" class="control-text" > -->
						<select name="status">
							<option value="">请选择</option>
							<option value="1">在职</option>
							<option value="0">离职</option>
						</select>
					</div>
				</div>
			 	
			</div>

			<input class="photo" type="hidden" name="photo" value="qqq">
			</form>
			</div>
		
		
	<script type="text/javascript" src="../assets/js/jquery-1.8.1.min.js"></script>
	<script src="http://g.alicdn.com/bui/seajs/2.3.0/sea.js"></script>
	<script type="text/javascript" src="../assets/js/bui-min.js"></script>
	<!-- <script type="text/javascript" src="../assets/js/config-min.js"></script> -->
	<script src="http://g.alicdn.com/bui/bui/1.1.21/config.js"></script>
	<!-- 以上一行之前没有 这样在360浏览器 执行Search.createStore时候 报错  -->
  	<script type="text/javascript" src="../assets/js/common/search-min.js"></script>

	<script type="text/javascript">
        BUI.use('bui/uploader',function (Uploader) {
          
      /**
       * 返回数据的格式
       *
       *  默认是 {url : 'url'},否则认为上传失败
       *  可以通过isSuccess 更改判定成功失败的结构
       */
      var uploader = new Uploader.Uploader({
        render: '#J_Uploader',
        url: '{:U("uploadphoto")}',
        //根据业务需求来判断上传是否成功，这里返回一个boolean
        isSuccess: function(result){

        	
          if(result){
          	$('.photo').val(result);
            return true;
          }
          return false;
        }
      }).render();

      var uploader1 = new Uploader.Uploader({
        render: '#J_Uploader1',
        url: '{:U("uploadphoto")}',
        //根据业务需求来判断上传是否成功，这里返回一个boolean
        isSuccess: function(result){

        	
          if(result){
          	$('.photo').val(result);
            return true;
          }
          return false;
        }
      }).render();
    });
    </script>
	<script type="text/javascript">
		BUI.use('common/page');
	</script>

	<script type="text/javascript"> 
	function edit(id){
		$('#user_id').val(id);
	}
//表格

BUI.use('common/search',function (Search) {

		// editing = new BUI.Grid.Plugins.DialogEditing({
		//   contentId : 'content', //设置隐藏的Dialog内容
		//   autoSave : true, //添加数据或者修改数据时，自动保存
		//   triggerCls : 'btn-edit'
		// }),

		/* adding = new BUI.Grid.Plugins.DialogEditing({

				contentId : 'content1', //设置隐藏的Dialog内容
				autoSave : true, //添加数据或者修改数据时，自动保存
				//triggerCls : 'btn-edit',
				editor: {
				buttons:[
					{ text:'添加',
						elCls : 'button button-primary',
						handler : function(){
						alert(111)
							$('#J_Form1').submit();
						}
					},
					{ text:'关闭', elCls : 'button', handler : function(){ this.hide(); } }
				]
			}
		}), */
		editing = new BUI.Grid.Plugins.DialogEditing({

				contentId : 'content', //设置隐藏的Dialog内容
				autoSave : true, //添加数据或者修改数据时，自动保存
				triggerCls : 'btn-edit',
				
		}),
		columns = [
		{title:'工号',dataIndex:'job_number',width:120},
		{title:'&nbsp; 姓名',dataIndex:'name',width:90},
		{title:'&nbsp; 头像',dataIndex:'photo',width:90, renderer : function(value,obj){
			if (value==null||value=='') {
				return "暂无";
			}else{
				return "<img src='__PUBLIC__/"+value+"' width='50px' height='35px'>";
			}
				
		}},
		{title:'&nbsp; 电话',dataIndex:'tel',width:120},
		{title:'入职时间',dataIndex:'hiredate',width:100},
		{title:'&nbsp; 部门',dataIndex:'department_id',width:100},
		{title:'&nbsp; 职位',dataIndex:'position_id',width:100},
		{title:'&nbsp; 性别',dataIndex:'sex',width:100 , renderer : function(value,obj){
			return value=='1'?'男':'女';	
		}},
		{title:'&nbsp; 状态',dataIndex:'status',width:100,renderer:BUI.Grid.Format.enumRenderer({"1":"在职","0":"离职"})},
		{title:'操作',dataIndex:'status',width:200,renderer : function(value,obj){
			editStr1 = '<span class="grid-command btn-edit " title="编辑" onclick="edit('+value+')">编辑</span>',
			delStr = '<span class="grid-command btn-del" title="删除">删除</span>';//页面操作不需要使用Search.createLink
			/*upstatu='<span class="grid-command" title="更改员工职位状态" onclick="uptstatu('+value+','+obj.id+')">更改状态</span>';*/
			return editStr1 + delStr /*+ upstatu*/;
		}}
			],
		store = Search.createStore('${pageContext.request.contextPath }/employee/getAllEmployee',{
			proxy : {
				save : { //也可以是一个字符串，那么增删改，都会往那么路径提交数据，同时附加参数saveType
					addUrl : "${pageContext.request.contextPath }/employee/addemployee",
					updateUrl : "${pageContext.request.contextPath }/employee/updateEmployee",
					removeUrl : "${pageContext.request.contextPath }/employee/delete"
				},
				method : 'POST'
			},
			autoSync : true ,//保存数据后，自动更新
			pageSize:10
		});
	 var  gridCfg = Search.createGridCfg(columns,{
				tbar : {
					items : [
						{text : '<i class="icon-plus"></i>新建',btnCls : 'button button-small',handler:addFunction},
						{text : '<i class="icon-remove"></i>删除',btnCls : 'button button-small',handler : delFunction}
					]
				},
				emptyDataTpl:'<div class="centered"><img alt="Crying" src="__PUBLIC__/img/nodata.png"><h2>查询的数据不存在</h2></div>',
				plugins : [editing,BUI.Grid.Plugins.CheckSelection,BUI.Grid.Plugins.AutoFit] // 插件形式引入多选表格

	 });
		
	var  search = new Search({
			store : store,
			gridCfg : gridCfg
		}),
		grid = search.get('grid');

	function addFunction(){
		var newData = {isNew : true,id:0}; //标志是新增加的记录
		editing.add(newData,'name'); //添加记录后，直接编辑
	}

	//删除操作
	function delFunction(){
		var selections = grid.getSelection();
		delItems(selections);
	}

	function delItems(items){
		var ids = [];
		BUI.each(items,function(item){
			ids.push(item.id);
		});

		if(ids.length){
			BUI.Message.Confirm('确认要删除选中的记录么？',function(){
				store.save('remove',{ids : ids});
			},'question');
		}
	}

	//监听事件，删除一条记录
	grid.on('cellclick',function(ev){
		var sender = $(ev.domTarget); //点击的Dom
		if(sender.hasClass('btn-del')){
			var record = ev.record;
			delItems([record]);
		}
	});
});

//搜索职位结构查询

BUI.use(['bui/extensions/treepicker','bui/tree','bui/data'],function(TreePicker,Tree,Data){

		//树节点数据，
		//text : 文本，
		//id : 节点的id,
		//leaf ：标示是否叶子节点，可以不提供，根据childern,是否为空判断
		//expanded ： 是否默认展开
		var store2 = new Data.TreeStore({
				root : {
					id : '0',
					text : '0'
				},
				url : "${pageContext.request.contextPath }/position/tree",
				autoLoad : true/**/
			}),
		//由于这个树，不显示根节点，所以可以不指定根节点
		tree = new Tree.TreeList({
			store : store2,
			//dirSelectable : false,//阻止树节点选中
			showLine : true //显示连接线
			//deepCascade : true
		});

	var  picker = new TreePicker({
			trigger : '#show',
			valueField : '#hide', //如果需要列表返回的value，放在隐藏域，那么指定隐藏域
			width:150,  //指定宽度
			children : [tree] //配置picker内的列表
		});

	picker.render();

	//数据加载完成后，执行选中操作
	store2.on('load',function(){
		var value = '0';
		picker.setSelectedValue(value);
	});
});



//新建职位结构查询

BUI.use(['bui/extensions/treepicker','bui/tree','bui/data'],function(TreePicker,Tree,Data){

		//树节点数据，
		//text : 文本，
		//id : 节点的id,
		//leaf ：标示是否叶子节点，可以不提供，根据childern,是否为空判断
		//expanded ： 是否默认展开
		var store2 = new Data.TreeStore({
				root : {
					id : '0',
					text : '0'
				},
				url : "${pageContext.request.contextPath }/position/tree",
				autoLoad : true/**/
			}),
		//由于这个树，不显示根节点，所以可以不指定根节点
		tree = new Tree.TreeList({
			store : store2,
			//dirSelectable : false,//阻止树节点选中
			showLine : true //显示连接线
		});

	var  picker = new TreePicker({
			trigger : '#show2',
			valueField : '#hide2', //如果需要列表返回的value，放在隐藏域，那么指定隐藏域
			width:150,  //指定宽度
			children : [tree] //配置picker内的列表
		});

	picker.render();

	//数据加载完成后，执行选中操作
	store2.on('load',function(){
		var value = '0';
		picker.setSelectedValue(value);
	});
});

//新建部门结构查询

BUI.use(['bui/extensions/treepicker','bui/tree','bui/data'],function(TreePicker,Tree,Data){

		var store2 = new Data.TreeStore({
				root : {
					id : '0',
					text : '0'
				},
				url : "${pageContext.request.contextPath }/department/tree",
				autoLoad : true/**/
			}),
		//由于这个树，不显示根节点，所以可以不指定根节点
		tree = new Tree.TreeList({
			store : store2,
			//dirSelectable : false,//阻止树节点选中
			showLine : true //显示连接线
		});

	var  picker = new TreePicker({
			trigger : '#show3',
			valueField : '#hide3', //如果需要列表返回的value，放在隐藏域，那么指定隐藏域
			width:150,  //指定宽度
			children : [tree] //配置picker内的列表
		});

	picker.render();

	//数据加载完成后，执行选中操作
	store2.on('load',function(){
		var value = '0';
		picker.setSelectedValue(value);
	});
});
</script>
<script type="text/javascript">
	function uptstatu(status,id){
		$.ajax({
			url:"{:U('admin/HrEmployee/uptstatu')}?status="+status+"&id="+id,
			success:function(){
				window.location.reload();
			}
		})
	}
</script>
</body>
</html>

