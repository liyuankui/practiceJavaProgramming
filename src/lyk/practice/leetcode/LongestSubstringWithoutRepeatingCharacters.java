package lyk.practice.leetcode;

/**
 * Created by stms130809 on 14-5-13.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        test("abcaabcbb",3);
        test("bbbbb",1);
    }
    public static void test(String a, int b){
        int r=lengthOfLongestSubstring(a);
        if(r!=b){
            System.out.println("test case "+ a+" fail, expecting "+b+" getting "+r);
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        int ret=-1;

        return  ret;
    }
}
