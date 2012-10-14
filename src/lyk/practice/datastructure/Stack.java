package lyk.practice.datastructure;

import java.util.NoSuchElementException;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/12/12
 * Time: 4:45 PM
 * The Stack class is intended to fulfil some duties.
 */
public class Stack<E> {
    LinkedNode<E> head = null;
    int size = 0;

    public Stack() {
    }

    public void push(E value) {
        LinkedNode<E> node = new LinkedNode<E>(value);
        node.next = head;
        head = node;
        size++;
    }

    public E pop() {
        if (size <= 0) throw new NoSuchElementException();
        E value = head.value;
        head = head.next;
        size--;
        return value;
    }
}
