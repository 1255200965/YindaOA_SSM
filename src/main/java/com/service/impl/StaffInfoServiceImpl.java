package com.service.impl;

import com.dao.DepartmentMapper;
import com.dao.StaffInfoMapper;
import com.model.Department;
import com.model.DepartmentExample;
import com.model.StaffInfo;
import com.model.StaffInfoExample;
import com.service.IStaffInfoService;
import com.util.DDUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ma on 2016/10/15.
 */

@Transactional
@Service
public class StaffInfoServiceImpl implements IStaffInfoService {

    @Autowired
    public StaffInfoMapper staffInfoMapper;
    @Autowired
    public DepartmentMapper departmentMapper;

    /*删除用户信息*/
    public int deleteStaffByID(String sequenceNum) {
        int result = staffInfoMapper.deleteByPrimaryKey(sequenceNum);
        return result;
    }


    public int deleteStaffByID(StaffInfo sequenceNum) {
        int result = staffInfoMapper.deleteByPrimaryKey(sequenceNum.getStaffUserId());
        return result;
    }

    /*添加用户信息*/
    public int insertStaff(StaffInfo record) {
        int result = staffInfoMapper.insert(record);
        return result;
    }
    /*添加一组用户*/
    public int insertStaffList(List<StaffInfo> record) {
        for (StaffInfo temp:record
                ) {
            int result = staffInfoMapper.insert(temp);
            if (result == 0){
                //插入报错
            }
        }

        return 0;
    }
    //查询用户信息分页
    public List<StaffInfo> selectStaffByQuery(List StaffDto, int index, int pages) {
        return null;
    }
    //查询用户信息
    public StaffInfo selectStaffByID(String sequenceNum) {

        StaffInfo selectStaff = staffInfoMapper.selectByPrimaryKey(sequenceNum);
        return selectStaff;
    }

    @Override
    public List<StaffInfo> selectAllUser() {
        return staffInfoMapper.selectAllUser();
    }


    //更新用户信息
    public int updateStaffByID(StaffInfo record) {
        int result = staffInfoMapper.updateByPrimaryKey(record);
        return result;
    }
    public List<StaffInfo> searchStaffInfo(StaffInfoExample example) {
        List<StaffInfo> list = staffInfoMapper.selectByExample(example);
        return list;
    }



    /**
     * 通过params来查询员工信息
     * like是精髓，字符串中包含部门的都会被搜索出来
     */
    public List<StaffInfo> searchStaffInfoByEntity(StaffInfo staffInfo) {
        String staffId = staffInfo.getStaffId();
        String name = staffInfo.getName();
        String depart = staffInfo.getDepartment();

        StaffInfoExample staffInfoExample = new StaffInfoExample();
        StaffInfoExample.Criteria criteria = staffInfoExample.createCriteria();
        if (staffId!=null && staffId!="") criteria.andStaffIdEqualTo(staffId);
        if (name!=null && name!="") criteria.andNameEqualTo(name);
        if (depart!=null && depart !="") criteria.andDepartmentEqualTo(depart);

        List<StaffInfo> list = staffInfoMapper.selectByExample(staffInfoExample);
        return list;
    }

    //根据名称，工号，电话好吗查询所有
    public List<StaffInfo> selectStaffInfo(StaffInfo staffInfo) {
//        String name = staffInfo.getName();
//        String cellphone = staffInfo.getCellphone();
//        String idNo = staffInfo.getIdNo();
        return staffInfoMapper.selectAllUser(staffInfo);
    }

    /**
     * 根据根部门的名称，查根部门的id
     */
    public String parentName2id(String name) {
        String id;
        DepartmentExample example = new DepartmentExample();
        example.createCriteria().andDepNameEqualTo(name).andDepParentidEqualTo("1");
        List<Department> list = departmentMapper.selectByExample(example);
        Department department = list.get(0);
        id = department.getDepDdId();
        return id;
    }

    /**
     * 通过子部门的名称，和刚刚得到的父部门id，查子部门id
     */
    public String myName2id(String myName, String parentId) {
        String id;
        DepartmentExample example = new DepartmentExample();
        example.createCriteria().andDepNameEqualTo(myName).andDepParentidEqualTo(parentId);
        List<Department> list = departmentMapper.selectByExample(example);
        Department department = list.get(0);
        id = department.getDepDdId();
        return id;
    }

    /**
     * 通过部门id，查到实体类
     */
    public Department id2name(String id) {
        DepartmentExample example = new DepartmentExample();
        example.createCriteria().andDepDdIdEqualTo(id);
        List<Department> list = departmentMapper.selectByExample(example);
        Department department = list.get(0);
        return department;
    }


	@Override
	public List<StaffInfo> getIdentifyInStallInfo(String user_staffId) {
		// TODO Auto-generated method stub
		
		return staffInfoMapper.getIdentifyInStallInfo(user_staffId);
	}


	@Override
	public List<StaffInfo> getContract_typeInStallInfo(String user_staffId) {
		// TODO Auto-generated method stub
		return staffInfoMapper.getContract_typeInStallInfo(user_staffId);
	}

	@Override
	public List<StaffInfo> selectAllUserName(){
		return staffInfoMapper.selectAllUser();
	}
	@Override
	public List<StaffInfo> selectStaffInWork(){
		StaffInfoExample example = new StaffInfoExample();
		StaffInfoExample.Criteria criteria = example.createCriteria();
		criteria.andWorkStateEqualTo("在职");
		criteria.andContractTypeNotEqualTo("S");
		return staffInfoMapper.selectByExample(example);
	}
	@Override
	public List<StaffInfo> selectByStaffId(String staffId){
		
		StaffInfoExample example = new StaffInfoExample();
		StaffInfoExample.Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		return staffInfoMapper.selectByExample(example);
	}
	@Override
	
	//查询所有的部门领导
	public List<String> selectLeaders(){
		StaffInfoExample example = new StaffInfoExample();
		StaffInfoExample.Criteria criteria = example.createCriteria();
		criteria.andWhetherLeaderLike("是");
		List<StaffInfo> staffInfoList = staffInfoMapper.selectByExample(example);
		List<String> leaders = new ArrayList<String>();
		for(StaffInfo  staffInfo : staffInfoList){
			leaders.add(staffInfo.getStaffUserId());
		}
		return leaders;
	}
}