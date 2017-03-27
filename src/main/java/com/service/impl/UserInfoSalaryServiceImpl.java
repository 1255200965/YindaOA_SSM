package com.service.impl;

import com.dao.YoSalaryDailyMapper;
import com.dao.YoUserinfosalaryMapper;
import com.model.YoSalaryDaily;
import com.model.YoSalaryDailyExample;
import com.model.YoUserinfosalary;
import com.model.YoUserinfosalaryExample;
import com.service.IUserInfoSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by ma on 2016/11/14.
 */
@Transactional
@Service
public class UserInfoSalaryServiceImpl implements IUserInfoSalaryService {
    @Autowired
    public YoUserinfosalaryMapper userMapper;
    @Autowired
    public YoSalaryDailyMapper yoSalaryDailyMapper;

    @Override
    public List<YoUserinfosalary> selectSalary(YoUserinfosalaryExample record) {
        return userMapper.selectByExample(record);
    }

    @Override
    public List<YoUserinfosalary> selectByExample(YoUserinfosalaryExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public int insert(YoUserinfosalary record) {
        return userMapper.insert(record);
    }

    @Override
    public int updateByUserSalary(YoUserinfosalary record) {
        int result=userMapper.updateByPrimaryKey(record);
        return result;
    }

    /*
    170324估计这里的代码还是让作者亲自操作靠谱
     */
    public List<YoUserinfosalary> searchUserInfoByEntity(YoUserinfosalary user) {
        YoUserinfosalaryExample staffInfoExample = new YoUserinfosalaryExample();
        YoUserinfosalaryExample.Criteria criteria = staffInfoExample.createCriteria();
        if (user.getDepartment()!=null && user.getDepartment()!= ""){
            String[] temp = user.getDepartment().split(",");
            for (int i=0 ; i<temp.length; i++){
                YoUserinfosalaryExample.Criteria criteria0 = staffInfoExample.createCriteria();
                if (user.getName()!=null && user.getName()!="") criteria0.andNameLike("%"+user.getName()+"%");
                if (user.getSalaryid()!=null && user.getSalaryid()!= "") criteria0.andSalaryidLike("%"+user.getSalaryid()+"%");
                if (user.getSalarydate()!= null && user.getSalarydate()!= "") criteria0.andSalarydateEqualTo( user.getSalarydate() );
                criteria0.andDepartmentLike("%" + temp[i] );
                staffInfoExample.or(criteria0);
            }
        } else{
            if (user.getName()!=null && user.getName()!="") criteria.andNameLike("%"+user.getName()+"%");
            if (user.getSalaryid()!=null && user.getSalaryid()!= "") criteria.andSalaryidLike("%"+user.getSalaryid()+"%");
            if (user.getSalarydate()!= null && user.getSalarydate()!= "") criteria.andSalarydateEqualTo( user.getSalarydate() );
        }
        List<YoUserinfosalary> list = userMapper.selectByExample(staffInfoExample);
        return list;
    }

    @Override
    public List<YoUserinfosalary> search_salary(String company, String salarydate) {
        // TODO Auto-generated method stub
        YoUserinfosalaryExample staffInfoExample = new YoUserinfosalaryExample();
        YoUserinfosalaryExample.Criteria criteria = staffInfoExample.createCriteria();
        if (company!=null) criteria.andBranchCompanyEqualTo(company);
        if (salarydate!=null) criteria.andSalarydateEqualTo(salarydate);

        List<YoUserinfosalary> list = userMapper.selectByExample(staffInfoExample);
        return list;
        //return userMapper.search_salary(company, salarydate);
    }

    @Override
    public List<YoUserinfosalary> search_Jan_salary(String userid, String salarydate) {
        // TODO Auto-generated method stub
        return userMapper.search_Jan_salary(userid, salarydate);
    }

    @Override
    public List<YoSalaryDaily> selectDailyByExample(YoSalaryDaily user) {
       //查询日报列表
        YoSalaryDailyExample example = new YoSalaryDailyExample();
        YoSalaryDailyExample.Criteria criteria1 = example.createCriteria();
        //姓名模糊查询

        //改写查询部门的方法！
        // 因为example里用的是data，所以不用改example类
        if (user.getDepartment()!=null && user.getDepartment()!= ""){
            String[] temp = user.getDepartment().split(",");
            for (int i=0 ; i<temp.length; i++){
                YoSalaryDailyExample.Criteria criteria0 = example.createCriteria();
                if (user.getName()!=null && user.getName()!="") criteria0.andNameLike("%"+user.getName()+"%");
                if (user.getStaffid()!=null && user.getStaffid()!= "") criteria0.andStaffidLike("%"+user.getStaffid()+"%");
                if (user.getStartDate()!= null && user.getStartDate()!= "") criteria0.andDateGreaterThanOrEqualTo( user.getStartDate() );
                if (user.getEndDate()!= null && user.getEndDate()!= "") criteria0.andDateLessThanOrEqualTo(user.getEndDate() );
                criteria0.andDepartmentLike(temp[i] + "%");
                example.or(criteria0);
            }
        } else {
            if (user.getName()!=null && user.getName()!="") criteria1.andNameLike("%"+user.getName()+"%");
            if (user.getStaffid()!=null && user.getStaffid()!= "") criteria1.andStaffidLike("%"+user.getStaffid()+"%");
            if (user.getStartDate()!= null && user.getStartDate()!= "") criteria1.andDateGreaterThanOrEqualTo( user.getStartDate() );
            if (user.getEndDate()!= null && user.getEndDate()!= "") criteria1.andDateLessThanOrEqualTo(user.getEndDate() );
        }
        //if (user.getDepartment()!=null) criteria1.andDepartmentLike(user.getDepartment());

        example.setOrderByClause("department,name,date asc");

        return yoSalaryDailyMapper.selectByExample(example);
    }

    /*
    这个是更改考勤打卡状态的方法
     */
    @Override
    public int updateDailyByUserSalary(YoSalaryDaily record) {
        // 170324，如果不这样搞，会导致数据库改了，但页面不变，极其坑爹
        record.setWhetherEffAtt(null);
        record.setWhetherBt(null);
        record.setWhetherOt(null);
        record.setTimebase(null);
        int result=yoSalaryDailyMapper.updateByPrimaryKeySelective(record);

        // 170321我只能动在这之后的东西
        String journalStateNow = record.getJournalState();
        String staffid = record.getStaffid();
        // 如果日报状态改为1了，触发改task
        if ("1".equals(journalStateNow)) {
            YoUserinfosalaryExample example1 = new YoUserinfosalaryExample();
            example1.or().andSalaryidEqualTo(staffid).andSalarydateEqualTo("2017-03");
            List<YoUserinfosalary> list1 = userMapper.selectByExample(example1);
            // 这里不用try了，自信有日报的人必定有工资
            YoUserinfosalary yoUserinfosalary = list1.get(0);
            yoUserinfosalary.setTask("3");
            userMapper.updateByPrimaryKey(yoUserinfosalary);
        }
        else {
            // 否则，触发python
            int seqNo = record.getSeqNo();
            systemCall(seqNo);
        }
        return result;
    }

    @Override
    public YoSalaryDaily searchResult(int seqNo) {
        YoSalaryDaily yoSalaryDaily = yoSalaryDailyMapper.selectByPrimaryKey(seqNo);
        return yoSalaryDaily;
    }

    /*
    170316，接收工号，返回2月份日报。日报有31条
     */
    public List<YoSalaryDaily> getJournal(String staffid) {
        // 得到2月份的例子，注意要选择日期区间
        YoSalaryDailyExample example = new YoSalaryDailyExample();
        example.or().andStaffidEqualTo(staffid).andDateGreaterThanOrEqualTo("2017-02-21");
        List<YoSalaryDaily> list = yoSalaryDailyMapper.selectByExample(example);
        return list;
    }

    /*
    170317，查询2月21日以来，日报状态为1的日报
     */
    public List<YoSalaryDaily> getJournalOnCheck() {
        // 得到2月份的例子，注意要选择日期区间
        YoSalaryDailyExample example = new YoSalaryDailyExample();
        example.or().andJournalStateEqualTo("1").andDateGreaterThanOrEqualTo("2017-02-21");
//        example.or().andJournalStateGreaterThanOrEqualTo("0").andDateGreaterThanOrEqualTo("2017-01-21");
        List<YoSalaryDaily> list = yoSalaryDailyMapper.selectByExample(example);
        return list;
    }

    /*
    170318，点击打回后，日报状态1变成0
    如果该员工没有审批中的日报时，总表的工资状态3变成0，分表维持0
     */
    public void rejectJournal(int seqNo, String staffid) {
        // 第1步，改日报状态，1变成0
        YoSalaryDaily yoSalaryDaily = new YoSalaryDaily();
        // 一定要设定主键编号，不然无法更新
        yoSalaryDaily.setSeqNo(seqNo);
        yoSalaryDaily.setJournalState("0");
        yoSalaryDailyMapper.updateByPrimaryKeySelective(yoSalaryDaily);

        // 第2步，根据工号查找当月所有日报，如果没有日报状态为1的日报，总表的工资状态3变成0
        threeToOne(staffid);
        return;
    }

    /*
    170321，通过日报时，更改日报和工资信息
    日报状态从1改为2
    如果该员工没有审批中的日报时，总表的工资状态3变成0，分表维持0
     */
    public void approveJournal(int seqNo, String staffid) {
        // 第1步，调用系统命令，改掉这个人的出勤状态
        systemCall(seqNo);

        // 第2步，改日报状态，1变成2
        YoSalaryDaily yoSalaryDaily = new YoSalaryDaily();
        // 一定要设定主键编号，不然无法更新
        yoSalaryDaily.setSeqNo(seqNo);
        yoSalaryDaily.setJournalState("2");
        yoSalaryDailyMapper.updateByPrimaryKeySelective(yoSalaryDaily);

        // 第3步，根据工号查找当月所有日报，如果没有日报状态为1的日报，总表的工资状态3变成0
        threeToOne(staffid);
        return;
    }

    /*
    170321，调用系统命令，改日报和工资信息。为了避免出现黄色波浪线
     */
    private void systemCall(int seqNo) {
        String command = "python C:\\workspace\\python_oa\\salary\\change_effatt.py " + seqNo;
//        String command = "python root/python_projects/change_effatt.py " + seqNo;
        try {
            // 定义一个进程，执行系统命令。Windows会自动调用cmd，Linux会自动调用Shell，很智能！
            Process process = Runtime.getRuntime().exec(command);
            // 等待进程完成后，再进行下面的操作
            process.waitFor();
            if (process.exitValue() != 0) {
                // 说明任务完成失败了，打印一下
                System.out.println("本行命令执行失败，请查看命令本身原因。");
                System.out.println("当前命令为：" + command);
            }
            // 进程完成之后会产生一个输入流，先得到
            InputStream inputStream = process.getInputStream();
            // 输入流的输出结果，要用输入流阅读器去读
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            // 阅读器得到的输出内容还要用缓冲器读出来。你们说用Java能写出简单的业务逻辑吗？
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // 终于能够通过缓冲器来读行了
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("当前读到的python输出行为：" + line);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /*
    170321，为了避免出现黄色波浪线，这段要复用的代码拉出来
     */
    private void threeToOne(String staffid) {
        YoSalaryDailyExample example = new YoSalaryDailyExample();
        example.or().andStaffidEqualTo(staffid).andDateGreaterThanOrEqualTo("2017-02-21");
        List<YoSalaryDaily> list = yoSalaryDailyMapper.selectByExample(example);
        // 170321，这一波为了节省一个变量和一个判断语句，直接在不达标时return了。当然不建议这么干
        for (int i=0; i<list.size(); i++) {
            YoSalaryDaily yoSalaryDaily = list.get(i);
            // 如果日报状态为空，说明不尖审批状态，达标，判断下一个
            if (yoSalaryDaily.getJournalState() == null) continue;
            // 如果日报状态为1，直接GG，不达标
            if (yoSalaryDaily.getJournalState().equals("1")) return;
        }
        // 到这一步说明没有待审批的日报了，先得到工资实体类再update
        YoUserinfosalaryExample example1 = new YoUserinfosalaryExample();
        example1.or().andSalaryidEqualTo(staffid).andSalarydateEqualTo("2017-03");
        List<YoUserinfosalary> list1 = userMapper.selectByExample(example1);
        // 这里不用try了，自信有日报的人必定有工资
        YoUserinfosalary yoUserinfosalary = list1.get(0);
        yoUserinfosalary.setTask("0");
        userMapper.updateByPrimaryKey(yoUserinfosalary);
        return;
    }
}
