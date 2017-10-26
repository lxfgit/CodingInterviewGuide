package Threads;

/**
 * Created by LXF on 2017/9/24.
 */
public class CreateMultiThreads {
    static class PrintNum implements Runnable{
        private static int num = 0;
        @Override
        public void run() {
            if (num < 10) {
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName() +":"+ num++);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new PrintNum()).start();
        }
    }
}
