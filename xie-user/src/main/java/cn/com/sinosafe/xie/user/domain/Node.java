/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xie.user.domain
 * fileName: Node.java
 * date: 2020-04-08 14:37
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xie.user.domain;

/**
 * @description: 节点
 * @packageName: cn.com.sinosafe.xie.user.domain
 * @className: Node
 * @author: xiehanchun
 * @data: 2020-04-08 14:37
 * @version: v1.0
 */
public class Node {
    /**
     * 左孩子
     */
    public Node left;
    /**
     *  右孩子
     */
    public Node right;
    /**
     * 数据
     */
    public int data;

    public Node(int data){
        this.left = null;
        this.right = null;
        this.data = data;
    }
}
