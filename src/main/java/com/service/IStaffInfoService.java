package com.service;

import com.model.StaffInfo;

import java.util.List;

/**
 * Created by ma on 2016/10/15.
 */
public interface IStaffInfoService {
    //删除一个用户
    int deleteStaffByID(Integer sequenceNum);
    //新增一个用户
    int insertStaff(StaffInfo record);
    //批量添加用户
    int insertStaffList(List<StaffInfo> record);
    //查询用户
    List<StaffInfo> selectStaffByQuery(List StaffInfo,int index,int pages);
    //查询单个用户
    StaffInfo selectStaffByID(Integer sequenceNum);

    //更新用户
    int updateStaffByID(StaffInfo record);
    /*通过工号来查询员工信息*/
    List<StaffInfo> searchStaffInfoByEntity(StaffInfo staffInfo);

}
