import java.util.Scanner;
import java.lang.*;

/**
 * Created by Lemon on 2017-08-18.
 */
public class solution3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(getLongestStr(str));
    }

    public static int getLongestStr(String str1) {
        int[] hashTable = new int[256];
        for (int p = 0; p < 256; p++) {
            hashTable[p] = 0;
        }
        char[] str = str1.toCharArray();
        int start = 0;
        int mstart = 0;
        int mlen = 0;
        int idx = 0;
        int len = 0;
        while (idx != str.length) {
            if (hashTable[str[idx]] == 1) {
                if (len > mlen) {
                    mstart = start;
                    System.out.println(str[idx]);
                    mlen = len;
                }
                while (str[start] != str[idx]) {
                    hashTable[str[start]] = 0;
                    start++;
                    len--;
                }
                start++;
            } else {
                hashTable[str[idx]] = 1;
                len++;
            }
            idx++;
        }

        if (len > mlen) {
            mlen = len;
            mstart = start;
        }

        return mlen;
    }
}