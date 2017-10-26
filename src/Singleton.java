/**
 * Created by LXF on 2017/8/18.
 */
public class Singleton {
    private Singleton(){}

    private static Singleton singleton = null;

    public static final Singleton getInstance() {
        if (singleton == null) {
            synchronized (singleton) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
