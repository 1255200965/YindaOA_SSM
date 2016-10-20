package com.service.impl;


import com.dao.UserInfoMapper;
import com.model.UserInfo;
import com.model.UserInfoExample;
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
public class UserInfoServiceImpl implements IUserInfoService{

    @Autowired
    public UserInfoMapper userInfoMapper;

    /*删除用户信息*/
    public int deleteUserByID(Integer sequenceNum) {
        int result = userInfoMapper.deleteByPrimaryKey(sequenceNum);
        return result;
    }
    /*添加用户信息*/
    public int insertUser(UserInfo record) {
        int result = userInfoMapper.insert(record);
        return result;
    }
    /*添加一组用户*/
    public int insertUserList(List<UserInfo> record) {
        for (UserInfo temp:record
             ) {
            int result = userInfoMapper.insert(temp);
            if (result == 0){
                //插入报错
            }
        }

        return 0;
    }
    //查询用户信息分页
    public List<UserInfo> selectUserByQuery(List UserDto, int index, int pages) {
        return null;
    }
    //查询用户信息
    public UserInfo selectUserByID(Integer sequenceNum) {

        UserInfo selectUser = userInfoMapper.selectByPrimaryKey(sequenceNum);
        return selectUser;
    }

    //更新用户信息
    public int updateUserByID(UserInfo record) {
        int result = userInfoMapper.updateByPrimaryKey(record);
        return result;
    }

    /**
     * 通过params来查询员工信息
     * like是精髓，字符串中包含部门的都会被搜索出来
     */
    public List<UserInfo> searchUserInfoByEntity(UserInfo userInfo) {
        String userId = userInfo.getUserId();
        String name = userInfo.getName();
        String depart = userInfo.getDepartment();
        String depart2 = "%"+depart+"%";

        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria()
                .andDepartmentLike(depart2);
        List<UserInfo> list = userInfoMapper.selectByExample(userInfoExample);
        return list;
    }
}
