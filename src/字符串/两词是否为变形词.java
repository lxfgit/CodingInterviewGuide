package 字符串;


import java.util.Scanner;

/**
 * Created by LXF on 2017/8/18.
 */
public class 两词是否为变形词 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(solution(s1, s2));
    }

    public static boolean solution(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[] map = new int[256];
        for (char c : c1) {
            map[c]++;
        }
        for (char c : c2) {
            if (map[c]-- == 0) {
                return false;
            }
        }
        return true;
    }
}
