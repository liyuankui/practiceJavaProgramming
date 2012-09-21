package lyk.practice;

import lyk.practice.datastructure.LinkedList;
import lyk.practice.datastructure.LinkedNode;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 9/21/12
 * Time: 2:15 PM
 * The OutputNpowerN class is intended to fulfil some duties.
 */
public class OutputNpowerN {


    static void generateNpowerN(String str){
        // remove duplicate

        char[] chars=str.toCharArray();
        //sort
        Arrays.sort(chars);
        int n = chars.length;
        int [] ptrs= new int[n+1];
        while(ptrs[0]!=1){
            for(int i=1;i<=n;i++){
                System.out.print(chars[ptrs[i]]);
            }
            System.out.println();

            //increase
            ptrs[n]++;
            // carrying
            for(int index=n;index>0; index--){
                if(ptrs[index]==n){
                    ptrs[index]=0;
                    ptrs[index-1]++;
                }
            }
        }
    }
    public static void main(String [] args){
       String str="abcd";
       generateNpowerN(str);
    }
}
