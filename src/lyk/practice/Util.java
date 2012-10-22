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

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static void reverse(int[] arr, int a, int b) {
        while (a <= b) {
            swap(arr, a++, b--);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[b];
        arr[b] = arr[a];
        arr[a] = tmp;
        //arr[a]^=arr[b]; arr[b]^=arr[a]; arr[a]^=arr[b];
    }

    public static String stringWithNC(int n, char c) {
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static int CombinationNumber(int n, int k) {
        int x = 1;
        int d = k > n - k ? k : n - k;
        int p = k < n - k ? k : n - k;

        System.out.println("d" + d + "p" + p);
        while (n > d) {
            x *= n--;
        }
        System.out.println("d" + d + "p" + p);
        x /= PermutationNumber(p);

        return x;
    }

    public static int PermutationNumber(int n) {
        int x = 1;
        System.out.println("per n=" + n);
        while (n > 0) {
            x *= n--;
        }
        System.out.println("per n=" + n);
        return x;
    }

    public static int powerTwo(int x, int p) {
        while (p-- > 0) {
            x <<= 1;
        }
        return x;
    }

    public static void DumpArray(int[] array) {
        int n = array.length;
        for (Object anArray : array) {
            System.out.print(anArray.toString() + " ");
        }
        System.out.println();
    }

    public static void DumpMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        System.out.println(matrix.getClass().getCanonicalName());
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < n; j++)
                System.out.print(aMatrix[j] + " ");
            System.out.println();
        }
    }
}
