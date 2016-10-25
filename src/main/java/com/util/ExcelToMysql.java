package com.util;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
     */
    public Map<String, String> checkFile(String fileDir) throws IOException {
        Map<String, String> errorMap = new HashMap<String, String>();
        File file = new File(fileDir);
        InputStream is = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

        /*首先校验第一行，表头的信息*/
        XSSFRow xssfRow = xssfSheet.getRow(0);
        if (!((xssfRow.getCell(0).toString().equals("员工号"))
                && (xssfRow.getCell(1).toString().equals("姓名"))
                && (xssfRow.getCell(2).toString().equals("年龄"))
                && (xssfRow.getCell(3).toString().equals("性别"))
                && (xssfRow.getCell(4).toString().equals("联系电话"))
                && (xssfRow.getCell(5).toString().equals("邮箱"))
                && (xssfRow.getCell(6).toString().equals("身份证号"))
                && (xssfRow.getCell(7).toString().equals("户籍地址"))
                && (xssfRow.getCell(8).toString().equals("民族"))
                && (xssfRow.getCell(9).toString().equals("常住地址"))
                && (xssfRow.getCell(10).toString().equals("分公司"))
                && (xssfRow.getCell(11).toString().equals("部门"))
                && (xssfRow.getCell(12).toString().equals("签到地点"))
                && (xssfRow.getCell(13).toString().equals("入职日期"))
                && (xssfRow.getCell(14).toString().equals("合同类型"))
                && (xssfRow.getCell(15).toString().equals("最新合同起始日期"))
                && (xssfRow.getCell(16).toString().equals("最新合同结束日期"))
                && (xssfRow.getCell(17).toString().equals("工资卡"))
                && (xssfRow.getCell(18).toString().equals("报销卡"))
                && (xssfRow.getCell(19).toString().equals("员工状态"))
                && (xssfRow.getCell(20).toString().equals("毕业院校"))
                && (xssfRow.getCell(21).toString().equals("最高学历"))
                && (xssfRow.getCell(22).toString().equals("毕业日期"))
                && (xssfRow.getCell(23).toString().equals("网元"))
                && (xssfRow.getCell(24).toString().equals("技术等级"))
                && (xssfRow.getCell(25).toString().equals("认证单位"))
                && (xssfRow.getCell(26).toString().equals("账号类型"))
                && (xssfRow.getCell(27).toString().equals("账号状态"))
                && (xssfRow.getCell(28).toString().equals("WTR项目"))
                && (xssfRow.getCell(29).toString().equals("WTR订单")))) {
            errorMap.put("row", "表头");
            errorMap.put("column", "表头");
            errorMap.put("reason", "表头名称错误，与模板不相符");
            return errorMap;
        }

        /*然后校验剩余的行*/
        for (int i = 1; i <= xssfSheet.getLastRowNum(); i++) {
            xssfRow = xssfSheet.getRow(i);

            if (xssfRow.getCell(6) == null) {
                errorMap.put("row", i + 1 + "");
                errorMap.put("column", "7");
                errorMap.put("reason", "身份证号不能为空");
                return errorMap;
            }

            if (((xssfRow.getCell(0) != null) && (xssfRow.getCell(0).getCellType() != 0))
                    || ((xssfRow.getCell(2) != null) && (xssfRow.getCell(2).getCellType() != 0))
                    || ((xssfRow.getCell(4) != null) && (xssfRow.getCell(4).getCellType() != 0))
                    || ((xssfRow.getCell(6) != null) && (xssfRow.getCell(6).getCellType() != 0))
                    || ((xssfRow.getCell(13) != null) && (xssfRow.getCell(13).getCellType() != 0))
                    || ((xssfRow.getCell(15) != null) && (xssfRow.getCell(15).getCellType() != 0))
                    || ((xssfRow.getCell(16) != null) && (xssfRow.getCell(16).getCellType() != 0))
                    || ((xssfRow.getCell(17) != null) && (xssfRow.getCell(17).getCellType() != 0))
                    || ((xssfRow.getCell(18) != null) && (xssfRow.getCell(18).getCellType() != 0))
                    || ((xssfRow.getCell(22) != null) && (xssfRow.getCell(22).getCellType() != 0))
                    || ((xssfRow.getCell(24) != null) && (xssfRow.getCell(24).getCellType() != 0))) {
                errorMap.put("row", i + 1 + "");
                errorMap.put("column", "1,3,5,7,14,16,17,18,19,23,25中的一个或多个");
                errorMap.put("reason", "该单元格必须为数值型或日期型");
                return errorMap;
            }
        }
        return errorMap;
    }

}
