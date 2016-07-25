package stackAndqueue.maxWindow;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by LXF on 2016/7/25.
 */
public class MaxWindow {
    public MaxWindow() {
    }

    public int[] getMaxWindow(int[] arr, int w) {
        if (arr != null && w >= 1 && arr.length >= w) {
            LinkedList qmax = new LinkedList();
            int[] res = new int[arr.length - w + 1];
            int index = 0;

            for (int i = 0; i < arr.length; ++i) {
                while (!qmax.isEmpty() && arr[((Integer) qmax.peekLast()).intValue()] <= arr[i]) {
                    qmax.pollLast();
                }

                qmax.addLast(Integer.valueOf(i));
                if (((Integer) qmax.peekFirst()).intValue() == i - w) {
                    qmax.pollFirst();
                }

                if (i >= w - 1) {
                    res[index++] = arr[((Integer) qmax.peekFirst()).intValue()];
                }
            }

            return res;
        } else {
            return null;
        }
    }

    @Test
    public void test() {
        int[] array = new int[]{54, 96, 4, 3, 8, 1, 68, 13, 8, 1, 684};
        MaxWindow maxWindow = new MaxWindow();
        int[] result = maxWindow.getMaxWindow(array, 3);

        for (int e : result) {
            System.out.println(e);
        }
    }
}
