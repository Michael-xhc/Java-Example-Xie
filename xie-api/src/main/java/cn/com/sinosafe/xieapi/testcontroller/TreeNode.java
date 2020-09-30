package cn.com.sinosafe.xieapi.testcontroller;

/**
 * Created by xiehanchun on 2020/9/30
 */
public class TreeNode {
    /**
     * 左孩子
     */
    public TreeNode left;
    /**
     *  右孩子
     */
    public TreeNode right;
    /**
     * 数据
     */
    public int data;

    public TreeNode(int data){
        this.left = null;
        this.right = null;
        this.data = data;
    }
}
