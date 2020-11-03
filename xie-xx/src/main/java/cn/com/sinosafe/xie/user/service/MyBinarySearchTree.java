/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xieapi.testcontroller
 * fileName: MyBinarySearchTree.java
 * date: 2020-04-08 14:26
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xie.user.service;

import cn.com.sinosafe.xie.user.domain.Node;

import java.util.LinkedList;

/**
 * @description: 二叉树搜索树
 * @packageName: cn.com.sinosafe.xieapi.testcontroller
 * @className: MyBinarySearchTree
 * @author: xiehanchun
 * @data: 2020-04-08 14:26
 * @version: v1.0
 */
public class MyBinarySearchTree {
    public Node root; //记录根节点
    public Node current;
    //增加节点
    public void addNode(int data){
        if(root == null){		//为空树
            root =new Node(data);
        }else{
            current = root;
            while(current != null){   //寻找叶子节点
                if(data <= current.data){
                    if(current.left == null){
                        current.left = new Node(data);
                        break;
                    }
                    current = current.left;

                }else{
                    if(current.right == null){
                        current.right = new Node(data);
                        break;
                    }
                    current = current.right;
                }
            }
        }
    }
    //中序遍历树
    public void inOrderPrintTree(Node node){
        if(node != null){
            inOrderPrintTree(node.left);
            System.out.print(node.data+",");
            inOrderPrintTree(node.right);
        }
    }

    //先序遍历
    public void preOrderTraverse1(Node root) {
        if (root != null) {
            System.out.print(root.data+",");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    //后序遍历
    public void postOrderTraverse1(Node root) {
        if (root != null) {
            postOrderTraverse1(root.left);
            postOrderTraverse1(root.right);
            System.out.print(root.data+",");
        }
    }

    //层序遍历
    public void levelTraverse(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data+",");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }


    /**
     * 四种遍历概念
     * 1）先序遍历：先访问根节点，再访问左子树，最后访问右子树。
     * 2) 后序遍历：先左子树，再右子树，最后根节点。
     * 3）中序遍历：先左子树，再根节点，最后右子树。
     * 4）层序遍历：每一层从左到右访问每一个节点。
     *      深度优先遍历:先序遍历、中序遍历和后序遍历
     *      广度优先遍历:层序遍历
     *                       F
     *                   /         \
     *                 C           E
     *               /    \      /    \
     *              A     D     H      G
     *                   /           /
     *                  B           M
     *
     *     先序遍历：FCADBEHGM
     *     后序遍历：ABDCHMGEF
     *     中序遍历：ACBDFHEMG
     *     层序遍历：FCEADHGBM，层序遍历一般很少用。
     */


    public static void main(String[] args) {
        MyBinarySearchTree my =new MyBinarySearchTree();
        //下列插入顺序可以打乱
        my.addNode(9);
        my.addNode(5);
        my.addNode(15);
        my.addNode(3);
        my.addNode(7);
        my.addNode(11);
        my.addNode(17);
        my.addNode(6);
        my.addNode(4);
        my.addNode(1);
        my.addNode(10);
        my.addNode(8);
        my.addNode(12);
        my.addNode(16);
        my.addNode(7);
        System.out.println("中序遍历：");
        my.inOrderPrintTree(my.current);
    }
}
