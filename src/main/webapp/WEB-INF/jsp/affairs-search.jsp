<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/1
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>工资查询</title>
    <%--<link rel="stylesheet" href="../stylesheets/style.css">--%>


    <link rel="shortcut icon" type="image/ico" href="../images/yd.ico" />
    <link rel="stylesheet" href="../stylesheets/reset.css">
    <link rel="stylesheet" href="../stylesheets/buttons.css">
    <link rel="stylesheet" href="../stylesheets/header.css">
    <link rel="stylesheet" href="../stylesheets/bootstarp.min.css">
    <link rel="stylesheet" href="../stylesheets/affairs-search.css">
    <link rel="stylesheet" href="../stylesheets/ddcss.css">
    <link rel="stylesheet" href="../stylesheets/shujutongji.css">
    <%--<link rel="stylesheet" href="../stylesheets/bootstrap-theme.min.css">--%>
    <%--<link rel="stylesheet" href="../stylesheets/bootstrap.min.css">--%>
    <link rel="stylesheet" href="../datePlug/jquery.monthpicker.css">


    <script src="../javascripts/jquery-1.10.2.js"></script>
    <script src="../javascripts/bootstrap.min.js"></script>
    <script type="text/javascript" src="../datePlug/jquery.monthpicker.js"></script>
    <script src="../javascripts//knockout-3.4.0rc.js"></script>
    <script>
        $(document).ready(function () {

            var ViewModel = function (){};
            ko.applyBindings(new ViewModel);
        });
    </script>
</head>
<body>
    <%--<header>--%>
        <%--<div class="head-cont">--%>
            <%--<div class="head-left fl">--%>
                <%--<img src="../images/logo.png" height="35" width="50" alt="">--%>
                <%--人事管理系统--%>
            <%--</div>--%>
            <%--<div class="head-nav fl" id="h-nav">--%>
                <%--<ul>--%>
                    <%--<li ><a href="#">成员导入</a></li>--%>
                    <%--<li ><a href="#">通讯录</a></li>--%>
                    <%--<li ><a href="#">成员导入</a></li>--%>
                    <%--<li class="active"><a href="upload.html">审批数据导入</a></li>--%>
                    <%--<li><a href="affairs-search.html">工资查询</a></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
            <%--<div class="head-right fl">--%>
                <%--欢迎您！管理员&nbsp;&nbsp;&nbsp;--%>
                <%--<a href=""><img src="../images/guanbi.png" height="22" width="22" alt=""></a>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</header>--%>
    <div class="row-fluid top-tiku">
        <div class="top-left"> <img src="../images/logo.png" />
            <p>人事管理系统</p>
        </div>
        <div id="box">
            <script language="javascript">          function switchMenustyle(num) { for (var id = 1; id <= 5; id++) { if (id == num) { document.getElementById("mynav" + id).className = "hover"; } else { document.getElementById("mynav" + id).className = ""; } } }          </script>
            <div id="menu">
                <ul>
                    <li ><a  id="mynav1" onclick="switchMenustyle(1)"data-bind="attr: { href: '<%=basePath%>userinfo/import.do'}">人员导入 </a></li>
                    <li><a   id="mynav2" onclick="switchMenustyle(2)"data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}"> 通讯录 </a></li>
                    <li ><a  id="mynav3" onclick="switchMenustyle(3)" data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}">人员统计 </a></li>
                    <li ><a  id="mynav4" onclick="switchMenustyle(4)" data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}"> 部门统计</a></li>
                    <li ><a  id="mynav5" onclick="switchMenustyle(5)"data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}"> 趋势统计</a></li>
                    <li ><a class="hover" id="mynav6" onclick="switchMenustyle(6)"data-bind="attr: { href: '<%=basePath%>userinfo/test.do'}">工资查询</a></li>
                </ul>
            </div>
            <div class="top-right">
            </div>
            <p>欢迎您！<span >管理员</span></p>
            <a href=""><img src="../images/guanbi.png" /></a> </div>
    </div>
    <div class="contain">
        <div class="content">
            <div class="cont-tit">
                工资查询
            </div>
            <div class="search">
                <div class="ser-input fl">

                    姓名：<input type="text" placeholder="输入姓名">
                    日期：<input type="text" placeholder="输入查询日期" class="input" id="monthly">

                </div>
                <div class="ser-btn fr">

                    <button class="button button-glow button-border button-rounded button-primary button-small ">查询</button>
                    <button class="button button-glow button-border button-rounded button-highlight button-small ">清空</button>

                </div>
            </div>
            <div class="ser-resault">
                <table border="1">
                    <thead>
                    <tr>
                        <th>日期</th>
                        <th>工作日</th>
                        <th>周末</th>
                        <th>缺勤</th>
                        <th>缺勤工资</th>
                        <th>事假</th>
                        <th>事假工资</th>
                        <th>长病假</th>
                        <th>长病假工资</th>
                        <th>调休</th>
                        <th>调休工资</th>
                        <th>请假</th>
                        <th>请假工资</th>
                        <th>加班</th>
                        <th>加班工资</th>
                        <th>出差天数</th>
                        <th>出差补贴</th>
                        <th>time</th>
                        <th>奖金</th>
                        <th>发放</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>xxx</td>
                        <td>2016-10</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                    </tr>
                    <tr>
                        <td>xxx</td>
                        <td>2016-10</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td>合计</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                        <td>0.00</td>
                    </tr>
                    </tfoot>
                </table>
            </div>

        </div>
    </div>


    <footer>
    <div>上海音达科技实业有限公司</div>
    <div><a href="">帮助中心</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="">友情链接</a></div>
</footer>
    <script>
    // 日期插件开始
        $('#monthpicker').monthpicker({
            years: [2017,2016,2015, 2014, 2013, 2012, 2011,2010,2009],
            topOffset: 6,
            onMonthSelect: function(m, y) {
                console.log('Month: ' + m + ', year: ' + y);
            }
        });
        $('#monthly').monthpicker({
            years: [2017,2016,2015, 2014, 2013, 2012, 2011,2010,2009],
            topOffset: 6
        })
        //日期插件结束

    </script>
</body>
</html>