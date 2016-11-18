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
    <link rel="stylesheet" type="text/css" href="../stylesheets/hello_blue.css" />
</head>

<body>

<header>
    <div class="head-cont">
        <div class="head-left fl">
            <img src="../images/logo.png" height="35" width="50" alt="">
            人事管理系统
        </div>
        <div class="head-nav fl" id="h-nav">
            <ul>
                <li><a class="active" href="${controller}/ExcelStaffInfo/homePage.do">人员导入</a></li>
                <li><a href="${controller}/userinfo/testMethod.do">通讯录</a></li>
                <li><a href="${controller}/Import/navigator.do">审批数据导入</a></li>
                <li><a href="${controller}/userinfo/test.do">工资查询</a></li>
                <li><a href="${controller}/userinfo/querys.do">个人工资明细</a></li>

            </ul>
        </div>
        <div class="head-right fr">
            欢迎您！管理员&nbsp;&nbsp;&nbsp;
            <a href=""><img src="../images/guanbi.png" height="22" width="22" alt=""></a>
        </div>
    </div>
</header>

<div class="content">
    <div class="cont-tit">
        <img src="../images/icon02.png"  width="100" alt="">花名册模块导入
    </div>

    <div class="float50">
        <div class="p-box">
            <p>第一步：下载花名册模板</p>
            <p>第二步：上传填写好的数据表</p>
        </div>
    </div>

    <div class="float50">
        <!-- <form action="${controller}/ExcelStaffInfo/exportExcel.do"> -->
            <div class="p-box">
                <p>第三步：把数据库的信息导出到Excel</p>
                <p><button>导出到Excel（此功能暂时不能使用）</button></p>
            </div>
        <!-- </form> -->
    </div>

    <div class="select-file">
        <form action="${controller}/ExcelStaffInfo/importExcel.do" enctype="multipart/form-data" method="post" onsubmit="return check()">
            <div class="select-details">
                <a href="javascript:;" class="file">选择文件
                    <input type="file" value="选择文件" id="fileInput" name="fileUpload" onchange="showFile()">
                </a>
                <div style="color:#888888;">
                    <div id="validateUpload">${validateUpload}</div>
                    <div class="gandiao">${validateTitle}</div>
                    <div class="gandiao">${successAmount}</div>
                    <div class="gandiao">${failAmount}</div>
                </div>
            </div>

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
