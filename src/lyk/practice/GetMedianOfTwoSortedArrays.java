package lyk.practice;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/23/12
 * Time: 12:07 AM
 * The GetMedianOfTwoSortedArrays class is intended to fulfil some duties.
 */
public class GetMedianOfTwoSortedArrays {

    public static int getMedian(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        System.out.println("b length: " + n);
        int l = m + n;

        return select(a, 0, m - 1, b, 0, n - 1, (m + n) / 2);
    }

    public static int select(int[] a, int sa, int ea, int[] b, int sb, int eb, int k) {
        System.out.println(sa + ":" + ea + "," + sb + ":" + eb + ". ?" + k);
        if (ea < sa) {
            return select(b, sb, eb, k);
        }
        if (eb < sb) {
            return select(a, sa, ea, k);
        }
        int na = ea - sa + 1;
        int nb = eb - sb + 1;
        int t = na + nb;
        int pa = (ea + sa) / 2;
        int pb = (eb + sb) / 2;

        if (a[pa] > b[pb]) {
            if (a[pa - 1] < b[pb + 1]) {
                return select(b, k - pa);
            }
            return select(a, sa, pa, b, pb, eb, k - pb);
        } else {
            if (a[pa + 1] > b[pb - 1]) {
                return select(a, k - pb);
            }
            return select(a, pa, ea, b, sb, pb, k - pa);
        }
    }

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
        int[] a = new int[]{2, 3, 9, 7, 6, 4, 6, 8};
        int[] b = new int[]{36, 4, 6, 8};
        int[] c = new int[]{};
        int[] d = new int[]{1};

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        Util.DumpArray(a);
        Util.DumpArray(b);
        Util.DumpArray(c);

        System.out.println("length of c " + c.length);

        //System.out.println(getMedian(a,b));
        System.out.println(getMedian(a, c));
    }
}
