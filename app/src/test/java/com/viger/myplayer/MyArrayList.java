package com.viger.myplayer;

public class MyArrayList<E> {

    private E[] ele;
    private int size;
    private int caption = 10;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int caption) {
        E[] eles = (E[]) new Object[caption];
        size = 0;
    }

    public void add(E e) {
        if(ele.length == size) {
            resize(size * 2);
        }
        ele[size] = e;
        size++;
    }

    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed. index is iell");
        }
        E ret = ele[index];
        for(int i = index+1;i<size;i++) {
            ele[i-1] = ele[i];
        }
        size--;
        if(size ==ele.length/4 && ele.length/2 != 0) {
            resize(ele.length/2);
        }
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }

    private void resize(int newSize) {
        E[] newAray = (E[])new Object[newSize];
        for(int i=0;i<ele.length;i++) {
            newAray[i] = ele[i];
        }
        ele = newAray;
    }

    public void test() {

    }

}
