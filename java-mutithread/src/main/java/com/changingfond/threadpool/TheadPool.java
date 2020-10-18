package com.changingfond.threadpool;

import java.util.concurrent.*;

/**
 * @auther: fangchengjin_sx
 * @date: 2019/8/16 21:28
 * @description: 四种常见的线程池
 */
public class TheadPool {

    private static int produceTaskSleepTime = 400;
    private static int produceTaskMaxNumber = 10;

    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2, 4, 3,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3), new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < produceTaskMaxNumber; i++) {
            try {
                String taskName = "task@" + (i + 1);
                threadPool.submit(new Task(taskName));
                Thread.sleep(produceTaskSleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
         fixedThreadPool.submit(new Runnable() {
             public void run() {
                 System.out.println(Thread.currentThread().getName());
             }
         });
        }
    }
}

class Task implements Runnable {

    private static int consumeTaskSleepTime = 3000;

    private String name;

    public Task(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name);
        System.out.println(Thread.currentThread().getName());

        try {
            Thread.sleep(consumeTaskSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}