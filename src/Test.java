import java.util.Scanner;

/**
 * Created by LXF on 2017/8/18.
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str != null)
            System.out.println(judgecf(str));
    }

    public static int judgecf(String str) {
        int j = 0;
        for (int i = 0; i < str.length()-1; i++) {
            if ((str.charAt(i)^str.charAt(i + 1)) != 0) {
                j++;
            }
            j++;
        }
        return j;
    }
}
