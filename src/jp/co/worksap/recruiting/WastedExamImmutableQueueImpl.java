package jp.co.worksap.recruiting;

import java.util.LinkedList;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 9/17/12
 * Time: 4:37 PM
 * The WastedExamImmutableQueueImpl<E> class is intended to fulfil some duties.
 */
public class WastedExamImmutableQueueImpl<E> implements ExamImmutableQueue<E>{

//    private static E[] vernier;
//    private int tail;
//    private int head;
//    protected static Hashtable storage= new Hashtable(50, 0.5f);
//    private ExamImmutableQueue<E> father=null;
//    private E tail=null;
//    private E head=null;
//    private int size=0;


//*
    int size=0;
    int head=-1;
    private Vector<E> out;
    private LinkedList<E> in;


    //final public static ExamImmutableQueue<E> EMPTY = new WastedExamImmutableQueueImpl<E> (0, -1, null, null);

    @SuppressWarnings("unchecked")
    public WastedExamImmutableQueueImpl(int _size, int _head, Vector<E> _out, LinkedList<E> _in){
        out = _out;
        in = _in;
        size = _size;
        head = _head;
    }



    public WastedExamImmutableQueueImpl(int initialCapacity){

    }
    
    public WastedExamImmutableQueueImpl(int initialCapacity, int capacityIncrement){
        if (initialCapacity<0)
            throw new java.lang.IllegalArgumentException("Illegal initial capacity: "+initialCapacity);
        //tail=null;
        //head=null;
    }
    /**
     * add element to tail
     *
     * @param e
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public ExamImmutableQueue<E> enqueue(E e) {
        if(out==null){
            out.add(e);
            size++;
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * @return
     * @throws java.util.NoSuchElementException
     *
     */
    @Override
    public ExamImmutableQueue<E> dequeue() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * @return
     * @throws java.util.NoSuchElementException
     *
     */
    @Override
    public E peek() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
