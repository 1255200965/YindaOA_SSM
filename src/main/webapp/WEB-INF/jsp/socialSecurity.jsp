<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
 String path=request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<!-- 项目变更 展示列表-->
<head>
<meta charset="utf-8" />
    <title>项目变更</title>
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
<%-- <header>
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
                <li><a href="<%=path%>/toAskForLeave.do">请假明细</a>
                <li><a href="<%=path%>/toOverTime.do">加班明细</a>
                <li><a href="<%=path%>/toItemChange.do">项目变更</a>
                <li><a class="active" href="<%=path%>/toSocialSecurity.do">社保明细查看</a>
            </ul>
        </div>
        <div class="head-right fr">
            欢迎您！管理员&nbsp;&nbsp;&nbsp;
            <a href=""><img src="<%=path%>/images/guanbi.png" height="22" width="22" alt=""></a>
        </div>
    </div>
</header> --%>
<br/>
<form id="form"> 
  <div class="caidan-tiku" style="margin-bottom:3%">              
              <div class="caidan-tiku-s" style="margin-right:5%"> <span>姓名：</span>
                    <input id="search_name" type="text" name="ssiName" class="shuruk-a2" placeholder="" value="${socialSecurity2.ssiName}">
                </div>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>工号：</span>
                    <input id="search_workid" type="text" name="ssiStaffId" class="shuruk-a2" placeholder="" value="${socialSecurity2.ssiStaffId }">
                </div>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>公司：</span>
                    <input id="search_name1" type="text" name="ssiBranchCompany" class="shuruk-a2" placeholder="" value="${socialSecurity2.ssiBranchCompany }">
                </div>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>生效开始日期：</span>
                    <input id="start" type="text" name="ssiBeginMonth" class="laydate-icon shuruk-a2 form_date" placeholder="" value="${socialSecurity2.ssiBeginMonth }">
                </div>
                 <div style="float:right;margin-right:15px;padding-bottom:10px;" >
                    <input  type="button" value="查询"  class="chaxun" onclick="subForm();">
                    <input   type="button" value="清空"  class="chaxun" style="background:#fd9162" onclick="clearPropertities();">
                </div>         
    </div>
</form>
 <div style="overflow-x:auto;">
    <div style="width:4000px; height:700px;padding-top:5px;overflow:auto;border:0 solid #000000;">
            <table  width="100%" border="1" cellspacing="0" cellpadding="0" class="table-1"  >
                <thead class="table-1-tou">
                <td class="text_center" width="3%">分公司</td>
                <td class="text_center" width="3%">员工号</td>
                <td class="text_center" width="3%">姓名</td>
                <td class="text_center" width="3%">交金地</td>
                <td class="text_center" width="3%">生效日期</td>
                <td class="text_center" width="3%">养老基数</td>
                <td class="text_center" width="3%">公司缴养老金</td>
                <td class="text_center" width="3%">个人缴养老金</td>
                 <td class="text_center" width="3%">医保基数</td>
                 <td class="text_center" width="3%">公司缴医保</td>
                 <td class="text_center" width="3%">个人缴医保</td>
                 <td class="text_center" width="3%">失业基数</td>
                 <td class="text_center" width="3%">公司缴失保</td>
                 <td class="text_center" width="3%">个人缴失保</td>
                  <td class="text_center" width="3%">生育基数</td>
                  <td class="text_center" width="3%">公司缴生保</td>
                  <td class="text_center" width="3%">个人缴生保</td>
                  <td class="text_center" width="3%">工伤基数</td>
                  <td class="text_center" width="3%">公司缴工伤</td>
                  <td class="text_center" width="3%">个人缴工伤</td>
                  <td class="text_center" width="3%">公积金基数</td>   
                  <td class="text_center" width="3%">公司缴公积金</td>
                  <td class="text_center" width="3%">个人缴公积金</td>
                  <td class="text_center" width="3%">外服基数</td>
                  <td class="text_center" width="3%">公司缴</td>
                  <td class="text_center" width="3%">个人缴</td>
                  <td class="text_center" width="3%">大病基数</td>
                  <td class="text_center" width="3%">公司缴</td>
                  <td class="text_center" width="3%">个人缴</td>
                </thead>
                <tbody >
               <c:forEach items="${socialSecurityList}" var="socialSecurity">
                <tr>
                <td class="text_center" width="3%">${socialSecurity.ssiBranchCompany }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiStaffId }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiName }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiSecurityAddress }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiBeginMonth}</td>
                <td class="text_center" width="3%">${socialSecurity.ssiEndowment }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiEndowmentCom }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiEndowmentPer }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiMedical }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiMedicalCom}</td>
                <td class="text_center" width="3%">${socialSecurity.ssiMedicalPer }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiUnemployment }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiUnemploymentCom }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiUnemploymentPer }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiMaternity}</td>
                <td class="text_center" width="3%">${socialSecurity.ssiMaternityCom }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiMaternityPer }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiInjury }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiInjuryCom }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiInjuryPer}</td>
                <td class="text_center" width="3%">${socialSecurity.ssiAccumulation }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiAccumulationCom }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiAccumulationPer }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiExternalService }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiExternalServiceCom}</td>
                <td class="text_center" width="3%">${socialSecurity.ssiExternalServicePer }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiFatalIll }</td>
                <td class="text_center" width="3%">${socialSecurity.ssiFatalIllCom}</td>
                <td class="text_center" width="3%">${socialSecurity.ssiFatalIllPer }</td>
                </tr>
               </c:forEach>
                </tbody>
            </table>
            <%-- <jsp:include page="./commons/page.jsp"></jsp:include> --%>
     </div>
     </div>
<div class="row-fluid">
    <div class="footer" data-reactid=".0.a">
        <div style="margin-bottom:5px;" data-reactid=".0.a.0">
            <span data-reactid=".0.a.0.0">
                <img width="11px" src="https://gw.alicdn.com/tps/TB14UngLXXXXXXQapXXXXXXXXXX-22-26.png" data-reactid=".0.a.0.0.0"></span>
            <span data-reactid=".0.a.0.1">上海音达科技实业有限公司</span></div>

    </div>
</div>
<script type="text/javascript">
$('.form_date').datetimepicker({
    language:  'zh-CN',
    todayBtn:  1,
	autoclose: 1,
	format:'yyyy-mm-dd',
	minView: "month",
});
	function subForm(){
		$("#form").submit();
	}
	function clearPropertities(){
		$("input[name='ssiName']").val("");
		$("input[name='ssiStaffId']").val("");
		$("input[name='ssiBranchCompany']").val("");
		$("input[name='ssiBeginMonth']").val("");
	}
</script>
</body>
</html>
