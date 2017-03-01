package com.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;


public class WebExUtil {
	 
    public static List<String> match(String s) {
        List<String> results = new ArrayList<String>();
        Pattern p = Pattern.compile("<icon>([\\w/\\.]*)</icon>");
        Matcher m = p.matcher(s);
        while (!m.hitEnd() && m.find()) {
            results.add(m.group(1));
        }
        return results;
    }
 
    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "dfdds<icon>image/expressions/p24.gif</icon>你好<icon>image/expressions/p25.gif</icon>";
        System.out.println(Arrays.toString(WebExUtil.match(s).toArray(
                new String[0])));
    }
    
    /**
     * 模拟表单提交
     *@param url
     *@param data
     *@return
     * @throws UnsupportedEncodingException 
     *@since 2016-6-27 
     */
    public static String methodPost(String url, Map<String, Object> map) throws UnsupportedEncodingException{  
    	 List<NameValuePair> pairList = new ArrayList<>(map.size());
    	  
    	  for (Map.Entry<String, Object> entry : map.entrySet()) {
              NameValuePair pair = new NameValuePair(entry.getKey(),
            		  
            		  entry.getValue().toString());
              
              pairList.add(pair);
          }
        String response= "";//要返回的response信息  
        HttpClient httpClient = new HttpClient();  
        PostMethod postMethod = new PostMethod(url);  
        //设置编码
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        // 将表单的值放入postMethod中  
        postMethod.setRequestBody( pairList.toArray(new NameValuePair [map.size()])); 
        
        // 执行postMethod  
        int statusCode = 0;  
        try {  
            statusCode = httpClient.executeMethod(postMethod);  
        } catch (HttpException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        try {  
            response= postMethod.getResponseBodyAsString();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return response;  
    }  
 
}