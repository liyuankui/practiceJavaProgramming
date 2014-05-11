package jp.co.worksap.recruiting;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 9/17/12
 * Time: 4:01 PM
 * The ExamImmutableQueue interface defines immutable property.
 */
public interface ExamImmutableQueue<E> {
    /**
     *  add element to tail
     * @param e
     * @return 
     * @throws java.lang.IllegalArgumentException
     */
    public ExamImmutableQueue <E> enqueue(E e);

    /**
     * 
     * @return
     * @throws java.util.NoSuchElementException
     */
    public ExamImmutableQueue <E> dequeue();

    /**
     *
     * @return
     * @throws java.util.NoSuchElementException
     */
    public E peek();

    /**
     *
     * @return
     */
    public int size();
}
