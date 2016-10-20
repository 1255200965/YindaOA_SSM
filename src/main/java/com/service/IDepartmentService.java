package com.service;

import com.model.Department;
import com.model.DepartmentExample;

import java.util.List;

/**
 * Created by ma on 2016/10/19.
 */
public interface IDepartmentService {
    int deleteByPrimaryKey(Integer depId);

    int insert(Department record);

    int insertSelective(Department record);
    //查询部门列表
    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(Integer depId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}
