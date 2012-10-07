package lyk.practice.kata;

import com.sun.org.apache.xml.internal.utils.Trie;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/6/12
 * Time: 4:06 PM
 * The Anagrams class is intended to fulfil some duties.
 */
public class Anagrams {

    private static int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101, 103, 107, 109};

    public static void insertWordPrimeHashing(String str) {
        char[] s = str.toCharArray();
        double hash = 0;
        for (char c : s) {
            System.out.println(prime[c - 'a']);
            hash *= prime[c - 'a'];
        }
        hash *= prime[s.length];
        System.out.println(hash);
    }

    private static Trie trie = new Trie();

    public static void insertWord(String str) {
        char[] s = str.toCharArray();
        Arrays.sort(s);
        trie.put(new String(s), str);
    }

    public static void main(String[] args) {

        insertWord("listen");
        insertWord("enlist");
        System.out.println(trie.get("eilnst"));
        System.out.println(trie.get("eilnst"));
    }
}
