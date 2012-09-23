package lyk.practice;

import lyk.practice.datastructure.BinarySearchTreeNode;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 9/21/12
 * Time: 4:21 PM
 * The OrderBST class is intended to fulfil some duties.
 */
public class OrderBST {
    public static void main(String[] args) {
        BinarySearchTreeNode<Integer> bst = new BinarySearchTreeNode<Integer>();
        bst.insert(10);
        bst.insert(20);
        bst.insert(50);
        bst.insert(80);
        bst.insert(40);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(70);
        bst.insert(80);
        bst.insert(30);
        bst.middleOrderTraverseOutput();
    }
}
