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
<link href="../stylesheets/bootstrap.min.css" rel="stylesheet" />
<link href="../stylesheets/bootstrap-theme.min.css" rel="stylesheet" />
<link href="../stylesheets/bootstrap-treeview.min.css" rel="stylesheet" />
<link href="../stylesheets/shujutongji.css" rel="stylesheet" />
<script type="text/javascript" src="../javascripts/jquery-1.10.2.js"></script>
<script type="text/javascript" src="../javascripts/bootstrap.min.js"></script>
<script type="text/javascript" src="../javascripts/bootstrap-treeview.min.js"></script>
<script src="../javascripts//knockout-3.4.0rc.js"></script>

<script type="text/javascript">
    var result = null;
    function ajaxTest(){
        $.ajax({
            data:"name="+$("#nr1").val(),
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
            //获取用户列表测试用
            self.GetUserList = function(){
                $.ajax({
                    data:"name="+$("#search_name").val(),
                    type:"get",
                    dataType: 'json',
                    url:"../userinfo/login.do",
                    error:function(data){
                        alert("出错了！！:"+data.msg);
                    },
                    success:function(data){
                        result = eval(data.usertest);
                        self.ShowList.removeAll();
                        //清空viewmodel
                        for (var i = 0; i < result.length; i++) {
                            self.ShowList.push(result[i]);
                            //加入每行题目信息

                        }
                    }
                });
            }




            //===============================
            //获取部门成员
            self.GetUserListByDep = function(depddid){
                $.ajax({
                    data:JSON.stringify(new UserModel(depddid,null,null,null)),
                    type:"post",
                    headers: { 'Content-Type': 'application/json' },
                    dataType: 'json',
                    url:"../userinfo/login.do",
                    error:function(data){
                        alert("出错了！！:"+data.msg);
                    },
                    success:function(data){
                        result = eval(data.usertest);
                        self.ShowList.removeAll();
                        //清空viewmodel
                        for (var i = 0; i < result.length; i++) {
                            self.ShowList.push(result[i]);
                            //加入每行题目信息

                        }
                    }
                });

            }
            //查询成员列表（部门，姓名，电话，工号）
            self.GetUserByQuery = function(){
                $.ajax({
                    data:JSON.stringify(new UserModel(nowDep.id,$("#search_name").val(),$("#search_workid").val(),$("#search_phone").val())),
                    type:"post",
                    headers: { 'Content-Type': 'application/json' },
                    dataType: 'json',
                    url:"../userinfo/login.do",
                    error:function(data){
                        alert("出错了！！:"+data.msg);
                    },
                    success:function(data){
                        result = eval(data.usertest);
                        self.ShowList.removeAll();
                        //清空viewmodel
                        for (var i = 0; i < result.length; i++) {
                            self.ShowList.push(result[i]);
                            //加入每行题目信息

                        }
                    }
                });

            }
            //新增部门成员
            self.AddNewUser = function(){
                $.ajax({
                    data:JSON.stringify(self.changeItem()),
                    type:"post",
                    headers: { 'Content-Type': 'application/json' },
                    dataType: 'json',
                    url:"../userinfo/adduser.do",
                    error:function(data){
                        alert("出错了！！:"+data.msg);
                    },
                    success:function(data){
                        alert("success:"+data.msg);

                    }
                });

            }
            //修改部门成员
            self.UpdateUser = function(){
                $.ajax({
                    data:JSON.stringify(self.changeItem()),
                    type:"post",
                    headers: { 'Content-Type': 'application/json' },
                    dataType: 'json',
                    url:"../userinfo/updateuser.do",
                    error:function(data){
                        alert("出错了！！:"+data.msg);
                    },
                    success:function(data){
                        alert("success:"+data.msg);

                    }
                });
            }
            //删除部门成员
            self.DeleteUser = function(){}
            //点击事件-点击添加用户按钮
            self.ClickAdd = function(){
                self.changeItem(new UserModel());
                self.rootid(1);
                $("#model1").click();
            };
            //点击事件-点击更新用户按钮
            self.ClickUpdate = function(item){
                self.changeItem(item);
                self.rootid(0);
                $("#model1").click();
            };
            //点击事件-点击删除用户按钮
            self.ClickDelete = function(){};
            //点击事件-点击搜索
            self.ClickSearch = function () {
                self.GetUserByQuery();
            }
            //点击事件-点击清空搜索项
            self.ClickClear = function() {
                /*                searchlab = 0;
                 $("#nr1").val("");
                 $("#zzs1").val("");
                 $("#stfx1").val("");
                 $("#sh1").val("");
                 $("#nd1").val("");*/
            }
            //点击事件-模态框确定
            self.ClickModelYes = function() {
                if (self.rootid() == 0) {
                        self.UpdateUser();
                    } else {
                        self.AddNewUser();
                }
            };
            //点击事件-模态框关闭
            self.ClickModelNo = function(){
                $("#close1").click();
            };
            //==========部门列表方法==============
            //获取部门列表
            self.GetDepartment = function () {
                $.ajax({
                    type: "post",
                    async: false,
                    contentType: "text/json",
                    url: "../department/GetDepList.do",
                    headers: { 'Content-Type': 'application/json' },
                    error:function(data){
                        alert("出错了！！:"+data.msg);
                    },
                    success:function(data){
                        //alert("success:"+data.msg);
                        tree = eval(data.dep);
                    }
                });
                //显示部门列表
                $('#tree').treeview({
                    data: tree,
                    onNodeSelected: function (event, data) {
                        nowDep = data;
                        self.clickNode1(event, data);
                    },
                    onNodeUnselected: function (event, data) {
                        nowDep = null;
                        self.clickNode1(event, data);
                    }
                });
                $('#tree').treeview('collapseAll');
            }
            //点击部门事件
            self.clickNode1 = function (event, data) {
                if (lastSelectedNodeId && lastSelectTime) {
                    var time = new Date().getTime();
                    var t = time - lastSelectTime;
                    if (lastSelectedNodeId == data.id && t < 300) {
                        nowDep = data;
                        self.chooseDep();
                        alert("选择部门:"+data.name);
                    }
                }
                lastSelectedNodeId = data.id;
                lastSelectTime = new Date().getTime();
            }
            //选择部门
            self.chooseDep = function () {
                var id = "";
                if (nowDep != null) {
                    id = nowDep.id;
                }

                //获取部门用户
                self.GetUserListByDep(id);
            }
        }
        ko.applyBindings(new ViewModel);
    });
    function UserModel(depid,name,workid,cellphone) {
        this.sequenceNum = null;
        this.name = name;
        this.age = null;
        this.sex = null;
        this.department = depid;
        this.idcard = workid;
        this.cellphone = cellphone;
        this.userId = null;
        this.userState = null;
        this.mail = null;
        return this;
    }
    function GetUrl(id) {
        var ans = "Login";
        switch (id) {
            case 1: ans = "UpLoad"; break;
            case 2: ans = "ViewTable"; break;
            case 3: ans = "ShowStat"; break;
            case 4: ans = "ShowRepeat"; break;
            case 5: ans = "ShowTree"; break;
        }
        var url = location.search;
        if (url.indexOf("?") != -1) {
            var s = url.indexOf("?");
            ans += url.substring(s);// t就是?后面的东西了
        }
        return ans;
    }
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
        <div class="top-left"> <img src="../images/logo.png" />
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
            <p>欢迎您！<span >张三三</span></p>
            <a href="Login"><img src="../images/guanbi.png" /></a> </div>
    </div>
    <div class="row-fluid">
        <div class="col-md-2" >
<%--            <ul class="nav nav-stacked nav-pills">
                <li class="active">
                    <a href="#">人事部</a>
                </li>
                <li>
                    <a href="#">财务部</a>
                </li>
                <li class="disabled">
                    <a href="#">创新部</a>
                </li>

            </ul>--%>
            <div id="tree"></div>

        </div>
        <div class="col-md-10" >
            <div class="caidan-tiku" style="margin-bottom:2%">
                <div style="float:left">
                    <input data-bind="click:$root.ClickAdd" type="button" value="新增"  class="chaxun">
                </div>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>姓名：</span>
                    <input id="search_name" type="text" name="name" class="shuruk-a2" placeholder="">
                </div>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>电话：</span>
                    <input id="search_phone" type="text" name="cellphone" class="shuruk-a2" placeholder="">
                </div>

                <div class="caidan-tiku-s" style="margin-right:5%"> <span>工号：</span>
                    <input id="search_workid" type="text" name="workid" class="shuruk-a2" placeholder="">
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
                <tr >
                    <td data-bind="text:sequenceNum">编号</td>
                    <td data-bind="text:name">标题</td>
                    <td data-bind="text:idcard">题型</td>
                    <td data-bind="text:department">难度</td>
                    <td data-bind="text:cellphone">知识树编号</td>
                    <td data-bind="text:mail">所属知识</td>
                    <td data-bind="text:userId">修改者</td>
                    <td data-bind="text:userState">审核状态</td>
                    <td><input data-bind="click:$root.ClickUpdate" type="button" value="更新" class="gx-btn"/><input  data-bind="click:$root.ClickDelete" type="button" value="删除" class="gx-btn" style="background:#fd9162;"/></td>
                    <td><input  type="button" value="审核" class="gx-btn" style="background:#fab807;"/></td>

                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- Button trigger modal -->
<button type="button" id="model1" style="display: none" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    modal
</button>
<div class="container">
    <!-- Modal -->
    <div class="modal fade " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="false">
        <div class="modal-dialog " style="width:80%;margin-left: 10%;margin-top:0%" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">用户信息详情</h4>
                </div>
                <div class="modal-body">
                    <div data-bind="with:changeItem">
                                <span style="margin-bottom: 10px;" class="input-group">
                                    <span class="input-group-addon">姓名:</span><input id="bt" class="form-control" style="width:95%" data-bind="textinput:name" />
                                </span>

<%--                        <div style="margin-bottom: 5px;" class="input-group">
                            <span class="input-group-addon">难度:</span><select id="nd" class="form-control" style="border: 1px solid #621313; width:60px; margin-right:5px;" data-bind="options: [1,2,3,4,5,6,7,8,9], optionsText: function (item) {  return item;},textinput:难度,optionsCaption:''"></select>
                            <span style="margin-left: 2px;" class="input-group-addon">题目类型:</span><select id="tx" class="form-control" style="border: 1px solid #621313; width:100px; margin-right:5px;" data-bind="options: ['单选题','多选题','判断题'], optionsText: function (item) {  return item;},textinput:题型,optionsCaption:''"></select>
                            <span style="margin-left: 2px;" class="input-group-addon">题目分类:</span><input class="form-control" style="width: 80%" id="class" data-bind="textinput:题目分类,click:function(){$root.CilckClass(1);}" />
                            <span style="margin-left: 2px;" class="input-group-addon"><button data-bind="click:function(){$root.CilckTree(1);}">知识树编号</button>:</span><input class="form-control" style="width: 80%" id="zzs" data-bind="textinput:知识树编号" />
                        </div>--%>
                        <div style="margin-bottom: 10px;" class="input-group">
                            <span style="margin-left: 2px;" class="input-group-addon">工号:</span><input class="form-control" style="width: 80%" id="da" data-bind="textinput:idcard" />
                            <span style="margin-left: 2px;" class="input-group-addon">电话:</span><input class="form-control" style="width: 80%" id="sszz" data-bind="textinput:cellphone" />
                        </div>
                        <div style="margin-bottom: 5px;" class="input-group">
                            <span style="margin-left: 2px;" class="input-group-addon">部门:</span><input class="form-control" style="width:80%" id="kxda1" data-bind="textinput:department" />
                            <span style="margin-left: 2px;" class="input-group-addon">邮箱:</span><input class="form-control" style="width:80%" id="kxda2" data-bind="textinput:mail" />
                        </div>
                        <div style="margin-bottom: 5px;" class="input-group">
                            <span style="margin-left: 2px;" class="input-group-addon">钉钉id:</span><input class="form-control" style="width: 80%" id="kxda3" data-bind="textinput:userId" />
                            <span style="margin-left: 2px;" class="input-group-addon">用户状态:</span><input class="form-control" style="width: 80%" id="kxda4" data-bind="textinput:userState" />
                        </div>



                    </div>
                </div>
                <div class="modal-footer">
                    <button id="close1" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" data-bind="click:$root.ClickModelYes">提交</button>
                    <button type="button" class="btn btn-primary">审核</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
