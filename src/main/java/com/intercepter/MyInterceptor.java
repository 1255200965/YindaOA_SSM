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

		/*
		 * 权限的url的按照controller的requestmapping 对比
		 */

		List<String> urlList = (List<String>) request.getSession().getAttribute("urlList");
		if(urlList==null||urlList.size()==0){
			response.sendRedirect(request.getContextPath()+"/error.jsp");
			return false;
		}

		System.out.println("用户可访问的url:" +urlList.size());
		try{
			url = subUrl(url);
			System.out.println("subUrl");
		}catch(Exception e){
			System.out.println("当前链接："+url+",myinterceptor 67 ,出错");
			response.sendRedirect(request.getContextPath()+"/error.jsp");
			return false;

		}

		for(String str :urlList){
			if(url.equals(str)){
				System.out.println("judge");
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
	public static void main(String[] args) {
		MyInterceptor.subUrl("/YindaOA////userinfo////updateuser.do");


	}

	public static String subUrl(String url){

		int index = url.indexOf("/YindaOA/");
		//判断是否含有/YindaOA/ 
		if(index==-1){
			return null;
		}
		int length = url.length();
		//去除‘/YindaOA/’
		url = url.substring(9, length);
		System.out.println(url);

		/*
		 * 判断下一个字符串串是否为‘/’ 如果是那么去除		   
		 */
		int  i = url.indexOf("/");
		while(i==0){
			url =url.substring(1, url.length());
			i = url.indexOf("/");
		}

		System.out.println(url);
		/* 
		 * 现在url是以controller的 requestmapping 开始的 且开始不含 ‘/’
		 * 现在要截取到 第一个出现 ‘/’ 为止
		 */
		if(url.indexOf('/')==-1){
			url =url.substring(0, url.length());
		}else{
			url =url.substring(0, url.indexOf('/'));
		}
		
		System.out.println(url);
		return url;
	}
}
