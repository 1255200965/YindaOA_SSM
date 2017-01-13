
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>订单</title>
<link rel="stylesheet" href="<%=path%>/stylesheets/reset.css">

<link href="<%=path%>/stylesheets/bootstrap.min.css" rel="stylesheet" />
<link href="<%=path%>/stylesheets/bootstrap-theme.min.css"
	rel="stylesheet" />
<link href="<%=path%>/stylesheets/bootstrap-treeview.min.css"
	rel="stylesheet" />
<link href="<%=path%>/stylesheets/shujutongji.css" rel="stylesheet" />
<link href="<%=path%>/stylesheets/ddcss.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path%>/stylesheets/header.css">

<script type="text/javascript"
	src="<%=path%>/javascripts/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="<%=path%>/javascripts/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/javascripts/bootstrap-treeview.min.js"></script>
<script src="<%=path%>/javascripts//knockout-3.4.0rc.js"></script>
<style>
* {
	box-sizing: content-box;
	-webkit-box-sizing: content-box;
}

.c_box {
	min-width: 1350px;
	width: 100%;
}

.c_box .col-md-2 {
	min-width: 189px;
	width: 12.4%;
}

.c_box .c_left_box {
	height: 850px;
}

.c_box .c_right_box {
	min-width: 1056.7px;
	width: 79%;
}

.table-1 tbody td {
	font-size: 12px;
}
</style>

</head>
<body>


	<div class="row-fluid c_box" style="">
		
		<div class="col-md-12 " style="background:white;">
			<div class="caidan-tiku" style="margin-bottom: 3%">
				<%--                <div style="float:left">
                    <input data-bind="click:$root.ClickAdd" type="button" value="新增"  class="chaxun">
                </div>--%>
				<div class="caidan-tiku-s" style="margin-right: 5%">
					<span>部门：</span>
					<!--  <select  id="department" class="form-control "><option value="0">无</option></select> -->
					<select id="department" class="riqi-xiala " style="width: 70px;"><option>无</option></select>
				</div>
				<div class="caidan-tiku-s" style="margin-right: 5%">
					<span>项目：</span> <select id="project" class="riqi-xiala "
						style="width: 70px;"></select>
				</div>

				<div class="caidan-tiku-s" style="margin-right: 5%">
					<span>订单号：</span> <input id="order_number" type="text"
						name="workid" class="shuruk-a2" placeholder="">
				</div>
				
				<div style="float: right; margin-right: 15px; padding-bottom: 10px;">
					<input onclick="search_List();" type="button" value="查询"
						class="chaxun">
					
					<input onclick="open_addModel();" type="button"
						style="background: #FEAE1B;" value="新增" class="chaxun">
				</div>
			</div>

			<div
				style="width: 100%; height: 700px; padding-top: 5px; overflow: auto; border: 0 solid #000000;">

				<table width="100%" border="1" cellspacing="0" cellpadding="0"
					class="table-1">
					<thead class="table-1-tou">
						<td class="text_center" width="13%">部门</td>
						<td class="text_center" width="6%">项目</td>
						<td class="text_center" width="15%">订单名</td>
						<td class="text_center" width="14%">订单号</td>
						<!-- <td class="text_center" width="10%">年份</td> -->
						<!-- <td class="text_center" width="18%">邮箱</td>
                    <td class="text_center" width="6%">工号</td>
                    <td class="text_center" width="8%">在职状态</td> -->
						<td class="text_center" width="9%">操作</td>
					</thead>

					<tbody id="tbody">

					</tbody>
				</table>
			</div>

			<%--<div align="center" style="font-size:12px">--%>
			<%--<p>	                <span class="STYLE33">当前是[第  ${currPage}&nbsp;页 / 共有&nbsp;${totalPage}<span class="STYLE7">&nbsp;</span>页]</span>--%>
			<%--<span class="STYLE15"><span class="STYLE20"><a href="javascript:submitByPage(1)">首页</a>--%>
			<%--<a href="javascript:submitByPage(${currPage -1  < 1? 1: currPage-1})">上一页</a>--%>
			<%--<a href="javascript:submitByPage(${currPage+1> totalPage? totalPage: currPage+1 })">下一页</a>--%>
			<%--<a href="javascript:submitByPage(${totalPage})">末页 </a></span></span> </p>--%>
			<%--</div>--%>
		</div>
	</div>
	<div class="row-fluid">
		<div class="footer" data-reactid=".0.a">
			<div style="margin-bottom: 5px;" data-reactid=".0.a.0">
				<span data-reactid=".0.a.0.0"> <img width="11px"
					src="https://gw.alicdn.com/tps/TB14UngLXXXXXXQapXXXXXXXXXX-22-26.png"
					data-reactid=".0.a.0.0.0"></span> <span data-reactid=".0.a.0.1">上海音达科技实业有限公司</span>
			</div>

		</div>
	</div>
	<%--</div>--%>
	<!-- Button trigger modal -->
	<button type="button" id="model1" style="display: none"
		class="btn btn-primary btn-lg" data-toggle="modal"
		data-target="#myModal">modal</button>
	<button type="button" id="model2" style="display: none"
		class="btn btn-primary btn-lg" data-toggle="modal"
		data-target="#myModal2">modal</button>
	<div class="container">
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true"
			data-backdrop="false">
			<div class="modal-dialog c_side_modal_box" role="document"
				style="margin: 0px;">
				<div class="modal-content c_side_modal ">
					<div class="modal-header c_modal_head">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">更新订单信息</h4>
					</div>
					<div class="modal-body c_modal_body">
						<div data-bind="with:changeItem">
							<!-- <div class="c_action_content">手机端展示信息</div> -->
							<div class="c_ding_form">
								<div class="c_ding_form_group">
									<input type="hidden" id="m_id" />
									<!--隐藏id  -->
									<label><i class="iconfont c_ding_from_icon">*</i><span>部门:</span></label>
									<div class="input_content">
										<input class="c_ding_input" id="m_department"
											data-bind="textinput:name" />
									</div>
								</div>

								<div class="c_ding_form_group">
									<label><i class="iconfont c_ding_from_icon">*</i><span>项目:</span></label>
									<div class="input_content">
										<input class="c_ding_input" id="m_project"
											data-bind="textinput:cellphone" />
									</div>
								</div>
								<div class="c_ding_form_group">
									<label><i class="iconfont c_ding_from_icon"></i><span>订单名:</span></label>
									<div class="input_content">
										<input class="c_ding_input" id="m_orderName"
											data-bind="textinput:department" />
									</div>
								</div>

							</div>


						</div>
					</div>
					<div class="modal-footer c_modal_foot">
						<button id="close1" type="button" class="c_ding_btn"
							data-dismiss="modal">Close</button>
						<button type="button" class="c_ding_btn c_ding_btn_primary"
							onclick="update_form();">提交</button>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true"
			data-backdrop="false">
			<div class="modal-dialog c_side_modal_box" role="document"
				style="margin: 0px;">
				<div class="modal-content c_side_modal ">
					<div class="modal-header c_modal_head">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">新增订单信息</h4>
					</div>
					<div class="modal-body c_modal_body">
						<div data-bind="with:changeItem">
							<!-- <div class="c_action_content">PC端展示信息</div> -->
							<div class="c_ding_form">
								<div class="c_ding_form_group">
									<input type="hidden" id="m_id" />
									<!--隐藏id  -->
									<label><i class="iconfont c_ding_from_icon">*</i><span>部门:</span></label>
									<div class="input_content">
										<input class="c_ding_input" id="a_department" />
									</div>
								</div>
								<div class="c_ding_form_group">
									<label><i class="iconfont c_ding_from_icon">*</i><span>项目:</span></label>
									<div class="input_content">
										<input class="c_ding_input" id="a_project" />
									</div>
								</div>
								<div class="c_ding_form_group">
									<label><i class="iconfont c_ding_from_icon">*</i><span>订单名:</span></label>
									<div class="input_content">
										<input class="c_ding_input" id="a_orderName" />
									</div>
								</div>
								<div class="c_ding_form_group">
									<label><i class="iconfont c_ding_from_icon">*</i><span>订单号:</span></label>
									<div class="input_content">
										<input class="c_ding_input" id="a_orderNumber" />
									</div>
								</div>

							</div>


						</div>
					</div>
					<div class="modal-footer c_modal_foot">
						<button id="close1" type="button" class="c_ding_btn"
							data-dismiss="modal">Close</button>
						<button type="button" class="c_ding_btn c_ding_btn_primary"
							onclick="add_form();">提交</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
/**
 * 初始化部门
 */
    $(function (){
    	
    	 var departmenthtml =$("#department").html();  
    	$.post("<%=path%>/order/getDepartment.do",function(json){
    	
    		$.each(json, function (n, value) {
              
               departmenthtml = departmenthtml+"<option value='"+value+"'>"+value+"</option>";              
            });    		
    		 $("#department").html(departmenthtml);
    	});	 
    });

    $("#department").change(function (){    	
    	var projecthtml;
    	var department =$(this).val();
    	
    	if(department=="无"){$("#project").html("");return;}
    	$.post("<%=path%>/order/getProjectByDepartment.do",{'department':department},function(json){    		
    		$.each(json, function (n, value) {                
    			projecthtml = projecthtml +"<option value='"+value+"'>"+value+"</option>";
                
            });
    		
    		 $("#project").html(projecthtml);
    	});
    	
    });
   
   /* 订单查询 */ 
function search_List(){
	var department=$("#department").val();
	var project =$("#project").val();
	var orderNumber=$("#order_number").val();
	var tbody =$("#tbody").html();
	 if(department==null||department==""){
		alert("请选择部门！");
		return;		
	}
 	if(project==null||project==""){
		alert("请选择项目！");
		return;		
	} 
	$.post("<%=path%>/order/search_order.do",{"department":department,"project":project,"orderNumber":orderNumber},function(json){		
	   tbody="";
		$.each(json, function (n, value) {
           tbody = tbody+"<tr>"+
            "<td class='text_center' width='13%'>"+value.department+"</td>"+
            "<td class='text_center' width='13%'>"+value.project+"</td>"+
			"<td class='text_center' width='13%'>"+value.orderName+"</td>"+
			"<td class='text_center' width='13%'>"+value.orderNumber+"</td>"+
			"<td>  <input  type=\"button\" onclick=\"openModel("+value.id+");\" value=\"更新\" class=\"gx-btn\"/>"+
			"<input   type=\"button\" value=\"删除\" onclick='del_Entity("+value.id+");'class=\"gx-btn\" style=\"background:#fd9162;\"/>"+
            "</td>"+
        
			"</tr>";
        });
	     
	    $("#tbody").html(tbody)
		
	});
	
	
	
}
/**
 * 打开更新模态框
 */
function openModel(id){
	
	$.post("<%=path%>/order/get_order_by_id.do",{'id':id},function(json){
		
		$("#m_department").val(json.department);
		$("#m_project").val(json.project);
		$("#m_orderName").val(json.orderName);
		$("#m_id").val(json.id);
		
	});
	
	$("#model1").click();
}

/**
 * 打开新增模态框
 */
function open_addModel(){
	

	 
	$("#model2").click();
}

/**
 * 更新订单
 */
function update_form(){
	var department= $("#m_department").val();
	var project= $("#m_project").val();
	var orderName= $("#m_orderName").val();
	var id= $("#m_id").val();
	$.post("<%=path%>/order/update_order.do", {
			'id' : id,
			'department' : department,
			'project' : project,
			'orderName' : orderName
		}, function(data) {
			alert(data)
		});
	}
	
	
/**
 * 新增订单
 */
function add_form(){
	var department= $("#a_department").val();
	var project= $("#a_project").val();
	var orderName= $("#a_orderName").val();
	var orderNumber= $("#a_orderNumber").val();
	if(""==department){alert("请输入部门！");return;}
	if(""==project)   {alert("请输入项目！");return;}
	if(""==orderName) {alert("请输入订单名！");return;}
	if(""==orderNumber){alert("请输入订单号！");return;}
	$.post("<%=path%>/order/add_order.do", {
			'orderNumber' : orderNumber,
			'department' : department,
			'project' : project,
			'orderName' : orderName		
		}, function(data) {
			alert(data)
		});
	}
/*
 * 删除订单
 */
function del_Entity(id){
	$.post("<%=path%>/order/delete_order.do", {
		'id' : id	
	}, function(data) {
		alert(data)
	});
}	
</script>
</html>
