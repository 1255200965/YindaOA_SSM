package com.dao;

import com.model.YoAdvance;
import com.model.YoAdvanceExample;
import java.util.List;

public interface YoAdvanceMapper {
    int deleteByPrimaryKey(String approveNo);

    int insert(YoAdvance record);

    int insertSelective(YoAdvance record);

    List<YoAdvance> selectByExample(YoAdvanceExample example);

    YoAdvance selectByPrimaryKey(String approveNo);

    int updateByPrimaryKeySelective(YoAdvance record);

    int updateByPrimaryKey(YoAdvance record);
}