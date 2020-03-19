/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xieapi.testController
 * fileName: testController.java
 * date: 2020-03-13 16:34
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.testController;


/**
 * @description: 测试
 * @packageName: cn.com.sinosafe.xieapi.testController
 * @className: testController
 * @author: xiehanchun
 * @data: 2020-03-13 16:34
 * @version: v1.0
 **/
public class testController {

    /*
     //冒泡排序
    public static void main(String[] args) {
        int[] nums = {3,4,7,1,9,6,2,5,11};
        //3 4 1 7 6 2 5 9 11
        //3 1 4 6 2 5 7 9 11
        //1 3 4 2 5 6 7 9 11
        //1 3 2 4 5 6 7 9 11
        //1 2 3 4 5 6 7 9 11

        System.out.println("数组长度----》"+nums.length);
       for(int i = 0; i < nums.length - 1; i++){
           int temp = 0;
           for(int j = 0;j < nums.length-i-1;j++) {
               if (nums[j] > nums[j + 1]) {
                   temp = nums[j];
                   nums[j] = nums[j + 1];
                   nums[j + 1] = temp;
               }
           }
       }

        for (int num : nums) {
            System.out.println(num);
        }
    }*/

    /*
    //选择排序
    public static void main(String[] args) {
        int[] nums = {3,4,7,1,9,6,2,5,11};
        //1 4 7 3 9 6 2 5 11
        //1 2 7 4 9 6 3 5 11

        System.out.println("数组长度----》"+nums.length);
        for(int i = 0; i < nums.length - 1; i++){
            int temp = 0;
            for (int j = i;j < nums.length - 1 -i; j++){
                if(nums[i] > nums[j]){
                    nums[i] = temp;
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }*/

    //插入排序
   /* public static void main(String[] args) {
        int[] nums = {3, 4, 7, 1, 9, 6, 2, 5, 11};
        //1 3 4 5 6 7 9 11
        //1 3 4  7 9
        //已知循环用for 未知循环次数用while
       *//* int t = 0;
        int n = 0;
        for(int i = 0;i < nums.length;i++){
            t = i-1;
            n = nums[i];
            // 这里主要关注t在变化
            while (t >= 0 && nums[t] > n) {
                nums[t+1] = nums[t];
                t--;
            }
            nums[t+1] = n;
        }

        for (int num : nums) {
            System.out.println(num);
        }*//*
        //3, 4, 7, 1, 9, 6, 2, 5, 11
       int n = 0;
       int t = 0;
        for(int i = 1; i < nums.length; i++){

          if(nums[i] < nums[i - 1]) {
              n = nums[i];
              int j = i - 1;
              for (; j >= 0 && nums[j] > n; j--) {
                    nums[j+1] = nums[j];
              }
              nums[j + 1] = n;
          }
       }

//        for(int i = 0; i<nums.length; i++){
//            int n = nums[i];
//            int t = i-1;
//            while (t >= 0 && nums[t]>n){
//                nums[t+1] = nums[t];
//                t--;
//            }
//            nums[t+1] = n;
//        }
        //做排序 主要计算流程要很清楚 全部变量 局部变量灵活运用 多变化方法不要一个方法走到底  不然继续下去可能就是死循环
           for (int num : nums) {
               System.out.println(num);
           }
    }*/
    
     /**
      * @Description //最短无序连续子数组
      * @Author xiehanchun
      * @Date 2020/3/19 17:29
      * @Param
      * @return
      * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
      * 你找到的子数组应是最短的，请输出它的长度。
      * 示例 1:
      * 输入: [2, 6, 4, 8, 10, 9, 15]
      * 输出: 5
      * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
      * 说明 :
      * 输入的数组长度范围在 [1, 10,000]。
      * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
      */
    public static void main(String[] args) {
        int[] num = {2, 6, 4, 8, 10, 9, 15};

    }
}
