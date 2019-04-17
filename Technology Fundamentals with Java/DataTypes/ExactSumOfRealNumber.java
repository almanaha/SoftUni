package DataTypes;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumOfRealNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        BigDecimal sum = new BigDecimal(0);
        for (int i = 0; i < n; i++) {
            BigDecimal x = sc.nextBigDecimal();
            sum = sum.add(x);
        }
        System.out.println(sum);
    }
}
