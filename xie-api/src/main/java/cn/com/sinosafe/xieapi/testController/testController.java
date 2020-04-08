/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xieapi.testController
 * fileName: testController.java
 * date: 2020-03-13 16:34
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.testController;


import cn.com.sinosafe.xie.user.domain.Node;
import cn.com.sinosafe.xie.user.service.MyBinarySearchTree;

import java.util.Arrays;

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
//    public static void main(String[] args) {
//         /**
//           * 思路：一流程序员靠数学 二流程序员靠算法 三流程序员靠逻辑 四流程序员靠sdk 五流程序员靠google 六流程序员靠百度 要善于表现自己
//           * 在暴力方法中，我们考虑 nums 数组中每一个可能的子序列。对于每一个子序列 nums[i:j]，我们检查它是否是最小的无序子序列。因此对于每一个子序列，我们求出这个子序列中的最大和最小值，并分别用 maxmax 和 minmin 表示。
//           * 如果子序列 nums[0:i-1]和 nums[j:n-1]是升序的，那么仅有 nums[i:j]是可能的子序列。更进一步， nums[0:i-1]中所有的元素都要比 minmin 小且 nums[j:n-1]中所有的元素都要比 maxmax 大。我们对于枚举的每一对 i 和 j 都做这样的检查。
//           * 接下来，我们需要检查 nums[0:i-1]和 nums[j:n-1]是否是升序的。如果上述所有条件都满足，我们通过枚举所有的 i 和 j 并计算 j-i来找到最短的无序子数组。
//           */
//        int[] nums = {2, 6, 4, 8, 10, 9, 15};
//        int res = nums.length;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j <= nums.length; j++) {
//                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, prev = Integer.MIN_VALUE;
//                for (int k = i; k < j; k++) {
//                    //min 放最大值
//                    min = Math.min(min, nums[k]);
//                    //max 放最小值
//                    max = Math.max(max, nums[k]);
//                }
//                if ((i > 0 && nums[i - 1] > min) || (j < nums.length && nums[j] < max))
//                    continue;
//                int k = 0;
//                while (k < i && prev <= nums[k]) {
//                    prev = nums[k];
//                    k++;
//                }
//                if (k != i)
//                    continue;
//                k = j;
//                while (k < nums.length && prev <= nums[k]) {
//                    prev = nums[k];
//                    k++;
//                }
//                if (k == nums.length) {
//                    res = Math.min(res, j - i);
//
//                }
//            }
//        }
//        System.out.println(res);
        //2, 6, 4, 8, 10, 9, 15
        //2, 4, 6, 8,  9, 10,15
//        int[] nums = {2, 6, 4, 8, 10, 9, 15};
//        int l = nums.length,r = 0;
//        for (int i=0; i<=nums.length;i++){
//            for (int j=i+1; j<nums.length; j++){
//                if(nums[i] > nums[j]){
//                    r = Math.max(r,j);
//                    l = Math.min(i,l);
//                }
//            }
//        }
//        System.out.println("r--->"+r+",l--->"+l);
//        System.out.println(r-l<0?0:r-l+1);

//        int[] nums = {2, 6, 4, 8, 10, 9, 15};
//        int[] fnums = nums.clone();
//        Arrays.sort(fnums);
//        for (int fnum : fnums) {
//            System.out.println(fnum);
//        }
//        int start = fnums.length, end = 0;
//        for(int i = 0; i < fnums.length-1; i++){
//            if(fnums[i] != nums[i]){
//                start = Math.min(start,i);
//                end = Math.max(i,end);
//            }
//        }
//        System.out.println("start--->"+start+",end--->"+end);
//        System.out.println(end-start<=0?0:end-start+1);
//    }
     /**
      * @Description //给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
      *                  使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
      *               输入: 原始二叉搜索树:
      *               5
      *             /   \
      *            2     13
      *
      *             输出: 转换为累加树:
      *              18
      *             /   \
      *           20     13
      * @Author xiehanchun
      * @Date 2020/4/8 14:04
      * @Param
      * @return
      */
     public static void main(String[] args) {
     }
}
