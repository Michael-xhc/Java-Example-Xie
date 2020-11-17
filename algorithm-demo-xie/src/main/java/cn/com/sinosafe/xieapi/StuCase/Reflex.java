package cn.com.sinosafe.xieapi.StuCase;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by xiehanchun on 2020/11/16
 */
public class Reflex {
    private int id;
    private String name;

    public Reflex() {}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        Reflex at = new Reflex();
        at.setId(1);
        at.setName("AT");

        Class clazz = Class.forName("cn.com.sinosafe.xieapi.StuCase.Reflex");
        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(false);//AccessibleTest类中的成员变量为private,故必须进行此操作
            System.out.println(f.get(at));//获取当前对象中当前Field的value
//            System.out.println(f);
        }

//        for (Method declaredMethod : clazz.getDeclaredMethods()) {
//            System.out.println(declaredMethod);
//        }
    }
}


