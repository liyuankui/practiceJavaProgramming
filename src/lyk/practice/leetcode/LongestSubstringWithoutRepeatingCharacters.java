package lyk.practice.leetcode;

import lyk.practice.Util;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by stms130809 on 14-5-13.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        test("",0);
        test("a",1);
        test("aa",1);
        test("ab",2);
        test("aba",2);
        test("ababc",3);
        test("abcdabcd",4);
        test("abababababab",2);
        test("abaabbaabbaabbaabbaabb",2);
        test("abcaabcbb",3);
        test("abcaabcd",4);
        test("abcaabaaaaaabcd",4);
        test("abcaabbccddabcd",4);
        test("abcaabcdd",4);
        test("bbb",1);
        test("bbbb",1);
        test("bbbbb",1);
        test("ccbbdefg",5);
        test("abcdcefg",5);
        test("qopubjguxhxdipfzwswybgfylqvjzhar",12);

    }
    public static void test(String a, int b){
        int r=lengthOfLongestSubstring(a);
        if(r!=b){
            System.out.println("test case "+ a+" fail, expecting "+b+" getting "+r);
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n<=0) return 0;
        HashSet<Character> repeating = new HashSet<Character>();
        int ret=1;
        int start =0;
        for(int i =0; i<n;i++){
            Character character = Character.valueOf(s.charAt(i));
            if(repeating.contains(character)){
                int temp=start;
                for(;s.charAt(start)!=s.charAt(i);start++){
                    repeating.remove(Character.valueOf(s.charAt(start)));
                }
                start+=1;
            }else{
                int temp = i-start+1;
                ret = ret>=temp ? ret : temp;
            }
            repeating.add(character);
        }
        return ret;
    }
}
