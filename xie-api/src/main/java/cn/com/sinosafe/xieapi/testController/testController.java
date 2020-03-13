/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xieapi.testController
 * fileName: testController.java
 * date: 2020-03-13 16:34
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.testController;

import java.util.Scanner;

/**
 * @description: 测试
 * @packageName: cn.com.sinosafe.xieapi.testController
 * @className: testController
 * @author: xiehanchun
 * @data: 2020-03-13 16:34
 * @version: v1.0
 **/
public class testController {
    public static void main(String[] args) {
        int[] nums = {2,2,3,4,2,6,2,2,9};
        System.out.println("数组长度----》"+nums.length/2);
       for(int i = 0; i < nums.length; i++){
           int temp = 0;
           for(int j = 0; j < nums.length-i-1;i++){
                if(nums[j] > nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = nums[j];
                }
            }
       }
    }
}
