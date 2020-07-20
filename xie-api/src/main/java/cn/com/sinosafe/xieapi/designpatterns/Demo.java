package cn.com.sinosafe.xieapi.designpatterns;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiehanchun on 2020/7/20
 */
public class Demo {
    public void demoFunction(Transporter transporter) {
        Map<String,String> map = new HashMap<>();
        transporter.sendRequest(map);
        System.out.println("-------");
    }
}
