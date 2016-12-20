package com.dao;

import com.model.BusinessTrip;
import com.model.BusinessTripExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessTripMapper {
    int countByExample(BusinessTripExample example);

    int deleteByExample(BusinessTripExample example);

    int deleteByPrimaryKey(Integer btSequenceNo);

    int insert(BusinessTrip record);

    int insertSelective(BusinessTrip record);

    List<BusinessTrip> selectByExample(BusinessTripExample example);

    BusinessTrip selectByPrimaryKey(Integer btSequenceNo);

    int updateByExampleSelective(@Param("record") BusinessTrip record, @Param("example") BusinessTripExample example);

    int updateByExample(@Param("record") BusinessTrip record, @Param("example") BusinessTripExample example);

    int updateByPrimaryKeySelective(BusinessTrip record);

    int updateByPrimaryKey(BusinessTrip record);
     //出差信息列表展示
    public List<BusinessTrip> selectByPropertities(BusinessTrip businessTrip);
}