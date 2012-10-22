package lyk.practice;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/14/12
 * Time: 11:39 PM
 * The QuickSelection class is intended to fulfil some duties.
 */
public class QuickSelection {

    public static int select(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return Integer.MIN_VALUE;
        return select(arr, 0, n - 1, k);
    }

    public static int select(int[] arr, int start, int end, int k) {
        if (start == end) return arr[start];
        int pos = partition(arr, start, end);
        if (pos + 1 == k) return arr[k - 1];
        if (pos + 1 < k) return select(arr, pos + 1, end, k);
        if (pos + 1 > k) return select(arr, start, pos, k);
        return -1;
    }

    public static int partition(int[] arr, int start, int end) {
//        Util.DumpArray(arr);
        int index = start;
        int pivot = arr[index];
        swap(arr, index, end);
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                swap(arr, index++, i);
//                Util.DumpArray(arr);
            }

        }
        swap(arr, index, end);
//        Util.DumpArray(arr);
        return index;
    }

    public static void swap(int[] arr, int a, int b) {
        Util.swap(arr, a, b);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, -1, -2};
//        System.out.println(partition(arr,0,6));
        System.out.println(select(arr, 7));
    }
}
