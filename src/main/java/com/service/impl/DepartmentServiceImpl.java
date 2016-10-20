package com.service.impl;

import com.dao.DepartmentMapper;
import com.model.Department;
import com.model.DepartmentExample;
import com.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ma on 2016/10/19.
 */
@Transactional
@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    public DepartmentMapper departmentMapper;

    @Override
    public int deleteByPrimaryKey(Integer depId) {
        return 0;
    }

    @Override
    public int insert(Department record) {
        return 0;
    }

    @Override
    public int insertSelective(Department record) {
        return 0;
    }

    @Override
    public List<Department> selectByExample(DepartmentExample example) {
        List<Department> selectDep = departmentMapper.selectByExample(example);
        return selectDep;
    }

    @Override
    public Department selectByPrimaryKey(Integer depId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return 0;
    }
}
