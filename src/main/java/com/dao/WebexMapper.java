package com.dao;

import com.model.Webex;
import com.model.WebexExample;
import java.util.List;

public interface WebexMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Webex record);

    int insertSelective(Webex record);

    List<Webex> selectByExample(WebexExample example);

    Webex selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Webex record);

    int updateByPrimaryKey(Webex record);
}