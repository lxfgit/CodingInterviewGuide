import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by LXF on 2017/8/11.
 */
public class Dche {
    public static int qTime(int taxiNum, int[] heng, int[] zong, Point gs, int wt, int tt) {

        HashMap<Point, Integer> taxi = new HashMap<Point, Integer>();
        int n = heng.length;
        int zouLu = (Math.abs(gs.x) + Math.abs(gs.y)) * wt;
        if (n == 0) {
            return (wt > tt ? tt : wt) * (gs.x + gs.y);
        }
        for (int i = 0; i < n; i++) {
            Point point = new Point(heng[i], zong[i]);
            taxi.put(point, 0);
        }

        Iterator map = taxi.entrySet().iterator();
        while (map.hasNext()) {
            Map.Entry entry = (Map.Entry) map.next();
            Point point  = (Point) entry.getKey();
            int zouD = (Math.abs(point.x) + Math.abs(point.y)) * wt;
            int dacheD = Math.abs((gs.x-point.x) + Math.abs(gs.y-point.y)) * tt;
            entry.setValue(Math.min(zouLu, zouD + dacheD));
        }
        int min = Integer.MAX_VALUE;
        Iterator iter = (Iterator) taxi.values();
        while (iter.hasNext()) {
            int d = (int) iter.next();
            min = Math.min(min, d);
        }
        return min;
    }


    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        String[] h = scanner.nextLine().toCharArray().toString().split(" ");
//        String[] z = scanner.nextLine().toCharArray().toString().split(" ");
//        int x = scanner.nextInt();
//        int y = scanner.nextInt();
        Point gs = new Point(-4, -2);
        int[] heng = new int[]{-2,-2};
        int[] zong = new int[]{0,-2};
//
//        for (int i = 0;i<n;i++) {
//            heng[i] = Integer.parseInt(h[i]);
//            zong[i] = Integer.parseInt(z[i]);
//        }
//        int w = scanner.nextInt();
//        int t = scanner.nextInt();

        int n = 2;

        System.out.println(qTime(n, heng, zong, gs, 15, 3));
    }

}
