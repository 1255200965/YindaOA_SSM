package com.dao;

import com.model.AskForLeave;
import com.model.AskForLeaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AskForLeaveMapper {
    int countByExample(AskForLeaveExample example);

    int deleteByExample(AskForLeaveExample example);

    int deleteByPrimaryKey(Integer sequenceNo);

    int insert(AskForLeave record);

    int insertSelective(AskForLeave record);

    List<AskForLeave> selectByExample(AskForLeaveExample example);

    /*彭文杰改，方法不带参数*/
    List<AskForLeave> selectByExample();

    AskForLeave selectByPrimaryKey(Integer sequenceNo);

    int updateByExampleSelective(@Param("record") AskForLeave record, @Param("example") AskForLeaveExample example);

    int updateByExample(@Param("record") AskForLeave record, @Param("example") AskForLeaveExample example);

    int updateByPrimaryKeySelective(AskForLeave record);

    int updateByPrimaryKey(AskForLeave record);
}