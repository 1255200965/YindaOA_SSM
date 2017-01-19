package com.dao;

import com.model.YoLoan;
import com.model.YoLoanExample;
import java.util.List;

public interface YoLoanMapper {
    int deleteByPrimaryKey(String approveNo);

    int insert(YoLoan record);

    int insertSelective(YoLoan record);

    List<YoLoan> selectByExample(YoLoanExample example);

    YoLoan selectByPrimaryKey(String approveNo);

    int updateByPrimaryKeySelective(YoLoan record);

    int updateByPrimaryKey(YoLoan record);
}