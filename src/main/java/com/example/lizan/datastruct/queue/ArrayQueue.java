package com.example.lizan.datastruct.queue;

/**
 * 使用数组模拟队列
 *
 * @author lizan
 * @version $Id: ArrayQueue.java, v 0.1 2022年05月30日 15:44 lizan Exp $$
 */
public class ArrayQueue {

    public static void main(String[] args) {

    }
}

class ArrayQueueDemo {
    //最大数量
    private int maxSize;

    //头
    private int front;

    //尾部
    private int rear;

    //用于存放数据
    private int[] arr;

    public ArrayQueueDemo(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("数组为空");
        }

        front++;
        return arr[front];
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列空了");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
}