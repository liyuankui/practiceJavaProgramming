package lyk.practice.leetcode;

import lyk.practice.Util;

import java.util.HashSet;

/**
 * Created by stms130809 on 14-5-21.
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args){
        test(new int[]{1},new int[]{2},2);
        test(new int[]{1,2},new int[]{3},2);
        test(new int[]{1,2,3},new int[]{1},2);
        test(new int[]{1,2,3},new int[]{2},2);
        test(new int[]{1,2,3},new int[]{3},2);
        test(new int[]{1,2,3},new int[]{-1},1);
        test(new int[]{1,2,3},new int[]{4,5,6,7},4);
        test(new int[]{1,2,3},new int[]{4,5,6,7,8},4);
        test(new int[]{1,4,5},new int[]{2,3},3);
        test(new int[]{1,4,5,6,7},new int[]{2,3},4);
    }
    public static void test(int A[], int B[], double solution){
        double r=findMedianSortedArrays(A, B);
        if(r!=solution){
            System.out.println("test case "+" fail, expecting "+solution+" getting "+r);
            System.out.print("\t A: ");
            Util.DumpArray(A);
            System.out.print("\t B: ");
            Util.DumpArray(B);
        }
    }

    public static double findMedianSortedArrays(int A[], int B[]) {
        double ret =-1;
        int m = A.length;
        int n = B.length;
        int l = m+n;


        while(ret==-1) {
            int al=0;
            int bl=0;
            int ar = m;
            int br = n;

            int am = (ar + al - 1) / 2;
            int bm = (br + bl - 1) / 2;

            if(A[am]>B[bm]){

            }
        }

        return ret;
    }

}
