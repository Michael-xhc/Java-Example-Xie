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

/*Retention注解
        Retention(保留)注解说明,这种类型的注解会被保留到那个阶段. 有三个值:
        1.RetentionPolicy.SOURCE —— 这种类型的Annotations只在源代码级别保留,编译时就会被忽略
        2.RetentionPolicy.CLASS —— 这种类型的Annotations编译时被保留,在class文件中存在,但JVM将会忽略
        3.RetentionPolicy.RUNTIME —— 这种类型的Annotations将被JVM保留,所以他们能在运行时被JVM或其他使用反射机制的代码所读取和使用.
        上面示例中, @Retention(RetentionPolicy.RUNTIME)注解表明 Test_Retention注解将会由虚拟机保留,以便它可以在运行时通过反射读取.
        Target注解
@Target说明了Annotation所修饰的对象范围：Annotation可被用于 packages、types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数）。在Annotation类型的声明中使用了target可更加明晰其修饰的目标。
        作用：用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
        取值(ElementType)有：
        1.CONSTRUCTOR:用于描述构造器
        2.FIELD:用于描述域
        3.LOCAL_VARIABLE:用于描述局部变量
        4.METHOD:用于描述方法
        5.PACKAGE:用于描述包
        6.PARAMETER:用于描述参数
        7.TYPE:用于描述类、接口(包括注解类型) 或enum声明*/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Authentication {
}