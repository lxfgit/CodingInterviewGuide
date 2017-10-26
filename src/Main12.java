import java.util.ArrayList;
import java.util.Scanner;

public class Main12 {
    static private final int POINT_NUM = 9;
    static private int[][] e = new int[Integer.MAX_VALUE/20000][Integer.MAX_VALUE/20000];


    static ArrayList<Integer> trace=new ArrayList<Integer>();
    static boolean hasCycle=false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(",");
        System.out.println(s.length);

        MouldeIsCycularDependecy(0);
        if(!hasCycle)
            System.out.println("No Cycle.");
    }

    static void AddDependency(int mId, int dId) {
        e[mId][dId] = 1;
    }

    static boolean MouldeIsCycularDependecy(int v) {
        int j;
        if((j=trace.indexOf(v))!=-1) {
            hasCycle=true;
            return hasCycle;
        }
        trace.add(v);

        for(int i=0;i<POINT_NUM;i++)
        {
            if(e[v][i]==1)
                MouldeIsCycularDependecy(i);
        }
        trace.remove(trace.size()-1);
        if (trace.size() == 1) {
            return hasCycle;
        }
        return hasCycle;
    }
}