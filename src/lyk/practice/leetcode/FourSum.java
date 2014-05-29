package lyk.practice.leetcode;

import lyk.practice.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by stms130809 on 14-5-22.
 */
public class FourSum {
    public static int c=1;
    public static void main(String[] args){
        ArrayList<Integer> a= new ArrayList<Integer>();
        a.add(-1);a.add(0);a.add(0);a.add(1);
        ArrayList<Integer> b= new ArrayList<Integer>();
        b.add(-2);b.add(-1);b.add(1);b.add(2);
        ArrayList<Integer> c= new ArrayList<Integer>();
        c.add(-2);c.add(0);c.add(0);c.add(2);
        ArrayList<ArrayList<Integer>> s=new ArrayList<ArrayList<Integer>>();
        s.add(a);s.add(b);s.add(c);
        test(new int[]{1, 0, -1, 0, -2, 2}, 0, s);

    }

    public static void test(int [] num, int target, ArrayList<ArrayList<Integer>> solution){
        List<List<Integer>> r=fourSum(num,target) ;

        if(r==null||r.size()!=solution.size()||!r.containsAll(solution)){
            System.out.println("test case fail, expecting "+solution+", getting " +r);
            System.out.print("[\n\t"); Util.DumpArray(num);System.out.println("]");
        }else{
            System.out.println("Pass case "+(c++));
        }
    }

    public static List<List<Integer>> fourSum(int[] num, int target)  {
        int n=num.length;
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    int sum = num[i] + num[j] + num[l] + num[r];
                    if (sum > target) {
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[l]);
                        temp.add(num[r]);
                        if (!hashSet.contains(temp)) {
                            hashSet.add(temp);
                            ret.add(temp);
                        }
                        l++;
                        r--;
                    }
                }
            }
        }
        return ret;
    }
}

