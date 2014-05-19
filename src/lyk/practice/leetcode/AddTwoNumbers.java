package lyk.practice.leetcode;

import lyk.practice.Util;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by stms130809 on 14-5-12.
 * http://oj.leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public static void main (String[] args) throws java.lang.Exception {

        test(makeNode(BigInteger.valueOf(9l)),makeNode(BigInteger.valueOf(9999999991l)));
        test(makeNode(BigInteger.valueOf(0l)),makeNode(BigInteger.valueOf(0l)));
        test(makeNode(BigInteger.valueOf(5l)),makeNode(BigInteger.valueOf(5l)));
    }
    public static ListNode makeNode(BigInteger t){
        if(t.compareTo(BigInteger.ZERO)<0) return null;
        ListNode ret = new ListNode(-1);
        ListNode tmp = ret;
        while(t.compareTo(BigInteger.TEN)>=0){
            tmp.val=t.mod(BigInteger.TEN).intValue();
            tmp.next=new ListNode(-1);
            tmp=tmp.next;
            t=t.divide(BigInteger.TEN);
        }
        tmp.val=t.intValue();
        tmp.next=null;
        return ret;
    }

    public static BigInteger getNumber(ListNode n){
        BigInteger ret =BigInteger.ZERO;
        if(n!=null){
            Stack<Integer> q= new Stack<Integer>();
            while(n!=null){
                q.add(Integer.valueOf(n.val));
                n=n.next;
            }
            while(!q.empty()){
                ret=ret.multiply(BigInteger.TEN);
                ret=ret.add(BigInteger.valueOf(q.pop().intValue()));
            }
        }
        return ret;
    }

    public static void test(ListNode t1, ListNode t2){
        ListNode.dumpListNode(addTwoNumbers(t1,t2));
        ListNode.dumpListNode(cleverAddTwoNumbers(t1,t2));
    }

    public static ListNode cleverAddTwoNumbers(ListNode l1, ListNode l2){
        return makeNode(getNumber(l1).add(getNumber(l2)));
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null) return null;
        ListNode t1=l1;
        ListNode t2=l2;
        ListNode ret;
        ret=new ListNode(-1);
        ret.next=null;
        ListNode t3=ret;
        ListNode prev=null;
        boolean hasCarrier=false;
        while(t1!=null&&t2!=null){
            int value = t1.val+t2.val;
            if(hasCarrier){
                value+=1;
                hasCarrier=false;
            }
            if(value>9){
                hasCarrier=true;
            }
            t3.val=value%10;
            t1=t1.next;
            t2=t2.next;
            prev=t3;
            t3.next=new ListNode(-1);
            t3=t3.next;
        }
        ListNode rest=null;
        if(t1!=null){
            rest=t1;
        }else{
            rest=t2;
        }
        while(rest!=null){
            int value = rest.val;
            if(hasCarrier){
                value+=1;
                hasCarrier=false;
            }
            if(value>9){
                hasCarrier=true;
            }
            prev=t3;
            t3.val=value%10;
            t3.next=new ListNode(-1);
            t3=t3.next;
            rest=rest.next;
        }
        if(hasCarrier){
            prev.next= new ListNode(1);
        } else {
            prev.next=null;
        }
        return ret;
    }
}
