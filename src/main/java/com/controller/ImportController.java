package com.controller;

import com.service.IImportService;
import com.util.DateUtil;
import com.util.ExcelToMysql;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/Import")
public class ImportController {
    @Resource
    private IImportService importService;

    @RequestMapping("/navigator.do")
    public String navigator(HttpServletRequest request) throws IOException {
        return "/upload";
    }

    @RequestMapping("/importOvertimeHome.do")
    public String importOvertimeHome(HttpServletRequest request) throws IOException {
        return "/upload-jiaban";
    }

    @RequestMapping("/importBusinessTripHome.do")
    public String importBusinessTripHome(HttpServletRequest request) throws IOException {
        return "/upload-chuchai";
    }

    @RequestMapping("/importSubwayHome.do")
    public String importSubwayHome(HttpServletRequest request) throws IOException {
        return "/upload-jiaotong";
    }

    @RequestMapping("/importItemChangeHome.do")
    public String importItemChangeHome(HttpServletRequest request) throws IOException {
        return "/upload-project";
    }

    @RequestMapping("/importYindaIdentifyHome.do")
    public String importYindaIdentifyHome(HttpServletRequest request) throws IOException {
        return "/upload-renzheng";
    }

    @RequestMapping("/AskLeaveHome.do")
    public String askLeaveHome(HttpServletRequest request){
        return "askLeaveHome";
    }

    /**
     * 下载按钮和选择文件按钮都直接在前端完成了功能，不需要来这里调方法
     * 只有上传文件按钮需要调用。该功能分两步，校验和导入
     */
    @RequestMapping("/ImportAskLeave.do")
    public ModelAndView importAskLeave(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
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
                            System.out.println("当前要上传文件的文件名 = "+myFileName);
                            String time = DateUtil.getCurrentTimeMillis();
                            //重命名上传后的文件名
                            String fileName = time + "_" + file.getOriginalFilename();
                            //定义上传路径
                            String path = request.getSession().getServletContext().getRealPath("upload/") + "/" +fileName;
                            File localFile = new File(path);
                            // 如果创建失败
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
                    int timeCost = finaltime - pre;
                    System.out.println("上传该文件到服务端所使用的秒数 = "+timeCost);
                }
            }
            // 把你放到上面去！
            map.put("filename",fileans);

            //=========文件上传成功后处理excel
            for (String path:filelist){
                ExcelToMysql excelToMysql = new ExcelToMysql();
                // 第一步，校验文件，不合格会直接在页面抛出错误
                Map<String, String> errorMap = excelToMysql.checkAskLeaveExcel(path);
                if (errorMap.isEmpty()) {
                    map.put("validate","文件验证通过！");
                } else {
                    map.putAll(errorMap);
                    break;
                }
                // 第二步，添加文件到数据库，会返回成功的数量和失败的列表
                Map<String, Object> map2 = importService.insertAskLeave(path);
                map.putAll(map2);
                // 第三步，把刚才创建的excel文件删除掉
                File fileDelete = new File(path);
                fileDelete.delete();
            }

        } catch (Exception e) {
            e.printStackTrace();
            map.put("error",e.toString());
        }
        return new ModelAndView("/askLeaveHome",map);
    }

}
