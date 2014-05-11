package jp.co.worksap.recruiting;

import java.util.NoSuchElementException;

/**
 * Created by IntelliJ IDEA.
 * User: kyle lee
 * Date: 9/17/12
 * Time: 2:19 PM
 */
public class ExamImmutableQueueImpl<E> implements ExamImmutableQueue<E>{


    private class LinkedNode<E>{
        public E element;
        public LinkedNode<E> next;

        public LinkedNode(E element, LinkedNode<E> next){
            this.element=element;
            this.next=next;
        }
    }

    private LinkedNode<E> head;
    private LinkedNode<E> tail;
    private LinkedNode<LinkedNode<E>> tree;

    public ExamImmutableQueueImpl(){
        // nil queue
        this(null);
    }

    public ExamImmutableQueueImpl(LinkedNode<E> e){
        // single element queue
        this(e, e, null);
    }

    public ExamImmutableQueueImpl( LinkedNode<E> _head, LinkedNode<E> _tail,LinkedNode<LinkedNode<E>> _tree){
        // new tree
        head=_head;
        tail=_tail;
        tree=_tree;
    }
    /**
     * add element to head
     *
     * @param e
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public ExamImmutableQueue<E> enqueue(E e) {
        if(e==null)
            throw new IllegalArgumentException("Illegal argument! Sorry, but you can not enqueue this null element: "+ e);
        LinkedNode<E> node= new LinkedNode<E>(e, tail);
        if(head==null)
            //nil
            return new ExamImmutableQueueImpl(node);
        else
            return new ExamImmutableQueueImpl(head,node,null);
    }

    /**
     * @return
     * @throws java.util.NoSuchElementException
     *
     */
    @Override
    public ExamImmutableQueue<E> dequeue() {
        ExamImmutableQueueImpl<E> q;
        if(head==null){
            //empty queue
            throw new NoSuchElementException("No Such Element! Sorry, but the queue is empty, you can not dequeue it.");
        }else if(head==tail){
            //there was only one element, so just return a nil queue
            q=new ExamImmutableQueueImpl();
        }else {
            // dequeue
            LinkedNode<LinkedNode<E>> newtree = this.tree;
            if(newtree==null){
                // the tree doesn't exist, we copy to create it
                LinkedNode<E> link;
                for(link = tail;link != head;link=link.next){
                    newtree = new LinkedNode<LinkedNode<E>>(link,newtree);
                }
            }
            q= new ExamImmutableQueueImpl(newtree.element,tail, newtree.next);
        }
        return q;
    }

    /**
     * @return
     * @throws java.util.NoSuchElementException
     *
     */
    @Override
    public E peek() {
        if(head==null)
            throw new NoSuchElementException("No Such Element! Sorry, but the queue is empty, you can not peek it.");
        return head.element;
    }

    /**
     * @return
     */
    @Override
    public int size() {
        if(head==null) return 0;
        int size=1;
        for (LinkedNode<E> link = tail; link != head; link = link.next) {
            ++size;
        }
        return size;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /*
    public static void time(){
        long currentTime = System.currentTimeMillis();

        ExamImmutableQueueImpl<String> s = new ExamImmutableQueueImpl<String>();

        for (int i = 0; i < 100000; i++) {
            s = (ExamImmutableQueueImpl<String>) s.enqueue("long: "+new Random().nextLong());
        }

        for (int i = 0; i < 100000; i++) {
            s = (ExamImmutableQueueImpl<String>) s.dequeue();
        }

        System.out.println("Time Cost: " + (System.currentTimeMillis() - currentTime));

    }

    public static void forks(){
        long currentTime = System.currentTimeMillis();

        ExamImmutableQueueImpl<String> s = new ExamImmutableQueueImpl<String>();

        for (int i = 0; i < 100000; i++) {
            s = (ExamImmutableQueueImpl<String>) s.enqueue("long: "+new Random().nextLong());
        }

        ExamImmutableQueueImpl<String> t = s;
        for (int i = 0; i < 100000; i++) {
            t = (ExamImmutableQueueImpl<String>) t.enqueue("long: "+new Random().nextLong());
        }

        ExamImmutableQueueImpl<String> u = s;
        for (int i = 0; i < 100000; i++) {
            u = (ExamImmutableQueueImpl<String>) u.enqueue("long: "+new Random().nextLong());
        }

        System.out.println(s.size());
        System.out.println(t.size());
        System.out.println(u.size());

        for (int i = s.size(); i > 0; i--) {
            s = (ExamImmutableQueueImpl<String>) s.dequeue();
        }

        s=t;
        for (int i = s.size(); i > 0; i--) {
            s = (ExamImmutableQueueImpl<String>) s.dequeue();
        }

        s=u;
        for (int i = s.size(); i > 0; i--) {
            s = (ExamImmutableQueueImpl<String>) s.dequeue();
        }

        System.out.println("Time Cost: " + (System.currentTimeMillis() - currentTime));

    }

    public static void trace(){

        ExamImmutableQueueImpl<String> s=new ExamImmutableQueueImpl<String>();
        String e;
        e="fdafad"+new Random().nextLong();
        String tmp=e;
        System.out.println("EQ "+e);
        s=(ExamImmutableQueueImpl<String>)s.enqueue(e);
        System.out.println("After 1 EQ S hash: "+s.hashCode());
        e="fdafad"+new Random().nextLong();
        System.out.println("EQ "+e);
        s=(ExamImmutableQueueImpl<String>)s.enqueue(e);
        System.out.println("After 2 EQ S hash: "+s.hashCode());
        e="fdafad"+new Random().nextLong();
        System.out.println("EQ "+e);
        s=(ExamImmutableQueueImpl<String>)s.enqueue(e);
        System.out.println("After 3 EQ S hash: "+s.hashCode());
        e="fdafad"+new Random().nextLong();
        System.out.println("EQ "+e);
        s=(ExamImmutableQueueImpl<String>)s.enqueue(e);
        System.out.println("After 4 EQ S hash: "+s.hashCode());


        e=s.peek();
        System.out.println("DQ "+e);
        s=(ExamImmutableQueueImpl<String>)s.dequeue();
        System.out.println("After 1 DQ S hash: "+s.hashCode());
        e=s.peek();
        System.out.println("DQ "+e);
        s=(ExamImmutableQueueImpl<String>)s.dequeue();
        System.out.println("After 2 DQ S hash: "+s.hashCode());
        e=s.peek();
        System.out.println("DQ "+e);
        s=(ExamImmutableQueueImpl<String>)s.dequeue();
        System.out.println("After 3 DQ S hash: "+s.hashCode());
        e=s.peek();
        System.out.println("DQ "+e);
        s=(ExamImmutableQueueImpl<String>)s.dequeue();
        System.out.println("After 4 DQ S hash: "+s.hashCode());

        System.out.println("RE EQ "+tmp);
        s=(ExamImmutableQueueImpl<String>)s.enqueue(tmp);
        System.out.println("After 4 DQ S size: "+s.size());
        System.out.println("After RE DQ S hash: "+s.hashCode());


    }

    public static void peekable(){
    }
    public static void main(String[] args){

        trace();
        time();
        forks();
        return;
    }
    */
}
