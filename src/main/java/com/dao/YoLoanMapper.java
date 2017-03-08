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
    //更新冲借款审批信息--审批结果,审批建议
    int updateApproveMessage(YoLoan record);
}