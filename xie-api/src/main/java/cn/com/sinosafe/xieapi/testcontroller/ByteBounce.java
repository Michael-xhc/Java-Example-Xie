package cn.com.sinosafe.xieapi.testcontroller;

import java.util.Stack;

/**
 * Created by xiehanchun on 2020/9/28
 */
public class ByteBounce {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public class Solution {
        /**
         * @param root TreeNode类
         * @param o1 int整型
         * @param o2 int整型
         * @return int整型
         */
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        public boolean find(TreeNode ro, int o, Stack s) {
            if (ro == null)
                return false;
            s.push(ro.val);
            if (ro.val == o) {
                return true;
            }
            if (find(ro.left, o, s)) {
                return true;
            }
            if (find(ro.right, o, s)) {
                return true;
            }
            s.pop();
            return false;
        }

        public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
            int v1 = 0, v2 = 0;
            if (!find(root, o1, s1)) {
                return 0;
            }
            //因为递归单次查找速度较快，这里就做两次查找了，保持代码简洁
            if (!find(root, o2, s2)) {
                return 0;
            }
            //size()即树的层次，从1开始计算，最近祖节点层<=min(o1层，o2层)
            while (s1.size() > s2.size()) {
                s1.pop();
            }
            while (s2.size() > s1.size()) {
                s2.pop();
            }
            while (!s1.empty() && !s2.empty()) {
                v1 = s1.pop();
                v2 = s2.pop();
                if (v1 == v2) {
                    return v1;
                }
            }
            return 0;
        }
    }
}
