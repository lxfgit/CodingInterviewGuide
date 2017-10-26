import java.io.*;
import java.util.ArrayList;

/**
 * Created by LXF on 2017/10/26.
 */
public class 杭州银行最后变成题 {
    public static void main(String[] args) throws IOException {
        for (int i = 0;i<args.length;i++) {
            System.out.println(args[i]);
        }
        String fileName = "E:/IDEAworkpalce/CodingInterviewGuide/src/num.txt";
        ArrayList arrayList = readIntegerFromTxt(fileName);
        Integer[] array = (Integer[]) arrayList.toArray(new Integer[arrayList.size()]);
        QSort(array,0,array.length-1);
    }

    public static ArrayList<Integer> readIntegerFromTxt(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String readLTxt = null;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while ((readLTxt = bufferedReader.readLine()) != null) {
            String[] sLineChar = readLTxt.trim().split("\\s+");
            for (String s : sLineChar) {
                int i = Integer.parseInt(s);
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    public static void QSort(Integer[] array, int low, int high) {
        if (low < high) {
            int partition = partition(array, low, high);
            QSort(array, low, partition-1);
            QSort(array, partition+1, high);
        }
    }

    public static int partition(Integer[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= temp) low++;
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return high;
    }
}
