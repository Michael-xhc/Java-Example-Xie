package cn.com.sinosafe.xiecommon.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName:  Authentication   
 * @Description:自定义登录鉴权注解   
 * @author: HuYang
 * @date:   2020年2月12日 上午10:47:13      
 * @Copyright:
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Authentication {

}