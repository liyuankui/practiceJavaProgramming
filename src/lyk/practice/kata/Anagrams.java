package lyk.practice.kata;


import lyk.practice.datastructure.LinkedList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    // attempted to using Gödel encoding to hash the words, turned out the number is too big to represent
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


    private static AnagramsTrieNode trie = new AnagramsTrieNode();
    private static LinkedList<LinkedList<String>> wordsets = new LinkedList<LinkedList<String>>();

    public static void insertWord(String str) {
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        char[] s = str.toCharArray();
        Arrays.sort(s);
        LinkedList<String> newWordlist = trie.appendWord(s, 0, str);
        if (newWordlist != null)
            wordsets.append(newWordlist);
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("wordlist.txt"));
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                insertWord(line);
                count++;
            }

            System.out.println("\n-- Total " + count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        LinkedList<String> wlist = wordsets.getValueAt(0);
        Object[] words = wlist.values();
        for (Object w : words) {
            System.out.print(w + " ");
        }


        Object[] wordlists = wordsets.values();
        int anagramsCount = 0;
        for (Object list : wordlists) {
            LinkedList<String> list2 = (LinkedList<String>) list;
            int size = list2.size();
            if (size > 1) {
                anagramsCount++;
                words = list2.values();
                for (Object w : words) {
                    System.out.print(w + " ");
                }
                System.out.println();
            }
        }
        System.out.println("Set Number: " + anagramsCount);
    }
}

class AnagramsTrieNode {
    private AnagramsTrieNode[] next;
    private LinkedList[] wordlist;
    private boolean[] endhere;

    public AnagramsTrieNode() {
        next = new AnagramsTrieNode[26];
        endhere = new boolean[26];
        wordlist = new LinkedList[26];
    }

    public LinkedList<String> appendWord(char[] word, int index, String str) {
//        System.out.println(word+"-"+index+"-`"+str);
        int first = word[index] - 'a';
        if (index + 1 == word.length) {
            endhere[first] = true;
            if (wordlist[first] == null) {
                wordlist[first] = new LinkedList<String>();
                wordlist[first].append(str);
                //only return the just newed list;
                return wordlist[first];
            } else {
                wordlist[first].append(str);
                //only return the just newed list;
                // or else return null
                return null;
            }
        } else {
            if (next[first] == null) {
                next[first] = new AnagramsTrieNode();
            }
            return next[first].appendWord(word, index + 1, str);
        }
    }

    public void insert(String str) {
        if (str == null) throw new IllegalArgumentException("null string to insert");
        if (str.length() == 0) throw new IllegalArgumentException("empty string to insert");
        str = str.replaceAll("[^a-z]", "");
        insert(str.toLowerCase().toCharArray(), 0);
    }

    public boolean has(String str) {
        if (str == null) throw new IllegalArgumentException("null string to query");
        if (str.length() == 0) throw new IllegalArgumentException("empty string to query");
        str = str.replaceAll("[^a-z]", "");
        return has(str.toLowerCase().toCharArray(), 0);
    }

    public void insert(char[] word, int index) {
        int first = word[index] - 'a';

        if (next[first] == null) {
            next[first] = new AnagramsTrieNode();
        }

        if (index + 1 == word.length) {
            endhere[first] = true;

        } else {
            next[first].insert(word, index + 1);
        }
    }

    public boolean has(char[] word, int index) {
        int first = word[index] - 'a';
        if (next[first] == null) {
            return false;
        }
        if (index + 1 == word.length) {
            return endhere[first];
        } else {
            return next[first].has(word, index + 1);
        }
    }

}

