/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xiecommon.annotation
 * fileName: demoAop.java
 * date: 2020-03-17 15:52
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description: 测试
 * @packageName: cn.com.sinosafe.xiecommon.annotation
 * @className: demoAop
 * @author: xiehanchun
 * @data: 2020-03-17 15:52
 * @version: v1.0
 **/

//@Aspect：切面。表示一个横切进业务的一个对象。它里面包含切入点(Pointcut)和Advice（通知）。
//@Pointcut：切入点。表示需要切入的位置，比如某些类或者某些方法，也就是先定一个范围。
//@Before：Advice（通知）的一种，切入点的方法体执行之前执行。
//@Around：Advice（通知）的一种，环绕切入点执行也就是把切入点包裹起来执行。
//@After：Advice（通知）的一种，在切入点正常运行结束后执行。
//@AfterReturning：Advice（通知）的一种，在切入点正常运行结束后执行，异常则不执行
//@AfterThrowing：Advice（通知）的一种，在切入点运行异常时执行。

@Component
@Aspect
public class demoAop {
//    在Spring 2.0中，Pointcut的定义包括两个部分：Pointcut表示式(expression)和Pointcut签名(signature)。
//    让我们先看看execution表示式的格式：execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)throws-pattern?)
//    括号中各个pattern分别表示修饰符匹配（modifier-pattern?）、
//    返回值匹配（ret-type-pattern）、
//    类路径匹配（declaring-type-pattern?）、
//    方法名匹配（name-pattern）、
//    参数匹配（(param-pattern)）、
//    异常类型匹配（throws-pattern?），其中后面跟着“?”的是可选项。
//    在各个pattern中可以使用“”来表示匹配所有。在(param-pattern)中，可以指定具体的参数类型，多个参数间用“,”隔开，
//    各个也可以用“”来表示匹配任意类型的参数，如(String)表示匹配一个String参数的方法；(*,String)表示匹配有两个参数的方法，
//    第一个参数可以是任意类型，而第二个参数是String类型；可以用(..)表示零个或多个任意参数。

//    这是aop+自定义注解 aop拦截哪些包 哪些类 哪些方法 是统一做操作 而自定义注解是针对某一类 某一方法做操作
//    自定义注解也可以写自己的逻辑 配合aop就使得aop更加灵活
//    AOP：Aspect Oriented Programming，翻译过来就是大名鼎鼎的“面向切面编程”，它是对面向对象的一种补充和完善。
//    AOP的使用场景一般有：数据源切换、事务管理、权限控制、日志打印等。根据它的名字我们不难理解，它的实现很像是将我们要实现的代码切入业务实现的逻辑中。它有以下特点：
//            1、侵入性小，几乎可以不改动原来逻辑的情况下把新的逻辑加入业务。
//            2、实现方便，使用几个注解就可以实现，使系统更容易扩展。
//            3、更好的复用代码，比如事务日志打印，简单逻辑适合所有情况。

//        @Pointcut("execution(public * cn.com.sinosafe.xieapi.cost.CostController.returnUrl())")
        @Pointcut("@annotation(cn.com.sinosafe.xiecommon.annotation.Authentication)")
        private void cut() {
        }

        /**
         * @Description //开始环绕
         * @Author xiehanchun
         * @Date 2020/3/9 18:25
         * @Param [joinPoint]
         * @return void
         **/
/*        @Around("cut()") //cut()就是签名
        public void around(ProceedingJoinPoint joinPoint) throws Throwable {
            System.out.println("1");
            try {
                joinPoint.proceed();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("4");
        }*/

        @Before(value = "cut()")
        public void before() {
            System.out.println("方法前加入aop");
        }

//        @After("")
//        public void after() {
//        }

     /*各种@Pointcut配置解释*/

    /**
     * 1、使用within表达式匹配
     * 下面示例表示匹配com.leo.controller包下所有的类的方法
     */
//    @Pointcut("within(com.leo.controller..*)")
//    public void pointcutWithin(){
//
//    }

    /**
     * 2、this匹配目标指定的方法，此处就是HelloController的方法
     */
//    @Pointcut("this(com.leo.controller.HelloController)")
//    public void pointcutThis(){
//
//    }

    /**
     * 3、target匹配实现UserInfoService接口的目标对象
     */
//    @Pointcut("target(com.leo.service.UserInfoService)")
//    public void pointcutTarge(){
//
//    }

    /**
     * 4、bean匹配所有以Service结尾的bean里面的方法，
     * 注意：使用自动注入的时候默认实现类首字母小写为bean的id
     */
//    @Pointcut("bean(*ServiceImpl)")
//    public void pointcutBean(){
//
//    }

    /**
     * 5、args匹配第一个入参是String类型的方法
     */
//    @Pointcut("args(String, ..)")
//    public void pointcutArgs(){
//
//    }

    /**
     * 6、@annotation匹配是@Controller类型的方法
     */
//    @Pointcut("value = @annotation(org.springframework.stereotype.Controller)")
//    public void pointcutAnnocation(){
//
//    }
    /**
     * 7、@within匹配@Controller注解下的方法，要求注解的@Controller级别为@Retention(RetentionPolicy.CLASS)
     */
//    @Pointcut("value = @within(org.springframework.stereotype.Controller)")
//    public void pointcutWithinAnno(){
//
//    }
    /**
     * 8、@target匹配的是@Controller的类下面的方法，要求注解的@Controller级别为@Retention(RetentionPolicy.RUNTIME)
     */
//    @Pointcut("value = @target(org.springframework.stereotype.Controller)")
//    public void pointcutTargetAnno(){
//
//    }
    /**
     * 9、@args匹配参数中标注为@Sevice的注解的方法
     */
//    @Pointcut("value = @args(org.springframework.stereotype.Service)")
//    public void pointcutArgsAnno(){
//
//    }


    /**
     * 10、使用excution表达式
     * execution(
     *  modifier-pattern?           //用于匹配public、private等访问修饰符
     *  ret-type-pattern            //用于匹配返回值类型，不可省略
     *  declaring-type-pattern?     //用于匹配包类型
     *  name-pattern(param-pattern) //用于匹配类中的方法，不可省略
     *  throws-pattern?             //用于匹配抛出异常的方法
     * )
     *
     * 下面的表达式解释为：匹配com.leo.controller.HelloController类中以hello开头的修饰符为public返回类型任意的方法
     */
//    @Pointcut(value = "execution(public * com.leo.controller.HelloController.hello*(..))")
//    public void pointCut() {
//
//    }

     /**
       * @Description //TODO
       * @Author xiehanchun
       * @Date 2020/3/19 15:02
       * @Param
       * @return
      *
      * 1、新技术原理是什么 比如aop 面向切面编程  切点定义范围 在类、方法之前 之后 环绕切入
      * 2、解决了什么问题 比如aop 数据库切换 日志打印 事务管理 权限控制
      * 3、与之前技术相比 有哪些提升 解决了技术方面的缺点 比如aop 解决代码重复 为什么不直接把生成日志的代码
      *   抽成一个方法供调用 java 高内聚 低耦合 如果调用公共方法不就是与上一个有了耦合关系
      */
}
