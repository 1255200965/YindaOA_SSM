<%--
  Created by IntelliJ IDEA.
  User: ma
  Date: 2016/10/17
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
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



<body>

	

	<div class="row-fluid c_box" style="">
		<div class="col-md-2 c_left_box">
			<div style="margin-top: 3%"></div>
			<div id="tree" style="overflow: auto; height: 800px;"></div>

		</div>
		<div class="col-md-10 c_right_box">
			<div class="caidan-tiku" style="margin-bottom: 3%">
				<%--                <div style="float:left">
                    <input data-bind="click:$root.ClickAdd" type="button" value="新增"  class="chaxun">
                </div>--%>
				<div class="caidan-tiku-s" style="margin-right: 5%">
					<span>部门：</span>
					<!--  <select  id="department" class="form-control "><option value="0">无</option></select> -->
					<select id="department" name="department" class="riqi-xiala " style="width: 70px;"><option>无</option></select>
				</div>
				<div class="caidan-tiku-s" style="margin-right: 5%">
				
				</div>

				<div class="caidan-tiku-s" style="margin-right: 5%">
					<span>年份</span> <input id="order_number" type="text"
						name="" class="shuruk-a2" placeholder="">
				</div>
				<%--                <div class="caidan-tiku-s"> <span>是否审核：</span>
                    <select id="sh1" class="riqi-xiala" style="width:70px;" data-bind="options: [0,1], optionsText: function (item) {  if (item == 0) return '否'; else return '是';},optionsCaption:''"></select>
                </div>
                <div class="caidan-tiku-s"> <span>难度：</span>
                    <select id="nd1" class="riqi-xiala" style="width:70px;" data-bind="options: [1,2,3,4,5,6,7,8,9], optionsText: function (item) {  return item;},optionsCaption:''"></select>
                </div>--%>
				<div style="float: right; margin-right: 15px; padding-bottom: 10px;">
					<input onclick="search_List();" type="button" value="查询"
						class="chaxun">
					<!-- <input data-bind="click:$root.ClickClear"
						type="button" value="清空" class="chaxun"
						style="background: #fd9162"> -->
					<input onclick="open_addModel();" type="button"
						style="background: green;" value="导出" class="chaxun">
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
            <jsp:include page="page.jsp"></jsp:include>
			
		</div>
	</div>
	

</body>

<script type="text/javascript">

function movePage(pageNo){
	if("${page.totalCount}"==0){
		return;
	}	
	if(pageNo==0){
		return ;
	}
	var url = "<%=path%>/mvc/search_salary.do?name=${qualityModelEntity.name}&creater=${qualityModelEntity.creater}&state=${qualityModelEntity.state}";
	var pageSize =50;
	
	url+="&pageNo="+pageNo;
	if(pageSize){
		url += "&pageSize="+pageSize ;
	}
	window.location=url;
};
/**
 * 初始化部门
 */
    $(function (){
    	
    	 var departmenthtml =$("#department").html();  
    	$.post("<%=path%>/order/getDepartment.do",function(json){
    	
    		$.each(json, function (n, value) {
              
               departmenthtml = departmenthtml+"<option value='"+value.department+"'>"+value.department+"</option>";              
            });    		
    		 $("#department").html(departmenthtml);
    	});	 
    });

   
   /* 订单查询 */ 
function search_List(){
	var department=$("#department").val();
	var orderNumber=$("#order_number").val();
	var tbody =$("#tbody").html();
	 if(department==null||department==""){
		alert("请选择部门！");
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
