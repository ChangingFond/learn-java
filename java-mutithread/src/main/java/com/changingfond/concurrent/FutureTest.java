package com.changingfond.concurrent;

import java.util.Random;
import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<Integer> result = executor.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Random().nextInt();
            }
        });
        executor.shutdown();
        try {
            System.out.println("result:" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
