/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xieapi
 * fileName: singleton.java
 * date: 2020-04-07 15:04
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi;
//
//import cn.com.sinosafe.xie.user.domain.UserBaseInfo;
//import org.apache.commons.collections4.Put;
//import sun.security.jca.GetInstance;
//
//import javax.xml.crypto.KeySelector;

/**
 * @description: 单例模式
 * @packageName: cn.com.sinosafe.xieapi
 * @className: singleton
 * @author: xiehanchun
 * @data: 2020-04-07 15:04
 * @version: v1.0
 */
public class Singleton {
    //饿汉模式
//    private static final Singleton instance = new Singleton();
    //懒汉模式
    private static Singleton instance;

    public Singleton(){}

    //饿汉模式
//    public static Singleton getInstance(){
//        return instance;
//    }

    //懒汉模式
//    public static synchronized Singleton getInstance(){
//        if(instance == null){
//            instance = new Singleton();
//        }
//        return instance;
//    }
    //双重检测
//    public static Singleton getInstance(){
//        if(instance == null){
//            synchronized (Singleton.class){
//                instance = new Singleton();
//            }
//        }
//        return instance;
//    }

     public static class SingletonHolder{
         private static final Singleton instance = new Singleton();
     }

     public static Singleton getInstance(){
        return SingletonHolder.instance;
     }

//    public UserBaseInfo getUserBaseInfo(){
//        UserBaseInfo userBaseInfo = new UserBaseInfo();
//        userBaseInfo.setApplyId("12334");
//        return userBaseInfo;
//    }
}
