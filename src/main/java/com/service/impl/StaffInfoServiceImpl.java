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
 * 说明：
 * 1.excel中所有的数值列，如工号，年龄，身份证号，所有的日期，都必须输入为纯数字，一旦一个单元格冒泡，后面所有的item都无法更新。即还没完成对excel文件的校验
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

    @Override
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

    //更新用户信息
    public int updateStaffByID(StaffInfo record) {
        int result = staffInfoMapper.updateByPrimaryKey(record);
        return result;
    }

    /**
     * 通过params来查询员工信息
     * like是精髓，字符串中包含部门的都会被搜索出来
     */
    public List<StaffInfo> searchStaffInfoByEntity(StaffInfo staffInfo) {
        String staffId = staffInfo.getStaffId();
        String name = staffInfo.getName();
        String depart = staffInfo.getDepartment();
        String depart2 = "%"+depart+"%";

        StaffInfoExample staffInfoExample = new StaffInfoExample();
        StaffInfoExample.Criteria criteria = staffInfoExample.createCriteria();
        if (staffId!=null) criteria.andStaffIdEqualTo(staffId);
        if (name!=null) criteria.andNameEqualTo(name);
        if (depart2!=null) criteria.andDepartmentLike(depart2);
        staffInfoExample.or(criteria);

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
     * 循环地插入excel中的一行到数据库中
     * @param fileDir
     * @return
     * @throws IOException
     */
    public Map<String, Object> insert(String fileDir) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        List<StaffInfo> listFail = new ArrayList<StaffInfo>();
        int successAmount = 0;

        File file = new File(fileDir);
        InputStream is = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);

        for (int i=1; i<=hssfSheet.getLastRowNum(); i++) {
            // 得到当前行
            HSSFRow hssfRow = hssfSheet.getRow(i);

            /*第一步，先把这一行里所有的cell都设为string型*/
            for (int j=0; j<=40; j++) {
                if (hssfRow.getCell(j) != null) hssfRow.getCell(j).setCellType(1);
            }

            StaffInfo staffInfo = new StaffInfo();
            if (hssfRow.getCell(0) != null) staffInfo.setStaffUserId(hssfRow.getCell(0).toString());
            if (hssfRow.getCell(1) != null) staffInfo.setDepartment(hssfRow.getCell(1).toString());
            if (hssfRow.getCell(2) != null) staffInfo.setPosition(hssfRow.getCell(2).toString());
            if (hssfRow.getCell(3) != null) staffInfo.setName(hssfRow.getCell(3).toString());
            if (hssfRow.getCell(4) != null) staffInfo.setSex(hssfRow.getCell(4).toString());
            if (hssfRow.getCell(5) != null) staffInfo.setStaffId(hssfRow.getCell(5).toString());
            if (hssfRow.getCell(6) != null) staffInfo.setWhetherLeader(hssfRow.getCell(6).toString());
            if (hssfRow.getCell(7) != null) staffInfo.setCellphone(hssfRow.getCell(7).toString());
            if (hssfRow.getCell(8) != null) staffInfo.setEmail(hssfRow.getCell(8).toString());
            if (hssfRow.getCell(9) != null) staffInfo.setBranchPhone(hssfRow.getCell(9).toString());
            if (hssfRow.getCell(10) != null) staffInfo.setWorkAddress(hssfRow.getCell(10).toString());
            if (hssfRow.getCell(11) != null) staffInfo.setComment1(hssfRow.getCell(11).toString());
            if (hssfRow.getCell(12) != null) staffInfo.setContractType(hssfRow.getCell(12).toString());
            if (hssfRow.getCell(13) != null) staffInfo.setYindaIdentify(hssfRow.getCell(13).toString());
            if (hssfRow.getCell(14) != null) staffInfo.setComment2(hssfRow.getCell(14).toString());
            if (hssfRow.getCell(15) != null) staffInfo.setOrdinaryAddress(hssfRow.getCell(15).toString());
            if (hssfRow.getCell(16) != null) staffInfo.setSocialSecurityAddress(hssfRow.getCell(16).toString());
            if (hssfRow.getCell(17) != null) staffInfo.setBranchCompany(hssfRow.getCell(17).toString());
            if (hssfRow.getCell(18) != null) staffInfo.setHouseholdAddress(hssfRow.getCell(18).toString());
            if (hssfRow.getCell(19) != null) staffInfo.setIdNo(hssfRow.getCell(19).toString());
            if (hssfRow.getCell(20) != null) staffInfo.setNetUnit(hssfRow.getCell(20).toString());
            if (hssfRow.getCell(21) != null) staffInfo.setRsoIdentify(hssfRow.getCell(21).toString());
            if (hssfRow.getCell(22) != null) staffInfo.setBaseSalary(hssfRow.getCell(22).toString());
            if (hssfRow.getCell(23) != null) staffInfo.setItemSalary(hssfRow.getCell(23).toString());
            if (hssfRow.getCell(24) != null) staffInfo.setNation(hssfRow.getCell(24).toString());
            if (hssfRow.getCell(25) != null) staffInfo.setAge(hssfRow.getCell(25).toString());
            if (hssfRow.getCell(26) != null) staffInfo.setLastContract(hssfRow.getCell(26).toString());
            if (hssfRow.getCell(27) != null) staffInfo.setLastContractBegin(hssfRow.getCell(27).toString());
            if (hssfRow.getCell(28) != null) staffInfo.setLastContractEnd(hssfRow.getCell(28).toString());
            if (hssfRow.getCell(29) != null) staffInfo.setEnterTime(hssfRow.getCell(29).toString());
            if (hssfRow.getCell(30) != null) staffInfo.setWorkYear(hssfRow.getCell(30).toString());
            if (hssfRow.getCell(31) != null) staffInfo.setSalaryCard(hssfRow.getCell(31).toString());
            if (hssfRow.getCell(32) != null) staffInfo.setGraduateSchool(hssfRow.getCell(32).toString());
            if (hssfRow.getCell(33) != null) staffInfo.setSchoolRecord(hssfRow.getCell(33).toString());
            if (hssfRow.getCell(34) != null) staffInfo.setGraduateDate(hssfRow.getCell(34).toString());
            if (hssfRow.getCell(35) != null) staffInfo.setExpenseCard(hssfRow.getCell(35).toString());
            if (hssfRow.getCell(36) != null) staffInfo.setItem(hssfRow.getCell(36).toString());
            if (hssfRow.getCell(37) != null) staffInfo.setYoOrder(hssfRow.getCell(37).toString());
            if (hssfRow.getCell(38) != null) staffInfo.setStaffState(hssfRow.getCell(38).toString());
            if (hssfRow.getCell(39) != null) staffInfo.setWorkState(hssfRow.getCell(39).toString());
            if (hssfRow.getCell(40) != null) staffInfo.setLeaveDate(hssfRow.getCell(40).toString());

            // 判断员工UserId，为空则先插入钉钉，获得userID
            if (hssfRow.getCell(0) == null) {
                /*listFail.add(staffInfo);
                continue;*/
                DDUtil ddUtil = new DDUtil(this);
                String userid = ddUtil.createUser(staffInfo);
                staffInfo.setStaffUserId(userid);
            }

            // 查找身份证号，如果相同就把该实体类返回到失败列表当中
            String idNo = hssfRow.getCell(19).toString();
            StaffInfoExample staffInfoExample = new StaffInfoExample();
            staffInfoExample.createCriteria().andIdNoEqualTo(idNo);
            List<StaffInfo> listExist = staffInfoMapper.selectByExample(staffInfoExample);

            if (listExist.size() != 0) {   // 说明数据库中有相同的身份证号
                listFail.add(staffInfo);
                continue;
            }

            try {   // 尝试性地向数据库插入从excel行得到的实体类
                staffInfoMapper.insert(staffInfo);
            } catch (Exception e) {
                listFail.add(staffInfo);
                continue;
            }

            // 到了这里都没有出问题，说明成功！
            successAmount++;
        }
        // 循环结束后，把成功数目和失败列表返回到map
        map.put("successAmount", successAmount);
        map.put("listFail", listFail);
        return map;
    }

    /**
     * 从excel07导入数据，没有就插入，有就更新
     * @param fileDir
     * @return
     * @throws IOException
     */
    public Map<String, Object> insertAndUpdate(String fileDir) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        List<StaffInfo> listFail = new ArrayList<StaffInfo>();
        int successAmount = 0;

        File file = new File(fileDir);
        InputStream is = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);

        for (int i=1; i<=hssfSheet.getLastRowNum(); i++) {
            // 得到当前行
            HSSFRow hssfRow = hssfSheet.getRow(i);

            /*第一步，先把这一行里所有的cell都设为string型*/
            for (int j=0; j<=40; j++) {
                if (hssfRow.getCell(j) != null) hssfRow.getCell(j).setCellType(1);
            }

            StaffInfo staffInfo = new StaffInfo();
            if (hssfRow.getCell(0) != null) staffInfo.setStaffUserId(hssfRow.getCell(0).toString());
            if (hssfRow.getCell(1) != null) staffInfo.setDepartment(hssfRow.getCell(1).toString());
            if (hssfRow.getCell(2) != null) staffInfo.setPosition(hssfRow.getCell(2).toString());
            if (hssfRow.getCell(3) != null) staffInfo.setName(hssfRow.getCell(3).toString());
            if (hssfRow.getCell(4) != null) staffInfo.setSex(hssfRow.getCell(4).toString());
            if (hssfRow.getCell(5) != null) staffInfo.setStaffId(hssfRow.getCell(5).toString());
            if (hssfRow.getCell(6) != null) staffInfo.setWhetherLeader(hssfRow.getCell(6).toString());
            if (hssfRow.getCell(7) != null) staffInfo.setCellphone(hssfRow.getCell(7).toString());
            if (hssfRow.getCell(8) != null) staffInfo.setEmail(hssfRow.getCell(8).toString());
            if (hssfRow.getCell(9) != null) staffInfo.setBranchPhone(hssfRow.getCell(9).toString());
            if (hssfRow.getCell(10) != null) staffInfo.setWorkAddress(hssfRow.getCell(10).toString());
            if (hssfRow.getCell(11) != null) staffInfo.setComment1(hssfRow.getCell(11).toString());
            if (hssfRow.getCell(12) != null) staffInfo.setContractType(hssfRow.getCell(12).toString());
            if (hssfRow.getCell(13) != null) staffInfo.setYindaIdentify(hssfRow.getCell(13).toString());
            if (hssfRow.getCell(14) != null) staffInfo.setComment2(hssfRow.getCell(14).toString());
            if (hssfRow.getCell(15) != null) staffInfo.setOrdinaryAddress(hssfRow.getCell(15).toString());
            if (hssfRow.getCell(16) != null) staffInfo.setSocialSecurityAddress(hssfRow.getCell(16).toString());
            if (hssfRow.getCell(17) != null) staffInfo.setBranchCompany(hssfRow.getCell(17).toString());
            if (hssfRow.getCell(18) != null) staffInfo.setHouseholdAddress(hssfRow.getCell(18).toString());
            if (hssfRow.getCell(19) != null) staffInfo.setIdNo(hssfRow.getCell(19).toString());
            if (hssfRow.getCell(20) != null) staffInfo.setNetUnit(hssfRow.getCell(20).toString());
            if (hssfRow.getCell(21) != null) staffInfo.setRsoIdentify(hssfRow.getCell(21).toString());
            if (hssfRow.getCell(22) != null) staffInfo.setBaseSalary(hssfRow.getCell(22).toString());
            if (hssfRow.getCell(23) != null) staffInfo.setItemSalary(hssfRow.getCell(23).toString());
            if (hssfRow.getCell(24) != null) staffInfo.setNation(hssfRow.getCell(24).toString());
            if (hssfRow.getCell(25) != null) staffInfo.setAge(hssfRow.getCell(25).toString());
            if (hssfRow.getCell(26) != null) staffInfo.setLastContract(hssfRow.getCell(26).toString());
            if (hssfRow.getCell(27) != null) staffInfo.setLastContractBegin(hssfRow.getCell(27).toString());
            if (hssfRow.getCell(28) != null) staffInfo.setLastContractEnd(hssfRow.getCell(28).toString());
            if (hssfRow.getCell(29) != null) staffInfo.setEnterTime(hssfRow.getCell(29).toString());
            if (hssfRow.getCell(30) != null) staffInfo.setWorkYear(hssfRow.getCell(30).toString());
            if (hssfRow.getCell(31) != null) staffInfo.setSalaryCard(hssfRow.getCell(31).toString());
            if (hssfRow.getCell(32) != null) staffInfo.setGraduateSchool(hssfRow.getCell(32).toString());
            if (hssfRow.getCell(33) != null) staffInfo.setSchoolRecord(hssfRow.getCell(33).toString());
            if (hssfRow.getCell(34) != null) staffInfo.setGraduateDate(hssfRow.getCell(34).toString());
            if (hssfRow.getCell(35) != null) staffInfo.setExpenseCard(hssfRow.getCell(35).toString());
            if (hssfRow.getCell(36) != null) staffInfo.setItem(hssfRow.getCell(36).toString());
            if (hssfRow.getCell(37) != null) staffInfo.setYoOrder(hssfRow.getCell(37).toString());
            if (hssfRow.getCell(38) != null) staffInfo.setStaffState(hssfRow.getCell(38).toString());
            if (hssfRow.getCell(39) != null) staffInfo.setWorkState(hssfRow.getCell(39).toString());
            if (hssfRow.getCell(40) != null) staffInfo.setLeaveDate(hssfRow.getCell(40).toString());

            // 判断员工UserId，为空则先插入钉钉，获得userID
            if (hssfRow.getCell(0) == null) {
                //listFail.add(staffInfo);
                //continue;

            }

            // 如果身份证号相同，那么更新条目
            String idNo = hssfRow.getCell(19).toString();
            StaffInfoExample staffInfoExample = new StaffInfoExample();
            staffInfoExample.createCriteria().andIdNoEqualTo(idNo);
            List<StaffInfo> listExist = staffInfoMapper.selectByExample(staffInfoExample);

            if (listExist.size() != 0) {   // 说明数据库中有相同的身份证号
                String sequence = listExist.get(0).getStaffUserId();
                staffInfo.setStaffUserId(sequence);
                // 尝试更新条目
                try {
                    staffInfoMapper.updateByPrimaryKey(staffInfo);
                    // 更新成功，数目自加
                    successAmount++;
                    //更新钉钉

                    continue;
                } catch (Exception e) {
                    listFail.add(staffInfo);
                }
            }

            try {
                // 尝试性地向数据库插入从excel行得到的实体类
                staffInfoMapper.insert(staffInfo);
                // 添加成功，数目自加
                successAmount++;
            } catch (Exception e) {
                listFail.add(staffInfo);
                continue;
            }
        }
        // 循环结束后，把成功数目和失败列表返回到map
        map.put("successAmount", successAmount);
        map.put("listFail", listFail);
        return map;
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

}