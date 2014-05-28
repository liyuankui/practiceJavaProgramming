package lyk.practice.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by stms130809 on 14-5-23.
 */
public class GenerateParentheses {
    public static int c=1;
    public static void main(String[] args){
        test(0,new ArrayList<String>());
        ArrayList<String> s = new ArrayList<String>();
        s.add("()");
        test(1, s);
        s = new ArrayList<String>();
        s.add("(())");s.add("()()");
        test(2, s);
        s = new ArrayList<String>();
        s.add("((()))");s.add("(()())");s.add("(())()");s.add("()(())");s.add("()()()");
        test(3, s);
    }

    public static void test(int x, ArrayList<String> solution){
        ArrayList<String> r=generateParenthesis(x) ;
        if(r.size()!=solution.size()||!r.containsAll(solution)){
            System.out.println("test case ` "+x+" ' fail, expecting "+solution+" getting "+r);
        }else{
            System.out.println("Pass case "+(c++));
        }
    }

    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ret = new ArrayList<String>();
        if(n>0){
            generateString(n,n,"",ret);
        }
        return  ret;
    }

    public static void generateString(int left, int right, String s, ArrayList<String> ret){
        if(left==0&&right==0){
            ret.add(s);
        }
        if(left>0){
            generateString(left-1,right,s+"(",ret);
        }
        if(right>0&&left<right){
            generateString(left, right-1,s+")",ret);
        }
    }
}

