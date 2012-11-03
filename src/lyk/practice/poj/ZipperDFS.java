package lyk.practice.poj;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/24/12
 * Time: 1:15 PM
 * The ZipperDFS class is intended to fulfil some duties.
 */

// http://poj.org/problem?id=2192

import java.util.Scanner;

public class ZipperDFS {
    private static char[] a;
    private static char[] b;
    private static char[] c;

    public static boolean dfs(int x, int y) {
        if (x < 0 && y < 0)
            return true;
        if (x >= 0 && a[x] == c[x + y + 1])
            if (dfs(x - 1, y)) return true;
        if (y >= 0 && b[y] == c[x + y + 1])
            if (dfs(x, y - 1)) return true;

        return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int count = Integer.parseInt(cin.nextLine());
        int i = 1;
        while (i <= count) {
            String data = cin.nextLine();
            String[] strings = data.split(" ");
            a = strings[0].toCharArray();
            b = strings[1].toCharArray();
            c = strings[2].toCharArray();
            String result = dfs(a.length - 1, b.length - 1) ? "yes" : "no";
            System.out.println("Data set " + i + ": " + result);
            i++;
        }
    }
}
