package designpattern;

/**
 * @auther: fangchengjin_sx
 * @date: 2019/8/16 17:22
 * @description: double-check 单例模式
 */
public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        while (true) {
            new Thread(new Runnable() {
                public void run() {
                    Singleton singleton = Singleton.getInstance();
                    System.out.println(singleton);
                }
            }).start();
        }
    }
}
