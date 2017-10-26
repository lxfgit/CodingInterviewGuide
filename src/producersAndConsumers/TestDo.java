package producersAndConsumers;

/**
 * Created by LXF on 2017/7/27.
 */
//不能改动此TestDo类
class TestDo {
    public static String doSome(String input){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String output = input + ":"+ (System.currentTimeMillis() / 1000);
        return output;
    }
}