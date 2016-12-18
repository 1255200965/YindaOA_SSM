package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.YoItemChange;
import com.service.IExcelItemChangeService;

@Controller
public class ItemChangeController {
	@Autowired
	private IExcelItemChangeService itemChangeService;
	@RequestMapping("/toItemChange.do")
	public ModelAndView toItemChange(HttpServletRequest request,YoItemChange itemChange){
		ModelAndView mav = new ModelAndView();
		YoItemChange itemChange2 = itemChange;
		List<YoItemChange> itemChangeList =  itemChangeService.selectByPropertities(itemChange);
		mav.addObject("itemChangeList",itemChangeList);
		mav.addObject("itemChange2", itemChange2);
		mav.setViewName("itemchange");
	    return mav;
	}
}
