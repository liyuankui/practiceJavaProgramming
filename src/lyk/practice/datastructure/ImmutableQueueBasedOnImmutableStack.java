package lyk.practice.datastructure;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 9/23/12
 * Time: 4:02 PM
 * The ImmutableQueueBasedOnImmutableStack class is intended to fulfil some duties.
 */
public class ImmutableQueueBasedOnImmutableStack<T> {
    private int size = 0;
    private ImmutableStack<T> forwards;
    private ImmutableStack<T> backwards;

    public ImmutableQueueBasedOnImmutableStack() {
        forwards = new ImmutableStack<T>();
        backwards = new ImmutableStack<T>();
    }

    public ImmutableQueueBasedOnImmutableStack(ImmutableStack<T> f, ImmutableStack<T> b) {
        forwards = f;
        backwards = b;
    }

    public ImmutableQueueBasedOnImmutableStack<T> enqueue(T v) {
        /*
        if(forwards.size()==0){
            //the first element
            return new ImmutableQueueBasedOnImmutableStack<T>(forwards.push(v),backwards);
        }else{
            // not the first
        */
        return new ImmutableQueueBasedOnImmutableStack<T>(forwards, backwards.push(v));
        // }

    }

    public ImmutableQueueBasedOnImmutableStack<T> dequeue() {
        if (size() == 0)
            throw new NoSuchElementException("empty queue");
        if (forwards.size() == 0) {
            return new ImmutableQueueBasedOnImmutableStack<T>(backwards.reverse().pop(), forwards);
        } else {
            return new ImmutableQueueBasedOnImmutableStack<T>(forwards.pop(), backwards);
        }

    }

    public T peek() {
        if (this.size() == 0)
            throw new NoSuchElementException("empty queue");
        if (forwards.size() == 0) {
            forwards = backwards.reverse();
            backwards = new ImmutableStack<T>();
        }
        return forwards.top();
    }

    public int size() {
        return backwards.size() + forwards.size();
    }

    public static void main(String[] args) {
        ImmutableQueueBasedOnImmutableStack<String> q = new ImmutableQueueBasedOnImmutableStack<String>();
        for (int i = 0; i < 100000; i++) {
            String v = "f: " + new Random().nextLong();
            if (i > 0 && i < 5) System.out.println(v);
            q = q.enqueue(v);
        }
        System.out.println(q.size());
        for (int i = 0; i < 100000; i++) {
            if (i > 0 && i < 5) System.out.println(q.peek());
            q = q.dequeue();
        }

        System.out.println(q.size());

    }
}

