/**
 * projectName: haxb-weixin-api
 * packageName: cn.com.sinosafe.common.util
 * fileName: LocationUtils.java
 * date: 2020-05-26 17:17
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xiecommon.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @description: 定位
 * @packageName: cn.com.sinosafe.common.util
 * @className: LocationUtils
 * @author: xiehanchun
 * @data: 2020-05-26 17:17
 * @version: v1.0
 */
@Slf4j
public class LocationUtils {

    /**
     * http://lbsyun.baidu.com/apiconsole/key
     * <百度开发者>用户申请注册的ak
     */
    final static String AK = "YdsZpQ4q5y5H3y6kQERmNGPk7XMPOgdy";
    /**
     * 逆地理编码 URL
     */
    private final static String LONGITUDE_TO_ADDRESS_URL = "http://api.map.baidu.com/reverse_geocoding/v3/?output=json&coordtype=BD09&pois=1";

    /**
     * @Description //根据经纬度查询位置
     * @Author xiehanchun
     * @Date 2020/5/26 17:20
     * @Param [lng, lat]
     * @return java.lang.String
     */
    public static String getAdd(String lng, String lat) {
        String baiduUrl = LONGITUDE_TO_ADDRESS_URL + "&ak=" + AK + "&location=" + lat + "," + lng;
        log.info("请求url:" + baiduUrl);
        String res = null;
        BufferedReader in = null;
        try {
            URL url = new URL(baiduUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = null;
            while ((line = in.readLine()) != null) {
                JSONObject parse = JSONObject.parseObject(line);
                if(StringUtils.equals(parse.getString("status"),"0")) {
                    JSONObject result = parse.getJSONObject("result");
                    res = result.getString("formatted_address");
                }
                return res;
            }
        } catch (Exception e) {
            log.info("根据经纬度定位失败，error："+e.getMessage());
        } finally{
            try{
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
