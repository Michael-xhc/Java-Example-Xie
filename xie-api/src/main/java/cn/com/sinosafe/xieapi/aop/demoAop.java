/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xieapi.aop
 * fileName: demoAop.java
 * date: 2020-03-09 17:51
 * copyright(c) 2019-  华安保险公司
 *//*

package cn.com.sinosafe.xieapi.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

*/
/**
 * @description: aop
 * @packageName: cn.com.sinosafe.xieapi.aop
 * @className: demoAop
 * @author: xiehanchun
 * @data: 2020-03-09 17:51
 * @version: v1.0
 **//*

public class demoAop {

    @Component
    @Aspect
    public class AspectImpl {
        @Pointcut("@annotation(cn.com.sinosafe.xiecommon.annotation.Authentication)")
        private void cut() {
            System.out.println("3");
        }

        */
/**
         * @Description //开始环绕
         * @Author xiehanchun
         * @Date 2020/3/9 18:25
         * @Param [joinPoint]
         * @return void
        **//*

        @Around("cut()")
        public void around(ProceedingJoinPoint joinPoint) throws Throwable {
            System.out.println("1");
            try {
                joinPoint.proceed();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("4");
        }

        @Before("cut()")
        public void before() {
            System.out.println("2");
        }

        @After("cut()")
        public void after() {
        }
    }
}
*/
