package lyk.practice.poj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/26/12
 * Time: 2:38 PM
 * The BracketsSequence class is intended to fulfil some duties.
 */
// http://poj.org/problem?id=1141
/*
Sample Input
([(]
([)]
(()(([([)]]])
Sample Output:
Write to the output file a single line that contains some regular
brackets sequence that has the minimal possible length and contains
the given sequence as a subsequence.

()[()]
*/
public class BracketsSequence {

    /*
    public static int PEACE=321;
    public static int OPENCURL=988;
    public static int OPENSQUARE=9912;
    public static char[] matchBrackets(char[] arr){
        int curl=0;
        int square=0;
        int tag=PEACE;
        int length=arr.length;
        char [] out=new char[200];
        int count=0;
        for (char anArr : arr) {
            switch (anArr) {
                case '[':
                    square++;
                    tag = OPENSQUARE;
                    break;
                case ']':
                    if (tag == OPENSQUARE) {
                        square--;
                    } else if (tag == PEACE) {
                        out[count++] = '[';
                    } else if (tag == OPENCURL) {
                        while (curl > 0) {
                            out[count++] = ')';
                            curl--;
                        }
                    }
                    break;
                case '(':
                    curl++;
                    tag = OPENCURL;
                    break;
                case ')':
                    if (tag == OPENCURL) {
                        curl--;
                    } else if (tag == PEACE) {
                        out[count++] = '(';
                    } else if (tag == OPENSQUARE) {
                        while (square > 0) {
                            out[count++] = ']';
                            square--;
                        }
                    }
                    break;
                default:
                    System.out.println("Unhandled character: " + anArr);
            }
            out[count++] = anArr;
        }

        System.out.println(curl+","+square);

        return out;

    }
    */

    public static void printSequence(char[] arr, int[][] pos, int start, int end) {
        if (start > end) return;
        if (start == end) {
            if (arr[start] == '(' || arr[start] == ')')
                System.out.print("()");
            else
                System.out.print("[]");
        } else if (pos[start][end] == -1) {
            System.out.print(arr[start]);
            printSequence(arr, pos, start + 1, end - 1);
            System.out.print(arr[end]);
        } else {
            printSequence(arr, pos, start, pos[start][end]);
            printSequence(arr, pos, pos[start][end] + 1, end);
        }
    }

    public static char[] dpBrackets(char[] arr) {
        int length = arr.length;
        int[][] dp = new int[length][length];
        int[][] pos = new int[length][length];
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++)
                dp[i][j] = length * 2;

        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
            if (i < length - 1)
                dp[i + 1][i] = 0;
        }

        // increasing the step
        for (int step = 1; step < length; step++) {
            for (int i = 0; i + step < length; i++) {
                int j = step + i;
                int min = length * 2;
                if ((arr[i] == '(' && arr[j] == ')') || (arr[i] == '[' && arr[j] == ']'))
                    min = dp[i + 1][j - 1];
                pos[i][j] = -1;
                for (int k = i; k < j; k++) {
                    if (min > dp[i][k] + dp[k + 1][j]) {
                        min = dp[i][k] + dp[k + 1][j];
                        pos[i][j] = k;
                    }
                }
                dp[i][j] = min;
                //System.out.println("("+i+","+j+")"+"<-"+min);
            }
        }

        //System.out.println("length: "+dp[0][length-1]);
        //Util.DumpMatrix(dp);
        printSequence(arr, pos, 0, length - 1);
        System.out.println();
        return arr;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        char[] input = read.readLine().toCharArray();
        dpBrackets(input);
    }
}
