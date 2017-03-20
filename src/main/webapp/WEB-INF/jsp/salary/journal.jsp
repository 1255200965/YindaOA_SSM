<%--这一行是JSP页面的必要标识--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--自定义一个标签，允许调用tags里的文件--%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%--开启c标签的使用--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--定义变量ctx代表上下文路径--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>

<head>
    <title>journal</title>
    <!-- head中的必要声明 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="../stylesheets/reset.css">

    <link href="${ctx}/stylesheets/bootstrap.min.css" rel="stylesheet" />
    <link href="${ctx}/stylesheets/bootstrap-theme.min.css" rel="stylesheet" />
    <link href="${ctx}/stylesheets/bootstrap-treeview.min.css" rel="stylesheet" />
    <link href="${ctx}/stylesheets/shujutongji.css" rel="stylesheet" />
    <link href="${ctx}/stylesheets/ddcss.css" rel="stylesheet" />
    <link rel="stylesheet" href="${ctx}/stylesheets/header.css">
    <%--加载table样式文件--%>
    <link rel="stylesheet" type="text/css" href="${ctx}/stylesheets/salary/table.css" />

    <script type="text/javascript" src="${ctx}/javascripts/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="${ctx}/javascripts/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/javascripts/bootstrap-treeview.min.js"></script>
    <script src="${ctx}/datePlug/jquery.monthpicker.js"></script>
    <script src="${ctx}/javascripts//knockout-3.4.0rc.js"></script>

    <script type="text/javascript">
        //======用户信息缓存============================
        // 进入页面时读session，得到role
        var role  = "<%=request.getAttribute("userRole")%>";
        var StaffName  ="<%=request.getAttribute("StaffName")%>";
        var Department  ="<%=request.getAttribute("Department")%>";
        var StaffID  ="<%=request.getAttribute("StaffID")%>";
        var StaffUserID  ="<%=request.getAttribute("StaffUserID")%>";
        //=============================================
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
                //==========================
                self.role = ko.observable(role);

                //==============================

                //当前部门信息
                self.dateCount = ko.observable();
                self.nowDep = ko.observable();


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
                    //如果查询的部门不对，不显示数据
                    //alert(Department +' '+ depddid);
                    if (role=="项目经理" && (Department.lastIndexOf(depddid)==-1 || depddid=="无线事业部") ){
                        //alert(depddid.lastIndexOf(Department));
                        self.ShowList.removeAll();
                        return ;
                    } else  if (role=="部门经理" && depddid.lastIndexOf(Department)==-1){
                        //alert(depddid.lastIndexOf(Department));
                        self.ShowList.removeAll();
                        return ;
                    } else
                    {
                        $.ajax({
                            data: JSON.stringify(new UserModel(depddid, null, null, "2017-02")),
                            type: "post",
                            headers: {'Content-Type': 'application/json'},
                            dataType: 'json',
                            url: "../userinfosalary/querys.do",
                            error: function (data) {
                                alert("出错了！！:" + data.msg);
                            },
                            success: function (data) {
                                result = eval(data.usertest);
                                self.ShowList.removeAll();
                                //清空viewmodel
                                for (var i = 0; i < result.length; i++) {
                                    self.ShowList.push(result[i]);
                                    //加入每行题目信息
                                }
                                if (result.length>0) self.dateCount(result[0].datetype);
                            }
                        });
                    }
                }

                //查询成员列表（部门，姓名，电话，工号）
                self.GetUserByQuery = function(){
                    if (nowDep != null){var depid = nowDep.name;} else {depid = Department;}
                    if  ($("#search_name").val() == "" && nowDep =="") {
                        alert("请输入名字或工号！");
                    } else {
                        $.ajax({
                            data: JSON.stringify(new UserModel(depid, $("#search_name").val(), null, "2017-02")),
                            type: "post",
                            async: false,
                            headers: {'Content-Type': 'application/json'},
                            dataType: 'json',
                            url: "../userinfosalary/select.do",
                            error: function (data) {
                                alert("出错了！！:" + data.msg);
                            },
                            success: function (data) {
                                result = eval(data.usertest);
                                self.ShowList.removeAll();
                                for (var i = 0; i < result.length; i++) {
                                    self.ShowList.push(result[i]);
                                }

                            }
                        });
                    }
                }

                // 修改工资,增加总计变化
                self.UpdateSalary = function(type,item){
                    if (role=='项目经理' && (item.timesalary<item.timebaseadd || item.tasksalary<item.taskbaseadd)){
                        //调整不合法
                        alert(item.name + "的调整项超出了界限！");

                    } else {

                        if (role=='项目经理')
                        {
                            item.task = '1';
                        }
                        else
                        {
                            item.task = '2';
                        }

                        $.ajax({
                            data: JSON.stringify(item),
                            type: "post",
                            headers: {'Content-Type': 'application/json'},
                            dataType: 'json',
                            async:'false',
                            url: "../userinfosalary/updatesalary.do",
                            error: function (data) {
                                alert("出错了！！:" + data.msg);

                            },
                            success: function (data) {
                                if (type == 1) alert("提交结果:"+data.msg);
                                if (data.ok == "ok") {
                                    for (var i = 0; i < self.ShowList().length; i++) {
                                        if (self.ShowList()[i].sid == item.sid) {
                                            item.totalsalary = parseFloat(item.subtotal) + parseFloat(item.allowance) + parseFloat(item.heatingAllowance) + parseFloat(item.trafficsalary)  + parseFloat(item.userbonus) + parseFloat(item.timebaseadd) + parseFloat(item.taskbaseadd);
                                            self.ShowList.splice(i, 1);
                                            self.ShowList.splice(i, 0, item);
                                            break;
                                        }
                                    }
                                }

                            }
                        });
                    }
                }
                // 点击事件-点击跳转到日报页
                self.ClickJump = function(item){
                    window.location.href="<%=basePath%>" + "userinfosalary/journal.do?staffid="+item.salaryid+"&&salaryState="+item.task;
                }
                // 点击事件-点击更新用户按钮
                self.ClickUpdate = function(item){
                    self.changeItem(item);
                    //单条审批，如果是项目经理没批，部门经理不能批
                    //如果项目经理批完，项目经理不能提交
                    //如果部门经理批完，部门经理不能批，项目经理也不能批
                    if (role=='项目经理' && item.task >0 ){
                        //项目经理不能审批已经被部门经理审批过的条目
                        alert(item.name + "已经被项目经理提交，不能提交!");

                    }  else if (role=='部门经理' && item.task >1){
                        //项目经理不能审批已经被部门经理审批过的条目
                        alert(item.name + "已经被部门经理提交，不能提交!");
                    } else{
                        self.ClickModelYes();
                    }

                };
                //点击事件-点击搜索
                self.ClickSearch = function () {
                    self.GetUserByQuery();
                }
                self.ClickAllSearch = function () {
                    if (!confirm("确认要全部审批通过？")) {
                        window.event.returnValue = false;
                    }else{
                        //逐条审批
                        for (var j = 0; j < self.ShowList().length; j++) {
                            self.changeItem(self.ShowList()[j]);
                            var item = self.changeItem();
                            if (role=='项目经理' && item.task >0 ){
                                //项目经理不能审批已经被部门经理审批过的条目
                                alert(item.name + "已经被项目经理提交，不能提交!");

                            }  else if (role=='部门经理' && item.task >1){
                                //项目经理不能审批已经被部门经理审批过的条目
                                alert(item.name + "已经被部门经理提交，不能提交!");
                            } else{
                                self.UpdateSalary(0,item);
                            }

                        }
                        alert("全部处理完成！");
                        return true;
                    }
                }
                //点击事件-点击清空搜索项
                self.ClickClear = function() {
                    $("#search_name").val("");
                    $("#search_salaryid").val("");

                }

                //点击事件-模态框确定
                self.ClickModelYes = function() {
                    if (!confirm("确认要提交？")) {
                        window.event.returnValue = false;
                    }else{

                        self.UpdateSalary(1,self.changeItem());
                        return true;
                    }
                };

                //点击事件-模态框关闭
                // self是一个全局变量，是一个handler，类似于this
                self.changeValue = function(item){
                    item.totalsalary = parseFloat(item.subtotal) + parseFloat(item.allowance) + parseFloat(item.heatingAllowance) + parseFloat(item.trafficsalary)  + parseFloat(item.userbonus) + parseFloat(item.timebaseadd) + parseFloat(item.taskbaseadd);
                    //如果项目经理已经审批了，不能修改
                    $.ajax({
                        data: JSON.stringify(item),
                        type: "post",
                        headers: {'Content-Type': 'application/json'},
                        dataType: 'json',
                        url: "../userinfosalary/updatesalary.do",
                        error: function (data) {
                            alert("出错了！！:" + data.msg);

                        },
                        // 玩杂技，return并不返回数据，只返回状态，更新的值是从JS中算出来的。
                        success: function (data) {
                            if (data.ok == "ok") {
                                for (var i = 0; i < self.ShowList().length; i++) {
                                    if (self.ShowList()[i].sid == item.sid) {
                                        item.totalsalary = parseFloat(item.subtotal) + parseFloat(item.allowance) + parseFloat(item.heatingAllowance) + parseFloat(item.trafficsalary)  + parseFloat(item.userbonus) + parseFloat(item.timebaseadd) + parseFloat(item.taskbaseadd);
                                        self.ShowList.splice(i, 1);
                                        self.ShowList.splice(i, 0, item);
                                        break;
                                    }
                                }
                            }

                        }
                    });

                }
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
                            //将当前部门置为空，列表取消
                            self.nowDep("");
                            self.ShowList.removeAll();
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
                        self.nowDep(id);
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
    <p class="p-middle">这个页面是每个人的日报，更改数据后再次提交可以回到总表。</p>
    <p class="p-middle">工资状态 = ${salaryState}</p>
    <br>

    <div class="row-fluid c_box" style="">
        <div class="col-md-2 c_left_box" >
            <div style="margin-top:3%"></div>
            <div id="tree" style="overflow:auto;height:800px;"></div>
        </div>

        <div class="col-md-10 c_right_box" style="overflow:scroll" >
            <div class="caidan-tiku" style="margin-bottom:3%">
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>姓名：</span>
                    <input id="search_name" type="text" name="name" class="shuruk-a2" placeholder="">
                </div>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>当前月份：</span>
                    <%--<input id="search_salaryid" type="text" name="salaryid" class="shuruk-a2" placeholder="">--%>
                    <span id="nowamonth"  > 2017-02 </span>
                </div>
                <%--            <div class="caidan-tiku-s" style="margin-right:5%"> <span>日期：</span>
                                <input id="search_salarydate" type="text" name="salarydate" class="shuruk-a2" placeholder="">
                            </div>--%>

                <div class="caidan-tiku-s" style="margin-right:5%"> <span>当月满勤天数：</span>
                    <span id="nowaday"  data-bind="text:$root.dateCount"> </span>
                </div>
                <div class="caidan-tiku-s" style="margin-right:5%"> <span>当前部门：</span>
                    <span id="nowdepartment"  data-bind="text:$root.nowDep"> </span>
                </div>
                <div style="float:right;margin-right:15px;padding-bottom:10px;" >
                    <input data-bind="click:$root.ClickSearch" type="button" value="查询"  class="chaxun">
                    <%--<input  data-bind="click:$root.ClickClear" type="button" value="清空"  class="chaxun" style="background:#fd9162">--%>
                </div>

                <div style="float:right;margin-right:15px;padding-bottom:10px;" >
                    <input data-bind="click:$root.ClickAllSearch" type="button" value="一键提交"  class="chaxun">
                    <%--<input  data-bind="click:$root.ClickClear" type="button" value="清空"  class="chaxun" style="background:#fd9162">--%>
                </div>
            </div>

            <table  width="100%" border="1" cellspacing="0" cellpadding="0" class="table-1 daily">
                <thead class="table-1-tou">
                    <th style="width: 5%">日报编号</th>
                    <th style="width: 5%">工号</th>
                    <th style="width: 5%">姓名</th>
                    <th style="width: 5%">日期</th>
                    <th style="width: 5%">日期类型</th>
                    <th style="width: 8%">订单</th>
                    <th style="width: 5%">商务属性</th>
                    <th style="width: 5%">订单地市</th>
                    <th style="width: 5%">请假类型</th>
                    <th style="width: 5%">出勤状态</th>
                    <th style="width: 5%">出勤地市</th>
                    <th style="width: 5%">是否有效加班</th>
                    <th style="width: 5%">是否有效出差</th>
                    <th style="width: 10%">操作</th>
                </thead>

                <c:forEach var="entity" items="${journal}" varStatus="sequence">
                    <form action="${ctx}/userinfosalary/submitApprove.do">
                        <tr>
                            <td>${entity.seqNo}</td>
                            <td>${entity.staffid}</td>
                            <td>${entity.name}</td>
                            <td>${entity.date}</td>
                            <td>${entity.dateType}</td>
                            <td>${entity.orderName}</td>
                            <td>${entity.businessAttribute}</td>
                            <td>${entity.orderProcity}</td>
                            <td>${entity.askLeaveType}</td>
                            <td style="font-size: large">${entity.whetherEffAtt}</td>
                            <td>${entity.attProcity}</td>
                            <td>${entity.whetherEffOt}</td>
                            <td>${entity.whetherEffBt}</td>
                            <td>
                                <%--如果是PM，打开modal--%>
                                <c:if test="${operatorState eq '1'}">
                                    <button type="button" disabled="disabled" class="btn1" data-toggle="modal" data-target="#myModal">设为有效出勤</button>
                                </c:if>

                                <%--如果是DM，直接跳转--%>
                                <c:if test="${operatorState eq '2'}">
                                    <a href="${ctx}/userinfosalary/attEffective.do?seqNo=${entity.seqNo}&&staffid=${entity.staffid}&&salaryState=${salaryState}"><button type="button" class="btn1">设为有效出勤</button></a>
                                </c:if>

                                <a href="${ctx}/userinfosalary/attInvalid.do?seqNo=${entity.seqNo}&&staffid=${entity.staffid}&&salaryState=${salaryState}"><button type="button" class="btn2">设为无效出勤</button></a>
                                <button type="button" class="btn3" data-toggle="modal" data-target="#myModal">查看申请原因</button>
                            </td>
                        </tr>

                        <%--170318这个模态框虽然看起来很鱼，但出于效率的考虑，先用这个了--%>
                        <div class="container">
                            <!-- Modal -->
                            <%--这个加Id的方法绝对高端--%>
                            <div class="modal fade" id="myModal"+${sequence.index} tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="false">
                                <div class="modal-dialog c_side_modal_box"  role="document" style="margin: 0px;">
                                    <div class="modal-content c_side_modal">
                                        <div class="modal-header c_modal_head">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="myModalLabel">用户信息详情</h4>
                                        </div>
                                        <div class="modal-body c_modal_body">
                                            <div data-bind="with:changeItem">
                                                <div class="c_ding_form" >
                                                    <div class="c_ding_form_group" >
                                                        <label><i class="iconfont c_ding_from_icon" >*</i><span >申请原因:</span></label>
                                                        <div class="input_content">
                                                            <%--如果日报状态为1的话，显示一个只读的inpux框，内容为自己写的内容--%>
                                                            <c:if test="${entity.journalState eq '1'}">
                                                                <input type="text" readonly="readonly" value="${entity.comment}" style="width: 300px; height: 300px">
                                                            </c:if>
                                                            <%--如果日报状态不为1的话，显示的inpux框是可以输入的，可以提交--%>
                                                            <c:if test="${entity.journalState ne '1'}">
                                                                <input type="text" name="comment" style="width: 300px; height: 300px">
                                                            </c:if>
                                                            <%--170319，定义一个看不到的input，用来显示日报编号。虽然很鱼但这次可能是救命的--%>
                                                            <input type="hidden" name="seqNo" value="${entity.seqNo}">
                                                            <input type="hidden" name="staffid" value="${entity.staffid}">
                                                            <input type="hidden" name="salaryState" value="${salaryState}">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer c_modal_foot">
                                            <button id="close1" type="button" class="c_ding_btn" data-dismiss="modal">Close</button>
                                            <%--如果日报状态不为1的话，才有这个提交按钮--%>
                                            <c:if test="${entity.journalState ne '1'}">
                                                <button type="submit" class="c_ding_btn c_ding_btn_primary">提交</button>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </c:forEach>
            </table>
        </div>
    </div>

    <p class="p-middle">
        <a href="javascript:history.go(-1)"><button class="btn-submit">返回上一页</button></a>
    </p>

</body>
</html>

<script type="text/javascript">
    // 先用类选择器，把每一个元素的id加上。注意如果后面的出错了，也就加不上了
    $(".btn1").each(function (i) {
        $(this).attr("id", "btn1_" + i);
    });
    $(".btn2").each(function (i) {
        $(this).attr("id", "btn2_" + i);
    });
    $(".btn3").each(function (i) {
        $(this).attr("id", "btn3_" + i);
    });

    // 定义工资状态
    var salaryState = "${salaryState}";
    // 定义操作者状态
    var operatorState = "${operatorState}";

    <c:forEach var="entity" items="${journal}" varStatus="sequence">
        // 定义日报状态。注意一定要加引号，不然就雪崩了
        var journalState = "${entity.journalState}";
        // 定义是否有效出勤
        var whetherEffAtt = "${entity.whetherEffAtt}";
        // 定义序号
        var seq = "${sequence.index}";

        // 第1步，从日报状态判断该显示哪些按钮
        // 如果是待审批状态，那就只能看到查看按钮
        if (journalState == "1") {
            $("#btn1_"+seq).hide();
            $("#btn2_"+seq).hide();
            $("#btn3_"+seq).show();
        }
        // 其他的状态，有效只能改无效，无效只能改有效
        else {
            if (whetherEffAtt == "1") {
                $("#btn1_"+seq).hide();
                $("#btn2_"+seq).show();
                $("#btn3_"+seq).hide();
            }
            else if (whetherEffAtt == "0") {
                $("#btn1_"+seq).show();
                $("#btn2_"+seq).hide();
                $("#btn3_"+seq).hide();
            }
        }
    </c:forEach>

    // 第2步，由工资状态看权限，决定隐藏哪些按钮
    // 如果工资状态为2，那么日报只能查看，什么按钮都看不到
    if (salaryState == "2") {
        $(".btn1").hide();
        $(".btn2").hide();
        $(".btn3").hide();
    }
    // 如果工资状态为1，说明PM已经批过，PM看不到按钮
    else if (salaryState == "1") {
        if (operatorState == "1") {
            $(".btn1").hide();
            $(".btn2").hide();
            $(".btn3").hide();
        }
    }

</script>
