package stackAndqueue.maJpminXNum;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by LXF on 2016/7/25.
 */
public class XYNum {
    public XYNum() {
    }

    public int getNum(int[] arr, int num) {
        if(arr != null && arr.length != 0) {
            LinkedList qmin = new LinkedList();
            LinkedList qmax = new LinkedList();
            int i = 0;
            int j = 0;

            int res;
            for(res = 0; i < arr.length; ++i) {
                while(j < arr.length) {
                    while(!qmin.isEmpty() && arr[((Integer)qmin.peekLast()).intValue()] >= arr[j]) {
                        qmin.pollLast();
                    }

                    qmin.addLast(j);

                    while(!qmax.isEmpty() && arr[((Integer)qmax.peekLast()).intValue()] <= arr[j]) {
                        qmax.pollLast();
                    }

                    qmax.addLast(j);
                    if(arr[((Integer)qmax.getFirst()).intValue()] - arr[((Integer)qmin.getFirst()).intValue()] > num) {
                        break;
                    }

                    ++j;
                }

                if(((Integer)qmin.peekFirst()).intValue() == i) {
                    qmin.pollFirst();
                }

                if(((Integer)qmax.peekFirst()).intValue() == i) {
                    qmax.pollFirst();
                }

                res += j - i;
            }

            return res;
        } else {
            return 0;
        }
    }

    @Test
    public void test() {
        int[] test = new int[]{56, 8};
        XYNum xynum = new XYNum();
        int res = xynum.getNum(test, 150);
        System.out.println(res);
    }

    @Test
    public void test1() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(6);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.peekFirst());
    }
}
