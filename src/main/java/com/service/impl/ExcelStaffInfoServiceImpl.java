package com.service.impl;

import com.dao.DepartmentMapper;
import com.dao.OaWtrSalaryMapper;
import com.dao.StaffInfoMapper;
import com.ddSdk.auth.AuthHelper;
import com.dingtalk.open.client.ServiceFactory;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.dingtalk.open.client.api.service.corp.CorpUserService;
import com.model.*;
import com.service.IExcelStaffInfoService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 队标：一篇代码，最好不要超过200行，尽量不要超过300行，一定不能超过500行
 */
@Service
public class ExcelStaffInfoServiceImpl implements IExcelStaffInfoService {

    @Autowired
    public StaffInfoMapper staffInfoMapper;
    @Autowired
    public DepartmentMapper departmentMapper;
    @Autowired
    public OaWtrSalaryMapper oaWtrSalaryMapper;

     /*
     循环地从excel中插入每一行数据
     如果StaffUserId相同，就更新数据
     */
    public Map<String, Object> insertAndUpdate(HSSFWorkbook hssfWorkbook) {
        Map<String, Object> mapInsert = new HashMap<String, Object>();
        List<StaffInfo> listFail = new ArrayList<StaffInfo>();

        // 得到当前文件的总表数
        int sheetTotal = hssfWorkbook.getNumberOfSheets();

        // 设定一个变量，记录for循环当中操作成功的条目数目
        int successAmount = 0;
        // 接下来对每一张表都进行操作
        for (int sheetNo=0; sheetNo<sheetTotal; sheetNo++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheetNo);
            // 这里不要用物理行数，要用最后一行的编号，不然很容易跳坑
            int rowLastNo = hssfSheet.getLastRowNum();

            // 从第二行开始，对每一张表中的每一行进行操作
            for (int rowNo=1; rowNo<=rowLastNo; rowNo++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNo);
                // 同理，这里也不要用单元格的总数，要用最后一个单元格的序号
                int cellLastNo = hssfRow.getLastCellNum();

                /*
                现在开始做真正的功能！
                第一步，把得到的hssfRow对象中的每一个cell都设为文本类型，确保每一个整形数值在toString后不会自动加上.0
                */
                for (int cellNo=0; cellNo<=cellLastNo; cellNo++) {
                    // cell不为空时才操作，为空也就不用管他是什么类型了
                    // 想管也管不起，因为会报NullPointerException，而我们编程时应当避免异常，而不是积极处理异常
                    if (hssfRow.getCell(cellNo) != null) hssfRow.getCell(cellNo).setCellType(1);
                }

                /*
                第二步，检查当前行是不是空行，如果是就跳过后面的，操作下一行
                检查方法：空的单元格的数目是否等于最后单元格序号+1
                 */
                int emptyCellAmount = 0;
                for (int cellNo=0; cellNo<=cellLastNo; cellNo++) {
                    // cell不为空时才操作，为空也就不用管他是什么类型了
                    // 想管也管不起，因为会报NullPointerException，而我们编程时应当避免异常，而不是积极处理异常
                    if (hssfRow.getCell(cellNo)==null || hssfRow.getCell(cellNo).toString().equals("")) {
                        // 这里就可以用++i了，听说运算速度更快= =
                        ++emptyCellAmount;
                    }
                }
                if (emptyCellAmount == cellLastNo+1) continue;

                // 第3步，对于不为空的行，将excel数据转成实体对象
                int cellNo = -1;
                StaffInfo staffInfo = new StaffInfo();
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setStaffUserId(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setDepartment(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setPosition(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setName(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setSex(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setStaffId(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setWhetherLeader(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setCellphone(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setEmail(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setBranchPhone(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setWorkAddress(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setComment1(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setContractType(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setYindaIdentify(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setNetUnit(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setComment2(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setIdNo(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setHouseholdAddress(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setBranchCompany(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setSocialSecurityAddress(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setOrdinaryAddress(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setRsoIdentify(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setBaseSalary(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setItemSalary(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setNation(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setAge(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setLastContract(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setLastContractBegin(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setLastContractEnd(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setEnterTime(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setWorkYear(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setSalaryCard(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setGraduateSchool(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setSchoolRecord(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setGraduateDate(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setExpenseCard(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setItem(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setYoOrder(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setStaffState(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setWorkState(hssfRow.getCell(cellNo).toString());
                if (hssfRow.getCell(++cellNo) != null && !hssfRow.getCell(cellNo).toString().equals("")) staffInfo.setLeaveDate(hssfRow.getCell(cellNo).toString());

                /*
                第4步，判断部门，姓名，工号，手机号这4个字段是否为空
                如果为空的话，实体对象直接进入失败列表并跳出循环
                身份证号暂时允许为空，因为入职的人好鱼啊，可能连身份证号都木有
                 */
                if (hssfRow.getCell(1) == null
                        || hssfRow.getCell(3) == null
                        || hssfRow.getCell(5) == null
                        || hssfRow.getCell(7) == null
                        || hssfRow.getCell(1).toString().equals("")
                        || hssfRow.getCell(3).toString().equals("")
                        || hssfRow.getCell(5).toString().equals("")
                        || hssfRow.getCell(7).toString().equals("")
                        ) {
                    listFail.add(staffInfo);
                    continue;
                }

                // 第5步，判断对象中的staffUserId是否为空。如果为空的话，就先插入钉钉并获得一个
                String staffUserId = staffInfo.getStaffUserId();
                if (staffUserId == null || staffUserId.equals("")) {
                    try {
                        staffUserId = createUser(staffInfo);
                    } catch (Exception e) {
                        // 如果异常直接跳出循环
                        listFail.add(staffInfo);
                        continue;
                    }
                }

                // 第6步，根据staffUserId在数据库中查询是否有该员工。如果有，则进行选择更新操作
                if (staffInfoMapper.selectByPrimaryKey(staffUserId) != null) {
                    try {
                        staffInfoMapper.updateByPrimaryKeySelective(staffInfo);
                    } catch (Exception e) {
                        listFail.add(staffInfo);
                        continue;
                    }
                }

                // 第7步，如果查不到该员工，说明是一条新数据，执行插入操作
                else {
                    try {
                        staffInfoMapper.insert(staffInfo);
                    } catch (Exception e) {
                        listFail.add(staffInfo);
                        continue;
                    }
                }

                // 第8步，检查一下对应的工号之前是否有离职数据，如果有，就删掉
                String staffId = staffInfo.getStaffId();
                StaffInfoExample example = new StaffInfoExample();
                example.createCriteria().andStaffIdEqualTo(staffId).andWorkStateEqualTo("离职");
                List<StaffInfo> list = staffInfoMapper.selectByExample(example);
                // 不可能有多条离职信息，故只删除第1条
                if (list.size() > 0){
                    // 由于不再需要读写该对象以及使用其进行更新，于是对之进行复用！
                    staffInfo = list.get(0);
                    staffUserId = staffInfo.getStaffUserId();
                    staffInfoMapper.deleteByPrimaryKey(staffUserId);
                }

                // 到了这一步，说明插入或更新成功，数目自加！
                successAmount++;
            }
        }
        // for循环之后，把成功数目和失败列表返回到map
        mapInsert.put("successAmount", successAmount);
        mapInsert.put("listFail", listFail);
        System.out.println("successAmount = "+successAmount);
        System.out.println("listFail.size() = "+listFail.size());
        return mapInsert;
    }

    /**
     * 把手机号不为空的员工列表返回
     * @return
     */
    public List<StaffInfo> getAllStaff() {
        StaffInfoExample staffInfoExample = new StaffInfoExample();
        staffInfoExample.createCriteria().andStaffUserIdIsNotNull();
        List<StaffInfo> list = staffInfoMapper.selectByExample(staffInfoExample);
        return list;
    }

    private String accessToken = null;
    public String getAccessToken(){
        try {
            accessToken = AuthHelper.getAccessToken();
        } catch (Exception e){
            e.printStackTrace();
        }
        return accessToken;
    }

    public String createUser(StaffInfo user){
        String result = null;
        try {
            CorpUserDetail userDetail = ChangeToDD(user);
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
        String departId = changeToDepartId(user.getDepartment());
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
            String parentId = parentName2id(parentName);
            String myId = myName2id(myName, parentId);
            return myId;
        }
        // 接下来看本身就是根部门的情况
        else {
            String parentId = parentName2id(departName);
            return parentId;
        }
    }

    /**
     * 根据根部门的名称，查根部门的id
     */
    public String parentName2id(String name) {
        String id;
        DepartmentExample example = new DepartmentExample();
        example.createCriteria().andDepNameEqualTo(name).andDepParentidEqualTo("1");
        List<Department> list = departmentMapper.selectByExample(example);
        Department department = list.get(0);
        id = department.getDepDdId();
        return id;
    }

    /**
     * 通过子部门的名称，和刚刚得到的父部门id，查子部门id
     */
    public String myName2id(String myName, String parentId) {
        String id;
        DepartmentExample example = new DepartmentExample();
        example.createCriteria().andDepNameEqualTo(myName).andDepParentidEqualTo(parentId);
        List<Department> list = departmentMapper.selectByExample(example);
        Department department = list.get(0);
        id = department.getDepDdId();
        return id;
    }

    /**
     * 通过部门id，查到实体类
     */
    public Department id2name(String id) {
        DepartmentExample example = new DepartmentExample();
        example.createCriteria().andDepDdIdEqualTo(id);
        List<Department> list = departmentMapper.selectByExample(example);
        Department department = list.get(0);
        return department;
    }

    public void address() {
        int aa = 0;
        int bb = 0;
        OaWtrSalaryExample example = new OaWtrSalaryExample();
        example.createCriteria().andAddressIsNotNull();
        List<OaWtrSalary> list = oaWtrSalaryMapper.selectByExample(example);
        for (int i=0; i<list.size(); i++) {
            OaWtrSalary oaWtrSalary = list.get(i);
            String address = oaWtrSalary.getAddress();
            if (address.contains("上海市")) address = "上海市";
            else if (address.contains("北京市")) address = "北京市";
            else if (address.contains("天津市")) address = "天津市";
            else if (address.contains("重庆市")) address = "重庆市";
            else {
                if (address.contains("市")) {
                    int endNo = address.indexOf("市");
                    address = address.substring(0, endNo);
                }
            }
            oaWtrSalary.setAddress(address);
            try {
                oaWtrSalaryMapper.updateByPrimaryKey(oaWtrSalary);
                aa++;
            } catch (Exception e) {
                System.out.println(oaWtrSalary.getId());
                bb++;
            }
            if (aa % 1000 == 0) System.out.println(aa);
        }
        System.out.println(aa);
        System.out.println(bb);
    }

}
