<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
 String path=request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
 <!--  单条预付款财务审核界面-->
<head>
<meta charset="utf-8" />
  	<link href="<%=path%>/stylesheets/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path%>/stylesheets/fileinput.css" media="all" rel="stylesheet" type="text/css" />
	<script src="<%=path%>/javascripts/jquery-2.1.4.js"></script>
    <script src="<%=path%>/javascripts/bootstrap.min.js"></script>
    <script src="<%=path%>/javascripts/fileinput.min.js"></script>
    <script src="<%=path%>/javascripts/fileinput_locale_zh.js"></script>
</head>

<body style="background-color:white;">
<br/><br/><br/><br/><br/>
<form class="form-horizontal"  id="form1">
                    <fieldset>
                        <legend></legend>
                       <div class="form-group">
                          <label class="col-sm-2 control-label" for="ds_host"><b>姓名</b></label>
                          <div class="col-sm-4">
                             <input class="form-control" id="ds_host"  readonly value="${loan.askStaffName }"/>
                          </div>
                          <label class="col-sm-2 control-label" for="ds_name"><b>工号</b></label>
                          <div class="col-sm-4">
                             <input class="form-control" id="ds_name"  value="${loan.askStaffId }" readonly/>
                          </div>
                       </div>
                       <div class="form-group">
                          <label class="col-sm-2 control-label" for="ds_host"><b>部门</b></label>
                          <div class="col-sm-4">
                             <input class="form-control" id="ds_host"  readonly value="${loan.askStaffDep }"/>
                          </div>
                          <label class="col-sm-2 control-label" for="ds_name"><b>借款时间</b></label>
                          <div class="col-sm-4">
                             <input class="form-control" id="ds_name"  value="${loan.askStartTime }" readonly/>
                          </div>
                       </div>
                       <div class="form-group">
                          <label class="col-sm-2 control-label" for="ds_host"><b>借款用途大类</b></label>
                          <div class="col-sm-4">
                             <input class="form-control" id="ds_host"  readonly value="${loan.loanAimMc }"/>
                          </div>
                          <label class="col-sm-2 control-label" for="ds_name"><b>借款用途小类</b></label>
                          <div class="col-sm-4">
                             <input class="form-control" id="ds_name"  value="${loan.loanAimSc }" readonly/>
                          </div>
                       </div>
                       <div class="form-group">
                           <label class="col-sm-2 control-label" for="ds_username"><b>预付款金额</b></label>
                          <div class="col-sm-4">
                             <input class="form-control" id="advanceSum" value="${loan.loanSum }" readonly/>
                          </div>
                          <label class="col-sm-2 control-label" for="ds_name"><b>收款人</b></label>
                          <div class="col-sm-4">
                             <input class="form-control" id="ds_name"  value="${loan.loanPayee }" readonly/>
                          </div>
                       </div>
                       <div class="form-group">
                          <label class="col-sm-2 control-label" for="ds_username"><b>发票金额</b></label>
                          <div class="col-sm-4">
                             <input class="form-control" id="ds_username"  value="${loan.approveInvoice }" readonly/>
                          </div>
                          <label class="col-sm-2 control-label" for="ds_password"><b>返还金额</b></label>
                          <div class="col-sm-4">
                             <input class="form-control" id="ds_password"  value="${loan.approveRepayment }" readonly/>
                          </div>
                       </div>
                        <div class="form-group">
                          
                          <label class="col-sm-2 control-label" for="ds_password"><b>建议</b></label>
                          <div class="col-sm-4">
                             <input class="form-control" name="approveAdvice" id="approveAdvice" value="${loan.approveAdvice }" readonly>
                          </div>
                       </div>
                       <div class="form-group">
    <label class="col-sm-2 control-label" for="ds_host"><b>发票照片</b></label>
    <div class="col-sm-4">
         <img src="http://121.40.29.241/YindaOAImageUpload/LoanImage/${loan.imageUrl}" style="height:300px;width:200px;" onclick="changeSize(this);">
    </div>
    </div>
  </fieldset>  
</form>
 <div class="row" >
 	<div class="col-sm-2">
	
	</div>
	<div class="col-sm-10">
	<button type="button" class="btn btn-primary" onclick="agree('${loan.approveNo}');">同意</button>
	<button type="button" class="btn btn-default" onclick="disAgree('${loan.approveNo}');">驳回</button>
	</div >
</div>
<script type="text/javascript">
//审批状态
var operationStatus = "${loan.approveStatus}";
$("document").ready(function(){
	if(operationStatus != "待审核"){
		$(".btn").hide();
	}else{
		$("#approveAdvice").removeAttr("readonly");
	}
});
 	//审批同意操作
function agree(e){
		
 		$.post("approve.do",{"approveNo":e,"approveStatus":'同意',"approveAdvice":$("#approveAdvice").val()},function(data){
 			if(data="success"){
 				alert("操作成功");
 				window.location.href="toLoan_approveGetList.do";
 			}else{
 				alert("系统繁忙,请稍后重试");
 			}
 		});
 	};
 	//审批拒绝操作
function disAgree(e){
 		
	$.post("approve.do",{"approveNo":e,"approveStatus":"驳回","approveAdvice":$("#approveAdvice").val()},function(data){
			if(data="success"){
				alert("操作成功");
				window.location.href="toLoan_approveGetList.do";
			}else{
				alert("系统繁忙,请稍后重试");
			}
		});
}
 	//图片预览
function changeSize(e){
	var width=$(e).css("width");
	if(width == "200px"){
		$(e).css("width","300px");
		$(e).css("height","500px");
	}else{
		$(e).css("width","200px");
		$(e).css("height","300px");
	}
	
}
</script>
</body>
</html>
