<%--
  Created by IntelliJ IDEA.
  User: pwj
  Date: 2016/11/11
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上海音达科技</title>
    <script type="text/javascript">
        $.ajax({
            data:JSON.stringify(new UserModel($("#search_name").val(),$("#search_date").val())),
            type:"post",
            headers: { 'Content-Type': 'application/json' },
            dataType: 'json',
            url:"../usersalary/QueryType.do",
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

    </script>

</head>
<body>
<div class="ser-resault" >
    <table border="1">
        <thead>
        <tr >
            <th>姓名</th>
            <%--<th>用户id</th>--%>
            <%--<th>工资序列id</th>--%>
            <th>日期</th>
            <th>日期类型</th>
            <th>打卡情况</th>
            <%--<th>缺勤工资</th>--%>
            <th>请假类型</th>
            <%--<th>请假工资</th>--%>
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
            <%--<td data-bind="text:salaryid">工资id</td>--%>
            <%--<td data-bind="text:date" > 日期</td>--%>
            <td data-bind="text:date"></td>

            <td data-bind="text:datetype">日期类型</td>
            <td data-bind="text:effectiveAttendance">知识树编号</td>
            <%-- <td data-bind="text:attendanceSalary">所属知识</td>--%>
            <td data-bind="text:leavetype">修改者</td>
            <%--<td data-bind="text:leavesalary">审核状态</td>--%>
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
        </tbody>
        <thead>
        <tr >
            <th >合计</th>
            <td data-bind="text:name"></td>
            <td data-bind="text:date"></td>
            <td data-bind="text:datetype"></td>
            <td data-bind="text:effectiveAttendance"></td>
            <td data-bind="text:leavetype"></td>
            <td data-bind="text:workovertime"></td>
            <td data-bind="text:worksalary"></td>
            <td data-bind="text:evection"></td>
            <td data-bind="text:allowance"></td>
            <td data-bind="text:timesalary"></td>
            <td data-bind="text:task"></td>
            <td data-bind="text:tasksalary"></td>
            <td data-bind="text:busalary"></td>
            <td data-bind="text:trafficsalary"></td>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>
