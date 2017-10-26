/**
 * Created by LXF on 2017/8/15.
 */
public class Main10 {
    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 3, 4, 5};
        int n = array.length;
        int[] isdel = new int[n];
        int k = 0;
        for (int i = 0; ; i = (i+1) % n) {
            if (isdel[i] == 0) {
                k++;
            }
            if (k == 3) {
                isdel[i]=1;
                k=0;
                if (getSum(isdel) == n-1) {
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (isdel[i] == 0) {
                System.out.println(i);
            }
        }
    }

    public static int getSum(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }
}
