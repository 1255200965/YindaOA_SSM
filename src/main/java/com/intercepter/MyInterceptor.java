package com.intercepter;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.ecache.Impl.SystemCacheImpl;
import com.util.GlobalConstant;


/*
 * create by  yexianglei
 * date : 2017.1.17
 */
public class MyInterceptor extends HandlerInterceptorAdapter {
	 ValueWrapper moduleCache =SystemCacheImpl.cache.get("role_module");
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("-----进入了我的拦截器-----");
		System.out.println(request.getRequestURI());
		String userAgent = request.getHeader("user-agent");
		String[] agent = { "Android", "iPhone", "iPod","iPad", "Windows Phone", "MQQBrowser" };
	    System.out.println(userAgent);
		//第1步 判断是否为登录链接 如果是放行
		String url =request.getRequestURI();
		if(url.equals("/YindaOA/login.do")||url.equals("/YindaOA/loginSuccess.do")){
			return true;
		}
		//如果是手机访问,就放行
		for(String str:agent){			
			if(userAgent.contains(str)){
				return true;
			}
		}

        //第2步 判断是否登录 如果没有登录 返回登录页		
		String staff_id = (String) request.getSession().getAttribute(GlobalConstant.user_staffId);
		if(staff_id==null||"".equals(staff_id)){
			 System.out.println("session不存在，返回登录页");
			 response.sendRedirect(request.getContextPath()+"/index.jsp");
			 return false;
		}
		//第3步 进去其他链接判断用户对应的角色是否有权限
		List<String> urlList = (List<String>) request.getSession().getAttribute("urlList");
		

	    System.out.println("用户可访问的url:" +urlList.size());
	    for(String str :urlList){
	    	if(url.equals(str)){
	    		return true;
	    	}
	    }
	    response.sendRedirect(request.getContextPath()+"/error.jsp");
	    return false;

}
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("===========MyInterceptor postHandle===========");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("===========MyInterceptor afterCompletion===========");
	}
}
