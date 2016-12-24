<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
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
        <img src="../images/icon02.png"  width="100" alt="">花名册模块导入导出
    </div>

    <div style="float: left; width: 50%">
        <p style="margin: 50px 0px 0px 50px">第一步：下载花名册模板</p>
        <a href="${ctx}/ExcelStaffInfo/downloadTemplate.do" class="file" style="margin: 20px 0px 0px 50px">下载文件
            <input type="button" onchange="showFile()">
        </a>
        <p style="margin: 20px 0px 30px 50px">第二步：上传填写好的数据表</p>
    </div>

    <div style="float: right; width: 50%">
        <p style="margin: 50px 0px 0px 50px">导出部分：把花名册的数据库信息导出成Excel</p>
        <a href="${ctx}/ExcelStaffInfo/export.do" class="file" style="margin: 30px 0px 90px 50px">开始导出
            <input type="button" onchange="showFile()">
        </a>
    </div>

    <div class="select-file">
        <form action="${ctx}/ExcelStaffInfo/import.do" enctype="multipart/form-data" method="post" onsubmit="return check()">
            <div class="select-details">
                <a href="javascript:;" class="file">选择文件
                    <input type="file" id="fileInput" name="fileUpload" onchange="showFile()">
                </a>
                <div id="result" style="color:#888888;">
                    <div id="validateUpload">${validateUpload}</div>
                    <div class="gandiao">${validateTitle}</div>
                </div>
            </div>

            <br>
            <div class="file-sub">
                <input type="submit" value="上传" class="button button-3d button-rounded button-primary">
            </div>
        </form>
    </div>

</div>

<footer sthle="height:100px;">
    <p><img src="../images/tubiao.png" alt="">上海音达科技实业有限公司</p>
</footer>

<script>

$(document).ready(function(){
    if ($("#validateUpload").text() == "") {
        $("#validateUpload").html("未选择任何文件");
    }
});

function showFile(){
    var filepath = $("#fileInput").val();
    $("#validateUpload").html(filepath);
    $(".gandiao").html("");
}

function check() {
    if ($("#fileInput").val() == "") {
        return false;
    }
}
</script>

</body>
</html>
