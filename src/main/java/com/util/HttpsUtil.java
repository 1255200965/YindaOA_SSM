package com.util;

import java.io.IOException;
import java.net.URISyntaxException;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

import com.ddSdk.base.OApiException;

import bsh.ParseException;

@SuppressWarnings("deprecation")
public class HttpsUtil {
	//httpsPost请求
	public static String httpGet(String url) throws ClientProtocolException, IOException, URISyntaxException, ParseException {  
	            HttpClient httpclient = new DefaultHttpClient();  
	            String result = "";  
	             try {  
	                   // 连接超时  
	                  httpclient.getParams().setParameter(  
	                              CoreConnectionPNames. CONNECTION_TIMEOUT, 5000);  
	                   // 读取超时  
	                  httpclient.getParams().setParameter(  
	                              CoreConnectionPNames. SO_TIMEOUT, 5000);  
	                   HttpGet hg = new HttpGet (url);  
	                   //模拟浏览器  
	                  hg.addHeader( "User-Agent","Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31");   
	                  String charset = "UTF-8";   
	                  hg.setURI( new java.net.URI(url));   
	                        HttpResponse response = httpclient.execute(hg);   
	                        HttpEntity entity = response.getEntity();   
	                        if (entity != null) {   
	                            charset = getContentCharSet(entity);  
	                               // 使用EntityUtils的toString方法，传递编码，默认编码是ISO-8859-1   
	                            result = EntityUtils.toString(entity, charset);   
	                      }   
	        
	            } finally {  
	                  httpclient.getConnectionManager().shutdown();  
	            }  
	             return result;  
	      }  
	//https get请求
	public static JSONObject httpPost(String url, String json) throws OApiException {
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().
        		setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-Type", "application/json");

        try {
        	StringEntity requestEntity = new StringEntity(json, "utf-8");
            httpPost.setEntity(requestEntity);            
            response = httpClient.execute(httpPost, new BasicHttpContext());
            if (response.getStatusLine().getStatusCode() != 200) {
                System.out.println("request url failed, http code=" + response.getStatusLine().getStatusCode() + ", url=" + url);
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String resultStr = EntityUtils.toString(entity, "utf-8");
                JSONObject result = JSONObject.fromObject(resultStr);
                return result;
        } 
        }catch (IOException e) {
            System.out.println("request url=" + url + ", exception, msg=" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (response != null) try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
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
	    
}

