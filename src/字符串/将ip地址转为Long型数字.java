package 字符串;

import java.util.Scanner;

/**
 * Created by LXF on 2017/9/25.
 */
public class 将ip地址转为Long型数字 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();
        String[] ipArr = ip.split("\\.");
        System.out.println(ipArr.length);
        Long ipLong = Long.parseLong(ipArr[3]) * 256 * 256 * 256 +
                Long.parseLong(ipArr[2]) * 256 * 256 +
                Long.parseLong(ipArr[1]) * 256 +
                Long.parseLong(ipArr[1]);

        System.out.println(ipLong);
    }
}
