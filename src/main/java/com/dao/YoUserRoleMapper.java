package com.dao;

import com.model.YoUserRole;
import com.model.YoUserRoleExample;
import java.util.List;

public interface YoUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YoUserRole record);

    int insertSelective(YoUserRole record);

    List<YoUserRole> selectByExample(YoUserRoleExample example);

    YoUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YoUserRole record);

    int updateByPrimaryKey(YoUserRole record);
}