package com.dao;

import com.model.StaffInfo;
import com.model.StaffInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffInfoMapper {
    int countByExample(StaffInfoExample example);

    int deleteByExample(StaffInfoExample example);

    int deleteByPrimaryKey(String staffUserId);

    int insert(StaffInfo record);

    int insertSelective(StaffInfo record);

    List<StaffInfo> selectByExample(StaffInfoExample example);

    List<StaffInfo> selectAllUser(StaffInfo staffInfo);

    List<StaffInfo> selectAllUser();


    StaffInfo selectByPrimaryKey(String staffUserId);

    int updateByExampleSelective(@Param("record") StaffInfo record, @Param("example") StaffInfoExample example);

    int updateByExample(@Param("record") StaffInfo record, @Param("example") StaffInfoExample example);

    int updateByPrimaryKeySelective(StaffInfo record);

    int updateByPrimaryKey(StaffInfo staffUserId);

    /**
     * 获取staffinfo表中 商务等级yinda_identify
     * @return
     */
    List<StaffInfo>  getIdentifyInStallInfo(String user_staffId);
     /**
      *  获取staffinfo表中 合同属性contract_type
      * @return
      */
    List<StaffInfo> getContract_typeInStallInfo(String user_staffId);
}