package com.service.impl;

import com.dao.YoSignInMapper;
import com.model.YoSignIn;
import com.model.YoSignInExample;
import com.service.IExcelSignInService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 打卡明细记录表的导入
 * 第3行是表头，第4行开始才是内容
 */
@Service
public class ExcelSignInServiceImpl implements IExcelSignInService {

    @Autowired
    public YoSignInMapper yoSignInMapper;

    /*
    循环地从excel中插入或更新每一行数据
     */
    public Map<String, Object> insertAndUpdate(HSSFWorkbook hssfWorkbook) {
        Map<String, Object> mapInsert = new HashMap<String, Object>();
        List<YoSignIn> listFail = new ArrayList<YoSignIn>();

        // 得到第1张表
        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
        // 这里不要用物理行数，要用最后一行的编号，不然很容易跳坑
        int rowLastNo = hssfSheet.getLastRowNum();

        // 设定一个变量，记录for循环当中操作成功的条目数目
        int successAmount = 0;

        // 接下来从第4行开始，对每一行进行操作
        for (int rowNo=3; rowNo<=rowLastNo; rowNo++) {
            HSSFRow hssfRow = hssfSheet.getRow(rowNo);
            // 同理，这里也不要用单元格的总数，要用最后一个单元格的序号
            int cellLastNo = hssfRow.getLastCellNum();

            /*
            现在开始做真正的功能！
            第1步，把得到的hssfRow中每一个不为null的cell都设为文本类型，确保每一个整形数值在toString后不会自动加上.0
            */
            for (int cellNo=0; cellNo<=13; cellNo++) {
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
            第3步，由于图1-图9都是链接类型，所以先把其中的链接地址读出来
             */
            String image1 = (hssfRow.getCell(14).getHyperlink() != null) ? hssfRow.getCell(14).getHyperlink().getAddress() : null;
            String image2 = (hssfRow.getCell(15).getHyperlink() != null) ? hssfRow.getCell(15).getHyperlink().getAddress() : null;
            String image3 = (hssfRow.getCell(16).getHyperlink() != null) ? hssfRow.getCell(16).getHyperlink().getAddress() : null;
            String image4 = (hssfRow.getCell(17).getHyperlink() != null) ? hssfRow.getCell(17).getHyperlink().getAddress() : null;
            String image5 = (hssfRow.getCell(18).getHyperlink() != null) ? hssfRow.getCell(18).getHyperlink().getAddress() : null;
            String image6 = (hssfRow.getCell(19).getHyperlink() != null) ? hssfRow.getCell(19).getHyperlink().getAddress() : null;
            String image7 = (hssfRow.getCell(20).getHyperlink() != null) ? hssfRow.getCell(20).getHyperlink().getAddress() : null;
            String image8 = (hssfRow.getCell(21).getHyperlink() != null) ? hssfRow.getCell(21).getHyperlink().getAddress() : null;
            String image9 = (hssfRow.getCell(22).getHyperlink() != null) ? hssfRow.getCell(22).getHyperlink().getAddress() : null;

            /*
            第4步，对于不为空的行，将数据注入引用过来的实体对象
             */
            int cellNo = -1;
            YoSignIn yoSignIn = new YoSignIn();
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiName(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiStaffId(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiDepartment(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiCompleteDepartment(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiJobPosition(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiDate(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiTime(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiLongitude(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiLatitude(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiAddress(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiCompleteAddress(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiMeet(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiComment(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiCellphoneId(hssfRow.getCell(cellNo).toString());
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiImage1(image1);
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiImage2(image2);
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiImage3(image3);
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiImage4(image4);
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiImage5(image5);
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiImage6(image6);
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiImage7(image7);
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiImage8(image8);
            if (hssfRow.getCell(++cellNo) != null) yoSignIn.setSiImage9(image9);

            /*
            第5步，如果工号，日期，时间都相同，就直接跳过
             */
            String staffId = yoSignIn.getSiStaffId();
            String date = yoSignIn.getSiDate();
            String time = yoSignIn.getSiTime();
            YoSignInExample yoSignInExample = new YoSignInExample();
            yoSignInExample.createCriteria().andSiStaffIdEqualTo(staffId).andSiDateEqualTo(date).andSiTimeEqualTo(time);
            List<YoSignIn> listSignIn = yoSignInMapper.selectByExample(yoSignInExample);

            if (listSignIn.size() > 0) {
                continue;
            }

            // 第6步，如果不相同，就插入新数据
            else {
                try {
                    yoSignInMapper.insert(yoSignIn);
                } catch (Exception e) {
                    listFail.add(yoSignIn);
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

    public List<YoSignIn> selectByExample(YoSignInExample example){
        return yoSignInMapper.selectByExample(example);
    }

}
