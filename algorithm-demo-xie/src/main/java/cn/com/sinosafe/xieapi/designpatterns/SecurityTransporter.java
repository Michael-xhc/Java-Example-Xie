package cn.com.sinosafe.xieapi.designpatterns;


import cn.com.sinosafe.xiecommon.utils.StringUtils;

import java.util.Map;

/**
 * Created by xiehanchun on 2020/7/20
 */
public class SecurityTransporter extends Transporter{
    private String appId;
    private String appToken;

    public SecurityTransporter(String str, String appId, String appToken) {
        super(str);
        this.appId = appId;
        this.appToken = appToken;
    }

    @Override
    public void sendRequest(Map<String,String> map) {
        if (StringUtils.isNotEmpty(appId) && StringUtils.isNotEmpty(appToken)) {
            map.put("appId",appId);
            map.put("appToken",appToken);
        }
        super.sendRequest(map);
    }
}
