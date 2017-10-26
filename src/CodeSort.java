import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by LXF on 2017/8/15.
 */
public class CodeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> arrayLists = new ArrayList<>();
        while (n-->0) {
            arrayLists.add(scanner.next());
        }
        Collections.sort(arrayLists);
        for (String arrayList : arrayLists) {
            System.out.println(arrayList);
        }
    }
}
