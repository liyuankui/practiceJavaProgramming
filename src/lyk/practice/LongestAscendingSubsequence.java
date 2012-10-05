package lyk.practice;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/4/12
 * Time: 10:25 AM
 * The LongestAscendingSubsequence class is intended to fulfil some duties.
 */
public class LongestAscendingSubsequence {

    //O(n^2)
    public static void las(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = dp[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] >= arr[j]) {
                    max = max > dp[j] ? max : dp[j];
                }
            }
            dp[i] = max + 1;
        }
        System.out.println(dp[n - 1]);
    }

    public static void main(String[] args) {
        las(new int[]{1, 2, 2, 3, 2, 3, 1, 4, 5, 6});
    }
}
