package com.controller;

import com.model.StaffInfo;
import com.model.YoAtteninfo;
import com.service.IExcelAttendanceDetailService;
import com.util.DateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ExcelAttendanceDetail")
public class ExcelAttendanceDetailController {

    @Autowired
    private IExcelAttendanceDetailService iExcelAttendanceDetailService;

    @RequestMapping("/navigator.do")
    public String navigator() {
        return "/upload";
    }

    /*
    打开主页
     */
    @RequestMapping("/homePage.do")
    public String homePage( @RequestParam(value = "validateUpload", defaultValue = "") String validateUpload,
                            @RequestParam(value = "validateTitle", defaultValue = "") String validateTitle,
                            Model m) {
        m.addAttribute("validateUpload", validateUpload);
        m.addAttribute("validateTitle", validateTitle);
        return "excel/attendance_detail";
    }

    /*
    导入功能
     */
    @RequestMapping(value = "/import.do", method = RequestMethod.POST)
    public String importExcel(@RequestParam("fileUpload") MultipartFile fileUpload, Model m, RedirectAttributes ra) {
        // 第1步，从上传的文件中得到输入流
        InputStream inputStream = null;
        try {
            inputStream = fileUpload.getInputStream();
            ra.addAttribute("validateUpload", "文件上传成功！");
        } catch (Exception e) {
            ra.addAttribute("validateUpload", "文件上传失败，请检查联网状态");
            return "redirect:homePage.do";
        }

        // 第2步，从输入流中得到excel工作表
        // Java的规定，有了输入流才能按照格式读取excel文件
        HSSFWorkbook hssfWorkbook = null;
        try {
            // 猜想：有可能文件太大会爆掉，所以要try
            hssfWorkbook = new HSSFWorkbook(inputStream);
        } catch (Exception e) {
            ra.addAttribute("validateTitle", "文件输入流可能太大乃至爆掉了，请换个文件再试试吧！");
            return "redirect:homePage.do";
        }

        // 第3步，对文件进行表头效验
        String validateTitle = validateExcelTitle(hssfWorkbook);
        if (!(validateTitle.contains("成功"))) {
            // 如果失败了，把失败原因输出到页面
            ra.addAttribute("validateTitle", validateTitle);
            return "redirect:homePage.do";
        }

        // 第4步，添加文件到数据库
        Date dateBegin = new Date();
        Map<String, Object> mapInsert = iExcelAttendanceDetailService.insertAndUpdate(hssfWorkbook);
        String successAmount = mapInsert.get("successAmount").toString();
        m.addAttribute("successAmount", successAmount);
        List<YoAtteninfo> listFail = (ArrayList<YoAtteninfo>)mapInsert.get("listFail");
        int failAmonutInt = listFail.size();
        String failAmountStr = String.valueOf(failAmonutInt);
        Date dateEnd = new Date();
        long interval = dateEnd.getTime() - dateBegin.getTime();
        long minute = interval / 60000;
        long second = (interval - minute * 60000) / 1000;
        m.addAttribute("cost", minute+"分"+second+"秒");
        m.addAttribute("failAmount", failAmountStr);
        m.addAttribute("listFail", listFail);

        return "excel/attendance_detail_import";
    }

    /*
    表头校验
    表头不符合规范或者发生了空指针异常，皆视为校验失败
    剩余内容的校验，在插入方法中完成
     */
    public String validateExcelTitle(HSSFWorkbook hssfWorkbook) {
        // 得到当前文件的总表数
        int sheetTotal = hssfWorkbook.getNumberOfSheets();

        // 接下来只对第3张表的第3行进行校验
        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(2);
        HSSFRow hssfRow = hssfSheet.getRow(2);
        try {
            // int也是一个对象，大括号结束后会释放掉
            int cellNo = 0;
            // 这里用一个大胆的做法，先执行函数再自加。虽然++i听说效率更高，但想必也高不到哪里去
            if (hssfRow.getCell(cellNo++).toString().equals("部门")
                    && hssfRow.getCell(cellNo++).toString().equals("工号")
                    && hssfRow.getCell(cellNo++).toString().equals("userId")
                    && hssfRow.getCell(cellNo++).toString().equals("姓名")
                    && hssfRow.getCell(cellNo++).toString().equals("考勤日期")
                    && hssfRow.getCell(cellNo++).toString().equals("考勤时间")
                    && hssfRow.getCell(cellNo++).toString().equals("打卡时间")
                    && hssfRow.getCell(cellNo++).toString().equals("打卡结果")
                    && hssfRow.getCell(cellNo++).toString().equals("打卡地址")
                    && hssfRow.getCell(cellNo++).toString().equals("是否外勤")
                    && hssfRow.getCell(cellNo++).toString().equals("备注")
                    && hssfRow.getCell(cellNo++).toString().equals("打卡图片1")
                    && hssfRow.getCell(cellNo++).toString().equals("打卡图片2")
                    && hssfRow.getCell(cellNo++).toString().equals("打卡设备")
                    && hssfRow.getCell(cellNo++).toString().equals("设备号")
                    ) {
                // 如果验证通过了，就打印成功信息（额，要不然什么都不做的话显得不太好= =）
                System.out.println("表头校验成功！通过校验的表格页数 = "+3);
            }
            else {
                return "第3张表的表头名称错误，与模板不相符";
            }
        } catch (NullPointerException e) {
            return "第3张表的表头名称错误，与模板不相符";
        }
        return "表头校验成功！";
    }
}
