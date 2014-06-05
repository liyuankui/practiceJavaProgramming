package lyk.practice.leetcode;

import lyk.practice.Util;

import java.util.ArrayList;
import java.util.BitSet;

/**
 * Created by stms130809 on 14-5-23.
 */
public class FirstMissingPositive {
    public static int c=1;
    public static void main(String[] args){
        test(new int[]{1},2);
        test(new int[]{1,1},2);
        test(new int[]{1,1000},2);
        test(new int[]{1,2,3,0},4);
        test(new int[]{0,2,2,1,1},3);
        test(new int[]{3,2,1,0},4);
        test(new int[]{1,2,3,-1},4);
        test(new int[]{1,2,3,-1,5,6,7},4);
        test(new int[]{1,2,3,-1,4,5,7},6);
        test(new int[]{2,3,0},1);
        test(new int[]{2,1},3);
        test(new int[]{3,4,-1,1},2);
        test(new int[]{2,3,-1},1);
    }

    public static void test(int[] A, int solution){
        int r=firstMissingPositive(A) ;
        if(r!=solution){
            System.out.println("test case "+c+" fail, expecting "+solution+" getting "+r);
            Util.DumpArray(A);
        }else{
            System.out.println("Pass case "+c);
        }
        c++;
    }

    public static int firstMissingPositive(int[] A) {
        int min=Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if(A.length==1){
            if(A[0]==1)
                return 2;
            else
                return 1;
        }
        for(int x:A){
            if(x<=0) continue;
            min = min<=x?min:x;
            max = max>=x?max:x;
        }
        if(min>1) return 1;
        for(int i=0;i<A.length;){
            System.out.println("with "+A[i]);
            if(A[i]>A.length || A[i]<=0){
                A[i++]=-1;
                continue;
            }
            if(A[i]!=i+1){
                int index = A[i]-1;
                int t = A[index];
                if(t!=A[i]){
                    System.out.println("swaping "+A[i]+" "+t);
                    A[index] = A[i];
                    A[i] = t;
                }else{
                    A[i]=0;
                }
            }
            i++;
        }
        for(int i=0;i<A.length;i++){
            if(A[i]<=0){
                return i+1;
            }
        }
        return max+1;
    }

    public static int firstMissingPositive2(int[] A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> p=new ArrayList<Integer>();
        for(int i : A){
            if(i<0) continue;
            p.add(i);
            max = max >= i ? max : i;
            min = min <= i ? min : i;
        }
        int x[] = new int[max+1];
        for(int i :A){
            if(i<0) continue;
            x[i]=1;
        }
        for(int i=1;i<x.length;i++){
            if(x[i]!=1)
                return i;
        }
        return max+1;
    }
}

