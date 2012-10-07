package lyk.practice.datastructure;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/6/12
 * Time: 4:57 PM
 * The TrieTree class is intended to fulfil some duties.
 */
public class TrieTree {
    private TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    public void insert(String str) {
        root.insert(str);
    }

    public boolean has(String str) {
        return root.has(str);
    }
}

class TrieNode {
    private TrieNode[] next;
    private boolean[] endhere;

    public TrieNode() {
        next = new TrieNode[26];
        endhere = new boolean[26];
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