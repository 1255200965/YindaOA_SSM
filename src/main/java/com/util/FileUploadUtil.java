package com.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

public class FileUploadUtil {
	/**
	 * 图片上传处理
	 * @param request
	 * @return 新文件名称
	 * @throws IllegalStateException
	 * @throws IOException
	 */
   public static String imageUpload(HttpServletRequest request) throws IllegalStateException, IOException{
   	MultipartRequest mRequest = (MultipartRequest)request;
   	MultipartFile mFile= mRequest.getFile("image");
   	   //原始图片名称
   	String originalName=mFile.getOriginalFilename();
   	System.out.println("上传后的文件名为"+originalName);
   	  //图片存储的物理路径
		String basePath =ExpenseApplyResources.IMG_SAVE_PATH;
		  //新的图片名称
		String newFileName=UUID.randomUUID()+originalName.substring(originalName.lastIndexOf("."));
		  //新图片
   	File file = new File(basePath+newFileName);  
   	//将mFile文件的内容写入file
		mFile.transferTo(file);
		return newFileName;
   }
}
