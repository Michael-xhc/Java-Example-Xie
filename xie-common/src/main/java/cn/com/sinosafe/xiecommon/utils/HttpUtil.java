package cn.com.sinosafe.xiecommon.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.Consts;
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
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @Description //Http工具类
 * @Author xiehanchun
 * @Date 2020/3/30 14:31
 * @Param
 * @return
 */
public class HttpUtil {
//   private static final Logger log = LoggerFactory.getLogger(HttpUtil.class);

	public static class UTF8PostMethod extends PostMethod {
		public UTF8PostMethod(String url) {
			super(url);
		}

		@Override
		public String getRequestCharSet() {
			// return super.getRequestCharSet();
 			 	return "UTF-8";
		}
	}

	/**
	 * POST请求的方式数据放入请求体，以application/json的方式
	 * MQ调用方法
	 * @author dwj
	 * @param url
	 * @param params
	 * @return
	 */
	public static String sendPostWithJson(String url, Map<String, Object> params) {
		// 响应结果
		String responseContent = null;

		org.apache.http.client.HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			// httpClient = new DefaultHttpClient();
			httpClient = createSSLClientDefault();


			httpPost = new HttpPost(url);
			RequestConfig requestConfig =  RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000).build();
			httpPost.setConfig(requestConfig);
			JSONObject paraJson = new JSONObject();
			if (params != null) {
				for (Entry<String, Object> entry : params.entrySet()) {
					paraJson.put(entry.getKey(),
							entry.getValue());
				}
			}
			// 解决中文乱码问题 httpPost.setEntity(entity);
			StringEntity entity = new StringEntity(paraJson.toString(), "utf-8");
			httpPost.setEntity(entity);
			httpPost.setHeader("Content-Type", "application/json");
			org.apache.http.HttpResponse response = httpClient
					.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, "UTF-8");
					responseContent = result;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return responseContent;
	}

	/**
	 * POST请求的方式数据放入请求体，以text/plain的方式
	 * MQ调用方法
	 * @author dwj
	 * @param url
	 * @param params
	 * @return
	 */
	public static String sendPostWithText(String url, Map<String, Object> params) {
		// 响应结果
		String responseContent = null;

		org.apache.http.client.HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			// httpClient = new DefaultHttpClient();
			httpClient = createSSLClientDefault();

			httpPost = new HttpPost(url);
			JSONObject paraJson = new JSONObject();
			if (params != null) {
				for (Entry<String, Object> entry : params.entrySet()) {
					paraJson.put(entry.getKey(),
							entry.getValue());
				}
			}
			// 解决中文乱码问题 httpPost.setEntity(entity);
			StringEntity entity = new StringEntity(paraJson.toString(), "utf-8");
			httpPost.setEntity(entity);
			httpPost.setHeader("Content-Type", "text/plain");
			org.apache.http.HttpResponse response = httpClient
					.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, "UTF-8");
					responseContent = result;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return responseContent;
	}

	/**
	 * POST请求的方式数据放入请求体，以application/json的方式
	 * @param url
	 * @param jsonData
	 * @return
	 */
	public static String sendPostWithJson(String url, String jsonData) {
		// 响应结果
		String responseContent = null;

		org.apache.http.client.HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			// httpClient = new DefaultHttpClient();
			httpClient = createSSLClientDefault();

			httpPost = new HttpPost(url);
			RequestConfig requestConfig =  RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000).build();
			httpPost.setConfig(requestConfig);
			// 解决中文乱码问题 httpPost.setEntity(entity);
			StringEntity entity = new StringEntity(jsonData, "utf-8");
			httpPost.setEntity(entity);
			httpPost.setHeader("Content-Type", "application/json");
			org.apache.http.HttpResponse response = httpClient
					.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, "UTF-8");
					responseContent = result;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return responseContent;
	}

	/**
	* @Title: sendGetReq
	* @Description: 发送get请求
	* @param reqUrl
	* @param paramMap    
	* @return void    
	* @throws
	 */
	public static String sendGetReq(String reqUrl, Map<String, String> paramMap) {
		CloseableHttpClient client = HttpClients.createDefault();
		try {
			List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
			for(String key:paramMap.keySet()) {
				list.add(new BasicNameValuePair(key, paramMap.get(key)));
			}
			String params = EntityUtils.toString(new UrlEncodedFormEntity(list, Consts.UTF_8));
			System.out.println("sendGetReq请求参数:"+params);
			HttpGet httpGet = new HttpGet(reqUrl+"?"+params);
			CloseableHttpResponse response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			System.out.println("sendGetReq返回参数:"+result);
			response.close();
			return result;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
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
	/**
     * 以Post Multipart/Form-Data的方式请求
     * @param reqUrl
     * @param builder
     * @return
     */
	public static String sendOcrPost(String reqUrl, MultipartEntityBuilder builder) {
    	String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(reqUrl);
        HttpEntity reqEntity = builder.build();
        post.setEntity(reqEntity);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(post);
            if(response != null && response.getStatusLine().getStatusCode() == 200)
            {
            	HttpEntity entity = response.getEntity();
            	result = entityToString(entity);
            }
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
                if(response != null)
                {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
	}
	private static String entityToString(HttpEntity entity) throws IOException {
        String result = null;
        if(entity != null)
        {
            long lenth = entity.getContentLength();
            if(lenth != -1 && lenth < 2048)
            {
                result = EntityUtils.toString(entity,"UTF-8");
            }else {
                InputStreamReader reader1 = new InputStreamReader(entity.getContent(), "UTF-8");
                CharArrayBuffer buffer = new CharArrayBuffer(2048);
                char[] tmp = new char[1024];
                int l;
                while((l = reader1.read(tmp)) != -1) {
                    buffer.append(tmp, 0, l);
                }
                result = buffer.toString();
            }
        }
        return result;
    }

    /**
     * @Description: 向指定 URL 发送GET方法的请求
     * @Param: [url, param]  发送请求的 URL 请求参数，请求参数应该是 name1=value1&name2=value2 的形式
     * @Return: java.lang.String
     * @Author: xiehanchun
     * @Date: 2020/2/26
     */
    public static String sendGet(String url, String param)
    {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try
        {
            String urlNameString = url + "?" + param;
//            log.info("sendGet - {}", urlNameString);
            URL realUrl = new URL(urlNameString);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null)
            {
                result.append(line);
            }
//            log.info("recv - {}", result);
        }
        catch (ConnectException e)
        {
//            log.error("调用HttpUtils.sendGet ConnectException, url=" + url + ",param=" + param, e);
        }
        catch (SocketTimeoutException e)
        {
//            log.error("调用HttpUtils.sendGet SocketTimeoutException, url=" + url + ",param=" + param, e);
        }
        catch (IOException e)
        {
//            log.error("调用HttpUtils.sendGet IOException, url=" + url + ",param=" + param, e);
        }
        catch (Exception e)
        {
//            log.error("调用HttpsUtil.sendGet Exception, url=" + url + ",param=" + param, e);
        }
        finally
        {
            try
            {
                if (in != null)
                {
                    in.close();
                }
            }
            catch (Exception ex)
            {
//                log.error("调用in.close Exception, url=" + url + ",param=" + param, ex);
            }
        }
        return result.toString();
    }

    /**
     * @Description: Map参数转&连接符形式的http请求参数
     * @Param: [paramMap] method	http请求类型：get、post、put、delete
     * @Return: java.lang.String
     * @Author: xiehanchun
     * @Date: 2020/2/26
     */
    public static String httpParamObjConver(Map<String, Object> paramMap) {
        StringBuffer param = new StringBuffer();
        for (String key : paramMap.keySet()) {
            param.append("&");
            Object value = paramMap.get(key);
            if (value == null) continue;

            //如果是数据，说明需要拼接一个参数多个值
            if (value.getClass().isArray())
                param.append(concatParams(key, (Object[]) value));
            else
                param.append(key).append("=").append(value);
        }
        return param.toString();
    }

    /**
     * @Description: 拼接一个参数多个值情况
     * @Param: [key, values]
     * @Return: java.lang.String
     * @Author: xiehanchun
     * @Date: 2020/2/26
     */
    private static String concatParams(String key, Object[] values) {
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        for (Object value: values) {
            if (i != 0)
                buffer.append("&");
            buffer.append(key).append("=").append(value);
            i++;
        }
        return buffer.toString();
    }
    
    @SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public static String sendPost(String url, Map<String, Object> params) {
    	String result = null;  
        try{  
        	HttpClient httpClient = null;
        	HttpPost httpPost = null;  
        	
            httpClient = new DefaultHttpClient();
            httpPost = new HttpPost(url);  
            //设置参数  
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = params.entrySet().iterator();  
            while(iterator.hasNext()){  
                Entry<String,String> elem = (Entry<String, String>) iterator.next();  
                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));  
            }  
            if(list.size() > 0){  
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");  
                httpPost.setEntity(entity);  
            }
           long t = System.currentTimeMillis();
            HttpResponse response = httpClient.execute(httpPost);
            if(response != null){  
                HttpEntity resEntity = response.getEntity();  
                if(resEntity != null){  
                    result = EntityUtils.toString(resEntity,"GBK");
                }  
            }  
        }catch(Exception ex){  
            ex.printStackTrace();  
        }
		return result;
	}
}
