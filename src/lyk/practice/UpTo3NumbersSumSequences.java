package lyk.practice;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/24/12
 * Time: 7:57 PM
 * The UpTo3NumbersSumSequences class is intended to fulfil some duties.
 */
public class UpTo3NumbersSumSequences {


    public static void sums(int[] a, int count) {
        int n = a.length;
        int[] z = new int[n + 2];
        for (int i = 0; i < n; i++)
            z[i + 2] = a[i];
        boolean[] taken = new boolean[n + 2];

        int[] p = new int[3];
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            p[i] = i;
            taken[i] = true;
            sum += z[p[i]];
        }


        while (count > 0) {
            System.out.println(sum + "");

            int[] sums = new int[3];

            for (int i = 0; i < 3; i++) {
                int[] next = Arrays.copyOf(p, 3);
                int cur = next[i];
                while (taken[cur]) cur++;
            }


        }
    }

    public static void main(String[] args) throws Exception {
        int[] a = new int[]{3, 4, 5, 6, 12, 15, 19, 20, 25};
        sums(a, 7);

    }
}
