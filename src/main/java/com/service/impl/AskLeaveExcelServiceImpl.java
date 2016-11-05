package com.service.impl;

import com.dao.*;
import com.model.*;
import com.service.IAskLeaveExcelService;
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
 * 队标：一篇代码，最好不要超过200行，尽量不要超过300行，一定不能超过500行
 * Created by ma on 2016/10/15.
 * 说明：
 * 1.excel中所有的数值列，如工号，年龄，身份证号，所有的日期，都必须输入为纯数字，一旦一个单元格冒泡，后面所有的item都无法更新。即还没完成对excel文件的校验
 */

@Service
public class AskLeaveExcelServiceImpl implements IAskLeaveExcelService {

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
     * 该方法实现对表头的校验，至于剩余内容的校验，在插入方法中完成
     * 表头不符合规范或者发生了空指针异常，皆视为校验失败
     * 为了方便，暂时将Map的格式统一为String+Object
     */
    public Map<String, Object> checkAskLeaveExcel(String fileDir) throws IOException {
        Map<String, Object> errorMap = new HashMap<String, Object>();
        File file = new File(fileDir);
        InputStream inputStream = new FileInputStream(file);
        // Java的规定，有了输入流才能按照格式读取excel文件
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        // 得到当前文件的总表数
        int sheetTotal = hssfWorkbook.getNumberOfSheets();

        // 接下来对每一张表都进行操作
        for (int sheetNo=0; sheetNo<sheetTotal; sheetNo++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetNo);
            // 在表头校验方法中，我们只玩第一行！
            HSSFRow hssfRow = hssfSheet.getRow(0);
            try {
                // int也是一个对象，大括号结束后会释放掉
                int cellNo = 0;
                // 这里用一个大胆的做法，先执行函数再自加。虽然++i听说效率更高，但想必也高不到哪里去
                if (hssfRow.getCell(cellNo++).toString().equals("审批编号")
                        && hssfRow.getCell(cellNo++).toString().equals("标题")
                        && hssfRow.getCell(cellNo++).toString().equals("审批状态")
                        && hssfRow.getCell(cellNo++).toString().equals("审批结果")
                        && hssfRow.getCell(cellNo++).toString().equals("审批发起时间")
                        && hssfRow.getCell(cellNo++).toString().equals("审批完成时间")
                        && hssfRow.getCell(cellNo++).toString().equals("发起人工号")
                        && hssfRow.getCell(cellNo++).toString().equals("发起人姓名")
                        && hssfRow.getCell(cellNo++).toString().equals("发起人部门")
                        && hssfRow.getCell(cellNo++).toString().equals("历史审批人姓名")
                        && hssfRow.getCell(cellNo++).toString().equals("审批记录")
                        && hssfRow.getCell(cellNo++).toString().equals("当前处理人姓名")
                        && hssfRow.getCell(cellNo++).toString().equals("审批耗时")
                        && hssfRow.getCell(cellNo++).toString().equals("请假类型")
                        && hssfRow.getCell(cellNo++).toString().equals("开始日期")
                        && hssfRow.getCell(cellNo++).toString().equals("开始时间")
                        && hssfRow.getCell(cellNo++).toString().equals("结束日期")
                        && hssfRow.getCell(cellNo++).toString().equals("结束时间")
                        && hssfRow.getCell(cellNo++).toString().equals("请假天数")
                        && hssfRow.getCell(cellNo++).toString().equals("请假事由")
                        && hssfRow.getCell(cellNo++).toString().equals("图片")
                        ) {
                    // 如果验证通过了，就打印成功信息（额，要不然什么都不做的话显得不太好= =）
                    System.out.println("表头审核成功！通过审核的表格页数 = "+sheetNo+1);
                }
                else {
                    errorMap.put("row", "表头");
                    errorMap.put("column", "表头");
                    errorMap.put("reason", "表头名称错误，与模板不相符");
                    return errorMap;
                }
            } catch (NullPointerException e) {
                errorMap.put("row", "表头");
                errorMap.put("column", "表头");
                errorMap.put("reason", "表头名称错误，与模板不相符");
                return errorMap;
            }
        }

        return errorMap;
    }

    /**
     * 循环地插入excel中的一行到数据库中
     * 如果审批编号相同，那么更新数据
     */
//    public Map<String, Object> insertAskLeave(String fileDir) throws IOException {
//        Map<String, Object> map = new HashMap<String, Object>();
//        List<AskForLeave> listFail = new ArrayList<AskForLeave>();
//        int successAmount = 0;
//
//        File file = new File(fileDir);
//        InputStream inputStream = new FileInputStream(file);
//        // Java的规定，有了输入流才能按照格式读取excel文件
//        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
//        // 得到当前文件的总表数
//        int sheetTotal = hssfWorkbook.getNumberOfSheets();
//
//        // 接下来对每一张表都进行操作
//        for (int sheetNo=0; sheetNo<sheetTotal; sheetNo++) {
//            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetNo);
//            int rowTotal = hssfSheet.getPhysicalNumberOfRows();
//
//            // 对每一张表中的每一行进行操作
//            for (int rowNo=1; rowNo<rowTotal; rowNo++) {
//                // 从第二行开始，得到每一行
//                HSSFRow hssfRow = hssfSheet.getRow(rowNo);
//                int cellTotal = hssfRow.getPhysicalNumberOfCells();
//
//                /*
//                现在开始做真正的功能！
//                第一步，把得到的hssfRow对象中的每一个cell都设为文本类型，确保每一个数值在toString后不会自动加上.0
//                */
//                for (int cellNo=0; cellNo<cellTotal; cellNo++) {
//                    // cell不为空时才操作，为空也就不用管他是什么类型了
//                    // 想管也管不起，因为会报NullPointerException，而我们编程时应当避免异常，而不是积极处理异常
//                    if (hssfRow.getCell(cellNo) != null) hssfRow.getCell(cellNo).setCellType(1);
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


}