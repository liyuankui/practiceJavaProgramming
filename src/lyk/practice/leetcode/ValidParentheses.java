package lyk.practice.leetcode;

import java.util.Stack;

/**
 * Created by stms130809 on 14-5-23.
 */
public class ValidParentheses {
    public static int c=1;
    public static void main(String[] args){
        test("",true);
        test("()",true);
        test("(]",false);
        test("{]",false);
        test("{[]",false);
        test("[]]]]]",false);
    }

    public static void test(String x, boolean solution){
        boolean r=isValid(x) ;
        if(r!=solution){
            System.out.println("test case ` "+x+" ' fail, expecting "+solution+" getting "+r);
        }else{
            System.out.println("Pass case "+(c++));
        }
    }

    public static boolean isValid(String s) {
        boolean ret = true;
        int n=s.length();
        Stack<Character> stack= new Stack<Character>();
        for(int i=0;i<n;i++){
            char x= s.charAt(i);
            if(x== '(' || x == '['|| x== '{') {
                stack.add(x);
            }
            if(x==')'||x==']'||x=='}') {
                if(stack.size()==0) {
                    ret=false;
                    break;
                }
                Character y=stack.pop();
                if((x==')'&&y=='(')||
                   (x==']'&&y=='[')||
                   (x=='}'&&y=='{')){

                }else{
                    ret=false;
                    break;
                }
            }
        }
        if(stack.size()>0) ret=false;
        return ret;
    }
}

