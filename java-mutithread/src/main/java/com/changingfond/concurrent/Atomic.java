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
    }
}
