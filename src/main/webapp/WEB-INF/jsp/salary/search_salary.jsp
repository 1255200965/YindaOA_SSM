<%--
  Created by IntelliJ IDEA.
  User: ma
  Date: 2016/10/17
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta charset="utf-8" />
<title>日历</title>

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
  
 

   
    <link rel="stylesheet" href="<%=path%>/stylesheets/affairs-search.css"/>
    <link rel="stylesheet" href="<%=path%>/datePlug/jquery.monthpicker.css"/>

    <link href="<%=path%>/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    

    <script src="<%=path%>/datePlug/jquery.monthpicker.js"></script>
    <script type="text/javascript" src="<%=path%>/javascripts/bootstrap-treeview.min.js"></script>

    


	<script type="text/javascript" src="<%=path%>/datetimepicker/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="<%=path%>/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>

<body>

	

	<div class="row-fluid c_box" style="background:white;">
		<!-- <div class="col-md-2 c_left_box">
			<div style="margin-top: 3%"></div>
			<div id="tree" style="overflow: auto; height: 800px;"></div>

		</div> -->
		<div class="col-md-12">
			<div class="caidan-tiku" style="margin-bottom: 3%">
				<%--                <div style="float:left">
                    <input data-bind="click:$root.ClickAdd" type="button" value="新增"  class="chaxun">
                </div>--%>
				<div class="caidan-tiku-s" style="margin-right: 5%">
					<span>分公司：</span>
					<!--  <select  id="branchCompany" class="form-control "><option value="0">无</option></select> -->
					<select id="branchCompany" name="branchCompany" class="riqi-xiala " style="width: 70px;"><option>无</option></select>
				</div>
				<div class="caidan-tiku-s" style="margin-right: 5%">
				
				</div>

				<div class="caidan-tiku-s" style="margin-right: 5%">
					<span>年份</span> <input id="salarydate" type="text"  class="laydate-icon shuruk-a2 form_date" 
						name="salarydate" class="shuruk-a2" placeholder="">
						 
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
					<input  type="button"
						style="background: green;" value="导出" class="chaxun" onclick="export_List();">
				</div>
			</div>

			<div
				style="width: 100%; height: 700px; padding-top: 5px; overflow: auto; border: 0 solid #000000;">

				<table width="100%" border="1" cellspacing="0" cellpadding="0"
					class="table-1">
					<thead class="table-1-tou">
						<td class="text_center" width="13%">分公司</td>
						<td class="text_center" width="6%">月份</td>
						<td class="text_center" width="15%">姓名</td>
						<td class="text_center" width="14%">出差薪资</td>
						
						<td class="text_center" width="9%">总工资</td>
					</thead>

					<tbody id="tbody">

					</tbody>
				</table>
			</div>
       
			
		</div>
	</div>
	<footer>
    <p><img src="<%=path%>/images/tubiao.png" alt="">上海音达科技实业有限公司</p>
</footer> 

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
    		format:'yyyy-mm',
    		minView: "month",
    	});
    	
    	
    	
    	
    	 var branchCompanythtml =$("#branchCompany").html();  
    	$.post("<%=path%>/usersalary/getbranchCompany.do",function(json){
    	
    		$.each(json, function (n, value) {
              
    			branchCompanythtml = branchCompanythtml+"<option value='"+value.branchCompany+"'>"+value.branchCompany+"</option>";              
            });    		
    		 $("#branchCompany").html(branchCompanythtml);
    	});	 
    });

   
   /* 订单查询 */ 
function search_List(){
	var branchCompany=$("#branchCompany").val();
	var salarydate=$("#salarydate").val();
	var tbody =$("#tbody").html();
	
 	
	$.post("<%=path%>/usersalary/search_salary.do",{"salarydate":salarydate,"branchCompany":branchCompany},function(json){		
	   tbody="";
		$.each(json, function (n, value) {
           tbody = tbody+"<tr>"+
            "<td class='text_center' width='13%'>"+value.department+"</td>"+
            "<td class='text_center' width='13%'>"+value.salarydate+"</td>"+
			"<td class='text_center' width='13%'>"+value.name+"</td>"+
			"<td class='text_center' width='13%'>"+value.attendancesalary+"</td>"+
			"<td class='text_center' width='13%'>"+value.totalsalary+"</td>"+
        
			"</tr>";
        });
	     
	    $("#tbody").html(tbody)
		
	});
	
	
	

   }

function export_List(){
	var branchCompany=$("#branchCompany").val();
	var salarydate=$("#salarydate").val();
   
	window.location.href="<%=path%>/usersalary/export_salary.do?salarydate="+salarydate+"&branchCompany="+branchCompany;
 	


}
</script>
</html>
