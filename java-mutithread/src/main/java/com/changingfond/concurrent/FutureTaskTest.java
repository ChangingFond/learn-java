package com.changingfond.concurrent;

import java.util.Random;
import java.util.concurrent.*;

public class FutureTaskTest {
    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Random().nextInt();
            }
        });
        new Thread(task).start();
        // 或使用 ExecutorService 提交任务
        // ExecutorService executor = Executors.newSingleThreadExecutor();
        // executor.submit(task);
        try {
            System.out.println("result: " + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
