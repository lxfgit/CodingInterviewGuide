package 排序;

import java.util.Scanner;

/**
 * Created by LXF on 2017/9/25.
 */
public class 快速排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Qsort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    private static void Qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = getPos(arr, low, high);
            Qsort(arr, low, pivot-1);
            Qsort(arr, pivot+1, high);
        }
    }

    private static int getPos(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low<high&&arr[high]>=temp) --high;
            arr[low] = arr[high];
            while (low<high&&arr[low]<=temp) ++low;
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }
}
