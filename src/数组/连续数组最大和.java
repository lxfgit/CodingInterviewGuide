package 数组;

import java.util.Scanner;

/**
 * Created by LXF on 2017/8/14.
 */
public class 连续数组最大和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int max = 0;

        int tem =0;
        for(int i=0;i<a.length;i++)
        {
            if(tem<0) {
                tem = a[i];
            }
            else {
                tem += a[i];
            }
            if(max<tem)
                max=tem;
        }
        System.out.println(max);
    }

    public static int getSum(int[] arr, int i, int j) {

        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += arr[k];
        }
        return sum;
    }
}
