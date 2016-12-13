package com.dao;

import com.model.YoSignIn;
import com.model.YoSignInExample;
import java.util.List;

public interface YoSignInMapper {
    int deleteByPrimaryKey(Integer siSequenceNo);

    int insert(YoSignIn record);

    int insertSelective(YoSignIn record);

    List<YoSignIn> selectByExample(YoSignInExample example);

    YoSignIn selectByPrimaryKey(Integer siSequenceNo);

    int updateByPrimaryKeySelective(YoSignIn record);

    int updateByPrimaryKey(YoSignIn record);
}