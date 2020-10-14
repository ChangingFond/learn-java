package com.changingfond.invocation.callback;

/**
 * 异步回调：
 * 把函数 b 传递给函数 a。执行 a 的时候，回调了 b，然后 a 就继续往后执行，b 独自执行。
 * 注意：同步可以是单线程也可以是多线程，
 * 异步必须是多线程或多进程（每个进程可以是单线程）==> 换句话说，异步必须依靠多线程或多进程才能完成
 *
 * 程序运行结果
 * TimeCounter start.
 * TimeCounter end.
 * Method start.
 * Method end.
 * Method execute time:1002
 */

class Method implements Callback {

  @Override
  public void execute() {
    System.out.println("Method start.");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Method end.");
  }
}

class AsyncTimeCounter {
  public void doTask(final Callback callback) {

    System.out.println("TimeCounter start.");
    new Thread(new Runnable() {

      @Override
      public void run() {
        long startTime = System.currentTimeMillis();
        callback.execute();
        long endTime = System.currentTimeMillis();
        System.out.println(callback.getClass().getSimpleName() +
            " execute time:" + (endTime - startTime));
      }

    }).start();
    System.out.println("TimeCounter end.");
  }
}

public class AsyncCallback {
  public static void main(String[] args) {
    AsyncTimeCounter counter = new AsyncTimeCounter();
    counter.doTask(new Method());
  }
}
