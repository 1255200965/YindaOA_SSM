package com.service;

import com.model.UserDto;
import com.model.UserInfo;

import java.util.List;

/**
 * Created by ma on 2016/10/15.
 */
public interface IUserInfoService {
    //删除一个用户
    int deleteUserByID(Integer sequenceNum);
    //新增一个用户
    int insertUser(UserDto record);
    //批量添加用户
    int insertUserList(List<UserDto> record);
    //查询用户
    List<UserDto> selectUserByQuery(List UserDto,int index,int pages);
    //查询单个用户
    UserDto selectUserByID(Integer sequenceNum);
    //更新用户
    int updateUserByID(UserDto record);
    /*通过工号来查询员工信息*/
    List<UserInfo> searchUserInfoByUserId(String userId);

}
