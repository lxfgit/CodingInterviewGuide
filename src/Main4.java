import java.util.Scanner;

/**
 * Created by LXF on 2017/8/12.
 */
public class Main4 {

    public static int[] nx(int n, int[] x) {
        int[] result = new int[n];
        if (n % 2 == 1) {
            result[n / 2] = x[0];
        }
        for (int i = n-1,j = 0; i > 0; i=i-2,j++) {
            result[j] = x[i];
            result[n - j-1] = x[i - 1];
        }
        return result;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }
        int[] result = nx(n, x);
        for (int i = 0; i < n; i++) {
            System.out.print(result[i]+ (i==n-1?"\n":" "));
        }
    }
}
