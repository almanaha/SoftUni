package DataTypes.Exercises;
import java.math.BigDecimal;
import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        int y = Integer.parseInt(sc.nextLine());
        int targets = 0;
        double half = n * 1.0 / 2;

        while (n >= m){
            targets++;
            n -= m;
            if (n == half && y != 0){
                n /= y;
            }
        }
        System.out.println(n);
        System.out.println(targets);

    }
}
