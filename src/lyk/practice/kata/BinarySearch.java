package lyk.practice.kata;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/5/12
 * Time: 2:41 PM
 * The BinarySearch class is intended to fulfil some duties.
 */
public class BinarySearch {

    public static int chop(int key, int[] array) {
        if (array == null) return -1;
        int n = array.length;
        if (n == 0) return -1;
        int start = 0, end = n - 1;
        while (start <= end) {
            int pivot = (start + end) / 2;
            if (array[pivot] == key) return pivot;
            if (key < array[pivot]) {
                end = pivot - 1;
            } else {
                start = pivot + 1;
            }
        }
        return -1;
    }

    public static int chop2(int key, int[] array) {
        if (array == null) return -1;
        int n = array.length;
        if (n == 0) return -1;
        return halfSearch(key, array, 0, n - 1);
    }

    private static int halfSearch(int key, int[] array, int start, int end) {
        if (start > end) return -1;
        int pivot = (end + start) / 2;
        if (array[pivot] == key)
            return pivot;
        if (key < array[pivot]) {
            return halfSearch(key, array, start, pivot - 1);
        } else {
            return halfSearch(key, array, pivot + 1, end);
        }
    }

}
