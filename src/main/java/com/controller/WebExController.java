package com.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.enterprise.inject.Model;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.WebexMapper;
import com.ddSdk.auth.AuthHelper;
import com.ddSdk.base.OApiException;
import com.model.Webex;
import com.model.WebexExample;
import com.util.GlobalConstant;
import com.util.HttpsUtil;
import com.util.OrderMessageUtil;
import com.util.WebExUtil;

import bsh.ParseException;
import net.sf.json.JSONObject;

/**
 * create date:2017-03-01
 * @author yexianglei
 *
 */
@Controller
@RequestMapping("WebEx")
public class WebExController {
	/*
	 *webex 接口链接
	 */
	String webexUrl ="https://yinda.webex.com.cn/WBXService/xml8.0.0/XMLService";

	@Autowired
	private WebexMapper webexMapper;
	/**
	 * 进去创建会议的页面 (导学习会议)
	 * @return
	 */
	@RequestMapping("create_meeting_page.do")
	public ModelAndView create_meeting_Page(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webex/create_meeting");		
		return mav;
	}

	/**
	 * 进去创建会议的页面 (钉钉会议)
	 * @return
	 */
	@RequestMapping("create_dd_meeting_page.do")
	public ModelAndView create_dd_meeting_Page(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
//		王龙		    11261
//		秦光远		17080
//		方舒		    19561
//		吴梦萍		10375
//		魏群		    22031
//		叶祥磊		16534
//		杨旭兰		10389
//		周靓		    10268
//		黄照香		19119
//		丁希林		19179
//		高雪峰		10305
//		韩永林		13025
//		岳韶斌		41401
//		章其波		16318
//		孙华武		19355
//		谭英花		14037
//		吴成勇		19002
//		钱忠诚		10272
//		马天立		16360
//		徐圆圆		17082
//		潘佳蕾      17084
//      朱俊柯		19770
//		余芳芳       70664
//      祁鑫炎      16382
//      于会芳       71704
		String [] staffidss  ={"11261","17080","19561","10375","22031","16534","10389","10268","19119","19179","10305","13025","41401","16318","19355","14037","19002","10272","16360","17082"
				,"17084","19770","70664","16382","71704"};
		
		String staffid = (String) request.getSession().getAttribute(GlobalConstant.user_staffId);
		
		for(int i =0;i<staffidss.length;i++){
			if(staffidss[i].equals(staffid)){
				mav.setViewName("webex/create_dd_meeting");	
				return mav;
			}
		}
		mav.setViewName("webex/create_dd_meeting_no_authority");	
		return mav;
	}

	/**
	 * 音达会议的主页面 (钉钉会议)
	 * @return
	 */
	@RequestMapping("meeting_home.do")
	public ModelAndView meeting_home(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String config= AuthHelper.getConfig(request);
	 	System.out.println("config:"+config);
	 	request.setAttribute("config", config);
		mav.setViewName("webex/meeting_home");		
		return mav;
	}

	@RequestMapping("create_meeting_page2.do")
	public ModelAndView create_meeting_Page2(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webex/create_meeting2222");		
		return mav;
	}

	@RequestMapping("create_meeting_success.do")
	public ModelAndView create_meeting_success(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webex/create_meeting_success");		
		return mav;
	}

	@RequestMapping("create_meeting_error.do")
	public ModelAndView create_meeting_error(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webex/create_meeting_error");		
		return mav;
	}
	/**
	 * 创建培训
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("create_meeting.do")
	@ResponseBody
	public String create_meeting(String meeting_name,String meeting_desc,String meeting_time,String meeting_count,String meeting_password,String meeting_length) throws UnsupportedEncodingException{

		/*
		 *日期格式 
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");//04/05/2017 10:00:00

		try {

			/*
			 *前端时间控件的格式和webex接口所需要的XML是不一致的 
			 */
			Date time = sdf.parse(meeting_time);
			sdf1.format(time);
			meeting_time = sdf1.format(time);

			/*
			 *创建会议 
			 */
			String res = create_Event(meeting_name, meeting_desc, meeting_time, meeting_count, meeting_password, meeting_length);

			/*
			 *判断是否创建成功 
			 */
			if(!res.contains("SUCCESS")){
				return "error";            	
			}
			/*
			 *获取中的值，也就是我们需要的seeionkey
			 */
			return  match("<event:sessionKey>","</event:sessionKey>",res);

		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}  

	}
	/**
	 * 获取两个字符串中间的内容
	 * @param start_str 开始的字符串
	 * @param end_str 结束的字符串
	 * @param s  全部的内容
	 * @return
	 */
	public  String match(String start_str,String end_str,String s) {
		List<String> results = new ArrayList<String>();
		Pattern p = Pattern.compile(start_str+"([\\w/\\.]*)"+end_str);
		Matcher m = p.matcher(s);
		while (!m.hitEnd() && m.find()) {
			results.add(m.group(1));
		}
		return results!=null ? results.get(0):null;
	}



	public String create_Event(String meeting_name,String meeting_desc,String meeting_time,String meeting_count,String meeting_password,String meeting_length) throws UnsupportedEncodingException{

		/*
		 *WEBEX XML 固定格式 
		 */
		String XML = ""+
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
				"<serv:message xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"+
				"  <header>"+
				"  <securityContext>"+
				"  <webExID>webex@yindatech.com</webExID>"+
				" <password>Abc123</password>"+
				"  <siteID>32757</siteID>"+
				"  <partnerID>vhS2rVHylENr0TpnV1Urkg</partnerID>"+
				"  <email>matl@yindatech.com</email>"+
				" </securityContext>"+
				" </header>"+
				" <body>"+
				" <bodyContent"+
				"   xsi:type=\"java:com.webex.service.binding.event.CreateEvent\">"+
				"   <accessControl>"+
				"    <listing>PUBLIC</listing>"+
				"      <sessionPassword>"+meeting_password+"</sessionPassword>"+
				" </accessControl>"+
				" <schedule>"+
				"  <startDate>"+meeting_time+"</startDate>"+
				"  <duration>"+meeting_length+"</duration>"+
				"  <timeZoneID>"+45+"</timeZoneID>"+
				"   <entryExitTone>NOTONE</entryExitTone>"+
				"<openTime>20</openTime>"+
				" </schedule>"+
//				"<telephony>"+
//                "<telephonySupport>NONE</telephonySupport>"+
//                "<extTelephonyDescription>"+
//                ""+
//                "</extTelephonyDescription>"+
//                "</telephony>"+
				" <enrollment>"+
				" <endURLAfterEnroll>www.yahoo.com</endURLAfterEnroll>"+
				"</enrollment>"+
				" <metaData>"+
				" <sessionName>"+meeting_name+"</sessionName>"+

		               " <description>"+meeting_desc+"</description>"+
		               "  </metaData>"+
		               " </bodyContent>"+
		               "</body>"+
		               "</serv:message>";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("XML", XML);

		return  WebExUtil.methodPost(webexUrl, map);

	}
   
	
	public String get_Event(String sessionKey) throws UnsupportedEncodingException{
		String XML ="<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>"+
		"<serv:message xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"+
		"<header>"+
		"  <securityContext>"+
		"  <webExID>webex@yindatech.com</webExID>"+
		" <password>Abc123</password>"+
		"  <siteID>32757</siteID>"+
		"  <partnerID>vhS2rVHylENr0TpnV1Urkg</partnerID>"+
		"  <email>matl@yindatech.com</email>"+
		" </securityContext>"+
		"</header>"+
		"<body>"+
		"<bodyContent xsi:type=\"java:com.webex.service.binding.event.GetEvent\">"+
		"<sessionKey>"+sessionKey+"</sessionKey>"+
		"</bodyContent>"+
		"</body>"+
		"</serv:message>";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("XML", XML);
		
		String response = WebExUtil.methodPost(webexUrl, map);
		
		String hostkey =match("<event:hostKey>","</event:hostKey>",response);
		
        return hostkey;
		
	}

	public String set_Event(String user_email,String session_key) throws UnsupportedEncodingException{
		String XML ="<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>"+
				"<serv:message xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"+
				"<header>"+
				"<securityContext>"+
				"<webExID>webex@yindatech.com</webExID>"+
				"<password>Abc123</password>"+
				"<siteID>32757</siteID>"+
				"<partnerID>vhS2rVHylENr0TpnV1Urkg</partnerID>"+
				"<email>matl@yindatech.com</email>"+
				"</securityContext>"+
				"</header>"+
				"<body>"+
				"<bodyContent xsi:type=\"java:com.webex.service.binding.event.SetEvent\">"+
				"<accessControl>"+
				"<listing>PUBLIC</listing>"+
				"<sessionPassword></sessionPassword>"+
				"</accessControl>"+
				"<panelists>"+
				"<panelist>"+
				"<com:email>"+user_email+"</com:email>"+
				"<com:notes>钉钉新增用户</com:notes>"+
				"<com:type>VISITOR</com:type>"+
				"</panelist>"+
				"</panelists>"+
				"<attendees />"+
				"<event:sessionKey>"+session_key+"</event:sessionKey>"+
				"</bodyContent>"+
				"</body>"+
				"</serv:message>";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("XML", XML);

		return  WebExUtil.methodPost(webexUrl, map);
	}

	public String reg_Event(String username,String user_email,String session_key) throws UnsupportedEncodingException{
		String XML ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
		"<serv:message xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:serv=\"http://www.webex.com/schemas/2002/06/service\" xsi:schemaLocation=\"http://www.webex.com/schemas/2002/06/service http://www.webex.com/schemas/2002/06/service/service.xsd\">"+
		"<header>"+
		"<securityContext>"+
		"<webExID>webex@yindatech.com</webExID>"+
		"<password>Abc123</password>"+
		"<siteID>32757</siteID>"+
		"<partnerID>vhS2rVHylENr0TpnV1Urkg</partnerID>"+
		"<email>matl@yindatech.com</email>"+
		"</securityContext>"+
		"</header>"+
		"<body>"+
		"<bodyContent xsi:type= \"java:com.webex.service.binding.attendee.RegisterMeetingAttendee\">"+
		"<attendees>"+
		"<person>"+
		"<name>"+username+"</name>"+
		"<title>title</title>"+
		"<company>yinda</company>"+
		"<address>"+
		"<addressType>PERSONAL</addressType>"+
		"<city>shanghai</city>"+
		"<country>china</country>"+
		"</address>"+

		"<email>"+user_email+"</email>"+
		"<notes>notes</notes>"+
		"<url>https://</url>"+
		"<type>VISITOR</type>"+
		"</person>"+
		"<joinStatus>ACCEPT</joinStatus>"+
		"<role>ATTENDEE</role>"+
		"<emailInvitations>true</emailInvitations>"+
		"<sessionKey>"+session_key+"</sessionKey>"+
		"</attendees>"+

		"</bodyContent>"+
		"</body>"+
		"</serv:message>";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("XML", XML);

		return  WebExUtil.methodPost(webexUrl, map);
	}
	public ModelAndView get_Event() throws ClientProtocolException, ParseException, IOException, URISyntaxException{

		ModelAndView mav = new ModelAndView();
		mav.setViewName("webex/create_meeting");
		String webexUrl ="https://yinda.webex.com.cn/WBXService/xml8.0.0/XMLService";

		String XML =readTxtFile("C:\\Users\\yexianglei\\Desktop\\1.txt");
		String xml ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
				"<serv:message xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"+
				" <header>"+
				" <securityContext>"+
				"<webExID>webex@yindatech.com</webExID>"+
				"<password>Abc123</password>"+
				"<siteID>32757</siteID>"+
				"<partnerID>vhS2rVHylENr0TpnV1Urkg</partnerID>"+
				"<email>matl@yindatech.com</email>"+
				" </securityContext>"+
				" </header>"+
				"<body>"+
				" <bodyContent xsi:type=\"java:com.webex.service.binding.event.GetEvent\">"+
				"<sessionKey>188728235</sessionKey>"+
				" </bodyContent>"+
				" </body>"+
				"</serv:message>";
		String json  ="{'XML':"+xml+"}";


		Map<String, Object> map = new HashMap<String, Object>();
		map.put("XML", xml);
		System.out.println("______________________");
		//System.out.println(doPost(webexUrl, map));
		WebExUtil.methodPost(webexUrl, map);
		System.out.println("______________________");
		String url ="https://yinda.webex.com.cn/WBXService/xml8.0.0/XMLService";
		//httpGet(url+"&XML="+xml);


		return mav;
	}


	/**
	 * 功能：Java读取txt文件的内容
	 * 步骤：1：先获得文件句柄
	 * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
	 * 3：读取到输入流后，需要读取生成字节流
	 * 4：一行一行的输出。readline()。
	 * 备注：需要考虑的是异常情况
	 * @param filePath
	 */
	public  String readTxtFile(String filePath){
		String str ="";
		try {
			String encoding="UTF-8";
			File file=new File(filePath);
			if(file.isFile() && file.exists()){ //判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file),encoding);//考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while((lineTxt = bufferedReader.readLine()) != null){
					str +=lineTxt;
				}
				read.close();
			}else{
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return str;

	}

	public static void main(String[] args) {

		//System.out.println(WebExController.readTxtFile("C:\\Users\\yexianglei\\Desktop\\1.txt"));
		WebExController e = new WebExController();
		try {
			e.get_Event();
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}






	/** 
	 * 默认编码utf -8 
	 * Obtains character set of the entity, if known. 
	 *  
	 * @param entity must not be null 
	 * @return the character set, or null if not found 
	 * @throws ParseException if header elements cannot be parsed 
	 * @throws IllegalArgumentException if entity is null 
	 */    
	private static String getContentCharSet(final HttpEntity entity)   
			throws ParseException {   

		if (entity == null) {   
			throw new IllegalArgumentException("HTTP entity may not be null");   
		}   
		String charset = null;   
		if (entity.getContentType() != null) {    
			HeaderElement values[] = entity.getContentType().getElements();   
			if (values.length > 0) {   
				NameValuePair param = values[0].getParameterByName("charset" );   
				if (param != null) {   
					charset = param.getValue();   
				}   
			}   
		}   

		if(StringUtils.isEmpty(charset)){  
			charset = "UTF-8";  
		}  
		return charset;   
	} 

	/**
	 * 发送 POST 请求（HTTP），K-V形式
	 * @param apiUrl API接口URL
	 * @param params 参数map
	 * @return
	 */
	private static RequestConfig requestConfig;
	public static String doPost(String apiUrl, Map<String, Object> params) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String httpStr = null;
		HttpPost httpPost = new HttpPost(apiUrl);
		CloseableHttpResponse response = null;

		try {
			httpPost.setConfig(requestConfig);
			List<NameValuePair> pairList = new ArrayList<>(params.size());
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				NameValuePair pair = new BasicNameValuePair(entry.getKey(), URLEncoder.encode(entry
						.getValue().toString(), "UTF-8"));
				pairList.add(pair);
			}

			httpPost.setEntity(new UrlEncodedFormEntity(pairList, "UTF-8"));

			response = httpClient.execute(httpPost);
			System.out.println(response.toString());
			HttpEntity entity = response.getEntity();
			httpStr = EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					EntityUtils.consume(response.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return httpStr;
	}

	/**
	 * 音达会议列表
	 * @return
	 */
	@RequestMapping("meeting_list.do")
	public ModelAndView meeting_list(){
		ModelAndView mav = new ModelAndView();
		WebexExample example = new WebexExample();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
	/*	WebexExample.Criteria criteria = example.createCriteria();    			
		List<Webex> webexList = webexMapper.selectByExample(example);*/
		List<Webex> reList = new ArrayList<Webex>();
		List<Webex> webexList  =webexMapper.select_all();
        for(Webex w :webexList){
        	try {
				Date d =sdf.parse(w.getMeetingTime());
				d.setMinutes(d.getMinutes()+Integer.valueOf(w.getMeetingLength()));
				
				if(new Date().before(d)){
				     reList.add(w);
				}
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		mav.addObject("webexList", reList);
		mav.setViewName("webex/dd_meeting_list");
		return mav;
	}

	@RequestMapping(value ="create_dd_meeting.do",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String create_dd_meeting(String meeting_name,String meeting_desc,String meeting_time,String meeting_count,String meeting_password,String meeting_length,String user_email,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webex/create_dd_meeting_success");
		/*
		 *日期格式 
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");//04/05/2017 10:00:00

		try {

			/*
			 *前端时间控件的格式和webex接口所需要的XML是不一致的 
			 */
		   
			Date time = sdf.parse(meeting_time);
			sdf1.format(time);
			String webex_meeting_time = sdf1.format(time);
			
			/*
			 * 比较是否与之前的会议冲突;
			 */
			List<String> w = webexMapper.select_by_time(meeting_time);
			if(w!=null && w.size()>0){
			
				return w.get(0); 
			}

			/*
			 *创建会议 
			 */
			String res;
			try {
				res = create_Event(meeting_name, meeting_desc, webex_meeting_time, meeting_count, meeting_password, meeting_length);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				return "error";
			}

			/*
			 *判断是否创建成功 
			 */
			if(!res.contains("SUCCESS")){
				mav.setViewName("webex/create_dd_meeting_error");
				return "error";            	
			}
			/*
			 *创建成功后 保存到数据库 
			 */

			Webex webex = new Webex();
			webex.setMeetingLength(meeting_length);
			webex.setMeetingCount(meeting_count);
			webex.setMeetingPassword(meeting_password);
			webex.setMeetingName(meeting_name);
			webex.setMeetingTime(meeting_time);
			webex.setMeetingDesc(meeting_desc);
			/*
			 *获取中的值，也就是我们需要的seeionkey
			 */
			String sessionKey =match("<event:sessionKey>","</event:sessionKey>",res);
			webex.setSessionKey(sessionKey);
			webexMapper.insert(webex);
			
			
			/*
			 *webex免注册
			 */
			String res1 ="";
			try {
				res1=reg_Event("主持人",user_email, sessionKey);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				return "error";
			}
			if(res==null){
				
					return "error";
			}
		   if(!res.contains("SUCCESS")){
			   mav.setViewName("webex/dd_meeting_apply_error");
				return "error";
		   }
            
           /**
            * 获取主持人秘钥
            */
			String hostKey  = get_Event(sessionKey);
		
			  /*
			    *钉钉发送消息 
			    */
			   
			String meeting_url="https://yinda.webex.com.cn";
			String staff_user_id = (String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);
			sendMessage("您好！您刚刚申请的音达的会议;\n会议名称："+meeting_name+";\n活动号："+sessionKey+";\n密码："+meeting_password +";\n会议地址(pc地址)："+meeting_url+" ; \n "+
			"主持人邮箱："+user_email+"\n主持人秘钥为："+hostKey+"(提前20分钟进入会议，成为主持人；如若遗忘或者丢失，请联系管理员)\n"+sdf.format(new Date()),staff_user_id );
				 
			
			mav.setViewName("webex/create_dd_meeting_success");
			return "success";

		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mav.setViewName("webex/create_dd_meeting_error");
			return "error";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		} catch (OApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}  


	}
	@RequestMapping("create_dd_meeting_success.do")
	public ModelAndView create_dd_meeting_success(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webex/create_dd_meeting_success");
		return mav;
	}
	@RequestMapping("create_dd_meeting_error.do")
	public ModelAndView create_dd_meeting_error(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webex/create_dd_meeting_error");
		return mav;
	}
	
	@RequestMapping("create_dd_meeting_time_error.do")
	public ModelAndView create_dd_meeting_time_error(String meeting_name){
		ModelAndView mav = new ModelAndView();
		mav.addObject("meeting_name", meeting_name);
		System.out.println("------------------"+meeting_name);
		mav.setViewName("webex/create_dd_meeting_time_error");
		return mav;
	}
	
	@RequestMapping("add_dd_meeting")
	public ModelAndView add_dd_meeting(String id,String session_key,String meeting_name,String meeting_time,String meeting_password,String user_email,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/*
		 * 获取用户信息
		 */		
		String username = (String) request.getSession().getAttribute(GlobalConstant.user_name);
		if(username == null){
			username = "匿名";
		}
		/*
		 *界面返回值 
		 */
		Webex webex = new Webex();		
		webex.setMeetingName(meeting_name);
		webex.setMeetingTime(meeting_time);
		webex.setMeetingPassword(meeting_password);
		webex.setSessionKey(session_key);

		String meeting_url="https://yinda.webex.com.cn";

		/*
		 *webex免注册
		 */
		String res ="";
		try {
			res=reg_Event(username,user_email, session_key);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mav.setViewName("webex/dd_meeting_apply_error");
			return mav;
		}
		if(res==null){
			 mav.setViewName("webex/dd_meeting_apply_error");
				return mav;
		}
	   if(!res.contains("SUCCESS")){
		   mav.setViewName("webex/dd_meeting_apply_error");
			return mav;
	   }
	   
	   /*
	    *钉钉发送消息 
	    */
	   
	   
	   try {
		   
		   String staff_user_id = (String) request.getSession().getAttribute(GlobalConstant.user_staff_user_id);
		   sendMessage("您好！您刚刚申请的音达的会议;\n会议名称："+meeting_name+";\n活动号："+session_key+";\n密码："+meeting_password +";\n会议地址(pc地址)："+meeting_url+" ; \n "+sdf.format(new Date()),staff_user_id );
		 
	} catch (OApiException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		mav.addObject("webex", webex);	
		mav.addObject("meeting_url", meeting_url);

		mav.setViewName("webex/dd_meeting_apply_success");
		return mav;
	}
	
	  /**
	   * 推送普通提示信息
	   * @param message
	   * @param staff_user_id
	   * @return
	   * @throws OApiException
	   */
    public static JSONObject sendMessage(String message,String staff_user_id) throws OApiException{
  	  
  	  String  contentJson ="{'touser':'"+staff_user_id+"','toparty':'1','agentid':'78682896','msgtype':'text','text':{'content':'"+message+"'}}";
  	  String  access_token = OrderMessageUtil.getAccess_token();
  	  JSONObject json=HttpsUtil.httpPost("https://oapi.dingtalk.com/message/send?access_token="+access_token,contentJson);
	      return json;
	
}
}
