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
import java.util.List;


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
    public List<StaffInfo> insert(String fileDir) throws IOException {
        List<StaffInfo> listFail = new ArrayList<StaffInfo>();
        File file = new File(fileDir);
        InputStream is = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

        for (int i=0; i<xssfSheet.getLastRowNum(); i++) {
            // 得到当前行
            XSSFRow xssfRow = xssfSheet.getRow(i);
            StaffInfo staffInfo = new StaffInfo();
            staffInfo.setStffId(xssfRow.getCell(0).getStringCellValue());
            staffInfo.setName(xssfRow.getCell(1).getStringCellValue());
            staffInfo.setAge((int)(xssfRow.getCell(2).getNumericCellValue()));
            staffInfo.setSex(xssfRow.getCell(3).getStringCellValue());
            staffInfo.setCellphone(xssfRow.getCell(4).getStringCellValue());
            staffInfo.setEmail(xssfRow.getCell(5).getStringCellValue());
            staffInfo.setIdCrd(xssfRow.getCell(6).toString());
            staffInfo.setHshldAddrss(xssfRow.getCell(7).toString());
            staffInfo.setNation(xssfRow.getCell(8).toString());
            staffInfo.setLvAddrss(xssfRow.getCell(9).toString());
            staffInfo.setBrnchCmpny(xssfRow.getCell(10).toString());
            staffInfo.setDepartment(xssfRow.getCell(11).toString());
            staffInfo.setSgnAddrss(xssfRow.getCell(12).toString());
            staffInfo.setSgnDt(xssfRow.getCell(13).toString());
            staffInfo.setCntrctType(xssfRow.getCell(14).toString());
            staffInfo.setCntrctBgn(xssfRow.getCell(15).toString());
            staffInfo.setCntrctEnd(xssfRow.getCell(16).toString());
            staffInfo.setSlryCrd(xssfRow.getCell(17).toString());
            staffInfo.setExpnsCrd(xssfRow.getCell(18).toString());
            staffInfo.setStffState(xssfRow.getCell(19).toString());
            staffInfo.setGrdtSchl(xssfRow.getCell(20).toString());
            staffInfo.setSchlRcrd(xssfRow.getCell(21).toString());
            staffInfo.setGrdtDt(xssfRow.getCell(22).toString());
            staffInfo.setNtUnt(xssfRow.getCell(23).toString());
            staffInfo.setTchnldgLv(xssfRow.getCell(24).toString());
            staffInfo.setIdntfyUnt(xssfRow.getCell(25).toString());
            staffInfo.setAccntType(xssfRow.getCell(26).toString());
            staffInfo.setAccntState(xssfRow.getCell(27).toString());
            staffInfo.setWtrItm(xssfRow.getCell(28).toString());
            staffInfo.setWtrOrdr(xssfRow.getCell(29).toString());

            try {   // 尝试性地向数据库插入从excel行得到的实体类
                staffInfoMapper.insert(staffInfo);
            } catch (Exception e) {
                listFail.add(staffInfo);
            }
        }
        return listFail;
    }
}
