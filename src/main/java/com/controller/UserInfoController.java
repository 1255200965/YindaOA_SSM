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
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
    private IUserInfoService userService;

    @RequestMapping("/testMethod.do")
    public String getAllUser(Map<String,Object> map,HttpServletRequest request){
        List<UserDto> userDtoList = new ArrayList<UserDto>();
        //int index = Integer.parseInt(request.getParameter("index"));
        //int page = Integer.parseInt(request.getParameter("page"));
        int id = 0;
        if (request.getParameter("name")!= null) {
            id = Integer.parseInt(request.getParameter("name"));
        }
        userDtoList.add(userService.selectUserByID(id));

        map.put("listUser", userDtoList);

        try {
            readL1();
        } catch (IOException e) {
            // 直接输出异常，帮助分析
            e.printStackTrace();
        }

        return "/UserInfo";
    }

    /**
     * 点击查询按钮后，根据输入框产生的实体类进行查询，页面不跳转
     * @param userInfo
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public Map<String,Object> login(UserInfo userInfo) throws IOException {
        List<UserInfo> list = userService.searchUserInfoByEntity(userInfo);
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
    public @ResponseBody Map<String,Object> adduser(@RequestBody UserDto user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        int result = userService.insertUser(user);
        if(result != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "失败");
        }
        return map;
    }
    @RequestMapping(value = "/updateuser.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateuser(@RequestBody UserDto user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        int result = userService.updateUserByID(user);
        if(result != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "失败");
        }
        return map;
    }

    void readL1() throws IOException{
        File file = new File("/home/baili/workspace/YindaOA_SSM/test.xls");
        InputStream is = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
        HSSFRow hssfRow = hssfSheet.getRow(2);
        String name = hssfRow.getCell(1).toString();
        System.out.println("My name is "+name);
    }
}
