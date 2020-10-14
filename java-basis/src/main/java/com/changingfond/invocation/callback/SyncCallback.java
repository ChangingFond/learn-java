package com.changingfond.invocation.callback;

/**
 * 同步回调：
 * 把函数 b 传递给函数 a, 执行 a 的时候，回调了 b，a 要一直等到 b 执行完才能继续执行
 * a -> TimeCounter.doTask(Callback callback)
 * b -> callback.execute()
 *
 * 程序运行结果
 * TimeCounter start.
 * MethodA start.
 * MethodA end.
 * MethodA execute time:1003
 * TimeCounter end.
 */

interface Callback {
  public void execute();
}

// 主动调用方实现接口
class MethodA implements Callback {

  @Override
  public void execute() {
    System.out.println("MethodA start.");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("MethodA end.");
  }

}

class MethodB implements Callback {

  @Override
  public void execute() {
    System.out.println("MethodB start.");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("MethodB end.");
  }

}

class TimeCounter {
  // 被调用方回调函数
  public void doTask(Callback callback) {
    System.out.println("TimeCounter start.");
    long startTime = System.currentTimeMillis();
    callback.execute();
    long endTime = System.currentTimeMillis();
    System.out.println(callback.getClass().getSimpleName() +
        " execute time:" + (endTime - startTime));
    System.out.println("TimeCounter end.");
  }

}

public class SyncCallback {
  public static void main(String[] args) {
    TimeCounter counter = new TimeCounter();
    counter.doTask(new MethodA());
    counter.doTask(new MethodB());
  }
}
