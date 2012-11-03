package lyk.practice.poj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/24/12
 * Time: 4:06 PM
 * The MaximumSequence class is intended to fulfil some duties.
 */

// http://poj.org/problem?id=2593

public class MaximumSequence {


    public static int[] arr = new int[100001];
    public static int[] left = new int[100001];
    public static int[] right = new int[100001];

    public static int length = -1;
    public static int result = -1;


    public static void maxseq() {
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
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        do {
            length = Integer.parseInt(read.readLine());
            if (length <= 0) break;
            String[] s = read.readLine().split(" ");
            for (int i = 0; i < length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            maxseq();
            System.out.println(result);
        } while (length != 0);

        /*
        for(length=Integer.parseInt(read.readLine()); length>0;length=Integer.parseInt(read.readLine())){
            if(length<=0) break;
            String []s=read.readLine().split(" ");
            for(int i=0;i<length;i++){
                arr[i]=Integer.parseInt(s[i]);
            }
            maxseq();
            System.out.println(result);
        }
        */

    }
}
