package com.dao;

import com.model.BusinessTrip;
import com.model.BusinessTripExample;
import java.util.List;

public interface BusinessTripMapper {
    int deleteByPrimaryKey(Integer btSequenceNo);

    int insert(BusinessTrip record);

    int insertSelective(BusinessTrip record);

    List<BusinessTrip> selectByExample(BusinessTripExample example);

    BusinessTrip selectByPrimaryKey(Integer btSequenceNo);

    int updateByPrimaryKeySelective(BusinessTrip record);

    int updateByPrimaryKey(BusinessTrip record);
}