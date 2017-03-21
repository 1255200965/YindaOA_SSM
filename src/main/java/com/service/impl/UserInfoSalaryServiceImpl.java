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

//    //修改工资
//    @Override
//    public YoUserinfosalary selectByPrimaryKey(YoUserinfosalary sid) {
//        return userMapper.selectByPrimaryKey(sid);
//    }

    @Override
    public int updateByUserSalary(YoUserinfosalary record) {
        int result=userMapper.updateByPrimaryKey(record);
        return result;
    }


    public List<YoUserinfosalary> searchUserInfoByEntity(YoUserinfosalary yo) {
        String staffid = yo.getSalaryid();
        String name = yo.getName();
        String depart = "%"+yo.getDepartment() + "%";
        if (!depart.contains("-")){
            //如果不是子部门查询
            depart = yo.getDepartment();
        }
        String date = yo.getSalarydate();

        YoUserinfosalaryExample staffInfoExample = new YoUserinfosalaryExample();
        YoUserinfosalaryExample.Criteria criteria = staffInfoExample.createCriteria();
        if (staffid!=null) criteria.andSalaryidEqualTo(staffid);
        if (name!=null) criteria.andNameEqualTo(name);
        if (depart!=null) criteria.andDepartmentLike(depart);
        if (date!=null) criteria.andSalarydateEqualTo(date);

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
//=================================================================================
@Override
public List<YoSalaryDaily> selectDailyByExample(YoSalaryDaily user) {
   //查询日报列表
    YoSalaryDailyExample example = new YoSalaryDailyExample();
    YoSalaryDailyExample.Criteria criteria1 = example.createCriteria();
    //姓名模糊查询
    if (user.getName()!=null) criteria1.andNameLike("%"+user.getName()+"%");
    if (user.getStaffid()!=null) criteria1.andStaffidEqualTo(user.getStaffid());
    if (user.getStartDate()!= null && user.getStartDate()!= "") criteria1.andDateGreaterThanOrEqualTo( user.getStartDate() );
    if (user.getEndDate()!= null && user.getEndDate()!= "") criteria1.andDateLessThan(user.getEndDate() );

    if (user.getDepartment()!=null) criteria1.andDepartmentLike(user.getDepartment());
    example.setOrderByClause("department,name,date asc");

    return yoSalaryDailyMapper.selectByExample(example);
}
    @Override
    public int updateDailyByUserSalary(YoSalaryDaily record) {
        int result=yoSalaryDailyMapper.updateByPrimaryKey(record);
        return result;
    }


    //================================================================================

    /*
    170316，接收工号，返回2月份日报。日报有31条
     */
    public List<YoSalaryDaily> getJournal(String staffid) {
        // 得到2月份的例子，注意要选择日期区间
        YoSalaryDailyExample example = new YoSalaryDailyExample();
        example.or().andStaffidEqualTo(staffid).andDateGreaterThanOrEqualTo("2017-01-21");
        List<YoSalaryDaily> list = yoSalaryDailyMapper.selectByExample(example);
        return list;
    }

    /*
    170317，查询2月21日以来，日报状态为1的日报
     */
    public List<YoSalaryDaily> getJournalOnCheck() {
        // 得到2月份的例子，注意要选择日期区间
        YoSalaryDailyExample example = new YoSalaryDailyExample();
//        example.or().andJournalStateEqualTo("1").andDateGreaterThanOrEqualTo("2017-01-21");
        example.or().andJournalStateGreaterThanOrEqualTo("0").andDateGreaterThanOrEqualTo("2017-01-21");
        List<YoSalaryDaily> list = yoSalaryDailyMapper.selectByExample(example);
        return list;
    }

    // 提交改为有效考勤的审批，PM一级要用到
    public void submitApprove(YoSalaryDaily yoSalaryDaily) {
        // 不但要更新controller传过来的内容，日报状态也要更新
        yoSalaryDaily.setJournalState("1");
        yoSalaryDailyMapper.updateByPrimaryKeySelective(yoSalaryDaily);
        return;
    }

    /*
    170318，通过日报时，日报状态从1改为2
    不建议用updateByExample，建议用updateByPrimaryKeySelective
    return null中的null不用写。
     */
    public void approveJournal(int seqNo) {
        YoSalaryDaily yoSalaryDaily = new YoSalaryDaily();
        // 一定要设定主键编号，不然无法更新
        yoSalaryDaily.setSeqNo(seqNo);
        yoSalaryDaily.setJournalState("2");
        yoSalaryDailyMapper.updateByPrimaryKeySelective(yoSalaryDaily);
        return;
    }

    /*
    170318，拒绝日报时，日报状态从1改为0
     */
    public void rejectJournal(int seqNo) {
        YoSalaryDaily yoSalaryDaily = new YoSalaryDaily();
        // 一定要设定主键编号，不然无法更新
        yoSalaryDaily.setSeqNo(seqNo);
        yoSalaryDaily.setJournalState("0");
        yoSalaryDailyMapper.updateByPrimaryKeySelective(yoSalaryDaily);
        return;
    }

    /*
    无效改为有效
     */
    public void attEffective(int seqNo) {
        YoSalaryDaily yoSalaryDaily = new YoSalaryDaily();
        // 一定要设定主键编号，不然无法更新
        yoSalaryDaily.setSeqNo(seqNo);
        yoSalaryDaily.setWhetherEffAtt("1");
        yoSalaryDaily.setJournalState("2");
        yoSalaryDailyMapper.updateByPrimaryKeySelective(yoSalaryDaily);
        return;
    }

    /*
    有效改为无效
     */
    public void attInvalid(int seqNo) {
        YoSalaryDaily yoSalaryDaily = new YoSalaryDaily();
        // 一定要设定主键编号，不然无法更新
        yoSalaryDaily.setSeqNo(seqNo);
        yoSalaryDaily.setWhetherEffAtt("0");
        yoSalaryDaily.setJournalState("3");
        yoSalaryDailyMapper.updateByPrimaryKeySelective(yoSalaryDaily);
        return;
    }
}
