package com.service.impl;

import com.dao.YoSocialSecurityInfoMapper;
import com.model.YoSocialSecurityInfo;
import com.model.YoSocialSecurityInfoExample;
import com.service.IExcelSocialSecurityInfoService;
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
 * 社保信息明细表的导入
 * 从第1张表第2行开始导入
 */
@Service
public class ExcelSocialSecurityInfoServiceImpl implements IExcelSocialSecurityInfoService {

    @Autowired
    public YoSocialSecurityInfoMapper yoSocialSecurityInfoMapper;

    /*
    循环地从excel中插入或更新每一行数据
     */
    public Map<String, Object> insertAndUpdate(HSSFWorkbook hssfWorkbook) {
        Map<String, Object> mapInsert = new HashMap<String, Object>();
        List<YoSocialSecurityInfo> listFail = new ArrayList<YoSocialSecurityInfo>();

        // 得到第1张表
        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
        // 这里不要用物理行数，要用最后一行的编号，不然很容易跳坑
        int rowLastNo = hssfSheet.getLastRowNum();

        // 设定一个变量，记录for循环当中操作成功的条目数目
        int successAmount = 0;

        // 接下来从第1行开始，对每一行进行操作
        for (int rowNo=0; rowNo<=rowLastNo; rowNo++) {
            HSSFRow hssfRow = hssfSheet.getRow(rowNo);
            // 同理，这里也不要用单元格的总数，要用最后一个单元格的序号
            int cellLastNo = hssfRow.getLastCellNum();

            /*
            现在开始做真正的功能！
            第1步，把得到的hssfRow中每一个不为null的cell都设为文本类型，确保每一个整形数值在toString后不会自动加上.0
            */
            for (int cellNo=0; cellNo<=cellLastNo; cellNo++) {
                // cell不为空时才操作，为空也就不用管他是什么类型了
                // 想管也管不起，因为会报NullPointerException，而我们编程时应当避免异常，而不是积极处理异常
                if (hssfRow.getCell(cellNo) != null) hssfRow.getCell(cellNo).setCellType(1);
            }

            /*
            第2步，检查当前行是不是空行，如果是就跳过后面的，操作下一行
            检查方法：空的单元格的数目是否等于最后单元格序号+1
             */
            int emptyCellAmount = 0;
            for (int cellNo=0; cellNo<=cellLastNo; cellNo++) {
                if (hssfRow.getCell(cellNo)==null || hssfRow.getCell(cellNo).toString().equals("")) {
                    // 这里就可以用++i了，听说运算速度更快= =
                    ++emptyCellAmount;
                }
            }
            if (emptyCellAmount == cellLastNo+1) continue;

            /*
            第3步，对于不为空的行，将数据注入引用过来的实体对象
             */
            int cellNo = -1;
            YoSocialSecurityInfo yoSocialSecurityInfo = new YoSocialSecurityInfo();
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiBranchCompany(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiStaffId(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiName(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiSecurityAddress(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiBeginMonth(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiEndowment(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiEndowmentCom(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiEndowmentPer(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiMedical(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiMedicalCom(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiMedicalPer(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiUnemployment(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiUnemploymentCom(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiUnemploymentPer(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiMaternity(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiMaternityCom(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiMaternityPer(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiInjury(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiInjuryCom(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiInjuryPer(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiAccumulation(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiAccumulationCom(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiAccumulationPer(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiExternalService(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiExternalServiceCom(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiExternalServicePer(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiFatalIll(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiFatalIllCom(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSocialSecurityInfo.setSsiFatalIllPer(hssfRow.getCell(cellNo).toString());

            /*
            第5步，如果工号相同，就直接下一条，即不成功也不失败
             */
            String staffId = yoSocialSecurityInfo.getSsiStaffId();
            YoSocialSecurityInfoExample yoSocialSecurityInfoExample = new YoSocialSecurityInfoExample();
            yoSocialSecurityInfoExample.createCriteria().andSsiStaffIdEqualTo(staffId);
            List<YoSocialSecurityInfo> listSocialSecurityInfo = yoSocialSecurityInfoMapper.selectByExample(yoSocialSecurityInfoExample);

            if (listSocialSecurityInfo.size() > 0) {
                continue;
            }

            // 第6步，如果是一条新信息，就插入新数据
            else {
                try {
                    yoSocialSecurityInfoMapper.insert(yoSocialSecurityInfo);
                } catch (Exception e) {
                    listFail.add(yoSocialSecurityInfo);
                    continue;
                }
            }

            // 到了这一步，说明插入或更新成功，数目自加！
            successAmount++;
            if (successAmount % 1000 == 0) System.out.println(successAmount);
        }

        // for循环之后，把成功数目和失败列表返回到map
        mapInsert.put("successAmount", successAmount);
        mapInsert.put("listFail", listFail);
        return mapInsert;
    }

}
