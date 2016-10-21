package com.controller;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

import com.model.UserInfo;
import com.util.ExcelToMysql;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;   // allow Spring injection
import org.springframework.stereotype.Controller;   // allow controller
import org.springframework.ui.Model;   // allow model
import org.springframework.web.bind.annotation.RequestMapping;   // allow map tag
import org.springframework.web.bind.annotation.RequestParam;   // allow using name to pass argument
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.UserDto;
import com.service.IUserInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ma on 2016/10/17.
 */
@Controller
@RequestMapping("/userinfo")
public class UserInfoController {
    @Resource
    private IUserInfoService userInfoService;

    @RequestMapping("/testMethod.do")
    public String getAllUser(Map<String,Object> map,HttpServletRequest request){
        List<UserInfo> userDtoList = new ArrayList<UserInfo>();
        //int index = Integer.parseInt(request.getParameter("index"));
        //int page = Integer.parseInt(request.getParameter("page"));
        int id = 0;
        if (request.getParameter("name")!= null) {
            id = Integer.parseInt(request.getParameter("name"));
        }
        userDtoList.add(userInfoService.selectUserByID(id));

        map.put("listUser", userDtoList);

        return "/UserInfo";
    }

    /**
     * 点击查询按钮后，根据输入框产生的实体类进行查询，页面不跳转
     * @param user
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> login(@RequestBody UserInfo user) throws IOException {
        //查询指定id，填充进map
        List<UserInfo> list = userInfoService.searchUserInfoByEntity(user);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("usertest",list);
        if(list.size() != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "查询结果为空");
        }
        return map;
    }

    @RequestMapping(value = "/adduser.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> adduser(@RequestBody UserInfo user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        int result = userInfoService.insertUser(user);
        if(result != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "失败");
        }
        return map;
    }
    @RequestMapping(value = "/updateuser.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateuser(@RequestBody UserInfo user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        int result = userInfoService.updateUserByID(user);
        if(result != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "失败");
        }
        return map;
    }

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
        if (xssfRow.getCell(2).toString() != "年龄") return false;
        if (xssfRow.getCell(3).toString() != "性别") return false;
        if (xssfRow.getCell(4).toString() != "联系电话") return false;
        if (xssfRow.getCell(5).toString() != "邮箱") return false;
        if (xssfRow.getCell(6).toString() != "身份证号") return false;
        if (xssfRow.getCell(7).toString() != "户籍地址") return false;
        if (xssfRow.getCell(8).toString() != "民族") return false;
        if (xssfRow.getCell(9).toString() != "常住地址") return false;
        if (xssfRow.getCell(10).toString() != "分公司") return false;
        if (xssfRow.getCell(11).toString() != "部门") return false;
        if (xssfRow.getCell(12).toString() != "签到地点") return false;
        if (xssfRow.getCell(13).toString() != "入职日期") return false;
        if (xssfRow.getCell(14).toString() != "合同类型") return false;
        if (xssfRow.getCell(15).toString() != "最新合同起始日期") return false;
        if (xssfRow.getCell(16).toString() != "最新合同结束日期") return false;
        if (xssfRow.getCell(17).toString() != "工资卡") return false;
        if (xssfRow.getCell(18).toString() != "报销卡") return false;
        if (xssfRow.getCell(19).toString() != "员工状态") return false;
        if (xssfRow.getCell(20).toString() != "毕业院校") return false;
        if (xssfRow.getCell(21).toString() != "最高学历") return false;
        if (xssfRow.getCell(22).toString() != "毕业日期") return false;
        if (xssfRow.getCell(23).toString() != "网元") return false;
        if (xssfRow.getCell(24).toString() != "技术等级") return false;
        if (xssfRow.getCell(25).toString() != "认证单位") return false;
        if (xssfRow.getCell(26).toString() != "账号类型") return false;
        if (xssfRow.getCell(27).toString() != "账号状态") return false;
        if (xssfRow.getCell(28).toString() != "WTR项目") return false;
        if (xssfRow.getCell(29).toString() != "WTR订单") return false;
        return true;
    }

}
