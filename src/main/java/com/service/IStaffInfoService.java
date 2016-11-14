package com.service;

import com.model.Department;
import com.model.StaffInfo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by ma on 2016/10/15.
 */
public interface IStaffInfoService {
    //删除一个用户
    int deleteStaffByID(StaffInfo staffUserId);
    //新增一个用户
    int insertStaff(StaffInfo record);
    //批量添加用户
    int insertStaffList(List<StaffInfo> record);
    //查询用户
    List<StaffInfo> selectStaffByQuery(List StaffInfo, int index, int pages);
    //查询单个用户 List<StaffInfo>
    StaffInfo selectStaffByID(String staffUserId);

    //查询所有用户id
    //StaffInfo selectAll();
    List<StaffInfo> selectAllUser();

    //更新用户
    int updateStaffByID(StaffInfo staffUserId);
    /*通过工号来查询员工信息*/
    List<StaffInfo> searchStaffInfoByEntity(StaffInfo staffInfo);

    //查询所有用户信息
    List<StaffInfo> selectStaffInfo(StaffInfo staffInfo);

    /*根据根部门的名称，查根部门的id*/
    String parentName2id(String name);

    /*通过子部门的名称，和刚刚得到的父部门id，查子部门id*/
    String myName2id(String myName, String parentId);

    /*通过部门id，查到实体类*/
    Department id2name(String id);

}
