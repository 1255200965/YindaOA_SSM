//package com.service.impl;
//
//import com.dao.*;
//import com.model.*;
//import com.service.IAskLeaveExcelService;
//import com.service.IImportService;
//import com.sun.org.apache.bcel.internal.generic.IASTORE;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by ma on 2016/10/15.
// * 说明：
// * 1.excel中所有的数值列，如工号，年龄，身份证号，所有的日期，都必须输入为纯数字，一旦一个单元格冒泡，后面所有的item都无法更新。即还没完成对excel文件的校验
// */
//@Transactional
//@Service
//public class AskLeaveExcelServiceImpl implements IAskLeaveExcelService {
//
//    @Autowired
//    public AskForLeaveMapper askForLeaveMapper;
//    @Autowired
//    public BusinessTripMapper businessTripMapper;
//    @Autowired
//    public YoItemChangeMapper yoItemChangeMapper;
//    @Autowired
//    public YoOvertimeMapper yoOvertimeMapper;
//    @Autowired
//    public YoSubwayMapper subwayMapper;
//    @Autowired
//    public YoYindaIdentifyMapper yoYindaIdentifyMapper;
//
//    public void testPrint(String fileDir) throws Exception{
//        File file = new File(fileDir);
//        InputStream is = new FileInputStream(file);
//        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
//
//        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
//    }
//
//    public Map<String, String> checkAskLeaveExcel(String fileDir) throws IOException {
//        Map<String, String> errorMap = new HashMap<String, String>();
//        File file = new File(fileDir);
//        InputStream is = new FileInputStream(file);
//        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
//
//        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
//
//        /*首先校验第一行，表头的信息
//        * 不相等或出现空指针异常皆视为校验失败*/
//        HSSFRow hssfRow = hssfSheet.getRow(0);
//        try {
//            if (!((hssfRow.getCell(0).toString().equals("审批编号"))
//                    && (hssfRow.getCell(1).toString().equals("标题"))
//                    && (hssfRow.getCell(2).toString().equals("审批状态"))
//                    && (hssfRow.getCell(3).toString().equals("审批结果"))
//                    && (hssfRow.getCell(4).toString().equals("审批发起时间"))
//                    && (hssfRow.getCell(5).toString().equals("审批完成时间"))
//                    && (hssfRow.getCell(6).toString().equals("发起人工号"))
//                    && (hssfRow.getCell(7).toString().equals("发起人姓名"))
//                    && (hssfRow.getCell(8).toString().equals("发起人部门"))
//                    && (hssfRow.getCell(9).toString().equals("历史审批人姓名"))
//                    && (hssfRow.getCell(10).toString().equals("审批记录"))
//                    && (hssfRow.getCell(11).toString().equals("当前处理人姓名"))
//                    && (hssfRow.getCell(12).toString().equals("审批耗时"))
//                    && (hssfRow.getCell(13).toString().equals("请假类型"))
//                    && (hssfRow.getCell(14).toString().equals("开始日期"))
//                    && (hssfRow.getCell(15).toString().equals("开始时间"))
//                    && (hssfRow.getCell(16).toString().equals("结束日期"))
//                    && (hssfRow.getCell(17).toString().equals("结束时间"))
//                    && (hssfRow.getCell(18).toString().equals("请假天数"))
//                    && (hssfRow.getCell(19).toString().equals("请假事由"))
//                    && (hssfRow.getCell(20).toString().equals("图片")))) {
//                errorMap.put("row", "表头");
//                errorMap.put("column", "表头");
//                errorMap.put("reason", "表头名称错误，与模板不相符");
//                return errorMap;
//            }
//        } catch (NullPointerException npe) {
//            errorMap.put("row", "表头");
//            errorMap.put("column", "表头");
//            errorMap.put("reason", "表头名称错误，与模板不相符");
//            return errorMap;
//        }
//
//        return errorMap;
//    }
//
//
//    /**
//     * 循环地插入excel中的一行到数据库中
//     * 如果审批编号相同，那么更新数据
//     */
//    public Map<String, Object> insertAskLeave(String fileDir) throws IOException {
//        Map<String, Object> map = new HashMap<String, Object>();
//        List<AskForLeave> listFail = new ArrayList<AskForLeave>();
//        int successAmount = 0;
//
//        File file = new File(fileDir);
//        InputStream is = new FileInputStream(file);
//        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
//        int sheetAccounts = hssfWorkbook.getNumberOfSheets();
//
//        for (int sheetNo=0; sheetNo<sheetAccounts; sheetNo++) {
//
//            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetNo);
//            for (int i=1; i<=hssfSheet.getLastRowNum(); i++) {
//                // 得到当前行
//                HSSFRow hssfRow = hssfSheet.getRow(i);
//
//                /*把每一行都设为string类型，这样数值型就可以直接toString了*/
//                for (int j=0; j<hssfRow.getPhysicalNumberOfCells(); j++) {
//                    if (hssfRow.getCell(j) != null) hssfRow.getCell(j).setCellType(1);
//                }
//
//                AskForLeave askForLeave = new AskForLeave();
//                if (hssfRow.getCell(0) != null) askForLeave.setYoApproveNo(hssfRow.getCell(0).toString());
//                if (hssfRow.getCell(1) != null) askForLeave.setYoTitle(hssfRow.getCell(1).toString());
//                if (hssfRow.getCell(2) != null) askForLeave.setYoApproveState(hssfRow.getCell(2).toString());
//                if (hssfRow.getCell(3) != null) askForLeave.setYoApproveResult(hssfRow.getCell(3).toString());
//                if (hssfRow.getCell(4) != null) askForLeave.setYoApproveBegin(hssfRow.getCell(4).toString());
//                if (hssfRow.getCell(5) != null) askForLeave.setYoApproveEnd(hssfRow.getCell(5).toString());
//                if (hssfRow.getCell(6) != null) askForLeave.setYoAskStaffId(hssfRow.getCell(6).toString());
//                if (hssfRow.getCell(7) != null) askForLeave.setYoAskStaffName(hssfRow.getCell(7).toString());
//                if (hssfRow.getCell(8) != null) askForLeave.setYoAskStaffDepart(hssfRow.getCell(8).toString());
//                if (hssfRow.getCell(9) != null) askForLeave.setYoHistoryApproveName(hssfRow.getCell(9).toString());
//                if (hssfRow.getCell(10) != null) askForLeave.setYoApproveRecord(hssfRow.getCell(10).toString());
//                if (hssfRow.getCell(11) != null) askForLeave.setYoNowApproveName(hssfRow.getCell(11).toString());
//                if (hssfRow.getCell(12) != null) askForLeave.setYoCost(hssfRow.getCell(12).toString());
//                if (hssfRow.getCell(13) != null) askForLeave.setYoType(hssfRow.getCell(13).toString());
//                if (hssfRow.getCell(14) != null) askForLeave.setYoAskBeginDate(hssfRow.getCell(14).toString());
//                if (hssfRow.getCell(15) != null) askForLeave.setYoAskBeginTime(hssfRow.getCell(15).toString());
//                if (hssfRow.getCell(16) != null) askForLeave.setYoAskEndDate(hssfRow.getCell(16).toString());
//                if (hssfRow.getCell(17) != null) askForLeave.setYoAskEndTime(hssfRow.getCell(17).toString());
//                if (hssfRow.getCell(18) != null) askForLeave.setYoAskSustain(hssfRow.getCell(18).toString());
//                if (hssfRow.getCell(19) != null) askForLeave.setYoAskReason(hssfRow.getCell(19).toString());
//                if (hssfRow.getCell(20) != null) askForLeave.setYoPicture(hssfRow.getCell(20).toString());
//
//                String approveNo = hssfRow.getCell(0).toString();
//                AskForLeaveExample example = new AskForLeaveExample();
//                example.createCriteria().andYoApproveNoEqualTo(approveNo);
//                List<AskForLeave> listExist = askForLeaveMapper.selectByExample(example);
//
//                if (listExist.size() != 0) {
//                    int sequence = listExist.get(0).getSequenceNo();
//                    askForLeave.setSequenceNo(sequence);
//                    // 尝试更新条目
//                    try {
//                        askForLeaveMapper.updateByPrimaryKey(askForLeave);
//                        // 更新成功，数目自加
//                        successAmount++;
//                        continue;
//                    } catch (Exception e) {
//                        listFail.add(askForLeave);
//                    }
//                }
//
//                try {   // 尝试性地向数据库插入从excel行得到的实体类
//                    askForLeaveMapper.insert(askForLeave);
//                } catch (Exception e) {
//                    listFail.add(askForLeave);
//                    continue;
//                }
//
//                // 到了这里都没有出问题，说明成功！
//                successAmount++;
//            }
//        }
//
//        // 循环结束后，把成功数目和失败列表返回到map
//        map.put("successAmount", successAmount);
//        map.put("listFail", listFail);
//        return map;
//    }
//
//
//}