package com.changingfond.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther: fangchengjin_sx
 * @date: 2019/8/15 19:54
 * @description:
 */
public class Atomic {

    static AtomicInteger i = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(i.get());
        // return previous value
        System.out.println(i.getAndIncrement());
        System.out.println(i.getAndDecrement());
        System.out.println(i.getAndAdd(1));
    }
}
