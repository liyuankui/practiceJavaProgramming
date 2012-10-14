package lyk.practice.datastructure;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 9/21/12
 * Time: 1:50 PM
 * The LinkedNode class is intended to fulfil some duties.
 */
public class LinkedNode<E> {
    public E value;
    public LinkedNode<E> next = null;

    public LinkedNode() {

    }

    public LinkedNode(E v) {
        this.value = v;
    }
}
