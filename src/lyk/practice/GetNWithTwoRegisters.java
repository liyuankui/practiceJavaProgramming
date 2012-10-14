package lyk.practice;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/14/12
 * Time: 12:18 AM
 * The GetNWithTwoRegisters class is intended to fulfil some duties.
 */

//两个寄存器a b 初始值都是1  只提供两种操作 a=a+b b=a+b 求最少的操作集合 使得有一个寄存器值为n
public class GetNWithTwoRegisters {
    public static int a = 1;
    public static int b = 1;

    public static void operationsForN(int n) {
        int[][] dp = new int[n + 1][n + 1];
        dp[1][1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[1][i] = i - 1;
        }
        for (int i = 2; i <= n; i++) {
            dp[i][1] = i - 1;
        }
        for (int i = 1; i <= n; i++)
            for (int j = i + 1; j <= n; j++) {
                if (dp[j - i][i] != 0)
                    dp[i][j] = dp[j - i][i] + 1;
            }

        Util.DumpMatrix(dp);
        int min = Integer.MAX_VALUE;
        int pos = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i][n] == 0) continue;
            if (dp[i][n] < min) {
                min = dp[i][n];
                pos = i;
            }
        }
        System.out.print(min + "-" + pos);


    }


    public static void main(String[] args) {
        operationsForN(17);
    }

}
