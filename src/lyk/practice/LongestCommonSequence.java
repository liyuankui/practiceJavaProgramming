package lyk.practice;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/3/12
 * Time: 11:23 PM
 * The LongestCommonSequence class is intended to fulfil some duties.
 */
public class LongestCommonSequence {

    public static void lcs(char[] p, char[] q) {
        int m = p.length, n = q.length;
        int[][] lcsl = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p[i - 1] == q[j - 1]) {
                    lcsl[i][j] = lcsl[i - 1][j - 1] + 1;
                } else {
                    lcsl[i][j] = lcsl[i - 1][j] > lcsl[i][j - 1] ? lcsl[i - 1][j] : lcsl[i][j - 1];
                }
            }
        }

        getLCS(lcsl, m, n, p, q);

        System.out.println(lcsl[m][n]);
        Util.DumpMatrix(lcsl);

    }

    public static void getLCS(int[][] lcsl, int m, int n, char[] p, char[] q) {
        String lcs = "";
        int i = m;
        int j = n;
        while (i >= 1 && j >= 1) {
            if (p[i - 1] == q[j - 1]) {
                lcs = p[i - 1] + lcs;
                System.out.println((i) + "." + (j) + ":" + p[i - 1]);
                i--;
                j--;
            } else {
                if (lcsl[i - 1][j] >= lcsl[i][j - 1]) {
                    i--;
                    System.out.println(i + "." + j);
                }
                if (lcsl[i - 1][j] <= lcsl[i][j - 1]) {
                    j--;
                    System.out.println(i + "." + j);
                }
            }
        }
        System.out.println(lcs);
    }

    public static void main(String[] args) {
        lcs("aabza".toCharArray(), "aabzaa".toCharArray());
    }
}
