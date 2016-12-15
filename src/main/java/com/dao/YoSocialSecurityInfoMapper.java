package com.dao;

import com.model.YoSocialSecurityInfo;
import com.model.YoSocialSecurityInfoExample;
import java.util.List;

public interface YoSocialSecurityInfoMapper {
    int deleteByPrimaryKey(Integer ssiSequenceNo);

    int insert(YoSocialSecurityInfo record);

    int insertSelective(YoSocialSecurityInfo record);

    List<YoSocialSecurityInfo> selectByExample(YoSocialSecurityInfoExample example);

    YoSocialSecurityInfo selectByPrimaryKey(Integer ssiSequenceNo);

    int updateByPrimaryKeySelective(YoSocialSecurityInfo record);

    int updateByPrimaryKey(YoSocialSecurityInfo record);
}