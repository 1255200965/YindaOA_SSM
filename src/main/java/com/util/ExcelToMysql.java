package com.util;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by baili on 16-10-20.
 */
public class ExcelToMysql {

    /**
     * 这个方法实现校验表格合法性，返回一个错误图
     * 简易校验，只判断单元格类型，不判断长度
     * 161027，由于发明了新技术，无需再校验单元格type
     */
    public Map<String, String> checkFile(String fileDir) throws IOException {
        Map<String, String> errorMap = new HashMap<String, String>();
        File file = new File(fileDir);
        InputStream is = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);

        /*首先校验第一行，表头的信息
        * 不相等或出现空指针异常皆视为校验失败*/
        HSSFRow hssfRow = hssfSheet.getRow(0);
        try {
            if (!((hssfRow.getCell(0).toString().equals("员工UserID"))
                    && (hssfRow.getCell(1).toString().equals("部门"))
                    && (hssfRow.getCell(2).toString().equals("职位"))
                    && (hssfRow.getCell(3).toString().equals("姓名"))
                    && (hssfRow.getCell(4).toString().equals("性别"))
                    && (hssfRow.getCell(5).toString().equals("工号"))
                    && (hssfRow.getCell(6).toString().equals("是否此部门主管(是/否)"))
                    && (hssfRow.getCell(7).toString().equals("手机号"))
                    && (hssfRow.getCell(8).toString().equals("邮箱"))
                    && (hssfRow.getCell(9).toString().equals("分机号"))
                    && (hssfRow.getCell(10).toString().equals("办公地点"))
                    && (hssfRow.getCell(11).toString().equals("备注"))
                    && (hssfRow.getCell(12).toString().equals("合同类型"))
                    && (hssfRow.getCell(13).toString().equals("音达认证"))
                    && (hssfRow.getCell(14).toString().equals("备注2"))
                    && (hssfRow.getCell(15).toString().equals("常驻地"))
                    && (hssfRow.getCell(16).toString().equals("社保地"))
                    && (hssfRow.getCell(17).toString().equals("分公司"))
                    && (hssfRow.getCell(18).toString().equals("户籍地"))
                    && (hssfRow.getCell(19).toString().equals("身份证号"))
                    && (hssfRow.getCell(20).toString().equals("网元"))
                    && (hssfRow.getCell(21).toString().equals("RSO认证"))
                    && (hssfRow.getCell(22).toString().equals("基本工资"))
                    && (hssfRow.getCell(23).toString().equals("项目工资"))
                    && (hssfRow.getCell(24).toString().equals("民族"))
                    && (hssfRow.getCell(25).toString().equals("年龄"))
                    && (hssfRow.getCell(26).toString().equals("最新合同"))
                    && (hssfRow.getCell(27).toString().equals("最新合同起始日期"))
                    && (hssfRow.getCell(28).toString().equals("最新合同结束日期"))
                    && (hssfRow.getCell(29).toString().equals("入职时间"))
                    && (hssfRow.getCell(30).toString().equals("工作年限"))
                    && (hssfRow.getCell(31).toString().equals("工资卡"))
                    && (hssfRow.getCell(32).toString().equals("毕业院校"))
                    && (hssfRow.getCell(33).toString().equals("最高学历"))
                    && (hssfRow.getCell(34).toString().equals("毕业日期"))
                    && (hssfRow.getCell(35).toString().equals("报销卡"))
                    && (hssfRow.getCell(36).toString().equals("项目"))
                    && (hssfRow.getCell(37).toString().equals("订单"))
                    && (hssfRow.getCell(38).toString().equals("员工状态"))
                    && (hssfRow.getCell(39).toString().equals("在职状态"))
                    && (hssfRow.getCell(40).toString().equals("离职日期")))) {
                errorMap.put("row", "表头");
                errorMap.put("column", "表头");
                errorMap.put("reason", "表头名称错误，与模板不相符");
                return errorMap;
            }
        } catch (NullPointerException npe) {
            errorMap.put("row", "表头");
            errorMap.put("column", "表头");
            errorMap.put("reason", "表头名称错误，与模板不相符");
            return errorMap;
        }

        /*然后校验剩余的行*/
        for (int i = 1; i <= hssfSheet.getLastRowNum(); i++) {
            hssfRow = hssfSheet.getRow(i);

            if (hssfRow.getCell(1) == null) {
                errorMap.put("row", i + 1 + "");
                errorMap.put("column", "2");
                errorMap.put("reason", "部门不能为空");
                return errorMap;
            }

            if (hssfRow.getCell(3) == null) {
                errorMap.put("row", i + 1 + "");
                errorMap.put("column", "5");
                errorMap.put("reason", "姓名不能为空");
                return errorMap;
            }

            if (hssfRow.getCell(7) == null) {
                errorMap.put("row", i + 1 + "");
                errorMap.put("column", "8");
                errorMap.put("reason", "手机号不能为空");
                return errorMap;
            }

            if (hssfRow.getCell(19) == null) {
                errorMap.put("row", i + 1 + "");
                errorMap.put("column", "20");
                errorMap.put("reason", "身份证号不能为空");
                return errorMap;
            }

            /*if (((hssfRow.getCell(0) != null) && (hssfRow.getCell(0).getCellType() != 0))
                    || ((hssfRow.getCell(5) != null) && (hssfRow.getCell(5).getCellType() != 0))
                    || ((hssfRow.getCell(7) != null) && (hssfRow.getCell(7).getCellType() != 0))
                    || ((hssfRow.getCell(9) != null) && (hssfRow.getCell(9).getCellType() != 0))
                    || ((hssfRow.getCell(16) != null) && (hssfRow.getCell(16).getCellType() != 0))
                    || ((hssfRow.getCell(22) != null) && (hssfRow.getCell(22).getCellType() != 0))
                    || ((hssfRow.getCell(23) != null) && (hssfRow.getCell(23).getCellType() != 0))
                    || ((hssfRow.getCell(25) != null) && (hssfRow.getCell(25).getCellType() != 0))
                    || ((hssfRow.getCell(27) != null) && (hssfRow.getCell(27).getCellType() != 0))
                    || ((hssfRow.getCell(28) != null) && (hssfRow.getCell(28).getCellType() != 0))
                    || ((hssfRow.getCell(29) != null) && (hssfRow.getCell(29).getCellType() != 0))
                    || ((hssfRow.getCell(30) != null) && (hssfRow.getCell(30).getCellType() != 0))
                    || ((hssfRow.getCell(31) != null) && (hssfRow.getCell(31).getCellType() != 0))
                    || ((hssfRow.getCell(34) != null) && (hssfRow.getCell(34).getCellType() != 0))
                    || ((hssfRow.getCell(35) != null) && (hssfRow.getCell(35).getCellType() != 0))
                    || ((hssfRow.getCell(40) != null) && (hssfRow.getCell(40).getCellType() != 0))) {
                errorMap.put("row", i + 1 + "");
                errorMap.put("column", "1,6,8,10,17,23,24,26,28,29,30,31,32,35,36,41中的一个或多个");
                errorMap.put("reason", "该单元格必须为数值型或日期型");
                return errorMap;
            }*/
        }
        return errorMap;
    }

}
