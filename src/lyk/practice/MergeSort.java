package lyk.practice;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 9/29/12
 * Time: 2:27 PM
 * The MergeSort class is intended to fulfil some duties.
 */
public class MergeSort {

    public static int[] sort(int[] input) {
        int length = input.length;
        if (length == 0 || length == 1) return input;

        int mLength = length / 2;
        int[] m = new int[mLength];
        System.arraycopy(input, 0, m, 0, mLength);

        int nLength = length - mLength;
        int[] n = new int[nLength];
        System.arraycopy(input, mLength, n, 0, nLength);

        return merge(sort(m), sort(n));
    }

    static int[] merge(int[] m, int[] n) {
        if (m.length == 0) return n;
        if (n.length == 0) return m;

        int[] r = new int[m.length + n.length];
        for (int i = 0, im = 0, in = 0; i < r.length; i++) {
            if (im >= m.length) {
                r[i] = n[in++];
                continue;
            }
            if (in >= n.length) {
                r[i] = m[im++];
                continue;
            }
            r[i] = m[im] < n[in] ? m[im++] : n[in++];
        }
        return r;
    }

    public static int[] fasterSort(int[] input) {
        int length = input.length;
        if (length == 0 || length == 1) return input;

        int mLength = length / 2;
        int[] m = new int[mLength];
        System.arraycopy(input, 0, m, 0, mLength);

        int nLength = length - mLength;
        int[] n = new int[nLength];
        System.arraycopy(input, mLength, n, 0, nLength);

        inplaceMerge(input, 0, fasterSort(m), 0, fasterSort(n), 0);
        return input;
    }

    static void inplaceMerge(int[] src, int srcpos, int[] m, int mpos, int[] n, int npos) {
        while (true) {
            if (mpos >= m.length) {
                while (npos < n.length)
                    src[srcpos++] = n[npos++];
                return;
            }
            if (npos >= n.length) {
                while (mpos < m.length)
                    src[srcpos++] = m[mpos++];
                return;
            }
            if (m[mpos] < n[npos]) {
                src[srcpos++] = m[mpos++];
            } else {
                src[srcpos++] = n[npos++];
            }
        }
        //inplaceMerge(src,srcpos,m,mpos,n,npos);
        // optimize tail recursion to loop, making the faster inplace merge really faster
    }

    public static void main(String[] args) {
        int length = 10000;
        int[] a = new int[length];
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        for (int i = 0; i < length; i++) {
            a[i] = random.nextInt();
        }

        long start = System.currentTimeMillis();

        int[] k = sort(a);

        for (int i = 0; i < 5; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print(k[i] + " ");
        }
        System.out.println();
        System.out.println("\nTime Cost: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();

        fasterSort(a);
        // inplace is not faster at all, since it cause more invocations
        for (int i = 0; i < 5; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println("\nTime Cost: " + (System.currentTimeMillis() - start));

    }
}
