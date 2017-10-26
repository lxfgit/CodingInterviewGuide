package deadlocke;

/**
 * Created by LXF on 2017/8/9.
 */

/**
 * 两个对象分别持有对方的锁，导致两个线程都需要等待对方执行完之后执行，
 * 这就造成无限阻塞的状态，也称为死锁。
 */
public class Deadlocker implements Runnable{
    public int flag = 1;
    static Object o1 = new Object(), o2 = new Object();

    public void run() {
        System.out.println("flag=" + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1");
                }
            }
        }

        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Deadlocker td1 = new Deadlocker();
        Deadlocker td2 = new Deadlocker();
        td1.flag = 1;
        td2.flag = 0;
        Thread t1 = new Thread(td1);
        Thread t2 = new Thread(td1);
        t1.start();
        t2.start();

    }
}
