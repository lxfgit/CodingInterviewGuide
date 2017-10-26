package 排序;

/**
 * Created by LXF on 2017/10/26.
 */
public class ArrayUtils {
    public static void printArray(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            System.out.println(array[i] + ((i < len) ? " " : ""));
        }
    }

    public static void exchangeElements(int[] array, int i, int i1) {
        int tem = array[i];
        array[i] = array[i1];
        array[i1] = tem;
    }
}
