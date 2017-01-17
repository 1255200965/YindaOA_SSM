package com.dao;

import com.model.YoRoleModule;
import com.model.YoRoleModuleExample;
import java.util.List;

public interface YoRoleModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YoRoleModule record);

    int insertSelective(YoRoleModule record);

    List<YoRoleModule> selectByExample(YoRoleModuleExample example);

    YoRoleModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YoRoleModule record);

    int updateByPrimaryKey(YoRoleModule record);
}