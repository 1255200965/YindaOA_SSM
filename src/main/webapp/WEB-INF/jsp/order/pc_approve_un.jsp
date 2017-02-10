<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!--
    create by yexianglei;
    date:2017-2-8; 
     -->
<html>
<head>
<meta charset="utf-8" />
<title>项目变更审批后台</title>

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
		<form id = "subForm" action ="<%=path%>/PCOrderChange/pc_get_approve_un.do" >
			<div class="caidan-tiku" style="margin-bottom: 3%">
				               <div style="float:left">
                  
                </div>
				<div style="background-color:#00a1d6;width:20px;height:100px; position:fixed ;top:200px;left:0px;" border-radius:5px;><a style="color:white;" href="#">使用帮助</a></div>
				<div class="caidan-tiku-s" style="margin-right: 5%">
					<span>目标订单：</span>
					<input id="orderName" name="orderName" class="riqi-xiala "
						style="width: 170px;">
				</div>
				<div class="caidan-tiku-s" style="margin-right: 5%"></div>

				<!-- <div class="caidan-tiku-s" style="margin-right: 5%">
					<span>生效日期</span> <input id="salarydate" type="text"
						class="laydate-icon shuruk-a2 form_date" name="salarydate"
						class="shuruk-a2" placeholder=""> —— <input
						id="salarydate" type="text"
						class="laydate-icon shuruk-a2 form_date" name="salarydate"
						class="shuruk-a2" placeholder="">
				</div>	 -->
				<div style="float: right; margin-right: 15px; padding-bottom: 10px;">
					<input onclick="search_List();" type="button" value="查询"
						class="chaxun">
					<input type="button" style="background: green;" value="多条通过"
						class="chaxun" onclick="approve_order();">
						<input type="button" style="background: red;" value="多条拒绝"
						class="chaxun" onclick="refuse_order();">
				</div>	
				</form>
			</div>

			<div
				style="width: 100%; height: 700px; padding-top: 5px; overflow: auto; border: 0 solid #000000;">

				<table width="100%" border="1" cellspacing="0" cellpadding="0"
					class="table-1">
					<thead class="table-1-tou">
						<td class="text_center" width="5%">选择<br /><input type="checkbox" style ="width:20px;height:20px;" name="all" onclick ="is_select();"></td>
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
						<!-- <td class="text_center" width="10%">操作</td> -->
					</thead>

					<tbody id="tbody"> 
						<c:forEach items="${orderChangeList}" var="orderChange" >
						          
							<tr>
								<td class="text_center" width="5%"><input type="checkbox" name="ids" style ="width:20px;height:20px;"><input name="id"   value="${orderChange.id}" type="hidden"></td>
								<td class="text_center" width="5%" name="username">${orderChange.username}</td>
								<td class="text_center" width="6%" >${orderChange.modifyTime}</td>
								<td class="text_center" width="6%" >${orderChange.department}</td>
								<td class="text_center" width="6%">${orderChange.project}</td>
								<td class="text_center" width="15%">${orderChange.orderName} <input type = "hidden" name = "orderName" value="${orderChange.orderName}"></td>
								<td class="text_center" width="6%">${orderChange.changeProvince}</td>
						        <td class="text_center" width="6%">${orderChange.changeCity}</td>
								<td class="text_center" width="6%" >
								<input  type ="hidden"name= "businessProperty2" value="${orderChange.businessProperty}">
								      <select name="businessProperty" onchange="yindaIdentifyRefresh(this)"><option></option></select></td>
								<td class="text_center" width="6%" >
								<input  type ="hidden" name= "identify2" value="${orderChange.yindaIdentify}">
								 <select name="identify">
								        <option></option>
										
										</select>
								<%-- <input type="hidden" name="identify" value="${orderChange.yindaIdentify}"/> --%></td>
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
								<td class="text_center" width="6%">${orderChange.effectTime}</td>
								<td class="text_center" width="6%"><input name="orderRemark"/></td>
								<%-- <td class="text_center" width="5%"><input
									onclick="PC_pass_approve($(this).parent().parent(),'${orderChange.id}');" type="button" value="通过"
									style="background: green;" class="gx-btn"> <input
									type="button" style="background: red;" value="拒绝"
									class="gx-btn" onclick="export_List();"></td> --%>
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
/**
 * 页面加载完毕之后， 获取每一行元素，开始加载每行的商务属性和商务等级
 */
$(document).ready(function(){
  
	var ids =$(document).find("input[name='ids']");
	
	 /*遍历表格中所有行*/
	for(var i =0 ;i<ids.length;i++){		
		/* 
		*加载商务属性
		*/
		getBusinessProperty(ids[i]);
		/* 
		*加载商务等级
		*/
		getIdentify(ids[i]);
	}
   

});

/**
 * 多条审批审批批准提交方法
 */
function approve_order(){
	/*校验*/
	if(	$("input[name='ids']:checked").length==0){
		alert("你没有选择项目变更申请！");
		return;
	}
	debugger;
	/*找到所有的被选中的按钮*/
	var ids = $("input[name='ids']:checked");
	
	/*申明要提交的数组*/
	//{"id":id,"identify":yindaIdentify,"orderRemark":orderRemark,"businessProperty":businessProperty,"outdoorJob3":outdoorJob,"lte3":lte}
	var id = [];
	var identifys = [];
	var orderRemarks = [];
	var businessProps =[];
	var outdoorJob3s = [];
	var lte3s = [];
	for(var i =0 ;i<ids.length;i++){
		/*找到该按钮所在的那一行元素*/
		var tr  = $(ids[i]).parent().parent();
		
		/*获取这行id的值*/
		var idss = tr.find("input[name='id']");		
		/*将id的值添加数组中*/
		id.push($(idss).val());
		
		/*获取这行identify的值*/
		var identify = tr.find("select[name='identify']");		
		/*将identify的值添加数组中*/
		if(identify.val()==null){
			identifys.push("");
		}else{
			identifys.push($(identify).val());
		}
		
		
		
		/*获取这行orderRemark的值*/
		var orderRemark = tr.find("input[name='orderRemark']");		
		/*将orderRemark的值添加数组中*/
		orderRemarks.push($(orderRemark).val());
		
		/*获取这行businessProperty的值*/
		var businessProp = tr.find("select[name='businessProperty']");		
		/*将orderRemark的值添加数组中*/
		if(businessProp.val()==null){
			businessProps.push("");
		}else{
			businessProps.push($(businessProp).val());
		}
		
		
		/*获取这行outdoorJob的值*/
		var outdoorJob3 = tr.find("select[name='outdoorJob']");		
		/*将outdoorJob3的值添加数组中*/
		outdoorJob3s.push($(outdoorJob3).val());
		
		/*获取这行lte的值*/
		var lte = tr.find("select[name='lte']");		
		/*将lte的值添加数组中*/
		lte3s.push($(lte).val());
		
	}
	
     /*提交*/
     if(confirm("审批后不可更改，确定要同意么？")){
     //{"ids":id,"identifys":identifys,"orderRemarks":orderRemark,"businessProps":businessProps,"outdoorJob3s":outdoorJob3s,"lte3s":lte3s}
	 $.post("<%=path%>/PCOrderChange/pc_pass_approve.do",{"ids":id,"identifys":identifys,"orderRemarks":orderRemarks,"businessProps":businessProps,"outdoorJob3s":outdoorJob3s,"lte3s":lte3s},function(data){
	         alert(data);
	         location.reload();
	     });
     }
}

/**
 * 多条审批审批拒绝提交方法
 */
 function refuse_order(){
	
	
		/*校验*/
		if(	$("input[name='ids']:checked").length==0){
			alert("你没有选择项目变更申请！");
			return;
		}
		
		/*找到所有的被选中的按钮*/
		var ids = $("input[name='ids']:checked");
		
		/*申明要提交的数组*/		
		var id = [];
		
		for(var i =0 ;i<ids.length;i++){
			/*找到该按钮所在的那一行元素*/
			var tr  = $(ids[i]).parent().parent();
			
			/*获取这行id的值*/
			var idss = tr.find("input[name='id']");	
			
			/*将id的值添加数组中*/
			id.push($(idss).val());
		}
		 /*提交*/
	     if(confirm("拒绝后不可更改，确定要拒绝么？")){
	    	 
	     
	     //{"ids":id,"identifys":identifys,"orderRemarks":orderRemark,"businessProps":businessProps,"outdoorJob3s":outdoorJob3s,"lte3s":lte3s}
		 $.post("<%=path%>/PCOrderChange/pc_refuse_approve.do",{"ids":id},function(data){
		         alert(data);
		         location.reload();
		     });
	     }
}
 
 
function search_List(){
  $("#subForm").submit();
	
}
/**
 * 获取商务属性
 */
function getBusinessProperty(item){
	
    /*获取当前点击的行元素*/
	var tr = $(item).parent().parent();
	   
	/*获取当前行中的订单名称*/
	var orderName = tr.find("input[name='orderName']").val();
	
	/*获取当前行中的订单的商务属性*/
	var businessProperty =tr.find("select[name='businessProperty']");
    
	
	/*获取当前行中订单的商务属性的值*/
	var businessProperty2 =tr.find("input[name='businessProperty2']").val();
	
	if(businessProperty.html()=="<option></option>"){
		 $.post("<%=path%>/orderProperty/getBusinessProperty.do",{'orderName':orderName},function (data){
		        var businessPropertyHTML="";
		        $.each(data, function (n, value) {
		            if (businessProperty2 == value){
		                businessPropertyHTML = businessPropertyHTML + "<option value='" + value + "' selected>" + value + "</option>";
		            } else {
		                businessPropertyHTML = businessPropertyHTML + "<option value='" + value + "'>" + value + "</option>";
		            }
		        });
		        businessProperty.html(businessPropertyHTML); 	

		
	 		});
	}
 		

}


/**
 * 获取商务等级
 */
function getIdentify(item){
	
    /*获取当前点击的行元素*/
	var tr = $(item).parent().parent();
	   
	/*获取当前行中的订单名称*/
	var orderName = tr.find("input[name='orderName']").val();
	
	/*获取当前行中的订单的商务等级*/
	var identify =tr.find("select[name='identify']");
    	
	/*获取当前行中订单的商务属性等级值*/
    var identify2 =tr.find("input[name='identify2']").val();
	
	
	/*获取当前行中订单的商务属性的值*/
	var businessProperty2 =tr.find("input[name='businessProperty2']").val();
	
	var remarkHTML ="";
	
	 if(businessProperty2=="TaskBase" && (identify2==null||identify2 == "" )){
		 identify.html("");
		 return;		 
	 }
	 
	  $.post("<%=path%>/order/getRemarkByOrder.do",{'orderName':orderName},function (data){
          $.each(data, function (n, value) {
        	 
              if (identify2 == value){
            	  
                  remarkHTML = remarkHTML + "<option value='" + value + "' selected>" + value + "</option>";
              } else {
                  remarkHTML = remarkHTML + "<option value='" + value + "'>" + value + "</option>";
              }
          });
          identify.html(remarkHTML);
	  });
	  
         
}


/**
 *商务属性发生变动时，商务等级改变，订单名含有无线工程，选中TaskBase时 商务等级清空
 */
function yindaIdentifyRefresh(item){
	
	 /*获取当前点击的行元素*/
	var tr = $(item).parent().parent();
	   
	/*获取当前行中的订单名称*/
	var orderName = tr.find("input[name='orderName']").val();
	
	/*获取当前行中的订单的商务属性*/
	var businessProperty =tr.find("select[name='businessProperty']");
	
	/*获取当前行中的订单的商务等级*/
	var identify =tr.find("select[name='identify']");
	
    /*获取当前行中订单的商务属性等级值*/
	var identify2 =tr.find("input[name='identify2']").val();
    
	var remarkHTML ="";
	  $.post("<%=path%>/order/getRemarkByOrder.do",{'orderName':orderName},function (data){
        $.each(data, function (n, value) {
      	 
            if (identify2 == value){
          	  
                remarkHTML = remarkHTML + "<option value='" + value + "' selected>" + value + "</option>";
            } else {
                remarkHTML = remarkHTML + "<option value='" + value + "'>" + value + "</option>";
            }
            
          
        });
        
        if (businessProperty.val() == "TaskBase" && orderName.indexOf("无线工程")>0 ) {
        	identify.html("<option></option>");
        } else {
        	identify.html("<option></option>"+remarkHTML);
        }
	  });
	
 
}

var s = 0;
function is_select(){
	
	/*找到全选按钮*/
	var check_all = $("input[name='all']:checked");
	if(s==0){
		s=1;
		
	}else{
	   s=0;
	}
	
	
	if(s==1){
		
		var ids =  $("input[name='ids']");

		for(var i=0;i<ids.length;i++){
			
			ids[i].checked = true;
		}
	}
	if(s==0){
		
		var ids =  $("input[name='ids']");

		for(var i=0;i<ids.length;i++){
			
			ids[i].checked = false;
		}
	}

}

</script>
</html> 
