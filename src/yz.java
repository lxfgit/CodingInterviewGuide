import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by LXF on 2017/9/21.
 */
public class yz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int[] a1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            a1[i] = scanner.nextInt();
        }
        int n2 = scanner.nextInt();
        int[] a2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            a2[i] = scanner.nextInt();
        }
        ArrayList<Integer> dq = new ArrayList<>();
        for (int i = 0, j = 0; i < n1 && j < n2; i++, j++) {
            if (a1[i] < a2[j]) {
                dq.add(a1[i]);
                i++;
            } else if (a1[i] > a2[j]) {
                dq.add(a2[j]);
                j++;
            } else {
                dq.add(a1[i]);
                i++;
                j++;
            }
        }
        if (dq.size() % 2 == 1) {
            System.out.println(dq.get(dq.size()/2+1));
        }else {
            System.out.println((dq.get(dq.size()/2)+dq.get(dq.size()/2+1))/2);
        }

    }
}
