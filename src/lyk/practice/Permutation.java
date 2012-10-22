package lyk.practice;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/16/12
 * Time: 2:31 PM
 * The Permutation class is intended to fulfil some duties.
 */
public class Permutation {

    // giving permutation in a dictionary ascending order, allowing duplicating elements
    public static void permutationDictionarySequence(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        Util.DumpArray(arr);
        while (pds(arr)) {
            Util.DumpArray(arr);
        }
    }

    public static boolean pds(int[] arr) {
        int n = arr.length;
        int end = n - 1;
        int left = -1;
        for (int i = 0; i <= end - 1; i++) {
            if (arr[i] < arr[i + 1])
                left = i;
        }
        if (left == -1)
            return false;
        else {
            int right = -1;
            for (int i = left; i < n; i++) {
                if (arr[left] < arr[i]) {
                    right = i;
                }
            }
            Util.swap(arr, left, right);
            Util.reverse(arr, left + 1, n - 1);
            return true;
        }


    }

    public static void permutation(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        perm(arr, 0, n - 1);
    }

    public static void perm(int[] arr, int k, int n) {
        if (k == n) {
            Util.DumpArray(arr);
            return;
        }
        for (int i = k; i <= n; i++) {
            Util.swap(arr, i, k);
            perm(arr, k + 1, n);
            Util.swap(arr, i, k);
        }
    }

    public static void main(String[] args) {
        permutationDictionarySequence(4);
    }
}
