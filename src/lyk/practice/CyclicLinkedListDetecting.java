package lyk.practice;

import lyk.practice.datastructure.LinkedList;
import lyk.practice.datastructure.LinkedNode;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 9/21/12
 * Time: 1:45 PM
 * The CyclicLinkedListDetecting class is intended to fulfil some duties.
 */
public class CyclicLinkedListDetecting {

    public static LinkedNode FindCyclic(LinkedNode head){
        LinkedNode one=head;
        LinkedNode two=head;
        while(one!=null){
            one=one.next;
            two=two.next.next;
            if(one==two)  break;
        }
        one=head;
        while(one!=null){
            one=one.next;
            two=two.next;
            if(one==two)return one;
        }
        return one;
    }
    public static void main(String[] args){
        LinkedList<String> list= new LinkedList<String>();
        list.append("DS");
        list.append("OS");
        LinkedNode DB=list.append("DB");
        list.append("CS");
        list.append("SA");
        list.append("SQ");
        list.setCyclic(DB);

        System.out.println(FindCyclic(list.head).value);
    }
}
