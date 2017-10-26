import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by LXF on 2017/8/15.
 */
public class Main11 implements Serializable {
    public static int get(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int k = n / 3;
        return k + get(n % 3+k);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] n = new int[10];
        for (int i = 0; i < 10; i++) {
            int c;
            if ((c=scanner.nextInt()) != 0) {
                n[i] = c;
            } else {
                break;
            }
        }

        for (int i = 0; i < n.length; i++) {
            if (n[i] != 0) {
                if (n[i] < 2) {
                    System.out.println(0);
                } else {
                    System.out.println(get(n[i]));
                }
            }
        }
    }
}
