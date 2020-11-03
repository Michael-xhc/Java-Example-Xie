/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xieapi.testcontroller
 * fileName: FileTest.java
 * date: 2020-03-26 16:18
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.testcontroller;

import java.io.File;
import java.io.IOException;

/**
 * @description: 文件测试
 * @packageName: cn.com.sinosafe.xieapi.testcontroller
 * @className: FileTest
 * @author: xiehanchun
 * @data: 2020-03-26 16:18
 * @version: v1.0
 */
public class FileTest {
//        File类的常见方法
//        1.创建。
//        boolean createNewFile(); //创建文件
//        boolean mkdir();创建文件夹
//        boolean mkdirs();创建多级文件夹。
//
//        2.删除。
//        boolean delete();
//        void deleteOnExit();在程序退出时删除文件。
//
//        3.判断。
//        boolean canExcute(); 判断是否可执行
//        boolean exists(); 文件事是否存在。
//        isFile();文件
//        isDirectory();文件夹
//        isHidden();//java能得到文件中的隐藏文件但是对隐藏文件时不能访问的
//        isAbsolute();//绝对路径即时不存在也能得到。
//
//        4.获取信息。
//        getName();
//        getPath();
//        getParent();
//
//        4.三种文件创建方式：
//        File file = new File("E:/...");//文件/文件夹路径对象
//        File file = new File("..." ,""...);//父目录绝对路径 + 子目录名称
//        File file = new File("...","...");//父目录File对象 + 子目录名称
//
//        file.exists():判断文件/文件夹是否存在
//        file.delete():删除文件/文件夹
//        file.isDirectory():判读是否为目录
//        file.isFile():判读是否为文件夹
//        file.mkdir():创建文件夹(仅限一级目录)
//        file.mkdirs():创建多及目录文件夹(包括但不限一级目录)
//        file.createNewFile():创建文件
//        file.getAbsolutePath():得到文件/文件夹的绝对路径
//        file.getName():得到文件/文件夹的名字
//        file.String():同样是得到文件/文件夹的绝对路径等于file.getAbsolutePath()
//        file.getParent():得到父目录的绝对路径String 不可以调用可以调用mkdir()方法
//
//        file.getParentFile()：得到父目录的绝对路径的返回值是File型可以调用mkdir()方法
//
//        String[] gdir.list():得到目录的子目录\文件的名称(不是绝对路径)
//        File[] dir.listFiles():得到目录的子目录\文件事是否存在。

    public static void main(String[] args) throws IOException {
       String fileName = "01.jpg";
       File file = new File("D:"+File.separator+"home/"+fileName);
        File parentFile = file.getParentFile();//file类型 可以用exists判断
        String parent = file.getParent();//string类型
        System.out.println("parentFile"+parentFile);
        System.out.println("parent"+parent);
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }
        if(!file.exists()){
            file.createNewFile();
        }

        File absoluteFile = file.getAbsoluteFile();
        String absolutePath = file.getAbsolutePath();
        String path = file.getPath();
        String name = file.getName();
        System.out.println("absoluteFile"+absoluteFile);
        System.out.println("absolutePath"+absolutePath);
        System.out.println("path"+path);
        System.out.println("name"+name);
    }
}
