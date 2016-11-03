<%--
  Created by IntelliJ IDEA.
  User: ma
  Date: 2016/10/17
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>音达后台管理系统</title>
    <link rel="shortcut icon" type="image/ico" href="../images/yd.ico" />
    <link rel="stylesheet" href="../stylesheets/reset.css">
    <link rel="stylesheet" href="../stylesheets/header.css">
    <link href="../stylesheets/shujutongji.css" rel="stylesheet" />
    <script type="text/javascript" src="../javascripts/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="../javascripts/bootstrap.min.js"></script>
    <script type="text/javascript" src="../javascripts/bootstrap-treeview.min.js"></script>
    <script src="../javascripts//knockout-3.4.0rc.js"></script>
    <script>
        $(document).ready(function () {
            var type = "${tab}";
            if (type != "") checkInit(type);
            var ViewModel = function (){};
            ko.applyBindings(new ViewModel);
        });
    </script>
    <style>
        .content img{width:120px;}
        .content{width:930px;margin:0 auto;padding-bottom:30px;background:#fff;margin-top:30px;overflow: hidden;}
        .content a{display:block;width:190px;height:150px;float:left;width:190px;height: 150px;background: purple;margin:30px;text-align: center;border-radius:20px;color:#fff;}
        .content a:hover{opacity: 0.7;cursor:pointer;}
        .content a:nth-child(1){background:#3792F2;}
        .content a:nth-child(2){background:#B019E0;}
        .content a:nth-child(3){background:#F19349;}
        .content a:nth-child(4){background:#7575B8;}
        .content a:nth-child(5){background:#F5684A;}
        .content a:nth-child(6){background:#7CD33A;}
        .content .mod{margin:0 auto;width:750px;}
        /*        .content ul{overflow: hidden;margin-left:80px;margin-bottom:30px;}
                .content ul li{float:left;width:190px;height: 150px;background: purple;margin:30px;text-align: center;border-radius:20px;color:#fff;line-height: 150px;}
                .content ul li:hover{cursor: pointer;}
                .content ul li a{color:#fff;}*/

        footer{background:#e7e8eb;padding:50px 0;}
        footer p{text-align: center;color:#888;font-size:12px;}
    </style>
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
                    <li><a data-bind="attr: { href: '<%=basePath%>userinfo/import.do'}">人员导入</a></li>
                    <li><a data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}">通讯录</a></li>
                    <li><a class="active" data-bind="attr: { href: '<%=basePath%>Import/navigator.do'}">审批数据导入</a></li>
                    <li><a data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}">工资查询</a></li>
                    <li><a data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}">关于我们</a></li>
                </ul>
            </div>
            <div class="head-right fl">
                欢迎您！管理员&nbsp;&nbsp;&nbsp;
                <a href=""><img src="../images/guanbi.png" height="22" width="22" alt=""></a>
            </div>
        </div>
    </header>

<div class="content">
    <!--         <ul>
                <li><a href="">请假</a></li>
                <li><a href="">加班</a></li>
                <li><a href="">调休</a></li>
                <li><a href="">出差</a></li>
                <li><a href="">项目申请</a></li>
                <li><a href="">报告</a></li>
            </ul> -->
    <div class="mod">
        <a data-bind="attr: { href: '<%=basePath%>Import/AskLeaveHome.do'}"><img src="../images/icon01.png" alt=""><p>请假申请</p></a>
        <a data-bind="attr: { href: '<%=basePath%>Import/importOvertimeHome.do'}"><img src="../images/icon02.png" alt=""><p>加班申请</p></a>
        <a data-bind="attr: { href: '<%=basePath%>Import/importSubwayHome.do'}"><img src="../images/icon01.png" alt=""><p>公交地铁</p></a>
        <a data-bind="attr: { href: '<%=basePath%>Import/importBusinessTripHome.do'}"><img src="../images/icon02.png" alt=""><p>出差申请</p></a>
        <a data-bind="attr: { href: '<%=basePath%>Import/importItemChangeHome.do'}"><img src="../images/icon01.png" alt=""><p>项目信息变动</p></a>
        <a data-bind="attr: { href: '<%=basePath%>Import/importYindaIdentifyHome.do'}"><img src="../images/icon02.png" alt=""><p>音达认证</p></a>
    </div>


</div>


<footer>
    <p><img src="../images/tubiao.png" alt="">上海音达科技实业有限公司</p>
</footer>
</body>
</html>
