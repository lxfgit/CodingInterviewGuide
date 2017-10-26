package 字符串;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by LXF on 2017/9/21.
 */
public class 反转字符串除了单词外 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] cs = s.toCharArray();
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            s1.push(cs[i]);
        }
        StringBuffer str = new StringBuffer();
        while (!s1.empty()) {
            if (Character.isLetter(s1.peek())) {
                s2.push(s1.pop());
            }else{
                while (!s2.empty()) {
                    str.append(s2.pop());
                }
                str.append(s1.pop());
            }
        }
        System.out.println(str.toString());

    }
}
