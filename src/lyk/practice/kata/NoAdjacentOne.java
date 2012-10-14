package lyk.practice.kata;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/9/12
 * Time: 11:34 AM
 * The NoAdjacentOne class is intended to fulfil some duties.
 */

/*
At my son's karate school, they spend most of their time doing various exercises,
with the occasional round of sparring thrown in. But every now and then the teacher
finds a way to break the routine by injecting some kind of game or surprise into the
mix. This kata is one of those. It's nothing serious, and unlikely to have practical
benefits (unless you're working in some fairly specialized areas).
Think of binary numbers: sequences of 0's and 1's. How many n-digit binary numbers
are there that don't have two adjacent 1 bits? For example, for three-digit numbers,
five of the possible eight combinations meet the criteria: 000, 001, 010, 011, 100, 101, 110, 111.
What is the number for sequences of length 4, 5, 10, n?

Having worked out the pattern, there's a second part to the question: can you prove
why that relationship exists?
 */


//fibnacci
// http://www.codekata.com/2007/01/code_kata_fifte.html
public class NoAdjacentOne {
    public static int max = 255;

    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i <= max; i++) {
            String x = Integer.toBinaryString(i);
            if (x.contains("1"))
                continue;
            count++;
        }
        System.out.println(count);
    }
}
