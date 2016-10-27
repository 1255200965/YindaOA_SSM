package com.service.impl;

import com.dao.StaffInfoMapper;
import com.model.StaffInfo;
import com.model.StaffInfoExample;
import com.service.IStaffInfoService;
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
public class StaffInfoServiceImpl implements IStaffInfoService{

    @Autowired
    public StaffInfoMapper staffInfoMapper;

    /*删除用户信息*/
    public int deleteStaffByID(String sequenceNum) {
        int result = staffInfoMapper.deleteByPrimaryKey(sequenceNum);
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
            StaffInfo staffInfo = new StaffInfo();

            if (hssfRow.getCell(0) != null) staffInfo.setStaffUserId((String.valueOf((int)(hssfRow.getCell(0).getNumericCellValue()))));
            if (hssfRow.getCell(1) != null) staffInfo.setDepartment((hssfRow.getCell(1).toString()));
            if (hssfRow.getCell(2) != null) staffInfo.setPosition((hssfRow.getCell(2).toString()));
            if (hssfRow.getCell(3) != null) staffInfo.setName((hssfRow.getCell(3).toString()));
            if (hssfRow.getCell(4) != null) staffInfo.setSex((hssfRow.getCell(4).toString()));
            if (hssfRow.getCell(5) != null) staffInfo.setStaffId((String.valueOf((int)(hssfRow.getCell(5).getNumericCellValue()))));
            if (hssfRow.getCell(6) != null) staffInfo.setWhetherLeader((hssfRow.getCell(6).toString()));
            if (hssfRow.getCell(7) != null) staffInfo.setCellphone((String.valueOf((int)(hssfRow.getCell(7).getNumericCellValue()))));
            if (hssfRow.getCell(8) != null) staffInfo.setEmail((hssfRow.getCell(8).toString()));
            if (hssfRow.getCell(9) != null) staffInfo.setBranchPhone((String.valueOf((int)(hssfRow.getCell(9).getNumericCellValue()))));
            if (hssfRow.getCell(10) != null) staffInfo.setWorkAddress((hssfRow.getCell(10).toString()));
            if (hssfRow.getCell(11) != null) staffInfo.setComment1((hssfRow.getCell(11).toString()));
            if (hssfRow.getCell(12) != null) staffInfo.setContractType((hssfRow.getCell(12).toString()));
            if (hssfRow.getCell(13) != null) staffInfo.setYindaIdentify((hssfRow.getCell(13).toString()));
            if (hssfRow.getCell(14) != null) staffInfo.setNetUnit((hssfRow.getCell(14).toString()));
            if (hssfRow.getCell(15) != null) staffInfo.setComment2((hssfRow.getCell(15).toString()));
            if (hssfRow.getCell(16) != null) staffInfo.setIdNo((String.valueOf((int)(hssfRow.getCell(16).getNumericCellValue()))));
            if (hssfRow.getCell(17) != null) staffInfo.setHouseholdAddress((hssfRow.getCell(17).toString()));
            if (hssfRow.getCell(18) != null) staffInfo.setBranchCompany((hssfRow.getCell(18).toString()));
            if (hssfRow.getCell(19) != null) staffInfo.setSocialSecurityAddress((hssfRow.getCell(19).toString()));
            if (hssfRow.getCell(20) != null) staffInfo.setOrdinaryAddress((hssfRow.getCell(20).toString()));
            if (hssfRow.getCell(21) != null) staffInfo.setRsoIdentify((hssfRow.getCell(21).toString()));
            if (hssfRow.getCell(22) != null) staffInfo.setBaseSalary((String.valueOf((int)(hssfRow.getCell(22).getNumericCellValue()))));
            if (hssfRow.getCell(23) != null) staffInfo.setItemSalary((String.valueOf((int)(hssfRow.getCell(23).getNumericCellValue()))));
            if (hssfRow.getCell(24) != null) staffInfo.setNation((hssfRow.getCell(24).toString()));
            if (hssfRow.getCell(25) != null) staffInfo.setAge((String.valueOf((int)(hssfRow.getCell(25).getNumericCellValue()))));
            if (hssfRow.getCell(26) != null) staffInfo.setLastContract((hssfRow.getCell(26).toString()));
            if (hssfRow.getCell(27) != null) staffInfo.setLastContractBegin((hssfRow.getCell(27).toString()));
            if (hssfRow.getCell(28) != null) staffInfo.setLastContractEnd((hssfRow.getCell(28).toString()));
            if (hssfRow.getCell(29) != null) staffInfo.setEnterTime((hssfRow.getCell(29).toString()));
            if (hssfRow.getCell(30) != null) staffInfo.setWorkYear((String.valueOf((int)(hssfRow.getCell(30).getNumericCellValue()))));
            if (hssfRow.getCell(31) != null) staffInfo.setSalaryCard((String.valueOf((int)(hssfRow.getCell(31).getNumericCellValue()))));
            if (hssfRow.getCell(32) != null) staffInfo.setGraduateSchool((hssfRow.getCell(32).toString()));
            if (hssfRow.getCell(33) != null) staffInfo.setSchoolRecord((hssfRow.getCell(33).toString()));
            if (hssfRow.getCell(34) != null) staffInfo.setGraduateDate((hssfRow.getCell(34).toString()));
            if (hssfRow.getCell(35) != null) staffInfo.setExpenseCard((String.valueOf((int)(hssfRow.getCell(35).getNumericCellValue()))));
            if (hssfRow.getCell(36) != null) staffInfo.setItem((hssfRow.getCell(36).toString()));
            if (hssfRow.getCell(37) != null) staffInfo.setYoOrder((hssfRow.getCell(37).toString()));
            if (hssfRow.getCell(38) != null) staffInfo.setStaffState((hssfRow.getCell(38).toString()));
            if (hssfRow.getCell(39) != null) staffInfo.setWorkState((hssfRow.getCell(39).toString()));
            if (hssfRow.getCell(40) != null) staffInfo.setWorkState((hssfRow.getCell(40).toString()));

            // 判断员工UserId，为空直接GG
            if (hssfRow.getCell(0) == null) {
                listFail.add(staffInfo);
                continue;
            }

            // 查找身份证号，如果相同就把该实体类返回到失败列表当中
            String idNo = String.valueOf((int)(hssfRow.getCell(16).getNumericCellValue()));
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
            StaffInfo staffInfo = new StaffInfo();

            if (hssfRow.getCell(0) != null) staffInfo.setStaffUserId((String.valueOf((int)(hssfRow.getCell(0).getNumericCellValue()))));
            if (hssfRow.getCell(1) != null) staffInfo.setDepartment((hssfRow.getCell(1).toString()));
            if (hssfRow.getCell(2) != null) staffInfo.setPosition((hssfRow.getCell(2).toString()));
            if (hssfRow.getCell(3) != null) staffInfo.setName((hssfRow.getCell(3).toString()));
            if (hssfRow.getCell(4) != null) staffInfo.setSex((hssfRow.getCell(4).toString()));
            if (hssfRow.getCell(5) != null) staffInfo.setStaffId((String.valueOf((int)(hssfRow.getCell(5).getNumericCellValue()))));
            if (hssfRow.getCell(6) != null) staffInfo.setWhetherLeader((hssfRow.getCell(6).toString()));
            if (hssfRow.getCell(7) != null) staffInfo.setCellphone((String.valueOf((int)(hssfRow.getCell(7).getNumericCellValue()))));
            if (hssfRow.getCell(8) != null) staffInfo.setEmail((hssfRow.getCell(8).toString()));
            if (hssfRow.getCell(9) != null) staffInfo.setBranchPhone((String.valueOf((int)(hssfRow.getCell(9).getNumericCellValue()))));
            if (hssfRow.getCell(10) != null) staffInfo.setWorkAddress((hssfRow.getCell(10).toString()));
            if (hssfRow.getCell(11) != null) staffInfo.setComment1((hssfRow.getCell(11).toString()));
            if (hssfRow.getCell(12) != null) staffInfo.setContractType((hssfRow.getCell(12).toString()));
            if (hssfRow.getCell(13) != null) staffInfo.setYindaIdentify((hssfRow.getCell(13).toString()));
            if (hssfRow.getCell(14) != null) staffInfo.setNetUnit((hssfRow.getCell(14).toString()));
            if (hssfRow.getCell(15) != null) staffInfo.setComment2((hssfRow.getCell(15).toString()));
            if (hssfRow.getCell(16) != null) staffInfo.setIdNo((String.valueOf((int)(hssfRow.getCell(16).getNumericCellValue()))));
            if (hssfRow.getCell(17) != null) staffInfo.setHouseholdAddress((hssfRow.getCell(17).toString()));
            if (hssfRow.getCell(18) != null) staffInfo.setBranchCompany((hssfRow.getCell(18).toString()));
            if (hssfRow.getCell(19) != null) staffInfo.setSocialSecurityAddress((hssfRow.getCell(19).toString()));
            if (hssfRow.getCell(20) != null) staffInfo.setOrdinaryAddress((hssfRow.getCell(20).toString()));
            if (hssfRow.getCell(21) != null) staffInfo.setRsoIdentify((hssfRow.getCell(21).toString()));
            if (hssfRow.getCell(22) != null) staffInfo.setBaseSalary((String.valueOf((int)(hssfRow.getCell(22).getNumericCellValue()))));
            if (hssfRow.getCell(23) != null) staffInfo.setItemSalary((String.valueOf((int)(hssfRow.getCell(23).getNumericCellValue()))));
            if (hssfRow.getCell(24) != null) staffInfo.setNation((hssfRow.getCell(24).toString()));
            if (hssfRow.getCell(25) != null) staffInfo.setAge((String.valueOf((int)(hssfRow.getCell(25).getNumericCellValue()))));
            if (hssfRow.getCell(26) != null) staffInfo.setLastContract((hssfRow.getCell(26).toString()));
            if (hssfRow.getCell(27) != null) staffInfo.setLastContractBegin((hssfRow.getCell(27).toString()));
            if (hssfRow.getCell(28) != null) staffInfo.setLastContractEnd((hssfRow.getCell(28).toString()));
            if (hssfRow.getCell(29) != null) staffInfo.setEnterTime((hssfRow.getCell(29).toString()));
            if (hssfRow.getCell(30) != null) staffInfo.setWorkYear((String.valueOf((int)(hssfRow.getCell(30).getNumericCellValue()))));
            if (hssfRow.getCell(31) != null) staffInfo.setSalaryCard((String.valueOf((int)(hssfRow.getCell(31).getNumericCellValue()))));
            if (hssfRow.getCell(32) != null) staffInfo.setGraduateSchool((hssfRow.getCell(32).toString()));
            if (hssfRow.getCell(33) != null) staffInfo.setSchoolRecord((hssfRow.getCell(33).toString()));
            if (hssfRow.getCell(34) != null) staffInfo.setGraduateDate((hssfRow.getCell(34).toString()));
            if (hssfRow.getCell(35) != null) staffInfo.setExpenseCard((String.valueOf((int)(hssfRow.getCell(35).getNumericCellValue()))));
            if (hssfRow.getCell(36) != null) staffInfo.setItem((hssfRow.getCell(36).toString()));
            if (hssfRow.getCell(37) != null) staffInfo.setYoOrder((hssfRow.getCell(37).toString()));
            if (hssfRow.getCell(38) != null) staffInfo.setStaffState((hssfRow.getCell(38).toString()));
            if (hssfRow.getCell(39) != null) staffInfo.setWorkState((hssfRow.getCell(39).toString()));
            if (hssfRow.getCell(40) != null) staffInfo.setWorkState((hssfRow.getCell(40).toString()));

            // 判断员工UserId，为空直接GG
            if (hssfRow.getCell(0) == null) {
                listFail.add(staffInfo);
                continue;
            }

            // 如果身份证号相同，那么更新条目
            String idNo = hssfRow.getCell(16).toString();
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
                    continue;
                } catch (Exception e) {
                    listFail.add(staffInfo);
                }
            }

            try {   // 尝试性地向数据库插入从excel行得到的实体类
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
}
