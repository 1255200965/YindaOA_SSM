<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/3
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>上传详情页</title>
    <link rel="shortcut icon" type="image/ico" href="../images/yd.ico" />
    <link rel="stylesheet" href="../stylesheets/reset.css">
    <link rel="stylesheet" href="../stylesheets/buttons.css">
    <link rel="stylesheet" href="../stylesheets/header.css">
    <link rel="stylesheet" href="../stylesheets/upload-details.css">
    <script src="../javascripts/jquery.min.js"></script>
    <script src="../javascripts//knockout-3.4.0rc.js"></script>
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
                <li><a  data-bind="attr: { href: '<%=basePath%>userinfo/import.do'}">人员导入</a></li>
                <li><a data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}">通讯录</a></li>
                <li><a class="active" data-bind="attr: { href: '<%=basePath%>Import/navigator.do'}">审批数据导入</a></li>
                <li><a data-bind="attr: { href: '<%=basePath%>userinfo/test.do'}">工资查询</a></li>
                <li><a data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}">关于我们</a></li>
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
        <img src="../images/icon02.png"  width="100" alt="">请假申请模块导入
    </div>
    <div class="cont-msg">
        <p>第一步：从钉钉后台下载请假申请数据表</p>
        <p>第二步：上传填写好的数据表</p>
    </div>
    <div class="select-file">
        <form action="../AskLeaveExcel/importExcel.do" enctype="multipart/form-data" method="post" onsubmit="return check_upload(this,1)">
            <div class="select-details">
                <a href="javascript:;" class="file">选择文件
                    <input type="file" value="选择文件" id="fileInput" name="fileUpload" onchange="showFile()">
                </a>
                <div>
                    <div id="fileState">${validate}</div>
                    <div>${validate}</div>
                    <div>${amountPrint}</div>
                </div>
            </div>

            <br>
            <div class="file-sub"><input type="submit" value="上传" class="button button-3d button-rounded button-primary"></div>

        </form>
    </div>
</div>

<footer>
    <p><img src="../images/tubiao.png" alt="">上海音达科技实业有限公司</p>
</footer>

<script>
    $(document).ready(function () {
        var type = "${tab}";
        if (type != "") checkInit(type);
        var ViewModel = function (){};
        ko.applyBindings(new ViewModel);
    });
$(document).ready(function(){
    if ($("#fileState").text() == "") {
        $("#fileState").html("未选择任何文件");
    }
});

function showFile(){
    var filepath = $("#fileInput").val();
    $("#fileState").html(filepath);
}
</script>

</body>
</html>
