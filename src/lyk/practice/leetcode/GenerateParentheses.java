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
        Stack<Character> stack = new Stack<Character>();
        char pl='(';
        char pr=')';

//        stack.empty();
        for(int i =0; i<n;i++){
            stack.push(pl);
        }
        while(stack.size()>0) {
            StringBuilder sb = new StringBuilder();
            stack.pop()
        }

        return  ret;
    }
}

