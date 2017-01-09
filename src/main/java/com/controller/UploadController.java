package com.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.service.IBusinessTripService;

@Controller
@RequestMapping("/upload")
public class UploadController {
	@Autowired
	private IBusinessTripService businessTripService;
	/**
	 * 出差导入界面跳转
	 * @return
	 */
	@RequestMapping("/toBusinessTrip.do")
	public ModelAndView toBusinessTrip(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("upload/upload-businessTrip");
		return mav;
	}
	/**
	 * 数据导入
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/businessTrip_upload.do")
	public ModelAndView  businessTrip_upload(HttpServletRequest request) throws IOException{
		ModelAndView mav = new ModelAndView();
		MultipartRequest mRequest=(MultipartRequest) request;
		MultipartFile file=null;
//		FileInputStream fis=null;
		InputStream fis= null;
		List<String []> errorList=new ArrayList<String []>();
		try{
			file = mRequest.getFile("file");
			fis =  file.getInputStream();
		}catch(Exception e){
			e.printStackTrace();
			String []errorMsg = {"导入失败","1.无法从本地读取文件内容,请查看文件夹权限或者查看文件是否正在被使用2.查看文件是否为.xls格式的EXCEL文件"};
			errorList.add(errorMsg);
		}
		if(errorList.size()==0){
		errorList = businessTripService.readExcel(fis);
		}
		mav.addObject("errorList", errorList);
		mav.setViewName("upload/upload_result");
		return mav;
		
	}
}
