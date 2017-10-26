/**
 * Created by LXF on 2017/8/10.
 */
import java.util.Scanner;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
//    static int maxScore(int[] score) {
//        int[] max = new int[score.length];
//      for(int i=0;i<score.length;i++) {
//          if (score[i]!=0) {
//              if (i - 1 < 0 || score[i] == 0||score[i+1]>) {
//                  int left = 1;
//              }
//          }
//      }
//
//    }
    static int maxScore(int[] score) {
        int n = score.length;
        int[] nums = new int[n + 2];
        for (int i = 0; i < n; i++)
            nums[i + 1] = score[i];
        nums[0] = nums[n + 1] = 1;
        int[][] alibaba = new int[n + 2][n + 2];
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n - k + 1; i++) {
                int j = i + k - 1;
                for (int x = i; x <= j; x++) {
                    alibaba[i][j] = Math.max(alibaba[i][j], alibaba[i][x - 1] + nums[i - 1] * nums[x] * nums[j + 1] + alibaba[x + 1][j]) ;
                }
            }
        }
        return alibaba[1][n];
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _score_size = 0;
        _score_size = Integer.parseInt(in.nextLine().trim());
        int[] _score = new int[_score_size];
        int _score_item;
        for(int _score_i = 0; _score_i < _score_size; _score_i++) {
            _score_item = Integer.parseInt(in.nextLine().trim());
            _score[_score_i] = _score_item;
        }

        res = maxScore(_score);
        System.out.println(String.valueOf(res));

    }
}