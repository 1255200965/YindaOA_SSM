package com.controller;

import com.model.StaffInfo;
import com.service.IExcelStaffInfoService;
import com.util.DateUtil;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
    public String export(Model model) {
        // 第1步，得到开始导出的时间
        Date dateBegin = new Date();

        // 第2步，向页面发送导出数据表的名称
        model.addAttribute("tableName", "staff_info");

        // 第3步，创建一个列的集合，用于创建表头
        List<String> listColumnNames = createColumnNames();

        // 第4步，向页面输出列的总数
        int columnAmount = listColumnNames.size();
        model.addAttribute("columnAmount", columnAmount);

        // 第5步，创建Excel工作表对象，并向第1行输出表头
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        HSSFSheet hssfSheet = hssfWorkbook.createSheet();
        HSSFRow row = hssfSheet.createRow(0);
        row.setHeight((short)800);
        hssfSheet = setColumnWidth(hssfSheet);
        for (int i=0; i<columnAmount; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(listColumnNames.get(i));
        }

        // 第6步，从后台得到要导出的源数据
        List<StaffInfo> listAllStaff = iExcelStaffInfoService.getAllStaff();

        // 第7步，果断向页面发送成功导出的项目数，因为不可能失败
        model.addAttribute("successAmount", listAllStaff.size());

        // 第8步，将后台得到的每一条数据输出到Excel表的剩余部分
        for (int i=0; i<listAllStaff.size(); i++) {
            // 先从实体类集合中得到实体类
            StaffInfo staffInfo = listAllStaff.get(i);
            // 把实体类中的数据转换成一个多元素的列表
            List<String> listRowContent = getRowContent(staffInfo);
            row = hssfSheet.createRow(i+1);
            row.setHeight((short)400);
            // 把列表中的元素对应添加到新创建的cell中
            for (int j=0; j<columnAmount; j++) {
                HSSFCell cell = row.createCell(j);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(listRowContent.get(j));
            }
        }

        // 第9步，设定输出文件路径，并添加到页面
        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
        String desktopPath = desktopDir.getPath();
        String path = desktopPath + "\\花名册导出.xls";
        model.addAttribute("path", path);



        // 第10步，发动总攻，把已经制作好的workbook输出到路径
        try {
            // 对于Excel文件要用文件流，不能用FileWriter
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            hssfWorkbook.write(fileOutputStream);
            // 写完要关闭，不然文件被锁定，开Excel不能更改
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        // 第11步，计算导出时间并输出到页面
        Date dateEnd = new Date();
        long interval = dateEnd.getTime() - dateBegin.getTime();
        long minute = interval / 1000 / 60;
        long second = (interval - minute * 60) / 1000;
        model.addAttribute("cost", minute+"分"+second+"秒");

        return "excel/staff_info_result_export";
    }

    /**
     * 得到表头集合列表
     * 如果List中的元素类型可以统一，为了安全，最好添加泛型
     * 由于字段数量还在一个可以忍受的范围内，所以就先用ArrayList一行一行添加了
     */
    public List<String> createColumnNames() {
        List<String> columnNames = new ArrayList();
        columnNames.add("员工UserID");
        columnNames.add("部门");
        columnNames.add("职位");
        columnNames.add("姓名");
        columnNames.add("性别");
        columnNames.add("工号");
        columnNames.add("是否此部门主管(是/否)");
        columnNames.add("手机号");
        columnNames.add("邮箱");
        columnNames.add("分机号");
        columnNames.add("办公地点");
        columnNames.add("备注");
        columnNames.add("合同类型");
        columnNames.add("音达认证");
        columnNames.add("网元");
        columnNames.add("备注2");
        columnNames.add("身份证号");
        columnNames.add("户籍地");
        columnNames.add("分公司");
        columnNames.add("社保地");
        columnNames.add("常驻地");
        columnNames.add("RSO认证");
        columnNames.add("基本工资");
        columnNames.add("项目工资");
        columnNames.add("民族");
        columnNames.add("年龄");
        columnNames.add("最新合同");
        columnNames.add("最新合同起始日期");
        columnNames.add("最新合同结束日期");
        columnNames.add("入职时间");
        columnNames.add("工作年限");
        columnNames.add("工资卡");
        columnNames.add("毕业院校");
        columnNames.add("最高学历");
        columnNames.add("毕业日期");
        columnNames.add("报销卡");
        columnNames.add("项目");
        columnNames.add("订单");
        columnNames.add("员工状态");
        columnNames.add("在职状态");
        columnNames.add("离职日期");
        return columnNames;
    }

    /**
     * 生成填充内容的数据集
     */
    public List<String> getRowContent(StaffInfo staffInfo) {
        List<String> rowContents = new ArrayList();
        rowContents.add(staffInfo.getStaffUserId());
        rowContents.add(staffInfo.getDepartment());
        rowContents.add(staffInfo.getPosition());
        rowContents.add(staffInfo.getName());
        rowContents.add(staffInfo.getSex());
        rowContents.add(staffInfo.getStaffId());
        rowContents.add(staffInfo.getWhetherLeader());
        rowContents.add(staffInfo.getCellphone());
        rowContents.add(staffInfo.getEmail());
        rowContents.add(staffInfo.getBranchPhone());
        rowContents.add(staffInfo.getWorkAddress());
        rowContents.add(staffInfo.getComment1());
        rowContents.add(staffInfo.getContractType());
        rowContents.add(staffInfo.getYindaIdentify());
        rowContents.add(staffInfo.getNetUnit());
        rowContents.add(staffInfo.getComment2());
        rowContents.add(staffInfo.getIdNo());
        rowContents.add(staffInfo.getHouseholdAddress());
        rowContents.add(staffInfo.getBranchCompany());
        rowContents.add(staffInfo.getSocialSecurityAddress());
        rowContents.add(staffInfo.getOrdinaryAddress());
        rowContents.add(staffInfo.getRsoIdentify());
        rowContents.add(staffInfo.getBaseSalary());
        rowContents.add(staffInfo.getItemSalary());
        rowContents.add(staffInfo.getNation());
        rowContents.add(staffInfo.getAge());
        rowContents.add(staffInfo.getLastContract());
        rowContents.add(staffInfo.getLastContractBegin());
        rowContents.add(staffInfo.getLastContractEnd());
        rowContents.add(staffInfo.getEnterTime());
        rowContents.add(staffInfo.getWorkYear());
        rowContents.add(staffInfo.getSalaryCard());
        rowContents.add(staffInfo.getGraduateSchool());
        rowContents.add(staffInfo.getSchoolRecord());
        rowContents.add(staffInfo.getGraduateDate());
        rowContents.add(staffInfo.getExpenseCard());
        rowContents.add(staffInfo.getItem());
        rowContents.add(staffInfo.getYoOrder());
        rowContents.add(staffInfo.getStaffState());
        rowContents.add(staffInfo.getWorkState());
        rowContents.add(staffInfo.getLeaveDate());
        return rowContents;
    }

    public HSSFSheet setColumnWidth(HSSFSheet hssfSheet) {
        hssfSheet.setColumnWidth(0, 6000);
        hssfSheet.setColumnWidth(1, 6000);
        hssfSheet.setColumnWidth(2, 4000);
        hssfSheet.setColumnWidth(5, 3000);
        hssfSheet.setColumnWidth(6, 5000);
        hssfSheet.setColumnWidth(7, 4000);
        hssfSheet.setColumnWidth(8, 7000);
        hssfSheet.setColumnWidth(11, 7000);
        hssfSheet.setColumnWidth(14, 4000);
        hssfSheet.setColumnWidth(16, 6000);
        hssfSheet.setColumnWidth(17, 4000);
        hssfSheet.setColumnWidth(21, 14000);
        hssfSheet.setColumnWidth(25, 4000);
        hssfSheet.setColumnWidth(27, 4000);
        hssfSheet.setColumnWidth(28, 4000);
        hssfSheet.setColumnWidth(29, 4000);
        hssfSheet.setColumnWidth(32, 9000);
        hssfSheet.setColumnWidth(40, 5000);
        return hssfSheet;
    }

}
