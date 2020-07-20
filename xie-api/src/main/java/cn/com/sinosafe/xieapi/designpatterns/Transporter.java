package cn.com.sinosafe.xieapi.designpatterns;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by xiehanchun on 2020/7/20
 */
public class Transporter {
    private String string;

    public Transporter(String str) {
        this.string = str;
    }

    public void sendRequest(Map<String,String> map) {
        map.put("string",string);

        /**
         * 迭代遍历
         */
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key:"+entry.getKey()+"-------"+"value:"+entry.getValue());
        }

        /**
         * for循环遍历
         */
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println("key:"+entry.getKey()+"-------"+"value:"+entry.getValue());
//        }
    }
}
