package com.service.impl;

import com.dao.IUserDao;
import com.dao.UserDtoMapper;
import com.dao.UserInfoMapper;
import com.model.User;
import com.model.UserDto;
import com.model.UserInfo;
import com.model.UserInfoExample;
import com.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by ma on 2016/10/15.
 */

@Transactional
@Service
public class UserInfoServiceImpl implements IUserInfoService{
    @Autowired
    public UserDtoMapper userMapper;
    @Autowired
    public UserInfoMapper userInfoMapper;

    /*删除用户信息*/
    public int deleteUserByID(Integer sequenceNum) {
        int result = userMapper.deleteByPrimaryKey(sequenceNum);
        return result;
    }
    /*添加用户信息*/
    public int insertUser(UserDto record) {
        int result = userMapper.insert(record);
        return result;
    }
    /*添加一组用户*/
    public int insertUserList(List<UserDto> record) {
        for (UserDto temp:record
             ) {
            int result = userMapper.insert(temp);
            if (result == 0){
                //插入报错
            }
        }

        return 0;
    }
    //查询用户信息分页
    public List<UserDto> selectUserByQuery(List UserDto, int index, int pages) {
        return null;
    }
    //查询用户信息
    public UserDto selectUserByID(Integer sequenceNum) {

        UserDto selectUser = userMapper.selectByPrimaryKey(sequenceNum);
        return selectUser;
    }

    //更新用户信息
    public int updateUserByID(UserDto record) {
        int result = userMapper.updateByPrimaryKey(record);
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
                .andUserIdEqualTo(userId)
                .andNameEqualTo(name)
                .andDepartmentLike(depart2);
        List<UserInfo> list = userInfoMapper.selectByExample(userInfoExample);
        return list;
    }
}
