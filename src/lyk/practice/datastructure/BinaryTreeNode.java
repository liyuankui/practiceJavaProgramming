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
    BinaryTreeNode<E> left=null;
    BinaryTreeNode<E> right=null;

    public BinaryTreeNode<E> leftChild(E value){
        if(left==null) {
        }else{
            left=new BinaryTreeNode<E>();
        }
        left.value=value;
        return left;
    }

    public BinaryTreeNode<E> rightChild(E value){
        if(right==null) {
        }else{
            right=new BinaryTreeNode<E>();
        }
        right.value=value;
        return right;
    }
}
