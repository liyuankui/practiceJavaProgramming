package lyk.practice.datastructure;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 9/21/12
 * Time: 2:56 PM
 * The BinaryTreeNode class is intended to fulfil some duties.
 */
public class BinaryTreeNode<E> {
    E value;
    BinaryTreeNode<E> left = null;
    BinaryTreeNode<E> right = null;


    public void middleOrderTraverseOutput() {
        middleOrderTraverseOutput(this);
    }

    public void middleOrderTraverseOutput(BinaryTreeNode<E> n) {
        if (n == null) return;
        middleOrderTraverseOutput(n.left);
        System.out.println(value);
        middleOrderTraverseOutput(n.right);
    }

    public E leftValue() {
        return left.value;
    }

    public E rightValue() {
        return right.value;
    }

    public BinaryTreeNode<E> leftChild() {
        if (left == null) {
            left = new BinaryTreeNode<E>();
        }
        left.value = value;
        return left;
    }

    public BinaryTreeNode<E> rightChild() {
        if (right == null) {
            right = new BinaryTreeNode<E>();
        }
        right.value = value;
        return right;
    }

    public BinaryTreeNode<E> leftChild(E value) {
        if (left == null) {
            left = new BinaryTreeNode<E>();
        }
        left.value = value;
        return left;
    }

    public BinaryTreeNode<E> rightChild(E value) {
        if (right == null) {
            right = new BinaryTreeNode<E>();
        }
        right.value = value;
        return right;
    }
}
