package lyk.practice.worksap.recruitment;


import java.util.ArrayList;

public class MinMaxHeap<E extends IndexedComparable<E>> {
    // min at root and at even levels; max at odd levels
    ArrayList<E> heap;

    public MinMaxHeap() {
        heap = new ArrayList<E>();
    }


    /**
     * Returns the maximum element in the heap,
     * or null if it is empty.
     *
     * @return The largest element in the heap.
     */
    public E peekMax() {
        if (heap.size() == 0) {
            return null;
        } else if (heap.size() == 1) {
            return heap.get(0);
        } else if (heap.size() == 2) {
            return heap.get(1);
        } else {
            if (heap.get(1).compareTo(heap.get(2)) > 0) {
                return heap.get(1);
            } else {
                return heap.get(2);
            }
        }
    }


    /**
     * Returns the minimum element in the heap,
     * or null if it is empty.
     *
     * @return The smallest element in the heap.
     */
    public E peekMin() {
        return (heap.size() == 0) ? null : heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public void add(E e) {
        heap.add(e);
        e.setIndex(heap.size() - 1);
        bubbleUp(heap.size() - 1);
    }

    void bubbleUp(int nodeIndex) {
        if (!hasParent(nodeIndex)) {
            return;
        }

        int parentIndex = parentIndex(nodeIndex);

        if (onMinLevel(nodeIndex)) {
            if (heap.get(nodeIndex).compareTo(heap.get(parentIndex)) > 0) {
                swap(nodeIndex, parentIndex);
                bubbleUpMax(parentIndex);
            } else {
                bubbleUpMin(nodeIndex);
            }
        } else {  // on max level
            if (heap.get(nodeIndex).compareTo(heap.get(parentIndex)) < 0) {
                swap(nodeIndex, parentIndex);
                bubbleUpMin(parentIndex);
            } else {
                bubbleUpMax(nodeIndex);
            }
        }
    }

    void bubbleUpMin(int nodeIndex) {
        while (true) {
            if (!hasParent(nodeIndex)) {
                return;
            }

            int parentIndex = parentIndex(nodeIndex);
            if (!hasParent(parentIndex)) {
                return;
            }

            int grandparentIndex = parentIndex(parentIndex);
            if (heap.get(nodeIndex).compareTo(heap.get(grandparentIndex)) < 0) {
                swap(nodeIndex, grandparentIndex);
                nodeIndex = grandparentIndex;
            } else {
                return;
            }
        }
    }

    void bubbleUpMax(int nodeIndex) {
        while (true) {
            if (!hasParent(nodeIndex)) {
                return;
            }

            int parentIndex = parentIndex(nodeIndex);
            if (!hasParent(parentIndex)) {
                return;
            }

            int grandparentIndex = parentIndex(parentIndex);
            if (heap.get(nodeIndex).compareTo(heap.get(grandparentIndex)) > 0) {
                swap(nodeIndex, grandparentIndex);
                nodeIndex = grandparentIndex;
            } else {
                return;
            }
        }
    }

    void delete(int nodeIndex) {
        if (nodeIndex >= heap.size()) {
            return;
        }

        heap.set(nodeIndex, heap.get(heap.size() - 1));
        heap.get(nodeIndex).setIndex(nodeIndex);
        heap.remove(heap.size() - 1);

        if (onMinLevel(nodeIndex)) {
            trickleDownMin(nodeIndex);
        } else {  // on max level
            trickleDownMax(nodeIndex);
        }
    }

    void replace(int nodeIndex, E node) {
        if (nodeIndex >= heap.size()) {
            return;
        }

        heap.set(nodeIndex, node);
        heap.get(nodeIndex).setIndex(nodeIndex);

        if (onMinLevel(nodeIndex)) {
            trickleDownMin(nodeIndex);
        } else {  // on max level
            trickleDownMax(nodeIndex);
        }
    }


    void trickleDownMin(int nodeIndex) {
        while (leftChildIndex(nodeIndex) < heap.size()) {
            int minDescIndex = minChildOrGrandChildIndex(nodeIndex);
            if (isChild(nodeIndex, minDescIndex)) {
                if (heap.get(minDescIndex).compareTo(heap.get(nodeIndex)) < 0) {
                    swap(minDescIndex, nodeIndex);
                }
                return;
            } else {  // is grand child
                if (heap.get(minDescIndex).compareTo(heap.get(nodeIndex)) < 0) {
                    swap(minDescIndex, nodeIndex);
                    int parentIndex = parentIndex(minDescIndex);
                    if (heap.get(minDescIndex).compareTo(heap.get(parentIndex)) > 0) {
                        swap(minDescIndex, parentIndex);
                    }
                    nodeIndex = minDescIndex; // recursive call
                }
                return;
            }
        }
    }


    // requires nodeIndex to have a child
    int minChildOrGrandChildIndex(int nodeIndex) {
        // start with left child
        int leftChildIndex = leftChildIndex(nodeIndex);
        int minIndex = leftChildIndex;

        // compare to the right child
        int rightChildIndex = rightChildIndex(nodeIndex);
        if (rightChildIndex >= heap.size()) {
            return minIndex;
        }
        if (heap.get(rightChildIndex).compareTo(heap.get(minIndex)) < 0) {
            minIndex = rightChildIndex;
        }


        // compare to the first grandchild
        int grandChild1Index = leftChildIndex(leftChildIndex);
        if (grandChild1Index >= heap.size()) {
            return minIndex;
        }
        if (heap.get(grandChild1Index).compareTo(heap.get(minIndex)) < 0) {
            minIndex = grandChild1Index;
        }

        // compare to the second grandchild
        int grandChild2Index = rightChildIndex(leftChildIndex);
        if (grandChild2Index >= heap.size()) {
            return minIndex;
        }
        if (heap.get(grandChild2Index).compareTo(heap.get(minIndex)) < 0) {
            minIndex = grandChild2Index;
        }

        // compare to the third grandchild
        int grandChild3Index = leftChildIndex(rightChildIndex);
        if (grandChild3Index >= heap.size()) {
            return minIndex;
        }
        if (heap.get(grandChild3Index).compareTo(heap.get(minIndex)) < 0) {
            minIndex = grandChild3Index;
        }

        // compare to the fourth grandchild
        int grandChild4Index = rightChildIndex(rightChildIndex);
        if (grandChild4Index >= heap.size()) {
            return minIndex;
        }
        if (heap.get(grandChild4Index).compareTo(heap.get(minIndex)) < 0) {
            minIndex = grandChild4Index;
        }

        return minIndex;
    }


    void trickleDownMax(int nodeIndex) {
        while (leftChildIndex(nodeIndex) < heap.size()) {
            int maxDescIndex = maxChildOrGrandChildIndex(nodeIndex);
            if (isChild(nodeIndex, maxDescIndex)) {
                if (heap.get(maxDescIndex).compareTo(heap.get(nodeIndex)) > 0) {
                    swap(maxDescIndex, nodeIndex);
                }
                return;
            } else {  // is grand child
                if (heap.get(maxDescIndex).compareTo(heap.get(nodeIndex)) > 0) {
                    swap(maxDescIndex, nodeIndex);
                    int parentIndex = parentIndex(maxDescIndex);
                    if (heap.get(maxDescIndex).compareTo(heap.get(parentIndex)) < 0) {
                        swap(maxDescIndex, parentIndex);
                    }
                    nodeIndex = maxDescIndex; // recursive call
                }
                return;
            }
        }
    }


    // requires nodeIndex to have a child
    int maxChildOrGrandChildIndex(int nodeIndex) {
        // start with left child
        int leftChildIndex = leftChildIndex(nodeIndex);
        int maxIndex = leftChildIndex;

        // compare to the right child
        int rightChildIndex = rightChildIndex(nodeIndex);
        if (rightChildIndex >= heap.size()) {
            return maxIndex;
        }
        if (heap.get(rightChildIndex).compareTo(heap.get(maxIndex)) > 0) {
            maxIndex = rightChildIndex;
        }


        // compare to the first grandchild
        int grandChild1Index = leftChildIndex(leftChildIndex);
        if (grandChild1Index >= heap.size()) {
            return maxIndex;
        }
        if (heap.get(grandChild1Index).compareTo(heap.get(maxIndex)) > 0) {
            maxIndex = grandChild1Index;
        }

        // compare to the second grandchild
        int grandChild2Index = rightChildIndex(leftChildIndex);
        if (grandChild2Index >= heap.size()) {
            return maxIndex;
        }
        if (heap.get(grandChild2Index).compareTo(heap.get(maxIndex)) > 0) {
            maxIndex = grandChild2Index;
        }

        // compare to the third grandchild
        int grandChild3Index = leftChildIndex(rightChildIndex);
        if (grandChild3Index >= heap.size()) {
            return maxIndex;
        }
        if (heap.get(grandChild3Index).compareTo(heap.get(maxIndex)) > 0) {
            maxIndex = grandChild3Index;
        }

        // compare to the fourth grandchild
        int grandChild4Index = rightChildIndex(rightChildIndex);
        if (grandChild4Index >= heap.size()) {
            return maxIndex;
        }
        if (heap.get(grandChild4Index).compareTo(heap.get(maxIndex)) > 0) {
            maxIndex = grandChild4Index;
        }

        return maxIndex;
    }


    void swap(int index1, int index2) {
        E temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);

        heap.get(index1).setIndex(index1);
        heap.get(index2).setIndex(index2);
    }

    int parentIndex(int nodeIndex) {
        return (nodeIndex - 1) / 2;
    }

    boolean hasParent(int nodeIndex) {
        return nodeIndex > 0;
    }

    boolean onMinLevel(int nodeIndex) {
        int level = (int) (Math.log(nodeIndex + 1) / Math.log(2));
        return level % 2 == 0;
    }

    int leftChildIndex(int nodeIndex) {
        return 2 * nodeIndex + 1;
    }

    int rightChildIndex(int nodeIndex) {
        return 2 * nodeIndex + 2;
    }

    boolean isChild(int nodeIndexParent, int nodeIndexDescendant) {
        return (nodeIndexDescendant == leftChildIndex(nodeIndexParent) ||
                nodeIndexDescendant == rightChildIndex(nodeIndexParent));
    }

}

interface IndexedComparable<T> extends Comparable<T> {
    public void setIndex(int index);
}
