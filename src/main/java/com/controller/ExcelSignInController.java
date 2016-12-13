package com.controller;

import com.model.YoAtteninfo;
import com.service.IExcelSignInService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ExcelSignIn")
public class ExcelSignInController {

    @Autowired
    private IExcelSignInService iExcelSignInService;

    /*
    打开主页
     */
    @RequestMapping("/homePage.do")
    public String homePage( @RequestParam(value = "validateUpload", defaultValue = "") String validateUpload,
                            @RequestParam(value = "validateTitle", defaultValue = "") String validateTitle,
                            Model m) {
        m.addAttribute("validateUpload", validateUpload);
        m.addAttribute("validateTitle", validateTitle);
        return "excel/sign_in";
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

        // 第3步，添加文件到数据库
        Date dateBegin = new Date();
        Map<String, Object> mapInsert = iExcelSignInService.insertAndUpdate(hssfWorkbook);
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

        return "excel/sign_in_import";
    }

}
