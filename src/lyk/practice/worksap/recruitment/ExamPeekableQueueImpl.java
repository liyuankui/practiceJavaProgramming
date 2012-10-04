package lyk.practice.worksap.recruitment;

/**
 * Created by IntelliJ IDEA.
 * User: kyle lee
 * Date: 9/18/12
 * Time: 2:13 PM
 */
public class ExamPeekableQueueImpl<E extends Comparable<E>> implements ExamPeekableQueue<E> {

    class Node implements IndexedComparable<Node> {

        E element;
        Node next;
        boolean inLeftHeap;
        boolean inRightHeap;
        int index;

        public Node() {
            this(null, null);
        }

        public Node(E element) {
            this(element, null);
        }

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
            inLeftHeap = false;
            inRightHeap = false;
            index = -1;
        }

        @Override
        public void setIndex(int _index) {
            this.index = _index;
        }

        @Override
        public int compareTo(Node node) {
            return this.element.compareTo(node.element);
        }
    }


    MinMaxHeap<Node> leftHeap, rightHeap;
    Node head, tail, median;

    public ExamPeekableQueueImpl() {
        leftHeap = new MinMaxHeap<Node>();
        rightHeap = new MinMaxHeap<Node>();
        head = null;
        tail = null;
        median = null;
    }


    /**
     * append item to the tail of the queue
     *
     * @param e
     * @throws IllegalArgumentException
     */
    @Override
    public void enqueue(E e) {
        if (e == null)
            throw new IllegalArgumentException("Sorry, but you can not enqueue a null element.");
        Node node = new Node(e);
        if (tail == null && head == null) {
            tail = node;
            head = tail;
            median = tail;
        } else {
            tail.next = node;
            tail = tail.next;
            // larger
            if (node.compareTo(median) > 0) {
                if (leftHeap.size() > rightHeap.size()) {
                    node.inRightHeap = true;
                    rightHeap.add(node);
                } else {
                    median.inLeftHeap = true;
                    leftHeap.add(median);

                    Node rightMinNode = rightHeap.peekMin();
                    if (rightMinNode.compareTo(node) < 0) {
                        rightMinNode.inRightHeap = false;
                        median = rightMinNode;

                        node.inRightHeap = true;
                        rightHeap.replace(median.index, node);

                        median.index = -1;
                    } else {
                        median = node;
                    }
                }
            } else if (node.compareTo(median) < 0) {
                if (leftHeap.size() > rightHeap.size()) {
                    median.inRightHeap = true;
                    rightHeap.add(median);

                    Node leftMaxNode = leftHeap.peekMax();
                    if (leftMaxNode.compareTo(node) > 0) {
                        leftMaxNode.inLeftHeap = false;
                        median = leftMaxNode;

                        node.inLeftHeap = true;
                        leftHeap.replace(median.index, node);

                        median.index = -1;
                    } else {
                        median = node;
                    }
                } else {
                    node.inLeftHeap = true;
                    leftHeap.add(node);
                }
            } else {
                if (leftHeap.size() > rightHeap.size()) {
                    node.inRightHeap = true;
                    rightHeap.add(node);
                } else {
                    node.inLeftHeap = true;
                    leftHeap.add(node);
                }
            }
        }
    }

    /**
     * remove head
     *
     * @return
     * @throws java.util.NoSuchElementException
     *
     */
    @Override
    public E dequeue() {
        if (head == null) {
            throw new java.util.NoSuchElementException("Sorry, but this queue is empty.");
        } else if (head == tail) {
            Node node = head;
            tail = null;
            head = null;
            median = null;
            return node.element;
        }

        if (head.inLeftHeap) {
            leftHeap.delete(head.index);
            if (leftHeap.size() < rightHeap.size()) {
                leftHeap.add(median);
                median.inLeftHeap = true;

                Node rightMinNode = rightHeap.peekMin();
                rightHeap.delete(rightMinNode.index);

                median = rightMinNode;
                median.inRightHeap = false;
                median.index = -1;
            }
        } else if (head.inRightHeap) {
            rightHeap.delete(head.index);
            if (leftHeap.size() > rightHeap.size() + 1) {
                rightHeap.add(median);
                median.inRightHeap = true;

                Node leftMaxNode = leftHeap.peekMax();
                leftHeap.delete(leftMaxNode.index);

                median = leftMaxNode;
                median.inLeftHeap = false;
                median.index = -1;
            }
        } else {
            if (leftHeap.size() > rightHeap.size()) {
                Node leftMaxNode = leftHeap.peekMax();
                leftHeap.delete(leftMaxNode.index);

                median = leftMaxNode;
                median.inLeftHeap = false;
                median.index = -1;
            } else {
                Node rightMinNode = rightHeap.peekMin();
                rightHeap.delete(rightMinNode.index);

                median = rightMinNode;
                median.inRightHeap = false;
                median.index = -1;
            }

        }


        E temp = head.element;
        head = head.next;
        return temp;

    }

    /**
     * the median value (bigger one if even number)
     *
     * @return
     * @throws java.util.NoSuchElementException
     *
     */
    @Override
    public E peekMedian() {
        if (median == null) {
            throw new java.util.NoSuchElementException("Sorry, but this is empty.");
        }
        return median.element;
    }

    /**
     * max value
     *
     * @return
     * @throws java.util.NoSuchElementException
     *
     */
    @Override
    public E peekMaximum() {
        if (median == null) {
            throw new java.util.NoSuchElementException("Sorry, but this is empty.");
        } else if (rightHeap.size() == 0) {
            return median.element;
        } else {
            return rightHeap.peekMax().element;
        }
    }

    /**
     * min value
     *
     * @return
     * @throws java.util.NoSuchElementException
     *
     */
    @Override
    public E peekMinimum() {
        if (median == null) {
            throw new java.util.NoSuchElementException("Sorry, but this is empty.");
        } else if (leftHeap.size() == 0) {
            return median.element;
        } else {
            return leftHeap.peekMin().element;
        }
    }

    /**
     * size
     *
     * @return
     */
    @Override
    public int size() {
        return leftHeap.size() + rightHeap.size() + 1;
    }

}
