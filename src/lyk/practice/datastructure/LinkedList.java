package lyk.practice.datastructure;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 9/21/12
 * Time: 1:01 PM
 * The LinkedList class is intended to fulfil some duties.
 */

public class LinkedList<E> {
    public LinkedNode<E> head=null;
    private LinkedNode<E> tail=null;

    private int count=0;

    public LinkedList(){

    }

    public LinkedNode<E> append(E value){
        if(tail==null){
            head = new LinkedNode<E>();
            tail = head;
        }else{
            tail.next= new LinkedNode<E>();
            tail=tail.next;
        }
        tail.value=value;
        tail.next=null;
        count++;
        return tail;
    }


    public void setCyclic(LinkedNode<E> to){
        if(tail==null) return;
        tail.next=to;
    }

    public LinkedNode<E>[] nodes(){
        LinkedNode<E> [] nodesArray=new LinkedNode[count];
        int i =0;
        LinkedNode<E> ptr;
        for(ptr=head; ptr!=null; ptr=ptr.next){
            nodesArray[i++]=ptr;
        }
        return nodesArray;
    }
}

