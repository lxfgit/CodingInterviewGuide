import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by LXF on 2017/8/12.
 */
public class Main3 {

    public static String dengcha(int n, int[] x) {
        Arrays.sort(x);
        int d = x[1] - x[0];
        for (int i = 1; i+1 < n; i++) {
            if (x[i + 1] - x[i] != d) {
                return "Impossible";
            }
        }
        return "Possible";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }
        System.out.println(dengcha(n, x));
    }
}
