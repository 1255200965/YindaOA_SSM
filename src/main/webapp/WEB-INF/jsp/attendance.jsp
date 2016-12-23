<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%
 String path=request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
    <title>请假明细</title>
    <!-- this "tags" contains all the patterns we need in this page -->
    <link rel="stylesheet" href="<%=path%>/stylesheets/reset.css"/>
    <link href="<%=path%>/stylesheets/bootstrap.min.css" rel="stylesheet" />
    <link href="<%=path%>/stylesheets/bootstrap-theme.min.css" rel="stylesheet" />
    <link href="<%=path%>/stylesheets/bootstrap-treeview.min.css" rel="stylesheet" />
    <link href="<%=path%>/stylesheets/shujutongji.css" rel="stylesheet" />
    <link href="<%=path%>/stylesheets/ddcss.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=path%>/stylesheets/bootstrap.min.css" />
    <link rel="shortcut icon" type="image/ico" href="<%=path%>/images/yd.ico" />
    <link rel="stylesheet" href="<%=path%>/stylesheets/reset.css"/>
    <link rel="stylesheet" href="<%=path%>/stylesheets/buttons.css"/>
    <link rel="stylesheet" href="<%=path%>/stylesheets/header.css"/>
    <link rel="stylesheet" href="<%=path%>/stylesheets/affairs-search.css"/>
    <link rel="stylesheet" href="<%=path%>/datePlug/jquery.monthpicker.css"/>
    <link href="<%=path%>/datetimepicker/sample/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="<%=path%>/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    
    <script src="<%=path%>/javascripts/jquery-1.10.2.js"></script> 
    <script src="<%=path%>/datePlug/jquery.monthpicker.js"></script>
    <script type="text/javascript" src="<%=path%>/javascripts/bootstrap-treeview.min.js"></script>
    <script src="<%=path%>/javascripts/knockout-3.4.0rc.js"></script>
    
    <script type="text/javascript" src="<%=path%>/datetimepicker/sample/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="<%=path%>/datetimepicker/sample/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=path%>/datetimepicker/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="<%=path%>/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>


    <style>
        *{box-sizing: content-box;-webkit-box-sizing: content-box;}
        .c_box{min-width:1350px;width:100%;}
        .c_box .col-md-2{min-width:189px;width:12.4%;}
        .c_box .c_left_box{height:850px;}
        .c_box .c_right_box {min-width:1056.7px;width:79%;}
        .table-1 tbody td{font-size:12px;}
    </style>
    
</head>

<body style="background-color:white;">
<header>
   <div class="head-cont">
        <div class="head-left fl">
            <img src="<%=path%>/images/logo.png" height="35" width="50" alt="">
            人事管理系统
        </div>
        <div class="head-nav fl" id="h-nav">
            <ul>
                <li><a href="<%=path%>/ExcelStaffInfo/homePage.do">人员导入</a></li>
                <li><a href="<%=path%>/userinfo/testMethod.do">通讯录</a></li>
                <li><a href="<%=path%>/Import/navigator.do">审批数据导入</a></li>
                <li><a href="<%=path%>/userinfo/test.do">工资查询</a></li>
                <li><a href="<%=path%>/userinfo/querys.do">个人工资明细</a></li>
                <li><a  href="<%=path%>/toAskForLeave.do">请假明细</a>
                <li><a class="active" href="<%=path%>/toAskForLeave.do">考勤明细</a>
            </ul>
        </div>
        <div class="head-right fr">
            欢迎您！管理员&nbsp;&nbsp;&nbsp;
            <a href=""><img src="<%=path%>/images/guanbi.png" height="22" width="22" alt=""></a>
        </div>
    </div>
</header>
<br/>
<form id="form" > 
  <div class="caidan-tiku" style="margin-bottom:3%">              
              <div class="caidan-tiku-s" style="margin-right:5%"> <span>部门：</span>
                    <input id="search_name" type="text" name="department" class="shuruk-a2" placeholder="" value="${yoAtteninfo.department }">
                </div>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>项目名称：</span>
                    <input id="search_workid" type="text" name="projectName" class="shuruk-a2" placeholder="" value="${yoAtteninfo.device }">
                </div>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>订单名称：</span>
                    <input id="search_workid" type="text" name="orderName" class="shuruk-a2" placeholder="" value="${yoAtteninfo.ifactivity }">
                </div>
                 <div class="caidan-tiku-s" style="margin-right:5%"> <span>时间：</span>
                    <input id="start" type="text" name="attendtime" class="laydate-icon shuruk-a2 form_date" placeholder="" value="${yoAtteninfo.attaddress }" >
                    <input id="search_name" type="text" name="atttime" class="shuruk-a2 form_date" placeholder="" value="${yoAtteninfo.attendresult }" >
                </div>
                 <div style="float:right;margin-right:0px;padding-bottom:0px;" >
                    <button  type="button"   class="btn btn_primary" onclick="subForm();">查询</button>
                    <button  type="button"   class="btn btn_info"  onclick="clearPropertities();">清空</button>
                    <button  type="button"   class="btn btn_danger" style="background:#fd9162" onclick="download();">下载</button>
                </div>         
    </div>
</form>
    <div style="width:100%; height:700px;padding-top: 5px;overflow:auto;border:0 solid #000000;">
            <table  width="100%" border="1" cellspacing="0" cellpadding="0" class="table-1">
               <thead class="table-1-tou">
                <td class="text_center" width="6%">姓名</td>
                <td class="text_center" width="9%">工号</td>
                <td class="text_center" width="6%">部门</td>
                <td class="text_center" width="6%">项目</td>
                <td class="text_center" width="6%">订单名称</td>
                <td class="text_center" width="6%">合同类型</td>
                <td class="text_center" width="6%">打卡时间</td>
                <td class="text_center" width="6%">打卡结果</td>
                <td class="text_center" width="6%">备注</td>
                <td class="text_center" width="6%">打卡设备号</td>
                </thead>
                <tbody >
               <c:forEach items="${YEList}" var="ye">
                <tr >
                 <td class="text_center" width="6%">${ye.name }</td>
                <td class="text_center" width="6%">${ye.staffId }</td>
                <td class="text_center" width="9%">${ye.department }</td>
                <td class="text_center" width="6%">${ye.projectName}</td>
                <td class="text_center" width="6%">${ye.orderName }</td>
                <td class="text_center" width="6%">${ye.contractType }</td>
                <td class="text_center" width="6%">${ye.attendTime}</td>
                <td class="text_center" width="6%">${ye.attendResult }</td>
                <td class="text_center" width="6%">${ye.remark}</td>
                <td class="text_center" width="6%">${ye.deviceid}</td>
                </tr>
               </c:forEach>
                </tbody>
            </table>
            <%-- <jsp:include page="./commons/page.jsp"></jsp:include> --%>
     </div>
<footer>
    <p><img src="<%=path%>/images/tubiao.png" alt="">上海音达科技实业有限公司</p>
</footer> 
<script type="text/javascript">
$('.form_date').datetimepicker({
    language:  'zh-CN',
    todayBtn:  1,
	autoclose: 1,
	format:'yyyy-mm-dd',
	minView: "month",
});
//查询
	function subForm(){
		if($("input[name='department']").val() == ""){
			alert("请选择查询条件--部门;\r注:部门、开始日期、结束为必填项,项目、订单名称可填,可不填");
			return false;
		}
		
		if($("input[name='attendtime']").val() == "" || $("input[name='attendtime']").val() ==null){
			alert("请输入查询条件--开始日期;\r注:部门、开始日期、结束为必填项,项目、订单名称可填,可不填");
			return false;
		}
		if($("input[name='atttime']").val()== "" || $("input[name='atttime']").val() == null){
			alert("请选择查询条件--截止日期;\r注:部门、开始日期、结束为必填项,项目、订单名称可填,可不填");
			return false;
		}
		$("#form").submit();
	}
	//下载
	function download(){
		if($("input[name='department']").val() == ""){
			alert("请选择查询条件--部门;\r注:部门、开始日期、结束为必填项,项目、订单名称可填,可不填");
			return false;
		}
		
		if($("input[name='attendtime']").val() == "" || $("input[name='attendtime']").val() ==null){
			alert("请输入查询条件--开始日期;\r注:部门、开始日期、结束为必填项,项目、订单名称可填,可不填");
			return false;
		}
		if($("input[name='atttime']").val()== "" || $("input[name='atttime']").val() == null){
			alert("请选择查询条件--截止日期;\r注:部门、开始日期、结束为必填项,项目、订单名称可填,可不填");
			return false;
		}
		window.location.href="attendance_export.do?department="+$("input[name='department']").val()+
		"&orderName="+$("input[name='orderName']").val()+"&attendtime="+$("input[name='attendtime']").val()
		+"&atttime="+$("input[name='atttime']").val();
	}
	//清空按钮
	function clearPropertities(){
		$("input[name='department']").val("");
		$("input[name='orderName']").val("");
		$("input[name='atttime']").val("");
		$("input[name='attendtime']").val("");
		$("input[name='projectName']").val("");
	}
</script>
</body>
</html>
