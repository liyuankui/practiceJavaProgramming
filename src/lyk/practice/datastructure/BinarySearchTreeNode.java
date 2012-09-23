package lyk.practice.datastructure;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 9/21/12
 * Time: 2:57 PM
 * The BinarySearchTreeNode class is intended to fulfil some duties.
 */
public class BinarySearchTreeNode<E extends Comparable<E>> {


    E value;
    BinarySearchTreeNode<E> left;
    BinarySearchTreeNode<E> right;

    public BinarySearchTreeNode() {
        value = null;
        left = right = null;
    }

    public BinarySearchTreeNode(E v) {
        left = null;
        right = null;
        value = v;
    }

    public void middleOrderTraverseOutput() {
        middleOrderTraverseOutput(this);
    }

    public void middleOrderTraverseOutput(BinarySearchTreeNode<E> n) {
        if (n == null) return;
        middleOrderTraverseOutput(n.left);
        System.out.println(n.value);
        middleOrderTraverseOutput(n.right);
    }

    public BinarySearchTreeNode<E> insert(E v) {
        if (value == null) {
            value = v;
            return this;
        }
        int result = v.compareTo(value);
        BinarySearchTreeNode<E> insertPosition = null;
        if (result == 0) {
            return this;
        } else if (result > 0) {
            insertPosition = insertRightChild(v);
        } else if (result < 0) {
            insertPosition = insertLeftChild(v);
        }
        return insertPosition;

    }

    public BinarySearchTreeNode<E> insertLeftChild(E value) {
        if (left == null) {
            left = new BinarySearchTreeNode<E>(value);
            return left;
        } else {
            return left.insert(value);
        }

    }

    public BinarySearchTreeNode<E> insertRightChild(E value) {
        if (right == null) {
            right = new BinarySearchTreeNode<E>(value);
            return right;
        } else {
            return right.insert(value);
        }
    }


}
