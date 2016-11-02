package com.dao;

import com.model.YoLeave;
import com.model.YoLeaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YoLeaveMapper {
    int countByExample(YoLeaveExample example);

    int deleteByExample(YoLeaveExample example);

    int deleteByPrimaryKey(Integer leaveId);

    int insert(YoLeave record);

    int insertSelective(YoLeave record);

    List<YoLeave> selectByExample(YoLeaveExample example);

    YoLeave selectByPrimaryKey(Integer leaveId);

    int updateByExampleSelective(@Param("record") YoLeave record, @Param("example") YoLeaveExample example);

    int updateByExample(@Param("record") YoLeave record, @Param("example") YoLeaveExample example);

    int updateByPrimaryKeySelective(YoLeave record);

    int updateByPrimaryKey(YoLeave record);
}