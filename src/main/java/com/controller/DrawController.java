package com.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ddSdk.auth.AuthHelper;
import com.ecache.Impl.SystemCacheImpl;
import com.model.LuckyStaff;
import com.model.Prize;
import com.model.StaffInfo;
import com.service.ILuckyStaffService;
import com.service.IStaffInfoService;
import com.service.PrizeService;
import com.util.DDUtil;
import com.util.GlobalConstant;
@Controller
public class DrawController {
	public String result=null;//抽奖结果
	public LuckyStaff luckyStaffNow=null;//当前中奖人员
	public String operation = null;//当前抽奖活动进展
	@Autowired
	public PrizeService prizeService;
	@Autowired
	public IStaffInfoService staffInfoService;
	@Autowired
	private ILuckyStaffService luckyService;
		//获取员工信息缓存
	ValueWrapper staffCache = SystemCacheImpl.cache.get("staffInfo");
		//从缓存中拿取有资格抽奖的职工信息--map<职工姓名,钉钉ID>
	public Map<String,String> staffMap=(Map<String, String>) staffCache.get();
	
	@RequestMapping("/drawStaff.do")
	public ModelAndView goDrawJsp(HttpServletRequest request){
		String flag="start";
		Prize prize =prizeService.selectNowPrize();
		ModelAndView mav =new ModelAndView();
		if(prize == null){
			flag="end";
		}
		mav.addObject("flag", flag);
		mav.setViewName("draw/draw_staff");
		return mav;
	}

		/**
		 * 领奖
		 * @param staffUserId
		 * @return
		 */
	@RequestMapping("/getPrize.do")
	public @ResponseBody boolean getPrize(String staffId,String prizeType){
		System.out.println("********"+prizeType);
	    
	  try{ 	
		  //只有当1.当前用户有资格抽奖并且2.当前奖项并未被领走的情况下才可以进行领奖
	    if(judgePerson(staffId) && judgePrize(prizeType)){
	    	
	    	Prize prize = prizeService.selectByType(prizeType).get(0);
	    	prize.setStatus("已抽");
	    	prizeService.updateSelective(prize);
	    	
	    	LuckyStaff luckyStaff = new LuckyStaff();
	    	StaffInfo staffInfo = staffInfoService.selectByStaffId(staffId).get(0);
	    	luckyStaff.setDrawType(prizeType);
	    	
	    	luckyStaff.setStaffId(staffInfo.getStaffId());
	    	luckyStaff.setStaffName(staffInfo.getName());
	    	luckyService.save(luckyStaff);
	    	return true;
	    }else{
	    	return false;
	    }
	   }catch(Exception e){
		   return false;
	   }
	}
	/*@RequestMapping("/getCode.do")
	*//**获取员工的staffUserId***//*
	private void getCode(HttpServletRequest request ,String code){
		
		String staffUserId=DDUtil.getUserID(code);
		System.out.println(staffUserId);
		request.getSession().setAttribute(GlobalConstant.user_staff_user_id, staffUserId);
	}*/
	/**
	 * 判断当前员工是否有资格中奖
	 * @param staffUserId
	 * @return
	 */
	private boolean judgePerson(String staffId){
			//如果当前员工不在抽奖人员名单中则其无资格中奖
		if(staffMap.get(staffId)==null || "".equals(staffMap.get(staffId))){
			System.out.println("抽奖资格校验失败");
			return false;
		}else{
				//如果当前员工已中过奖则其无资格再中奖
			List<LuckyStaff> luckyList= luckyService.selectByStaffId(staffId);
			if(luckyList==null || luckyList.size()==0){
				System.out.println("抽奖资格校验成功");
				return true;
			}else{
				System.out.println("抽奖资格校验失败2");
				return false;
			}
		}
	}
	/**
	 * 判断当前奖品是否还能被中
	 * @param prizeType
	 * @return  fasle-奖品已完  true--还有待抽奖品
	 */
	private boolean judgePrize(String prizeType){
		List<Prize> prizeList = prizeService.selectByType(prizeType);
		if(prizeList==null || prizeList.size()==0){
			System.out.println("无该奖品可抽");
			return false;
		}else{
			System.out.println("还有该奖品可抽");
			return true;
		}
	}
	
}
