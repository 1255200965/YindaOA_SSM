package com.util;

import com.alibaba.fastjson.JSONObject;
import com.ddSdk.auth.AuthHelper;
import com.ddSdk.user.UserHelper;
import com.ddSdk.utils.FileUtils;
import com.dingtalk.open.client.ServiceFactory;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.dingtalk.open.client.api.model.corp.CorpUserList;
import com.dingtalk.open.client.api.service.corp.CorpUserService;
import com.model.StaffInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ma on 2016/10/26.
 */
public class DDUtil {

    public static String jsapiTicket = null;
    public static String accessToken = null;

    public String getAccessToken(){
        try {
            if (accessToken == null) {
                accessToken = AuthHelper.getAccessToken();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return accessToken;
    }

    /**
     * 先定一个小目标，通过部门id，得到创新部的所有成员
     */
    public CorpUserList getAllDepartMem(
            String accessToken,
            long departmentId,
            Long offset,
            Integer size,
            String order)
            throws Exception {

        CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
        return corpUserService.getCorpUserSimpleList(accessToken, departmentId,
                offset, size, order);
    }

//    public static String createUser(StaffInfo user){
//        String result = null;
//        try {
//            CorpUserDetail userDetail = ChangeToDD(user);
//            CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
//            //获取部门id
//            Map<Long, Long> orderInDepts = new HashMap<Long, Long>();
//            orderInDepts.put((long)orderInDepts.size(),Long.parseLong(user.getDepartment()));
//            //获取userid
//            result = corpUserService.createCorpUser(getAccessToken(), userDetail.getUserid(), userDetail.getName(), orderInDepts,
//                    userDetail.getDepartment(), userDetail.getPosition(), userDetail.getMobile(), userDetail.getTel(), userDetail.getWorkPlace(),
//                    userDetail.getRemark(), userDetail.getEmail(), userDetail.getJobnumber(),
//                    userDetail.getIsHide(), userDetail.getSenior(), userDetail.getExtattr());
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return result;
//       /* {
//            "errcode": 0,
//                "errmsg": "created",
//                "userid": "dedwefewfwe1231"
//        }*/
//    }
    public static String updateUser(StaffInfo user){
        String result = null;
        try {
            CorpUserDetail userDetail = ChangeToDD(user);

            CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
            JSONObject js = (JSONObject) JSONObject.parse(userDetail.getOrderInDepts());
            Map<Long, Long> orderInDepts = FileUtils.toHashMap(js);

            result = corpUserService.updateCorpUser(accessToken, userDetail.getUserid(), userDetail.getName(), orderInDepts,
                    userDetail.getDepartment(), userDetail.getPosition(), userDetail.getMobile(), userDetail.getTel(), userDetail.getWorkPlace(),
                    userDetail.getRemark(), userDetail.getEmail(), userDetail.getJobnumber(),
                    userDetail.getIsHide(), userDetail.getSenior(), userDetail.getExtattr());
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
        /*{
            "errcode": 0,
            "errmsg": "updated"
         }*/
    }
    public static CorpUserDetail deleteUser(StaffInfo user){
        CorpUserDetail result = null;
        try {
            CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
            result = corpUserService.deleteCorpUser(accessToken, user.getStaffUserId());
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
        /*{
            "errcode": 0,
            "errmsg": "deleted"
        }*/
    }
//    public static StaffInfo getUserByID(String userid){
//        StaffInfo user = null;
//        try {
//            CorpUserDetail dduser = UserHelper.getUser(getAccessToken(), userid);
//            user = ChangeToLocal(dduser);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return user;
//    }

    //转换成本地用户类
    public static StaffInfo ChangeToLocal(CorpUserDetail user){
        StaffInfo result = new StaffInfo();
        result.setName(user.getName());
        result.setCellphone(user.getMobile());
        result.setEmail(user.getEmail());
        result.setStaffUserId(user.getDingId());
        result.setStaffId(user.getJobnumber());
        //部门
        result.setDepartment(user.getDepartment().get(0).toString());
        return result;
    }
    //转换成钉钉用户类
    public static CorpUserDetail ChangeToDD(StaffInfo user){
        CorpUserDetail result = new CorpUserDetail();
        result.setName(user.getName());
        result.setJobnumber(user.getStaffId());
        result.setMobile(user.getCellphone());
        //部门
        //result.setDepartment(user.getDepartment());
        return result;
    }
}
