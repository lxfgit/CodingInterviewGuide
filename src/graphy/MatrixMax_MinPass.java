package graphy;

/**
 * Created by LXF on 2017/7/19.
 */
public class MatrixMax_MinPass {
    public static void main(String[] args) {
        int matrix[][] = {
                 /*A*//*B*//*C*//*D*/
          /*A*/ {1, 1, 6, 1,3},
          /*B*/ {2, 2, 4, 1,2},
          /*C*/ {3, 1, 3, 2,6},
          /*D*/ {3, 5, 1, 1,2},
        };
        printDist(getMost(matrix));
    }

    private static void printDist(int[][] most) {
        System.out.printf("floyd: \n");
        for(int i = 0;i<most.length;i++) {
            for (int j = 0; j < most[0].length; j++)
                System.out.printf("%12d  ", most[i][j]);
            System.out.printf("\n");
        }
    }

    public static int[][] getMost(int[][] board) {
        int jj=board.length;
        int ii=board[0].length;
        int[][] arr = new int[jj][ii];
        for(int i = 0;i<jj;i++){
            for(int j = 0;j<ii;j++){
                int b = board[i][j];
                if(i==0&&j==0)
                    arr[i][j] = b;
                else if(i==0){
                    arr[i][j] = arr[i][j-1]+b;
                }else if (j==0) {
                    arr[i][j] = arr[i-1][j]+b;
                }else{
                    arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j])+b;
                }
            }
        }
        return arr;
    }

}
