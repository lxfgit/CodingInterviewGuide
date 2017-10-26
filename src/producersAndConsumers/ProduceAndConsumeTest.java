package producersAndConsumers;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * Created by LXF on 2017/7/27.
 */

 /*
     *  第二题：现成程序中的Test类中的代码在不断地产生数据，然后交给TestDo.doSome()方法去处理，
     *       就好像生产者在不断地产生数据，消费者在不断消费数据。
     *       请将程序改造成有10个线程来消费生成者产生的数据，这些消费者都调用TestDo.doSome()方法去进行处理，
     *       故每个消费者都需要一秒才能处理完，程序应保证这些消费者线程依次有序地消费数据，只有上一个消费者消费完后，
     *       下一个消费者才能消费数据，下一个消费者是谁都可以，但要保证这些消费者线程拿到的数据是有顺序的。
     *       原始代码如下：
     */
public class ProduceAndConsumeTest {
    public static void main(String[] args) {

        final Semaphore semaphore = new Semaphore(1);//并发交通灯（Lock也可以）

        //同步队列（阻塞队列都可以实现）
//          final SynchronousQueue<String> queue = new SynchronousQueue<String>();
        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable(){

                @Override
                public void run() {
                    try {
                        semaphore.acquire();//拿到阻塞

                        String input = queue.take();//从队列中拿

                        String output = TestDo.doSome(input);
                        System.out.println(Thread.currentThread().getName()+ ":" + output);

                        semaphore.release();//释放
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();

        }

        System.out.println("begin:"+(System.currentTimeMillis()/1000));
        for(int i=0;i<10;i++){  //这行不能改动
            String input = i+"";  //这行不能改动
            try {
                queue.put(input);//往队列中放入
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//              String output = TestDo.doSome(input);
//              System.out.println(Thread.currentThread().getName()+ ":" + output);
        }
    }
}

