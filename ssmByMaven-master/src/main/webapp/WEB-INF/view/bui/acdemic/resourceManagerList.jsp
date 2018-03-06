<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
    <!-- <link href="../assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/css/page-min.css" rel="stylesheet" type="text/css" />    -->
	<link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/dpl.css" rel="stylesheet">
  <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/bui.css" rel="stylesheet">
		<link href="../assets/css/page-min.css" rel="stylesheet" type="text/css" />   <!-- 下面的样式，仅是为了显示代码，而不应该在项目中使用-->
	 <link href="../assets/css/prettify.css" rel="stylesheet" type="text/css" />
	 <style>
	 	a,a:link,a:visited{ 
	 		text-decoration:none; 
	 	} 
	 </style>
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
		  <div class="span3">
		  	<input type="file" id="btn_file" style="display:none" onchange="uploadFile(this)" name="myfile">
            <button  type="button" class="button button-success" onclick="F_Open_dialog()"><i class="icon-white icon-arrow-up"></i> 上传文件</button>
          </div>
          <div class="span3">
            <button  type="button" class="button" id="btnShow">新建文件夹</button>
          </div>
          <div class="span2">
            <button  type="button" class="button">下载</button>
          </div>
          <div class="span2">
            <button  type="button" class="button">删除</button>
          </div>
          <div class="control-group span6">
            
            <div class="controls">
              <input type="text" class="control-text" name="searchname" placeholder="搜索所有文件">
            </div>
          </div>
          
          <div class="span3">
            <button  type="button" id="btnSearch" class="button button-primary">搜索</button>
          </div>
        </div>
      </form>
    </div>
    <div class="row">
    
	    <div class="span18">
	      
	      <ul class="breadcrumb" style="margin-bottom:-20px">
	      	<li><a href="${pageContext.request.contextPath }/resourceManager/index?pid=${requestScope.id }&ppid=${requestScope.iid}"><i class="icon icon-arrow-left"></i>&nbsp;&nbsp;返回上一级</a> <span class="divider">|</span></li>
	        <c:if test="${requestScope.folderList.size()>0}">
	        	
	        </c:if>
	        <c:choose>  
  
			   <c:when test="${requestScope.folderList.size()>0}">    
					<li><a href="${pageContext.request.contextPath }/resourceManager/index?pid=0&ppid=0"><i class="icon icon-inbox"></i>&nbsp;&nbsp;根目录</a><span class="divider">></span></li>
			        <!-- <li><a href="#" class="folders">一级目录</a> <span class="divider">></span></li>
			        <li class="active folders">二级目录</li> -->
			        <c:forEach items="${requestScope.folderList }" var="res" varStatus="stat">
			        		<li 
			        		<c:if test="${stat.last }">
			        			class="active"
			        		</c:if>
			        		><a href="${pageContext.request.contextPath }/resourceManager/index?pid=${res.id }&ppid=${res.pid}" class="folders">${res.name}</a>
			        		<c:if test="${!stat.last }">
			        			<span class="divider">></span>
			        			
			        		</c:if>
			        		</li>
			        		
			        	
			        </c:forEach>
			   </c:when>  
			     
			   <c:otherwise>  
					<li class="active"><i class="icon icon-inbox"></i>&nbsp;&nbsp;根目录</li>
			   </c:otherwise>  
			</c:choose>
	        
	      </ul>
	    </div>
	</div>
	<c:if test="${requestScope.pid>0 }">
		<input type="hidden" value="${requestScope.pid }" id="curfolderid">
	</c:if>
    <div class="search-grid-container">
      <div id="grid"></div>
    </div>

  </div>
  <div id="content" class="hide">
      <form id="J_Form" class="form-horizontal" action="<{:U('User/add')}>">
        <input type="hidden" name="id">
        <div class="row">
          <div class="control-group span8">
            <label class="control-label"><s>*</s>姓名</label>
            <div class="controls">
              <input name="username" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
          </div>
        <div class="row">
          <div class="control-group span8">
            <label class="control-label"><s>*</s>密码</label>
            <div class="controls">
              <input name="password" type="password" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
        </div>
       <div class="row">
	        	<div class="control-group span8">
		        	<label class="control-label"><s>*</s>用户状态</label>
		            <div class="controls">
		              	<select  data-rules="{required:true}"  name="status" class="input-normal">
			                <option value="">请选择</option>
			                <option value="0">禁用</option>
			                <option value="1">正常</option>
		              	</select>
		            </div>
	            </div>
        </div>
      </form>
    </div>
    
	<!-- 绑定角色 id="J_Form_Bind_Role" class="form-horizontal" action="<{:U('User/bindRoles')}>" -->
    <div id="contentForBindRole" class="hide">
      <form id="J_Form_Bind_Role" class="form-horizontal">
        <input type="hidden" name="id">
        <c:forEach items="${requestScope.allrole }" var="roleInfo">
        	<input class="roleclass" type="checkbox" name="roles[]" value="${roleInfo.id}" checked="true" />  ${roleInfo.name}<br>
        </c:forEach>
      
      </form>
    </div>


  
  <script type="text/javascript" src="../assets/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript" src="../scripts/ajaxfileupload.js"></script>

  <script type="text/javascript" src="../assets/js/bui-min.js"></script>

  <script type="text/javascript" src="../assets/js/config-min.js"></script>

  <!-- 以上一行之前没有 这样在360浏览器 执行Search.createStore时候 报错  -->
  <script type="text/javascript" src="../assets/js/common/search-min.js"></script>



  <script type="text/javascript">
    BUI.use('common/page');
  </script>

<script type="text/javascript">
  if($('#curfolderid').val()){
  	arg='?pid='+$('#curfolderid').val();
  }else{
  	arg='';
  }
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
                            { text:'点击绑定',
                              elCls : 'button button-primary',
                              handler : function(){
								  var winthis=this;
                            	  var user_id = this.__attrVals.editValue.id;
								                
                                  var role_ids = "";

                            	  $("input:checked").each(function(){
                            		  role_ids += "," + $(this).val()  ;
                            	  });
								  role_ids=role_ids.substring(1);
                            	  $.post("bind_Roles", { user_id: user_id, role_ids: role_ids },
                            			 function(data){
                            			     alert("绑定成功! ");
                            			     winthis.hide();
                            	     }
                                );

                           	  }

                            },
                            { "text":'关闭', "elCls" : 'button', "handler" : function(){ this.hide(); } }
                ]
      		},
        }),

      columns = [
          {title:'文件名',dataIndex:'name',width:800,renderer:function(value,obj){
          	icon='';
          	
          	console.log(obj);
          	
          	if(obj.type==0){
          		icon='icon-folder-close';
          		return "<a href='${pageContext.request.contextPath }/resourceManager/index?foldername="+value+"&pid="+obj.id+"&ppid="+obj.pid+"'><i class='icon "+icon+"'></i>&nbsp;&nbsp;&nbsp;"+value+"</a>";
          	}else{
          		houzhui=value.substring(value.lastIndexOf('.')+1);
          		if(houzhui=='jpg' || houzhui=='jpeg' || houzhui=='gif' || houzhui=='png'){
          			icon='icon-picture';
          		}else if(houzhui=='mp4' || houzhui=='rmvb' || houzhui=='wmv'){
          			icon='icon-film';
          		}else if(houzhui=='txt' || houzhui=='doc' || houzhui=='docx'){
          			icon='icon-file';
          		}
	          	return "<a href='${pageContext.request.contextPath }/"+obj.url+"'><i class='icon "+icon+"'></i>&nbsp;&nbsp;&nbsp;"+value+"</a>";
          	}
          }},
          {title:'大小',dataIndex:'size',width:100},
          {title:'时间',dataIndex:'addtime',width:100}
          
          /* {title:'操作',dataIndex:'roles',width:200,renderer : function(value,obj){
        	  //console.log(obj);
        	  if(obj.username=='admin'&&"<{$Think.session.user.username}>"!="admin"){
        		  return '';
              }else{
            	  editStr1 = '<span class="grid-command btn-edit" title="编辑">编辑</span>',
            	  grantStr = '<span class="grid-command btn-grant" title="授权" onclick="grant_role(\''+value+'\')">绑定角色</span>',
                  delStr = '<span class="grid-command btn-del" title="删除">删除</span>';//页面操作不需要使用Search.createLink
                return editStr1 + grantStr + delStr;
              }
          }} */
        ],
      store = Search.createStore('${pageContext.request.contextPath }/resourceManager/getAllResourceManager'+arg,{
        proxy : {
          save : { //也可以是一个字符串，那么增删改，都会往那么路径提交数据，同时附加参数saveType
            addUrl : "{:U('SysUser/add')}",
            updateUrl : "{:U('SysUser/update')}",
            bindRolesUrl : "{:U('SysUser/bindRoles')}",
            grantUrl : "{:U('SysUser/grant')}",
            removeUrl : "{:U('SysUser/delete')}"
          },
          method : 'POST',
        },
        autoSync : true ,//保存数据后，自动更新
        pageSize:10
      });
      if("<{$Think.session.user.username}>"=="admin"){
     var  gridCfg = Search.createGridCfg(columns,{
          tbar : {
            items : [
              /* {text : '<i class="icon-plus"></i>新建',btnCls : 'button button-small',handler:addFunction},
              {text : '<i class="icon-remove"></i>删除',btnCls : 'button button-small',handler : delFunction} */
            ]
          },
          emptyDataTpl:'<div class="centered"><img alt="Crying" src="__PUBLIC__/img/nodata.png"><h2>查询的数据不存在</h2></div>',
          plugins : [editing,granting,BUI.Grid.Plugins.CheckSelection,BUI.Grid.Plugins.AutoFit] // 插件形式引入多选表格

     });
      }else{
    	     var  gridCfg = Search.createGridCfg(columns,{
    	          tbar : {
    	            items : [
    	              /* {text : '<i class="icon-plus"></i>新建',btnCls : 'button button-small',handler:addFunction},
    	              {text : '<i class="icon-remove"></i>删除',btnCls : 'button button-small',handler : delFunction} */
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

  BUI.use(['bui/select','bui/data'],function(Select,Data){

	    var store1 = new Data.Store({
	      url : "{:U('SysUser/addInput')}",
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
function F_Open_dialog() 
{ 
	document.getElementById("btn_file").click(); 
}

function uploadFile(obj) {  
	pid=$('#curfolderid').val();
	if(pid>0){
	}else{
		pid=0;
	}
	parentdir='resourse/manager/';
  	$('.folders').each(function(k,v){
  		parentdir=parentdir+$(v).text()+'/';
  	});
    $.ajaxFileUpload({  
        url : "http://localhost:8080/ssm/resourceManager/fileUpload?parentdir="+parentdir+"&pid="+pid,  
        secureuri : false,// 一般设置为false  
        fileElementId : "btn_file",// 文件上传表单的id <input type="file" id="fileUpload" name="file" />  
        dataType : 'json',// 返回值类型 一般设置为json  
        type:'post',  
        success : function(data) // 服务器成功响应处理函数  
        {  
            alert("上传成功");
            location.reload();    
        },  
        error : function(data)// 服务器响应失败处理函数  
        {  
            console.log("服务器异常");  
        }  
    });  
    return false;  
} 
</script>
<script type="text/javascript">
        BUI.use('bui/overlay',function(Overlay){
          var dialog = new Overlay.Dialog({
            title:'请输入文件夹名称',
            width:500,
            height:150,
            align: {
              //node : '#t1',//对齐的节点
              points: ['tl','tl'], //对齐参考：http://dxq613.github.io/#positon
              offset: [10,10] //偏移
            },
            bodyContent:'<div style="text-align:center"><span style="font-size:16px">输入文件夹名称 </span>&nbsp;&nbsp;<input type="text" class="control-text" name="foldername"></div>',
            success:function () {
              parentdir='resourse/manager/';
		  	  $('.folders').each(function(k,v){
		  	  	alert($(v).text())
		  		parentdir=parentdir+$(v).text()+'/';
		  	  });
		  	  pid=$('#curfolderid').val();
		  	  if(pid>0){
				}else{
					pid=0;
				}
		  	  foldername=$('input[name=foldername]').val();
              $.ajax({
              	url:"http://localhost:8080/ssm/resourceManager/makedir?parentdir="+parentdir+"&foldername="+foldername+"&pid="+pid,
              	success:function(){
              		alert("创建成功");
            		location.reload(); 
              	}
              });
              
              this.close();
            }
          });
        $('#btnShow').on('click',function () {
          dialog.show();
        });
    });
  </script>
</body>
</html>
