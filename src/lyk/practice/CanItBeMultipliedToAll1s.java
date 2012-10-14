package lyk.practice;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/12/12
 * Time: 11:57 PM
 * The CanItBeMultipliedToAll1s class is intended to fulfil some duties.
 */
public class CanItBeMultipliedToAll1s {


    public static void isIt(int n) {
        int count = (int) Math.log(n);
        int target = Integer.parseInt(Util.stringWithNC(10, '1'), 10);
        System.out.println(target);

        int k = 0;
        int mask = 10;
        while (true) {
            int a = n % mask;
            int b = target % mask;
            int x = 1;
            for (int i = 0; i <= 9; i++) {
                x = k + i * mask / 10;
                if (a * x % mask == b) {
                    k = x;
                }
            }
            count--;
            if (a * k == b && count < 0)
                break;
            if (a * k % mask != b)
                break;
            mask *= 10;
        }
        System.out.println(k);

    }

    public static void main(String[] args) {
        isIt(37037037);

    }
}
