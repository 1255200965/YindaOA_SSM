package com.controller;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

import com.model.StaffInfo;
import com.service.IStaffInfoService;
import com.util.DateUtil;
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
import org.springframework.web.bind.annotation.RequestMapping;   // allow map tag

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ma on 2016/10/17.
 */
@Controller
@RequestMapping("/userinfo")
public class StaffInfoController {
    @Resource
    private IStaffInfoService userInfoService;

    @RequestMapping("/testMethod.do")
    public String getAllUser(HttpServletRequest request) throws IOException {

        // 添加文件到数据库
/*        String path = "/home/baili/Documents/yindaTech/007.xlsx";
        Map<String, Object> map = userInfoService.insert(path);
        Object obj = map.get("listFail");
        List<StaffInfo> list = (List<StaffInfo>)obj;
        System.out.println(map.get("successAmount"));
        System.out.println(list.size());
        for (int i=0; i<list.size(); i++) {
            String string = list.get(i).getStffId();
            System.out.println(string);
        }*/
        return "/UserInfo";
    }

    @RequestMapping("/import.do")
    public String ImportUser(Map<String,Object> map,HttpServletRequest request){
        List<StaffInfo> userDtoList = new ArrayList<StaffInfo>();

        map.put("listUser", userDtoList);
        return "/ImportUser";
    }
    @RequestMapping("/importMethod.do")
    public ModelAndView upload2(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
        Map<String,Object> map = new HashMap<String,Object>();
        List<String> filelist = new ArrayList<String>();
        try {
            String tab = request.getParameter("tab");
            String fileans = "";
            map.put("tab",tab);
            //创建一个通用的多部分解析器
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            //判断 request 是否有文件上传,即多部分请求
            if (multipartResolver.isMultipart(request)) {
                //转换成多部分request
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                //取得request中的所有文件名
                Iterator<String> iter = multiRequest.getFileNames();
                while (iter.hasNext()) {
                    //记录上传过程起始时的时间，用来计算上传时间
                    int pre = (int) System.currentTimeMillis();
                    //取得上传文件
                    MultipartFile file = multiRequest.getFile(iter.next());
                    if (file != null) {
                        //取得当前上传文件的文件名称
                        String myFileName = file.getOriginalFilename();
                        //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                        if (myFileName.trim() != "") {
                            System.out.println(myFileName);
                            String time = DateUtil.getCurrentTimeMillis();
                            //重命名上传后的文件名
                            String fileName = time + "_" + file.getOriginalFilename();
                            //定义上传路径
                            //String path = "H:/" + fileName;
                            String path = request.getSession().getServletContext().getRealPath("upload/") + "/" +fileName;
                            File localFile = new File(path);
                            //创建失败
                            if (!localFile.exists()&&!localFile.isDirectory()){
                                localFile.mkdir();
                            }
                            file.transferTo(localFile);
                            filelist.add(path);
                            fileans += file.getOriginalFilename() + "<br/>";
                        }
                    }
                    //记录上传该文件后的时间
                    int finaltime = (int) System.currentTimeMillis();
                    System.out.println(finaltime - pre);
                }
            }

            //=========导入成功后处理excel
            for (String path:filelist){
                ExcelToMysql excelToMysql = new ExcelToMysql();
                Map<String, String> errorMap = excelToMysql.checkFile(path);

                if (errorMap.isEmpty()) {
                    map.put("validate","文件验证通过！");
                } else {
                    map.putAll(errorMap);
                    break;
                }
                // 添加文件到数据库
                Map<String, Object> map2 = userInfoService.insert(path);
                map.putAll(map2);
            }

            map.put("filename",fileans);
        }catch (Exception e)
        {
            e.printStackTrace();
            map.put("error",e.toString());
        }
        return new ModelAndView("/ImportUser",map);
    }

    /**
     * 点击查询按钮后，根据输入框产生的实体类进行查询，页面不跳转
     * @param user
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> login1(@RequestBody StaffInfo user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询指定id，填充进map
        List<StaffInfo> list = userInfoService.searchStaffInfoByEntity(user);
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
    public @ResponseBody Map<String,Object> adduser(@RequestBody StaffInfo user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        int result = userInfoService.insertStaff(user);
        if(result != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "失败");
        }
        return map;
    }

    @RequestMapping(value = "/updateuser.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateuser(@RequestBody StaffInfo user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        int result = userInfoService.updateStaffByID(user);
        if(result != 0){
            map.put("msg", "成功");
        }else{
            map.put("msg", "失败");
        }
        return map;
    }

}
