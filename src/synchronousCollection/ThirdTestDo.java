package synchronousCollection;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by LXF on 2017/7/27.
 */
public class ThirdTestDo {
    private ThirdTestDo() {}
    private static ThirdTestDo _instance = new ThirdTestDo();
    public static ThirdTestDo getInstance() {
        return _instance;
    }

    //      private ArrayList<Object> keys = new ArrayList<Object>();
    private CopyOnWriteArrayList<Object> keys = new CopyOnWriteArrayList<Object>();//使用线程安全

    public void doSome(Object key, String value) {
        Object o = key;
        if(!keys.contains(o)) {//contains 就是equals 集合中没有该对象
            keys.add(o);//往集合装东西，当有线程在遍历时，这时就会报错，所以换容器

        }else{
            //
            for(Iterator<Object> its = keys.iterator(); its.hasNext(); ) {//遍历集合
                try {
                    Thread.sleep(20);//慢点迭代，这样就可以并发集合操作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Object obj = its.next();
                if(obj.equals(o)){
                    o = obj;//这时的 obj 与  key 即是我们需要的一组对象
                }
            }
        }

        synchronized (o)//锁定该对象

        // 以大括号内的是需要局部同步的代码，不能改动!
        {
            try {
                Thread.sleep(1000);
                System.out.println(key+":"+value + ":"
                        + (System.currentTimeMillis() / 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
