package ObjectsАndClasses;

import java.math.BigInteger;
import java.util.*;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger x = sc.nextBigInteger();
        BigInteger y = sc.nextBigInteger();
        System.out.println(x.add(y));
    }
}
