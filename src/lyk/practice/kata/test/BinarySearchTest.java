package lyk.practice.kata.test;

import org.testng.annotations.Test;

import static lyk.practice.kata.BinarySearch.chop;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/5/12
 * Time: 3:21 PM
 * The BinarySearchTest class is intended to fulfil some duties.
 */
public class BinarySearchTest {
    @Test
    public static void testChop() throws Exception {

        assertTrue(-1 == chop(3, new int[]{}));

        int[] test1 = new int[]{1};
        assertTrue(-1 == chop(3, test1));
        assertTrue(0 == chop(1, test1));

        int[] test2 = new int[]{1, 3, 5};
        assertTrue(0 == chop(1, test2));
        assertTrue(1 == chop(3, test2));
        assertTrue(2 == chop(5, test2));
        assertTrue(-1 == chop(0, test2));
        assertTrue(-1 == chop(2, test2));
        assertTrue(-1 == chop(4, test2));
        assertTrue(-1 == chop(6, test2));

        int[] test3 = new int[]{1, 3, 5, 7};
        assertTrue(0 == chop(1, test3));
        assertTrue(1 == chop(3, test3));
        assertTrue(2 == chop(5, test3));
        assertTrue(3 == chop(7, test3));
        assertTrue(-1 == chop(0, test3));
        assertTrue(-1 == chop(2, test3));
        assertTrue(-1 == chop(4, test3));
        assertTrue(-1 == chop(6, test3));
        assertTrue(-1 == chop(8, test3));
    }

    public static void main(String[] args) throws Exception {
        testChop();

    }
}
