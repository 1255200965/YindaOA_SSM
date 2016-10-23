package com.service.impl;


import com.dao.StaffInfoMapper;
import com.model.StaffInfo;
import com.model.StaffInfoExample;
import com.service.IStaffInfoService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
public class StaffInfoServiceImpl implements IStaffInfoService{

    @Autowired
    public StaffInfoMapper staffInfoMapper;

    /*删除用户信息*/
    public int deleteStaffByID(Integer sequenceNum) {
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
    public StaffInfo selectStaffByID(Integer sequenceNum) {

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
        String staffId = staffInfo.getStffId();
        String name = staffInfo.getName();
        String depart = staffInfo.getDepartment();
        String depart2 = "%"+depart+"%";

        StaffInfoExample staffInfoExample = new StaffInfoExample();
        StaffInfoExample.Criteria criteria = staffInfoExample.createCriteria();
        if (staffId!=null) criteria.andStffIdEqualTo(staffId);
        if (name!=null) criteria.andNameEqualTo(name);
        if (depart2!=null) criteria.andDepartmentLike(depart2);
        staffInfoExample.or(criteria);

        List<StaffInfo> list = staffInfoMapper.selectByExample(staffInfoExample);
        return list;
    }

    /**
     * 插入从excel行得到的实体类
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
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

        for (int i=0; i<xssfSheet.getLastRowNum(); i++) {
            // 得到当前行
            XSSFRow xssfRow = xssfSheet.getRow(i);
            StaffInfo staffInfo = new StaffInfo();
            // 一定要先判空再赋值，不然会报空指针异常
            if (xssfRow.getCell(0) != null) staffInfo.setStffId(xssfRow.getCell(0).toString());
            if (xssfRow.getCell(1) != null) staffInfo.setName(xssfRow.getCell(1).getStringCellValue());
            if (xssfRow.getCell(2) != null) staffInfo.setAge((int)(xssfRow.getCell(2).getNumericCellValue()));
            if (xssfRow.getCell(3) != null) staffInfo.setSex(xssfRow.getCell(3).getStringCellValue());
            if (xssfRow.getCell(4) != null) staffInfo.setCellphone(xssfRow.getCell(4).getStringCellValue());
            if (xssfRow.getCell(5) != null) staffInfo.setEmail(xssfRow.getCell(5).getStringCellValue());
            if (xssfRow.getCell(6) != null) staffInfo.setIdCrd(xssfRow.getCell(6).toString());
            if (xssfRow.getCell(7) != null) staffInfo.setHshldAddrss(xssfRow.getCell(7).toString());
            if (xssfRow.getCell(8) != null) staffInfo.setNation(xssfRow.getCell(8).toString());
            if (xssfRow.getCell(9) != null) staffInfo.setLvAddrss(xssfRow.getCell(9).toString());
            if (xssfRow.getCell(10) != null) staffInfo.setBrnchCmpny(xssfRow.getCell(10).toString());
            if (xssfRow.getCell(11) != null) staffInfo.setDepartment(xssfRow.getCell(11).toString());
            if (xssfRow.getCell(12) != null) staffInfo.setSgnAddrss(xssfRow.getCell(12).toString());
            if (xssfRow.getCell(13) != null) staffInfo.setSgnDt(xssfRow.getCell(13).toString());
            if (xssfRow.getCell(14) != null) staffInfo.setCntrctType(xssfRow.getCell(14).toString());
            if (xssfRow.getCell(15) != null) staffInfo.setCntrctBgn(xssfRow.getCell(15).toString());
            if (xssfRow.getCell(16) != null) staffInfo.setCntrctEnd(xssfRow.getCell(16).toString());
            if (xssfRow.getCell(17) != null) staffInfo.setSlryCrd(xssfRow.getCell(17).toString());
            if (xssfRow.getCell(18) != null) staffInfo.setExpnsCrd(xssfRow.getCell(18).toString());
            if (xssfRow.getCell(19) != null) staffInfo.setStffState(xssfRow.getCell(19).toString());
            if (xssfRow.getCell(20) != null) staffInfo.setGrdtSchl(xssfRow.getCell(20).toString());
            if (xssfRow.getCell(21) != null) staffInfo.setSchlRcrd(xssfRow.getCell(21).toString());
            if (xssfRow.getCell(22) != null) staffInfo.setGrdtDt(xssfRow.getCell(22).toString());
            if (xssfRow.getCell(23) != null) staffInfo.setNtUnt(xssfRow.getCell(23).toString());
            if (xssfRow.getCell(24) != null) staffInfo.setTchnldgLv(xssfRow.getCell(24).toString());
            if (xssfRow.getCell(25) != null) staffInfo.setIdntfyUnt(xssfRow.getCell(25).toString());
            if (xssfRow.getCell(26) != null) staffInfo.setAccntType(xssfRow.getCell(26).toString());
            if (xssfRow.getCell(27) != null) staffInfo.setAccntState(xssfRow.getCell(27).toString());
            if (xssfRow.getCell(28) != null) staffInfo.setWtrItm(xssfRow.getCell(28).toString());
            if (xssfRow.getCell(29) != null) staffInfo.setWtrOrdr(xssfRow.getCell(29).toString());

            // 如果员工号相同，或者身份证号相同，那么把该实体类返回到失败列表当中
            StaffInfoExample staffInfoExample = new StaffInfoExample();
            StaffInfoExample.Criteria criteria = staffInfoExample.createCriteria();
            if (xssfRow.getCell(0) != null) criteria.andStffIdEqualTo(xssfRow.getCell(0).toString());
            if (xssfRow.getCell(6) != null) criteria.andStffIdEqualTo(xssfRow.getCell(6).toString());
            staffInfoExample.or(criteria);
            List<StaffInfo> listAdd = staffInfoMapper.selectByExample(staffInfoExample);

            if (listAdd.size() != 0) {   // 说明有重样的
                listFail.add(staffInfo);
                continue;
            }

            try {   // 尝试性地向数据库插入从excel行得到的实体类
                staffInfoMapper.insert(staffInfo);
            } catch (Exception e) {
                listFail.add(staffInfo);
            }

            // 到了这里都没有出问题，说明成功！
            successAmount++;
        }
        // 循环结束后，把成功数目和失败列表返回到map
        map.put("successAmount", successAmount);
        map.put("listFail", listFail);
        return map;
    }
}
