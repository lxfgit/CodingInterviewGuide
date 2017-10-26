import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by LXF on 2017/8/15.
 */
public class Main8 {
    public static int FirstNotRepeatingChar(String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            String s2 = str.substring(i + 1,n);
            String s1 = "";
            if (i != 0) {
                s1 = str.substring(0, i);
            }
            if (!s2.contains(str.charAt(i) + "")&&!s1.contains(str.charAt(i) + "")) {
                return i;
            }
        }
        return 0;
    }

    public static int FirstNotRepeatingChar1(String str) {
        if(str == null || str.length()==0) return -1;
        List<Character> list = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!list.contains(ch)){
                list.add(Character.valueOf(ch));
            }else{
                list.remove(Character.valueOf(ch));
            }
        }
        if(list.size() <=0) return -1;
        return str.indexOf(list.get(0));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Long start = System.currentTimeMillis();
        System.out.println(FirstNotRepeatingChar(s));
        Long end = System.currentTimeMillis();
        System.out.println(end-start);

        Long start1 = System.currentTimeMillis();
        System.out.println(FirstNotRepeatingChar1(s));
        Long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);

    }
}
