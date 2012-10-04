package lyk.practice.worksap.recruitment;

/**
 * Created by IntelliJ IDEA.
 * User: kyle lee
 * Date: 9/17/12
 * Time: 3:57 PM
 */
public interface ExamPeekableQueue<E extends Comparable<E>> {

    /**
     * append item to the tail of the queue
     *
     * @param e
     * @throws IllegalArgumentException
     */
    public void enqueue(E e);

    /**
     * remove head
     *
     * @return
     * @throws java.util.NoSuchElementException
     *
     */
    public E dequeue();

    /**
     * the median value (bigger one if even number)
     *
     * @return
     * @throws java.util.NoSuchElementException
     *
     */
    public E peekMedian();

    /**
     * max value
     *
     * @return
     * @throws java.util.NoSuchElementException
     *
     */
    public E peekMaximum();

    /**
     * min value
     *
     * @return
     * @throws java.util.NoSuchElementException
     *
     */
    public E peekMinimum();

    /**
     * size
     *
     * @return
     */
    public int size();
}
