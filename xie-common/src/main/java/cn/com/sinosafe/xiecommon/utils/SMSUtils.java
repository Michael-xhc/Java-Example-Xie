package cn.com.sinosafe.xiecommon.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.Map.Entry;


/**
 * 短信相关的工具类*
 * 
 * @author sinosafe
 */
public class SMSUtils {
	private static final Logger log = LoggerFactory.getLogger(SMSUtils.class);

	/**
	 * 短信网关接口地址、用户名、密码
	 */
	private static String SMS_URL = "http://msgplat.sinosafe.com.cn:80/sms/Api/Send.do";
	private static String SMS_USER = "H04";
	private static String SMS_PWD = "Hsms04";
	/**
	 * 生成短信验证码*
	 * 
	 * @param length
	 *            长度
	 * @return 指定长度的随机短信验证码
	 */
	public static final String randomSMSCode(int length) {
		return randomSMSCode(length, true);
	}
	/**
	 * 生成短信验证码*
	 * 
	 * @param length
	 *            长度
	 * @param numberFlag  是否只是数字：true 纯数字，false数字+字母
	 * @return 指定长度的随机短信验证码
	 */
	public static final String randomSMSCode(int length, boolean numberFlag) {
		String retStr = "";
		String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		boolean bDone = true;
		do {
			retStr = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				retStr += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);
		return retStr;
	}


	/*
	 * 判断字符串中是否为正整数用逗号分隔：
	 */
	public static boolean isLegal(String str) {
		String regex = "^\\d+(,\\d+)*$";
		return str.matches(regex);
	}
	
	/**
	 * 此函数是主动向短信平台发起的http请求,并接收短信平台的响应
	 * 
	 * @param msg
	 *            发送内容
	 * @return
	 * @throws Exception
	 */
	public static boolean sendCode(String phone,String message){  
        return sendPhone(phone, "您的验证码是：" + message + "。请妥善保管！");  
    }

	/**
	 * 发送业务短信
	 * @param phone  手机号码
	 * @param message  业务信息
	 * @return
	 */
	public static boolean sendMessage(String phone,String message){
		return sendPhone(phone, message);
	}

	/**
	 * 手机短信平台登录及发送信息
	 * @author liansonghui
	 * @param phone
	 * @param flag
	 * @param params
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
	public static boolean sendPhone(String phone, String message) {
		boolean flag = false;
		Map<String, String> params = new HashMap<String, String>(16);
    	params.put("MessageContent", message);
		String url = SMS_URL;
		params.put("SpCode", "200097");
		params.put("LoginName", SMS_USER);
		params.put("Password", SMS_PWD);
		params.put("UserNumber", phone);
		params.put("SerialNumber", "");
		params.put("ScheduleTime", "");
		params.put("f", "1");
		params.put("busynessCode", "04");
		
        try{  
        	HttpClient httpClient = null;
        	HttpPost httpPost = null;
        	String result = null;  
        	
        	httpClient = new DefaultHttpClient();
            httpClient = createSSLClientDefault();  
            httpPost = new HttpPost(url);
            //设置参数  
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = params.entrySet().iterator();  
            while(iterator.hasNext()){  
                Entry<String,String> elem = (Entry<String, String>) iterator.next();  
                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
            }  
            if(list.size() > 0){  
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"GBK");
                httpPost.setEntity(entity);  
            }
           long t = System.currentTimeMillis();
            HttpResponse response = httpClient.execute(httpPost);
            log.info("【华安短信平台】给"+phone+"发送短信提交成功，耗时（ms）是："+(System.currentTimeMillis() - t));
            if(response != null){  
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){  
                    result = EntityUtils.toString(resEntity,"GBK");
                    String index = result.substring(7,8);
                    if ("0".equals(index)) {
                    	flag = true;
                    }
                    log.info("【华安短信平台】短信发送结果："+result);
                }  
            }  
        }catch(Exception ex){  
            ex.printStackTrace();  
        }
		return flag;
	}  

	private  static CloseableHttpClient createSSLClientDefault(){
  	  try {
  	    SSLContext sslContext = new SSLContextBuilder().setProtocol("TLSv1.2").loadTrustMaterial(null, new TrustStrategy() {
  	    //信任所有
  	        @Override
            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
  	            return true;
  	        }

  	    }).build();
  	    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
  	    return HttpClients.custom().setSSLSocketFactory(sslsf).build();
  	   } catch (KeyManagementException e) {
  	       e.printStackTrace();
  	   } catch (NoSuchAlgorithmException e) {
  	       e.printStackTrace();
  	   } catch (KeyStoreException e) {
  	       e.printStackTrace();
  	   }
  	   return  HttpClients.createDefault();
	}
}
