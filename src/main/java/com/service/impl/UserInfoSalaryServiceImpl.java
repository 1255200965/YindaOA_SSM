package com.service.impl;

import com.dao.YoUserinfosalaryMapper;
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
}
