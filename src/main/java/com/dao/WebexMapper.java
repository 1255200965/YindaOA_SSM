package com.dao;


import com.model.Webex;
import com.model.WebexExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface WebexMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Webex record);

    int insertSelective(Webex record);

    List<Webex> selectByExample(WebexExample example);

    Webex selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Webex record);

    
    int updateByPrimaryKey(Webex record);
    
    
    @Select(value = { "SELECT meeting_name from (select *, webex.meeting_time as sart ,date_add(webex.meeting_time, interval webex.meeting_length minute) as e from webex )as t  where sart >= '${meeting_time}' and '${meeting_time}' <= t.e" })
    @ResultType(value=String.class)
    //@Select(value = { "SELECT * from (select * from webex )as w, (select webex.meeting_time as sart ,date_add(webex.meeting_time, interval webex.meeting_length minute) as e from webex )as t where  t.sart <= '${meeting_time}'  and t.e >=  '${meeting_time}' " })
    List<String> select_by_time (@Param("meeting_time")String meeting_time);
}