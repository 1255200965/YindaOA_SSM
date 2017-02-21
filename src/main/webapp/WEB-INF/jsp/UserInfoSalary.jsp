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
<html>
<head>
    <title>通讯录查看</title>
    <%--<link type="text/css" rel="stylesheet" href="../stylesheets/style.css" />--%>
    <link rel="stylesheet" href="../stylesheets/reset.css">

    <link href="../stylesheets/bootstrap.min.css" rel="stylesheet" />
    <link href="../stylesheets/bootstrap-theme.min.css" rel="stylesheet" />
    <link href="../stylesheets/bootstrap-treeview.min.css" rel="stylesheet" />
    <link href="../stylesheets/shujutongji.css" rel="stylesheet" />
    <link href="../stylesheets/ddcss.css" rel="stylesheet" />
    <link rel="stylesheet" href="../stylesheets/header.css">

    <link rel="shortcut icon" type="image/ico" href="../images/yd.ico" />
    <link rel="stylesheet" href="../stylesheets/reset.css">
    <link rel="stylesheet" href="../stylesheets/buttons.css">
    <link rel="stylesheet" href="../stylesheets/header.css">
    <link rel="stylesheet" href="../stylesheets/affairs-search.css">
    <link rel="stylesheet" href="../datePlug/jquery.monthpicker.css">
    <script src="../javascripts/jquery-1.10.2.js"></script>
    <script src="../datePlug/jquery.monthpicker.js"></script>

    <script type="text/javascript" src="../javascripts/bootstrap.min.js"></script>
    <script type="text/javascript" src="../javascripts/bootstrap-treeview.min.js"></script>
    <script src="../javascripts//knockout-3.4.0rc.js"></script>
    <style>
        *{box-sizing: content-box;-webkit-box-sizing: content-box;}
        .c_box{min-width:1350px;width:100%;}
        .c_box .col-md-2{min-width:189px;width:12.4%;}
        .c_box .c_left_box{height:850px;}
        .c_box .c_right_box {min-width:1056.7px;width:79%;}
        .table-1 tbody td{font-size:12px;}
    </style>

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


                //===============================
                //获取部门成员
                self.GetUserListByDep = function(depddid){
                    $.ajax({
                        data:JSON.stringify(new UserModel(depddid,null,null,getNowDate())),
                        type:"post",
                        headers: { 'Content-Type': 'application/json' },
                        dataType: 'json',
                        url:"../userinfosalary/querys.do",
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
                    if (nowDep != null){var depid = nowDep.name;} else {depid = null;}
                    $.ajax({
                        data:JSON.stringify(new UserModel(depid,$("#search_name").val(),$("#search_salaryid").val(),getNowDate())),
                        type:"post",
                        async: false,
                        headers: { 'Content-Type': 'application/json' },
                        dataType: 'json',
                        url:"../userinfosalary/select.do",
                        error:function(data){
                            alert("出错了！！:"+data.msg);
                        },
                        success:function(data){
                            result = eval(data.usertest);
                            self.ShowList.removeAll();
                            for (var i = 0; i < result.length; i++) {
                                self.ShowList.push(result[i]);
                            }
                        }
                    });

                }

                //修改工资
                self.UpdateSalary = function(){
                    $.ajax({
                        data:JSON.stringify(self.changeItem()),
                        type:"post",
                        headers: { 'Content-Type': 'application/json' },
                        dataType: 'json',
                        url:"../userinfosalary/updatesalary.do",
                        error:function(data){
                            alert("出错了！！:"+data.msg);
                        },
                        success:function(data){
                            alert("修改结果:"+data.msg);
                            if (data.ok == "ok") {
                                for (var i = 0; i < self.ShowList().length; i++) {
                                    if (self.ShowList()[i].sid == self.changeItem().sid) {
                                        self.ShowList.splice(i, 1);
                                        self.ShowList.splice(i, 0, self.changeItem());
                                        break;
                                    }
                                }
                            }
                        }
                    });
                    //关闭模态框，更新前端
                    self.ClickModelNo();
                }

                //点击事件-点击更新用户按钮
                self.ClickUpdate = function(item){
                    self.changeItem(item);
                    self.rootid(0);
                    //$("#model1").click();
                    self.ClickModelYes();

                };
                //点击事件-点击搜索
                self.ClickSearch = function () {
                    self.GetUserByQuery();
                }
                //点击事件-点击清空搜索项
                self.ClickClear = function() {
                    $("#search_name").val("");
                    $("#search_salaryid").val("");

                }
                //点击事件-模态框确定
                self.ClickModelYes = function() {
                            if (!confirm("确认要修改？")) {
                                window.event.returnValue = false;
                            }else{
                                self.UpdateSalary();
                                return true;
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
                            self.chooseDep();
                        },
                        onNodeUnselected: function (event, data) {
                            nowDep = null;
                        }
                    });
                    $('#tree').treeview('collapseAll');
                }
                //点击部门事件
                self.clickNode1 = function (event, data) {
                    if (lastSelectedNodeId && lastSelectTime) {
                        var time = new Date().getTime();
                        var t = time - lastSelectTime;
                        if (lastSelectedNodeId == data.name && t < 300) {
                            nowDep = data;
                            self.chooseDep();
                            alert("选择部门:"+data.name);
                        }
                    }
                    lastSelectedNodeId = data.name;
                    lastSelectTime = new Date().getTime();
                }
                //选择部门
                self.chooseDep = function () {
                    var id = "";
                    if (nowDep != null) {
                        id = nowDep.name;
                    }
                    //获取部门用户
                    self.GetUserListByDep(id);
                }
            }
            ko.applyBindings(new ViewModel);
        });


        function UserModel(depid,name,salaryid,salarydate) {
            this.sid = null;
            this.salarydate=salarydate;
            this.name = name;
            this.department=depid;
            this.userid = null;
            this.salaryid = salaryid;
            return this;
        }
        function getNowDate() {
            var d = new Date();
            if (d.getMonth()<10) {
                return d.getFullYear() + '-0'+ (d.getMonth()+1);
            } else {
                return d.getFullYear() + '-' + (d.getMonth()+1);
            }
        }
    </script>
</head>
<body>


<div class="row-fluid c_box" style="">
    <div class="col-md-2 c_left_box" >
        <div style="margin-top:3%"></div>
        <div id="tree" style="overflow:auto;height:800px;"></div>

    </div>
    <div class="col-md-10 c_right_box" >
        <div class="caidan-tiku" style="margin-bottom:3%">
            <div class="caidan-tiku-s" style="margin-right:5%"> <span>姓名：</span>
                <input id="search_name" type="text" name="name" class="shuruk-a2" placeholder="">
            </div>
            <div class="caidan-tiku-s" style="margin-right:5%"> <span>工号：</span>
                <input id="search_salaryid" type="text" name="salaryid" class="shuruk-a2" placeholder="">
            </div>
<%--            <div class="caidan-tiku-s" style="margin-right:5%"> <span>日期：</span>
                <input id="search_salarydate" type="text" name="salarydate" class="shuruk-a2" placeholder="">
            </div>--%>
            <div style="float:right;margin-right:15px;padding-bottom:10px;" >
                <input data-bind="click:$root.ClickSearch" type="button" value="查询"  class="chaxun">
                <%--<input  data-bind="click:$root.ClickClear" type="button" value="清空"  class="chaxun" style="background:#fd9162">--%>
            </div>
        </div>
            <div style="width:100%; height:700px;padding-top: 5px;overflow:auto;border:0 solid #000000;">

            <table  width="100%" border="1" cellspacing="0" cellpadding="0" class="table-1">
                <thead class="table-1-tou" >
                <td class="text_center" width="5%"  >姓名</td>
                <td class="text_center" width="9%">部门</td>
                <td class="text_center" width="5%">工号</td>
                <td class="text_center" width="6%">日期</td>
                <td class="text_center" width="5%">出勤天数</td>
                <td class="text_center" width="6%">出勤工资</td>
                <td class="text_center" width="5%">请假补款</td>
                <td class="text_center" width="5%">加班费</td>
                <%--<td class="text_center" width="6%">小计</td>--%>
                <td class="text_center" width="6%">出差费</td>
                <td class="text_center" width="4%">交通费</td>
                <td class="text_center" width="5%">合同类型</td>
                <td class="text_center" width="5%">签到天数</td>
                <td class="text_center" width="6%">timebase奖金</td>
                <td class="text_center" width="6%">timebase调整项</td>
                <td class="text_center" width="6%">taskbase奖金</td>
                <td class="text_center" width="6%">taskbase调整项</td>
                <td class="text_center" width="6%">奖金调整项</td>
                <td class="text_center" width="6%">合计工资</td>
                <td class="text_center" width="5%">操作</td>
                </thead>

                <tbody data-bind="foreach:ShowList">
                <tr >
                    <td data-bind="text:name">编号</td>
                    <td data-bind="text:department">编号</td>
                    <td data-bind="text:salaryid">编号</td>
                    <td data-bind="text:salarydate">编号</td>
                    <td data-bind="text:effectiveattendance">编号</td>
                    <td data-bind="text:attendancesalary">编号</td>
                    <td data-bind="text:leavesalary">编号</td>
                    <td data-bind="text:worksalary">编号</td>
                    <%--<td data-bind="text:subtotal">编号</td>--%>
                    <td data-bind="text:allowance">编号</td>
                    <td data-bind="text:trafficsalary">编号</td>
                    <td data-bind="text:contractType"></td>
                    <td data-bind="text:realityattendance">编号</td>
                    <td data-bind="text:timesalary">编号</td>
                    <td ><input  class="c_ding_input" style="width:50%" data-bind="textinput:timebaseadd"/></td>
                    <td data-bind="text:tasksalary">编号</td>
                    <td ><input  class="c_ding_input" style="width:50%" data-bind="textinput:taskbaseadd"/></td>
                    <td ><input  class="c_ding_input" style="width:50%" data-bind="textinput:userbonus"/></td>
                    <td data-bind="text:totalsalary">编号</td>
                    <td>
                        <input data-bind="click:$root.ClickUpdate" type="button" value="保存修改" class="gx-btn_large"/>
                    </td>
                </tr>
                </tbody>
            </table></div>
    </div>
</div>
<div class="row-fluid">
    <div class="footer" data-reactid=".0.a">
        <div style="margin-bottom:5px;" data-reactid=".0.a.0">
            <span data-reactid=".0.a.0.0">
                <img width="11px" src="https://gw.alicdn.com/tps/TB14UngLXXXXXXQapXXXXXXXXXX-22-26.png" data-reactid=".0.a.0.0.0"></span>
            <span data-reactid=".0.a.0.1">上海音达科技实业有限公司</span></div>

    </div>
</div>


<%--</div>--%>
<!-- Button trigger modal -->
<button type="button" id="model1" style="display: none" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    modal
</button>
<button type="button" id="model1" style="display: none" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    modal
</button>
<div class="container">
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="false">
        <div class="modal-dialog c_side_modal_box"  role="document" style="margin: 0px;">
            <div class="modal-content c_side_modal " >
                <div class="modal-header c_modal_head">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">用户信息详情</h4>
                </div>
                <div class="modal-body c_modal_body">
                    <div data-bind="with:changeItem">
                        <div class="c_action_content" >修改奖金</div>
                        <div class="c_ding_form" >
                            <div class="c_ding_form_group" >
                                <label><i class="iconfont c_ding_from_icon" >*</i><span >姓名:</span></label>
                                <div class="input_content" >
                                    <input class="c_ding_input" data-bind="textinput:name" readonly="readonly" />
                                </div>
                            </div>

                            <div class="c_ding_form_group" >
                                <label><i class="iconfont c_ding_from_icon" >**</i><span >奖金:</span></label>
                                <div class="input_content" >
                                    <input id="userbonus" class="c_ding_input" data-bind="textinput:userbonus"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer c_modal_foot">
                    <button id="close1" type="button" class="c_ding_btn" data-dismiss="modal">Close</button>
                    <button type="button" class="c_ding_btn c_ding_btn_primary" data-bind="click:$root.ClickModelYes">提交</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    // 日期插件开始

    $('#search_salarydate').monthpicker({
        years: [2017,2016,2015, 2014, 2013, 2012, 2011,2010,2009],
        topOffset: 10,
    });
    //日期插件结束

</script>
</body>
</html>
