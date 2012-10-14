package lyk.practice;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/14/12
 * Time: 10:38 PM
 * The MoneyComposition class is intended to fulfil some duties.
 */
public class MoneyComposition {

    public static int[] facevalue = new int[]{1, 2, 5};

    // this is only solvable with a matrix dp structure, so only this one is correct
    public static int moreDP(int total) {
        int[][] dp = new int[total + 1][facevalue.length];
        for (int i = 0; i < facevalue.length; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= total; i++) {
            for (int j = 0; j < facevalue.length; j++) {
                if (j >= 1) dp[i][j] += dp[i][j - 1];
                if (i >= facevalue[j]) dp[i][j] += dp[i - facevalue[j]][j];
            }
        }
//        Util.DumpMatrix(dp);

        return dp[total][facevalue.length - 1];
    }

    public static int moneyByCalculation(int total) {
        int count = 0;
        for (int i = 0; i <= total; i++)
            for (int j = 0; j <= total; j++)
                for (int k = 0; k <= total; k++)
                    if (facevalue[0] * i + facevalue[1] * j + facevalue[2] * k == total)
                        count++;
        return count;


    }

    public static int moneyTreeRemembers(int total) {
        int[] dp = new int[total + 1];
        for (int value : facevalue) {
            if (value <= total)
                dp[value]++;
        }
        for (int i = 0; i <= total; i++) {
            int part = i / 2;
            System.out.println(i + "-" + part);
            for (int j = 0; j <= part; j++) {
                dp[i] += dp[j] + dp[i - j];
                Util.DumpArray(dp);
            }
        }
        Util.DumpArray(dp);
        return dp[total];
    }

    public static int moneyRemembers(int total) {
        int[] dp = new int[total + 1];
        for (int value : facevalue) {
            if (value <= total)
                dp[value]++;
        }
        Util.DumpArray(dp);
        for (int i = 1; i <= total; i++) {
            for (int j = 1; j <= i; j++) {
                if (i + j <= total) {
                    dp[i + j] += dp[j];
                    System.out.println("i=" + i + " j=" + j + " for " + (i + j) + " :" + dp[j]);
                    Util.DumpArray(dp);
                }
            }
        }

        Util.DumpArray(dp);
        return dp[total];

    }

    public static int moneyTalks(int total) {
        if (total == 0) return 1;

        int count = 0;
        for (int value : facevalue) {
            if (total > value)
                count += moneyTalks(total - value);
        }
        System.out.println(total + " " + count);
        return count;

    }

    public static void main(String[] args) {
        System.out.println(moreDP(101));
        System.out.println(moneyByCalculation(101));
    }
}
