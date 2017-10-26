import java.util.Scanner;

/**
 * Created by LXF on 2017/8/14.
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] string = scanner.nextLine().toCharArray();
        String s = scanner.next();
        int count = 0;
        for (int i = 0; i < string.length; i++) {
            if (s.equalsIgnoreCase(string[i]+"")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
