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


    <script type="text/javascript" src="../javascripts/jquery-1.10.2.js"></script>
    <script src="../javascripts//knockout-3.4.0rc.js"></script>

    <style>
        body{min-width:1350px;}
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
        .content .mod{margin:0 auto;width:750px;overflow:hidden;}
        
        footer{background:#e7e8eb;padding:50px 0;}
        footer img{width:14px;display:inline-block;vertical-align: middle;}
        footer p{text-align: center;color:#888;font-size:14px;}
    </style>
    <script>
        $(document).ready(function () {
            var type = "${tab}";
            if (type != "") checkInit(type);
            var ViewModel = function (){};
            ko.applyBindings(new ViewModel);
        });
    </script>
</head>
<body>
   <%--  <header>
        <div class="head-cont">
            <div class="head-left fl">
                <img src="../images/logo.png" height="35" width="50" alt="">
                人事管理系统
            </div>
            <div class="head-nav fl" id="h-nav">
                <ul>
                    <li><a data-bind="attr: { href: '<%=basePath%>ExcelStaffInfo/homePage.do'}">人员导入</a></li>
                    <li><a data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}">通讯录</a></li>
                    <li><a class="active" data-bind="attr: { href: '<%=basePath%>Import/navigator.do'}">审批数据导入</a></li>
                    <li><a data-bind="attr: { href: '<%=basePath%>userinfo/test.do'}">工资查询</a></li>
                    <li><a data-bind="attr: { href: '<%=basePath%>userinfo/querys.do'}">个人工资明细</a></li>
                    <li><a href="<%=basePath%>toAskForLeave.do">请假明细</a>
                    <li><a href="<%=basePath%>toOverTime.do">加班明细</a>
                    <li><a href="<%=basePath%>toItemChange.do">项目变更</a>
                    <li><a href="<%=basePath%>toSocialSecurity.do">社保明细查看</a>
                </ul>
            </div>
            <div class="head-right fr">
                欢迎您！管理员&nbsp;&nbsp;&nbsp;
                <a href=""><img src="../images/guanbi.png" height="22" width="22" alt=""></a>
            </div>
        </div>
    </header> --%>

<%-- <div class="content">
    <div class="mod">
        <a data-bind="attr: { href: '<%=basePath%>AskLeaveExcel/homePage.do'}"><img src="../images/icon01.png" alt=""><p>请假申请</p></a>
        <a data-bind="attr: { href: '<%=basePath%>OvertimeExcel/homePage.do'}"><img src="../images/icon02.png" alt=""><p>加班申请</p></a>
        <a data-bind="attr: { href: '<%=basePath%>ExcelItemChange/homePage.do'}"><img src="../images/icon01.png" alt=""><p>项目信息变动</p></a>
        <a data-bind="attr: { href: '<%=basePath%>ExcelAttendanceDetail/homePage.do'}"><img src="../images/icon02.png" alt=""><p>考勤明细导入</p></a>
        <a data-bind="attr: { href: '<%=basePath%>ExcelSignIn/homePage.do'}"><img src="../images/icon01.png" alt=""><p>签到导入</p></a>
        <a data-bind="attr: { href: '<%=basePath%>ExcelSocialSecurityInfo/homePage.do'}"><img src="../images/icon02.png" alt=""><p>社保信息导入</p></a>
    </div>

</div> --%>

<footer>
    <p><img src="../images/tubiao.png" alt="">上海音达科技实业有限公司</p>
</footer>
</body>
</html>
