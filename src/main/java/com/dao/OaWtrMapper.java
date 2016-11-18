package com.dao;

import com.model.OaWtr;
import com.model.OaWtrExample;
import java.util.List;

public interface OaWtrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaWtr record);

    int insertSelective(OaWtr record);

    List<OaWtr> selectByExample(OaWtrExample example);

    OaWtr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaWtr record);

    int updateByPrimaryKey(OaWtr record);
}