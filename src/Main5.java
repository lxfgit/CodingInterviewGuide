import java.util.*;

/**
 * Created by LXF on 2017/8/14.
 */
public class Main5 {
    private static int MoreThanHalfNum_Solution(int [] array) {
        Map map = new HashMap<Integer, Integer>();
        int max = 0;
        int v = 0;
        int flag = 0;
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                int newVal = (Integer) map.get(array[i]) + 1;
                max = max > newVal ? max : newVal;
                v = array[i];
                map.put(array[i], newVal);
                flag =1;
            }
        }
        if (flag == 0) {
            max = 1;
            v = array[0];
        }
        return max>array.length/2 ? v :0;
    }

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        int[] a = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(a));
    }
}
