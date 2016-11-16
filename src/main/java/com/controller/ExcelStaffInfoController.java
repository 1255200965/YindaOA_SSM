package com.controller;

import com.model.StaffInfo;
import com.service.IExcelStaffInfoService;
import com.util.DateUtil;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ExcelStaffInfo")
public class ExcelStaffInfoController {

    @Autowired
    private IExcelStaffInfoService iExcelStaffInfoService;

    @RequestMapping("/navigator.do")
    public String navigator() {
        return "/upload";
    }

    /**
     * RequestParam中必须有值传进来，不然会报400错误。所以defaultValue是必须的！
     */
    @RequestMapping("/homePage.do")
    public String homePage( @RequestParam(value = "validateUpload", defaultValue = "") String validateUpload,
                            @RequestParam(value = "validateTitle", defaultValue = "") String validateTitle,
                            @RequestParam(value = "successAmount", defaultValue = "") String successAmount,
                            @RequestParam(value = "failAmount", defaultValue = "") String failAmount,
                            Model m) {
        m.addAttribute("validateUpload", validateUpload);
        m.addAttribute("validateTitle", validateTitle);
        m.addAttribute("successAmount", successAmount);
        m.addAttribute("failAmount", failAmount);
        return "/ImportUser";
    }

    /**
     * 下载按钮和选择文件按钮都直接在前端完成了功能，不需要来这里调方法
     * 只有上传文件按钮需要调用。该功能分两步，校验和导入
     */
    @RequestMapping(value = "/importExcel.do", method = RequestMethod.POST)
    public String importExcel( @RequestParam("fileUpload") MultipartFile fileUpload,
                               HttpServletRequest request, RedirectAttributes ra) {
        // 得到上传文件的原文件名
        String myFileName = fileUpload.getOriginalFilename();
        // 创建一个时间戳，用于给文件名添加一个唯一存在的后缀
        String time = DateUtil.getCurrentTimeMillis();
        // 用于保存的文件名
        String saveName = time + "_" + myFileName;
        // 保存路径，为根目录的路径加文件名。这里保存在根目录是因为存完就删
        // 注：通过ServletContext可以得到Webroot下任意文件夹的绝对路径
        String savePath = request.getSession().getServletContext().getRealPath("/") + saveName;

        // 开始将传进来的文件按照新路径转存
        try {
            fileUpload.transferTo(new File(savePath));
            ra.addAttribute("validateUpload", "文件上传成功！");
        } catch (IOException e) {
            // 异常要在这一步处理，不要再在方法中向上抛出了，因为到顶了。。
            ra.addAttribute("validateUpload", "文件上传失败，请检查联网状态");
            return "redirect:homePage.do";
        }

        //=========文件上传成功后处理excel
        try {
            // 第一步，校验文件，不合格会直接在页面抛出错误
            String validateTitle = iExcelStaffInfoService.validateExcelTitle(savePath);
            ra.addAttribute("validateTitle", validateTitle);
            if (validateTitle.contains("表头名称错误")) return "redirect:homePage.do";
            // 第二步，添加文件到数据库，会返回成功的数量和失败的列表
            Map<String, Object> mapInsert = iExcelStaffInfoService.insertAndUpdate(savePath);
            String successAmount = mapInsert.get("successAmount").toString();
            String successAmountPrint = "上传成功的条目数目为：" + successAmount;
            ra.addAttribute("successAmount", successAmountPrint);
            List<StaffInfo> listFail = (ArrayList<StaffInfo>)mapInsert.get("listFail");
            int failAmonutInt = listFail.size();
            String failAmountStr = String.valueOf(failAmonutInt);
            String failAmountPrint = "上传失败的条目数目为：" + failAmountStr;
            ra.addAttribute("failAmount", failAmountPrint);
        } catch (Exception e) {
            String amountPrint = e.toString();
            ra.addAttribute("successAmount", amountPrint);
        } finally {
            // 第三步，无论异常不异常，我都要把这个文件删除掉，因为已经创建成功了^_^
            // 161108人生第一次用finally，表示很激动！
            File fileDelete = new File(savePath);
            fileDelete.delete();
        }

        return "redirect:homePage.do";
    }

    @RequestMapping("export.do")
    public String export() {
        return "excel/staff_info_result_export";
    }

}
