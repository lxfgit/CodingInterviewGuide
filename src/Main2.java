import java.util.Scanner;

/**
 * Created by LXF on 2017/8/12.
 */
public class Main2 {

    public static int getMaxNum(String str) {
        int max = 0;
        int i = 0;
        while (i+1 < str.length()) {
            int count = 0;
            int j = i;
            while (j+1 < str.length()) {
                if (str.charAt(j) - str.charAt(j + 1) != 0) {
                    j++;
                    count++;
                }
                else
                    break;
            }
            max = Math.max(max, count+1);
            i = j+1;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(getMaxNum(string));
    }
}
