package com.dao;

import com.model.UserDto;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

@MapperScan
@Repository
public interface UserDtoMapper {
    int deleteByPrimaryKey(Integer sequenceNum);

    int insert(UserDto record);

    int insertSelective(UserDto record);

    UserDto selectByPrimaryKey(Integer sequenceNum);

    int updateByPrimaryKeySelective(UserDto record);

    int updateByPrimaryKey(UserDto record);
}