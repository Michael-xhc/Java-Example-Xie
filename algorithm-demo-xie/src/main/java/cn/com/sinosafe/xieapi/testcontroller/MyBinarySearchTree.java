package cn.com.sinosafe.xieapi.testcontroller;

/**
 * Created by xiehanchun on 2020/9/30
 */
public class MyBinarySearchTree {
    public TreeNode root; //记录根节点
    public TreeNode current;
    //增加节点
    public void addNode(int data){
        if(root == null){		//为空树
            root =new TreeNode(data);
        }else{
            current = root;
            while(current != null){   //寻找叶子节点
                if(data <= current.data){
                    if(current.left == null){
                        current.left = new TreeNode(data);
                        break;
                    }
                    current = current.left;

                }else{
                    if(current.right == null){
                        current.right = new TreeNode(data);
                        break;
                    }
                    current = current.right;
                }
            }
        }
    }
}
