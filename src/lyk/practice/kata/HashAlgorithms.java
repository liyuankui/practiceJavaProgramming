package lyk.practice.kata;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/5/12
 * Time: 9:39 PM
 * The HashAlgorithms class is intended to fulfil some duties.
 */
public class HashAlgorithms {

    static int M_MASK = 0x8765fed1;

    public static int accumulativeHash(String key, int prime) {
        int n = key.length();
        int hash = n;
        for (int i = 0; i < n; i++)
            hash += key.charAt(i);
        return (hash % prime);
    }

    public static int rotatingHash(String key, int prime) {
        int n = key.length();
        int hash = n;
        for (int i = 0; i < n; i++)
            hash = (hash << 4) ^ (hash >> 28) ^ key.charAt(i);
        return hash % prime;
    }

    public static int oneByOneHash(String key) {
        int n = key.length();
        int hash = 0;
        for (int i = 0; i < n; i++) {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
        return hash;
    }

    public static int berstein(String key) {
        int n = key.length();
        int hash = 0;
        for (int i = 0; i < n; i++)
            hash = 33 * hash + key.charAt(i);
        return hash;
    }

    public static int universal(String key, int mask, int[] tab) {
        int n = key.length();
        int hash = n;
        int tablen = tab.length;
        for (int i = 0; i < (tablen << 3); i += 8) {
            char k = key.charAt(i >> 3);
            if ((k & 0x01) == 0) hash ^= tab[i + 0];
            if ((k & 0x02) == 0) hash ^= tab[i + 1];
            if ((k & 0x04) == 0) hash ^= tab[i + 2];
            if ((k & 0x08) == 0) hash ^= tab[i + 3];
            if ((k & 0x10) == 0) hash ^= tab[i + 4];
            if ((k & 0x20) == 0) hash ^= tab[i + 5];
            if ((k & 0x40) == 0) hash ^= tab[i + 6];
            if ((k & 0x80) == 0) hash ^= tab[i + 7];
        }
        return (hash & mask);
    }

    public static int zobrist(String key, int mask, int[][] tab) {
        int n = key.length();
        int hash = n;
        for (int i = 0; i < n; i++)
            hash ^= tab[i][key.charAt(i)];
        return (hash & mask);
    }

    public static int FNVHash(String key) {
        int hash = (int) 2166136261L;
        int n = key.length();
        for (int i = 0; i < n; i++)
            hash = (hash * 16777619) ^ key.charAt(i);
        return hash;
    }

    public static int FNVHash1(String key) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        int n = key.length();
        for (int i = 0; i < n; i++)
            hash = (hash ^ key.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return hash;
    }

    public static int RSHash(String key) {
        int b = 378551;
        int a = 63689;
        int hash = 0;
        int n = key.length();


        for (int i = 0; i < n; i++) {
            hash = hash * a + key.charAt(i);
            a = a * b;
        }

        return (hash & 0x7FFFFFFF);
    }

    public static int JSHash(String key) {
        int hash = 1315423911;
        int n = key.length();
        for (int i = 0; i < n; i++) {
            hash ^= ((hash << 5) + key.charAt(i) + (hash >> 2));
        }
        return (hash & 0x7FFFFFFF);
    }

    public static int PJWHash(String key) {
        int BitsInUnsignedInt = 32;
        int ThreeQuarters = (BitsInUnsignedInt * 3) / 4;
        int OneEighth = BitsInUnsignedInt / 8;
        int HighBits = 0xFFFFFFFF << (BitsInUnsignedInt - OneEighth);
        int hash = 0;
        int test = 0;
        int n = key.length();

        for (int i = 0; i < n; i++) {
            hash = (hash << OneEighth) + key.charAt(i);

            if ((test = hash & HighBits) != 0) {
                hash = ((hash ^ (test >> ThreeQuarters)) & (~HighBits));
            }
        }

        return (hash & 0x7FFFFFFF);
    }

    public static int ELFHash(String key) {
        int hash = 0;
        int x = 0;
        int n = key.length();

        for (int i = 0; i < n; i++) {
            hash = (hash << 4) + key.charAt(i);
            if ((x = (int) (hash & 0xF0000000L)) != 0) {
                hash ^= (x >> 24);
                hash &= ~x;
            }
        }

        return (hash & 0x7FFFFFFF);
    }

    public static int BKDRHash(String key) {
        int seed = 131; // 31 131 1313 13131 131313 etc..
        int hash = 0;

        int n = key.length();
        for (int i = 0; i < n; i++) {
            hash = (hash * seed) + key.charAt(i);
        }

        return (hash & 0x7FFFFFFF);
    }

    public static int SDBMHash(String key) {
        int hash = 0;
        int n = key.length();

        for (int i = 0; i < n; i++) {
            hash = key.charAt(i) + (hash << 6) + (hash << 16) - hash;
        }

        return (hash & 0x7FFFFFFF);
    }

    public static int DJBHash(String key) {
        int hash = 5381;

        int n = key.length();
        for (int i = 0; i < n; i++) {
            hash = ((hash << 5) + hash) + key.charAt(i);
        }

        return (hash & 0x7FFFFFFF);
    }

    public static int DEKHash(String key) {
        int hash = key.length();
        int n = hash;

        for (int i = 0; i < n; i++) {
            hash = ((hash << 5) ^ (hash >> 27)) ^ key.charAt(i);
        }

        return (hash & 0x7FFFFFFF);
    }

    public static int APHash(String key) {
        int hash = 0;
        int n = key.length();

        for (int i = 0; i < n; i++) {
            hash ^= ((i & 1) == 0) ? ((hash << 7) ^ key.charAt(i) ^ (hash >> 3)) :
                    (~((hash << 11) ^ key.charAt(i) ^ (hash >> 5)));
        }

        return hash;
    }

    public static int java(String key) {
        int h = 0;
        int off = 0;
        int n = key.length();
        for (int i = 0; i < n; i++) {
            h = 31 * h + key.charAt(off++);
        }
        return h;
    }

    /**
     * 混合hash算法，输出64位的值
     */
    public static long mixHash(String key) {
        long hash = key.hashCode();
        hash <<= 32;
        hash |= FNVHash1(key);
        return hash;
    }
}
