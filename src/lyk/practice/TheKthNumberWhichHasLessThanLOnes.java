package lyk.practice;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/12/12
 * Time: 8:57 PM
 * The TheKthNumberWhichHasLessThanLOnes class is intended to fulfil some duties.
 */
public class TheKthNumberWhichHasLessThanLOnes {

    public static void go(int k, int l) {
        if (1 == 1) ;
    }

    public static void onesAndzeros() {
        int[][][] dp = new int[5][5][];
        dp[0][0] = new int[]{0};
        dp[1][0] = new int[]{1};
        for (int i = 0; i < 5; i++) {
            dp[0][i] = dp[0][0];
        }
        for (int i = 1; i < 5; i++)
            for (int j = 1; j < 5; j++) {
                int[] tmp = new int[Util.CombinationNumber(i + j, i)];
                int index = 0;


            }
    }


    public static int[] theArrayOfKNumbersWithLOnes(int k, int l) {
        if (k < 0 || l < 0) throw new IllegalArgumentException();
        int[] arr = new int[k];
        int numberOfZero = 0;

        String oneString = Util.stringWithNC(4, '1');
        String zeroString = Util.stringWithNC(4, '0');
        char[] numberchars = (oneString + zeroString).toCharArray();

        int i = 3;
        int length = numberchars.length;

        while (i-- >= 0) {
            int temp = Integer.parseInt(oneString, 2);
            arr[i++] = temp;
        }

        return arr;


    }


    public static void main(String[] args) {
        System.out.println(Util.CombinationNumber(5, 4));
    }
}
