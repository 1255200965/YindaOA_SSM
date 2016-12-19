package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.model.StaffInfo;
import com.model.YoAttendance;
import com.service.IAttendanceService;
import com.service.IStaffInfoService;
import com.util.AttendanceWork;
import com.util.DDUtil;
import com.util.DateUtil;
import com.util.ExcelToMysql;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

/**
 * Created by ma on 2016/10/17.
 */
@Controller
@RequestMapping("/userinfo")
public class StaffInfoController {
    @Resource
    private IStaffInfoService userInfoService;

    @Resource
    private IAttendanceService iAttendanceService;

    @RequestMapping("/testMethod.do")
    public String getAllUser(HttpServletRequest request) throws IOException {
//        DDUtil ddUtil = new DDUtil();
//        try {
//            List<CorpUserDetail> list = ddUtil.getAllDepartMem(15111);
//            CorpUserDetail corpUserDetailLLR = list.get(3);
//            StaffInfo staffInfoLLR = ddUtil.ChangeToLocal(corpUserDetailLLR);
//            System.out.println("okc的电话号码是"+staffInfoLLR.getCellphone());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return "/UserInfo";
    }

/*    @RequestMapping("/import.do")
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
                    continue;
                }
                // 添加文件到数据库
                Map<String, Object> map2 = userInfoService.insertAndUpdate(path);
                map.putAll(map2);
            }

            map.put("filename",fileans);
        }catch (Exception e)
        {
            e.printStackTrace();
            map.put("error",e.toString());
        }
        return new ModelAndView("/ImportUser",map);
    }*/

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
    //根据条件查询所有员工信息
    @RequestMapping(value = "/query.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> query1(@RequestBody StaffInfo stu, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<StaffInfo> list = userInfoService.selectStaffInfo(stu);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userlist", list);
        if (list.size() != 0) {
            map.put("msg", "成功");
        } else {
            map.put("msg", "查询结果为空");
        }
        return map;
    }


    //修改用户信息
    @RequestMapping(value = "/updateuser.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateuser(@RequestBody StaffInfo user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        //钉钉侧修改
        DDUtil ddutil = new DDUtil(userInfoService);
        String DDresult = ddutil.updateUser(user);
        if (DDresult != null){
            map.put("msg", DDresult);
            return map;
        }
        int result = userInfoService.updateStaffByID(user);
        if(result != 0){
            map.put("msg", "更新成功");
            map.put("ok", "ok");
        }else{
            map.put("msg", "更新失败");
        }
        return map;
    }

    //删除用户信息
    @RequestMapping(value = "/delete.do", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> delete(@RequestBody StaffInfo user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();
        user.setWorkState("离职");
        user.setLeaveDate(DateUtil.getCurrentTimeDate().toString());
        //钉钉侧删除
        DDUtil ddutil = new DDUtil(userInfoService);
        String DDresult = ddutil.deleteUser(user);
        if (DDresult != null){
            map.put("msg", DDresult);
            return map;
        }
        int result = userInfoService.updateStaffByID(user);
        if(result != 0){
            map.put("msg", "离职成功");
            map.put("ok", "ok");
        }else{
            map.put("msg", "离职失败");
        }
        return map;
    }


    @RequestMapping("/test.do")
    public String test(Map<String,Object> map,HttpServletRequest request){
        List<StaffInfo> userDtoList = new ArrayList<StaffInfo>();
        map.put("listUser", userDtoList);
        return "/UserSalary";
    }

    @RequestMapping("/querys.do")
    public String querys(Map<String,Object> map,HttpServletRequest request){
        List<StaffInfo> userDtoList = new ArrayList<StaffInfo>();
        map.put("listUser", userDtoList);
        return "/UserInfoSalary";
    }

    @RequestMapping("/test22.do")
    public String testd(Map<String,Object> map,HttpServletRequest request){

        return "/UserSalary";
    }




//    剪切下来的一部分在test.do后面，从服务器获取数据，并且做好记录
/*测试的数据，从钉钉里面取出json数据，然后将它保存到数据库中*/
    //测试一条数据
/*    @RequestMapping("/test55.do")
    public String test(HttpServletRequest request) throws IOException {
        DDUtil ddUtil=new DDUtil(userInfoService);
        AttendanceWork ddUtil2 = new AttendanceWork();
        //我要先查出StaffInfo里面的所有id
        List<StaffInfo> listAll = userInfoService.selectAllUser();
        List<String> userlistIds=new ArrayList<String>();
        for (StaffInfo staffInfos:listAll){
            if(null!=staffInfos.getStaffUserId() &&  !staffInfos.getStaffUserId().isEmpty()){
                userlistIds.add(staffInfos.getStaffUserId());
            }
        }
        try {
//            StaffInfo staffInfo=new StaffInfo();
//            staffInfo.getStaffUserId();
//            List<StaffInfo> ids=new  ArrayList<StaffInfo>();
//            List<StaffInfo> list = userInfoService.seletecId();
            ///我想将这个01002626191049(数据库的id),变成一个集合，就是一张表里面的全部id,怎么弄
//            "2016-10-15 01：00：00","2016-10-21 00：00：00"
//            "2016-10-22 01：00：00","2016-10-28 00：00：00"
//            "2016-10-29 01：00：00","2016-11-04 00：00：00"
//            "2016-11-05 01：00：00","2016-11-11 00：00：00"
//            "2016-11-12 01：00：00","2016-11-19 00：00：00"

            //"2016-10-15 00:00:00", "2016-10-21 00:00:00",
            //"2016-10-21 01:00:00", "2016-10-28 00:00:00",
            //"2016-10-28 01:00:00", "2016-11-03 00:00:00",
            for(int i=0;i<userlistIds.size();i++) {
                String result = ddUtil2.getSuiteToken(userlistIds.get(i), "2016-11-10 01:00:00", "2016-11-12 00:00:00", ddUtil.getAccessToken());
                if (null == result || result.isEmpty()) {
                    continue;
                }
                System.out.println("开始存放数据============================");
                saveAttendance(result);
                Thread.sleep(5000);
                System.out.println("暂停存放数据============================");
            }
            System.out.println(">>>>>>>>>>>>>SUCCESS>>>>>存放批量数据结束=========================");
        } catch (Exception e) {

        }
        return "/UserInfo";
    }*/


    //从服务解析出来的json
    public  void saveAttendance(String result) {
        //我要将0100变成一个集合，就是一张表里的所有id
        JSONObject ob = JSONObject.parseObject(result);
        JSONObject thwb = null;
        List<YoAttendance> record = null;
        YoAttendance yoAttendance = null;
        JSONArray lists = ob.getJSONArray("recordresult");
        System.out.println(">>>刷数据，刷数据>>>>>>>> >>>>>>>" + lists.size());
        if (null != lists || lists.size() > 0)
            for (int j = 0; j < lists.size(); j++) {
                yoAttendance = new YoAttendance();
                thwb = (JSONObject) lists.get(j);
                yoAttendance.setCorpid(thwb.getString("corpId"));
                yoAttendance.setId(thwb.getInteger("id") + "");
                yoAttendance.setBasechecktime(thwb.getTimestamp("baseCheckTime"));
                yoAttendance.setChecktype(thwb.getString("checkType"));
                yoAttendance.setGroupid(thwb.getInteger("groupId") + "");
                yoAttendance.setLocationresult(thwb.getString("locationResult"));
                yoAttendance.setPlanid(thwb.getInteger("planId") + "");
                yoAttendance.setRecordid(thwb.getInteger("recordId") + "");
                yoAttendance.setTimeresult(thwb.getString("timeResult"));
                yoAttendance.setUserchecktime(thwb.getTimestamp("userCheckTime"));
                yoAttendance.setUserid(thwb.getString("userId") + "");
                yoAttendance.setWorkdate(thwb.getTimestamp("workDate"));
                System.out.println(">>>>>>>>>>哦咯> >>>>>>>" + yoAttendance.toString());
                try {
                    iAttendanceService.insertAttend(yoAttendance);
                } catch (Exception e) {
                    System.out.print("主键唯一约束");
                }
            }
        }



}
