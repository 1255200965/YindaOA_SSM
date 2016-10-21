package com.util;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * Created by baili on 16-10-20.
 */
public class ExcelToMysql {

    /**
     * 这个方法实现对表头的校验，返回false和抛出异常都表明失败
     * @param fileDir
     * @return
     * @throws IOException
     */
    public boolean checkFile(String fileDir) throws IOException {
        File file = new File(fileDir);
        InputStream is = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        XSSFRow xssfRow = xssfSheet.getRow(0);

        if (xssfRow.getCell(0).toString() != "员工号") return false;
        if (xssfRow.getCell(1).toString() != "姓名") return false;
        if (xssfRow.getCell(2).toString() != "部门") return false;
        if (xssfRow.getCell(3).toString() != "分公司") return false;
        if (xssfRow.getCell(4).toString() != "户籍") return false;
        if (xssfRow.getCell(5).toString() != "出生年月") return false;
        if (xssfRow.getCell(6).toString() != "年龄") return false;
        if (xssfRow.getCell(7).toString() != "民族") return false;
        if (xssfRow.getCell(8).toString() != "身份证号") return false;
        if (xssfRow.getCell(9).toString() != "性别") return false;
        if (xssfRow.getCell(10).toString() != "最新合同结束时间") return false;
        if (xssfRow.getCell(11).toString() != "毕业学校") return false;
        if (xssfRow.getCell(12).toString() != "最高学历") return false;
        if (xssfRow.getCell(13).toString() != "毕业时间") return false;
        if (xssfRow.getCell(14).toString() != "联系电话") return false;
        if (xssfRow.getCell(15).toString() != "邮箱") return false;
        if (xssfRow.getCell(16).toString() != "网元") return false;
        if (xssfRow.getCell(17).toString() != "技术等级") return false;
        if (xssfRow.getCell(18).toString() != "认证") return false;
        if (xssfRow.getCell(19).toString() != "合同类型") return false;
        if (xssfRow.getCell(20).toString() != "账号类型") return false;
        if (xssfRow.getCell(21).toString() != "账号状态") return false;
        if (xssfRow.getCell(22).toString() != "入职时间") return false;
        if (xssfRow.getCell(23).toString() != "工作年限") return false;
        if (xssfRow.getCell(24).toString() != "工资卡") return false;
        if (xssfRow.getCell(25).toString() != "报销卡") return false;
        if (xssfRow.getCell(26).toString() != "常驻地") return false;
        if (xssfRow.getCell(27).toString() != "签到地") return false;
        if (xssfRow.getCell(28).toString() != "WTR项目") return false;
        if (xssfRow.getCell(29).toString() != "WTR订单") return false;
        return true;
    }

    public void insert(String fileDir) throws IOException {
        File file = new File(fileDir);
        InputStream is = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        XSSFRow xssfRow = xssfSheet.getRow(0);

        for (int i=0; i<xssfRow.getRowNum(); i++) {
            xssfRow.getCell(0).toString();
        }
    }

}
