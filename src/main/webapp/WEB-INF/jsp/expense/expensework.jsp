
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>办事处报销查询</title>
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

<link rel="stylesheet" href="<%=path%>/stylesheets/affairs-search.css" />
<link rel="stylesheet" href="<%=path%>/datePlug/jquery.monthpicker.css" />

<link
	href="<%=path%>/datetimepicker/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" media="screen">


<script src="<%=path%>/datePlug/jquery.monthpicker.js"></script>
<script type="text/javascript"
	src="<%=path%>/javascripts/bootstrap-treeview.min.js"></script>




<script type="text/javascript"
	src="<%=path%>/datetimepicker/js/bootstrap-datetimepicker.js"
	charset="UTF-8"></script>
<script type="text/javascript"
	src="<%=path%>/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"
	charset="UTF-8"></script>

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

		<div class="col-md-12 " style="background: white;">
			<div class="caidan-tiku" style="margin-bottom: 3%">
				<%--                <div style="float:left">
                    <input data-bind="click:$root.ClickAdd" type="button" value="新增"  class="chaxun">
                </div>--%>
				<div class="caidan-tiku-s" style="margin-right: 5%">
					<span>类别：</span> <select id="costClass" class="riqi-xiala "
						name="costClass" style="width: 70px;">
						<option value="税金">税金</option>
						<option value="物业费">物业费</option>
						<option value="月租金 ">月租金</option>
						<option value="电费">电费</option>
						<option value="宽带费">宽带费</option>
						<option value="煤气费">煤气费</option>
						<option value="暖气费">暖气费</option>
						<option value="水费">水费</option>
						<option value="中介费">中介费</option>
					</select>
				</div>
				<div class="caidan-tiku-s" style="margin-right: 5%">
					<span>审批完成时间：</span> <input id="endTime1" type="text"
						class="laydate-icon shuruk-a2 form_date" name="endTime1"
						class="shuruk-a2" placeholder="">
						——
						<input id="endTime2" type="text"
						class="laydate-icon shuruk-a2 form_date" name="endTime2"
						class="shuruk-a2" placeholder="">

				</div>

				<div class="caidan-tiku-s" style="margin-right: 5%">
					<span>审批结果：</span> <select id="result" class="riqi-xiala "
						name="result" style="width: 70px;">
						<option value="同意">同意</option>
						<option value="">暂无</option>
					</select>
				</div>

				<div style="float: right; margin-right: 15px; padding-bottom: 10px;">
					<input onclick="search_List();" type="button" value="查询"
						class="chaxun"> <input onclick="expensework_export();"
						type="button" style="background: green;" value="导出" class="chaxun">
				</div>
			</div>
			<div style="overflow:scroll; width: 100%; height: 700px; ">
				<div
					style=" padding-top: 5px; border: 0 solid #000000;">

					<table width="100%" height="100%" border="1" cellspacing="0" cellpadding="0"
						class="table-1">
						<thead class="table-1-tou">
							<td class="text_center" width="4%">审批编号</td>
							<td class="text_center" width="4%">标题</td>
							<!-- <td class="text_center" width="4%">审批状态</td> -->
							<td class="text_center" width="4%">审批结果</td>
							<!-- <td class="text_center" width="4%">审批发起时间</td>
							<td class="text_center" width="4%">审批完成时间</td> -->
							<td class="text_center" width="4%">发起人工号</td>
							<td class="text_center" width="4%">发起人姓名</td>
							<td class="text_center" width="4%">发起人部门</td>
							<!-- <td class="text_center" width="4%">历史审批人姓名</td>
							<td class="text_center" width="4%">审批记录</td>
							<td class="text_center" width="4%">当前处理人</td>
							<td class="text_center" width="4%">审批耗时</td>
							<td class="text_center" width="4%">所属部门</td>
							<td class="text_center" width="4%">所属项目</td> -->
							<td class="text_center" width="4%">办事处名称</td>
							<td class="text_center" width="4%">费用类别</td>
							<td class="text_center" width="4%">收款人</td>
							<td class="text_center" width="4%">开户银行</td>
							<td class="text_center" width="4%">银行账号</td>
							<td class="text_center" width="4%">总金额</td>
							<td class="text_center" width="4%">发票类型</td>
							<td class="text_center" width="4%">发票号码</td>
						</thead>

						<tbody id="tbody">

						</tbody>
					</table>
				</div>
			</div>
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
    	  
    	    	$('.form_date').datetimepicker({
    	    	    language:  'zh-CN',
    	    	    todayBtn:  1,
    	    		autoclose: 1,
    	    		format:'yyyy-mm-dd',
    	    		minView: "month",
    	    	});
    	    	 	
    	
    });

   
   
   /* 订单查询 */ 
function search_List(){
	var result=$("#result").val();
	var endTime1 =$("#endTime1").val();
	var endTime2 =$("#endTime2").val();
	var costClass=$("#costClass").val();
	var tbody =$("#tbody").html();
	if(endTime1==null||endTime1==""){
		alert("输入审批完成时间！");
		return;		
	} 
	if(endTime2==null||endTime2==""){
		alert("输入审批完成时间！");
		return;		
	} 
 
	$.post("<%=path%>/expenseWork/expenseWork_search.do",{"result":result,"costClass":costClass,"endTime1":endTime1,"endTime2":endTime2},function(json){		
	   tbody="";
		$.each(json, function (n, value) {
           tbody = tbody+"<tr>"+
            "<td class='text_center' width='4%'>"+value.approveNumber+"</td>"+
            "<td class='text_center' width='4%'>"+value.title+"</td>"+
			/* "<td class='text_center' width='4%'>"+value.expenseStatus+"</td>"+ */
			"<td class='text_center' width='4%'>"+value.result+"</td>"+
			/*  "<td class='text_center' width='4%'>"+value.startTime+"</td>"+
	         "<td class='text_center' width='4%'>"+value.endTime+"</td>"+ */
			 "<td class='text_center' width='4%'>"+value.applyStaffId+"</td>"+
			 "<td class='text_center' width='4%'>"+value.applyName+"</td>"+
			 "<td class='text_center' width='4%'>"+value.applyDepartment+"</td>"+
		    /*  "<td class='text_center' width='4%'>"+value.histotyAccess+"</td>"+
		     "<td class='text_center' width='4%'>"+value.historyRecord.substring(0,30)+"...</td>"+
			 "<td class='text_center' width='4%'>"+value.nowAccess+"</td>"+
			 "<td class='text_center' width='4%'>"+value.usedTime+"</td>"+
			 "<td class='text_center' width='4%'>"+value.department+"</td>"+
			 "<td class='text_center' width='4%'>"+value.project+"</td>"+ */
		     "<td class='text_center' width='4%'>"+value.officeSite+"</td>"+
			 "<td class='text_center' width='4%'>"+value.costClass+"</td>"+		 
			 "<td class='text_center' width='4%'>"+value.receiverName+"</td>"+
			 "<td class='text_center' width='4%'>"+value.bank+"</td>"+
			 "<td class='text_center' width='4%'>"+value.brachBank+"</td>"+
		     "<td class='text_center' width='4%'>"+value.totalMoney+"</td>"+
			 "<td class='text_center' width='4%'>"+value.invoiceClass+"</td>"+
			 "<td class='text_center' width='4%'>"+value.invoiceCode+"</td>"+
		
			"</tr>";
        });
	     
	    $("#tbody").html(tbody)
		
	});
	
	
	
}
   
   
  function expensework_export(){
		var result=$("#result").val();
		var endTime1 =$("#endTime1").val();
		var endTime2 =$("#endTime2").val();
		var costClass=$("#costClass").val();
		if(endTime1==null||endTime1==""){
			alert("输入审批完成时间！");
			return;		
		} 
		if(endTime2==null||endTime2==""){
			alert("输入审批完成时间！");
			return;		
		} 
		window.location.href="<%=path%>/expenseWork/expenseWork_export.do?result="+result+"&endTime1="+endTime1+"&costClass="+costClass+"&endTime2="+endTime2;
	 	
  } 
/**
 * 打开更新模态框
 */
function openModel(id){
	
	$.post("<%=path%>/order/get_order_by_id.do", {
			'id' : id
		}, function(json) {

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
	function open_addModel() {

		$("#model2").click();
	}
</script>
</html>
