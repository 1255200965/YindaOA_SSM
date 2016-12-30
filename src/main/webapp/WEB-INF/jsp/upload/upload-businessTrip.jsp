<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="controller" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html>

<head>
    <title>上传详情页</title>
    <!-- this "tags" contains all the patterns we need in this page -->
    <tags:holy_patterns/>
</head>

<body>

<div class="content">
    <div class="cont-tit">
        <img src="../images/icon02.png"  width="100" alt="">出差申请模块导入
    </div>
    <div class="cont-msg">
        <p>第一步：从钉钉后台下载出差申请数据表</p>
        <p>第二步：上传填写好的数据表</p>
    </div>
    <div class="select-file">
        <form action="businessTrip_upload.do" enctype="multipart/form-data" method="post" onsubmit="return check()">
            <div class="select-details">
                <a href="javascript:;" class="file">选择文件
                    <input type="file" value="选择文件"  name="file" onchange="showFile(this);" accept=".xls">
                </a>   
            </div>
            <p></p>
            <br>
            <div class="file-sub">
                <input type="submit" value="上传" class="button button-3d button-rounded button-primary">
            </div>
        </form>
    </div>
</div>

<footer>
    <p><img src="../images/tubiao.png" alt="">上海音达科技实业有限公司</p>
</footer>

<script>
 function check(){
	 if($("input[name='file']").value()==null || $("input[name='file']").value()==""){
		 alert("请选择上传文件");
		 return false;
	 }
 };
 function showFile(data){
	 $(data).parent().parent().next().replaceWith("<p style='color:blue;'>已选择文件:"+$("input[name='file']").val()+"</p>"); 
 }
</script>

</body>
</html>
