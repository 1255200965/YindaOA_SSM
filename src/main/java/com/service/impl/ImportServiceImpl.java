package com.service.impl;

import com.dao.*;
import com.model.*;
import com.service.IImportService;
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
public class ImportServiceImpl implements IImportService {

    @Autowired
    public AskForLeaveMapper askForLeaveMapper;
    @Autowired
    public BusinessTripMapper businessTripMapper;
    @Autowired
    public YoItemChangeMapper yoItemChangeMapper;
    @Autowired
    public YoOvertimeMapper yoOvertimeMapper;
    @Autowired
    public YoSubwayMapper subwayMapper;
    @Autowired
    public YoYindaIdentifyMapper yoYindaIdentifyMapper;

    /**
     * 循环地插入excel中的一行到数据库中
     * 如果审批编号相同，那么更新数据
     */
    public Map<String, Object> insertAskLeave(String fileDir) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        List<AskForLeave> listFail = new ArrayList<AskForLeave>();
        int successAmount = 0;

        File file = new File(fileDir);
        InputStream is = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        int sheetAccounts = hssfWorkbook.getNumberOfSheets();

        for (int sheetNo=0; sheetNo<sheetAccounts; sheetNo++) {

            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetNo);
            for (int i=1; i<=hssfSheet.getLastRowNum(); i++) {
                // 得到当前行
                HSSFRow hssfRow = hssfSheet.getRow(i);

                /*把每一行都设为string类型，这样数值型就可以直接toString了*/
                for (int j=0; j<hssfRow.getPhysicalNumberOfCells(); j++) {
                    if (hssfRow.getCell(j) != null) hssfRow.getCell(j).setCellType(1);
                }

                AskForLeave askForLeave = new AskForLeave();
                if (hssfRow.getCell(0) != null) askForLeave.setYoApproveNo(hssfRow.getCell(0).toString());
                if (hssfRow.getCell(1) != null) askForLeave.setYoTitle(hssfRow.getCell(1).toString());
                if (hssfRow.getCell(2) != null) askForLeave.setYoApproveState(hssfRow.getCell(2).toString());
                if (hssfRow.getCell(3) != null) askForLeave.setYoApproveResult(hssfRow.getCell(3).toString());
                if (hssfRow.getCell(4) != null) askForLeave.setYoApproveBegin(hssfRow.getCell(4).toString());
                if (hssfRow.getCell(5) != null) askForLeave.setYoApproveEnd(hssfRow.getCell(5).toString());
                if (hssfRow.getCell(6) != null) askForLeave.setYoAskStaffId(hssfRow.getCell(6).toString());
                if (hssfRow.getCell(7) != null) askForLeave.setYoAskStaffName(hssfRow.getCell(7).toString());
                if (hssfRow.getCell(8) != null) askForLeave.setYoAskStaffDepart(hssfRow.getCell(8).toString());
                if (hssfRow.getCell(9) != null) askForLeave.setYoHistoryApproveName(hssfRow.getCell(9).toString());
                if (hssfRow.getCell(10) != null) askForLeave.setYoApproveRecord(hssfRow.getCell(10).toString());
                if (hssfRow.getCell(11) != null) askForLeave.setYoNowApproveName(hssfRow.getCell(11).toString());
                if (hssfRow.getCell(12) != null) askForLeave.setYoCost(hssfRow.getCell(12).toString());
                if (hssfRow.getCell(13) != null) askForLeave.setYoType(hssfRow.getCell(13).toString());
                if (hssfRow.getCell(14) != null) askForLeave.setYoAskBeginDate(hssfRow.getCell(14).toString());
                if (hssfRow.getCell(15) != null) askForLeave.setYoAskBeginTime(hssfRow.getCell(15).toString());
                if (hssfRow.getCell(16) != null) askForLeave.setYoAskEndDate(hssfRow.getCell(16).toString());
                if (hssfRow.getCell(17) != null) askForLeave.setYoAskEndTime(hssfRow.getCell(17).toString());
                if (hssfRow.getCell(18) != null) askForLeave.setYoAskSustain(hssfRow.getCell(18).toString());
                if (hssfRow.getCell(19) != null) askForLeave.setYoAskReason(hssfRow.getCell(19).toString());
                if (hssfRow.getCell(20) != null) askForLeave.setYoPicture(hssfRow.getCell(20).toString());

                String approveNo = hssfRow.getCell(0).toString();
                AskForLeaveExample example = new AskForLeaveExample();
                example.createCriteria().andYoApproveNoEqualTo(approveNo);
                List<AskForLeave> listExist = askForLeaveMapper.selectByExample(example);

                if (listExist.size() != 0) {
                    int sequence = listExist.get(0).getSequenceNo();
                    askForLeave.setSequenceNo(sequence);
                    // 尝试更新条目
                    try {
                        askForLeaveMapper.updateByPrimaryKey(askForLeave);
                        // 更新成功，数目自加
                        successAmount++;
                        continue;
                    } catch (Exception e) {
                        listFail.add(askForLeave);
                    }
                }

                try {   // 尝试性地向数据库插入从excel行得到的实体类
                    askForLeaveMapper.insert(askForLeave);
                } catch (Exception e) {
                    listFail.add(askForLeave);
                    continue;
                }

                // 到了这里都没有出问题，说明成功！
                successAmount++;
            }
        }

        // 循环结束后，把成功数目和失败列表返回到map
        map.put("successAmount", successAmount);
        map.put("listFail", listFail);
        return map;
    }

    public Map<String, Object> insertBusinessTrip(String fileDir) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        List<BusinessTrip> listFail = new ArrayList<BusinessTrip>();
        int successAmount = 0;

        File file = new File(fileDir);
        InputStream is = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        int sheetAccounts = hssfWorkbook.getNumberOfSheets();

        for (int sheetNo=0; sheetNo<sheetAccounts; sheetNo++) {

            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetNo);
            for (int i=1; i<=hssfSheet.getLastRowNum(); i++) {
                // 得到当前行
                HSSFRow hssfRow = hssfSheet.getRow(i);

                for (int j=0; j<hssfRow.getPhysicalNumberOfCells(); j++) {
                    if (hssfRow.getCell(j) != null) hssfRow.getCell(j).setCellType(1);
                }

                BusinessTrip businessTrip = new BusinessTrip();
                if (hssfRow.getCell(0) != null) businessTrip.setBtApproveNo(hssfRow.getCell(0).toString());
                if (hssfRow.getCell(1) != null) businessTrip.setBtTitle(hssfRow.getCell(1).toString());
                if (hssfRow.getCell(2) != null) businessTrip.setBtApproveState(hssfRow.getCell(2).toString());
                if (hssfRow.getCell(3) != null) businessTrip.setBtApproveResult(hssfRow.getCell(3).toString());
                if (hssfRow.getCell(4) != null) businessTrip.setBtApproveBegin(hssfRow.getCell(4).toString());
                if (hssfRow.getCell(5) != null) businessTrip.setBtApproveEnd(hssfRow.getCell(5).toString());
                if (hssfRow.getCell(6) != null) businessTrip.setBtAskStaffId(hssfRow.getCell(6).toString());
                if (hssfRow.getCell(7) != null) businessTrip.setBtAskStaffName(hssfRow.getCell(7).toString());
                if (hssfRow.getCell(8) != null) businessTrip.setBtAskStaffDepart(hssfRow.getCell(8).toString());
                if (hssfRow.getCell(9) != null) businessTrip.setBtHistoryApproveName(hssfRow.getCell(9).toString());
                if (hssfRow.getCell(10) != null) businessTrip.setBtApproveRecord(hssfRow.getCell(10).toString());
                if (hssfRow.getCell(11) != null) businessTrip.setBtNowApproveName(hssfRow.getCell(11).toString());
                if (hssfRow.getCell(12) != null) businessTrip.setBtCost(hssfRow.getCell(12).toString());
                if (hssfRow.getCell(13) != null) businessTrip.setBtDetail(hssfRow.getCell(13).toString());
                if (hssfRow.getCell(14) != null) businessTrip.setBtAddress(hssfRow.getCell(14).toString());
                if (hssfRow.getCell(15) != null) businessTrip.setBtAskBeginTime(hssfRow.getCell(15).toString());
                if (hssfRow.getCell(16) != null) businessTrip.setBtAskEndTime(hssfRow.getCell(16).toString());
                if (hssfRow.getCell(17) != null) businessTrip.setBtAskSustain(hssfRow.getCell(17).toString());
                if (hssfRow.getCell(18) != null) businessTrip.setBtAskReason(hssfRow.getCell(18).toString());
                if (hssfRow.getCell(19) != null) businessTrip.setBtPicture(hssfRow.getCell(19).toString());

                String approveNo = hssfRow.getCell(0).toString();
                BusinessTripExample example = new BusinessTripExample();
                example.createCriteria().andBtApproveNoEqualTo(approveNo);
                List<BusinessTrip> listExist = businessTripMapper.selectByExample(example);

                if (listExist.size() != 0) {
                    int sequence = listExist.get(0).getBtSequenceNo();
                    businessTrip.setBtSequenceNo(sequence);
                    // 尝试更新条目
                    try {
                        businessTripMapper.updateByPrimaryKey(businessTrip);
                        // 更新成功，数目自加
                        successAmount++;
                        continue;
                    } catch (Exception e) {
                        listFail.add(businessTrip);
                    }
                }

                try {   // 尝试性地向数据库插入从excel行得到的实体类
                    businessTripMapper.insert(businessTrip);
                } catch (Exception e) {
                    listFail.add(businessTrip);
                    continue;
                }

                // 到了这里都没有出问题，说明成功！
                successAmount++;
            }
        }

        // 循环结束后，把成功数目和失败列表返回到map
        map.put("successAmount", successAmount);
        map.put("listFail", listFail);
        return map;
    }

    public Map<String, Object> insertSubway(String fileDir) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        List<YoSubway> listFail = new ArrayList<YoSubway>();
        int successAmount = 0;

        File file = new File(fileDir);
        InputStream is = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        int sheetAccounts = hssfWorkbook.getNumberOfSheets();

        for (int sheetNo=0; sheetNo<sheetAccounts; sheetNo++) {

            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetNo);
            for (int i=1; i<=hssfSheet.getLastRowNum(); i++) {
                // 得到当前行
                HSSFRow hssfRow = hssfSheet.getRow(i);

                for (int j=0; j<hssfRow.getPhysicalNumberOfCells(); j++) {
                    if (hssfRow.getCell(j) != null) hssfRow.getCell(j).setCellType(1);
                }

                YoSubway subway = new YoSubway();
                if (hssfRow.getCell(0) != null) subway.setSubApproveNo(hssfRow.getCell(0).toString());
                if (hssfRow.getCell(1) != null) subway.setSubTitle(hssfRow.getCell(1).toString());
                if (hssfRow.getCell(2) != null) subway.setSubApproveState(hssfRow.getCell(2).toString());
                if (hssfRow.getCell(3) != null) subway.setSubApproveResult(hssfRow.getCell(3).toString());
                if (hssfRow.getCell(4) != null) subway.setSubApproveBegin(hssfRow.getCell(4).toString());
                if (hssfRow.getCell(5) != null) subway.setSubApproveEnd(hssfRow.getCell(5).toString());
                if (hssfRow.getCell(6) != null) subway.setSubAskStaffId(hssfRow.getCell(6).toString());
                if (hssfRow.getCell(7) != null) subway.setSubAskStaffName(hssfRow.getCell(7).toString());
                if (hssfRow.getCell(8) != null) subway.setSubAskStaffDepart(hssfRow.getCell(8).toString());
                if (hssfRow.getCell(9) != null) subway.setSubHistoryApproveName(hssfRow.getCell(9).toString());
                if (hssfRow.getCell(10) != null) subway.setSubApproveRecord(hssfRow.getCell(10).toString());
                if (hssfRow.getCell(11) != null) subway.setSubNowApproveName(hssfRow.getCell(11).toString());
                if (hssfRow.getCell(12) != null) subway.setSubCost(hssfRow.getCell(12).toString());
                if (hssfRow.getCell(13) != null) subway.setSubTakeDate(hssfRow.getCell(13).toString());
                if (hssfRow.getCell(14) != null) subway.setSubAmount(hssfRow.getCell(14).toString());
                if (hssfRow.getCell(15) != null) subway.setSubAskReason(hssfRow.getCell(15).toString());

                String approveNo = hssfRow.getCell(0).toString();
                YoSubwayExample example = new YoSubwayExample();
                example.createCriteria().andSubApproveNoEqualTo(approveNo);
                List<YoSubway> listExist = subwayMapper.selectByExample(example);

                if (listExist.size() != 0) {
                    int sequence = listExist.get(0).getSubSequenceNo();
                    subway.setSubSequenceNo(sequence);
                    // 尝试更新条目
                    try {
                        subwayMapper.updateByPrimaryKey(subway);
                        // 更新成功，数目自加
                        successAmount++;
                        continue;
                    } catch (Exception e) {
                        listFail.add(subway);
                    }
                }

                try {   // 尝试性地向数据库插入从excel行得到的实体类
                    subwayMapper.insert(subway);
                } catch (Exception e) {
                    listFail.add(subway);
                    continue;
                }

                // 到了这里都没有出问题，说明成功！
                successAmount++;
            }
        }

        // 循环结束后，把成功数目和失败列表返回到map
        map.put("successAmount", successAmount);
        map.put("listFail", listFail);
        return map;
    }

    public Map<String, Object> insertYoOvertime(String fileDir) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        List<YoOvertime> listFail = new ArrayList<YoOvertime>();
        int successAmount = 0;

        File file = new File(fileDir);
        InputStream is = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        int sheetAccounts = hssfWorkbook.getNumberOfSheets();

        for (int sheetNo=0; sheetNo<sheetAccounts; sheetNo++) {

            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetNo);
            for (int i=1; i<=hssfSheet.getLastRowNum(); i++) {
                // 得到当前行
                HSSFRow hssfRow = hssfSheet.getRow(i);

                for (int j=0; j<hssfRow.getPhysicalNumberOfCells(); j++) {
                    if (hssfRow.getCell(j) != null) hssfRow.getCell(j).setCellType(1);
                }

                YoOvertime yoOvertime = new YoOvertime();
                if (hssfRow.getCell(0) != null) yoOvertime.setOtApproveNo(hssfRow.getCell(0).toString());
                if (hssfRow.getCell(1) != null) yoOvertime.setOtTitle(hssfRow.getCell(1).toString());
                if (hssfRow.getCell(2) != null) yoOvertime.setOtApproveState(hssfRow.getCell(2).toString());
                if (hssfRow.getCell(3) != null) yoOvertime.setOtApproveResult(hssfRow.getCell(3).toString());
                if (hssfRow.getCell(4) != null) yoOvertime.setOtApproveBegin(hssfRow.getCell(4).toString());
                if (hssfRow.getCell(5) != null) yoOvertime.setOtApproveEnd(hssfRow.getCell(5).toString());
                if (hssfRow.getCell(6) != null) yoOvertime.setOtAskStaffId(hssfRow.getCell(6).toString());
                if (hssfRow.getCell(7) != null) yoOvertime.setOtAskStaffName(hssfRow.getCell(7).toString());
                if (hssfRow.getCell(8) != null) yoOvertime.setOtAskStaffDepart(hssfRow.getCell(8).toString());
                if (hssfRow.getCell(9) != null) yoOvertime.setOtHistoryApproveName(hssfRow.getCell(9).toString());
                if (hssfRow.getCell(10) != null) yoOvertime.setOtApproveRecord(hssfRow.getCell(10).toString());
                if (hssfRow.getCell(11) != null) yoOvertime.setOtNowApproveName(hssfRow.getCell(11).toString());
                if (hssfRow.getCell(12) != null) yoOvertime.setOtCost(hssfRow.getCell(12).toString());
                if (hssfRow.getCell(13) != null) yoOvertime.setOtAskBeginTime(hssfRow.getCell(13).toString());
                if (hssfRow.getCell(14) != null) yoOvertime.setOtAskEndTime(hssfRow.getCell(14).toString());
                if (hssfRow.getCell(15) != null) yoOvertime.setOtLegalHoliday(hssfRow.getCell(15).toString());
                if (hssfRow.getCell(16) != null) yoOvertime.setOtPayMethod(hssfRow.getCell(16).toString());
                if (hssfRow.getCell(17) != null) yoOvertime.setOtAskSustain(hssfRow.getCell(17).toString());
                if (hssfRow.getCell(18) != null) yoOvertime.setOtAskReason(hssfRow.getCell(18).toString());

                String approveNo = hssfRow.getCell(0).toString();
                YoOvertimeExample example = new YoOvertimeExample();
                example.createCriteria().andOtApproveNoEqualTo(approveNo);
                List<YoOvertime> listExist = yoOvertimeMapper.selectByExample(example);

                if (listExist.size() != 0) {
                    int sequence = listExist.get(0).getOtSequenceNo();
                    yoOvertime.setOtSequenceNo(sequence);
                    // 尝试更新条目
                    try {
                        yoOvertimeMapper.updateByPrimaryKey(yoOvertime);
                        // 更新成功，数目自加
                        successAmount++;
                        continue;
                    } catch (Exception e) {
                        listFail.add(yoOvertime);
                    }
                }

                try {   // 尝试性地向数据库插入从excel行得到的实体类
                    yoOvertimeMapper.insert(yoOvertime);
                } catch (Exception e) {
                    listFail.add(yoOvertime);
                    continue;
                }

                // 到了这里都没有出问题，说明成功！
                successAmount++;
            }
        }

        // 循环结束后，把成功数目和失败列表返回到map
        map.put("successAmount", successAmount);
        map.put("listFail", listFail);
        return map;
    }

    public Map<String, Object> insertYoItemChange(String fileDir) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        List<YoItemChange> listFail = new ArrayList<YoItemChange>();
        int successAmount = 0;

        File file = new File(fileDir);
        InputStream is = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        int sheetAccounts = hssfWorkbook.getNumberOfSheets();

        for (int sheetNo=0; sheetNo<sheetAccounts; sheetNo++) {

            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetNo);
            for (int i=1; i<=hssfSheet.getLastRowNum(); i++) {
                // 得到当前行
                HSSFRow hssfRow = hssfSheet.getRow(i);

                for (int j=0; j<hssfRow.getPhysicalNumberOfCells(); j++) {
                    if (hssfRow.getCell(j) != null) hssfRow.getCell(j).setCellType(1);
                }

                YoItemChange yoItemChange = new YoItemChange();
                if (hssfRow.getCell(0) != null) yoItemChange.setIcApproveNo(hssfRow.getCell(0).toString());
                if (hssfRow.getCell(1) != null) yoItemChange.setIcTitle(hssfRow.getCell(1).toString());
                if (hssfRow.getCell(2) != null) yoItemChange.setIcApproveState(hssfRow.getCell(2).toString());
                if (hssfRow.getCell(3) != null) yoItemChange.setIcApproveResult(hssfRow.getCell(3).toString());
                if (hssfRow.getCell(4) != null) yoItemChange.setIcApproveBegin(hssfRow.getCell(4).toString());
                if (hssfRow.getCell(5) != null) yoItemChange.setIcApproveEnd(hssfRow.getCell(5).toString());
                if (hssfRow.getCell(6) != null) yoItemChange.setIcAskStaffId(hssfRow.getCell(6).toString());
                if (hssfRow.getCell(7) != null) yoItemChange.setIcAskStaffName(hssfRow.getCell(7).toString());
                if (hssfRow.getCell(8) != null) yoItemChange.setIcAskStaffDepart(hssfRow.getCell(8).toString());
                if (hssfRow.getCell(9) != null) yoItemChange.setIcHistoryApproveName(hssfRow.getCell(9).toString());
                if (hssfRow.getCell(10) != null) yoItemChange.setIcApproveRecord(hssfRow.getCell(10).toString());
                if (hssfRow.getCell(11) != null) yoItemChange.setIcNowApproveName(hssfRow.getCell(11).toString());
                if (hssfRow.getCell(12) != null) yoItemChange.setIcCost(hssfRow.getCell(12).toString());
                if (hssfRow.getCell(13) != null) yoItemChange.setIcChangeItem(hssfRow.getCell(13).toString());
                if (hssfRow.getCell(14) != null) yoItemChange.setIcChangeProvince(hssfRow.getCell(14).toString());
                if (hssfRow.getCell(15) != null) yoItemChange.setIcWorkCity(hssfRow.getCell(15).toString());
                if (hssfRow.getCell(16) != null) yoItemChange.setIcTimebase(hssfRow.getCell(16).toString());
                if (hssfRow.getCell(17) != null) yoItemChange.setIcEffectDate(hssfRow.getCell(17).toString());

                String approveNo = hssfRow.getCell(0).toString();
                YoItemChangeExample example = new YoItemChangeExample();
                example.createCriteria().andIcApproveNoEqualTo(approveNo);
                List<YoItemChange> listExist = yoItemChangeMapper.selectByExample(example);

                if (listExist.size() != 0) {
                    int sequence = listExist.get(0).getIcSequenceNo();
                    yoItemChange.setIcSequenceNo(sequence);
                    // 尝试更新条目
                    try {
                        yoItemChangeMapper.updateByPrimaryKey(yoItemChange);
                        // 更新成功，数目自加
                        successAmount++;
                        continue;
                    } catch (Exception e) {
                        listFail.add(yoItemChange);
                    }
                }

                try {   // 尝试性地向数据库插入从excel行得到的实体类
                    yoItemChangeMapper.insert(yoItemChange);
                } catch (Exception e) {
                    listFail.add(yoItemChange);
                    continue;
                }

                // 到了这里都没有出问题，说明成功！
                successAmount++;
            }
        }

        // 循环结束后，把成功数目和失败列表返回到map
        map.put("successAmount", successAmount);
        map.put("listFail", listFail);
        return map;
    }

    public Map<String, Object> insertYoYindaIdentify(String fileDir) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        List<YoYindaIdentify> listFail = new ArrayList<YoYindaIdentify>();
        int successAmount = 0;

        File file = new File(fileDir);
        InputStream is = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        int sheetAccounts = hssfWorkbook.getNumberOfSheets();

        for (int sheetNo=0; sheetNo<sheetAccounts; sheetNo++) {

            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetNo);
            for (int i=1; i<=hssfSheet.getLastRowNum(); i++) {
                // 得到当前行
                HSSFRow hssfRow = hssfSheet.getRow(i);

                for (int j=0; j<hssfRow.getPhysicalNumberOfCells(); j++) {
                    if (hssfRow.getCell(j) != null) hssfRow.getCell(j).setCellType(1);
                }

                YoYindaIdentify yoYindaIdentify = new YoYindaIdentify();
                if (hssfRow.getCell(0) != null) yoYindaIdentify.setYiApproveNo(hssfRow.getCell(0).toString());
                if (hssfRow.getCell(1) != null) yoYindaIdentify.setYiTitle(hssfRow.getCell(1).toString());
                if (hssfRow.getCell(2) != null) yoYindaIdentify.setYiApproveState(hssfRow.getCell(2).toString());
                if (hssfRow.getCell(3) != null) yoYindaIdentify.setYiApproveResult(hssfRow.getCell(3).toString());
                if (hssfRow.getCell(4) != null) yoYindaIdentify.setYiApproveBegin(hssfRow.getCell(4).toString());
                if (hssfRow.getCell(5) != null) yoYindaIdentify.setYiApproveEnd(hssfRow.getCell(5).toString());
                if (hssfRow.getCell(6) != null) yoYindaIdentify.setYiAskStaffId(hssfRow.getCell(6).toString());
                if (hssfRow.getCell(7) != null) yoYindaIdentify.setYiAskStaffName(hssfRow.getCell(7).toString());
                if (hssfRow.getCell(8) != null) yoYindaIdentify.setYiAskStaffDepart(hssfRow.getCell(8).toString());
                if (hssfRow.getCell(9) != null) yoYindaIdentify.setYiHistoryApproveName(hssfRow.getCell(9).toString());
                if (hssfRow.getCell(10) != null) yoYindaIdentify.setYiApproveRecord(hssfRow.getCell(10).toString());
                if (hssfRow.getCell(11) != null) yoYindaIdentify.setYiNowApproveName(hssfRow.getCell(11).toString());
                if (hssfRow.getCell(12) != null) yoYindaIdentify.setYiCost(hssfRow.getCell(12).toString());
                if (hssfRow.getCell(13) != null) yoYindaIdentify.setYiYindaLevel(hssfRow.getCell(13).toString());
                if (hssfRow.getCell(14) != null) yoYindaIdentify.setYiEffectDate(hssfRow.getCell(14).toString());

                String approveNo = hssfRow.getCell(0).toString();
                YoYindaIdentifyExample example = new YoYindaIdentifyExample();
                example.createCriteria().andYiApproveNoEqualTo(approveNo);
                List<YoYindaIdentify> listExist = yoYindaIdentifyMapper.selectByExample(example);

                if (listExist.size() != 0) {
                    int sequence = listExist.get(0).getYiSequenceNo();
                    yoYindaIdentify.setYiSequenceNo(sequence);
                    // 尝试更新条目
                    try {
                        yoYindaIdentifyMapper.updateByPrimaryKey(yoYindaIdentify);
                        // 更新成功，数目自加
                        successAmount++;
                        continue;
                    } catch (Exception e) {
                        listFail.add(yoYindaIdentify);
                    }
                }

                try {   // 尝试性地向数据库插入从excel行得到的实体类
                    yoYindaIdentifyMapper.insert(yoYindaIdentify);
                } catch (Exception e) {
                    listFail.add(yoYindaIdentify);
                    continue;
                }

                // 到了这里都没有出问题，说明成功！
                successAmount++;
            }
        }

        // 循环结束后，把成功数目和失败列表返回到map
        map.put("successAmount", successAmount);
        map.put("listFail", listFail);
        return map;
    }
    
}