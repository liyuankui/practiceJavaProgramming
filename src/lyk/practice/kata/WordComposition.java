package lyk.practice.kata;

import lyk.practice.datastructure.LinkedList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/7/12
 * Time: 4:46 PM
 * The WordComposition class is intended to fulfil some duties.
 */
public class WordComposition {
    public static int length = 6;
    public static LinkedList<String> words = new LinkedList<String>();
    public static TrieNode wordRoot = new TrieNode();


    public static void initialize() {
        wordRoot.setRoot(wordRoot);
        try {
            BufferedReader reader = new BufferedReader(new FileReader("wordlist.txt"));
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                if (line.length() <= 6) {
                    line = line.toLowerCase().replaceAll("[^a-z]", "");
                    if (line.length() == 6) words.append(line);
                    wordRoot.insert(line);
                }
                count++;
            }

            System.out.println("\n-- Total " + count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void scan() {
        Object[] ws = words.values();
        for (Object w : ws) {
            int cut = wordRoot.scanWord((String) w);
            if (cut != -1) {
                System.out.println(w + "=" + ((String) w).substring(1, cut + 1) + "+" + ((String) w).substring(cut + 1, ((String) w).length()));
            }

        }
    }

    public static void main(String[] args) {
        initialize();
        scan();
    }
}

class TrieNode {
    private TrieNode[] next;
    private boolean[] endhere;
    private static TrieNode root;

    public void setRoot(TrieNode r) {
        root = r;
    }

    public TrieNode() {
        next = new TrieNode[26];
        endhere = new boolean[26];
    }

    public TrieNode(TrieNode r) {
        this();
        setRoot(r);
    }

    public void insert(String str) {
        if (str == null) throw new IllegalArgumentException("null string to insert");
        if (str.length() == 0) throw new IllegalArgumentException("empty string to insert");
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        insert(str.toCharArray(), 0);
    }

    public int scanWord(String str) {
        return scanWord(str.toCharArray(), 0);
    }

    public int scanWord(char[] chars, int index) {
        int first = chars[index] - 'a';
        if (index == 5) return -1;

        if (endhere[first]) {
            if (root.has(chars, index + 1))
                return index;
        }

        if (next[first] == null) {
            return -1;
        }

        return next[first].scanWord(chars, index + 1);
    }

    public boolean has(String str) {
        if (str == null) throw new IllegalArgumentException("null string to query");
        if (str.length() == 0) throw new IllegalArgumentException("empty string to query");
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        return has(str.toCharArray(), 0);
    }

    public void insert(char[] word, int index) {
        int first = word[index] - 'a';

        if (next[first] == null) {
            next[first] = new TrieNode();
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

