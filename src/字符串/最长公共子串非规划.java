package 字符串;

import java.util.Scanner;

/**
 * Created by LXF on 2017/8/15.
 */
public class 最长公共子串非规划 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int isEnd = 0;
        if (s1.length() == 0 || s2.length() == 0) {
            isEnd = 1;
            System.out.println(0);
            System.out.println();
        }
        if (isEnd == 0) {

            char[] ss1 = s1.toCharArray();
            char[] ss2 = s2.toCharArray();

            String longestStr = getLongestSubStr(s1, s2);
            System.out.println(longestStr.length() + " " + longestStr);
            int[][] dp = getdp(ss1, ss2);
            int max = 0;
            int end = 0;
            for (int i = 1; i < s1.length(); i++) {
                for (int j = 1; j < s2.length(); j++) {
                    if (max < dp[i][j]) {
                        end = i;
                        max = dp[i][j];
                    }
                }
            }
            System.out.println(max + " " + s1.substring(end - max + 1, end + 1));

        }
    }

    /**
     * 非动态规划实现，空间复杂度O(1)
     *
     * @param s1
     * @param s2
     * @return
     */

    public static String getLongestSubStr(String s1, String s2) {

        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();

        int row = 0;
        int col = ss2.length - 1;
        int max = 0;
        int end = 0;
        while (row < ss1.length) {
            int i = row;
            int j = col;
            int len = 0;

            while (i < ss1.length && j < ss2.length) {
                if (ss1[i] != ss2[j]) {
                    len = 0;
                } else {
                    len++;
                }
                if (len > max) {
                    end = i;
                    max = len;
                }
                i++;
                j++;
            }
            if (col > 0) {
                col--;
            } else {
                row++;
            }
        }
        return s1.substring(end - max + 1, end + 1);
    }


    /**
     * 动态规划实现，返回动态规划数组,空间复杂度O(M*N)。
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int[][] getdp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < str2.length; j++) {
            if (str1[0] == str2[j]) {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }

}
