package lyk.practice.leetcode;

import lyk.practice.Util;

import java.util.ArrayList;

/**
 * Created by stms130809 on 14-5-22.
 */
public class ZigZagConversion {
    public static void main(String[] args){
        test("",1,"");
        test("",5,"");
        test("A",1,"A");
        test("A",2,"A");
        test("AB",1,"AB");
        test("AB",2,"AB");
        test("ABC",1,"ABC");
        test("ABC",2,"ACB");
        test("ABC",3,"ABC");
        test("ABCD",1,"ABCD");
        test("ABCD",2,"ACBD");
        test("ABCD",3,"ABDC");
        test("ABCD",4,"ABCD");
        test("ABCDE",3,"AEBDC");
        test("ABCDEF",3,"AEBDFC");
        test("ABCDEFG",3,"AEBDFCG");
        test("ABCDEFGH",3,"AEBDFHCG");
        test("PAYPALISHIRING", 3,"PAHNAPLSIIGYIR");
    }
    public static void test(String s, int nRows, String solution){
        String r=convert(s, nRows);
        if(r.compareTo(solution)!=0){
            System.out.println("test case ["+s+","+nRows+"] fail, expecting "+solution+" getting "+r);
        }
    }

    public static String convert(String s, int nRows) {
        if(s.compareTo("")==0||nRows>=s.length()||nRows==1) return s;
        StringBuilder sb= new StringBuilder();
        ArrayList<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i =0; i<nRows;i++){
            rows.add(new StringBuilder());
        }
        char[] str=s.toCharArray();
        for(int i =0, row=0, offset=1;i<str.length;i++){
            rows.get(row).append(str[i]);
            row+=offset;
            if(row==nRows-1){
                offset=-1;
            }
            if(row==0){
                offset=1;
            }
        }
        for(int i =0; i<nRows;i++){
            rows.get(i).toString();
            sb.append(rows.get(i));
        }
        String ret=sb.toString();
        return  ret;
    }

}

