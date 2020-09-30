package cn.com.sinosafe.xieapi.testcontroller;

/**
 * Created by xiehanchun on 2020/9/30
 */
public class ByteBounce {
    /**
     * 第一行输入两个整数 n 和 root，n 表示二叉树的总节点个数，root 表示二叉树的根节点。
     * 以下 n 行每行三个整数 fa，lch，rch，表示 fa 的左儿子为 lch，右儿子为 rch。(如果 lch 为 0 则表示 fa 没有左儿子，rch同理)
     * 第 n+2 行输入一个整数 m，表示询问的次数。
     * 以下 m 行每行两个节点 o1 和 o2。
     * 对于每组询问每行输出一个整数表示答案。
     * 输入
     * 8 1
     * 1 2 3
     * 2 4 5
     * 4 0 0
     * 5 0 0
     * 3 6 7
     * 6 0 0
     * 7 8 0
     * 8 0 0
     * 4
     * 4 5
     * 5 2
     * 6 8
     * 5 8
     *
     * 输出
     * 2
     * 2
     * 3
     * 1
     */
    /**
     *             1
     *          2     3
     *        4  5  6   7
     *                8
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null; // 如果树为空，直接返回null
        if(root == p || root == q) return root; // 如果 p和q中有等于 root的，那么它们的最近公共祖先即为root（一个节点也可以是它自己的祖先）
        TreeNode left = lowestCommonAncestor(root.left, p, q); // 递归遍历左子树，只要在左子树中找到了p或q，则先找到谁就返回谁
        TreeNode right = lowestCommonAncestor(root.right, p, q); // 递归遍历右子树，只要在右子树中找到了p或q，则先找到谁就返回谁
        if(left == null) return right; // 如果在左子树中 p和 q都找不到，则 p和 q一定都在右子树中，右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else if(right == null) return left; // 否则，如果 left不为空，在左子树中有找到节点 （p或q），这时候要再判断一下右子树中的情况，如果在右子树中，p和q都找不到，则 p和q一定都在左子树中，左子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else return root; //否则，当 left和 right均不为空时，说明 p、q节点分别在 root异侧, 最近公共祖先即为 root
    }
}
