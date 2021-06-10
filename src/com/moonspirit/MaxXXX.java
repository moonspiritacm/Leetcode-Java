package com.moonspirit;

import Date_pacage.Array;

public class MaxHeap<E extends Comparable <E>> {
    private Array<E> data;
    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }
    public MaxHeap() {
        data = new Array<>();
    }
    //heapify:讲任意数组整理成堆的形状 O(n)
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        //从最后一个非叶子节点开始，逐个siftDown
        for(int i = parent(arr.length - 1) ; i >= 0 ; i-- ) {
            siftDown(i);
        }
    }
    public int size() {
        return data.getSize();
    }
    public boolean isEmpty() {
        return data.isEmpty();
    }
    //返回完全二叉树的数组（索引从0 开始）表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if(index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 +1;
    }
    private int rightChild(int index) {
        return index * 2 + 2;
    }
    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    //看堆中最大元素
    public E findMax() {
        if(data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        return data.get(0);
    }
    //取出元素，只能取出最大的那个元素
    public E extractMax(){
        E ret = findMax();

        data.swap(0,  data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    // 取出堆中最大的元素，并且替换成元素e
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }



}