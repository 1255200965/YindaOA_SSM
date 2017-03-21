package com.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.dao.BusinessTripMapper;
import com.dao.StaffInfoMapper;
import com.model.BusinessTrip;
import com.model.BusinessTripExample;
import com.model.StaffInfo;
import com.mysql.fabric.xmlrpc.base.Array;
import com.service.IBusinessTripService;
@Service
public class BusinessTripServiceImpl implements IBusinessTripService{
	@Autowired
	private BusinessTripMapper businessTripMapper;
	@Autowired
	private StaffInfoMapper staffInfoMapper;
    @Override
    public List<BusinessTrip> selectByPropertities(BusinessTrip businessTrip){
    	//return businessTripMapper.selectByPropertities(businessTrip);
		return null;
    }
    @Override
    public List<BusinessTrip> selectByStaffId(String staffId){
    	BusinessTripExample example=new BusinessTripExample();
    	BusinessTripExample.Criteria criteria = example.createCriteria();
    	criteria.andBtAskStaffIdEqualTo(staffId);
    	return businessTripMapper.selectByExample(example);
    }
    @Override
    public BusinessTrip selectById(int id){
    	return businessTripMapper.selectByPrimaryKey(id);
    }
    @Override
    public List<String[]> readExcel(InputStream fis) throws IOException{
    	BusinessTrip businessTrip = new BusinessTrip();
    	String startCity=null;
    	String endCity = null;
    	List<String> tripList = null;
    	List<String[]> errorList= new ArrayList<String[]>();//导入错误汇总列
    	Workbook workbook = new HSSFWorkbook(fis);
    	//获取第一个sheet
    	Sheet sheet = workbook.getSheetAt(0);
    	//获取表头
        Row rowHead = sheet.getRow(0);
        //表头验证
        String errorMsg[] = ExcelHeadValidate(rowHead);
        if(errorMsg[0] !=null){
        	errorList.add(errorMsg);
        	//表头验证失败直接返回,错误信息
        	return errorList;
        }
        //获取总行数
        int totalRowNum =sheet.getLastRowNum();
        //获取总列数
//        int totalCellNum =rowHead.getPhysicalNumberOfCells();
        //按行读取数据
        for(int i = 1 ;i<=totalRowNum;i++){
        	Row row = sheet.getRow(i);
        try{    
        	    //从第1列读入,不读第0列
        	    int j=1;
        	    //审批单号
        	    if(row.getCell(j) !=null){
        	    	row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
        	    	businessTrip.setBtApproveNo(row.getCell(j++).getStringCellValue().toString());
        	    }
        	    //出差目的
        		businessTrip.setBtAskReason(row.getCell(j++).getStringCellValue().toString());
        		//交通工具
        		if(row.getCell(j) !=null){
        			row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
        			businessTrip.setBtVehicle(row.getCell(j++).getStringCellValue().toString());
        		}
        			//审批状态
        		if(row.getCell(j) !=null){
        			row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
        			businessTrip.setBtApproveState(row.getCell(j++).getStringCellValue().toString());
        		}
        		//审批发起时间
        		if(row.getCell(j) !=null){
        			row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
        			businessTrip.setBtApproveBegin(row.getCell(j++).getStringCellValue().toString());
        		}
        		//审批处理时间
        		if(row.getCell(j) !=null){
        			row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
        			businessTrip.setBtApproveEnd(row.getCell(j++).getStringCellValue().toString());
        		}
        		//用户钉钉ID
        		if(row.getCell(j) !=null){
        			row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
        			businessTrip.setBtAskStaffUserId(row.getCell(j++).getStringCellValue().toString());
        		}
        			//用户工号
        			/*System.out.println(row.getCell(j).getStringCellValue().toString());*/
        			businessTrip.setBtAskStaffId(staffInfoMapper.selectByPrimaryKey(businessTrip.getBtAskStaffUserId()).getStaffId());
        	
        		//申请人名称
        		if(row.getCell(j) !=null){
        			row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
        			businessTrip.setBtAskStaffName(row.getCell(j++).getStringCellValue().toString());
        		}
        			//部门名称
        		if(row.getCell(j) !=null){
        			row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
        			businessTrip.setBtAskStaffDepart(row.getCell(j++).getStringCellValue().toString());
        		}
        			//部门id
        		if(row.getCell(j) !=null){
        			row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
        			businessTrip.setBtAskStaffDepartId(row.getCell(j++).getStringCellValue().toString());
        		}
        			//历史审批人
        		if(row.getCell(j) !=null){
        			row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
        			businessTrip.setBtHistoryApproveName(row.getCell(j++).getStringCellValue().toString());
        		}
        			//审批人意见
        		if(row.getCell(j) !=null){
        			row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
        			businessTrip.setBtApproveRecord(row.getCell(j++).getStringCellValue().toString());
        		}
        			//审批耗时
        		if(row.getCell(j) !=null){
        			row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
        			businessTrip.setBtCost(row.getCell(j++).getStringCellValue().toString());
        		}
        			//出差行程 
        		if(row.getCell(j) !=null){
        			row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
        			businessTrip.setBtTrip(row.getCell(j++).getStringCellValue().toString());
        		}
        		tripList=Arrays.asList(businessTrip.getBtTrip().split("\\-"));
        		    /**出差开始城市**/
        		businessTrip.setBtStartCity(tripList.get(0));
        		    /**出差结束城市**/
        		businessTrip.setBtAddress(tripList.get(tripList.size()-1));
        		//发起人工号
        		j++;
        		//出差开始日期
        		if(row.getCell(j) !=null){
        			row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
        			businessTrip.setBtAskBeginTime(row.getCell(j++).getStringCellValue().toString());
        		}
        			//出差结束日期
        		if(row.getCell(j) !=null){
        			row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
        			businessTrip.setBtAskEndTime(row.getCell(j++).getStringCellValue().toString());
        		}
        			if(isExistRecord(businessTrip.getBtApproveNo())){//已存在的出差订单，执行更新操作
        			businessTripMapper.updateByPrimaryKeySelective(businessTrip);
        		}else{//不在数据库中的出差订单,执行插入操作
        		    businessTripMapper.insertSelective(businessTrip);
        		}
        		if(i > 18) continue;
        		
        			
        }catch(Exception e){
        	e.printStackTrace();
        	errorMsg[0]="行数据导入错误";
        	errorMsg[1]="第"+i+"行数据导入错误";
        	errorList.add(errorMsg);
        }
        }
        return errorList;
    }
    /**
     * 表头验证
     * @param rowHead
     * @return
     */
    private String[] ExcelHeadValidate(Row rowHead){
    	//错误信息
    	String []errorMsg = new String[2];
    	int totalCellNum =rowHead.getPhysicalNumberOfCells();
    	if(totalCellNum != 18){
    		errorMsg[0]="导入失败";
    		errorMsg[1]="excel表格列数与要求格式列数不对应,无法导入";
    		return errorMsg;
    	}else{
    		return errorMsg;
    	}	
    }
    /**
     * 判断这条申请是否存在数据库中
     * @param btApproveNo
     * @return true--表示存在  false--表示不存在
     */
    private boolean isExistRecord(String btApproveNo){
    	BusinessTripExample example = new BusinessTripExample();
    	BusinessTripExample.Criteria criteria = example.createCriteria();
    	criteria.andBtApproveNoEqualTo(btApproveNo);
    	List<BusinessTrip> btList=businessTripMapper.selectByExample(example);
    	if(btList != null && btList.size()>0){
    		return true;
    	}
    	return false;
    }
}
