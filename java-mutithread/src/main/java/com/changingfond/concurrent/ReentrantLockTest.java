package com.changingfond.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther: fangchengjin_sx
 * @date: 2019/8/23 13:02
 * @description:
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println("lock.");
        } finally {
            lock.unlock();
        }

    }

}
