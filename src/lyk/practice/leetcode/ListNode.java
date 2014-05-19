package lyk.practice.leetcode;

/**
 * Created by stms130809 on 14-5-12.
 *
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    public static void dumpListNode(ListNode d){
        if(d!=null){
            System.out.print(d.val);
            d=d.next;
            while(d!=null){
                System.out.print("->"+d.val);
                d=d.next;
            }
            System.out.println();
        }
    }
}
