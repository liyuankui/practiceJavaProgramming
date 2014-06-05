package lyk.practice.leetcode;

import java.util.Stack;

/**
 * Created by stms130809 on 14-5-23.
 */
public class ImplementStrStr {
    public static int c=1;
    public static void main(String[] args){
        test("ab","a","ab");
        test("ab","b","b");

    }

    public static void test(String haystack, String needle, String solution){
        String r=strStr(haystack,needle) ;
        if(r!=null||r.compareTo(solution)!=0){
            System.out.println("test case ` "+haystack+" "+needle+" ' fail, expecting "+solution+" getting "+r);
        }else{
            System.out.println("Pass case "+(c++));
        }
    }

    public static String  strStr(String haystack, String needle) {
        String ret=null;
        return ret;
    }
}

