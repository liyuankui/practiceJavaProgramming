package lyk.practice.leetcode;

import lyk.practice.Util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by stms130809 on 14-5-22.
 */
public class ThreeSumClosest {
    public static int c=1;
    public static void main(String[] args){
        test(new int[]{-1, 0, 1, 2, -1, -4}, 0, 0);
        test(new int[]{-2, 0, 0, 2, 2}, 0, 0);
        test(new int[]{0, 0, 0, 0}, 0, 0);
        test(new int[]{0, 0, 0, 0, 0}, 0, 0);
        test(new int []{-1, 2, 1, -4}, 1, 2);
        test(new int []{1,1,2,3,5,8}, 1, 4);
        test(new int []{1,1,2,3,5,8}, 2, 4);
        test(new int []{1,1,2,3,5,8}, 3, 4);
        test(new int []{1,1,2,3,5,8}, 4, 4);
        test(new int []{1,1,2,3,5,8}, 5, 5);
        test(new int []{1,1,2,3,5,8}, 6, 6);
    }

    public static void test(int [] num, int target, int solution){
        int r=threeSumClosest(num, target) ;

        if(r!=solution){
            System.out.println("test case fail, expecting "+solution+", getting " +r);
            System.out.print("[\n\t"); Util.DumpArray(num);System.out.println("], for "+target);
        }else{
            System.out.println("Pass case "+(c++));
        }
    }

    public static int threeSumClosest(int[] num, int target)  {
        int ret=-1;
        int n = num.length;
        Arrays.sort(num);
        int absdiff=Integer.MAX_VALUE;
        int diff;
        for (int i=0;i<n-2;){
            // System.out.println(num[i]+" "+i);
            int s=i+1;
            int e=n-1;
            while(s<e){
                int sum=num[i]+num[s]+num[e];
                int tempdiff=sum-target;
                tempdiff=tempdiff>=0?tempdiff:-tempdiff;
                if(tempdiff<absdiff){
                    absdiff=tempdiff;
                    ret=sum;
                }
                if(sum<=target){
                    s++;
                }else{
                    e--;
                }
            }
            do{
                i++;
            }
            while(num[i]==num[i-1]&&i<n-1);
            if(i>=n-2) break;
        }
        return  ret;
    }
}

