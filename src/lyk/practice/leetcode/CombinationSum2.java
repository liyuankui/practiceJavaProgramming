package lyk.practice.leetcode;

import lyk.practice.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by stms130809 on 14-5-22.
 */
public class CombinationSum2 {
    public static int c=1;
    public static void main(String[] args){
        List<Integer> a= new ArrayList<Integer>();
        a.add(7);
        List<Integer> b= new ArrayList<Integer>();
        b.add(2);b.add(2);b.add(3);
        List<List<Integer>> s=new ArrayList<List<Integer>>();
        s.add(a);s.add(b);
        test(new int[]{2,2,3,6,7}, 7, s);

        s=new ArrayList<List<Integer>>();
        a=new ArrayList<Integer>();
        a.add(1);a.add(7);
        s.add(a);
        a=new ArrayList<Integer>();
        a.add(1);a.add(2);a.add(5);
        s.add(a);
        a=new ArrayList<Integer>();
        a.add(2);a.add(6);
        s.add(a);
        a=new ArrayList<Integer>();
        a.add(1);a.add(1);a.add(6);
        s.add(a);
        test(new int[]{10,1,2,7,6,1,5},8,s);
    }

    public static void test(int [] num, int target, List<List<Integer>> solution){
        List<List<Integer>> r=combinationSum2(num, target) ;

        if(r==null||r.size()!=solution.size()||!r.containsAll(solution)){
            System.out.println("test case fail, expecting "+solution+", getting " +r);
            System.out.print("[\n\t"); Util.DumpArray(num);System.out.println("]");
        }else{
            System.out.println("Pass case "+(c++));
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = candidates.length;
        Arrays.sort(candidates);
        if(n>0){
            combination(candidates, target, new HashSet<ArrayList<Integer>>(), ret, new ArrayList<Integer>(), 0, n);
        }
        return ret;
    }

    public static void combination(int[] candidates, int target, HashSet<ArrayList<Integer>> set,List<List<Integer>> ret, List<Integer> cur, int start, int end){
        if(target==0) {
            if(!set.contains(cur))
                ret.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i=start; i<end;){
            int rest=target-candidates[i];
            if(rest>=0){
                cur.add(candidates[i]);
                combination(candidates,rest,set, ret, cur, i+1, end);
                cur.remove(cur.size()-1);
            }
            if(rest<0){
                break;
            }
            i++;
            while(i<end&&candidates[i]==candidates[i-1]) {
                i++;
            }
        }
    }
}

