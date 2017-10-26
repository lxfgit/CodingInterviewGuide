package huawei;

/**
 * Created by LXF on 2017/8/15.
 */
public class Swap0Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 5, 4, 0, 3, 2};
        int n = arr.length;

        if (arr[0] != 0) {
            for (int j = 1; j < n; j++) {
                if (arr[0] > arr[j] && arr[j] == 0) {
                    swap(arr, 0, j);
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, 0, i);
                    swap(arr, i, j);
                    swap(arr, 0, j);
                }

            }
        }
        for (int i : arr) {
            System.out.print(i);
        }
    }

    public static void swap (int[] a,int i, int j){
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
