<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<meta charset="utf-8" />
<title>待审批列表</title>

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
<body>



	<div class="row-fluid c_box" style="background: white;">
	
		<div class="col-md-12">
			<div class="caidan-tiku" style="margin-bottom: 3%">
				               <div style="float:left">
                    <input data-bind="click:$root.ClickAdd" type="button" value="新增"  class="chaxun">
                </div>
				<div class="caidan-tiku-s" style="margin-right: 5%">
					<span>目标项目：</span>
					<!--  <select  id="branchCompany" class="form-control "><option value="0">无</option></select> -->
					<select id="branchCompany" name="branchCompany" class="riqi-xiala "
						style="width: 70px;"><option>无</option></select>
				</div>
				<div class="caidan-tiku-s" style="margin-right: 5%">
					<span>目标订单：</span>
					<!--  <select  id="branchCompany" class="form-control "><option value="0">无</option></select> -->
					<select id="branchCompany" name="branchCompany" class="riqi-xiala "
						style="width: 70px;"><option>无</option></select>
				</div>
				<div class="caidan-tiku-s" style="margin-right: 5%"></div>

				<div class="caidan-tiku-s" style="margin-right: 5%">
					<span>生效日期</span> <input id="salarydate" type="text"
						class="laydate-icon shuruk-a2 form_date" name="salarydate"
						class="shuruk-a2" placeholder=""> —— <input
						id="salarydate" type="text"
						class="laydate-icon shuruk-a2 form_date" name="salarydate"
						class="shuruk-a2" placeholder="">
				</div>	
				<div style="float: right; margin-right: 15px; padding-bottom: 10px;">
					<input onclick="search_List();" type="button" value="查询"
						class="chaxun">
					<input type="button" style="background: green;" value="多条通过"
						class="chaxun" onclick="export_List();">
				</div>
			</div>

			<div
				style="width: 100%; height: 700px; padding-top: 5px; overflow: auto; border: 0 solid #000000;">

				<table width="100%" border="1" cellspacing="0" cellpadding="0"
					class="table-1">
					<thead class="table-1-tou">
						<td class="text_center" width="5%">全选 <input type="checkbox"></td>
						<td class="text_center" width="5%">申请人</td>
						<td class="text_center" width="6%">申请时间</td>
						<td class="text_center" width="6%">目标部门</td>
						<td class="text_center" width="6%">目标项目</td>
						<td class="text_center" width="6%">目标订单</td>
						<td class="text_center" width="6%">变动省份</td>
						<td class="text_center" width="6%">变动城市</td>
						<td class="text_center" width="6%">商务属性</td>
						<td class="text_center" width="6%">商务等级</td>
						<td class="text_center" width="6%">合同类型</td>
						<td class="text_center" width="6%">LTE认证</td>
						<td class="text_center" width="6%">室外工作</td>
						<td class="text_center" width="6%">生效日期</td>
						<td class="text_center" width="6%">备注</td>
						<td class="text_center" width="10%">操作</td>
					</thead>

					<tbody id="tbody"> 
						<c:forEach items="${orderChangeList}" var="orderChange" >
						          
							<tr>
								<td class="text_center" width="5%"><input type="checkbox"><input name="id" value="id" type="hidden"></td>
								<td class="text_center" width="5%" name="username">${orderChange.username}</td>
								<td class="text_center" width="6%" >${orderChange.modifyTime}</td>
								<td class="text_center" width="6%" >${orderChange.department}</td>
								<td class="text_center" width="6%">${orderChange.project}</td>
								<td class="text_center" width="15%">${orderChange.orderName}</td>
								<td class="text_center" width="6%">${orderChange.changeProvince}</td>
						        <td class="text_center" width="6%">${orderChange.changeCity}</td>
								<td class="text_center" width="6%" name="businessProperty"><select><option>TimeBase</option>
										<option>TaskBase</option></select></td>
								<td class="text_center" width="6%" name="yindaIdentify">${orderChange.yindaIdentify}</td>
								<td class="text_center" width="6%">${orderChange.contractType}</td>
								<%-- <c:if
									test=" ${orderChange.nowAcess eq staff_user_id || fn:contains(orderChange.historyAccess,staff_user_id)}"> --%>
									<td class="text_center" width="6%">
										<div class="weui_cell weui_vcode">

											<div class="weui_cell_bd weui_cell_primary">
												<div class="weui_cell weui_cell_select">
													<div class="weui_cell_bd weui_cell_primary" >
														<select class="weui_select" name="lte" id="lte" style="width:50px;"> 
															<option value=""
																<c:if test="${orderChange.lte eq ''}"> selected="selected"</c:if>>
															</option>
															<option value="NPO LTE Specialist1"
																<c:if test="${orderChange.lte eq 'NPO LTE Specialist1'}"> selected="selected"</c:if>>NPO
																LTE Specialist1</option>
															<option value="NPO LTE Senior"
																<c:if test="${orderChange.lte eq 'NPO LTE Senior'}"> selected="selected"</c:if>>NPO
																LTE Senior</option>
															<option value="NPO LTE Intermediate"
																<c:if test="${orderChange.lte eq 'NPO LTE Intermediate'}"> selected="selected"</c:if>>NPO
																LTE Intermediate</option>
															<option value="Radio LTE Senior"
																<c:if test="${orderChange.lte eq 'Radio LTE Senior'}"> selected="selected"</c:if>>Radio
																LTE Senior</option>
															<option value="Radio LTE Intermediate"
																<c:if test="${orderChange.lte eq 'Radio LTE Intermediate'}">selected="selected"</c:if>>Radio
																LTE Intermediate</option>
															<option value="LTE双初级"
																<c:if test="${orderChange.lte eq 'LTE双初级'}">selected="selected"</c:if>>LTE双初级</option>
															<option value="LTE单初级"
																<c:if test="${orderChange.lte eq 'LTE单初级'}">selected="selected"</c:if>>LTE单初级</option>

														</select>
													</div>
												</div>
											</div>
										</div>
									</td>
								<%-- </c:if> --%>

								<td class="text_center" width="6%"><select name="outdoorJob" >								
								        <option value="是">是</option>
										<option value="否">否</option></select>
								</td>
								<td class="text_center" width="6%">生效日期</td>
								<td class="text_center" width="6%"><input /></td>
								<td class="text_center" width="5%"><input
									onclick="PC_pass_approve($(this).parent().parent(),'${orderChange.id}');" type="button" value="通过"
									style="background: green;" class="gx-btn"> <input
									type="button" style="background: red;" value="拒绝"
									class="gx-btn" onclick="export_List();"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>


		</div>
	</div>
	<footer>
		<p>
			<img src="<%=path%>/images/tubiao.png" alt="">上海音达科技实业有限公司
		</p>
	</footer>

</body>

<script type="text/javascript">

function PC_pass_approve(item,id){
	var tr =$(item);//获取当前按钮的那行对象
	var html =tr.html();
	var yindaIdentify = tr.find($("select[name='yindaIdentify']")).val();
	var orderRemark =tr.find($("input[name='orderRemark']")).val();
	var businessProperty =tr.find($("select[name='yindaIdentify']")).val();
	var outdoorJob =tr.find($("select[name='outdoorJob']")).val();
	var lte =tr.find($("select[name='lte']")).val();
	//String id,String identify,String orderRemark,String businessProp,String outdoorJob3,String lte3
	 $.post("<%=path%>/orderChange/pass_approve.do",{"id":id,"identify":yindaIdentify,"orderRemark":orderRemark,
     	"businessProp":businessProperty,"outdoorJob3":outdoorJob,"lte3":lte},function(data){
         if("success"==data){
             alert("操作成功！");            
         }else{
             alert("操作失败！");
         }
     });
}

</script>
</html> 
