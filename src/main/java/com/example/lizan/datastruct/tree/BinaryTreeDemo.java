package com.example.lizan.datastruct.tree;

import lombok.Data;

/**
 * @author lizan
 * @version $Id: BinaryTreeDemo.java, v 0.1 2022年06月09日 14:22 lizan Exp $$
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        HeroNode node = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "宋江2");
        HeroNode node3 = new HeroNode(3, "宋江3");
        HeroNode node4 = new HeroNode(4, "宋江4");
        HeroNode node5 = new HeroNode(5, "宋江5");

        node.setLeft(node2);
        node.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
        binaryTree.setRoot(node);

        binaryTree.preOrder();
    }
}

@Data
class BinaryTree {
    private HeroNode root;
    int count;
    public void preOrder() {

        if (this.root != null) {
            this.root.preOrder(count);

        }
    }

    public void infixOrder() {

        if (this.root != null) {
            this.root.infixOrder();
        }
    }

    public void afterOrder() {
        if (this.root != null) {
            this.root.afterOrder();
        }
    }
}


@Data
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    int lcount = 0;
    int rcount = 0;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


    //前序
    public void preOrder(int count) {
        System.out.println(this);
        count++;
        if (this.left != null) {
            this.left.preOrder(count);
        }
        if (this.right != null) {
            this.right.preOrder(count);
        }
        System.out.println(count);
    }

    //中序
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序
    public void afterOrder() {

        if (this.left != null) {
            this.left.afterOrder();
        }
        if (this.right != null) {
            this.right.afterOrder();
        }
        System.out.println(this);
    }
}