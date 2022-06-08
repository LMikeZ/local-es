package com.example.lizan.datastruct.linkedlist;

/**
 * @author lizan
 * @version $Id: DoubleLinkedListDemo.java, v 0.1 2022年06月01日 16:02 lizan Exp $$
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {

    }


}

class HeroNode2 {
    public int no;
    public String name;
    //        public String nickname;
    public HeroNode2 next; // next 默认为null
    public HeroNode2 pre; // pre 默认为null

    public HeroNode2(int hNo, String hName) {
        no = hNo;
        name = hName;
//            nickname = hNickname;
    }

}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "");


    public void add(HeroNode2 node2) {
        HeroNode2 node = head;
        while (true) {
            if (node.next == null) {
                break;
            }

            node = node.next;
        }
        node.next = node2;
        node2.pre = node;
    }

    public void list() {
        HeroNode2 node = head;
        if (node.next == null){
            return;
        }
        while (true){
            if (node.next == null){
                break;
            }
            System.out.println(node.next);
            node = node.next;
        }

    }

}