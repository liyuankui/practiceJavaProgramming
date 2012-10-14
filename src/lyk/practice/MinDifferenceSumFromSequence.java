package lyk.practice;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/14/12
 * Time: 4:47 PM
 * The MinDifferenceSumFromSequence class is intended to fulfil some duties.
 */
public class MinDifferenceSumFromSequence {


    public static void minDiff(int[] arr, int k) {
        Arrays.sort(arr);
        Util.DumpArray(arr);
        int[][] dp = new int[arr.length][++k];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < arr.length; i++)
            dp[i][0] = 0;

        for (int j = 1; j < k; j++) {
            for (int i = 0; i < arr.length; i++) {
                int dpv = 0;
                if (i + 1 < j * 2) // not enough numbers to form k pairs
                    dpv = Integer.MAX_VALUE;
                else {
                    if (i == 1) {
                        dpv = arr[i] - arr[i - 1];
                    } else {
                        int dpone = dp[i - 1][j];
                        int dptwo = dp[i - 2][j - 1] + arr[i] - arr[i - 1];
                        dpv = dpone < dptwo ? dpone : dptwo;
                    }
                }
                dp[i][j] = dpv;
            }
        }

        Util.DumpMatrix(dp);
        System.out.println(dp[arr.length - 1][k - 1]);
    }

    public static void main(String[] args) {
        minDiff(new int[]{2, 5, 6, 9}, 2);
        minDiff(new int[]{1731, 1572, 2041, 1561, 1682, 1572, 1609, 1731}, 3);
    }
}
