<%--
  Created by IntelliJ IDEA.
  User: ma
  Date: 2016/10/20
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<%--<link type="text/css" rel="stylesheet" href="../stylesheets/style.css" />--%>
<%--<link href="../stylesheets/bootstrap.min.css" rel="stylesheet" />--%>
<%--<link href="../stylesheets/bootstrap-theme.min.css" rel="stylesheet" />--%>
<%--<link href="../stylesheets/bootstrap-treeview.min.css" rel="stylesheet" />--%>
<%--<link href="../stylesheets/shujutongji.css" rel="stylesheet" />--%>
<%--<link href="../stylesheets/ddcss.css" rel="stylesheet" />--%>





<head>
        <meta charset="UTF-8">
        <title>工资查询</title>
        <link rel="stylesheet" href="../stylesheets/reset.css">
        <link rel="stylesheet" href="../stylesheets/buttons.css">
        <link rel="stylesheet" href="../stylesheets/header.css">
        <link rel="stylesheet" href="../stylesheets/affairs-search.css">
        <link rel="stylesheet" href="../datePlug/jquery.monthpicker.css">
        <script src="../javascripts/jquery-1.10.2.js"></script>
        <script type="text/javascript" src="../datePlug/jquery.monthpicker.js"></script>
    <%--<script type="text/javascript" src="../javascripts/bootstrap.min.js"></script>--%>
    <%--<script type="text/javascript" src="../javascripts/bootstrap-treeview.min.js"></script>--%>
    <script src="../javascripts/knockout-3.4.0rc.js"></script>
    <script type="text/javascript">
        var result = null;

        //============================================
        //当前选择的部门
        var nowDep = null;
        //最后一次触发节点Id
        var lastSelectedNodeId = null;
        //最后一次触发时间
        var lastSelectTime = null;
        //部门树
        var tree = [];
        //当前显示的页码
        var showindex = 0;
        //当前显示的分页条目
        var showpage = 20;

        function  dateTransform(date){
            var y=date.getFullYear();
            var m=date.getMonth()+1;
            var d=date.getDate();
            console.log(y+"-"+m+"-"+d)
        }


        $(document).ready(function () {

            var ViewModel = function () {
                var self = this;
                //变量区

                self.showTree = ko.observableArray();
                //当前显示的树列表
                self.rootid = ko.observable();
                //搜索的知识树编号
                self.classid = ko.observable();

                //待修改题目
                self.overItem = ko.observable(0);
                self.allItem = ko.observable(0);
                self.allCount = ko.observable(0);
                //==============================
                self.AllList = ko.observableArray();
                //绑定题目列表对象

                //当前被修改的用户信息
                self.changeItem = ko.observable();
                //当前显示的人员列表
                self.ShowList = ko.observableArray();

                //ko初始化数据加载
                $(function () {
                    self.GetDepartment();

                });
                //查询成员列表（部门，姓名，电话，工号）
                self.GetUserByQuery = function(){
//                if (nowDep != null){var depid = nowDep.name;} else {depid = null;}
                    $.ajax({
                        data:JSON.stringify(new UserModel($("#search_name").val(),$("#search_date").val())),
                        type:"post",
                        headers: { 'Content-Type': 'application/json' },
                        dataType: 'json',
                        url:"../usersalary/query.do",
                        error:function(data){
                            alert("出错了！！:"+data.msg);
                        },
                        success:function(data){
                            result = eval(data.userlist);
                            self.ShowList.removeAll();
                            for (var i = 0; i < result.length; i++) {
                                self.ShowList.push(result[i]);
                            }
                            //self.GetUserListByDep(nowDep.name);
                        }
                    });
                }
                //日期转换器
                self.ClickSearch = function () {
                    self.GetUserByQuery();
                }

                //点击事件-点击清空搜索项
                self.ClickClear = function() {
                    $("#search_name").val("");
                    $("#search_workid").val("");
                    $("#search_phone").val("");
                }

            }
            ko.applyBindings(new ViewModel);
        });
        function UserModel(name,salarydate) {
            this.sid = null;
            this.name = name;
            this.salarydate=salarydate;
            this.userid = null;
            this.salaryid = null;
            this.date = null;
            this.datetype = null;
            this.attendance = null;
            this.attendanceSalary = null;
            this.leavetype = null;
            this.workovertime = null;
            this.worksalary = null;
            this.evection = null;
            this.allowance = null;
            this.timesalary = null;
            this.task = null;
            this.tasksalary = null;
            this.busalary = null;
            this.trafficsalary = null;
            this.additionalsalary = null;
            return this;
        }
    </script>
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
                <li><a  data-bind="attr: { href: '<%=basePath%>Import/navigator.do'}">审批数据导入</a></li>
                <li><a class="active" data-bind="attr: { href: '<%=basePath%>userinfo/test.do'}">工资查询</a></li>
                <li><a data-bind="attr: { href: '<%=basePath%>userinfo/testMethod.do'}">关于我们</a></li>
            </ul>
        </div>
        <div class="head-right fl">
            欢迎您！管理员&nbsp;&nbsp;&nbsp;
            <a href=""><img src="../images/guanbi.png" height="22" width="22" alt=""></a>
        </div>
    </div>
</header>
    <div class="contain">
        <div class="content">
            <div class="cont-tit">
                工资查询
            </div>
            <div class="search">
                <div class="ser-input fl">
                    姓名：<input type="text" id="search_name" placeholder="输入姓名">
                    日期：<input type="text" id="search_date" placeholder="输入查询日期" class="input" id="monthly">
                </div>
                <%--<div class="ser-btn fr">--%>
                <%--<form action="${pageContext.request.contextPath}/usersalary/query.do" method="post">--%>
                <%--<table style="float:right;margin-right:15px;padding-bottom:10px;">--%>
                <%--<tr>--%>
                <%--<input  type="submit" value="查询"  class="chaxun">--%>
                <%--<input  type="button" value="清空"  class="chaxun" style="background:#fd9162">--%>
                <%--</tr>--%>
                <%--</table>--%>
                <%--</form>--%>
                <%--<div style="float:right;margin-right:15px;padding-bottom:10px;" >--%>
                <%--<input data-bind="click:$root.ClickSearch" type="button" value="查询"  class="chaxun">--%>
                <%--<input  data-bind="click:$root.ClickClear" type="button" value="清空"  class="chaxun" style="background:#fd9162">--%>
                <%--</div>--%>
                <div class="ser-btn fr">

                    <button class="button button-glow button-rounded button-primary button-small " data-bind="click:$root.ClickSearch">查询</button>
                    <button class="button button-glow button-rounded button-highlight button-small " data-bind="click:$root.ClickClear" >清空</button>

                </div>
            </div>
            <div class="ser-resault" >
                <table border="1">
                    <thead>
                    <tr >
                        <th>姓名</th>
                        <%--<th>用户id</th>--%>
                        <th>工资序列id</th>
                        <th>日期</th>
                        <th>日期类型</th>
                        <th>考勤情况</th>
                        <th>缺勤工资</th>
                        <th>请假类型</th>
                        <th>请假工资</th>
                        <th>加班</th>
                        <th>加班工资</th>
                        <th>出差</th>
                        <th>津贴</th>
                        <th>time认证奖金</th>
                        <th>task报告数</th>
                        <th>task报告奖金</th>
                        <th>公交地铁票</th>
                        <th>交通费</th>
                        <th>额外奖金</th>
                    </tr>
                    </thead>
                    <tbody data-bind="foreach:ShowList">
                    <tr >
                        <td data-bind="text:name">用户编号</td>
                        <%--<td data-bind="text:userid">用户编号</td>--%>
                        <td data-bind="text:salaryid">工资id</td>
                        <%--<td data-bind="text:date" > 日期</td>--%>
                        <td data-bind="text:date"></td>

                        <td data-bind="text:datetype">日期类型</td>
                        <td data-bind="text:attendance">知识树编号</td>
                        <td data-bind="text:attendanceSalary">所属知识</td>
                        <td data-bind="text:leavetype">修改者</td>
                        <td data-bind="text:leavesalary">审核状态</td>
                        <td data-bind="text:workovertime">ok的</td>
                        <td data-bind="text:worksalary">所属知识</td>
                        <td data-bind="text:evection">修改者</td>
                        <td data-bind="text:allowance">审核状态</td>
                        <td data-bind="text:timesalary">到大</td>
                        <td data-bind="text:task">所属知识</td>
                        <td data-bind="text:tasksalary">修改者</td>
                        <td data-bind="text:busalary">审核状态</td>
                        <td data-bind="text:trafficsalary">卫视</td>
                        <td data-bind="text:additionalsalary">卫视</td>
                    </tr>

                    <%--<c:forEach items="${usertest }" var="list">--%>
                    <%--<tr >--%>
                    <%--<td>${list.name }</td>--%>
                    <%--<td>${list.userid }</td>--%>
                    <%--<td>${list.salaryid }</td>--%>
                    <%--<td> <fmt:formatDate value="${list.date }" pattern="yyyy-MM-dd" /></td>--%>
                    <%--<td>${list.datetype }</td>--%>
                    <%--<td>${list.attendance }</td>--%>
                    <%--<td>${list.attendanceSalary }</td>--%>
                    <%--<td>${list.leavetype }</td>--%>
                    <%--<td>${list.leavesalary }</td>--%>
                    <%--<td>${list.workovertime }</td>--%>
                    <%--<td>${list.worksalary }</td>--%>
                    <%--<td>${list.evection }</td>--%>
                    <%--<td>${list.allowance }</td>--%>
                    <%--<td>${list.timesalary }</td>--%>
                    <%--<td>${list.task }</td>--%>
                    <%--<td>${list.tasksalary }</td>--%>
                    <%--<td>${list.busalary }</td>--%>
                    <%--<td>${list.trafficsalary }</td>--%>
                    <%--<td>${list.additionalsalary }</td>--%>
                    <%--</tr>--%>
                    <%--</c:forEach>--%>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
    <%--<div class="row-fluid">--%>
    <%--<div class="footer" data-reactid=".0.a">--%>
    <%--<div style="margin-bottom:5px;" data-reactid=".0.a.0">--%>
    <%--<span data-reactid=".0.a.0.0">--%>
    <%--<img width="11px" src="https://gw.alicdn.com/tps/TB14UngLXXXXXXQapXXXXXXXXXX-22-26.png" data-reactid=".0.a.0.0.0"></span>--%>
    <%--<span data-reactid=".0.a.0.1">上海音达科技实业有限公司</span></div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <footer>
        <p><img src="../images/tubiao.png" alt="">上海音达科技实业有限公司</p>
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
