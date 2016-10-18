<%--
  Created by IntelliJ IDEA.
  User: ma
  Date: 2016/10/17
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link type="text/css" rel="stylesheet" href="../stylesheets/style.css" />
<link href="../stylesheets/bootstrap-theme.min.css" rel="stylesheet" />
<link href="../stylesheets/bootstrap.min.css" rel="stylesheet" />
<link href="../stylesheets/shujutongji.css" rel="stylesheet" />
<script type="text/javascript" src="../javascripts/jquery-1.10.2.js"></script>
<script type="text/javascript" src="../javascripts/bootstrap.min.js"></script>
<script src="../javascripts//knockout-3.4.0rc.js"></script>

<script type="text/javascript">
    var result = null;
    function ajaxTest(){
        $.ajax({
            data:"name="+$("#name").val(),
            type:"get",
            dataType: 'json',
            url:"../userinfo/login.do",
            error:function(data){
                alert("出错了！！:"+data.msg);
            },
            success:function(data){
                alert("success:"+data.msg);
                result = eval(data.usertest);
                $("#result").html(data.usertest.name) ;
            }
        });
    }

    //============================================
    $(document).ready(function () {

        var ViewModel = function () {
            var self = this;
            //变量区

            self.showTree = ko.observableArray();
            //当前显示的树列表
            self.rootid = ko.observable();
            //搜索的知识树编号
            self.classid = ko.observable();
            self.changeItem = ko.observable();
            //待修改题目
            self.overItem = ko.observable(0);
            self.allItem = ko.observable(0);
            self.allCount = ko.observable(0);
            //==============================
            self.AllList = ko.observableArray();
            //绑定题目列表对象


            self.ShowList = ko.observableArray();
            //当前显示的人员列表


            //ko初始化数据加载
            $(function () {


            });
            self.GetUserList = function(){
                $.ajax({
                    data:"name="+$("#name").val(),
                    type:"get",
                    dataType: 'json',
                    url:"../userinfo/login.do",
                    error:function(data){
                        alert("出错了！！:"+data.msg);
                    },
                    success:function(data){
                        //result = eval(data.usertest);
                        self.ShowList.removeAll();
                        //清空viewmodel
                        for (var i = 0; i < data.length; i++) {
                            self.ShowList.push(data[i]);
                            //加入每行题目信息

                        }
                    }
                });
            }


        }
        ko.applyBindings(new ViewModel);
    });

</script>

<head>
    <title>Title</title>
</head>
<body>
<%--

<div style="width:30%;height:500px;background-color: #1b6d85;float:left">
    <input type="text" name="name" id="name"/>
    <input type="submit" value="登录" onclick="ajaxTest();"/>
    <input type="submit" value="更新" onclick=""/>
    <div id="result"></div>
</div>

<div style="width:70%;height:500px;background-color: #5cb85c;float:left">
    <table border="1">
        <tbody>
        <tr>
            <th>姓名</th>
            <th>工号</th>
            <th>电话</th>
            <th>邮箱</th>
        </tr>
        <c:if test="${!empty listUser }">
            <c:forEach items="${listUser}" var="list">
                <tr>
                    <td>${list.name }</td>
                    <td>${list.idcard }</td>
                    <td>${list.cellphone }</td>
                    <td>${list.mail }</td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</div>
--%>

<div class="container-fluid">
    <div class="row-fluid top-tiku">
        <div class="top-left"> <img src="~/Content/images/logo.png" />
            <p>人事管理系统</p>
        </div>
        <div id="box">
            <script language="javascript">          function switchMenustyle(num) { for (var id = 1; id <= 5; id++) { if (id == num) { document.getElementById("mynav" + id).className = "hover"; } else { document.getElementById("mynav" + id).className = ""; } } }          </script>
            <div id="menu">
                <ul>
                    <li ><a  id="mynav1" onclick="switchMenustyle(1)"data-bind="attr: { href: GetUrl(1)}">人员导入 </a></li>
                    <li><a  class="hover" id="mynav2" onclick="switchMenustyle(2)"data-bind="attr: { href: GetUrl(2)}"> 通讯录 </a></li>
                    <li ><a  id="mynav3" onclick="switchMenustyle(3)" data-bind="attr: { href: GetUrl(3)}">人员统计 </a></li>
                    <li ><a  id="mynav4" onclick="switchMenustyle(4)" data-bind="attr: { href: GetUrl(4)}"> 部门统计</a></li>
                    <li ><a  id="mynav5" onclick="switchMenustyle(5)"data-bind="attr: { href: GetUrl(5)}"> 趋势统计</a></li>
                </ul>
            </div>
        </div>
        <div class="top-right">
            <p>欢迎您！<span data-bind="text:GetUser()">张三三</span></p>
            <a href="Login"><img src="~/Content/images/guanbi.png" /></a> </div>
    </div>
    <div class="row-fluid">
        <div class="col-md-2" >
            <ul class="nav nav-stacked nav-pills">
                <li class="active">
                    <a href="#">人事部</a>
                </li>
                <li>
                    <a href="#">财务部</a>
                </li>
                <li class="disabled">
                    <a href="#">创新部</a>
                </li>

            </ul>
        </div>
        <div class="col-md-10" >
            <div class="caidan-tiku" style="margin-bottom:2%">
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>姓名：</span>
                    <input id="nr1" type="text" name="name" class="shuruk-a2" placeholder="">
                </div>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>电话：</span>
                    <input data-bind="click:function(){$root.CilckClass(0)},textinput:classid" id="class1" type="text" name="firstname" class="shuruk-a2" >
                </div>

                <div class="caidan-tiku-s" style="margin-right:5%"> <span>工号：</span>
                    <input id="workid" type="text" name="firstname" class="shuruk-a2" placeholder="">
                </div>
<%--                <div class="caidan-tiku-s"> <span>是否审核：</span>
                    <select id="sh1" class="riqi-xiala" style="width:70px;" data-bind="options: [0,1], optionsText: function (item) {  if (item == 0) return '否'; else return '是';},optionsCaption:''"></select>
                </div>
                <div class="caidan-tiku-s"> <span>难度：</span>
                    <select id="nd1" class="riqi-xiala" style="width:70px;" data-bind="options: [1,2,3,4,5,6,7,8,9], optionsText: function (item) {  return item;},optionsCaption:''"></select>
                </div>--%>
                <div style="float:right">
                    <input data-bind="click:$root.ClickSearch" type="button" value="查询"  class="chaxun">
                    <input  data-bind="click:$root.ClickClear" type="button" value="清空"  class="chaxun" style="background:#fd9162">
                </div>
            </div>
            <table style="margin-top:15px;" width="95%" border="1" cellspacing="0" cellpadding="0" class="table-1">
                <tr class="table-1-tou">
                    <td width="5%">编号 </td>
                    <td width="38%">姓名</td>
                    <td width="5%">工号</td>
                    <td width="5%"> 部门 </td>
                    <td width="7%">手机号 </td>
                    <td width="7%"> 邮箱 </td>
                    <td width="7%"> 相关信息 </td>
                    <td width="7%"> 状态 </td>
                    <td width="12%"> 操作 </td>
                    <td width="7%">审核 </td>
                </tr>
                <tbody data-bind="foreach:ShowList">
                <tr data-bind="style: { color: 审核 == '1' ? 'green' : 'black',fontWeight: 审核 == '1' ? 'bold' : 'normal'}">
                    <td data-bind="text:试题编号">编号</td>
                    <td data-bind="text:标题">标题</td>
                    <td data-bind="text:题型">题型</td>
                    <td data-bind="text:难度">难度</td>
                    <td data-bind="text:知识树编号">知识树编号</td>
                    <td data-bind="text:所属知识">所属知识</td>
                    <td data-bind="text:修改者">修改者</td>
                    <td data-bind="text:transFormat(审核)">审核状态</td>
                    <td><input data-bind="click:$root.ClickUpdate" type="button" value="更新" class="gx-btn"/><input  data-bind="click:$root.DeleteItem" type="button" value="删除" class="gx-btn" style="background:#fd9162;"/></td>
                    <td><input data-bind="click:$root.SHItem,style: { display: role == 'admin' ? 'block' : 'none' }" type="button" value="审核" class="gx-btn" style="background:#fab807;"/></td>

                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
