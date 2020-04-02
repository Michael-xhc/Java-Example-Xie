/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xieapi.testController
 * fileName: DemoCotroller.java
 * date: 2020-03-24 14:02
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.testController;

import cn.com.sinosafe.xiecommon.utils.ParamUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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


//    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_YEAR, 2);
//        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_TIME);
//        System.out.println(sdf.format(calendar.getTime()));
//    }

    public static void main(String[] args) {
        String str = null;
        ParamUtils.notEmpty(str,"name");
    }

}
