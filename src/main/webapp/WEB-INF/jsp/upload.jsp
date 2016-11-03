<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/3
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>音达后台管理系统</title>
    <link rel="shortcut icon" type="image/ico" href="../images/yd.ico" />
    <link rel="stylesheet" href="../stylesheets/reset.css">
    <link rel="stylesheet" href="../stylesheets/header.css">
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
                <li ><a href="#">通讯录</a></li>
                <li class="active"><a href="upload.html">审批数据导入</a></li>
                <li><a href="affairs-search.html">工资查询</a></li>
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
        <a href="upload-qingjia.jsp"><img src="../images/icon01.png" alt=""><p>请假申请</p></a>
        <a href="upload-jiaban.jsp"><img src="../images/icon02.png" alt=""><p>加班申请</p></a>
        <a href="upload-jiaotong.jsp"><img src="../images/icon01.png" alt=""><p>公交地铁</p></a>
        <a href="upload-chuchai.jsp"><img src="../images/icon02.png" alt=""><p>出差申请</p></a>
        <a href="upload-project.jsp"><img src="../images/icon01.png" alt=""><p>项目信息变动</p></a>
        <a href="upload-renzheng.jsp"><img src="../images/icon02.png" alt=""><p>音达认证</p></a>
    </div>


</div>


<footer>
    <p><img src="../images/tubiao.png" alt="">上海音达科技实业有限公司</p>
</footer>
</body>
</html>
