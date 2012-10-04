package lyk.practice;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/3/12
 * Time: 11:10 AM
 * The Util class is intended to fulfil some duties.
 */
public class Util {
    private Util() {

    }

    public static void DumpMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        System.out.println(matrix.getClass().getCanonicalName());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
}
