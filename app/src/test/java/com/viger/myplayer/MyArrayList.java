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

    public void remove(E e) {

    }

    private void resize(int newSize) {
        E[] newAray = (E[])new Object[newSize];
        for(int i=0;i<ele.length;i++) {
            newAray[i] = ele[i];
        }
        ele = newAray;
    }

}
