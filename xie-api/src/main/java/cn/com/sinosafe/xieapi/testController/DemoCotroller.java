/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xieapi.testController
 * fileName: DemoCotroller.java
 * date: 2020-03-24 14:02
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.testController;

/**
 * @description: 测试类
 * @packageName: cn.com.sinosafe.xieapi.testController
 * @className: DemoCotroller
 * @author: xiehanchun
 * @data: 2020-03-24 14:02
 * @version: v1.0
 */
public class DemoCotroller {

    public static void main(String[] args) {
         try {
             int i = 5/0;
         }catch (Exception e){
             System.out.println("抛出异常"+e.getMessage());
         }finally {
             System.out.println("last prinln");
         }
    }
}
