package jp.co.worksap.recruiting;

import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: kyle lee
 * Date: 9/18/12
 * Time: 10:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class LazyExamImmutableQueueImpl<E> implements ExamImmutableQueue<E>  {

    //algebraic data type
    // father == nil <=> this is nil queue;
    //this==father.enqueue(tail);
    //this.enqueue(x)==father.enqueue(tail).enqueue(x);
    //this.dequeue()==father.dequeue().enqueue(tail); as long as father != nil;
    //this.dequeue()==father.enqueue(tail).dequeue();
    //this.peek()==father.peek() as long as father!=nil;
    //this.size()==father.size();

    private ExamImmutableQueue<E> father=null;
    //enqueue
    //private ExamImmutableQueue<E> eq;
    //dequeue
    private ExamImmutableQueue<E> dq=null;
    private E tail=null;
    private E head=null;
    private int size=0;
    private int hash=-1;

    // runtime environment
    static Hashtable<Integer,ExamImmutableQueue> re=new Hashtable<Integer, ExamImmutableQueue>(100000,0.5f);

    // the static unique nil queue
    public static ExamImmutableQueue nil;
    //= new LazyExamImmutableQueueImpl(null,null,null,0,890321,re);

    public LazyExamImmutableQueueImpl() {
        //initialize runtime environment
        this(null,null,null,0,890321,re);
        if(nil==null) nil=this;
        System.out.println("in constructor, nil hash = "+nil.hashCode());
        System.out.println("in constructor, this hash = " + this.hashCode());

        //this.=(LazyExamImmutableQueueImpl<E>)nil;
    }


    //with hashcode for nil
    public LazyExamImmutableQueueImpl(ExamImmutableQueue<E> _father, E _tail, E _head, int _size, int _hash, Hashtable<Integer, ExamImmutableQueue> _re){
        father=_father;
        tail=_tail;
        head=_head;
        size=_size;
        hash =_hash;
        re=_re;
        re.put(this.hashCode(),this);
        //System.out.println(this.hashCode());
    }

    //generate a new queue with the father and tail, save it to hash table
    public LazyExamImmutableQueueImpl(ExamImmutableQueue<E> _father, E _tail, E _head, int _size, Hashtable<Integer, ExamImmutableQueue> _re){
        father=_father;
        tail=_tail;
        head=_head;
        size=_size;
        re=_re;
        calculateDQ();
        re.put(this.hashCode(),this);
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
        if(e==null)
            throw new IllegalArgumentException("Illegal argument! Sorry, but you can not enqueue this null element: "+ e);

        // query if there exists the queue
        ExamImmutableQueue<E> q=re.get(hashCombine(this.hashCode(),e.hashCode()));
        if(q==null){
            if(this==nil)
                // the first element in a queue is both the head and the tail
                q=new LazyExamImmutableQueueImpl<E>(this, e, e, size+1, re);
            else
                q=new LazyExamImmutableQueueImpl<E>(this, e, head, size+1, re);
        }
        return q;
    }

    private  void calculateDQ(){
        if(father==null){
            //nil queue
            dq=null;
        }else if(father.equals(nil)){
            //direct son of nil queue
            dq=nil;
        }else{
            dq=father.dequeue().enqueue(tail);
        }
    }
    /**
     * @return
     * @throws java.util.NoSuchElementException
     *
     */
    @Override
    public ExamImmutableQueue<E> dequeue() {
        if(size==0)
            throw new NoSuchElementException("No Such Element! Sorry, but the queue is empty, you can not dequeue it.");
        if(dq==null)
            calculateDQ();
        return dq;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * @return
     * @throws java.util.NoSuchElementException
     *
     */
    @Override
    public E peek() {
        if(size==0)
            throw new NoSuchElementException("No Such Element! Sorry, but the queue is empty, you can not peek it.");
        return head;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return size;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int hashCode(){
        if(this.hash == -1){
		    this.hash = hashCombine(father.hashCode(), tail.hashCode());
		}
	    return hash;
    }

    // combine hash code of father queue and tail element to determine a queue
    private int hashCombine(int seed, int hash){
	    //a la boost
	    seed ^= hash + 0x9e3779b9 + (seed << 6) + (seed >> 2);
	    return seed;
    }


    public static void time(){
        long currentTime = System.currentTimeMillis();

        LazyExamImmutableQueueImpl<Integer> exam = new LazyExamImmutableQueueImpl<Integer>();

        for (int i = 0; i < 100000; i++) {
            exam = (LazyExamImmutableQueueImpl<Integer>) exam.enqueue(i);
        }

        for (int i = 0; i < 1000; i++) {
            //exam = (LazyExamImmutableQueueImpl<Integer>) exam.dequeue();
        }

        System.out.println("Time Cost: " + (System.currentTimeMillis() - currentTime));

    }

    public static void trace(){

        LazyExamImmutableQueueImpl<String> s=new LazyExamImmutableQueueImpl<String>();
        String e;
        e="fdafad"+new Random().nextLong();
        String tmp=e;
        System.out.println("EQ "+e);
        s=(LazyExamImmutableQueueImpl<String>)s.enqueue(e);
        System.out.println("After 1 EQ S hash: "+s.hashCode());
        e="fdafad"+new Random().nextLong();
        System.out.println("EQ "+e);
        s=(LazyExamImmutableQueueImpl<String>)s.enqueue(e);
        System.out.println("After 2 EQ S hash: "+s.hashCode());
        e="fdafad"+new Random().nextLong();
        System.out.println("EQ "+e);
        s=(LazyExamImmutableQueueImpl<String>)s.enqueue(e);
        System.out.println("After 3 EQ S hash: "+s.hashCode());
        e="fdafad"+new Random().nextLong();
        System.out.println("EQ "+e);
        s=(LazyExamImmutableQueueImpl<String>)s.enqueue(e);
        System.out.println("After 4 EQ S hash: "+s.hashCode());


        e=s.peek();
        System.out.println("DQ "+e);
        s=(LazyExamImmutableQueueImpl<String>)s.dequeue();
        System.out.println("After 1 DQ S hash: "+s.hashCode());
        e=s.peek();
        System.out.println("DQ "+e);
        s=(LazyExamImmutableQueueImpl<String>)s.dequeue();
        System.out.println("After 2 DQ S hash: "+s.hashCode());
        e=s.peek();
        System.out.println("DQ "+e);
        s=(LazyExamImmutableQueueImpl<String>)s.dequeue();
        System.out.println("After 3 DQ S hash: "+s.hashCode());
        e=s.peek();
        System.out.println("DQ "+e);
        s=(LazyExamImmutableQueueImpl<String>)s.dequeue();
        System.out.println("After 4 DQ S hash: "+s.hashCode());

        System.out.println("RE EQ "+tmp);
        s=(LazyExamImmutableQueueImpl<String>)s.enqueue(tmp);
        System.out.println("After RE EQ S hash: "+s.hashCode());


    }
    public static void main(String[] args){

        time();
        return;
    }
}
