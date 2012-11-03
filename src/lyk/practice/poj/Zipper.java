package lyk.practice.poj;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/23/12
 * Time: 7:39 PM
 * The Zipper class is intended to fulfil some duties.
 */

// http://poj.org/problem?id=2192

import java.util.Scanner;

public class Zipper {


    public static boolean isZipped(char[] a, char[] b, char[] c) {
        int m = a.length;
        int n = b.length;
        int l = c.length;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            dp[0][i] = c[0] == a[0] || c[0] == b[0];
            dp[i][0] = c[0] == a[0] || c[0] == b[0];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && c[i + j - 1] == a[i - 1]) || (dp[i][j - 1] && c[i + j - 1] == b[j - 1]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int count = Integer.parseInt(cin.nextLine());
        int i = 1;
        while (i <= count) {
            String data = cin.nextLine();
            String[] strings = data.split(" ");
            String result = isZipped(strings[0].toCharArray(), strings[1].toCharArray(), strings[2].toCharArray()) ? "yes" : "no";
            System.out.println("Data set " + i + ": " + result);
            i++;
        }
    }
}
