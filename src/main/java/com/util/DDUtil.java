package com.util;

import com.alibaba.fastjson.JSONObject;
import com.dao.DepartmentMapper;
import com.ddSdk.auth.AuthHelper;
import com.ddSdk.base.Env;
import com.ddSdk.base.OApiException;
import com.ddSdk.user.UserHelper;
import com.ddSdk.utils.FileUtils;
import com.ddSdk.utils.HttpHelper;
import com.dingtalk.open.client.ServiceFactory;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.dingtalk.open.client.api.model.corp.CorpUserDetailList;
import com.dingtalk.open.client.api.service.corp.CorpUserService;
import com.model.Department;
import com.model.DepartmentExample;
import com.model.StaffInfo;
import com.service.IStaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ma on 2016/10/26.
 */
public class DDUtil {

    private IStaffInfoService userInfoService;

    public static String jsapiTicket = null;
    public static String accessToken = null;

    public DDUtil(IStaffInfoService service){
        userInfoService = service;
    }
    public String getAccessToken(){
        try {
            accessToken = AuthHelper.getAccessToken();
        } catch (Exception e){
            e.printStackTrace();
        }
        return accessToken;
    }

    /**
     * 获取部门成员（详情）
     * 分页设置暂时全部设为null，token直接从本方法中获得，不要再传到controller
     * departmentId原本为long型，这里为了方便用户，设为int类型
     */
    public List<CorpUserDetail> getAllDepartMem(int departmentId) throws Exception {
        String accessToken = getAccessToken();
        Long offset = null;
        Integer size = null;
        String order = null;
        CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
        CorpUserDetailList corpUserDetailList = corpUserService.getCorpUserList(accessToken, departmentId, offset, size, order);
        List<CorpUserDetail> userDetailList = corpUserDetailList.getUserlist();
        return userDetailList;
    }

    public String createUser(StaffInfo user){
        String result = null;
        try {
            CorpUserDetail userDetail = this.ChangeToDD(user);
            CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
            //获取部门id
            Map<Long, Long> orderInDepts = new HashMap<Long, Long>();
            orderInDepts.put((long)orderInDepts.size(),userDetail.getDepartment().get(0));
            //获取userid
            result = corpUserService.createCorpUser(getAccessToken(), userDetail.getUserid(), userDetail.getName(), null,
                    userDetail.getDepartment(), userDetail.getPosition(), userDetail.getMobile(), userDetail.getTel(), userDetail.getWorkPlace(),
                    userDetail.getRemark(), userDetail.getEmail(), userDetail.getJobnumber(),
                    userDetail.getIsHide(), userDetail.getSenior(), userDetail.getExtattr());
        } catch (Exception e){
            //return e.getMessage();
            e.printStackTrace();
        }
        return result;
    }

    public String updateUser(StaffInfo user){
        String result = null;
        try {
            CorpUserDetail userDetail = this.ChangeToDD(user);

            CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
            JSONObject js = (JSONObject) JSONObject.parse(userDetail.getOrderInDepts());
            Map<Long, Long> orderInDepts = FileUtils.toHashMap(js);

            result = corpUserService.updateCorpUser(getAccessToken(), userDetail.getDingId(), userDetail.getName(), null,
                    userDetail.getDepartment(), userDetail.getPosition(), userDetail.getMobile(), userDetail.getTel(), userDetail.getWorkPlace(),
                    userDetail.getRemark(), userDetail.getEmail(), userDetail.getJobnumber(),
                    userDetail.getIsHide(), userDetail.getSenior(), userDetail.getExtattr());
        } catch (Exception e){
            return e.getMessage();
            //e.printStackTrace();
        }
        return null;
        /*{
            "errcode": 0,
            "errmsg": "updated"
         }*/
    }
    public String deleteUser(StaffInfo user){
        CorpUserDetail result = null;
        try {
            CorpUserService corpUserService = ServiceFactory.getInstance().getOpenService(CorpUserService.class);
            result = corpUserService.deleteCorpUser(getAccessToken(), user.getStaffUserId());
        } catch (Exception e){
            return e.getMessage();
            //e.printStackTrace();
        }
        return null;
        /*{
            "errcode": 0,
            "errmsg": "deleted"
        }*/
    }

    public StaffInfo getUserByID(String userid){
        StaffInfo user = null;
        try {
            CorpUserDetail dduser = UserHelper.getUser(getAccessToken(), userid);
            user = ChangeToLocal(dduser);
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 输入一个我们数据库的StaffInfo实体类，输出一个钉钉数据库实体类
     * 目前只考虑单一部门的情况
     * 该方法目测不会发生空指针异常
     * @param user
     * @return
     */
    public CorpUserDetail ChangeToDD(StaffInfo user){
        CorpUserDetail corpUserDetail = new CorpUserDetail();
        corpUserDetail.setDingId(user.getStaffUserId());
        corpUserDetail.setPosition((user.getPosition()));
        corpUserDetail.setName(user.getName());
        corpUserDetail.setTel(user.getBranchPhone());
        corpUserDetail.setWorkPlace(user.getWorkAddress());
        corpUserDetail.setRemark(user.getComment1());
        corpUserDetail.setMobile(user.getCellphone());
        corpUserDetail.setEmail(user.getEmail());
        corpUserDetail.setJobnumber(user.getStaffId());
        corpUserDetail.setIsLeaderInDepts(user.getWhetherLeader());

        // 目前只有一个部门，就不循环了
        List<Long> departmentList = new ArrayList<Long>();
        String departId = this.changeToDepartId(user.getDepartment());
        Long longDepartId = Long.parseLong(departId);
        departmentList.add(longDepartId);
        corpUserDetail.setDepartment(departmentList);

        Map<String, String> extattr = new HashMap<String, String>();
        extattr.put("RSO认证",user.getRsoIdentify());
        extattr.put("社保地",user.getSocialSecurityAddress());
        extattr.put("音达认证",user.getYindaIdentify());
        extattr.put("合同类型",user.getContractType());
        extattr.put("常驻地",user.getOrdinaryAddress());
        extattr.put("备注2",user.getComment2());
        extattr.put("户籍地",user.getHouseholdAddress());
        extattr.put("分公司",user.getBranchCompany());
        extattr.put("身份证号",user.getIdNo());
        extattr.put("网元",user.getNetUnit());
        corpUserDetail.setExtattr(extattr);
        return corpUserDetail;
    }

    /**
     * 转换成本地用户类
     * @param user
     * @return
     */
    public StaffInfo ChangeToLocal(CorpUserDetail user){
        StaffInfo result = new StaffInfo();
        result.setName(user.getName());
        result.setCellphone(user.getMobile());
        result.setEmail(user.getEmail());
        result.setStaffUserId(user.getDingId());
        result.setStaffId(user.getJobnumber());
        result.setPosition(user.getPosition());
        result.setBranchPhone(user.getTel());
        result.setWorkAddress(user.getWorkPlace());
        result.setComment1(user.getRemark());
        result.setWhetherLeader(user.getIsLeaderInDepts());

        // 目前只有一个部门，就只获得第一个元素
        List<Long> departmentList = user.getDepartment();
        Long longDepartId = departmentList.get(0);
        String strDepartId = Long.toString(longDepartId);
        String departmentName = this.changeToChinese(strDepartId);
        result.setDepartment(departmentName);

        Map<String, String> extattr = user.getExtattr();
        result.setRsoIdentify(extattr.get("RSO认证"));
        result.setSocialSecurityAddress(extattr.get("社保地"));
        result.setYindaIdentify(extattr.get("音达认证"));
        result.setContractType(extattr.get("合同类型"));
        result.setOrdinaryAddress(extattr.get("常驻地"));
        result.setComment2(extattr.get("备注2"));
        result.setHouseholdAddress(extattr.get("户籍地"));
        result.setBranchCompany(extattr.get("分公司"));
        result.setIdNo(extattr.get("身份证号"));
        result.setNetUnit(extattr.get("网元"));
        return result;
    }

    /**
     * 把从数据库中得到的部门字段，转换为钉钉里的部门ID
     * 先考虑单部门的情况，但要考虑横杠的问题
     */
    public String changeToDepartId(String departName) {
        String parentName;
        String myName;
        if (departName.contains("-")) {
            String[] strings = departName.split("-");
            parentName = strings[0];
            myName = strings[1];
            String parentId = userInfoService.parentName2id(parentName);
            String myId = userInfoService.myName2id(myName, parentId);
            return myId;
        }
        // 接下来看本身就是根部门的情况
        else {
            String parentId = userInfoService.parentName2id(departName);
            return parentId;
        }
    }

    /**
     * 把钉钉里的部门id，转换为数据库所需要的中文名
     */
    public String changeToChinese(String id) {
        Department department = userInfoService.id2name(id);
        String parentId = department.getDepParentid();
        String myName = department.getDepName();

        if (parentId.equals("1")) {
            return myName;
        }
        else {
            department = userInfoService.id2name(parentId);
            String parentName = department.getDepName();
            String name = parentName+"-"+myName;
            return name;
        }

    }

    //获取当前用户id
    public static String getStaffUserId(String code){
        try {
            String accessToken = AuthHelper.getAccessToken();
            //获取用户code

            return UserHelper.getUserInfo(accessToken, code).getUserid();
        } catch (Exception e){

        }
        return null;
    }
    public static String testShow() {
        //这是请求接口的地址
        List<String> useridList = new ArrayList<String>();
        useridList.add("031618475738729262");
        useridList.add("022418113430903564");
        JSONObject json = new JSONObject();
        json.put("agentId", 38433641);
        //json.put("deptVisibleScopes", []);
        json.put("userVisibleScopes", useridList);
        JSONObject reponseJson = null;
        try {
            String url = "https://oapi.dingtalk.com/microapp/set_visible_scopes?access_token=" +  AuthHelper.getAccessToken();
            reponseJson = HttpHelper.httpPost(url, json);
        } catch (OApiException e) {
            e.printStackTrace();
        }
        return reponseJson.toJSONString();
    }
}
