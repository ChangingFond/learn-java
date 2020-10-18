package com.changingfond.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolStatus {
  private static ThreadPoolExecutor pool = new ThreadPoolExecutor(50, 100, 0L, TimeUnit.MILLISECONDS,
      new LinkedBlockingQueue<Runnable>(100000));

  public static void main(String[] args) throws Exception {
    for (int i = 0; i < 100000; i++) {
      pool.execute(() -> {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
    }

    while (true) {
      System.out.println();
      int queueSize = pool.getQueue().size();
      System.out.println("当前排队线程数：" + queueSize);

      int activeCount = pool.getActiveCount();
      System.out.println("当前活动线程数：" + activeCount);

      long completedTaskCount = pool.getCompletedTaskCount();
      System.out.println("执行完成线程数：" + completedTaskCount);

      long taskCount = pool.getTaskCount();
      System.out.println("总线程数：" + taskCount);

      Thread.sleep(3000);
    }
  }
}
