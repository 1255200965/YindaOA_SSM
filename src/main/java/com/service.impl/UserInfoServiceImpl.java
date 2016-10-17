package com.service.impl;

import com.dao.IUserDao;
import com.dao.UserDtoMapper;
import com.model.User;
import com.model.UserDto;
import com.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ma on 2016/10/15.
 */

@Transactional
@Service
public class UserInfoServiceImpl  implements IUserInfoService{
    @Autowired
    public UserDtoMapper userMapper;

    /*删除用户信息*/
    @Override
    public int deleteUserByID(Integer sequenceNum) {
        int result = userMapper.deleteByPrimaryKey(sequenceNum);
        return result;
    }
    /*添加用户信息*/
    @Override
    public int insertUser(UserDto record) {
        int result = userMapper.insert(record);
        return result;
    }
    /*添加一组用户*/
    @Override
    public int insertUserList(List<UserDto> record) {
        for (UserDto temp:record
             ) {
            int result = userMapper.insert(temp);
            if (result == 0){
                //
            }
        }

        return 0;
    }

    @Override
    public List<UserDto> selectUserByQuery(List UserDto, int index, int pages) {
        return null;
    }

    @Override
    public UserDto selectUserByID(Integer sequenceNum) {
        return null;
    }

    @Override
    public int updateUserByID(UserDto record) {
        return 0;
    }
}
