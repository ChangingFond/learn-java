package concurrent;


public class DaemonThread {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread = new Thread(runnable);
        // thread.setDaemon(true);

        thread.start();
        System.out.println("Main Thread is finished");

    }
}
