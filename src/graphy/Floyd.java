package graphy;

/**
 * Created by LXF on 2017/7/19.
 */
public class Floyd {
    public static void main(String[] args) {
        char[] Nodes = {'0', '1', '2', '3'};

        int matrix[][] = {
                 /*A*//*B*//*C*//*D*/
          /*A*/ {0, 1, 1, 0, 1},
          /*B*/ {1, 0, 0, 1, 1},
          /*C*/ {1, 0, 0, 1, 0},
          /*D*/ {0, 1, 1, 0, 1},
          /*E*/ {1, 1, 0, 1, 0},
        };
        printDist(getFloyDist(matrix));
    }

    public static int[][] getFloyDist(int[][] matrix) {
        int n = matrix[0].length;
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = matrix[i][j];
            }
        }
        int[][] equalsToVal = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                equalsToVal[i][j] = 0;
            }
        }
        for (int k = 0; k < n; k++) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = (distance[i][k] == 0 || distance[k][j] == 0) ? 0 : distance[i][k] + distance[k][j];
                    if (temp == 2) {
                        equalsToVal[i][j]++;
                    }
                }
            }
        }
        return equalsToVal;
    }


    public static void printDist(int[][] floyd) {
        System.out.printf("floyd: \n");
        for (int i = 0; i < floyd.length; i++) {
            for (int j = 0; j < floyd[0].length; j++)
                System.out.printf("%12d  ", floyd[i][j]);
            System.out.printf("\n");
        }
    }

}
