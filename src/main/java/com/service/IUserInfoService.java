package com.service;

import com.model.UserInfo;
import com.model.UserInfoExample;

import java.util.List;

/**
 * Created by ma on 2016/10/15.
 */
public interface IUserInfoService {
    //删除一个用户
    int deleteUserByID(Integer sequenceNum);
    //新增一个用户
    int insertUser(UserInfo record);
    //批量添加用户
    int insertUserList(List<UserInfo> record);
    //查询用户
    List<UserInfo> selectUserByQuery(List UserInfo,int index,int pages);
    //查询单个用户
    UserInfo selectUserByID(Integer sequenceNum);

    //更新用户
    int updateUserByID(UserInfo record);
    /*通过工号来查询员工信息*/
    List<UserInfo> searchUserInfoByEntity(UserInfo userInfo);

}
