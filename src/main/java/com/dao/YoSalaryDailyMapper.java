package com.dao;

import com.model.YoSalaryDaily;
import com.model.YoSalaryDailyExample;
import java.util.List;

public interface YoSalaryDailyMapper {
    int deleteByPrimaryKey(Integer seqNo);

    int insert(YoSalaryDaily record);

    int insertSelective(YoSalaryDaily record);

    List<YoSalaryDaily> selectByExample(YoSalaryDailyExample example);

    YoSalaryDaily selectByPrimaryKey(Integer seqNo);

    int updateByPrimaryKeySelective(YoSalaryDaily record);

    int updateByPrimaryKey(YoSalaryDaily record);
}