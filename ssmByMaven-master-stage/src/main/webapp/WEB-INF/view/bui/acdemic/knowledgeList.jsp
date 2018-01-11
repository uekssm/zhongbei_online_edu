<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/dpl.css" rel="stylesheet">
  <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/bui.css" rel="stylesheet">
    <!-- <link href="../assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/css/bui-min.css" rel="stylesheet" type="text/css" /> -->
    <link href="../assets/css/page-min.css" rel="stylesheet" type="text/css" />   

<script type="text/javascript">

function grant_role(value){

    var arrobj = value.split(",");
    $(".roleclass").each(function(i,v){
          $(v).attr('checked',false)
    });
    for(i=0;i<arrobj.length;i++){
      var val=arrobj[i]
      $(".roleclass[value="+val+"]").attr('checked','checked')
    }
   
}

</script>
   <style type="text/css">
    code {
      padding: 0px 4px;
      color: #d14;
      background-color: #f7f7f9;
      border: 1px solid #e1e1e8;
    }
   </style>
 </head>
 <body>

  <div class="container">
    <div class="row">
      <form id="searchForm" class="form-horizontal span24">
        <div class="row">

          <div class="control-group span8">
            <label class="control-label">名称：</label>
            <div class="controls">
              <input type="text" class="control-text" name="universityname">
            </div>
          </div>
          <div class="control-group span8">
            <label class="control-label">状态：</label>
            <div class="controls">
              <select name="status" class="control-text">
              	<option value="0">请选择</option>
                <option value="1">正常</option>
                <option value="2">禁用</option>
              </select>
            </div>
          </div>
          <div class="span3 offset2">
            <button  type="button" id="btnSearch" class="button button-small button-primary">搜索</button>
          </div>
        </div>
      </form>
    </div>
    <div class="search-grid-container">
      <div id="grid"></div>
    </div>

  </div>
  <div id="content" class="hide">
      <form id="J_Form" class="form-horizontal" action="<{:U('university/add')}>">
       <!--  <input type="hidden" name="id"> -->
        <div class="row">
          <div class="control-group span8">
            <label class="control-label"><s>*</s>知识点编号</label>
            <div class="controls">
              <input name="num" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
        </div>
        <div class="row">
          <div class="control-group span8">
            <label class="control-label"><s>*</s>知识点名称</label>
            <div class="controls">
              <input name="name" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
        </div>
       <div class="row">
	        	<div class="control-group span8">
		        	<label class="control-label"><s>*</s>是否重点</label>
		            <div class="controls">
		              	<select  data-rules="{required:true}"  name="is_important" class="input-normal">
			                <option value="">请选择</option>
			                <option value="0">否</option>
			                <option value="1">是</option>
		              	</select>
		            </div>
	            </div>
        </div>
        <div class="row">
	        	<div class="control-group span8">
		        	<label class="control-label"><s>*</s>是否难点</label>
		            <div class="controls">
		              	<select  data-rules="{required:true}"  name="is_difficult" class="input-normal">
			                <option value="">请选择</option>
			                <option value="0">否</option>
			                <option value="1">是</option>
		              	</select>
		            </div>
	            </div>
        </div>
        <div class="row">
          <div class="control-group span8">
            <label class="control-label"><s>*</s>上传视频</label>
            <div class="controls">
            	<div id="J_Uploader">
      			</div>
              	<input name="video" type="hidden" class="videourl">
            </div>
          </div>
        </div>
      </form>
    </div>
    
	<!-- 绑定角色 id="J_Form_Bind_Role" class="form-horizontal" action="<{:U('university/bindRoles')}>" -->
    <div id="contentForBindRole" class="hide">
      <form id="J_Form_Bind_Role" class="form-horizontal">
      	<video height="400px" width="400px" controls="controls" autoplay="autoplay">
		  <source src="${pageContext.request.contextPath }/resourse/upload/upload1.mp4" type="video/mp4" />
		  Your browser does not support the video tag.
		</video>
      </form>
    </div>

<embed src=mms://61.175.132.221/tv/mtv/f4/makeawish.wmv width=200 height=200 autostart=true loop=true></embed>
  
  <script type="text/javascript" src="../assets/js/jquery-1.8.1.min.js"></script>

  <script type="text/javascript" src="../assets/js/bui-min.js"></script>
  <script src="http://g.alicdn.com/bui/seajs/2.3.0/sea.js"></script>
  <script src="http://g.alicdn.com/bui/bui/1.1.21/config.js"></script>

  <!-- <script type="text/javascript" src="../assets/js/config-min.js"></script> -->

  <!-- 以上一行之前没有 这样在360浏览器 执行Search.createStore时候 报错  -->
  <script type="text/javascript" src="../assets/js/common/search-min.js"></script>



  <script type="text/javascript">
    BUI.use('common/page');
  </script>

<script type="text/javascript">
	$('body').on('click','.btn-grant',function(){
		$('.showVideo').html($(this).attr('videoURL'))
	})


  BUI.use('common/search',function (Search) {

      editing = new BUI.Grid.Plugins.DialogEditing({
        contentId : 'content', //设置隐藏的Dialog内容
        autoSave : true, //添加数据或者修改数据时，自动保存
        triggerCls : 'btn-edit'
      }),

      BUI.Editor.DialogEditor

      granting = new BUI.Grid.Plugins.DialogEditing({

          contentId : 'contentForBindRole', //设置隐藏的Dialog内容
          autoSave : true, //添加数据或者修改数据时，自动保存
          triggerCls : 'btn-grant',
          editor: {
        	  		buttons:[
                            /* { text:'点击绑定',
                              elCls : 'button button-primary',
                              handler : function(){

                            	  //console.log(this.__attrVals.editValue.id);
                            	  //alert($("input:checked").size());

                            	  var university_id = this.__attrVals.editValue.id;
								                
                                var role_ids = "";

                            	  $("input:checked").each(function(){
                            		  role_ids += "," + $(this).val()  ;
                            	  });

                            	  $.post("bind_Roles", { university_id: university_id, role_ids: role_ids },
                            			 function(data){
                            			     alert("绑定成功! ");
                            			     //this.hide();
                            	     }
                                );

                           	  }

                            }, */
                            { "text":'关闭', "elCls" : 'button', "handler" : function(){ this.hide(); } }
                ]
      		},
        }),

      columns = [
          {title:'知识点编号',dataIndex:'num',width:80},
          {title:'知识点名称',dataIndex:'name',width:200},
         /*  {title:'顺序',dataIndex:'sequence',width:50}, */
          {title:'是否难点',dataIndex:'is_difficult',width:80,renderer:BUI.Grid.Format.enumRenderer({'1':'是','2':'否'})},
          {title:'是否重点',dataIndex:'is_important',width:80,renderer:BUI.Grid.Format.enumRenderer({'1':'是','2':'否'})},
          {title:'所属课程',dataIndex:'course_name',width:200}, 
          {title:'操作',dataIndex:'roles',width:200,renderer : function(value,obj){
        	  //console.log(obj);
        	  if(obj.universityname=='admin'&&"<{$Think.session.university.universityname}>"!="admin"){
        		  return '';
              }else{
            	  editStr1 = '<span class="grid-command btn-edit" title="编辑">编辑</span>',
            	  grantStr = '<span class="grid-command btn-grant" title="查看视频" videoURL='+obj.video+'>查看视频</span>',
                  delStr = '<span class="grid-command btn-del" title="删除">删除</span>';//页面操作不需要使用Search.createLink
                return editStr1 + grantStr + delStr;
              }
          }}
        ],
      store = Search.createStore('${pageContext.request.contextPath }/knowledge/getAllKnowledge',{
        proxy : {
          save : { //也可以是一个字符串，那么增删改，都会往那么路径提交数据，同时附加参数saveType
            addUrl : "${pageContext.request.contextPath }/knowledge/addKnowledge",
            updateUrl : "{:U('Sysuniversity/update')}",
            bindRolesUrl : "{:U('Sysuniversity/bindRoles')}",
            grantUrl : "{:U('Sysuniversity/grant')}",
            removeUrl : "{:U('Sysuniversity/delete')}"
          },
          //method : 'POST',
        },
        autoSync : true ,//保存数据后，自动更新
        pageSize:10
      });
      if("<{$Think.session.university.universityname}>"=="admin"){
     var  gridCfg = Search.createGridCfg(columns,{
          tbar : {
            items : [
              {text : '<i class="icon-plus"></i>新建',btnCls : 'button button-small',handler:addFunction},
              {text : '<i class="icon-remove"></i>删除',btnCls : 'button button-small',handler : delFunction}
            ]
          },
          emptyDataTpl:'<div class="centered"><img alt="Crying" src="__PUBLIC__/img/nodata.png"><h2>查询的数据不存在</h2></div>',
          plugins : [editing,granting,BUI.Grid.Plugins.CheckSelection,BUI.Grid.Plugins.AutoFit] // 插件形式引入多选表格

     });
      }else{
    	     var  gridCfg = Search.createGridCfg(columns,{
    	          tbar : {
    	            items : [
    	              {text : '<i class="icon-plus"></i>新建',btnCls : 'button button-small',handler:addFunction},
    	              {text : '<i class="icon-remove"></i>删除',btnCls : 'button button-small',handler : delFunction}
    	            ]
    	          },
    	          emptyDataTpl:'<div class="centered"><img alt="Crying" src="__PUBLIC__/img/nodata.png"><h2>查询的数据不存在</h2></div>',
    	          plugins : [editing,granting,BUI.Grid.Plugins.CheckSelection,BUI.Grid.Plugins.AutoFit] // 插件形式引入多选表格

    	     });
      }
    var  search = new Search({
        store : store,
        gridCfg : gridCfg
      }),
      grid = search.get('grid');

    function addFunction(){
      var newData = {isNew : true}; //标志是新增加的记录
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

  BUI.use(['bui/select','bui/data'],function(Select,Data){

	    var store1 = new Data.Store({
	      url : "{:U('Sysuniversity/addInput')}",
	      autoLoad : true
	    }),

	    select = new Select.Select({
	      render:'#s1',
	      valueField:'#roles',
	      multipleSelect : true,
	      store : store1
	    });
	    select.render();

	    select1 = new Select.Select({
		      render:'#s2',
		      valueField:'#roles',
		      multipleSelect : true,
		      store : store1
		    });
		    select1.render();

	  });

</script>
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
        url: '${pageContext.request.contextPath }/knowledge/upload/',
        //rules: {
	         //文的类型
	         //ext: ['.mp4','文件类型只能为{0}'],
	         //上传的最大个数
	         //max: [1, '文件的最大个数不能超过{0}个'],
	         //文件大小的最小值,这个单位是kb
	         //minSize: [10, '文件的大小不能小于{0}KB'],
	         //文件大小的最大值,单位也是kb
	         //maxSize: [2048, '文件大小不能大于2M']
	    //},
	    //根据业务需求来判断上传是否成功
	    isSuccess: function(result){
	    	
	    	//console.log(JSON.parse(result));
	        if(result && result.url){
	        	$(".videourl").val(result.url);
	            BUI.Message.Alert("上传成功" );
	            
	        }else{
	            BUI.Message.Alert("上传失败");
	        } 
	    }
      }).render();
    });
    </script>
</body>
</html>
