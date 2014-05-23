package lyk.practice.leetcode;

import lyk.practice.Util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by stms130809 on 14-5-22.
 */
public class ThreeSum {
    public static int c=1;
    public static void main(String[] args){
        ArrayList<Integer> a= new ArrayList<Integer>();
        a.add(-1);a.add(0);a.add(1);
        ArrayList<Integer> b= new ArrayList<Integer>();
        b.add(-1);b.add(-1);b.add(2);
        ArrayList<ArrayList<Integer>> s=new ArrayList<ArrayList<Integer>>();
        s.add(a);s.add(b);
        test(new int[]{-1, 0, 1, 2, -1, -4}, s);

        a= new ArrayList<Integer>();
        a.add(-2);a.add(0);a.add(2);
        s=new ArrayList<ArrayList<Integer>>();
        s.add(a);
        test(new int[]{-2, 0, 0, 2, 2}, s);
        a= new ArrayList<Integer>();
        a.add(0);a.add(0);a.add(0);
        s=new ArrayList<ArrayList<Integer>>();
        s.add(a);
        test(new int[]{0, 0, 0, 0}, s);
        test(new int[]{0, 0, 0, 0, 0}, s);
    }

    public static void test(int [] num, ArrayList<ArrayList<Integer>> solution){
        ArrayList<ArrayList<Integer>> r=threeSum(num) ;

        if(r==null||r.size()!=solution.size()||!r.containsAll(solution)){
            System.out.println("test case fail, expecting "+solution+", getting " +r);
            System.out.print("[\n\t"); Util.DumpArray(num);System.out.println("]");
        }else{
            System.out.println("Pass case "+(c++));
        }
    }

    public static ArrayList<ArrayList<Integer>> threeSum(int[] num)  {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        int n = num.length;
        Arrays.sort(num);
        for (int i=0;i<n-2;){
            // System.out.println(num[i]+" "+i);
            int s=i+1;
            int e=n-1;
            while(s<e){
                int sum=num[s]+num[e];
                if(num[i]==-sum){
                    ArrayList<Integer> ans= new ArrayList<Integer>();
                    ans.add(num[i]);
                    ans.add(num[s]);
                    ans.add(num[e]);
                    //if(!ret.contains(ans))
                    ret.add(ans);
                    do {
                        s++;
                    } while (num[s] == num[s-1]&&s<e);
                    do {
                        e--;
                    } while (num[e] == num[e+1]&&s<e);
                }else if(num[i]>-sum){
                    do {
                        e--;
                    } while (num[e] == num[e+1]&&s<e);
                }else if(num[i]<-sum){
                    do {
                        s++;
                    } while (num[s] == num[s-1]&&s<e);
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

