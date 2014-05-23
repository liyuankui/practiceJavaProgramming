package lyk.practice.leetcode;

import java.util.ArrayList;

/**
 * Created by stms130809 on 14-5-22.
 */
public class ReverseInteger {
    public static void main(String[] args){
        test(0,0);
        test(-1,-1);
        test(299792458,854297992);
        //test(1000000003 ,3000000001);
    }

    public static void test(int x, int solution){
        int r=reverse(x) ;
        if(r!=solution){
            System.out.println("test case ["+x+"] fail, expecting "+solution+" getting "+r);
        }
    }

    public static int reverse(int x) {
        int ret =-1;
        String s;
        if(x<0){
            s = ""+(-x);
        }else {
            s=""+x;
        }
        char [] str= s.toCharArray();
        StringBuilder sb = new StringBuilder();
        if(x<0){
            sb.append("-");
        }
        for(int i = str.length-1;i>=0;i--){
            sb.append(str[i]);
        }
        try {
            ret = Integer.parseInt(sb.toString());
        }catch(Exception e){

        }
        return ret;
    }
}

