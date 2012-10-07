package lyk.practice.datastructure.test;

import lyk.practice.datastructure.TrieTree;

import static org.testng.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/7/12
 * Time: 9:33 AM
 * The TrieTreeTest class is intended to fulfil some duties.
 */
public class TrieTreeTest {

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();

        trieTree.insert("abccc");
        assertEquals(trieTree.has("abccc"), true);
        assertEquals(trieTree.has("abcc"), false);
        assertEquals(trieTree.has("bccc"), false);

        trieTree.insert("acbcc");
        assertEquals(trieTree.has("acbcc"), true);
        assertEquals(trieTree.has("abccc"), true);
        assertEquals(trieTree.has("abcc"), false);
        assertEquals(trieTree.has("bccc"), false);

        trieTree.insert("fa.fa.fa.");

    }
}
