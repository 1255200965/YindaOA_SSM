package com.service;

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
    //查询单个用户
    StaffInfo selectStaffByID(String staffUserId);

    //更新用户
    int updateStaffByID(StaffInfo staffUserId);
    /*通过工号来查询员工信息*/
    List<StaffInfo> searchStaffInfoByEntity(StaffInfo staffInfo);

    //查询所有用户信息
    List<StaffInfo> selectStaffInfo(StaffInfo staffInfo);

    /*插入从excel行得到的实体类*/
    Map<String, Object> insert(String fileDir) throws IOException;

    /*插入并更新从excel行得到的实体类*/
    Map<String, Object> insertAndUpdate(String fileDir) throws IOException;

    /*根据根部门的名称，查根部门的id*/
    String parentName2id(String name);

    /*通过子部门的名称，和刚刚得到的父部门id，查子部门id*/
    String myName2id(String myName, String parentId);

    /*通过根部门的id，查根部门的名称*/
    String parentId2name(String parentId);

    /*通过子部门的id和根部门的id，查子部门的名称*/
    String myId2name(String myId, String parentId);
}
