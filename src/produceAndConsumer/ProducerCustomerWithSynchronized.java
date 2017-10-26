package produceAndConsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by LXF on 2017/8/9.
 * 使用synchronized
 */
public class ProducerCustomerWithSynchronized {
    Executor pool = Executors.newFixedThreadPool(10);
    //仓库
    private List<String> storageList = new LinkedList<String>();
    //仓库容量
    private int MAX_SIZE = 3;
    //仓库为空
    private int ZERO = 0;

    //生产者线程
    private class Producer implements Runnable{
        //生产方法，需同步
        private void produce(){
            synchronized (storageList) {
                System.out.println(Thread.currentThread().getName()+"进入仓库，准备生产！");
                try {
                    if(storageList.size()==MAX_SIZE) {
                        System.out.println("仓库已满！等待消费者消费");
                        Thread.sleep(1000);
                        storageList.wait();//当前线程放弃锁，处于等待状态，让其他线程执行
                    }
                    if(storageList.size()<MAX_SIZE) {
                        String name = "产品"+new Random().nextInt();
                        storageList.add(name);
                        System.out.println(Thread.currentThread().getName()+"往仓库中生产了一个产品！");
                    }
                    Thread.sleep(1000);
                    storageList.notifyAll();//当前线程放弃锁，唤醒其他线程
                }catch(InterruptedException ie) {
                    System.out.println("中断异常");
                    ie.printStackTrace();
                }

            }
        }
        @Override
        public void run() {
            while(true) {
                produce();
            }
        }
    }

    //消费者线程
    private class Customer implements Runnable{
        //消费方法，需同步
        private void consume() {
            synchronized (storageList) {
                System.out.println(Thread.currentThread().getName()+"进入仓库，准备消费！");
                try {
                    if(storageList.size()==ZERO) {
                        System.out.println("仓库已空！等待生产者生产");
                        Thread.sleep(1000);
                        storageList.wait();//当前线程放弃锁，处于等待状态，让其他线程执行
                    }
                    if(storageList.size()!=ZERO) {
                        System.out.println(Thread.currentThread().getName()+"从仓库取得产品："+storageList.remove(0));
                    }
                    Thread.sleep(1000);
                    storageList.notifyAll();//当前线程放弃锁，唤醒其他线程
                }catch(InterruptedException ie) {
                    System.out.println("中断异常");
                    ie.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            while(true) {
                consume();
            }
        }

    }

    //启动生产者和消费者线程
    public void start() {
        for(int i=1;i<5;i++) {
            //new Thread(new Producer()).start();
            //new Thread(new Customer()).start();
            pool.execute(new Producer());
            pool.execute(new Customer());
        }
    }

    public static void main(String[] args) {
        ProducerCustomerWithSynchronized pc = new ProducerCustomerWithSynchronized();
        pc.start();
    }
}
