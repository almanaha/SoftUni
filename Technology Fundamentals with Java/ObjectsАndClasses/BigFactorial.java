package ObjectsАndClasses;

import java.math.BigInteger;
import java.util.*;

public class BigFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = Integer.parseInt(sc.nextLine());
        BigInteger y = BigInteger.ONE;

        for (int i = 1; i <= x; i++) {
            y = y.multiply(BigInteger.valueOf(i));
        }
        System.out.println(y);
    }
}

