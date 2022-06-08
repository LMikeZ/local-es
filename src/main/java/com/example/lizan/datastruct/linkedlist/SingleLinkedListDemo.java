package com.example.lizan.datastruct.linkedlist;

import com.alibaba.fastjson.JSON;

/**
 * @author lizan
 * @version $Id: SingleLinkedListDemo.java, v 0.1 2022年05月31日 16:40 lizan Exp $$
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(new HeroNode(1, "李四"));
        singleLinkedList.add(new HeroNode(2, "李四2"));
        singleLinkedList.add(new HeroNode(3, "李四3"));
        singleLinkedList.add(new HeroNode(4, "李四4"));
        singleLinkedList.add(new HeroNode(5, "李四5"));

        System.out.println(getLength(singleLinkedList.head));
        System.out.println(JSON.toJSONString(findLastNode(singleLinkedList.head,3)));
    }


    static class HeroNode {
        public int no;
        public String name;
        //        public String nickname;
        public HeroNode next; // next 默认为null

        public HeroNode(int hNo, String hName) {
            no = hNo;
            name = hName;
//            nickname = hNickname;
        }

    }

    static class SingleLinkedList {
        private HeroNode head = new HeroNode(0, "");

        public void add(HeroNode node) {
            HeroNode temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    //求单链表中有效节点的个数
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode node = head.next;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    //查找单链表中的倒数第k个结点 【新浪面试题】

    public static HeroNode findLastNode(HeroNode head, int index) {
       if (head.next == null){
           return null;
       }
        int length = getLength(head);
        HeroNode temp = head.next;
        for (int i = 0; i < length - index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    public static void reverseLinkedNode(HeroNode head) {
        if (head.next == null){
            return;
        }


    }
}