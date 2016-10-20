package com.dao;

import com.model.UserInfo;
import com.model.UserInfoExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;
@MapperScan
@Repository
public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer sequenceNum);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(Integer sequenceNum);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}