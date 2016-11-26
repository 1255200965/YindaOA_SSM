package com.dao;

import com.model.YoAnnualVacation;
import com.model.YoAnnualVacationExample;
import java.util.List;

public interface YoAnnualVacationMapper {
    int deleteByPrimaryKey(Integer avSequenceNo);

    int insert(YoAnnualVacation record);

    int insertSelective(YoAnnualVacation record);

    List<YoAnnualVacation> selectByExample(YoAnnualVacationExample example);

    YoAnnualVacation selectByPrimaryKey(Integer avSequenceNo);

    int updateByPrimaryKeySelective(YoAnnualVacation record);

    int updateByPrimaryKey(YoAnnualVacation record);
}