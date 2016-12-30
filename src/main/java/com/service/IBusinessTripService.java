package com.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.model.BusinessTrip;

public interface IBusinessTripService {
	public List<BusinessTrip> selectByPropertities(BusinessTrip businessTrip);
	//根据工号查询出差信息
	public List<BusinessTrip> selectByStaffId(String staffId);
	//根据出差申请单号查询出差相关信息
	public BusinessTrip selectById(int id);
	//Excel上传导入
	public List<String[]> readExcel(FileInputStream fis) throws IOException;
}
