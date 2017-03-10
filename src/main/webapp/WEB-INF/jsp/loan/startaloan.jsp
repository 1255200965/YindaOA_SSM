<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
 String path=request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
 <!--  发起界面-->
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
                             <input class="form-control" id="ds_host"  readonly value="${advance.askStaffName }"/>
                          </div>
                          <label class="col-sm-2 control-label" for="ds_name"><b>工号</b></label>
                          <div class="col-sm-4">
                             <input class="form-control" id="ds_name"  value="${advance.askStaffId }" readonly/>
                          </div>
                       </div>
                       <div class="form-group">
                          <label class="col-sm-2 control-label" for="ds_username"><b>预付款金额</b></label>
                          <div class="col-sm-4">
                             <input class="form-control" id="advanceSum" value="${advance.advanceSum }" readonly/>
                          </div>
                          <label class="col-sm-2 control-label" for="ds_password"><b>返还金额</b></label>
                          <div class="col-sm-4">
                             <input class="form-control" id="approveRepayment"  value="" name="approveRepayment"/>
                          </div>
                       </div>
                        <div class="form-group">
                          <label class="col-sm-2 control-label" for="ds_username"><b>发票金额</b></label>
                          <div class="col-sm-4">
                             <input class="form-control" id="approveInvoice"  value="" name="approveInvoice"/>
                          </div>
                          <!-- <label class="col-sm-2 control-label" for="ds_password"><b>发起时间</b></label>
                          <div class="col-sm-4">
                              <input  class="form-control form_date" placeholder="" >
                          </div> -->
                       </div>
                       <div class="form-group">
    <label class="col-sm-2 control-label" for="ds_host"><b>发票照片</b></label>
    <div class="col-sm-4">
         <input id="file"  type="file"  name ="mFiles"  class="file-loading"><!-- multiple表示可以提交多张 -->
         <p class="help-block">支持jpg、jpeg、png、gif格式,大小不超过2.0M</p>
    </div>
    </div>
  </fieldset>  
</form>
 <div class="row" >
 	<div class="col-sm-2">
	
	</div>
	<div class="col-sm-10">
	<button type="button" class="btn btn-primary" onclick="startALoan();">提交</button>
	<button type="button" class="btn btn-default" onclick="javascript:history.go(-1);">返回</button>
	</div >
</div>

<%-- <footer height="100px";>
    <p><img src="<%=path%>/images/tubiao.png" alt="">上海音达科技实业有限公司</p>
</footer>  --%>
<script type="text/javascript">
 	//fileInput初始化方法
function initFileInput(ctrlName,uploadUrl){
 		
	var control=$('#'+ctrlName);
		control.fileinput({
		language:'zh',//语言
		uploadUrl:uploadUrl,//上传地址 
		allowedFileExtensions:['jpg','gif','png','jpeg'],//接收的文件后缀
		maxFileSize:2000,//文件大小限制2M
		showUpload:false,
		showRemove:true,//是否显示删除按钮
		showCaption:false,//是否显示标题
		maxFileCount:10,//表示允许同时上传的最大文件个数
	});
}
 	//页面加载完后就初始化fileinput--设置上传事件对应的.do
$(function(){
	initFileInput("file","upLoadImage.do");
	});
 	
 		//确认按钮触发事件
	 function startALoan(){
			//返还金额
			 var approveRepayment=isNullForNumber($("#approveRepayment").val());
				//发票额
			 var approveInvoice =isNullForNumber($("#approveInvoice").val());
				//预付款金额
			 var sum = isNullForNumber($("#advanceSum").val());
			 if(parseInt(sum,10) ==(parseInt(approveRepayment,10)+parseInt(approveInvoice,10))){
 					//图片上传--并绑定上传完成后的回调事件
 		 		$("#file").fileinput("upload").on("fileuploaded",
 		 			function(event, data1, previewId, index){
 					var data = data1.response.path;
 			 		 if(isNull(data)){ 
 				 		$.post("startALoan.do",{approveNo:'${advance.approveNo}',approveRepayment:approveRepayment,
 					 	approveInvoice:approveInvoice,imageUrl:data},function(data2){
 						if(data2=="success"){
 										//上传图片
 									alert("成功发起一笔冲借款");
 									location="toLoan_operation.do";	
 						}else{
 							alert("发起冲借款失败");
 						}
 						});
 			 	}else{
 				 	alert("图片上传失败,请重新上传");
 				 } 
 		 	 });
			 }else{
				 alert("预付款金额不等于发票金额与返还金额之和,请重新核对");
			 }
		 
	};
	//判空
	function isNull(data){
		return (data == "" || data == undefined || data == null) ? false : true; 
	};
	//判空
	function isNullForNumber(data){
		return (data == "" || data == undefined || data == null) ? 0 : data; 
	};
</script>
</body>
</html>
