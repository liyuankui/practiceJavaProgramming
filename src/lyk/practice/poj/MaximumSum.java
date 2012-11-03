package lyk.practice.poj;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/24/12
 * Time: 2:03 PM
 * The MaximumSum class is intended to fulfil some duties.
 */

// http://poj.org/problem?id=2479

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaximumSum {

    public static int[] arr = new int[50001];
    public static int[] left = new int[50001];
    public static int[] right = new int[50001];
    public static int length;
    public static int result;

    public static void maxsum() {
        if (length == 1) {
            result = arr[0];
            return;
        }
        left[0] = arr[0];
        right[length - 1] = arr[length - 1];
        int tmpleft = arr[0];
        int tmpright = arr[length - 1];
        for (int i = 1; i < length; i++) {
            if (tmpleft < 0) {
                tmpleft = 0;
            }
            tmpleft += arr[i];
            left[i] = Math.max(left[i - 1], tmpleft);

            if (tmpright < 0) {
                tmpright = 0;
            }
            tmpright += arr[length - i - 1];
            right[length - 1 - i] = Math.max(right[length - i], tmpright);
        }

        result = Integer.MIN_VALUE;
        for (int i = 1; i < length; ++i) {
            result = Math.max(result, left[i - 1] + right[i]);
        }
    }

    public static void main(String[] args) throws Exception {
/* 3000ms
        Scanner in = new Scanner(System.in);
        int count=Integer.parseInt(in.nextLine());
        for(int i=0;i<count;i++){
            in.nextLine();
            length=Integer.parseInt(in.nextLine());
            String []s = in.nextLine().split(" ");
            for(int j=0;j<length;j++){
                arr[j]=Integer.parseInt(s[j]);
            }
            maxsum();
            System.out.println(r);
        }

         */
        // learn: buffered reader is much faster than scanner
        // scanner 3000ms while buffered reader 900ms
        BufferedReader read = new BufferedReader(new InputStreamReader(
                System.in));
        int count = Integer.parseInt(read.readLine());
        for (int i = 0; i < count; i++) {
            read.readLine();
            length = Integer.parseInt(read.readLine());
            String[] s = read.readLine().split(" ");
            for (int j = 0; j < length; j++) {
                arr[j] = Integer.parseInt(s[j]);
            }
            maxsum();
            System.out.println(result);
        }
    }
}
