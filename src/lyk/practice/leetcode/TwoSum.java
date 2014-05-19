package lyk.practice.leetcode;

import lyk.practice.Util;

import java.util.Arrays;

/**
 * Created by stms130809 on 14-5-12.
 * http://oj.leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public static void main (String[] args) throws java.lang.Exception {
        test(new int[]{2,7,11,15},9);
        test(new int[]{0,4,3,0},0);
        test(new int[]{5,75,25},100);
    }

    public static void test(int[] numbers, int target){
        int[] a = twoSum(numbers, target);
        Util.DumpArray(a);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        int[] orig= numbers.clone();
        Arrays.sort(numbers);
        int max=numbers.length;
        int l=0;
        int r= max-1;
        int sum=numbers[l]+numbers[r];
        while(target!=sum&&l<r){
            if(sum<target)
                l++;
            else if(sum>target)
                r--;
            sum=numbers[l]+numbers[r];
        }
        for(int i=0;i<max;i++){
            if(orig[i]==numbers[l]) {
                l=i;
                break;
            }
        }
        for(int i=max-1;i>=0;i--){
            if(orig[i]==numbers[r]) {
                r=i;
                break;
            }
        }
        if(l>r) {
            int temp=r;
            r=l;
            l=temp;
        }
        ret[0]=l+1;
        ret[1]=r+1;
        return ret;
    }
}
