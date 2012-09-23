package lyk.practice.datastructure;

import java.util.NoSuchElementException;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 9/23/12
 * Time: 3:05 PM
 * The ImmutableStack class is intended to fulfil some duties.
 */
public class ImmutableStack<T> {
    //    private static ImmutableStack empty;
    private StackNode<T> top = null;
    private int size = 0;

    public ImmutableStack() {
        top = null;
        size = 0;
    }

    public ImmutableStack(StackNode<T> t, int s) {
        top = t;
        size = s;
    }

    public ImmutableStack<T> push(T v) {
        if (v == null)
            throw new java.lang.IllegalArgumentException("Sorry, but don't push null element");
        StackNode<T> node = new StackNode<T>(v, top);
        return new ImmutableStack<T>(node, size + 1);
    }

    public ImmutableStack<T> pop() {
        if (top == null)
            throw new NoSuchElementException("Empty stack");
        return new ImmutableStack<T>(top.next, size - 1);
    }

    public ImmutableStack<T> reverse() {
        ImmutableStack<T> reversed = new ImmutableStack<T>();
        System.out.println("reversing a stack sized " + this.size());
        for (ImmutableStack<T> tmp = this; tmp.size() > 0; tmp = tmp.pop())
            reversed = reversed.push(tmp.top());
        return reversed;
    }

    public T top() {
        if (top == null)
            throw new NoSuchElementException("Empty stack");
        return top.value;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ImmutableStack<String> stack = new ImmutableStack<String>();
        System.out.println(stack.push("DS").push("GSF").push("Man").top());
        ImmutableStack<String> x = stack.push("DS").pop();
        System.out.println(x.size());
    }
}

class StackNode<T> {
    T value;
    StackNode<T> next;

    public StackNode(T v) {
        value = v;
    }

    public StackNode(T v, StackNode<T> n) {
        value = v;
        next = n;
    }
}
