/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xieapi.testController
 * fileName: DemoCotroller.java
 * date: 2020-03-24 14:02
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.testController;

import cn.com.sinosafe.xiecommon.utils.ParamUtils;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 测试类
 * @packageName: cn.com.sinosafe.xieapi.testController
 * @className: DemoCotroller
 * @author: xiehanchun
 * @data: 2020-03-24 14:02
 * @version: v1.0
 */
public class DemoCotroller {

//    public static void main(String[] args) {
//         try {
//             int i = 5/0;
//         }catch (Exception e){
//             System.out.println("抛出异常"+e.getMessage());
//         }finally {
//             System.out.println("last prinln");
//         }
//    }
public static String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";

private static Pattern NUMBER_PATTERN= Pattern.compile("【.+?】");

//    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_YEAR, 2);
//        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_TIME);
//        System.out.println(sdf.format(calendar.getTime()));
//    }

//    public static void main(String[] args) {
//        String str = null;
//        ParamUtils.notEmpty(str,"name");

//        List<String> list = new ArrayList<String>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        list.add("6");
//        list.add("7");
//        list.add("8");
//
//        int listSize=list.size();
//        int toIndex=2;
//        //用map存起来新的分组后数据
//        Map<String, List<String>> map = new HashMap();
//        int keyToken = 0;
//        for(int i = 0;i<listSize;i+=2) {
//            //作用为toIndex最后没有200条数据则剩余几条newList中就装几条
//            if(i+2>listSize){
//                toIndex=listSize-i;
//            }
//            List<String> newList = list.subList(i,i+toIndex);
//            map.put("keyName"+keyToken, newList);
//            keyToken++;
//        }
//
//        for (List<String> value : map.values()) {
//            System.out.println(value);
//            for (String s : value) {
//                System.out.println(s);
//            }
//        }

//        String str = "[]";
//        JSONArray errMsgs = com.alibaba.fastjson.JSONArray.parseArray(str);
//        if(errMsgs.size()>0) {
//            String string = errMsgs.getString(0);
//            System.out.println(string.toString());
//            Matcher m = NUMBER_PATTERN.matcher("【AA】XXX,【BB】XXX");
//
//            while (m.find()) {
//                System.out.println(m.group().replaceAll("[【】]", ""));
//            }
//        }else{
//            System.out.println("ssdfhf");
//        }
//    }

    public static void main(String[] args) {
        /*String s  = "([)]";
        int left1 = 0;
        int left2 = 0;
        int left3 = 0;
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            String str = String.valueOf(c);
            if("(".equals(str)){
                ++left1;
            }else if(")".equals(str)){
                if(left1>0){
                    --left1;
                }else{
                    System.out.println("表达式错误");
                }
            }else if("[".equals(str)){
                ++left2;
            }else if("]".equals(str)){
                if(left2>0){
                    --left2;
                }else{
                    System.out.println("表达式错误");
                }
            }else if("{".equals(str)){
                ++left3;
            }else if("}".equals(str)){
                if(left3>0){
                    --left3;
                }else{
                    System.out.println("表达式错误");
                }
            }
        }
        if(left1==0 && left2==0 && left3==0){
            System.out.println("表达式正确");
        }else{
            System.out.println("表达式错误");
        }*/

    }

}
